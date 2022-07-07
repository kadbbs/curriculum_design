package UI;

import lianjie.select_topic;
import lianjie.insert;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class home_ui {
    public static void home(){
        JFrame jFrame=new JFrame("毕业设计管理系统");
        jFrame.setSize(800,600);
        //jFrame.setLayout(new SpringLayout());
        //居中
        jFrame.setLocationRelativeTo(null);
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //SpringLayout springLayout=new SpringLayout();

        JPanel panel=new JPanel(new BorderLayout());
        //表头
        Object[] columnNames={"课程号","课程名","意义","内容","需要技能","指导老师"};

        //
//        Object[][] rowData = {
//                {"电力系统","直观","开发","java","王老师"},
//
//        };
        Object[][] rowData=select_topic.select("a");
        //创建表格
        JTable table_stu=new JTable(rowData,columnNames);
        //设计表属性
        table_stu.setGridColor(Color.BLUE);
        table_stu.setForeground(Color.RED);
        table_stu.setShowGrid(true);
        //添加表
        panel.add(table_stu.getTableHeader(),BorderLayout.NORTH);
        panel.add(table_stu, BorderLayout.CENTER);

        //选课按钮和输入框
//        ButtonGroup buttonGroup=new ButtonGroup();
//        buttonGroup.add();
//        for(int i=0;i<rowData.length;i++){
//            JRadioButton radioButton=
//
//        }废弃
            //重新加一个中间组件
        //JPanel jPanel=new JPanel(new SpringLayout());
        JButton jButton=new JButton("确定");
        JTextField jTextField=new JTextField(5);
        JTextField jTextField1=new JTextField(5);

        //添加jbutton的事件
        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               insert.Insert(jTextField1.getText(), Integer.parseInt(jTextField.getText()));
               jTextField.setText("");
               jTextField1.setText("");
               tixing();
            }
        });


        panel.add(jButton,BorderLayout.SOUTH);
        panel.add(jTextField,BorderLayout.EAST);
        panel.add(jTextField1,BorderLayout.WEST);
        //jPanel.setVisible(true);
        //panel.add(jPanel,BorderLayout.SOUTH);
        //jFrame.add(panel);
//        jFrame.add(panel);
        //panel.add(jPanel,BorderLayout.SOUTH);
        //panel.add(jPanel,BorderLayout.SOUTH);
        jFrame.setContentPane(panel);
        //jFrame.pack();
        jFrame.setVisible(true);




    }
    public static void tixing(){
        JFrame jFrame=new JFrame("waring");
        jFrame.setSize(100,60);
        //jFrame.setLayout(new SpringLayout());
        //居中
        jFrame.setLocationRelativeTo(null);
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        JLabel user=new JLabel("选题成功");
        jFrame.add(user);
        jFrame.setVisible(true);

    }
}
