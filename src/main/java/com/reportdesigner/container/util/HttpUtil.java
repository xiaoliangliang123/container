package com.reportdesigner.container.util;

import com.google.gson.Gson;
import jodd.http.HttpRequest;
import jodd.http.HttpResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HttpUtil {

    private final static Logger logger = LoggerFactory.getLogger(HttpUtil.class);


    static Gson gson = new Gson();
    /**
     *
     *
     * 发送Post请求-json数据
     * @param url : 请求的连接
     * @param object ：  请求参数，无参时传null
     * @return
     */
    public static String sendPostToJson(String url,Object object){

        HttpRequest request = HttpRequest.post(url);
        request.contentType("application/json");
        request.charset("utf-8");

        //参数详情
        if(object!=null) {
            request.body(gson.toJson(object));
        }

        HttpResponse response = request.send();
        String respJson = response.bodyText();

        return respJson;
    }





}
