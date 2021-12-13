package util;

import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * ClassName: Util
 * Description:
 * date: 2021/12/6 9:49
 *
 * @author: Lilin
 * @since JDK 1.8
 */

public class Util {
    public static final ThreadPoolExecutor threadPool = (ThreadPoolExecutor) Executors.newFixedThreadPool(10);

    public static Image getImage(String path){
        Image image = null;
        InputStream inputStream = Util.class.getClassLoader().getResourceAsStream(path);
        if (inputStream != null) {
            try {
                image = ImageIO.read(inputStream);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return image;
    }

    public static void playSound(String path){
        InputStream inputStream = Util.class.getClassLoader().getResourceAsStream(path);

        try {
            assert inputStream != null;
            AudioStream audioStream = new AudioStream(inputStream);
            AudioPlayer.player.start(audioStream);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
//        System.out.println(getImage("bg.jpg"));
        playSound("select.wav");

    }
}
