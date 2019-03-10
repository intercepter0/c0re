package sample;

import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import sample.Game.DDoSMap;
import sample.Game.Desktop;
import sample.Game.Game;
import sample.Graphics.Colors;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class MainMenu implements Mode {
    private Scene scene;
    private Pane mainPane = new Pane();
    private Label gameLogo, play, settings, exit, codeExample;

    public MainMenu() {
        System.out.println(Color.SKYBLUE.toString());
        scene = new Scene(mainPane);
        try {
            mainPane.getChildren().add(new ImageView(new Image(new FileInputStream("assets/mainMenuBG.jpg"))));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        mainPane.setStyle("-fx-background-color: " + Colors.MAIN_COLOR + ";");

        gameLogo = new Label("c0re");
        try {
            gameLogo.setFont(Font.loadFont(new FileInputStream(new File("assets/12157.ttf")), 200));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        gameLogo.setTextFill(Color.web(Colors.FONT_COLOR));
        gameLogo.setLayoutX(400);
        gameLogo.setLayoutY(170);
        mainPane.getChildren().add(gameLogo);

        play = new Label(" > Играть");
        try {
            play.setFont(Font.loadFont(new FileInputStream(new File("assets/consola.ttf")), 62));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        play.setTextFill(Color.web(Colors.FONT_COLOR));
        play.setLayoutX(925);
        play.setLayoutY(410);
        play.setOnMouseMoved(event -> {
            play.setTextFill(Color.web(Colors.FONT_COLOR_ACCENT));
            play.setText("=> Играть");
            codeExample.setText("root@"+System.getProperty("user.name")+" > exploit -start");
        });
        play.setOnMouseExited(event -> {
            play.setTextFill(Color.web(Colors.FONT_COLOR));
            play.setText(" > Играть");
            codeExample.setText("root@"+System.getProperty("user.name")+" >");

        });
        play.setOnMouseClicked(event -> {
            new Game().set(Main.getPrimaryStage());
        });
        mainPane.getChildren().add(play);

        settings = new Label(" > Настройки");
        try {
            settings.setFont(Font.loadFont(new FileInputStream(new File("assets/consola.ttf")), 62));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        settings.setTextFill(Color.web(Colors.FONT_COLOR));
        settings.setLayoutX(925);
        settings.setLayoutY(510);
        settings.setOnMouseMoved(event -> {
            settings.setTextFill(Color.web(Colors.FONT_COLOR_ACCENT));
            settings.setText("=> Настройки");
            codeExample.setText("root@"+System.getProperty("user.name")+" > config");
        });
        settings.setOnMouseExited(event -> {
            settings.setTextFill(Color.web(Colors.FONT_COLOR));
            settings.setText(" > Настройки");
            codeExample.setText("root@"+System.getProperty("user.name")+" >");

        });
        settings.setOnMouseClicked(event -> {
            // Click handling
        });
        mainPane.getChildren().add(settings);

        exit = new Label(" > Выход");
        try {
            exit.setFont(Font.loadFont(new FileInputStream(new File("assets/consola.ttf")), 62));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        exit.setTextFill(Color.web(Colors.FONT_COLOR));
        exit.setLayoutX(925);
        exit.setLayoutY(610);
        exit.setOnMouseMoved(event -> {
            exit.setTextFill(Color.web(Colors.FONT_COLOR_ACCENT));
            exit.setText("=> Выход");
            codeExample.setText("root@"+System.getProperty("user.name")+" > shutdown");
        });
        exit.setOnMouseExited(event -> {
            exit.setTextFill(Color.web(Colors.FONT_COLOR));
            exit.setText(" > Выход");
            codeExample.setText("root@"+System.getProperty("user.name")+" >");

        });
        exit.setOnMouseClicked(event -> {
            Platform.exit();
        });
        mainPane.getChildren().add(exit);

        codeExample = new Label("root@"+System.getProperty("user.name")+" >");
        codeExample.setFont(new Font("Consolas", 42));
        codeExample.setTextFill(Color.web(Colors.FONT_COLOR_DARK));
        codeExample.setLayoutX(255);
        codeExample.setLayoutY(720);
        mainPane.getChildren().add(codeExample);


    }

    // Sets main menu mode
    @Override
    public void set(Stage primaryStage) {
        primaryStage.setScene(scene);
    }
}
