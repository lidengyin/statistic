package cn.hctech2006.statistic.service;

import cn.hctech2006.statistic.bean.Subject;
import cn.hctech2006.statistic.bean.Subresult;
import cn.hctech2006.statistic.bean.Subsmall;
import cn.hctech2006.statistic.common.ServerResponse;
import cn.hctech2006.statistic.vo.SubjectVo;

import java.util.List;

public interface SubjectService {
    public ServerResponse insertSubject(Subject subject);
    public ServerResponse insertSubsmall(Subsmall subsmall);
    public ServerResponse insertSubresult(Subresult subresult);
    public List<SubjectVo> getSubjectVoList(String stuId);
    public ServerResponse getAllSubJectVo();

}
