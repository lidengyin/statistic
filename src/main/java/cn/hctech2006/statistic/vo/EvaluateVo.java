package cn.hctech2006.statistic.vo;

import cn.hctech2006.statistic.bean.Evaresult;

import java.util.List;

public class EvaluateVo {

    private String evaId;

    private String name;

    private Integer ord;
    private List<EvaresultVo> evaresultVoList;

    public List<EvaresultVo> getEvaresultVoList() {
        return evaresultVoList;
    }

    public void setEvaresultVoList(List<EvaresultVo> evaresultVoList) {
        this.evaresultVoList = evaresultVoList;
    }

    public String getEvaId() {
        return evaId;
    }

    public void setEvaId(String evaId) {
        this.evaId = evaId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getOrd() {
        return ord;
    }

    public void setOrd(Integer ord) {
        this.ord = ord;
    }
}
