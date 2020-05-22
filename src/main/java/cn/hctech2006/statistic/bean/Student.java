package cn.hctech2006.statistic.bean;

import java.io.Serializable;
import java.util.Date;

public class Student implements Serializable {
    private Long id;

    private String stuId;

    private String name;

    private String sex;

    private String classId;

    private String phone;

    private String email;

    private String empId;

    private String company;

    private String address;

    private String cateId;

    private String induId;

    private Date createTime;

    private Integer status;

    private String suggest;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getClassId() {
        return classId;
    }

    public void setClassId(String classId) {
        this.classId = classId;
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

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
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

    public String getCateId() {
        return cateId;
    }

    public void setCateId(String cateId) {
        this.cateId = cateId;
    }

    public String getInduId() {
        return induId;
    }

    public void setInduId(String induId) {
        this.induId = induId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getSuggest() {
        return suggest;
    }

    public void setSuggest(String suggest) {
        this.suggest = suggest;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", stuId=").append(stuId);
        sb.append(", name=").append(name);
        sb.append(", sex=").append(sex);
        sb.append(", classId=").append(classId);
        sb.append(", phone=").append(phone);
        sb.append(", email=").append(email);
        sb.append(", empId=").append(empId);
        sb.append(", company=").append(company);
        sb.append(", address=").append(address);
        sb.append(", cateId=").append(cateId);
        sb.append(", induId=").append(induId);
        sb.append(", createTime=").append(createTime);
        sb.append(", status=").append(status);
        sb.append(", suggest=").append(suggest);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}