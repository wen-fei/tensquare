package com.tensquare.qa.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.tensquare.qa.pojo.Problem;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * 数据访问接口
 * @author Administrator
 *
 */
public interface ProblemDao extends JpaRepository<Problem,String>,JpaSpecificationExecutor<Problem>{
    /**
     *  jpa生成只支持单表的，多表联合查询的需要自己写sql语句
     */


    /**
     * nativeQuery = true 则前面value值可以是sql语句。不指定默认是HQL
     * @return
     */
    @Query(value = "select * from tb_problem, tb_pl where id = problemid and labelid=? order by replytime desc ", nativeQuery = true)
    public Page<Problem> newlist(String labelid, Pageable pageable);

    @Query(value = "select * from tb_problem, tb_pl where id = problemid and labelid=? order by reply desc ", nativeQuery = true)
    public Page<Problem> hotlist(String labelid, Pageable pageable);

    @Query(value = "select * from tb_problem, tb_pl where id = problemid and labelid=? and reply=0 order by createtime desc ", nativeQuery = true)
    public Page<Problem> waitlist(String labelid, Pageable pageable);
}
