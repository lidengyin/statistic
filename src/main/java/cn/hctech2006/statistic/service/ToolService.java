package cn.hctech2006.statistic.service;

import cn.hctech2006.statistic.bean.Category;
import cn.hctech2006.statistic.bean.Class;
import cn.hctech2006.statistic.bean.Employ;
import cn.hctech2006.statistic.bean.Industry;
import cn.hctech2006.statistic.common.ServerResponse;

public interface ToolService {
    public ServerResponse insertClass(Class cla);
    public ServerResponse insertCategory(Category category);
    public ServerResponse insertIndustry(Industry industry);
    public ServerResponse insertEmploy(Employ employ);
    public ServerResponse getAllClass();
    public ServerResponse getAllCategory();
    public ServerResponse getAllIndustry();
    public ServerResponse getAllEmploy();

}
