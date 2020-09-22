package cn.itrip.service.impl;

import cn.itrip.beans.pojo.User;
import cn.itrip.common.Page;
import cn.itrip.dao.UserMapper;
import cn.itrip.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    UserMapper userMapper;

    @Override
    public Page<User> getPagedUsers(int pageIndex,  String userName) {
        //页大小
        int pageSize=5;
        //封装查询条件
        Map<String,Object> params=new HashMap<>();

        params.put("userName",userName);
        params.put("from",(pageIndex-1)*pageSize);
        params.put("limit",pageSize);

        //查询满足查询条件的用户集合和个数
        int totalCount = userMapper.getUserCountByParams(params);
        List<User> users = userMapper.getUsersByParams(params);
        //封装查询结果
        Page<User> pagedUsers=new Page<User>(pageIndex,pageSize,totalCount,users);

        return pagedUsers;
    }
}
