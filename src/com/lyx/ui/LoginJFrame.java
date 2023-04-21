package com.lyx.ui;

import javax.swing.*;

public class LoginJFrame extends JFrame {
    //登录
    public LoginJFrame(){
        //登录主界面
        initLoginJFrame();
        //登录界面样式
        initLoginImage();

        this.setVisible(true);
    }

    private void initLoginImage() {
        //开始先重置
        this.getContentPane().removeAll();


        //创建文本用JLabel

        JLabel loginJLabel = new JLabel("");


        //背景
        JLabel bgJLabel = new JLabel(new ImageIcon("D:\\IDEASPACE\\puzzlegame\\image\\background\\bg.jpg"));
        //用户名
        JLabel accJLabel = new JLabel(new ImageIcon("D:\\IDEASPACE\\puzzlegame\\image\\katomegumi1\\1.jpg"));
        //密码
        JLabel pwJLabel = new JLabel(new ImageIcon("D:\\IDEASPACE\\puzzlegame\\image\\katomegumi1\\1.jpg"));
        //验证码
        JLabel yzJLabel = new JLabel(new ImageIcon("D:\\IDEASPACE\\puzzlegame\\image\\katomegumi1\\1.jpg"));
        //验证码显示框


        //按钮
        JButton loginButton = new JButton();
        loginButton.setText("登录");
        loginButton.setBounds(170,400,60,60);
        JButton zhuCeButton = new JButton();
        zhuCeButton.setText("注册");
        zhuCeButton.setBounds(170,465,60,60);

        JButton yzmButton = new JButton();
        yzmButton.setText("刷新验证码");
        yzmButton.setBounds(170,530,60,60);



        //图片参数
        setBounds(bgJLabel, accJLabel, pwJLabel, yzJLabel);


        //用户名输入框
        JTextField accName = new JTextField("输入用户名",2);
        accName.setBounds(140,140,100,20);
        //密码
        JPasswordField passWord = new JPasswordField("输入密码",2);
        passWord.setBounds(140,170,100,20);
        //验证码(输入框和显示验证码框)
        String str = "20";
            //输入框
        JTextField yzm = new JTextField("输入验证码",2);
        yzm.setBounds(140,200,70,20);
            //验证码框
        JTextField yan = new JTextField("str",2);
        yan.setBounds(220,200,20,20);



        //登录、注册





        //给容器添加子对象

        loginJLabelADD(loginJLabel, accJLabel, pwJLabel, yzJLabel, accName, passWord, yzm , bgJLabel , yan ,loginButton ,
                zhuCeButton , yzmButton);

        //给界面添加容器
        this.getContentPane().add(loginJLabel);




        //刷新界面
        this.repaint();

















    }

    private void loginJLabelADD(JLabel loginJLabel, JLabel accJLabel, JLabel pwJLabel, JLabel yzJLabel, JTextField accName, JPasswordField passWord, JTextField yzm, JLabel bgJLabel, JTextField yan, JButton loginButton, JButton zhuCeButton, JButton yzmButton) {
        loginJLabel.add(accName);
        loginJLabel.add(accJLabel);
        loginJLabel.add(passWord);
        loginJLabel.add(pwJLabel);
        loginJLabel.add(yzm);
        loginJLabel.add(yzJLabel);
        loginJLabel.add(yan);
        loginJLabel.add(loginButton);
        loginJLabel.add(zhuCeButton);
        loginJLabel.add(yzmButton);
        loginJLabel.add(bgJLabel);
    }

    private void setBounds(JLabel bgJLabel, JLabel accJLabel, JLabel pwJLabel, JLabel yzJLabel) {
        accJLabel.setBounds(118,140,20,20);
        pwJLabel.setBounds(118,170,20,20);
        yzJLabel.setBounds(118,200,20,20);
        bgJLabel.setBounds(0,0,600,600);
    }



    private void initLoginJFrame() {
        this.setSize(400,600);
        this.setVisible(true);
        this.setTitle("登录");
        //置顶
        this.setAlwaysOnTop(true);

        //居中
        this.setLocationRelativeTo(null);
        //关闭模式
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }


}
