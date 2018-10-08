package com.stylefeng.guns.modular.dist.controller;

import com.stylefeng.guns.common.controller.BaseController;
import com.stylefeng.guns.core.shiro.ShiroKit;
import com.stylefeng.guns.modular.dist.util.Jwt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * 秘钥生成控制器
 *
 * @author huangpu
 * @Date 2018-04-07 15:10:32
 */
@Controller
@RequestMapping("/key")
public class KeyController extends BaseController {

    private String prefix = "/dist/key/";

    @Value("${dist.jwt.secret}")
    private  String secret;
    @Value("${dist.jwt.account}")
    private  String account;
    /**
     * 跳转到秘钥生成首页
     */
    @RequestMapping("")
    public String index(Model model) {
       // String secret= ShiroKit.getUser().getSecret();
      //  String key= Jwt.sign(ShiroKit.getUser().getAccount(),secret,30L * 24L * 3600L * 1000L);
        String key= Jwt.sign(account,secret,30L * 24L * 3600L * 1000L);
        model.addAttribute("key",key);
        return prefix + "key.html";
    }

    /**
     * 跳转到添加秘钥生成
     */
    @RequestMapping("/key_add")
    public String keyAdd() {
        return prefix + "key_add.html";
    }

    /**
     * 跳转到修改秘钥生成
     */
    @RequestMapping("/key_update/{keyId}")
    public String keyUpdate(@PathVariable Integer keyId, Model model) {
        return prefix + "key_edit.html";
    }

    /**
     * 获取秘钥生成列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(String condition) {
        return null;
    }

    /**
     * 新增秘钥生成
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public Object add() {
        return SUCCESS_TIP;
    }

    /**
     * 删除秘钥生成
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Object delete() {
        return SUCCESS_TIP;
    }


    /**
     * 修改秘钥生成
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public Object update() {
        return SUCCESS_TIP;
    }

    /**
     * 秘钥生成详情
     */
    @RequestMapping(value = "/detail")
    @ResponseBody
    public Object detail() {
        return null;
    }
}
