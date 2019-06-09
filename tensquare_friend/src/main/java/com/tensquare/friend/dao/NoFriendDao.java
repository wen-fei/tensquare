package com.tensquare.friend.dao;

import com.tensquare.friend.pojo.NoFriend;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author : TenYun
 * @date : 2019-06-09 11:47
 * @description : 不喜欢列表数据访问层
 **/
public interface NoFriendDao extends JpaRepository<NoFriend, String> {
}
