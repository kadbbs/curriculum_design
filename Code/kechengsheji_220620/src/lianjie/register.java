package lianjie;


import java.sql.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;



public class register {
    public static void main(String[] args) throws ClassNotFoundException {
        //Class.forName("com.mysql.jdbc.Driver");
        System.out.println("注册您的账户");
        System.out.println();
        Scanner scanner=new Scanner(System.in);

        System.out.println("用户名（6个字母以内）");
        String user=scanner.nextLine();
        System.out.println("姓名");
        String name=scanner.nextLine();

        System.out.println("密码（纯数字）");
        int password=scanner.nextInt();

//        System.out.println("姓名");
//        String name=scanner.nextLine();

        System.out.println("学号");
        int number=scanner.nextInt();
       // Map<String,String> user =initUI();

       // boolean loginSuccess= login (user);
        login (user,password,name,number);
        //System.out.println(loginSuccess);
    }

    public static void login(String user,int pwd,String name,int number){
        //boolean biaoji=false;
        Connection conn=null;
        Statement stmt=null;
        ResultSet rs_select =null;
        //String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
        //int password=123;
        String DB_URL = "jdbc:mysql://localhost:3306/gpms?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
        //1.注册驱动
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            //2.获取连接
            conn = DriverManager.getConnection(DB_URL,"root","hkk85n5z");
            //String sql="select * from stu_login where loginame='"+user.get("loginName")+"'and loginpwd='"+user.get("loginPwd")+"' ";
            //String sql="insert into stu_login (loginame,loginpwd)values ('ertweq',123456)";
            String sql="insert into stu(stu_user,stu_password,stu_name,stu_number) values ('"+user+"',"+pwd+",'"+name+"',"+number+")";
            String sql_select="select stu_user from stu";
            //3.获取数据库操作对象
            stmt= conn.createStatement();
            //4.执行sql
            //int rs =stmt.executeUpdate(sql);
            rs_select=stmt.executeQuery(sql_select);
            //5.处理结果
            boolean bool=true;
            int rs=-1;
                //判断重名
            while (rs_select.next()){
                String usename = rs_select.getString(1);
                if(user.equals(usename)){
                    bool=false;
                }


            }
            if(bool==true){
                rs =stmt.executeUpdate(sql);
            }else {
                System.out.println("用户名重复");
            }









            if (rs==1){
                System.out.println("注册成功");
            }else {
                System.out.println("注册失败");
            }





//            if(rs.next()){
//                biaoji=true;
//
//            }
//            while (rs.next()){
//                String name=rs.getString(1);
//                String pwd=rs.getString(2);
//                System.out.print(name);
//                System.out.print(" ");
//                System.out.println(name);
//
//            }


        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            //6.close
//            if(rs !=null){
//                try {
//                    rs.close();
//                } catch (SQLException e) {
//                    throw new RuntimeException(e);
//                }
//            }
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

        //return biaoji;

        //System.out.println("success");
    }

//    private static Map<String, String> initUI() {
//        Scanner scanner=new Scanner(System.in);
//        System.out.println("用户名");
//        String user=scanner.nextLine();
//        System.out.println("密码");
//        String password=scanner.nextLine();
//        Map<String,String> login=new HashMap<>();
//        login.put("loginName",user);
//        login.put("loginPwd",password);
//        return login;
//    }

}