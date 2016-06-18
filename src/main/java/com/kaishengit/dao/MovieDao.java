package com.kaishengit.dao;

import com.kaishengit.entity.Movie;
import com.kaishengit.utils.DbHelp;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.util.List;

/**
 * Created by Administrator on 2016/6/17.
 */
public class MovieDao {

    public List<Movie> findAll(){
        String sql = "select * from `movie`";
        return DbHelp.queryUser(sql,new BeanListHandler<>(Movie.class));
    }

    public List<Movie> findByPage(Integer start,Integer size){
        String sql ="select * from `movie` limit ?,?";
        return DbHelp.queryUser(sql,new BeanListHandler<>(Movie.class),start,size);
    }

    public Long getCount() {
        String sql = "select count(*) from `movie`";
        return DbHelp.queryUser(sql,new ScalarHandler<Long>());
    }
}
