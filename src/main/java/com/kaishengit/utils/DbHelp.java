package com.kaishengit.utils;

import com.kaishengit.exception.DataAccessException;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;

import java.sql.SQLException;

/**
 * Created by Administrator on 2016/6/9.
 */
public class DbHelp {

    public static void updateUser(String sql,Object...params){
        QueryRunner queryRunner = new QueryRunner(ConnectionManager.getDataSource());
        try {
            queryRunner.update(sql,params);
        } catch (SQLException e) {
            throw new DataAccessException("执行"+sql+"异常",e);
        }
    }

    public static <T> T queryUser(String sql , ResultSetHandler<T> rsh, Object...params) {
        QueryRunner queryRunner = new QueryRunner(ConnectionManager.getDataSource());
        try {
            return (T) queryRunner.query(sql, rsh, params);
        } catch (SQLException e) {
            throw new DataAccessException("执行"+sql+"异常", e);
        }
    }
}
