package lianjie;

import java.sql.*;

public class te_see {
    public static void te_select(String i){
        Connection conn=null;
        Statement stmt=null;
        ResultSet rs=null;
        String DB_URL = "jdbc:mysql://localhost:3306/gpms?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn= DriverManager.getConnection(DB_URL,"root","hkk85n5z");
            stmt= conn.createStatement();
            String sql="select  * from grade where grade.te_id=(select te_id from te where te_user='"+i+"')";
            rs= stmt.executeQuery(sql);

            System.out.print("题目");
            System.out.print("  ");
//            //System.out.print("学生账号   ");
            //System.out.print("  ");
            System.out.print("  学生姓名");
            System.out.print("  ");
//            System.out.print("意义   ");
//            System.out.print("  ");
//            System.out.print("内容    ");
//            System.out.print("  ");
//            System.out.print("技能  ");
//            System.out.print("  ");
            System.out.print("  成绩 ");
            System.out.print("  ");
            System.out.print("老师姓名  ");
            System.out.print("  ");
//            System.out.print("id  ");
//            System.out.print("  ");
            System.out.print("\n");
            





            while (rs.next()){
                String topic=rs.getString(1);
                String name=rs.getString(2);
//                String meaning=rs.getString(2);
//                String content=rs.getString(3);
//                String skill=rs.getString(4);
                String grade=rs.getString(3);
                String te_name=rs.getString(4);
//                String te_id=rs.getString(6);
//                String te_=rs.getString(7);


                System.out.print(topic);
                System.out.print("  ");
                System.out.print(name   );
                System.out.print("  ");
                System.out.print(grade    );
                System.out.print("  ");
//                System.out.print(skill  );
//                System.out.print("  ");
                System.out.print(te_name  );
                System.out.print("  ");
//                System.out.print(te_id  );
//                System.out.print("  ");
                System.out.print("\n");



            }


            rs.close();
            stmt.close();
            conn.close();


        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }



    }

}
