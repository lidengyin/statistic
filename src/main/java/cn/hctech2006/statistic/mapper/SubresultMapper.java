package cn.hctech2006.statistic.mapper;

import cn.hctech2006.statistic.bean.Subresult;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface SubresultMapper {
    int deleteByPrimaryKey(Long id);

    int insert( Subresult record);

    Subresult selectByPrimaryKey(Long id);

    List<Subresult> selectAll();

    int updateByPrimaryKey(Subresult record);
    List<Subresult> selectByStuIdSubId(String stuId, String subId);

    int checkByStuIdAndSmId(String stuId, String smId);
    int updateGradeByStuIdAndSmId(String stuId, String smId,String grade);
    List<Subresult> selectGradeBySmId(String smId);

}