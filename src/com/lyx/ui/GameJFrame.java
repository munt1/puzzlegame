package com.lyx.ui;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

public class GameJFrame extends JFrame implements KeyListener, ActionListener {
    //创建菜单子条目
    JMenuItem changeItem = new JMenuItem("changeImage");
    JMenuItem replayItem = new JMenuItem("restart");
    JMenuItem reLoginItem = new JMenuItem("reLogin");
    JMenuItem closeItem = new JMenuItem("close");
    //创建关于账号
    JMenuItem accountItem = new JMenuItem("account");

    //创建关于更换图片对象,用于更换游戏
    JMenuItem megumi1 = new JMenuItem("megumi1");
    JMenuItem megumi2 = new JMenuItem("megumi2");
    JMenuItem megumi3 = new JMenuItem("megumi3");



    //步数
    int step = 0 ;

    int win [][]=new int [][] {
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
            }//此处的else if会导致后边实现replay时候出现空白格不会传递覆盖的BUG，所以
            //应该让整个二维数组被覆盖即可

                data [ i / 5 ][ i % 5 ] = tempArr [ i ];


        }
    }

    private void initImage() {

        this.getContentPane().removeAll();

        //判断是否是正确的图像
        if (victory()) {
            JLabel winJ = new JLabel(new ImageIcon("D:\\IDEASPACE\\puzzlegame\\image\\background\\true.jpg"));
            winJ.setBounds(200,200,400,400);
            this.getContentPane().add(winJ);
        }

        //计数器
        JLabel stepCount = new JLabel("步数："  +  step);

        stepCount.setBounds(30,30,200,50);
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
                jLabel.setBounds(120*j + 100,120*i + 100,120,120);
                //给图片添加边框
                jLabel.setBorder(new BevelBorder(BevelBorder.RAISED));
                //把管理容器添加到界面中
                this.getContentPane().add(jLabel);

            }
        }
        //设置背景
        JLabel backGround = new JLabel(new ImageIcon("D:\\IDEASPACE\\puzzlegame\\image\\background\\bg.jpg"));
        backGround.setBounds(0,0,800,900);
        this.getContentPane().add(backGround);
        this.getContentPane().repaint();



    }


    private void initJMenuBar() {
        JMenuBar jMenuBar = new JMenuBar();
        //创建上方菜单对象
        JMenu functionJMenu = new JMenu("功能");
        JMenu aboutJMenu = new JMenu("关于");
        //JMenu 中可以再次嵌套多个JMenu。
        JMenu changeJMenu = new JMenu("changeImage");

        changeJMenu.add(megumi1);
        changeJMenu.add(megumi2);
        changeJMenu.add(megumi3);



        //给条目绑定事件，让按钮条目能够实现对应功能
        //过程中，为了实现按钮功能，首先需要准备好动作监听（准备好相应接口），然后给按钮创建对象，并把对象和接口监听事件
        //绑定，重写接口中的方法，然后调用方法。
        replayItem.addActionListener(this);
        reLoginItem.addActionListener(this);
        closeItem.addActionListener(this);
        accountItem.addActionListener(this);


        //将每个子条目加入对应选项中
        functionJMenu.add(replayItem);
        functionJMenu.add(reLoginItem);
        functionJMenu.add(closeItem);
        //添加更换图片菜单
        functionJMenu.add(changeJMenu);

        //添加关于账号菜单
        aboutJMenu.add(accountItem);
        //将菜单对象加入上方菜单中
        jMenuBar.add(functionJMenu);
        jMenuBar.add(aboutJMenu);

        //给整个界面设置菜单
        this.setJMenuBar(jMenuBar);
    }

    private void initJFrame() {

        this.getContentPane().setBackground(Color.pink);
        this.setSize(800,900);

        this.setTitle("拼图单机版v1.0");
        //置顶
        this.setAlwaysOnTop(true);

        //居中
        this.setLocationRelativeTo(null);
        //关闭模式
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

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
            JLabel all = new JLabel(new ImageIcon("D:\\IDEASPACE\\puzzlegame\\image\\katomegumi\\all.jpg"));
            all.setBounds(100,100,600,600);
            this.getContentPane().add(all);

            //设置背景
            JLabel backGround = new JLabel(new ImageIcon("D:\\IDEASPACE\\puzzlegame\\image\\background\\bg.jpg"));
            backGround.setBounds(0,0,800,900);
            this.getContentPane().add(backGround);
            this.getContentPane().repaint();
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

    @Override
    public void actionPerformed(ActionEvent e) {

        Object obj = e.getSource();
        if (obj == replayItem) {
            System.out.println("重新游戏");
            step=0;
            initDate();

            initImage();
            //直接重新调用方法会出现BUG
//            initDate();
//            initImage();
            //步数清零应该放在重新调用方法前边
//            step = 0;

        }else if (obj == reLoginItem) {
            System.out.println("重新登录");
            //关闭当前游戏界面
            this.setVisible(false);
            //打开登录界面
            new LoginJFrame();
        }else if (obj == closeItem) {
            System.out.println("关闭游戏");
            //直接关闭虚拟机
            System.exit(0);
        }else if (obj == accountItem) {
            System.out.println("公众号");
            //创建弹框对象
            JDialog jDialog = new JDialog();
            //创建一个管理图片的容器对象JLabel
            JLabel jLabel = new JLabel(new ImageIcon(path + "4.jpg"));
            jLabel.setBounds(0,0,258,258);
            jDialog.getContentPane().add(jLabel);
            jDialog.setSize(344,344);
            jDialog.setAlwaysOnTop(true);
            jDialog.setLocationRelativeTo(null);
            //弹框不关闭则无法操作下面的界面
            jDialog.setModal(true);
            jDialog.setVisible(true);
        }
    }
}
