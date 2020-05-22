package cn.hctech2006.statistic.vo;

import java.util.List;

public class SubjectVo {
    private String subId;

    private String name;

    private Integer ord;
    private List<SubresultVo> subresultVoList;

    public String getSubId() {
        return subId;
    }

    public void setSubId(String subId) {
        this.subId = subId;
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

    public List<SubresultVo> getSubresultVoList() {
        return subresultVoList;
    }

    public void setSubresultVoList(List<SubresultVo> subresultVoList) {
        this.subresultVoList = subresultVoList;
    }
}
