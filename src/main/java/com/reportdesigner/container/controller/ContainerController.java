package com.reportdesigner.container.controller;

import com.reportdesigner.container.model.DesignerReportModel;
import com.reportdesigner.container.model.JsonResult;
import com.reportdesigner.container.util.FileUtil;
import com.reportdesigner.container.util.JsonUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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
}
