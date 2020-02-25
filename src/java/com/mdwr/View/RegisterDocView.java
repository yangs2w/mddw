package com.mdwr.View;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class RegisterDocView extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        AnchorPane root = new AnchorPane();
        root.setStyle("-fx-background-color: #383838");

        // 欢迎词 --------------------------------------------
        HBox hBox = new HBox();
        hBox.setAlignment(Pos.CENTER);
        hBox.setPrefHeight(80);
        hBox.setPrefWidth(450);
        AnchorPane.setTopAnchor(hBox, 0.0);
        Label welcom = new Label("欢迎使用自助挂号系统");
        welcom.setFont(Font.font("sans-serif", 20));
        welcom.setTextFill(Paint.valueOf("#B7B7B7"));
        hBox.getChildren().addAll(welcom);
        root.getChildren().addAll(hBox);
        // ---------------------------------------------------

        // 表单信息 --------------------------------------------
        VBox formInfo = new VBox();
        formInfo.setPrefWidth(450);
        formInfo.setPrefHeight(360);
        AnchorPane.setTopAnchor(formInfo, 80.0);
        formInfo.setStyle("-fx-background-color: #cccccc");
        formInfo.setAlignment(Pos.CENTER);
        

        root.getChildren().addAll(formInfo);
        // ----------------------------------------------------

        Scene scene = new Scene(root);

        primaryStage.setScene(scene);
        primaryStage.setTitle("挂号");

        primaryStage.getIcons().add(new Image("images/register-title.png"));
        primaryStage.setWidth(450);
        primaryStage.setHeight(600);
        primaryStage.setResizable(false);
        primaryStage.show();


        // 高度度，宽度 -----------------------------------------------



        // --------------------------------------------------------

    }
}
