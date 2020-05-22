package cn.hctech2006.statistic.mapper;

import cn.hctech2006.statistic.bean.Student;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface StudentMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Student record);

    Student selectByPrimaryKey(Long id);

    List<Student> selectAll();

    int updateByPrimaryKey(Student record);

    Student selectByStuId(String stuId);

    List<Student> selectStudent(String classId, String empId, String cateId, String induId);

    int updateByStuId(Student student);
    int updateStatus(String stuId);

    int checkByStuId(String stuId);

    int checkCountByClassId(String classId);

}