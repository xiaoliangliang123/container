package com.reportdesigner.container.controller;

import com.reportdesigner.container.model.DesignerReportModel;
import com.reportdesigner.container.model.JsonResult;
import com.reportdesigner.container.util.FileUtil;
import com.reportdesigner.container.util.JsonUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;


/**
 * @author:WANGLIANG(XIAO)
 * @Date: 2020/1/16 17:38
 * @Description :报表接收controller
 */
@Controller
@RequestMapping("/container")
public class ContainerController {

     @RequestMapping(value = "/receive" ,method = RequestMethod.POST)
     @ResponseBody
     public JsonResult receive(@RequestBody  DesignerReportModel designerReportModel) throws IOException {

          String jsonString = JsonUtil.json2String(designerReportModel);
          FileUtil.writeDataTo(designerReportModel.getTitle(),jsonString);
          return new JsonResult(true);
     }

     @RequestMapping(value = "/report/{name}" ,method = RequestMethod.GET)
     public String report(@PathVariable("name") String reportName) throws IOException {

          return "";
     }
}
