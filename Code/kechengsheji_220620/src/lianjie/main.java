package lianjie;

import java.util.Map;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
//        Scanner s =new Scanner(System.in);
//        String l=s.nextLine();
//        System.out.println(l);
//        int r=Integer.parseInt(l);
//        System.out.println(r);
        System.out.println("学生输入1，老师输入2,学院输入3");
        Scanner scanner=new Scanner(System.in);
        int g=scanner.nextInt();
        if(g==1){
        Map<String,String> user =log_.initUI();

        boolean loginSuccess= log_.login (user);
        System.out.println("可选课程");
        select_topic.select();//无参数不包含学生信息
        System.out.println("请输入你想要选题id的编号");
        Scanner sc_1=new Scanner(System.in);
//        String a=sc.nextLine();
//        String b=sc.nextLine();
        int c=sc_1.nextInt();
        insert.Insert(user.get("loginName"),c);
        select_topic.select(1);
        }else if(g==2) {
            System.out.println("老师");
            Map<String,String> user =log.initUI();

            boolean loginSuccess= log.login (user);//返回true能登录，false不能登录
            if(loginSuccess==true) {
                System.out.println("选您课题的学生");
//            Scanner sc_2=new Scanner(System.in);
////        String a=sc.nextLine();
////        String b=sc.nextLine();
//            int c=sc_2.nextInt();
                te_see.te_select(user.get("loginName"));
            }else {
                System.out.println("登入错入，请您重试");
            }


        }else if(g==3){
            co_see.co_select();
        }




    }
}
