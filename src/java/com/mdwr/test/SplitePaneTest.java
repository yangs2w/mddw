package com.mdwr.test;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.*;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;

public class SplitePaneTest extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        AnchorPane root = new AnchorPane();


        SplitPane splitPane = new SplitPane();

        splitPane.setBackground(new Background(new BackgroundFill(Paint.valueOf("#111111"), null, null)));
        splitPane.setBorder(new Border(new BorderStroke(Paint.valueOf("#111111"), BorderStrokeStyle.SOLID, null, null)));

        AnchorPane left = new AnchorPane();
        left.setPrefWidth(400);
        left.setPrefHeight(800);
        left.setStyle("-fx-background-color: #383838");

        AnchorPane right = new AnchorPane();
        right.setPrefHeight(800);
        right.setStyle("-fx-background-color: #686868");



        splitPane.getItems().addAll(left, right);



        root.getChildren().addAll(splitPane);


        Scene scene = new Scene(root);
        primaryStage.setScene(scene);

        primaryStage.setTitle("SplitPaneTest");
        primaryStage.setWidth(1200);
        primaryStage.setHeight(800);
        primaryStage.show();

        scene.getStylesheets().addAll("css/main.css");

        right.setPrefWidth(root.getWidth() - left.getWidth());

    }
}
