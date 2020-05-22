package cn.hctech2006.statistic.mapper;

import cn.hctech2006.statistic.bean.Subsmall;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface SubsmallMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Subsmall record);

    Subsmall selectByPrimaryKey(Long id);

    List<Subsmall> selectAll();

    int updateByPrimaryKey(Subsmall record);

    Subsmall selectBySmId(String smId);

    List<Subsmall> selectBySubId(String subId);
}