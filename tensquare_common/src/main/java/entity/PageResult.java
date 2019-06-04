package entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

/**
 * @author : TenYun
 * @date : 2019-06-04 14:43
 * @description : page split result
 **/
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PageResult<T> {

    private long total;

    private List<T> rows;

}
