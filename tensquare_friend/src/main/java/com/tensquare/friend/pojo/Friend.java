package com.tensquare.friend.pojo;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

/**
 * @author : TenYun
 * @date : 2019-06-08 20:41
 * @description :
 **/
@Entity
@Table(name = "tb_friend")
@IdClass(Friend.class)
@Getter
@Setter
public class Friend {

    @Id
    private String userid;

    @Id
    private String friendid;

    private String Islike;

}
