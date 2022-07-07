package UI;

import lianjie.log_;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public class login_ui extends JFrame {
    static String zhanghao=null;
    public static Map<String,String> init(){
        JFrame jFrame=new JFrame("毕业设计管理系统");
        jFrame.setSize(800,600);
        //jFrame.setLayout(new SpringLayout());
        //居中
        jFrame.setLocationRelativeTo(null);
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        SpringLayout springLayout=new SpringLayout();

        JPanel panel=new JPanel(springLayout);


        //jFrame.setVisible(true);

        JLabel user=new JLabel("用户名");
        JTextField user_text=new JTextField(20);
        JLabel pwd=new JLabel("密码");
        JPasswordField pwd_text=new JPasswordField(20);
        zhanghao=user_text.getText();
        //获取输入值
        Map<String,String> login_map=new HashMap<>();
        //Map<String,String> login=new HashMap<>();
//        Map<String,String> login=new HashMap<>();
//        login.put("loginName",user_text.getText());
//        System.out.println(user_text.getText());
//        login.put("loginPwd",new String(pwd_text.getPassword()));
        //获取约束
        SpringLayout.Constraints user_c= springLayout.getConstraints(user);
        SpringLayout.Constraints user_text_c= springLayout.getConstraints(user_text);
        SpringLayout.Constraints pwd_c= springLayout.getConstraints(pwd);
        SpringLayout.Constraints pwd_text_c= springLayout.getConstraints(pwd_text);
        //
        user_c.setX(Spring.constant(100));
        user_c.setY(Spring.constant(20));

        user_text_c.setConstraint(SpringLayout.WEST,Spring.sum(user_c.getConstraint(SpringLayout.EAST),Spring.constant(10)));

        user_text_c.setConstraint(SpringLayout.NORTH,user_c.getConstraint(SpringLayout.NORTH));
        //
        pwd_c.setConstraint(SpringLayout.EAST,user_c.getConstraint(SpringLayout.EAST));//东面
        pwd_c.setConstraint(SpringLayout.NORTH,Spring.sum(user_c.getConstraint(SpringLayout.SOUTH),Spring.constant(15)));//我的北离你的南

        pwd_text_c.setConstraint(SpringLayout.WEST,user_text_c.getConstraint(SpringLayout.WEST));
        pwd_text_c.setConstraint(SpringLayout.NORTH,pwd_c.getConstraint(SpringLayout.NORTH));




        JButton jb_login=new JButton("登录");
        //jb_login.setLocation(300,600);
        //获取Jbutton约束
        SpringLayout.Constraints jb_login_c= springLayout.getConstraints(jb_login);

        jb_login_c.setConstraint(SpringLayout.NORTH,Spring.sum(pwd_c.getConstraint(SpringLayout.SOUTH),Spring.constant(15)));
        jb_login_c.setConstraint(SpringLayout.EAST,Spring.sum(pwd_c.getConstraint(SpringLayout.EAST),Spring.constant(80)));

        JButton jb_register=new JButton("注册");
        SpringLayout.Constraints jb_register_c= springLayout.getConstraints(jb_register);
        jb_register_c.setConstraint(SpringLayout.NORTH,jb_login_c.getConstraint(SpringLayout.NORTH));
        jb_register_c.setConstraint(SpringLayout.WEST,Spring.sum(jb_login_c.getConstraint(SpringLayout.EAST),Spring.constant(20)));
        jb_login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Map<String,String> login_map=new HashMap<>();
//                login.put("loginName",user_text.getText());
//                System.out.println(user_text.getText());
//                login.put("loginPwd",new String(pwd_text.getPassword()));

                Map<String,String> login_map=  log_.initUI(user_text.getText(),new String(pwd_text.getPassword()));
                boolean loginSuccess= log_.login (login_map);
                if(loginSuccess==true){
                    jFrame.setVisible(false);
                    home_ui.home();
                }else if(loginSuccess==false){
                    warning();
                }
                //home_ui.home();
            }
        });

        jb_register.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                register();
            }
        });
        panel.add(jb_login);
        panel.add(jb_register);
        panel.add(user);
        panel.add(user_text);
        panel.add(pwd);
        panel.add(pwd_text);
        jFrame.add(panel);
        jFrame.setVisible(true);
        return login_map;

    }
    public static void register(){
        JFrame jf_register=new JFrame("注册页面");
        jf_register.setSize(400,500);
        //jf_register.setLayout(new);
        jf_register.setLocationRelativeTo(null);
        jf_register.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        SpringLayout springLayout=new SpringLayout();
        JPanel jPanel=new JPanel(springLayout);

        JLabel email=new JLabel("邮箱:");
        JTextField email_text=new JTextField(14);

        JLabel user=new JLabel("用户名:");
        JTextField user_text=new JTextField(14);
        JLabel pwd=new JLabel("密码:");
        JPasswordField pwd_text=new JPasswordField(14);
        JLabel verify=new JLabel("验证码:");
        JPasswordField verify_text=new JPasswordField(8);
        //获取约束
        SpringLayout.Constraints email_c= springLayout.getConstraints(email);
        SpringLayout.Constraints email_text_c= springLayout.getConstraints(email_text);
        SpringLayout.Constraints user_c= springLayout.getConstraints(user);
        SpringLayout.Constraints user_text_c= springLayout.getConstraints(user_text);
        SpringLayout.Constraints pwd_c= springLayout.getConstraints(pwd);
        SpringLayout.Constraints pwd_text_c= springLayout.getConstraints(pwd_text);
        SpringLayout.Constraints verify_c= springLayout.getConstraints(verify);
        SpringLayout.Constraints verify_text_c= springLayout.getConstraints(verify_text);

        //设置约束
        email_c.setX(Spring.constant(100));
        email_c.setY(Spring.constant(20));
        //email_c.getConstraint(SpringLayout.EAST);
        email_text_c.setConstraint(SpringLayout.WEST,Spring.sum(email_c.getConstraint(SpringLayout.EAST),Spring.constant(10)));

        email_text_c.setConstraint(SpringLayout.NORTH,email_c.getConstraint(SpringLayout.NORTH));

        user_c.setConstraint(SpringLayout.EAST,email_c.getConstraint(SpringLayout.EAST));//东面
        user_c.setConstraint(SpringLayout.NORTH,Spring.sum(email_c.getConstraint(SpringLayout.SOUTH),Spring.constant(15)));//我的北离你的南

        user_text_c.setConstraint(SpringLayout.WEST,email_text_c.getConstraint(SpringLayout.WEST));
        user_text_c.setConstraint(SpringLayout.NORTH,user_c.getConstraint(SpringLayout.NORTH));

        pwd_c.setConstraint(SpringLayout.EAST,email_c.getConstraint(SpringLayout.EAST));
        pwd_c.setConstraint(SpringLayout.NORTH,Spring.sum(user_c.getConstraint(SpringLayout.SOUTH),Spring.constant(15)));

        pwd_text_c.setConstraint(SpringLayout.WEST,email_text_c.getConstraint(SpringLayout.WEST));
        pwd_text_c.setConstraint(SpringLayout.NORTH,pwd_c.getConstraint(SpringLayout.NORTH));

        verify_c.setConstraint(SpringLayout.EAST,email_c.getConstraint(SpringLayout.EAST));
        verify_c.setConstraint(SpringLayout.NORTH,Spring.sum(pwd_c.getConstraint(SpringLayout.SOUTH),Spring.constant(15)));
        verify_text_c.setConstraint(SpringLayout.WEST,email_text_c.getConstraint(SpringLayout.WEST));
        verify_text_c.setConstraint(SpringLayout.NORTH,verify_c.getConstraint(SpringLayout.NORTH));

        //确定按钮
        JButton jButton=new JButton("确认");
        SpringLayout.Constraints jButton_c= springLayout.getConstraints(jButton);
        jButton_c.setX(Spring.constant(150));
        jButton_c.setY(Spring.constant(170));
        //添加组件
        jPanel.add(email);
        jPanel.add(email_text);
        jPanel.add(user);
        jPanel.add(user_text);
        jPanel.add(pwd);
        jPanel.add(pwd_text);
        jPanel.add(verify);
        jPanel.add(verify_text);

        jPanel.add(jButton);
        jf_register.add(jPanel);




        jf_register.setVisible(true);



    }
    public static void warning(){
        JFrame jFrame=new JFrame("waring");
        jFrame.setSize(80,60);
        //jFrame.setLayout(new SpringLayout());
        //居中
        jFrame.setLocationRelativeTo(null);
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        JLabel user=new JLabel("用户名或密码错误");
        jFrame.add(user);
        jFrame.setVisible(true);

    }






//    public static void main(String[] args) {
//
//           init();
//        //log_.login(init());
//    }
}
