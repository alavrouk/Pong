import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class Score extends Label {
    protected static Integer score = 0;

    public Score() {
        this.setText("Score: " + score.toString());
        Font font = Font.font("Lucida Console", FontWeight.EXTRA_BOLD, 50.0D);
        this.setFont(font);
        this.setTextFill(Color.web("#fffc33"));
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer a) {
        score = a;
    }

}
