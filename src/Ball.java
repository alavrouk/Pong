import javafx.animation.AnimationTimer;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import java.util.Random;

public class Ball extends Circle {
    final protected double radius = 35;
    protected double dy;
    protected double dx;
    protected double x = Pong.width - 70;
    protected double y = Pong.height/2;

    public Ball() {
        super();
        this.setRadius(radius);
        this.setCenterX(x);
        this.setCenterY(y);
        this.setFill(Color.WHITESMOKE);
        this.dy = 0;
        this.dx = 0;
        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                y += dy;
                x += dx;

                if(x > 345 && x < 365 && y > Paddle.y - 15 && y < (Paddle.y + Paddle.height + 15)) {
                    dx = -dx;
                    dy = -dy;
                }
                if (y < radius) {
                    Random rand = new Random();
                    y = radius;
                    x += rand.nextInt(50);
                    dy = dy*-1;
                }
                if (y > Pong.height - radius) {
                    Random rand = new Random();
                    y = Pong.height - radius;
                    x -= rand.nextInt(50);
                    dy = dy * -1;
                }
                if (x > Pong.width - radius) {
                    Random rand = new Random();
                    y = rand.nextInt((int)Pong.height);
                    Score.score++;
                    Pong.score.setText(Pong.score.getScore().toString());
                    dx = (-1 * dx) - (Math.random() * 0.75);
                }
                if (x < radius) {
                    x = Pong.width - 70;
                    y  = Pong.height/2;
                    dx = 0;
                    dy = 0;
                }
                setCenterY(y);
                setCenterX(x);
                changeColor();
            }


        };
        this.setFocusTraversable(true);
        timer.start();
    }

    public void reset() {
        x = Pong.width - 70;
        y  = Pong.height/2;
        dx = 0;
        dy = 0;
    }

    public void start() {
        x = Pong.width - 70;
        y  = Pong.height/2;
        dx = -15;
        dy = 15;
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
