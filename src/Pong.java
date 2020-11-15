import javafx.animation.AnimationTimer;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.application.Application;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Pong extends Application {

    static final protected double width = 1680.0;
    static final protected double height = 1080.0;
    protected static Score score = new Score();
    protected static Ball ball = new Ball();
    protected static boolean clicked = false;
    protected static Paddle paddle = new Paddle();

    public void setBackground(String location, StackPane root) throws FileNotFoundException {
        FileInputStream input = new FileInputStream(location);
        Image space = new Image(input);
        BackgroundImage backgroundimage = new BackgroundImage(space,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT,
                new BackgroundSize(1.0D, 1.0D, true, true, false, false));
        Background background = new Background(backgroundimage);
        root.setBackground(background);
    }

    public void addLogo(String location, StackPane root) throws FileNotFoundException {
        FileInputStream input = new FileInputStream(location);
        Image title = new Image(input);
        ImageView imageView = new ImageView(title);
        HBox tempBox = new HBox();
        tempBox.setAlignment(Pos.TOP_CENTER);
        tempBox.getChildren().add(imageView);
        Label empty = new Label("");
        VBox tempBox2 = new VBox(10);
        tempBox2.getChildren().addAll(empty, tempBox);
        tempBox2.setAlignment(Pos.TOP_CENTER);
        root.getChildren().add(tempBox2);
    }

    public void createScoreBoard(StackPane root) {
        HBox scoreContainer = new HBox();
        scoreContainer.getChildren().add(score);
        scoreContainer.setAlignment(Pos.BOTTOM_CENTER);
        VBox container = new VBox(50);
        Label blank = new Label("");
        container.getChildren().addAll(scoreContainer, blank);
        container.setAlignment(Pos.BOTTOM_CENTER);
        root.getChildren().add(container);
    }

    public void createGamePieces(StackPane root) {
        Pane game = new Pane();
        game.getChildren().addAll(paddle, ball);
        root.getChildren().add(game);
    }

    public void start(Stage primaryStage) {
        primaryStage.setTitle("Pong");
        StackPane root = new StackPane();
        createGamePieces(root);
        createScoreBoard(root);
        Scene primaryScene = new Scene(root, width, height);
        try {
            setBackground("Images\\pongbg.jpg",root);
        } catch (FileNotFoundException e) {
            System.out.println("Background image could not be located");
        }
        try {
            addLogo("Images\\logo.png",root);
        } catch (FileNotFoundException e) {
            System.out.println("Logo image could not be located");
        }
        root.setOnMouseClicked(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent mouseEvent) {
                if(!clicked) {
                   ball.start();
                   clicked = true;
                } else {
                    ball.reset();
                    clicked = false;
                }
                score.setScore(0);
            }
        });
        root.setOnMouseMoved(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent mouseEvent) {
                paddle.mousey = mouseEvent.getY();
            }
        });
        primaryStage.setScene(primaryScene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
