package com.qianfeng.java2112.lilin.chess.chess;

/**
 * ClassName: Car
 * Description:
 * date: 2021/12/6 20:01
 *
 * @author: Lilin
 * @since JDK 1.8
 */
public class Car extends Chess{
    public Car(String name, boolean camp, int arrayX, int arrayY) {
        super(name, camp, arrayX, arrayY);
    }

    @Override
    public boolean run(int rowX, int colY, Chess[][] allChess) {
        System.out.format("[%d][%d]%n", rowX,colY);
        if (rowX!=this.getArrayX()&&colY!=this.getArrayY()) {
            return false;
        }
        int minX = Math.min(rowX, this.getArrayX());
        int maxX = Math.max(rowX, this.getArrayX());
        int minY = Math.min(colY, this.getArrayY());
        int maxY = Math.max(colY, this.getArrayY());
        System.out.println("minX"+minX+",maxX"+maxX);
        System.out.println("minY"+minY+",maxY"+maxY);
        if (minX==maxX){
            minY++;
            while (minY<maxY){
                if (allChess[minX][minY]!=null){
                    return false;
                }
                minY++;
            }
        }else {
            minX++;
            while (minX<maxX){
                if (allChess[minX][minY]!=null){
                    return false;
                }
                minX++;
            }
        }

        return true;
    }
}
