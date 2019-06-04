package com.tensquare.base.dao;

import com.tensquare.base.pojo.Label;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author : TenYun
 * @date : 2019-06-04 15:28
 * @description : label
 **/
public interface LabelDao extends JpaRepository<Label, String>, JpaSpecificationExecutor<Label> {
}
