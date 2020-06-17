package cn.hctech2006.statistic.mapper;

import cn.hctech2006.statistic.bean.Evaresult;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface EvaresultMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Evaresult record);

    Evaresult selectByPrimaryKey(Integer id);

    List<Evaresult> selectAll();

    int updateByPrimaryKey(Evaresult record);

    List<Evaresult> selectByStuIdEvaId(String stuId,String evaId);

    int checkBystuIdAndEsId(String stuId, String esId);

    int updateGradeByStuIdAndEsId(String stuId, String esId, String grade);
    List<Evaresult> selectGradeByEsId(String esId);


}