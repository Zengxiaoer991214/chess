package com.qianfeng.java2112.lilin.chess.chess;

/**
 * ClassName: Horse
 * Description:
 * date: 2021/12/6 20:06
 *
 * @author: Lilin
 * @since JDK 1.8
 */
public class Official extends Chess{
    public Official(String name, boolean camp, int arrayX, int arrayY) {
        super(name, camp, arrayX, arrayY);
    }

    @Override
    public boolean run(int rowX, int colY, Chess[][] allChess) {
        return  3<=colY && colY<=5
                &&(this.getCamp()?rowX<=9&&rowX>=7:rowX<=2&&rowX>=0)
                && Math.abs(this.getArrayX() - rowX)==1
                && Math.abs(this.getArrayY() - colY)==1;

    }

}
