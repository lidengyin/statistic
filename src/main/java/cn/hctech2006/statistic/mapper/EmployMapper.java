package cn.hctech2006.statistic.mapper;

import cn.hctech2006.statistic.bean.Employ;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface EmployMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Employ record);

    Employ selectByPrimaryKey(Integer id);

    List<Employ> selectAll();

    int updateByPrimaryKey(Employ record);

    Employ selectByEmpId(String empId);
}