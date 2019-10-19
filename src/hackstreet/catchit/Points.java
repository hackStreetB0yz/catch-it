package hackstreet.catchit;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.graphics.Text;

public class Points {

    private Text text;
    private Grid grid;
    private int points;

    public Points (Grid grid){
        this.grid = grid;
    }

    public void init(){

        text = new Text(1000,50, "POINTS: 0");
        text.setColor(Color.BLACK);
        text.grow(80,50);
        text.draw();
    }

    public void updatePoints(int points){
        this.points += points;
        text.setText("POINTS:" + this.points);
    }

    public int getPoints(){
        return points;
    }

}
