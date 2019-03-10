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
import sample.Main;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Desktop extends Pane {
    public static final int APP_BAR_HEIGHT = 44;
    public static final int HIDE_WINDOWS_BUTTON_WIDTH = 15;
    private Date date = new Date();
    private transient SimpleDateFormat formatForDateNow;
    private DDoSMap map = new DDoSMap();
    private Log log;


    /**
     * Creates a Pane layout.
     */
    public Desktop() {
        formatForDateNow = new SimpleDateFormat("hh:mm:ss");
        Rectangle appPanel = new Rectangle();
        appPanel.setFill(Color.web(Colors.SECONDARY_COLOR));
        appPanel.setOpacity(0.8);
        appPanel.setX(0);
        appPanel.setY(Main.screenHeight()-APP_BAR_HEIGHT);
        appPanel.setWidth(Main.screenWidth());
        appPanel.setHeight(APP_BAR_HEIGHT);
        Rectangle hideWindows = new Rectangle(Main.screenWidth()-HIDE_WINDOWS_BUTTON_WIDTH,appPanel.getY(),HIDE_WINDOWS_BUTTON_WIDTH,APP_BAR_HEIGHT);
        hideWindows.setOpacity(0.7);
        hideWindows.setFill(Color.web(Colors.SECONDARY_COLOR_ACCENT));
        hideWindows.setOnMouseMoved(event -> {
            hideWindows.setOpacity(1);
        });
        hideWindows.setOnMouseExited(event -> {
            hideWindows.setOpacity(0.7);
        });
        hideWindows.setOnMouseClicked(event -> {
            //TODO hide all windows
        });
        Label time = new Label(formatForDateNow.format(date));
        time.setFont(new Font("Consolas", 22));
        time.setTextFill(Color.WHITE);
        time.setLayoutX(Main.screenWidth()-HIDE_WINDOWS_BUTTON_WIDTH-120);
        time.setLayoutY(Main.screenHeight()-(double)APP_BAR_HEIGHT/1.25);
        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(1),event -> {
            date = new Date();
            time.setText(formatForDateNow.format(date));
        }));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
        getChildren().add(map);
        getChildren().add(appPanel);
        getChildren().add(hideWindows);
        getChildren().add(time);
        log = new Log();
        log.setLayoutY(Main.screenHeight()-APP_BAR_HEIGHT-30);
        log.setLayoutX(15);
        log.add("Добро пожаловать в c0re!");
        getChildren().add(log);
        getChildren().add(new Window(null,"cmd",500,500,300,300));
    }
}
