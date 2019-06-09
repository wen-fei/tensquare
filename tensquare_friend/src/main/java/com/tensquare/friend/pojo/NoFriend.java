package com.tensquare.friend.pojo;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @author : TenYun
 * @date : 2019-06-09 11:46
 * @description :
 **/
@Entity
@Table(name = "tb_nofriend")
@Getter
@Setter
public class NoFriend implements Serializable {
    @Id
    private String userid;
    @Id
    private String friendid;

}
