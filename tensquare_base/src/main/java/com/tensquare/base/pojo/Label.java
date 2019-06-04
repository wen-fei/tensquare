package com.tensquare.base.pojo;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @author : TenYun
 * @date : 2019-06-04 15:20
 * @description : Label
 **/

@Entity
@Table(name = "tb_label")
@Setter
@Getter
public class Label implements Serializable {
    @Id
    private String id;
    // label name
    private String labelname;
    // label state
    private String state;
    // label use numbers
    private Long count;
    // label fans
    private Long fans;
    // recommend or not
    private String recommend;
}
