package com.leotech.fileview.controller;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
public class IndexController {
    @RequestMapping("/")
    public String index() {
        return "index";
    }

    @RequestMapping("list")
    public String list(@RequestParam int fname, HttpServletRequest request, Model model) {
        String fNamePath = "/upload/";
        switch (fname) {
            case 1: //调控中心
                fNamePath += "调控中心";
                break;
            case 2: //运检部
                fNamePath += "运检部";
                break;
            case 3: //营销部
                fNamePath += "营销部";
                break;
            case 4: //安质部
                fNamePath += "安质部";
                break;
            case 5: //省电科院
                fNamePath += "省电科院";
                break;
            case 6: //农网办
                fNamePath += "农网办";
                break;
            case 7: //会议纪要
                fNamePath += "会议纪要";
                break;
        }
        // 获取文件列表
        String path = request.getServletContext().getRealPath(fNamePath);

        File[] fileList = new File(path).listFiles();
        model.addAttribute("title", fNamePath);
        List<Map<String, String>> fileInfoList = new ArrayList<>();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        for (File file : fileList) {
            try {
                Map<String, String> map = new HashMap<>();
                map.put("fileName", file.getName());
                map.put("filePath", fNamePath + "/" + file.getName());
                String dateTime=df.format(new Date(file.lastModified()));
                map.put("lastModified", dateTime);
                fileInfoList.add(map);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        // 读取upload目录
        model.addAttribute("fileInfoList", fileInfoList);
        return "list";
    }
}
