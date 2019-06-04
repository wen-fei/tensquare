package entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author : TenYun
 * @date : 2019-06-04 14:25
 * @description : response result json format
 **/
@Setter
@Getter
@NoArgsConstructor
public class Result {

    private boolean flag;

    private Integer code;

    private String message;

    private Object data;


    public Result(boolean flag, Integer code, String message) {
        this.flag = flag;
        this.code = code;
        this.message = message;
    }

    public Result(boolean flag, Integer code, String message, Object data) {
        this.flag = flag;
        this.code = code;
        this.message = message;
        this.data = data;
    }

}
