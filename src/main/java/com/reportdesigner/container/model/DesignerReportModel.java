package com.reportdesigner.container.model;


import com.reportdesigner.container.util.JsonUtil;

import java.util.List;
import java.util.stream.Collectors;

public class DesignerReportModel {

    private  String sql;
    private  String dbColumnJson;
    private  String id;
    private  String title;


    public DesignerReportModel(){}
    public DesignerReportModel(String id, String title, String dbColumnJson, String sql) {
        this.id = id ;
        this.dbColumnJson = dbColumnJson;
        this.sql = sql;
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSql() {
        return sql;
    }

    public void setSql(String sql) {
        this.sql = sql;
    }

    public String getDbColumnJson() {
        return dbColumnJson;
    }

    public void setDbColumnJson(String dbColumnJson) {
        this.dbColumnJson = dbColumnJson;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Object[] titleArray() {

        List<DBSelectColumn> dbSelectColumns = JsonUtil.JsonArrayString2ListBean(dbColumnJson);
        List<String> headerArray = dbSelectColumns.stream().map(DBSelectColumn::getHeaderName).collect(Collectors.toList());
        return   headerArray.toArray();
    }

    public Object[] columnArray() {
        List<DBSelectColumn> dbSelectColumns = JsonUtil.JsonArrayString2ListBean(dbColumnJson);
        List<String> columnArray = dbSelectColumns.stream().map(DBSelectColumn::getAliasName).collect(Collectors.toList());
        return   columnArray.toArray();
    }
}
