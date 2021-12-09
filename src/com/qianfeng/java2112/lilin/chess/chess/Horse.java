package com.qianfeng.java2112.lilin.chess.chess;

/**
 * ClassName: Horse
 * Description:
 * date: 2021/12/6 20:06
 *
 * @author: Lilin
 * @since JDK 1.8
 */
public class Horse extends Chess{
    public Horse(String name, boolean camp, int arrayX, int arrayY) {
        super(name, camp, arrayX, arrayY);
    }

    @Override
    public boolean run(int rowX, int colY, Chess[][] allChess) {
        boolean checkX = Math.abs(rowX-this.getArrayX())==1&&Math.abs(colY-this.getArrayY())==2;
        boolean checkY = Math.abs(rowX-this.getArrayX())==2&&Math.abs(colY-this.getArrayY())==1;
        if (checkX == !checkY){
            System.out.format("原来的位置[%d][%d],想去的位置[%d][%d]\n",this.getArrayX(),this.getArrayY(),rowX,colY);
            if (checkX) {
                if ((colY-this.getArrayY())==2){
                    System.out.println(allChess[this.getArrayX()][this.getArrayY()+1]);
                    return allChess[this.getArrayX()][this.getArrayY()+1]==null;
                }else {
                    System.out.println(allChess[this.getArrayX()][this.getArrayY()-1]);
                    return allChess[this.getArrayX()][this.getArrayY()-1]==null;
                }

            }else {
                if ((rowX-this.getArrayX())==2){
                    System.out.println(allChess[this.getArrayX()+1][this.getArrayY()]);
                    return allChess[this.getArrayX()+1][this.getArrayY()]==null;
                }else {
                    System.out.println(allChess[this.getArrayX()-1][this.getArrayY()]);
                    return allChess[this.getArrayX()-1][this.getArrayY()]==null;
                }

            }
        }
        return false;
    }

}
