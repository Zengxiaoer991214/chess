package com.qianfeng.java2112.lilin.chess.chess;

/**
 * ClassName: Horse
 * Description:
 * date: 2021/12/6 20:06
 *
 * @author: Lilin
 * @since JDK 1.8
 */
public class Boss extends Chess{
    public Boss(String name, boolean camp, int arrayX, int arrayY) {
        super(name, camp, arrayX, arrayY);
    }

    @Override
    public boolean run(int rowX, int colY, Chess[][] allChess) {
//        System.out.format("原来的位置[%d][%d],想去的位置[%d][%d]\n",this.getArrayX(),this.getArrayY(),rowX,colY);
//        if (colY<3||colY>5){
////            System.out.println("无效");
//            return false;
//        }
//        System.out.println(rowX);
//        boolean flag=this.getCamp()?rowX<=9&&rowX>=7:rowX<=2&&rowX>=0;
//        System.out.println(flag);
//        if (!flag){
//            return false;
//        }
//        boolean b = (Math.abs(this.getArrayX() - rowX) + Math.abs(this.getArrayY() - colY) )==1;
//        System.out.println("b"+b);
//        return (Math.abs(this.getArrayX() - rowX) + Math.abs(this.getArrayY() - colY) )== 1;
        return  3<=colY && colY<=5
                &&(this.getCamp()?rowX<=9&&rowX>=7:rowX<=2&&rowX>=0)
                &&(Math.abs(this.getArrayX() - rowX) + Math.abs(this.getArrayY() - colY) )== 1;

    }
}
