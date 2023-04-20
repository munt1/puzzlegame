package com.lyx.text;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class MyJFrame extends JFrame implements ActionListener{
    JButton jB1 = new JButton("点我");
    JButton jB2= new JButton("点我");
    public MyJFrame() {
        this.setSize(603,680);

        this.setTitle("拼图单机版v1.0");
        //置顶
        this.setAlwaysOnTop(true);
        //居中
        this.setLocationRelativeTo(null);
        //关闭模式
        this.setDefaultCloseOperation(3);
        //取消默认布局
        this.setLayout(null);


        //创建按钮

        jB1.setBounds(0,0,100,50);
        //参数为被点击后要执行的操作
//        jB.addActionListener(new MyActionListener());
        jB1.addActionListener(this);

        jB2.setBounds(100,100,100,50);
        //参数为被点击后要执行的操作
//        jB.addActionListener(new MyActionListener());
        jB2.addActionListener(this);

        this.getContentPane().add(jB1);
        this.getContentPane().add(jB2);


        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        Object source = e.getSource();

        if (source == jB1){
            jB1.setSize(200,20);

        }else if (source == jB2){
            Random random = new Random();
            jB2.setLocation(random.nextInt(400), random.nextInt(400));
        }
    }
}
