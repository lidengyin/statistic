package cn.hctech2006.statistic.vo;

import java.util.List;

public class EvaluateAndScatVo {
    private String evaId;

    private String name;

    private Integer ord;

    private List<EvaScatVo> evaScatVoList;

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

    public List<EvaScatVo> getEvaScatVoList() {
        return evaScatVoList;
    }

    public void setEvaScatVoList(List<EvaScatVo> evaScatVoList) {
        this.evaScatVoList = evaScatVoList;
    }
}
