package com.mdwr.View;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


public class DocAdviceView1 extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    private double xOffset = 0;
    private double yOffset = 0;

    @Override
    public void start(Stage primaryStage) throws Exception {

        AnchorPane root = new AnchorPane();


        // 菜单栏 -----------------------------------------
        AnchorPane menuBar = new AnchorPane();

        HBox menuBox = new HBox();
        HBox screenBox = new HBox();

        Button registerButton = new Button("挂号");
        Button diagnosisButton = new Button("诊断");
        Button instructionsButton = new Button("说明书");
        Button gruidSheetButton = new Button("指导单");

        // 将4个Button都加入到HBox中
        menuBox.getChildren().addAll(registerButton, diagnosisButton, instructionsButton, gruidSheetButton);

        menuBar.getChildren().addAll(menuBox, screenBox);

        root.getChildren().addAll(menuBar);

        // ----------------------------------------------

        Scene scene = new Scene(root);

        primaryStage.setScene(scene);
        primaryStage.setTitle("门诊医生工作站 v1.0");
        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.setMaximized(true);
        primaryStage.show();

        // 样式 ------------------------------------------
        // 菜单栏 -------------
        menuBox.setBackground(new Background(new BackgroundFill(Paint.valueOf("#515151"), null, null)));
        menuBox.setPrefHeight(38);
        menuBox.setPadding(new Insets(4));
        menuBox.setSpacing(38);
        menuBox.setPrefWidth(primaryStage.getWidth() / 2);

        screenBox.setBackground(new Background(new BackgroundFill(Paint.valueOf("#515151"), null, null)));
        screenBox.setPrefHeight(38);
        screenBox.setPadding(new Insets(4));
        screenBox.setSpacing(38);
        screenBox.setPrefWidth(primaryStage.getWidth() / 2);

        AnchorPane.setLeftAnchor(menuBox, 0.0);
        AnchorPane.setLeftAnchor(screenBox, primaryStage.getWidth() / 2);

        menuButtonStyle(registerButton, diagnosisButton, instructionsButton, gruidSheetButton);

        // 拖动窗体
        menuBar.setOnMousePressed(event -> {
            xOffset = event.getSceneX();
            yOffset = event.getSceneY();
        });
        menuBar.setOnMouseDragged(event -> {
            primaryStage.setX(event.getScreenX() - xOffset);
            primaryStage.setY(event.getScreenY() - yOffset);
        });

    }


    /**
     * 菜单栏Button的样式
     * @param buttons
     */
    private void menuButtonStyle(Button ... buttons) {
        for (Button bu : buttons) {
            bu.setMinWidth(80);
            bu.setPrefHeight(30);
            // 设置背景颜色
            bu.setBackground(new Background(new BackgroundFill(Paint.valueOf("#7A7A7A"), new CornerRadii(6), null)));
            bu.setFont(Font.font("sans-serif"));
            bu.setTextFill(Paint.valueOf("#C7C7C7"));
            bu.setBorder(new Border(new BorderStroke(Paint.valueOf("#BDBDBD"), BorderStrokeStyle.SOLID, new CornerRadii(6), new BorderWidths(0.5))));
        }
    }
}
