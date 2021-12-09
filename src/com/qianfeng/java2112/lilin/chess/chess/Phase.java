package com.qianfeng.java2112.lilin.chess.chess;

/**
 * ClassName: Horse
 * Description:
 * date: 2021/12/6 20:06
 *
 * @author: Lilin
 * @since JDK 1.8
 */
public class Phase extends Chess{
    public Phase(String name, boolean camp, int arrayX, int arrayY) {
        super(name, camp, arrayX, arrayY);
    }

    @Override
    public boolean run(int rowX, int colY, Chess[][] allChess) {
        return
                (this.getCamp()?rowX<=9&&rowX>=5:rowX<=4&rowX>=0)
                && Math.abs(this.getArrayX() - rowX)==2
                && Math.abs(this.getArrayY() - colY)==2
                && allChess[(this.getArrayX()+rowX)/2][(this.getArrayY()+colY)/2]==null;

    }

}
