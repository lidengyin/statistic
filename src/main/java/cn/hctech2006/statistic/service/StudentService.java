package cn.hctech2006.statistic.service;

import cn.hctech2006.statistic.bean.Student;
import cn.hctech2006.statistic.common.ServerResponse;

public interface StudentService {
    public ServerResponse insertStudent(Student student);

    public ServerResponse getDetail(String stuId);
    public ServerResponse selectStudent(String classId, String empId, String cateId, String induId);
    public ServerResponse checkCountByClassId(String classId);
    public ServerResponse getAllCount();
}
