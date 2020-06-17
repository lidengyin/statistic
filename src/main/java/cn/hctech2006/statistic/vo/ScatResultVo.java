package cn.hctech2006.statistic.vo;

import java.util.List;

public class ScatResultVo {
    private List<EvaluateAndScatVo> evaluateAndScatVo;
    private List<SubjectAndScatVo> subjectAndScatVo;

    public List<EvaluateAndScatVo> getEvaluateAndScatVo() {
        return evaluateAndScatVo;
    }

    public void setEvaluateAndScatVo(List<EvaluateAndScatVo> evaluateAndScatVo) {
        this.evaluateAndScatVo = evaluateAndScatVo;
    }

    public List<SubjectAndScatVo> getSubjectAndScatVo() {
        return subjectAndScatVo;
    }

    public void setSubjectAndScatVo(List<SubjectAndScatVo> subjectAndScatVo) {
        this.subjectAndScatVo = subjectAndScatVo;
    }
}
