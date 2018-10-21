import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

public class Game implements Runnable {

    private Window window;
    private CombatMap cMap;
    private Map map;
    private int width, height;
    private String title;
    private boolean running = false;
    private Thread thread;
    private boolean inCombat = false;
    private BufferStrategy bs;
    private Graphics g;
    public Game(int height, int width, String title) {

        this.width = width;
        this.height = height;
        this.title = title;
        this.map = new Map();

    }

    public void init() {

        window = new Window(height, width, title);


    }

    public void update() {

    }

    private BufferedImage testImage;

    public void draw() {
        bs = window.getCanvas().getBufferStrategy();
        if(bs == null){
            window.getCanvas().createBufferStrategy(3);
            return;
        }
        g = bs.getDrawGraphics();
        drawMap();

        bs.show();
        g.dispose();
    }

    private void drawMap(){
        Image grass = ImageLoader.loadImage("/resources/textures/grass.png");
        Image tallGrass = ImageLoader.loadImage("/resources/textures/tallGrass.png");

        bs = window.getCanvas().getBufferStrategy();
        if(bs == null){
            window.getCanvas().createBufferStrategy(3);
            return;
        }
        g = bs.getDrawGraphics();

        for(int i = 0; i < this.map.getMap().length; i++){
            for(int j = 0; j < this.map.getMap()[0].length; j++){
                if(this.map.getMap()[i][j] == 0){
                    g.drawImage(tallGrass, i*32, j*32, null);
                }

                else if(this.map.getMap()[i][j] == 1){
                    g.drawImage(grass, i*32, j*32, null);
                }
            }
        }
    }


    public void run() {

        init();
        while (running) {
            update();
            draw();
        }

        stop();
    }

    public synchronized void start() {
        if (running) {
            return;
        }
        running = true;
        thread = new Thread(this);
        thread.start();
    }

    public synchronized void stop() {
        if (!running) {
            return;
        }
        running = false;
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
