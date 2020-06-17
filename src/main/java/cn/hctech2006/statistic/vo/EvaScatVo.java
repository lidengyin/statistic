package cn.hctech2006.statistic.vo;

public class EvaScatVo {
    private String emId;
    private String EvaId;
    private String name;
    private int stuNum;
    private int AllGrade;
    private Integer[] gradeList;

    public String getEmId() {
        return emId;
    }

    public void setEmId(String emId) {
        this.emId = emId;
    }

    public String getEvaId() {
        return EvaId;
    }

    public void setEvaId(String evaId) {
        EvaId = evaId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStuNum() {
        return stuNum;
    }

    public void setStuNum(int stuNum) {
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
}
