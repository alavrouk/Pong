import javafx.animation.AnimationTimer;
import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.Random;

public class Paddle extends Rectangle {
    static final protected double width = 30;
    static final protected double height = 150;
    static protected double x;
    static protected double y;
    protected double mousey;

    public Paddle(){
        super();
        this.setWidth(width);
        this.setHeight(height);
        this.setArcHeight(height/4);
        this.setArcWidth(width);
        this.setFill(Color.WHITESMOKE);
        x = 300;
        y = Pong.height/2;
        this.setX(x);
        this.setY(y);
        EventHandler<MouseEvent> mouseMoved = event -> {

        };
        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                y = mousey;
                if(y < 0) {
                    y = 0;
                }
                if(y > Pong.height - height) {
                    y = Pong.height - height;
                }
                setY(y);
                changeColor();
            }
        };
        this.setFocusTraversable(true);
        timer.start();
    }

    public void changeColor() {
        Random rand = new Random();
        int random = rand.nextInt(9);
        switch(random) {
            case 1: this.setFill(Color.RED); break;
            case 2: this.setFill(Color.ORANGE); break;
            case 3: this.setFill(Color.YELLOW); break;
            case 4: this.setFill(Color.GREEN); break;
            case 5: this.setFill(Color.BLUE); break;
            case 6: this.setFill(Color.INDIGO); break;
            case 7: this.setFill(Color.VIOLET); break;
            case 8: this.setFill(Color.WHITESMOKE); break;
        }
    }
}
