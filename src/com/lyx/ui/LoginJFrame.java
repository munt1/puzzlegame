package com.lyx.ui;

import javax.swing.*;

public class LoginJFrame extends JFrame {
    //登录
    public LoginJFrame(){
        this.setSize(488,430);
        this.setVisible(true);
        this.setTitle("登录");
        //置顶
        this.setAlwaysOnTop(true);
        //居中
        this.setLocationRelativeTo(null);
        //关闭模式
        this.setDefaultCloseOperation(3);
    }
}
