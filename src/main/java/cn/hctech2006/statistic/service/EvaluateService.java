package cn.hctech2006.statistic.service;

import cn.hctech2006.statistic.bean.Evaluate;
import cn.hctech2006.statistic.bean.Evaresult;
import cn.hctech2006.statistic.bean.Evasmall;
import cn.hctech2006.statistic.common.ServerResponse;
import cn.hctech2006.statistic.vo.EvaluateVo;

import java.util.List;

public interface EvaluateService {
    public ServerResponse insertEValuate(Evaluate evaluate);
    public ServerResponse insertEVasmall(Evasmall evasmall);
    public ServerResponse insertEvaresult(Evaresult evaresult);
    public List<EvaluateVo> getEvaluateList(String stuId);
    public ServerResponse getAllEvaluateVo();

}
