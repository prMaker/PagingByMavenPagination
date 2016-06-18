package com.kaishengit.service;

import com.kaishengit.dao.MovieDao;
import com.kaishengit.entity.Movie;
import com.kaishengit.entity.Page;

import java.util.List;

/**
 * Created by Administrator on 2016/6/17.
 */
public class MovieService {

    MovieDao movieDao = new MovieDao();

    public Page getPage(int pageNO) {
        Page page = new Page(10,pageNO,movieDao.getCount().intValue());

        List<Movie> movieList= movieDao.findByPage(page.getStart(),page.getSize());
        page.setItems(movieList);

        return page;


//        int size = 10;
//
//        int totalSize = movieDao.getCount().intValue();
//        int totalPageSize = totalSize / size;
//        if (totalSize % size != 0) {
//            totalPageSize++;
//        }
//        if (pageNO > totalPageSize) {
//            pageNO = totalPageSize;
//        }
//        int start = (pageNO - 1) * size;
//        return movieDao.findByPage(start, size);
    }
}
