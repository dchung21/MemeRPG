package Render;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;
import Logic.Player;

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
        this.player = new Player(this.map.getMapSize(), this.map.getMapSize());
        this.cMap = new CombatMap();
    }

    public void init() {
        window = new Window(height, width, title);
        window.frame.addKeyListener(this);
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
        if(!inCombat) {
            drawMap();
            g.drawImage(Player.player, this.player.getX(), this.player.getY(), null);

        }else{
            g.drawImage(cMap.getBg(),0,0,width,height,null);
            g.drawImage(cMap.getCp().getMyMeme().getSprite(), 400,450,200,200,null);
            g.drawImage(cMap.getEnemy().getSprite(), 700, 200, 200, 200 , null);
            g.setColor(Color.lightGray);
            g.fillRect(100,650, (width-200), 350);
            g.setColor(Color.black);
            g.drawRect(100, 650, width - 200, 350);
        }


        bs.show();
        g.dispose();
    }

    private void drawMap(){

        for(int i = 0; i < Map.MAP.length; i++){
            for(int j = 0; j < Map.MAP[0].length; j++){
                if(Map.MAP[i][j] == 0){
                    g.drawImage(Map.tallGrass, i* Tiles.tileSize, j*Tiles.tileSize, null);
                }

                else if(Map.MAP[i][j] == 1){
                    g.drawImage(Map.grass, i*Tiles.tileSize, j*Tiles.tileSize, null);
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
        if(!inCombat){
        switch(e.getKeyCode()) {
            case KeyEvent.VK_W:
                this.player.moveForward();
                this.inCombat = this.player.encounter();
                break;
            case KeyEvent.VK_S:
                this.player.moveBackward();
                this.inCombat = this.player.encounter();
                break;
            case KeyEvent.VK_A:
                this.player.moveLeft();
                this.inCombat = this.player.encounter();
                break;
            case KeyEvent.VK_D:
                this.player.moveRight();
                this.inCombat = this.player.encounter();
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
