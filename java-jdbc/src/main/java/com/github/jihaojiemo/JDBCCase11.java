package com.github.jihaojiemo;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Description: 多参数的情况
 * Author: admin
 * Create: 2019-07-02 7:56
 */
public class JDBCCase11 {

    public static List<MemoGroup> queryMemoGroup(String...names) {//可变参数

        List<MemoGroup> data = new ArrayList<>();

        if (names.length == 0) {
            return data;
        }

        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://127.0.0.1:4406/memo?user=root&password=jhj52000&useSSL=false";
            connection = DriverManager.getConnection(url);

            StringBuilder sb = new StringBuilder();
            sb.append("select id,name,created_time,modify_time from memo_group where name in(");
            for (int i = 0; i < names.length; i++) {
                sb.append("?,");
            }
            sb.setLength(sb.length() - 1);//多了一个逗号
            sb.append(")");
            statement = connection.prepareStatement(sb.toString());

            for (int i = 0; i < names.length; i++) {
                statement.setString(i + 1, names[i]);
            }

            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                LocalDateTime createdTime = resultSet.getTimestamp("created_time").toLocalDateTime();
                LocalDateTime modifyTime = resultSet.getTimestamp("modify_time").toLocalDateTime();

                MemoGroup memoGroup = new MemoGroup();
                memoGroup.setId(id);
                memoGroup.setName(name);
                memoGroup.setCreatedTime(createdTime);
                memoGroup.setModifyTime(modifyTime);

                data.add(memoGroup);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return data;
    }

    public static void main(String[] args) {

        List<MemoGroup> memoGroups = queryMemoGroup("C++", "default", "Java");
        for (MemoGroup memoGroup : memoGroups) {
            System.out.println(memoGroup);
        }
    }
}