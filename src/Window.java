import javax.swing.*;
import java.awt.*;

public class Window {

    JFrame frame;
    private int height, width;
    private String title;
    public Canvas canvas;


    Window(int height, int width, String title){
        this.height = height;
        this.width = width;
        this.title = title;

        createWindow();
    }

    public void createWindow(){

        frame = new JFrame(title);
        frame.setSize(width,height);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        canvas = new Canvas();
        canvas.setPreferredSize(new Dimension(width,height));
        canvas.setMinimumSize(new Dimension(width,height));
        canvas.setMaximumSize(new Dimension(width,height));
        frame.add(canvas);
        frame.pack();

    }
    public Canvas getCanvas(){
        return(canvas);
    }

}
