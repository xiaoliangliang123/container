package com.reportdesigner.container.service;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.reportdesigner.container.model.DBSelectColumn;
import com.reportdesigner.container.model.DataViewModel;
import com.reportdesigner.container.model.DesignerReportModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.ColumnMapRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.*;

/**
 * @author:WANGLIANG(XIAO)
 * @Date: 2020/1/17 08:58
 * @Description :数据库操作实现类
 */
@Service("dataService")
public class DataServiceImpl implements DataService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public DataViewModel doQuery(DesignerReportModel designerReportModel) {

        DataViewModel dataViewModel = new DataViewModel();

        Type type  = new TypeToken<List<DBSelectColumn>>() {}.getType();
        List<DBSelectColumn> dbSelectColumns = new Gson().fromJson(designerReportModel.getDbColumnJson(), type);
        dataViewModel.setTitle(designerReportModel.getTitle());
        List<Map<String,Object>> dlist = jdbcTemplate.query(designerReportModel.getSql(),new ColumnMapRowMapper());
        List<List<String>> dslist = new ArrayList<>();
        List<String> headers = new ArrayList<>();
        for(DBSelectColumn dbSelectColumn:dbSelectColumns){
            headers.add(dbSelectColumn.getHeaderName().equals("无注释")?dbSelectColumn.getAliasName():dbSelectColumn.getHeaderName());
        }
        for(Map<String,Object> map:dlist){

            List<String> vs = new ArrayList<>();
            Collection collection = map.values();
            Iterator iterator = collection.iterator();
            while(iterator.hasNext()){

                String value = (String) iterator.next();
                vs.add(value);
            }
            dslist.add(vs);
        }
        dataViewModel.setHeaders(headers);
        dataViewModel.setDatalist(dslist);
        return dataViewModel;
    }
}
