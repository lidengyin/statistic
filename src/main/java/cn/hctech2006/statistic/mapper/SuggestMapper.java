package cn.hctech2006.statistic.mapper;

import cn.hctech2006.statistic.bean.Suggest;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface SuggestMapper {

    int deleteByPrimaryKey(Long id);

    int insert(Suggest record);

    Suggest selectByPrimaryKey(Long id);

    List<Suggest> selectAll();

    int updateByPrimaryKey(Suggest record);
    Suggest selectByStuId(String stuId);

    int checkByStuId(String stuId);

    int updateDetailByStuId(String stuId, String detail);
}