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
    /**
     *
     * @params []
     * @date 2021/12/6 19:09
     */
    @Override
    public void run() {
        InputStream is = MusicThread.class.getClassLoader().getResourceAsStream(Constant.BG_MUSIC);
        try {
            assert is != null;
            player = new Player(is);
            do {//循环播放
                player.play();
            }while(player.isComplete());
        } catch (JavaLayerException e) {
            e.printStackTrace();
        }
    }

    public void stop() {
        if(player!=null) {
            player.close();
        }
    }

}
