package com.kaishengit.entity;

import org.junit.Test;

/**
 * Created by Administrator on 2016/6/18.
 */
public class StringTest {

    @Test
    public void stringTest() {

        String a = "abc";
        String b = a;
        System.out.println(a.toString()+":"+b.toString());

        a = "def";
        System.out.println(a+":"+b);
    }
}
