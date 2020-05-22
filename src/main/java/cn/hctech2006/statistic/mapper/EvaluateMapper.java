package cn.hctech2006.statistic.mapper;

import cn.hctech2006.statistic.bean.Evaluate;
import cn.hctech2006.statistic.bean.Student;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface EvaluateMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Evaluate record);

    Evaluate selectByPrimaryKey(Long id);

    List<Evaluate> selectAll();

    int updateByPrimaryKey(Evaluate record);

    Student selectByStuId(String stuId);
}