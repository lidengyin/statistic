package cn.hctech2006.statistic.service.impl;

import cn.hctech2006.statistic.bean.*;
import cn.hctech2006.statistic.bean.Class;
import cn.hctech2006.statistic.common.ServerResponse;
import cn.hctech2006.statistic.mapper.*;
import cn.hctech2006.statistic.service.EvaluateService;
import cn.hctech2006.statistic.service.StudentService;
import cn.hctech2006.statistic.service.SubjectService;
import cn.hctech2006.statistic.service.SuggestService;
import cn.hctech2006.statistic.vo.*;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentMapper studentMapper;
    @Autowired
    private EvaresultMapper evaresultMapper;
    @Autowired
    private SubresultMapper subresultMapper;
    @Autowired
    private EvaluateService evaluateService;
    @Autowired
    private SubjectService subjectService;
    @Autowired
    private SuggestService suggestService;
    @Autowired
    private CategoryMapper categoryMapper;
    @Autowired
    private EmployMapper employMapper;
    @Autowired
    private IndustryMapper industryMapper;
    @Autowired
    private ClassMapper classMapper;
    @Override
    public ServerResponse insertStudent(Student student) {
        Student student1 = studentMapper.selectByStuId(student.getStuId());
        if (student1 != null && student1.getStatus()==1){
            return ServerResponse.createByError("已经填写完毕，无法重复填写");
        }else if (student1 != null && student1.getStatus() == 0){
            int count = studentMapper.updateByStuId(student);
            return ServerResponse.createBySuccess("已经填写，但是没有填写完毕,个人信息部分已经修改");
        }else{

        }
        //判断注册是否成功
        int count = studentMapper.insert(student);
        if (count > 0){
            return ServerResponse.createBySuccess("注册成功,学号为："+student.getStuId()+"存储编号为："+student.getId());

        }
        return ServerResponse.createByError("注册失败");
    }

    @Override
    public ServerResponse getDetail(String stuId) {
        int hasAlready = studentMapper.checkByStuId(stuId);
        if (hasAlready <= 0){
            return ServerResponse.createByError("该用户不存在或者填写不完整需要重新填写");
        }
        StudentVo studentVo = assembleStudent(stuId);

        return ServerResponse.createBySuccess(studentVo);
    }

    @Override
    public ServerResponse selectStudent(String classId, String empId, String cateId, String induId) {

        List<Student> studentList = studentMapper.selectStudent(classId, empId, cateId, induId);
        return ServerResponse.createBySuccess(assembleStudentOnlyVoList(studentList));

    }
    private List<StudentOnlyVo> assembleStudentOnlyVoList(List<Student> studentList){
        List<StudentOnlyVo> studentOnlyVoList =Lists.newArrayList();
        for (Student student : studentList){
            StudentOnlyVo studentOnlyVo = new StudentOnlyVo();
            studentOnlyVo.setAddress(student.getAddress());
            Category category = categoryMapper.selectByCateId(student.getCateId());
            Class cla = classMapper.selectByClassId(student.getClassId());
            Employ employ = employMapper.selectByEmpId(student.getEmpId());
            Industry industry = industryMapper.selectByInduId(student.getInduId());
            studentOnlyVo.setCateName(category.getName());
            studentOnlyVo.setEmpName(employ.getName());
            studentOnlyVo.setClassName(cla.getClassName());
            studentOnlyVo.setInduName(industry.getName());
            studentOnlyVo.setAddress(student.getAddress());
            studentOnlyVo.setCompany(student.getCompany());
            studentOnlyVo.setEmail(student.getEmail());
            studentOnlyVo.setName(student.getName());
            studentOnlyVo.setPhone(student.getPhone());
            studentOnlyVo.setSex(student.getSex());
            studentOnlyVo.setStuId(student.getStuId());
            studentOnlyVoList.add(studentOnlyVo);

        }
        return studentOnlyVoList;
    }
    private StudentVo assembleStudent(String stuId){
        StudentVo studentVo = new StudentVo();
        List<EvaluateVo> evaluateVoList = evaluateService.getEvaluateList(stuId);
        List<SubjectVo> subjectVoList = subjectService.getSubjectVoList(stuId);
        Suggest suggest = suggestService.selectSuggestByStuId(stuId);
        Student student = studentMapper.selectByStuId(stuId);
        Category category = categoryMapper.selectByCateId(student.getCateId());
        Class cla = classMapper.selectByClassId(student.getClassId());
        Employ employ = employMapper.selectByEmpId(student.getEmpId());
        Industry industry = industryMapper.selectByInduId(student.getInduId());
        studentVo.setAddress(student.getAddress());
        studentVo.setCateName(category.getName());
        studentVo.setClassName(cla.getClassName());
        studentVo.setCompany(student.getCompany());
        studentVo.setEmail(student.getEmail());
        studentVo.setEmpName(employ.getName());
        studentVo.setName(student.getName());
        studentVo.setStuId(student.getStuId());
        studentVo.setSex(student.getSex());
        studentVo.setPhone(student.getPhone());
        studentVo.setInduName(industry.getName());
        studentVo.setEvaluateVoList(evaluateVoList);
        studentVo.setSubjectVoList(subjectVoList);
        studentVo.setSuggest(suggest);
        return studentVo;
    }

    public ServerResponse checkCountByClassId(String classId){
        int count = studentMapper.checkCountByClassId(classId);
        return ServerResponse.createBySuccess(count);
    }
    public ServerResponse getAllCount(){
        List<Class> classList = classMapper.selectAll();
        Map<String, String> classCount = Maps.newHashMap();
        int totalCount = 0;
        for (Class cla : classList){
            totalCount+=studentMapper.checkCountByClassId(cla.getClassId());
            classCount.put(cla.getClassName(), studentMapper.checkCountByClassId(cla.getClassId())+"");
        }
        classCount.put("总人数",totalCount+"");
        return ServerResponse.createBySuccess(classCount);
    }
    public ServerResponse getAllGradePerSmall(){
        ServerResponse response = subjectService.getAllSubScatVo();
        List<SubjectAndScatVo> subjectAndScatVoList = (List<SubjectAndScatVo>) response.getData();
        ServerResponse response1 = evaluateService.getAllEvaluateAndScatVo();
        List<EvaluateAndScatVo> evaluateAndScatVoList = (List<EvaluateAndScatVo>) response1.getData();
        ScatResultVo scatResultVo = new ScatResultVo();
        scatResultVo.setEvaluateAndScatVo(evaluateAndScatVoList);
        scatResultVo.setSubjectAndScatVo(subjectAndScatVoList);
        return ServerResponse.createBySuccess(scatResultVo);
    }
}
