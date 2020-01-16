package com.reportdesigner.container.model;

/**
 * @author:WANGLIANG(XIAO)
 * @Date: 2019/6/1 12:35
 * @Description :
 */
public class DBSelectColumn {

    private  String id;
    private  String aliasName;
    private  String headerName;
    private  String tableName ;

    public String getTableName() {
        return tableName;
    }

    private DBSelectColumn(String tableName, String id, String aliasName, String headerName){
        this.tableName = tableName;
        this.id = id;
        this.aliasName = aliasName;
        this.headerName = headerName;
    }

    public static DBSelectColumn loadDBSelectColumn(String tableName ,String id, String aliasName, String headerName){
        return new DBSelectColumn(tableName,id,aliasName,headerName);
    }


    public String getId() {
        return id;
    }

    public String getAliasName() {
        return aliasName;
    }

    public String getHeaderName() {
        return headerName;
    }

    public String selectName() {
        return tableName+"."+id;
    }

    public void setAliasName(String aliasName) {
        this.aliasName = aliasName;
    }

    public void setHeaderName(String headerName) {
        this.headerName = headerName;
    }
}
