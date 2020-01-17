package com.reportdesigner.container.controller;

import com.reportdesigner.container.model.DBDesignerReportModel;
import com.reportdesigner.container.model.DataViewModel;
import com.reportdesigner.container.model.DesignerReportModel;
import com.reportdesigner.container.model.JsonResult;
import com.reportdesigner.container.service.DataService;
import com.reportdesigner.container.util.FileUtil;
import com.reportdesigner.container.util.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;


/**
 * @author:WANGLIANG(XIAO)
 * @Date: 2020/1/16 17:38
 * @Description :报表接收controller
 */
@Controller
@RequestMapping("/container")
public class ContainerController {

     @Autowired
     private JdbcTemplate jdbcTemplate;

     @Autowired
     private DataService dataService;

     @RequestMapping(value = "/receive" ,method = RequestMethod.POST)
     @ResponseBody
     public JsonResult receive(@RequestBody DBDesignerReportModel dbDesignerReportModel) throws IOException {

           FileUtil.writeDataTo(dbDesignerReportModel.getDesignerReportModel().getTitle(),dbDesignerReportModel);
          return new JsonResult(true);
     }

     @RequestMapping(value = "/report/{name}" ,method = RequestMethod.GET)
     public String report(HttpServletRequest request, @PathVariable("name") String reportName) throws IOException, ClassNotFoundException {

          DBDesignerReportModel dbDesignerReportModel = (DBDesignerReportModel)FileUtil.readFileToData(reportName);
          DataViewModel dataViewModel = dataService.doQuery(dbDesignerReportModel.getDesignerReportModel());
          request.setAttribute("data",dataViewModel);
          return "/report/datalist";
     }
}
