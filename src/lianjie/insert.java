package lianjie;

import java.sql.*;

public class insert {
    public static void Insert(String user_,int i)
    {
        Connection conn=null;
        Statement stmt=null;
        ResultSet rs=null;
        String DB_URL = "jdbc:mysql://localhost:3306/gpms?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn= DriverManager.getConnection(DB_URL,"root","hkk85n5z");
            stmt= conn.createStatement();
            //System.out.println("请输入你的xx");

            String sql_in="select stu_user,stu_name from stu";


            //String sql="update topic set te_user='"+user+"',te_name='"+name+"' where topic.te_id="+i+"";

            //String sql_select="select * from topic";
            //stmt=conn.createStatement();
            rs=stmt.executeQuery(sql_in);




            //rs.next();
            String user=null;
            String name=null;

            while (rs.next()){
                user=rs.getString(1);
                name=rs.getString(2);
                //user_为当前登录账号
                if(user_.equals(user)){
//                    user=rs.getString(1);
//                    //System.out.println(user);
//                    name=rs.getString(2);
                    break;

                }


            }






            String sql="update topic set stu_user='"+user+"',stu_name='"+name+"' where topic.te_id="+i+"";
            int shu=stmt.executeUpdate(sql);//返回影响行
            //rs = stmt.executeQuery(sql_select);








        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
