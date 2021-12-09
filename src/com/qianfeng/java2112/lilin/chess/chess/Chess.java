package com.qianfeng.java2112.lilin.chess.chess;

import lombok.ToString;
import util.Constant;
import util.Util;

import java.awt.*;

/**
 * ClassName: Chess
 * Description:
 * date: 2021/12/6 17:20
 *
 * @author: Lilin
 * @since JDK 1.8
 */
@ToString
public abstract class Chess {
    private String name;
    private boolean camp;
    private Point point;
    private int arrayX;
    private int arrayY;

    public Chess(String name, boolean camp, int arrayX, int arrayY) {
        this.name = name;
        this.camp = camp;
        setPoint(arrayX,arrayY);
        this.arrayX = arrayX;
        this.arrayY = arrayY;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Point getPoint() {
        return point;
    }

    public void setPoint(Point point) {
        this.point = point;
    }

    public int getArrayX() {
        return arrayX;
    }

    public void setArrayX(int arrayX) {
        this.arrayX = arrayX;
    }

    public int getArrayY() {
        return arrayY;
    }

    public void setArrayY(int arrayY) {
        this.arrayY = arrayY;
    }

    public boolean getCamp() {
        return camp;
    }

    public void setCamp(boolean camp) {
        this.camp = camp;
    }

    public void setPoint(int arrayX, int arrayY) {
        this.arrayX = arrayX;
        this.arrayY = arrayY;
        this.point =new Point(arrayY*Constant.CHESS_SIZE+Constant.OFFSET_X, arrayX*Constant.CHESS_SIZE+Constant.OFFSET_Y);
    }

    /**
     *
     * @params [int, int]
     * @return {@link boolean}
     * @date 2021/12/8 9:41
     */
    public abstract boolean run(int rowX, int colY, Chess[][] allChess);

    /**
     * @params [java.awt.Graphics]
     * @date 2021/12/6 19:40
     */
    public void draw(Graphics g) {
        //画棋子背景
        g.drawImage(Util.getImage(Constant.IMAGE_CHESS),point.x,point.y,null);
        //画字
        Math.abs(1);
        g.setColor(camp?Color.red:Color.black);
        g.setFont(new Font("黑体",Font.BOLD,Constant.FONT_SIZE));
        g.drawString(name, point.x+Constant.CHESS_OFFSET_X,point.y+Constant.CHESS_OFFSET_Y);
    }


    public void drawBorder(Graphics g) {
        g.setColor(Color.blue);
        Graphics2D g2 = (Graphics2D)g;
        g2.setStroke(new BasicStroke(3));
        g2.drawRect(point.x-2, point.y-2, Constant.CHESS_SIZE-6, Constant.CHESS_SIZE-6);
    }


}
