package com.reportdesigner.container.util;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.reportdesigner.container.model.DBSelectColumn;

import java.util.List;
import java.util.Map;

public class JsonUtil {
    public static String json2String(Object obj) {

        Gson gson = new Gson();
        String gsonList = gson.toJson(obj);
        return gsonList;
    }

    public static List<Map> JsonArrayString2ListMap(String dbColumnJson) {
        Gson gson = new Gson();
        List<Map> list = gson.fromJson(dbColumnJson,new TypeToken<List>() {}.getType());
        return list;
    }

    public static List<DBSelectColumn> JsonArrayString2ListBean(String dbColumnJson) {

        Gson gson = new Gson();
        List<DBSelectColumn> dbSelectColumns = gson.fromJson(dbColumnJson, new TypeToken<List<DBSelectColumn>>() {}.getType());
        return dbSelectColumns;
    }
}
