package com.qianfeng.java2112.lilin.chess.frame;

import util.Constant;
import util.MusicThread;

import javax.swing.*;

/**
 * ClassName: ChessFrame
 * Description:
 * date: 2021/12/6 18:50
 *
 * @author: Lilin
 * @since JDK 1.8
 */
public class ChessFrame extends JFrame {
    MusicThread mt = null;
    public void init(){
        this.setTitle(Constant.CHESS_TITLE);
        //设置大小
        this.setSize(Constant.WIDTH, Constant.HEIGHT);
        //设置棋盘不可修改
        this.setResizable(false);
        //设置棋盘初始显示位置
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        //设置棋盘初始显示位置
        this.setLocationRelativeTo(null);
        //设置菜单
        JMenuBar bar = new JMenuBar();
        JMenu menu = new JMenu("背景音乐");
        JMenu menu1 = new JMenu("游戏控制");
        //设置菜单项
        JMenuItem item1 = new JMenuItem("播放");
        //点击播放--绑定事件
        item1.addActionListener(e -> {
            //启动线程来播放背景音乐
            if(mt==null) {
                mt = new MusicThread();
                new Thread(mt).start();
            }
        });
        //停止音乐
        JMenuItem item2 = new JMenuItem("停止");
        //点击停止--绑定事件
        item2.addActionListener(e -> {
            //启动线程来播放背景音乐
            if(mt!=null) {
                mt.stop();
                mt = null;
            }
        });
        menu.add(item1);
        menu.add(item2);
        bar.add(menu);
        bar.add(menu1);
        this.setJMenuBar(bar);

    }

    public void run() {
        // 设置标题

        init();
        ChessPanel chessPanel = new ChessPanel();
        this.add(chessPanel);
        chessPanel.start();
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
