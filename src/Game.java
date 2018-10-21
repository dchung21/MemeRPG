import java.awt.*;
import java.awt.image.BufferStrategy;

public class Game implements Runnable {
    private Window window;
    private Map map;
    private CombatMap cMap;
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

    }

    public void init() {

        window = new Window(height, width, title);
        map = new Map();
    }

    public void update() {

    }

    public void draw() {
        bs = window.getCanvas().getBufferStrategy();
        if(bs == null){
            window.getCanvas().createBufferStrategy(3);
            return;
        }
        g = bs.getDrawGraphics();
        if(!inCombat){

        }else{
            cMap = new CombatMap();
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
