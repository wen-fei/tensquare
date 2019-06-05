package com.tensquare.spit.dao;

import com.tensquare.spit.pojo.Spit;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author : TenYun
 * @date : 2019-06-05 10:42
 * @description :
 **/
public interface SpitDao extends MongoRepository<Spit, String> {

    public Page<Spit> findByParentId(String parentid, Pageable pageable);



}
