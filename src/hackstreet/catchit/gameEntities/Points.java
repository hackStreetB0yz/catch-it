package hackstreet.catchit.gameEntities;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.graphics.Text;

public class Points {

    private Text text;
    private int points;


    public void init() {

        text = new Text(1000, 50, "POINTS: 0");
        text.setColor(Color.BLACK);
        text.grow(60, 50);
        text.draw();
    }

    public void updatePoints(int points) {

        this.points += points;

        if (this.points < 0) {

            text.setColor(Color.RED);
            text.setText("POINTS: " + this.points);
            return;
        }

        text.setColor(Color.BLACK);
        text.setText("POINTS: " + this.points);
    }

}
