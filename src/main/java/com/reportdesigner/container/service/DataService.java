package com.reportdesigner.container.service;

import com.reportdesigner.container.model.DataViewModel;
import com.reportdesigner.container.model.DesignerReportModel;

/**
 * @author:WANGLIANG(XIAO)
 * @Date: 2020/1/17 08:57
 * @Description :数据库操作service 接口
 */
public interface DataService {
    DataViewModel doQuery(DesignerReportModel designerReportModel);
}
