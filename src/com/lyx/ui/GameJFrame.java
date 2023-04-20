package com.lyx.ui;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

public class GameJFrame extends JFrame implements KeyListener {
    //步数
    int step = 0 ;

    int win[][]=new int[][] {
        {1,2,3,4,5},
        {6,7,8,9,10},
        {11,12,13,14,15},
        {16,17,18,19,20},
        {21,22,23,24,0}
    };
    //创建一个二维数组管理数据

    int [][] data = new int[6][6];
    //游戏主界面
    public GameJFrame() {
        initJFrame();

        //初始化菜单
        initJMenuBar();

        //初始化数据（打乱）
        initDate();

        //初始化图片
        initImage();


        this.setVisible(true);
    }
    //定义一个对象，记录当前展示图片位置
    String path = "D:\\IDEASPACE\\puzzlegame\\image\\katomegumi\\";
    //记录空白方块在二维数组中的位置
    int x = 0;
    int y = 0;
    //初始化数据
    private void initDate() {
        int[] tempArr = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24};
        Random r = new Random();
        for (int i = 0; i < tempArr.length; i++) {
            //获得随机索引
            int index = r.nextInt(tempArr.length);
            //拿着遍历得到的每个数据，跟随机索引上的数据交换
            int temp = tempArr[i];
            tempArr[i] = tempArr[index];
            tempArr[index] = temp;
        }
        //遍历一维数组tempArr得到每一个元素，把每一个元素依次添加到二维数组中
        for (int i = 0; i < tempArr.length; i++) {
            if (tempArr[i] == 0){
                x = i / 5;
                y = i % 5;
            }else if (tempArr[i] !=0){
                data [ i / 5 ][ i % 5 ] = tempArr [ i ];
            }

        }
    }

    private void initImage() {

        this.getContentPane().removeAll();

        //判断是否是正确的图像
        if (victory()) {
            JLabel winJ = new JLabel(new ImageIcon(path + "3.jpg"));
            winJ.setBounds(203,283,197,73);
            this.getContentPane().add(winJ);
        }

        //计数器
        JLabel stepCount = new JLabel("步数："  +  step);
        stepCount.setBounds(50,30,100,20);
        this.getContentPane().add(stepCount);




        //设置拼图
        for (int i = 0; i < 5; i++) {

            for (int j = 0; j < 5; j++) {
                //获取当前要加载图片的序号
                int number = data[i][j];
                //创建一个ImageIcon对象
                //创建一个JLabel的对象（管理容器）
                JLabel jLabel = new JLabel(new ImageIcon(path + number +".jpg"));
                //指定位置
                jLabel.setBounds(105*j + 30,105*i + 40,105,105);
                //给图片添加边框
                jLabel.setBorder(new BevelBorder(1));
                //把管理容器添加到界面中
                this.getContentPane().add(jLabel);

            }
        }
        //设置背景
        JLabel backGround = new JLabel(new ImageIcon(path + "\\background\\.jpg"));
        backGround.setBounds(0,0,1000,1000);
        this.getContentPane().add(backGround);

        this.getContentPane().repaint();



    }


    private void initJMenuBar() {
        JMenuBar jMenuBar = new JMenuBar();
        //创建上方菜单对象
        JMenu functionJMenu = new JMenu("功能");
        JMenu aboutJMenu = new JMenu("关于");
        //创建菜单子条目
        JMenuItem replayItem = new JMenuItem("restart");
        JMenuItem reLoginItem = new JMenuItem("reLogin");
        JMenuItem closeItem = new JMenuItem("close");

        JMenuItem accountItem = new JMenuItem("account");
        //将每个子条目加入对应选项中
        functionJMenu.add(replayItem);
        functionJMenu.add(reLoginItem);
        functionJMenu.add(closeItem);

        aboutJMenu.add(accountItem);
//将菜单对象加入上方菜单中
        jMenuBar.add(functionJMenu);
        jMenuBar.add(aboutJMenu);

        //给整个界面设置菜单
        this.setJMenuBar(jMenuBar);
    }

    private void initJFrame() {
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
        //整个屏幕的键盘监听器
        this.addKeyListener(this);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    //按下
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == 65 ) {
            this.getContentPane().removeAll();
            JLabel all = new JLabel(new ImageIcon(path + "2.jpg"));
            all.setBounds(0,0,200,200);
            this.getContentPane().add(all);

            JLabel background = new JLabel(new ImageIcon(path + "background.jpg"));
            background.setBounds(40,40,508,560);
            this.getContentPane().add(background);
            //刷新页面
            this.getContentPane().repaint();
        }
    }

    @Override
    //松开
    public void keyReleased(KeyEvent e) {
        //如果游戏胜利，不能继续移动代码
        if (victory()) {
            //1.返回结果 2.结束方法
            return;
        }
        //对上下左右进行判断
        //左37，上38，右39，下40

        int code = e.getKeyCode();
        System.out.println(code);
         if (code ==37) {
            System.out.println("向左移动");
            if (y == 4){
                return;
            }
            //x,y表示空白，x,y+1表示右边
            data[x][y] = data[x][y+1];
            data[x][y+1] = 0;
            y++;
            step++;

             //调用方法按最新的数字加载图片
            initImage();
        }
        else if (code ==38) {
            System.out.println("向上移动");
            if(x == 4){
                return;
            }
            //x,y表示空白，x+1，y表示下方
            data[x][y] = data[x+1][y];
            data[x+1][y] = 0;
            x++;
             step++;

             //调用方法按最新的数字加载图片
            initImage();
        }
        else if (code ==39) {
            System.out.println("向右移动");
            if(y == 0 ) {
                return;
            }
            //x,y表示空白，x,y-1表示左边
            data[x][y] = data[x][y-1];
            data[x][y-1] = 0;
            y--;
             step++;

             //调用方法按最新的数字加载图片
            initImage();
        }
        else if (code ==40) {
            System.out.println("向下移动");
            if (x == 0) {
                return;
            }
            //x,y表示空白，x-1，y表示上方
            data[x][y] = data[x-1][y];
            data[x-1][y] = 0;
            x--;
            step++;
            //调用方法按最新的数字加载图片
            initImage();

        }
        else if (code == 65) {
            initImage();
         }

        //按U
        else if (code == 85) {
            data = new int[][] {
                    {1,2,3,4,5},
                    {6,7,8,9,10},
                    {11,12,13,14,15},
                    {16,17,18,19,20},
                    {21,22,23,24,0}
            };
            initImage();
        }
    }

    public boolean victory() {
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                if (data[i][j] != win[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}
