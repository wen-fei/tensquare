package com.tensquare.friend.service;

import com.tensquare.friend.dao.FriendDao;
import com.tensquare.friend.pojo.Friend;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author : TenYun
 * @date : 2019-06-08 20:49
 * @description :
 **/
@Service
public class FriendService {

    @Autowired
    private FriendDao friendDao;

    @Transactional(rollbackFor = Exception.class)
    public int addFriend(String userid, String friendid) {

        // 判断如果用户已经添加了这个好友，则不进行任何操作，返回0
        if (friendDao.selectCount(userid, friendid) > 0) {
            return 0;
        }

        // 向喜欢表中添加记录
        Friend friend = new Friend();
        friend.setUserid(userid);
        friend.setFriendid(friendid);
        friend.setIslike("0");
        friendDao.save(friend);

        if (friendDao.selectCount( friendid, userid) > 0) {
            friendDao.updateLike(userid, friendid, "1");
            friendDao.updateLike(friendid, userid, "1");
        }
        return 1;
    }
}
