import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

public class Game implements Runnable, KeyListener {

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
    private Player player;


    public Game(int height, int width, String title) {

        this.width = width;
        this.height = height;
        this.title = title;
        this.map = new Map();
        this.player = new Player(this.map.getWidth(), this.map.getHeight());
    }

    public void init() {

        window = new Window(height, width, title);
        window.frame.addKeyListener(this);

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
        g.drawImage(Player.player, this.player.getX(), this.player.getY(), null);
        bs.show();
        g.dispose();
    }

    private void drawMap(){

        for(int i = 0; i < this.map.getMap().length; i++){
            for(int j = 0; j < this.map.getMap()[0].length; j++){
                if(this.map.getMap()[i][j] == 0){
                    g.drawImage(Map.tallGrass, i*32, j*32, null);
                }

                else if(this.map.getMap()[i][j] == 1){
                    g.drawImage(Map.grass, i*32, j*32, null);
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


    //Keyboard Input Handlers

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch(e.getKeyCode()){
            case KeyEvent.VK_W:
                this.player.moveForward();
                break;
            case KeyEvent.VK_S:
                this.player.moveBackward();
                break;
            case KeyEvent.VK_A:
                this.player.moveLeft();
                break;
            case KeyEvent.VK_D:
                this.player.moveRight();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
