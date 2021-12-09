package com.qianfeng.java2112.lilin.chess.frame;

import com.qianfeng.java2112.lilin.chess.chess.*;
import util.Constant;
import util.Util;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * ClassName: ChessPanel
 * Description:
 * date: 2021/12/6 19:22
 *
 * @author: Lilin
 * @since JDK 1.8
 */
public class ChessPanel extends Panel {
    private static final int CHESS_ROWS = 10;
    private static final int CHESS_CLOS = 9;
    public static Chess[][] allChess=new Chess[CHESS_ROWS][CHESS_CLOS];
    private Chess currentChess = null;
    /**
     * 代表谁是当前执棋人 红方true/黑方false
     */
    private boolean whoseTurn = true;
    private Graphics g;

    ChessPanel(){
        initAllChess();
    }

    private void initAllChess() {
        allChess[0][0] = new Car("車",false,0,0);
        allChess[0][8] = new Car("車",false,0,8);
        allChess[9][0] = new Car("車",true,9,0);
        allChess[9][8] = new Car("車",true,9,8);

        allChess[0][1] = new Horse("馬",false,0,1);
        allChess[0][7] = new Horse("馬",false,0,7);
        allChess[9][1] = new Horse("馬",true,9,1);
        allChess[9][7] = new Horse("馬",true,9,7);

        allChess[0][2] = new Phase("象",false,0,2);
        allChess[0][6] = new Phase("象",false,0,6);
        allChess[9][2] = new Phase("相",true,9,2);
        allChess[9][6] = new Phase("相",true,9,6);

        allChess[0][3] = new Official("仕",false,0,3);
        allChess[0][5] = new Official("仕",false,0,5);
        allChess[9][3] = new Official("士",true,9,3);
        allChess[9][5] = new Official("士",true,9,5);

        allChess[0][4] = new Boss("将",false,0,4);
        allChess[9][4] = new Boss("帥",true,9,4);

        allChess[2][1] = new Gun("砲",false,2,1);
        allChess[2][7] = new Gun("砲",false,2,7);
        allChess[7][1] = new Gun("炮",true,7,1);
        allChess[7][7] = new Gun("炮",true,7,7);

        for (int i=0;i<10;i+=2){
            allChess[3][i] = new Soldier("卒", false, 3, i);
        }
        for (int i=0;i<10;i+=2){
            allChess[6][i] = new Soldier("兵", true, 6, i);
        }

    }
    public static int getRow(int px){
        return (px-Constant.OFFSET_X)/Constant.CHESS_SIZE;
    }
    public static int getCol(int py){
        return (py-Constant.OFFSET_Y)/Constant.CHESS_SIZE;
    }
    public static void test(){
        for (int i = 0; i < allChess.length; i++) {
            for (int j=0;j< allChess[i].length;j++){
                if (allChess[i][j]!=null){
                    System.out.print(allChess[i][j].getName()+" ");
                }
                else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }
    public void start() {//下棋的逻辑
        //添加鼠标点击事件
        addMouseListener(new MouseAdapter() {
            //鼠标点击事件
            @Override
            public void mouseClicked(MouseEvent e) {
                if (whoseTurn){
                    System.out.println("红色方选棋");
                }else {
                    System.out.println("黑方选棋");
                }
                System.out.println("点击");
//                test();
                //获取到鼠标点击的坐标
                int px = e.getX();
                int py = e.getY();
//                System.out.format("[%d,%d]\n", px, py);
                int rowX =  getRow(py);
                int colY =  getCol(px);
                System.out.format("[%d][%d]\n", rowX, colY);
                Chess checkedChess = allChess[rowX][colY];
                // 当前，上个棋子都不为空

                if (checkedChess!=null&&currentChess!=null){
                    // 当前棋子和上个棋子为同一方的棋子
                    if (checkedChess.getCamp()==currentChess.getCamp()){
                        System.out.println("换棋子");
                        currentChess = checkedChess;
                    }
                    // 两个棋子不为同一方
                    else {
                        System.out.println("吃棋子");
                        if (currentChess.run(rowX, colY, allChess)){
                            System.out.println("可以吃");
                            System.out.println( allChess[currentChess.getArrayX()][currentChess.getArrayY()]);
                            allChess[currentChess.getArrayX()][currentChess.getArrayY()]=null;
                            currentChess.setPoint(rowX, colY);
                            allChess[rowX][colY] = currentChess;
                            currentChess=null;
                            whoseTurn=!whoseTurn;
                        }
                        else {
                            System.out.println("不可以吃");
                            return;
                        }
                    }
                }
                // 当前棋子为空，上次棋子也为空
                else if (checkedChess == null&&currentChess==null){
                    System.out.println("无效点击，没有选中其中");
                    return;
                }
                // 当前棋子不空，上个棋子为空
                else if(checkedChess!=null&&currentChess == null){
                    System.out.println("首次选子");
                    if (checkedChess.getCamp()==whoseTurn){
                        System.out.println("正确选子");
                        currentChess = checkedChess;
                    }else {
                        System.out.println("选了对方的子");
                        return;
                    }
                } else {
                    System.out.println("走棋");
                    if (currentChess.run(rowX, colY, allChess)){
                        allChess[currentChess.getArrayX()][currentChess.getArrayY()]=null;
                        currentChess.setPoint(rowX, colY);
                        allChess[rowX][colY] = currentChess;
                        currentChess=null;
                        whoseTurn=!whoseTurn;
                    }else {
                        return;
                    }
                }

                repaint();
            }

        });

    }


    @Override
    public void paint(Graphics g) {
        //先清空棋盘
        this.g = g;
        g.clearRect(0, 0, Constant.WIDTH, Constant.HEIGHT);
        //先画一个棋盘背景
        g.drawImage(Util.getImage(Constant.IMAGE_BACKGROUND), 0, 0, null);
        //画棋子---先画背景再画字
        for (int i=0;i<CHESS_ROWS;i++){
            for (int j=0;j<CHESS_CLOS;j++){
                Chess chess = allChess[i][j];
                if(chess!=null) {
                    chess.draw(g);
                }
            }
        }
        if(currentChess!=null) {
            currentChess.drawBorder(g);
        }
    }
}
