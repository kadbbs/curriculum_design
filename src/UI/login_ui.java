package UI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class login_ui extends JFrame {
    public static void init(){
        JFrame jFrame=new JFrame("毕业设计管理系统");
        jFrame.setSize(800,600);
        jFrame.setLayout(new SpringLayout());
        //居中
        jFrame.setLocationRelativeTo(null);
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JPanel panel=new JPanel();


        //jFrame.setVisible(true);

        JLabel user=new JLabel("用户名");
        JTextField user_text=new JTextField(20);
        JLabel pwd=new JLabel("密码");
        JPasswordField pwd_text=new JPasswordField(20);


        JButton jb_login=new JButton("登录");
        jb_login.setLocation(300,600);
        JButton jb_register=new JButton("注册");
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





    public static void main(String[] args) {
        init();
    }
}
