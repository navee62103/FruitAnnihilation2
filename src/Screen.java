import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;

import javax.imageio.ImageIO;
import javax.swing.*;

public class Screen extends JPanel {
    Timer timer;
    private BufferedImage apple;
    private BufferedImage banana;
    private BufferedImage pear;
    private BufferedImage grapes;
    private BufferedImage watermelon;
    private BufferedImage orange;
    private BufferedImage strawberry;
    private Image img;
//    private BufferedImage explosion;
    ArrayList<Point> locations = new ArrayList<Point>();

    public Screen() {
        setDoubleBuffered(true);

        try{
            apple = ImageIO.read(getClass().getResource("apple.png"));
            banana = ImageIO.read(getClass().getResource("banana.png"));
            pear = ImageIO.read(getClass().getResource("pear.png"));
            watermelon = ImageIO.read(getClass().getResource("watermelon.png"));
            grapes = ImageIO.read(getClass().getResource("grapes.png"));
            strawberry = ImageIO.read(getClass().getResource("strawberry.png"));
            orange = ImageIO.read(getClass().getResource("orange.png"));
            img = ImageIO.read(getClass().getResource("unknown.png"));
//            explosion = ImageIO.read(getClass().getResource("explode.png"));
        }catch(IOException e){

            e.printStackTrace();
        }
        //Smile Icon



    }
    public void paint(String fruitType) {
        int posY = 1;
        super.paint(getGraphics());
        Graphics2D g2d = (Graphics2D) getGraphics();
        Random r = new Random();
        int x = r.nextInt(7)*150;
        Point p = new Point(x, posY);
        if (isOverlappingImageFound(p)){
            return;
        }
        locations.add(p);
        for (int i = 0; i < 100; i++){
            if (fruitType.equals("apple")){
                g2d.drawImage(apple,x,posY,null);
            }
            if (fruitType.equals("banana")){
                g2d.drawImage(banana,x,posY,null);
            }
            if (fruitType.equals("pear")){
                g2d.drawImage(pear,x,posY,null);
            }
            if (fruitType.equals("watermelon")){
                g2d.drawImage(watermelon,x,posY,null);
            }
            if (fruitType.equals("strawberry")){
                g2d.drawImage(strawberry,x,posY,null);
            }
            if (fruitType.equals("grapes")){
                g2d.drawImage(grapes,x,posY,null);
            }
            if (fruitType.equals("orange")){
                g2d.drawImage(orange,x,posY,null);
            }


            try
            {
                Thread.sleep(500);
            } catch (InterruptedException e)
            {
                e.printStackTrace();
            }
//            dp.clear();
            g2d.setColor(Color.white);
            g2d.fillRect(x,posY,150, 150);
            posY+=20;
            p.y = posY;
        }
locations.remove(p);

    }

    public void paintComponent(Graphics g) {
        Dimension d = getSize();
        g.drawImage(img, 0, 0, d.width, d.height, null);
    }

    public boolean isOverlappingImageFound(Point p){
        for (int i = 0; i < locations.size(); i++)
        {
            if(locations.get(i).x == p.x && locations.get(i).y < 150){
                return true;
            }
        }
        return false;
    }
}
