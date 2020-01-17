package com.reportdesigner.container.util;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import com.reportdesigner.container.model.DBSelectColumn;

import java.util.List;
import java.util.Map;

public class JsonUtil {

    static Gson gson = new Gson();

    public static String json2String(Object obj) {

        String gsonList = gson.toJson(obj);
        return gsonList;
    }

    public static List<Map> JsonArrayString2ListMap(String dbColumnJson) {
        List<Map> list = gson.fromJson(dbColumnJson,new TypeToken<List>() {}.getType());
        return list;
    }

    public static List<DBSelectColumn> JsonArrayString2ListBean(String dbColumnJson) {


        List<DBSelectColumn> dbSelectColumns = gson.fromJson(dbColumnJson, new TypeToken<List<DBSelectColumn>>() {}.getType());
        return dbSelectColumns;
    }


    public static <T> T data2Model(String data,Class clazz) {

        return (T)gson.fromJson(data,clazz);
    }


}
