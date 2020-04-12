package com.test;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author: songqiang
 * @Description :
 * @Date : Create in 2020/4/12 9:28
 * @Modified :
 **/
@SpringBootTest
public class TestDe {

    @Test
    public void testA(){
        String str = "请出示你的证件{card},1234,please check your {name}";
        //*-0或者多 +-1或者多 ?-0或者1 {n,m}-n至m []选择  ()-分组 \\d-Java转义匹配数字 \\w
        String regex = "\\d+";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str);
        boolean b = matcher.find();
        System.out.println(b);
        String group = matcher.group();

    }
}
