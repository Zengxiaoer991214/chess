package com.qianfeng.java2112.lilin.chess.chess;

/**
 * ClassName: Horse
 * Description:
 * date: 2021/12/6 20:06
 *
 * @author: Lilin
 * @since JDK 1.8
 */
public class Soldier extends Chess{
    public Soldier(String name, boolean camp, int arrayX, int arrayY) {
        super(name, camp, arrayX, arrayY);
    }

    @Override
    public boolean run(int rowX, int colY, Chess[][] allChess) {
        if ((Math.abs(this.getArrayX() - rowX) + Math.abs(this.getArrayY() - colY) )!= 1){
            System.out.println("走两步");
            return false;
        }

        if (this.getCamp()?(rowX-this.getArrayX())>0:(rowX-this.getArrayX())<0){
            System.out.println("倒车");
            return false;
        }

        if (this.getCamp()){
            if (rowX>=5&&Math.abs(this.getArrayY() - colY) == 1){
                System.out.println(1);
                return false;
            }
        }else {
            if (rowX<=4&&Math.abs(this.getArrayY() - colY) == 1){
                System.out.println(2);
                return false;
            }
        }


        return  true;
    }

}
