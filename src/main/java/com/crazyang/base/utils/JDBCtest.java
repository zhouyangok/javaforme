package com.crazyang.base.utils;

import java.sql.*;
import java.util.Random;

/**
 * @ClassName JDBCtest
 * @Description: 测试向数据库插入100w条数据--用时：
 * @Author zhouyang
 * @Date 2019/8/26 下午9:17.
 */

public class JDBCtest {

    public static void main(String[] args) {
       JDBCtest jdbCtest = new JDBCtest();
       jdbCtest.test();
    }
    private String url = "jdbc:mysql://101.132.146.171:3306/java2019?rewriteBatchedStatements=true";
    private String user = "root";
    private String password = "root";

    public void test(){
        Connection conn = null;
        PreparedStatement pstm =null;
        ResultSet rt = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url, user, password);
            String sql = "INSERT INTO test2019(id,name,age,address) VALUES(?,CONCAT('姓名',?),?,?)";
            pstm = conn.prepareStatement(sql);
            Long startTime = System.currentTimeMillis();
            Random rand = new Random();
            int a,b,c,d;
            for (int i = 100000; i <= 1000000; i++) {
                pstm.setInt(1, i);
                pstm.setInt(2, i);
                a = rand.nextInt(10);
                b = rand.nextInt(10);
                c = rand.nextInt(10);
                d = rand.nextInt(10);
                pstm.setString(3, i+"");
                pstm.setString(4, "xxxxxxxxxx_"+"188"+a+"88"+b+c+"66"+d);
                pstm.addBatch();
            }
            pstm.executeBatch();
            Long endTime = System.currentTimeMillis();
            System.out.println("OK,用时：" + (endTime - startTime));
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }finally{
            if(pstm!=null){
                try {
                    pstm.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                    throw new RuntimeException(e);
                }
            }
            if(conn!=null){
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
