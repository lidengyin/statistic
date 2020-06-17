package cn.hctech2006.statistic.vo;

/**
 * 小项保存的具体打分信息
 */
public class SubScatVo {
    private String smId;
    private String subId;
    private String name;
    private String stuNum;
    private int AllGrade;
    private Integer[] gradeList;


    public String getSmId() {
        return smId;
    }

    public void setSmId(String smId) {
        this.smId = smId;
    }

    public String getStuNum() {
        return stuNum;
    }

    public void setStuNum(String stuNum) {
        this.stuNum = stuNum;
    }

    public int getAllGrade() {
        return AllGrade;
    }

    public void setAllGrade(int allGrade) {
        AllGrade = allGrade;
    }

    public Integer[] getGradeList() {
        return gradeList;
    }

    public void setGradeList(Integer[] gradeList) {
        this.gradeList = gradeList;
    }

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
}
