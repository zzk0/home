package top.zzk0.api.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.zzk0.api.service.FootprintService;
import top.zzk0.util.web.HttpUtil;
import top.zzk0.util.web.RequestUtil;
import top.zzk0.util.web.ResponseUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@CrossOrigin
@RestController
@RequestMapping("/footprint")
public class FootprintController {

    private final FootprintService footprintService;

    public FootprintController(FootprintService footprintService) {
        this.footprintService = footprintService;
    }

    @PostMapping("/record")
    public void addFootprint(HttpServletRequest request, HttpServletResponse response) {
        JSONObject requestJson = RequestUtil.retrieveJson(request);
        RequestUtil.hasAllRequired(requestJson, "url");
        String accessIp = HttpUtil.getRequestIp(request);
        String url = requestJson.getString("url");

        footprintService.insertFootprint(accessIp, url, 0);
        ResponseUtil.responseJson(response, ResponseUtil.successJson());
    }
}
