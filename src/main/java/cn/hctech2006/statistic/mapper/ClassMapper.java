package cn.hctech2006.statistic.mapper;

import cn.hctech2006.statistic.bean.Class;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface ClassMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Class record);

    Class selectByPrimaryKey(Long id);

    List<Class> selectAll();

    int updateByPrimaryKey(Class record);

    Class selectByClassId(String classId);

    //List<String> selectAllStuId();
}