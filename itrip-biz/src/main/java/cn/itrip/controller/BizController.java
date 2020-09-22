package cn.itrip.controller;

import cn.itrip.beans.dto.Dto;
import cn.itrip.beans.pojo.User;
import cn.itrip.common.DtoUtil;
import cn.itrip.common.Page;
import cn.itrip.service.UserService;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController   //方法返回的都是 @ResponseBody
public class BizController {
    @Resource
    UserService userService;

    @RequestMapping("/display")

    public Dto display(@RequestParam(value = "page",required = true, defaultValue = "1") int pageIndex,
                       @RequestParam(value = "name" ,required = false) String userName){
        //查询分页用户信息
        Page<User> pagedUsers = userService.getPagedUsers(pageIndex, userName);


        return DtoUtil.returnDataSuccess(pagedUsers);
    }
}
