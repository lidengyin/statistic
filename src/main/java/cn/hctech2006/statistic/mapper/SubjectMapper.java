package cn.hctech2006.statistic.mapper;

import cn.hctech2006.statistic.bean.Subject;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface SubjectMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Subject record);

    Subject selectByPrimaryKey(Long id);

    List<Subject> selectAll();

    int updateByPrimaryKey(Subject record);
}