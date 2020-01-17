package com.reportdesigner.container.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author:WANGLIANG(XIAO)
 * @Date: 2020/1/17 08:59
 * @Description :数据展示类
 */
@Data
public class DataViewModel {

    private String title ;
    private List<String> headers = new ArrayList<>();
    private List<List<String>> datalist = new ArrayList<>();


}
