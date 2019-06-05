package com.tensquare.search.pojo;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;

import java.io.Serializable;

/**
 * @author : TenYun
 * @date : 2019-06-05 15:51
 * @description :
 **/
@Document(indexName="tensquare_search", type="article")
@Getter
@Setter
public class Article implements Serializable {

    @Id
    private String id;

    // 是否索引，就是看该域是否能被搜索
    // 是否分词，就表示搜索的时候是整体匹配还是单词匹配
    // 是否存储，表示是否能在页面上显示
    @Field(index = true, analyzer = "ik_max_word", searchAnalyzer = "ik_max_word")
    private String title;
    @Field(index = true, analyzer = "ik_max_word", searchAnalyzer = "ik_max_word")
    private String content;

    private String state;

}
