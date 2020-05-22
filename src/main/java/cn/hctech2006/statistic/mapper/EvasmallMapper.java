package cn.hctech2006.statistic.mapper;

import cn.hctech2006.statistic.bean.Evasmall;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface EvasmallMapper {
    int insert(Evasmall record);

    List<Evasmall> selectAll();
    Evasmall selectByEsId(String esId);
    List<Evasmall> selectByEvaId(String evaId);
}