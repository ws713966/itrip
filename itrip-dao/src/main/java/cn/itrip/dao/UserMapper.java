package cn.itrip.dao;

import cn.itrip.beans.pojo.User;

import java.util.List;
import java.util.Map;

public interface UserMapper {

    /**
     * 根据参数进行分页查询
     * @param params
     * @return
     */
    List<User> getUsersByParams(Map<String,Object> params);

    /**
     * 根据参数查询用户数量
     * @param params
     * @return
     */
    int getUserCountByParams(Map<String,Object> params);

}
