package lianjie;

import java.sql.*;
import java.util.ResourceBundle;

public class JDBC_ {
    // MySQL 8.0 以下版本 - JDBC 驱动名及数据库 URL
    //static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    //static final String DB_URL = "jdbc:mysql://localhost:3306/RUNOOB";

    // MySQL 8.0 以上版本 - JDBC 驱动名及数据库 URL
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/homework?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";

    static ResourceBundle bundle= ResourceBundle.getBundle("peizhi");

    // 数据库的用户名与密码，需要根据自己的设置
    //static final String USER = "root";
    //static final String PASS = "hkk85n5z";
    static final String USER= bundle.getString("USER");
    static final String PASS= bundle.getString("PASS");

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        try{
            // 1.注册 JDBC 驱动
            Class.forName(JDBC_DRIVER);
            // 2.注册 JDBC 驱动
            //DriverManager.registerDriver(new com.mysql.jdbc.Driver());

            // 打开链接,创建连接
            System.out.println("连接数据库...");
            //public abstract boolean isOpen()
            conn = DriverManager.getConnection(DB_URL,USER,PASS);

            // 执行查询
            //数据库 Connection.createStatement() 方法用于创建一个 Statement 对象，封装 SQL 语句发送给数据库，通常用来执行不带参数的 SQL 语句。
            System.out.println(" 实例化Statement对象...");
            stmt = conn.createStatement();
            String sql;
            //sql = "SELECT * FROM websites";
            sql = "SELECT * FROM spj";
            ResultSet rs = stmt.executeQuery(sql);
            //stmt.executeUpdata(sql);(实现insert delete updata)
            while(rs.next()){
                // 通过字段检索，列名为查询结果集的列名
//                String id  = rs.getString("SNO");
//                String name = rs.getString("PNO");
//                String url = rs.getString("JNO");
//                int Q = rs.getInt("QTY");
                //JDBC的所有下标从1开始，1，2，3，4是第几列
                String id  = rs.getString(1);
                String name = rs.getString(2);
                String url = rs.getString(3);
                int Q = rs.getInt(4);
                // 输出数据
                System.out.print(id);
                System.out.print("  ");
                System.out.print(name   );
                System.out.print("  ");
                System.out.print(url    );
                System.out.print("  ");
                System.out.print(Q  );
                System.out.print("  ");
                System.out.print("\n");
            }

            // 展开结果集数据库
//            while(rs.next()){
//                // 通过字段检索
//                int id  = rs.getInt("id");
//                String name = rs.getString("name");
//                String url = rs.getString("url");
//
//                // 输出数据
//                System.out.print("ID: " + id);
//                System.out.print(", 站点名称: " + name);
//                System.out.print(", 站点 URL: " + url);
//                System.out.print("\n");
//            }
            // 完成后关闭
            rs.close();
            stmt.close();
            conn.close();
        }catch(SQLException se){
            // 处理 JDBC 错误
            se.printStackTrace();
        }catch(Exception e){
            // 处理 Class.forName 错误
            e.printStackTrace();
        }finally{
            // 关闭资源
            try{
                if(stmt!=null) stmt.close();
            }catch(SQLException se2){
            }// 什么都不做
            try{
                if(conn!=null) conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }
        }
        System.out.println("Goodbye!");
    }
}
