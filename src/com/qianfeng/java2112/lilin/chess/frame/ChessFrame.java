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
        JMenu menu1 = new MusicMenu().music;
        JMenu menu2 = new JMenu("游戏控制");

        bar.add(menu1);
        bar.add(menu2);
        this.setJMenuBar(bar);
    }

    public void run() {
        init();
        ChessPanel chessPanel = new ChessPanel();
        this.add(chessPanel);
        chessPanel.start();
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
