package com.jack.java.maven.day04;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.*;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/*
    操作数据库
 */
public class JDBCDemo1 {
    public static void main(String[] args) {
        // "?"：代表占位符
        String sql = "select regname,leaveamount from member where mobilephone=? and id=?";
        String[][] values = {{"17501621127"}};
        Map<String,Object> columnLabelAndValues1 = JDBCUtil.query(sql,values);
        Set<String> colunLabels = columnLabelAndValues1.keySet();
        for (String columLabel:colunLabels){
            System.out.println(columLabel+columnLabelAndValues1.get(columLabel));
        }

    }


}
