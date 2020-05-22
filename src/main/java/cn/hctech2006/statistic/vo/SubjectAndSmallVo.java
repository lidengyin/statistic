package cn.hctech2006.statistic.vo;

import java.util.List;

public class SubjectAndSmallVo {
    private String subId;

    private String name;

    private Integer ord;

    private List<SubSmallVo> subsmallVoList;


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

    public List<SubSmallVo> getSubsmallVoList() {
        return subsmallVoList;
    }

    public void setSubsmallVoList(List<SubSmallVo> subsmallVoList) {
        this.subsmallVoList = subsmallVoList;
    }
}
