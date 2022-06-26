package lianjie;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;



public class log_ {

//        Map<String,String> user =initUI();
//
//        boolean loginSuccess= login (user);



        public static boolean login(Map<String, String> user){
        boolean biaoji=false;
        Connection conn=null;
        Statement stmt=null;
        ResultSet rs =null;
        //String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
        String DB_URL = "jdbc:mysql://localhost:3306/gpms?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
        //1.注册驱动
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            //2.获取连接
            conn = DriverManager.getConnection(DB_URL,"root","hkk85n5z");
            String sql="select * from stu where stu.stu_user='"+user.get("loginName")+"'and stu.stu_password='"+user.get("loginPwd")+"' ";
            //3.获取数据库操作对象
            stmt= conn.createStatement();
            //4.执行sql
            rs =stmt.executeQuery(sql);
            //5.处理结果
            if(rs.next()){
                biaoji=true;

            }



        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            //6.close
            if(rs !=null){
                try {
                    rs.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
            if(stmt !=null){
                try {
                    stmt.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
            if(conn !=null){
                try {
                    conn.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }

        return biaoji;

        //System.out.println("success");
    }

        public static Map<String, String> initUI() {
        Scanner scanner=new Scanner(System.in);
        System.out.println("用户名");
        String user=scanner.nextLine();
        System.out.println("密码");
        String password=scanner.nextLine();
        Map<String,String> login=new HashMap<>();
        login.put("loginName",user);
        login.put("loginPwd",password);
        return login;
    }

}
