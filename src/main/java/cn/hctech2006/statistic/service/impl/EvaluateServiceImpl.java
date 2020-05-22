package cn.hctech2006.statistic.service.impl;

import cn.hctech2006.statistic.bean.Evaluate;
import cn.hctech2006.statistic.bean.Evaresult;
import cn.hctech2006.statistic.bean.Evasmall;
import cn.hctech2006.statistic.common.ServerResponse;
import cn.hctech2006.statistic.mapper.EvaluateMapper;
import cn.hctech2006.statistic.mapper.EvaresultMapper;
import cn.hctech2006.statistic.mapper.EvasmallMapper;
import cn.hctech2006.statistic.service.EvaluateService;
import cn.hctech2006.statistic.vo.EvaluateAndSmallVo;
import cn.hctech2006.statistic.vo.EvaluateVo;
import cn.hctech2006.statistic.vo.EvaresultVo;
import cn.hctech2006.statistic.vo.EvasmallVo;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
@Service
public class EvaluateServiceImpl implements EvaluateService {
    @Autowired
    private EvaluateMapper evaluateMapper;
    @Autowired
    private EvasmallMapper evasmallMapper;
    @Autowired
    private EvaresultMapper evaresultMapper;
    @Override
    public ServerResponse insertEValuate(Evaluate evaluate) {
        evaluate.setEvaId(UUID.randomUUID().toString());
        int count = evaluateMapper.insert(evaluate);
        if (count > 0){
            return ServerResponse.createBySuccess("注册成功，测试编号："+evaluate.getEvaId());
        }
        return ServerResponse.createByError("创建失败");
    }

    @Override
    public ServerResponse insertEVasmall(Evasmall evasmall) {
        evasmall.setEsId(UUID.randomUUID().toString());
        int count = evasmallMapper.insert(evasmall);
        if (count > 0){
            return ServerResponse.createBySuccess("注册成功，测试编号："+evasmall.getEsId());
        }
        return ServerResponse.createByError("创建失败");
    }

    @Override
    public ServerResponse insertEvaresult(Evaresult evaresult) {
        int hasAlready = evaresultMapper.checkBystuIdAndEsId(evaresult.getStuId(), evaresult.getEsId());
        int count = 0;
        if (hasAlready > 0){
            count = evaresultMapper.updateGradeByStuIdAndEsId(evaresult.getStuId(), evaresult.getEsId(), evaresult.getGrade());
        }else{
            count =  evaresultMapper.insert(evaresult);
        }

        if (count > 0){
            return ServerResponse.createBySuccess("注册成功");
        }
        return ServerResponse.createByError("注册失败");
    }
//    private ServerResponse assembleEvaresult(String stuId, String evaId){
//        List<Evaresult> evaresultList = evaresultMapper.selectByStuIdEvaId(stuId,evaId);
//        return null;
//    }
    public List<EvaluateVo> getEvaluateList(String stuId){
        return assembleEvaluate(stuId);
    }

    @Override
    public ServerResponse getAllEvaluateVo() {

        return ServerResponse.createBySuccess(assembleEvaluateAndSmallVo());
    }

    private List<EvaluateAndSmallVo> assembleEvaluateAndSmallVo(){
        List<EvaluateAndSmallVo> evaluateAndSmallVoList = Lists.newArrayList();
        List<Evaluate> evaluateList = evaluateMapper.selectAll();
        for (Evaluate evaluate: evaluateList){
            EvaluateAndSmallVo evaluateAndSmallVo = new EvaluateAndSmallVo();
            List<Evasmall> evasmallList = evasmallMapper.selectByEvaId(evaluate.getEvaId());
            evaluateAndSmallVo.setEvasmallVoList(assmbleEvasmallVo(evasmallList));
            evaluateAndSmallVo.setEvaId(evaluate.getEvaId());
            evaluateAndSmallVo.setName(evaluate.getName());
            evaluateAndSmallVoList.add(evaluateAndSmallVo);
            evaluateAndSmallVo.setOrd(evaluate.getOrd());
        }
        return evaluateAndSmallVoList;
    }

    private List<EvasmallVo> assmbleEvasmallVo(List<Evasmall> evasmallList){
        List<EvasmallVo> evasmallVoList = Lists.newArrayList();
        List<String> grade = Lists.newArrayList();
        grade.add("完全达到");
        grade.add("达到");
        grade.add("基本达到");
        grade.add("基本未达到");
        grade.add("完全未达到");
        for (Evasmall evasmall: evasmallList){
                EvasmallVo evasmallVo = new EvasmallVo();
                evasmallVo.setEsId(evasmall.getEsId());
                evasmallVo.setEvaId(evasmall.getEvaId());
                evasmallVo.setGrade(grade);
                evasmallVo.setName(evasmall.getName());
                evasmallVoList.add(evasmallVo);
            }
        return evasmallVoList;
    }
    private List<EvaluateVo>  assembleEvaluate(String stuId){
        List<Evaluate> evaluateList = evaluateMapper.selectAll();
        List<EvaluateVo> evaluateVoList = Lists.newArrayList();
        for (Evaluate evaluate : evaluateList){
            EvaluateVo evaluateVo = new EvaluateVo();
            List<EvaresultVo> evaresultVoList = assembleEvaresultVo(stuId,evaluate.getEvaId());
            evaluateVo.setEvaresultVoList(evaresultVoList);
            evaluateVo.setEvaId(evaluate.getEvaId());
            evaluateVo.setName(evaluate.getName());
            evaluateVo.setOrd(evaluate.getOrd());
            evaluateVoList.add(evaluateVo);
        }
        return evaluateVoList;
    }

        private List<EvaresultVo> assembleEvaresultVo(String stuId, String evaId){
        List<Evaresult> evaresultList = evaresultMapper.selectByStuIdEvaId(stuId,evaId);
        List<EvaresultVo> evaresultVoList = Lists.newArrayList();
        for (Evaresult evaresult: evaresultList){
            EvaresultVo evaresultVo = new EvaresultVo();
            Evasmall evasmall = evasmallMapper.selectByEsId(evaresult.getEsId());
            evaresultVo.setEsName(evasmall.getName());
            evaresultVo.setEsId(evaresult.getEsId());
            evaresultVo.setGrade(evaresult.getGrade());
            evaresultVoList.add(evaresultVo);
        }
        return evaresultVoList;
    }
}
