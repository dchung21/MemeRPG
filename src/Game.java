public class Game implements Runnable {
    private Window window;
    private Map map;
    private int width, height;
    private String title;
    private boolean running = false;
    private Thread thread;

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
