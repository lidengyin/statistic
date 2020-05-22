package cn.hctech2006.statistic.service;

import cn.hctech2006.statistic.bean.Suggest;
import cn.hctech2006.statistic.common.ServerResponse;

public interface SuggestService  {
    public ServerResponse insertSuggest(Suggest suggest);
    public Suggest selectSuggestByStuId(String stuId);
}
