package com.lyx.text;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MyJFrame3 extends JFrame implements KeyListener {
    public MyJFrame3(){
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

        //给整个窗口添加键盘监听
        this.addKeyListener(this);













        this.setVisible(true);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println("an xia bu song");
    }

    @Override
    public void keyReleased(KeyEvent e) {
        System.out.println("song kai");
        int code = e.getKeyCode();
        if(code == 65){
            System.out.println("A");

        }else if (code == 66) {
            System.out.println("B");
        }
    }
}
