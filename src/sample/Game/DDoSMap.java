package sample.Game;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class DDoSMap extends Pane {
    /**
     * Creates a Pane layout.
     */
    public DDoSMap() {
        try {
            getChildren().add(new ImageView(new Image(new FileInputStream(new File("assets/DDoSMap.png")))));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
