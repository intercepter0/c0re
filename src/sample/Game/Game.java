package sample.Game;

import javafx.scene.Scene;
import javafx.stage.Stage;
import sample.Mode;

public class Game implements Mode {
    private Scene scene;
    private Desktop desktop;

    public Game() {
        desktop = new Desktop();
        scene = new Scene(desktop);
    }

    @Override
    public void set(Stage primaryStage) {
        primaryStage.setScene(scene);
        primaryStage.setFullScreen(true);
    }
}
