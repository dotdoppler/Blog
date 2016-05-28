package com.doppler.blog.admin;

import com.doppler.blog.Service.SettingService;
import com.doppler.blog.models.Setting;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * Created by doppler on 2016/5/12.
 */
@Controller
@RequestMapping("admin")
public class AdminController {

    @Resource
    SettingService settingService;

    @RequestMapping("")
    public String index(){
        return "admin/home/index";
    }

    @RequestMapping(value = "settings",method = RequestMethod.GET)
    public String showSettings(Model model){
        model.addAttribute("settings",settingService.getSetting());
        return "admin/home/settings";
    }
    @RequestMapping(value = "settings",method = RequestMethod.POST)
    public String updateSettings(@Valid Setting setting, Model model){
       setting = settingService.updateSetting(setting);
        model.addAttribute("settings",setting);
        return "admin/home/settings";
    }
}
