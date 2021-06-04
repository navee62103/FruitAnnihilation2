import javax.swing.*;
import java.io.IOException;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class Fruits
{
    static JFrame f;
    public static void main(String[] args) throws InterruptedException, IOException
    {
//        DrawingPanel panel = new DrawingPanel(1000, 800);
//        Graphics g = panel.getGraphics();
        f = new JFrame("panel");



        Screen s = new Screen();
        f.add(s);

        // set the size of frame
        f.setSize(1070, 800);

        f.setVisible(true);
        while (true){
        Random r1 = new Random();
        int fruit = r1.nextInt(7);
        String[] fruitArray= {"apple", "banana", "pear", "grapes", "strawberry", "watermelon", "orange"};


        Random r = new Random();
        int result = r.nextInt(10);
        TimerTask task = new TimerTask() {
            public void run() {
                s.paint(fruitArray[fruit]);
            }
        };
        Timer timer = new Timer("Timer");

        long delay = result*1000L;
        timer.schedule(task, delay);
       Thread.sleep(3000);

    }
    }
}
