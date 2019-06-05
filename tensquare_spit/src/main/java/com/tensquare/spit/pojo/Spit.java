package com.tensquare.spit.pojo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.io.Serializable;
import java.util.Date;

/**
 * @author : TenYun
 * @date : 2019-06-05 10:37
 * @description :
 **/

@Setter
@Getter
@NoArgsConstructor
public class Spit implements Serializable {
    @Id
    private String _id;

    private String context;
    private Date publishtime;
    private String userId;
    private String nickname;
    private Integer visits;
    private Integer thumbup;
    private Integer share;
    private Integer comment;
    private String state;
    private String parentId;

}
