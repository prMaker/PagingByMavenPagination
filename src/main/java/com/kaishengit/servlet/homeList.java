package com.kaishengit.servlet;

import com.kaishengit.entity.Movie;
import com.kaishengit.entity.Page;
import com.kaishengit.service.MovieService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import org.apache.commons.lang3.StringUtils;

/**
 * Created by Administrator on 2016/6/17.
 */
@WebServlet("/home")
public class homeList extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String pagesize = req.getParameter("p");
        int p = 1;
        if (StringUtils.isNumeric(pagesize)) {
            p = Integer.parseInt(pagesize);
        }
        MovieService movieService = new MovieService();
        Page page = movieService.getPage(p);
        req.setAttribute("page",page);
        req.getRequestDispatcher("/WEB-INF/views/home.jsp").forward(req,resp);
    }
}
