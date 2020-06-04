package com.mingoxu.ws.controller;

import com.mingoxu.ws.entity.request.Phone;
import com.mingoxu.ws.service.PhoneService;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PhoneController {
    private Logger logger = Logger.getLogger(PhoneController.class);

    @Autowired
    PhoneService phoneService;

    @RequestMapping("/query.do")
    public String doQuery(Phone phone, Model model) {
        logger.info("==============手机号码查询开始==============");
        String msg = null;

        if (StringUtils.isEmpty(phone.getPhone())) {
            msg = "手机号码不为空";
        }else {
            try {
                msg = phoneService.doQuery(phone.getPhone());
            }catch (Exception e) {
                logger.error(">>>手机号码查询失败：" + e.getMessage());
                logger.error(">>>入参为：" + phone.toString());
                msg = "查询失败";
                e.printStackTrace();
            }
        }

        model.addAttribute("msg",msg);
        model.addAttribute("phone",phone.getPhone());
        logger.info("==============手机号码查询结束==============");
        return "display";
    }
}
