package cn.hctech2006.statistic.vo;

import cn.hctech2006.statistic.bean.Evasmall;

import java.util.List;

public class EvaluateAndSmallVo {
    private String evaId;

    private String name;

    private Integer ord;

    private List<EvasmallVo> evasmallVoList;


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

    public List<EvasmallVo> getEvasmallVoList() {
        return evasmallVoList;
    }

    public void setEvasmallVoList(List<EvasmallVo> evasmallVoList) {
        this.evasmallVoList = evasmallVoList;
    }

}
