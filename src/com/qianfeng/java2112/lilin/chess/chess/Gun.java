package com.qianfeng.java2112.lilin.chess.chess;

/**
 * ClassName: Horse
 * Description:
 * date: 2021/12/6 20:06
 *
 * @author: Lilin
 * @since JDK 1.8
 */
public class Gun extends Chess{
    public Gun(String name, boolean camp, int arrayX, int arrayY) {
        super(name, camp, arrayX, arrayY);
    }

    @Override
    public boolean run(int rowX, int colY, Chess[][] allChess) {
//        if (allChess[rowX][colY]==null)
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
        int hasGunMount = 0;
        if (minX==maxX){
            minY++;
            while (minY<maxY){
                if (allChess[minX][minY] != null) {
                    hasGunMount++;
                }
                minY++;
            }
        }else {
            minX++;
            while (minX<maxX){
                System.out.println(minX);
                if (allChess[minX][minY]!=null){
                    hasGunMount++;
                }
                minX++;
            }
        }
        System.out.println(hasGunMount);

        if (hasGunMount==1){
//            return allChess[rowX][colY]!=null&&allChess[rowX][colY].getCamp() != this.getCamp();
            return allChess[rowX][colY]!=null;
        }else if (hasGunMount==0){
            return allChess[rowX][colY] == null;
        }else {
            return false;
        }
    }
}
