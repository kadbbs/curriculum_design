package lianjie;

import java.sql.*;

public class select_topic {

    public static void select(){
        Connection conn=null;
        Statement stmt=null;
        ResultSet rs=null;
        String DB_URL = "jdbc:mysql://localhost:3306/gpms?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn= DriverManager.getConnection(DB_URL,"root","hkk85n5z");
            stmt= conn.createStatement();
            String sql="select topic.top_name,topic.meaning,topic.content,topic.skill,te.te_name,topic.te_id\n" +
                    "from te,topic\n" +
                    "where te.te_id=topic.te_id";
            rs= stmt.executeQuery(sql);

            System.out.print("题目");
            System.out.print("  ");
//            System.out.print("学生账号   ");
//            System.out.print("  ");
//            System.out.print("学生姓名    ");
//            System.out.print("  ");
            System.out.print("意义   ");
            System.out.print("  ");
            System.out.print("内容    ");
            System.out.print("  ");
            System.out.print("技能  ");
            System.out.print("  ");
            System.out.print("老师姓名  ");
            System.out.print("  ");
            System.out.print("id  ");
            System.out.print("  ");
            System.out.print("\n");






            while (rs.next()){
                String name=rs.getString(1);
                String meaning=rs.getString(2);
                String content=rs.getString(3);
                String skill=rs.getString(4);
                String te_name=rs.getString(5);
                String te_id=rs.getString(6);


                System.out.print(name);
                System.out.print("  ");
                System.out.print(meaning   );
                System.out.print("  ");
                System.out.print(content    );
                System.out.print("  ");
                System.out.print(skill  );
                System.out.print("  ");
                System.out.print(te_name  );
                System.out.print("  ");
                System.out.print(te_id  );
                System.out.print("  ");
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



    public static void select(int i){
        Connection conn=null;
        Statement stmt=null;
        ResultSet rs=null;
        String DB_URL = "jdbc:mysql://localhost:3306/gpms?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn= DriverManager.getConnection(DB_URL,"root","hkk85n5z");
            stmt= conn.createStatement();
            //String sql="select * from topic";
            String sql="select topic.top_name,topic.stu_user,topic.stu_name,topic.meaning,topic.content,topic.skill,te.te_name,topic.te_id\n" +
                    "from te,topic\n" +
                    "where te.te_id=topic.te_id";
            rs= stmt.executeQuery(sql);


            System.out.print("题目");
            System.out.print("  ");
            System.out.print("学生账号   ");
            System.out.print("  ");
            System.out.print("学生姓名    ");
            System.out.print("  ");
            System.out.print("意义   ");
            System.out.print("  ");
            System.out.print("内容    ");
            System.out.print("  ");
            System.out.print("技能  ");
            System.out.print("  ");
            System.out.print("老师姓名  ");
            System.out.print("  ");
            System.out.print("id  ");
            System.out.print("  ");
            System.out.print("\n");









            while (rs.next()){
                String name=rs.getString(1);
                String stu_user=rs.getString(2);
                String stu_name=rs.getString(3);
                String meaning=rs.getString(4);
                String content=rs.getString(5);
                String skill=rs.getString(6);
                String te_name=rs.getString(7);
                String te_id=rs.getString(8);


                System.out.print(name);
                System.out.print("  ");
                System.out.print(stu_user  );
                System.out.print("  ");
                System.out.print(stu_name  );
                System.out.print("  ");
                System.out.print(meaning   );
                System.out.print("  ");
                System.out.print(content    );
                System.out.print("  ");
                System.out.print(skill  );
                System.out.print("  ");
                System.out.print(te_name  );
                System.out.print("  ");
                System.out.print(te_id  );
                System.out.print("  ");
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
