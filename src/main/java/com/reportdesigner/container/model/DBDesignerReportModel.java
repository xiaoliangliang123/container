package com.reportdesigner.container.model;

import java.io.Serializable;

/**
 * @author:WANGLIANG(XIAO)
 * @Date: 2020/1/17 08:08
 * @Description :
 */


public class DBDesignerReportModel implements Serializable {

    private DBConnectionModel dbConnectionModel;


    private DesignerReportModel designerReportModel ;


    public DBDesignerReportModel(){}

    public DBDesignerReportModel(DBConnectionModel dbConnectionModel,DesignerReportModel designerReportModel){

        this.dbConnectionModel = dbConnectionModel;
        this.designerReportModel = designerReportModel;
    }

    public DBConnectionModel getDbConnectionModel() {
        return dbConnectionModel;
    }

    public void setDbConnectionModel(DBConnectionModel dbConnectionModel) {
        this.dbConnectionModel = dbConnectionModel;
    }

    public DesignerReportModel getDesignerReportModel() {
        return designerReportModel;
    }

    public void setDesignerReportModel(DesignerReportModel designerReportModel) {
        this.designerReportModel = designerReportModel;
    }
}
