package util;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

import java.io.InputStream;
/**
 * ClassName: MusicThread
 * Description:
 * date: 2021/12/6 19:06
 *
 * @author: Lilin
 * @since JDK 1.8
 */
public class MusicThread implements Runnable {
    Player player = null;
    String music;
    public MusicThread(String music){
        this.music = music;
    }
    /**
     *
     * @params []
     * @date 2021/12/6 19:09
     */
    public void myPlay(){
        InputStream is = MusicThread.class.getClassLoader().getResourceAsStream(music);
        try {
            player = new Player(is);
            do {//循环播放
                player.play();
            }while(player.isComplete());
        } catch (JavaLayerException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void run() {
        myPlay();
    }

    public void stop() {
        if(player!=null) {
            player.close();
        }
    }

}
