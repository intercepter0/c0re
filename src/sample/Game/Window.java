package sample.Game;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.util.Duration;
import sample.Graphics.Colors;


public class Window extends Pane {
    private App socket;
    private Label title;
    public static final int HEADER_HEIGHT = 36;
    public static final int BORDERS_WIDTH = 4;

    private Rectangle headerAndBorders, socketStage;

    public Window(App socket, String title, double spawnX, double spawnY, double width, double height) {
        this.socket = socket;

        // Appearance of window
        headerAndBorders = new Rectangle();
        headerAndBorders.setWidth(width+BORDERS_WIDTH);
        headerAndBorders.setHeight(height+HEADER_HEIGHT);
        headerAndBorders.setFill(Color.web(Colors.SECONDARY_COLOR));
        headerAndBorders.setOnMouseDragged(event -> relocate(event.getScreenX(),event.getScreenY()));
        headerAndBorders.setLayoutY((HEADER_HEIGHT)*-1+BORDERS_WIDTH/2);

        socketStage = new Rectangle();
        socketStage.setWidth(width);
        socketStage.setHeight(height);
        socketStage.setFill(Color.web(Colors.SECONDARY_COLOR_ACCENT));
        socketStage.setLayoutX(BORDERS_WIDTH/2);

        this.title = new Label();
        this.title.setTextFill(Color.LIGHTGRAY);
        this.title.heightProperty().addListener((obs, oldVal, newVal) -> {
            this.title.setLayoutY(-28);
        });
        this.title.setLayoutX(20);
        this.title.setFont(new Font("Consolas",22));
        this.title.setText(title);

        relocate(spawnX,spawnY);
        getChildren().add(headerAndBorders);
        getChildren().add(socketStage);
        getChildren().add(this.title);


        //getChildren().add(socket);

    }

    /**
     * Sets the node's layoutX and layoutY translation properties in order to
     * relocate this node to the x,y location in the parent.
     * <p>
     * This method does not alter translateX or translateY, which if also set
     * will be added to layoutX and layoutY, adjusting the final location by
     * corresponding amounts.
     *
     * @param x the target x coordinate location
     * @param y the target y coordinate location
     */
    @Override
    public void relocate(double x, double y) {
        setLayoutX(x);
        setLayoutY(y);
        //socket.relocate(x,y);
        //headerAndBorders.setLayoutX(x);
       //headerAndBorders.setLayoutY(y);
       // socketStage.setLayoutX(x);
       // socketStage.setLayoutY(y);

    }
}
