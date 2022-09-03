package com.jack.java.maven.day04;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class JDBCUtil {
    public static Properties properties = new Properties();

    static {
        InputStream iStream = null;
        try {
            iStream = new FileInputStream(new File("src/test/resources/jdbc.properties"));
            properties.load(iStream);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 根据 sql 查询表数据，并以 map 返回，key为字段名，value为子墩值
     * @param sql 要执行的查询语句
     * @param values 条件字段的值
     * @return
     */
    public static Map<String, Object> query(String sql, String[][]... values) {
        // object ... values ：三个点代表可变参数
//        String url = "";
//        String user = "";
//        String password = "";
        Map<String, Object> columnLablelAndValues = null;
        try {
            // 1）根据连接信息，获得数据库连接（连上数据库）；
            Connection connection = getConnection();
            //2）获取 PreparedStatement 对象（此类型的对象有提供数据库操作方法）；
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            //    3）设置条件字段的值，填充 ？占位符的内容；
            for (int i = 0; i < values.length; i++) {
                for (int j = 0; j < values[i].length; j++) {
                    preparedStatement.setObject(j + 1, values[i][j]);
                }
            }
            //    4）调用查询方法，执行查询，返回 ResultSet（结果集）；
            ResultSet resultSet = preparedStatement.executeQuery();
            // 获取查询相关信息
            ResultSetMetaData metadata = resultSet.getMetaData();
            // 得到查询字段的数目
            int columCount = metadata.getColumnCount();
            //    5）从结果集取查询数据
            columnLablelAndValues = new HashMap<String, Object>();
            while (resultSet.next()) {
                // 循环取出每个查询字段的数据
                for (int i = 1; i <= columCount; i++) {
                    String columLable = metadata.getColumnLabel(i);
                    String columnValue = resultSet.getObject(columLable).toString();
                    System.out.println(columnValue);
                    columnLablelAndValues.put(columLable, columnValue);
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return columnLablelAndValues;
    }

    //获取数据库连接
    public static Connection getConnection() throws SQLException {
        String url = properties.getProperty("jdbc.url");
        String user = properties.getProperty("jdbc.username");
        String password = properties.getProperty("jdbc.password");
        Connection connection = DriverManager.getConnection(url, user, password);
        return connection;
    }
}
