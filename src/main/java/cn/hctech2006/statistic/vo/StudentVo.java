package cn.hctech2006.statistic.vo;

import cn.hctech2006.statistic.bean.Suggest;

import java.util.List;

public class StudentVo {
    private List<EvaluateVo> evaluateVoList;
    private List<SubjectVo> subjectVoList;
    private Suggest suggest;
    private String stuId;

    private String name;

    private String sex;

    private String className;

    private String phone;

    private String email;

    private String empName;

    private String company;

    private String address;

    private String cateName;

    private String induName;

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getCateName() {
        return cateName;
    }

    public void setCateName(String cateName) {
        this.cateName = cateName;
    }

    public Suggest getSuggest() {
        return suggest;
    }

    public void setSuggest(Suggest suggest) {
        this.suggest = suggest;
    }

    public List<SubjectVo> getSubjectVoList() {
        return subjectVoList;
    }

    public void setSubjectVoList(List<SubjectVo> subjectVoList) {
        this.subjectVoList = subjectVoList;
    }

    public List<EvaluateVo> getEvaluateVoList() {
        return evaluateVoList;
    }

    public void setEvaluateVoList(List<EvaluateVo> evaluateVoList) {
        this.evaluateVoList = evaluateVoList;
    }

    public String getStuId() {
        return stuId;
    }

    public void setStuId(String stuId) {
        this.stuId = stuId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }



    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


    public String getInduName() {
        return induName;
    }

    public void setInduName(String induName) {
        this.induName = induName;
    }
}
