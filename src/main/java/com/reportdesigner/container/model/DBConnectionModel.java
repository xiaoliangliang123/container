package com.reportdesigner.container.model;

import java.io.Serializable;

/**
 * @author:WANGLIANG(XIAO)
 * @Date: 2020/1/17 08:14
 * @Description :
 */
public class DBConnectionModel implements Serializable {

    private String dbname;
    private String url ;
    private String username ;
    private String password;

    public DBConnectionModel(){

    }

    public DBConnectionModel(String dbname,String url,String username,String password){
        this.dbname = dbname;
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public String getDbname() {
        return dbname;
    }

    public void setDbname(String dbname) {
        this.dbname = dbname;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isMysql(){
        return dbname.equals("MYSQL");
    }

    public boolean isOracle(){
        return dbname.equals("ORACLE");
    }
}
