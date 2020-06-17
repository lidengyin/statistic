package cn.hctech2006.statistic.service.impl;

import cn.hctech2006.statistic.bean.Student;
import cn.hctech2006.statistic.bean.Subject;
import cn.hctech2006.statistic.bean.Subresult;
import cn.hctech2006.statistic.bean.Subsmall;
import cn.hctech2006.statistic.common.Const;
import cn.hctech2006.statistic.common.ServerResponse;
import cn.hctech2006.statistic.mapper.StudentMapper;
import cn.hctech2006.statistic.mapper.SubjectMapper;
import cn.hctech2006.statistic.mapper.SubresultMapper;
import cn.hctech2006.statistic.mapper.SubsmallMapper;
import cn.hctech2006.statistic.service.SubjectService;
import cn.hctech2006.statistic.vo.*;
import com.google.common.collect.Lists;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.rmi.ServerError;
import java.sql.ClientInfoStatus;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class SubjectServiceImpl implements SubjectService {
    @Autowired
    private SubjectMapper subjectMapper;
    @Autowired
    private SubsmallMapper subsmallMapper;
    @Autowired
    private SubresultMapper subresultMapper;
    @Autowired
    private StudentMapper studentMapper;
    @Override
    public ServerResponse insertSubject(Subject subject) {
        subject.setSubId(UUID.randomUUID().toString());
        int count =  subjectMapper.insert(subject);
        if (count > 0){
            return ServerResponse.createBySuccess("注册成功，学科分类ID为："+subject.getSubId());
        }
        return ServerResponse.createByError("注册失败");
    }

    @Override
    public ServerResponse insertSubsmall(Subsmall subsmall) {
        subsmall.setSmId(UUID.randomUUID().toString());
        int count = subsmallMapper.insert(subsmall);
        if (count > 0){
            return ServerResponse.createBySuccess("注册成功,测试ID："+subsmall.getSmId());
        }
        return ServerResponse.createByError("注册失败");
    }

    @Override
    public ServerResponse insertSubresult(Subresult subresult) {
        int hasAlready = subresultMapper.checkByStuIdAndSmId(subresult.getStuId(), subresult.getSmId());
        int count = 0;
        if (hasAlready > 0){
            count = subresultMapper.updateGradeByStuIdAndSmId(subresult.getStuId(), subresult.getSmId(),subresult.getGrade());
        }else{
            count = subresultMapper.insert(subresult);
        }

        if (count > 0){
            return ServerResponse.createBySuccess("注册成功");
        }
        return ServerResponse.createByError("注册失败");
    }

    @Override
    public List<SubjectVo> getSubjectVoList(String stuId) {
        return assembleSubjectVoList(stuId);
    }

    @Override
    public ServerResponse getAllSubJectVo() {
        return ServerResponse.createBySuccess(assembleSubjectAndSmallVo());
    }

    public ServerResponse getAllSubScatVo(){
        return ServerResponse.createBySuccess(assembleSubjectAndScatVo());
    }

    private List<SubjectAndScatVo> assembleSubjectAndScatVo(){
        List<Subject> subjectList = subjectMapper.selectAll();
        List<SubjectAndScatVo> subjectAndScatVoList = Lists.newArrayList();
        for (Subject subject : subjectList){
            SubjectAndScatVo subjectAndScatVo = new SubjectAndScatVo();
            subjectAndScatVo.setName(subject.getName());
            subjectAndScatVo.setOrd(subject.getOrd());
            subjectAndScatVo.setSubId(subject.getSubId());
            List<Subsmall> subsmallList = subsmallMapper.selectBySubId(subject.getSubId());
            subjectAndScatVo.setSubScatVoList(assembleSubScatVo(subsmallList));
            subjectAndScatVoList.add(subjectAndScatVo);
        }
        return subjectAndScatVoList;
    }
    private List<SubjectAndSmallVo> assembleSubjectAndSmallVo(){
        List<Subject> subjectList = subjectMapper.selectAll();
        List<SubjectAndSmallVo> subjectAndSmallVoList = Lists.newArrayList();
        for(Subject subject: subjectList){
            SubjectAndSmallVo subjectAndSmallVo = new SubjectAndSmallVo();
            subjectAndSmallVo.setName(subject.getName());
            subjectAndSmallVo.setOrd(subject.getOrd());
            subjectAndSmallVo.setSubId(subject.getSubId());
            List<Subsmall> subsmallList = subsmallMapper.selectBySubId(subject.getSubId());
            subjectAndSmallVo.setSubsmallVoList(assembleSubsmallVo(subsmallList));
            subjectAndSmallVoList.add(subjectAndSmallVo);
            }
        return subjectAndSmallVoList;
    }
    private List<SubScatVo> assembleSubScatVo(List<Subsmall> subsmallList){

        List<SubScatVo> subScatVoList  =Lists.newArrayList();
        for (Subsmall subsmall : subsmallList){
            SubScatVo subScatVo = new SubScatVo();
            subScatVo.setName(subsmall.getName());
            subScatVo.setSmId(subsmall.getSmId());
            subScatVo.setSubId(subsmall.getSubId());
            List<Subresult> gradeStrList = subresultMapper.selectGradeBySmId(subsmall.getSmId());
            subScatVo.setGradeList(assembleGradeList(gradeStrList));

            subScatVo.setStuNum(subScatVo.getGradeList().length+"");
            int allGrade = 0;
            for (int grade: subScatVo.getGradeList()){
                allGrade += grade;
            }
            subScatVo.setAllGrade(allGrade);
            subScatVoList.add(subScatVo);
        }
        return subScatVoList;
    }
    private Integer[] assembleGradeList(List<Subresult> gradeStrList){
        List<Integer> gradeIntList = new ArrayList<>();

        for (Subresult subresult : gradeStrList){
            Student student = studentMapper.selectByStuId(subresult.getStuId());
            if (student == null){
                continue;
            }
            if (Const.SubGrade.VeryHigh.getGradeStr().equals(subresult.getGrade())){
                gradeIntList.add(5);
            }else if (Const.SubGrade.High.getGradeStr().equals(subresult.getGrade())){
                gradeIntList.add(4);
            }else if (Const.SubGrade.Normal.getGradeStr().equals(subresult.getGrade())){
                gradeIntList.add(3);
            }else if (Const.SubGrade.Low.getGradeStr().equals(subresult.getGrade())){
                gradeIntList.add(2);
            }else if (Const.SubGrade.VeryLow.getGradeStr().equals(subresult.getGrade())){
                gradeIntList.add(1);
            }
        }
        Integer[] gradeList = new Integer[gradeIntList.size()];
        gradeIntList.toArray(gradeList);
        return gradeList;
    }
    private List<SubSmallVo> assembleSubsmallVo(List<Subsmall> subsmallList){
        List<SubSmallVo> subSmallVoList  =Lists.newArrayList();
        List<String> grade = Lists.newArrayList();
        grade.add("非常高");
        grade.add("较高");
        grade.add("一般");
        grade.add("较低");
        grade.add("非常低");
        for (Subsmall subsmall: subsmallList){
            SubSmallVo subSmallVo = new SubSmallVo();
            subSmallVo.setName(subsmall.getName());
            subSmallVo.setGrade(grade);
            subSmallVo.setSmId(subsmall.getSmId());
            subSmallVo.setSubId(subsmall.getSubId());
            subSmallVoList.add(subSmallVo);
        }
        return subSmallVoList;
    }
    private List<SubjectVo> assembleSubjectVoList(String stuId){
        List<Subject> subjectList = subjectMapper.selectAll();
        List<SubjectVo> subjectVoList = Lists.newArrayList();
        for(Subject subject : subjectList){
            SubjectVo subjectVo = new SubjectVo();
            List<SubresultVo> subresultVoList = assembleSubresultVo(stuId, subject.getSubId());
            subjectVo.setSubresultVoList(subresultVoList);
            subjectVo.setName(subject.getName());
            subjectVo.setOrd(subject.getOrd());
            subjectVo.setSubId(subject.getSubId());
            subjectVoList.add(subjectVo);
        }
        return subjectVoList;
    }
    private List<SubresultVo> assembleSubresultVo(String stuId, String subId){
        List<Subresult> subresultList = subresultMapper.selectByStuIdSubId(stuId,subId);

        List<SubresultVo> subresultVoList = Lists.newArrayList();
        for(Subresult subresult : subresultList){
            SubresultVo subresultVo = new SubresultVo();
            Subsmall subsmall = subsmallMapper.selectBySmId(subresult.getSmId());
            subresultVo.setGrade(subresult.getGrade());
            subresultVo.setSmId(subsmall.getSmId());
            subresultVo.setSubId(subresult.getSubId());
            subresultVo.setSmName(subsmall.getName());
            subresultVoList.add(subresultVo);
        }
        return subresultVoList;
    }

}
