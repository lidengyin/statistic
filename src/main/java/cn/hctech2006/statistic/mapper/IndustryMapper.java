package cn.hctech2006.statistic.mapper;

import cn.hctech2006.statistic.bean.Industry;
import io.swagger.models.auth.In;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface IndustryMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Industry record);

    Industry selectByPrimaryKey(Long id);

    List<Industry> selectAll();

    int updateByPrimaryKey(Industry record);

    Industry selectByInduId(String induId);
}