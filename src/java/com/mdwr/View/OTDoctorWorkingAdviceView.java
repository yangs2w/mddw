package com.mdwr.View;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class OTDoctorWorkingAdviceView extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    private ImageView min1;
    private ImageView min2;
    private ImageView close1;
    private ImageView close2;


    private double x1 = 0;
    private double y1 = 0;
    private double x2 = 0;
    private double y2 = 0;


    @Override
    public void start(Stage primaryStage) throws Exception {

        AnchorPane root = new AnchorPane();
        root.setStyle("-fx-background-color: #3f3f3f");

        // 启用一个StackPane来承载MenuBar ------------------
        StackPane menuPane = new StackPane();
        menuPane.setPrefHeight(38);
        menuPane.setStyle("-fx-background-color: #5a5a5a");
        AnchorPane.setTopAnchor(menuPane, 0.0);
        // // menus ----------------------------------------
        HBox menuBox = new HBox();
        menuBox.setBorder(new Border(new BorderStroke(Paint.valueOf("#6a6a6a"), BorderStrokeStyle.SOLID, null, new BorderWidths(0, 0, 0.5, 0))));
        StackPane.setAlignment(menuBox, Pos.CENTER_LEFT);
        menuBox.setAlignment(Pos.CENTER_LEFT);
        menuBox.setPadding(new Insets(0, 18, 0, 18));
        menuBox.setSpacing(38);
        menuBox.setStyle("-fx-background-color: #383838");

        Button registerButton = new Button("挂号");
        Button zhenduanButton = new Button("诊断");
        Button instructionsButton = new Button("说明书");
        Button guideSheetButton = new Button("指导单");

        menuBoxStyle(registerButton, zhenduanButton, instructionsButton, guideSheetButton);

        menuBox.getChildren().addAll(registerButton, zhenduanButton, instructionsButton, guideSheetButton);

        // // ----------------------------------------------
        // // closeBar -------------------------------------
        HBox closeBar = new HBox();
        closeBar.setBorder(new Border(new BorderStroke(Paint.valueOf("#6a6a6a"), BorderStrokeStyle.SOLID, null, new BorderWidths(0, 0, 0.5, 0))));
        StackPane.setAlignment(closeBar, Pos.CENTER_RIGHT);
        closeBar.setStyle("-fx-background-color: #383838");
        closeBar.setPadding(new Insets(0, 28, 0, 28));
        min1 = new ImageView("/images/min-1.png");
        min2 = new ImageView("/images/min-2.png");
        close1 = new ImageView("/images/close-1.png");
        close2 = new ImageView("/images/close-2.png");
        closeBar.setAlignment(Pos.CENTER_RIGHT);
        closeBar.setSpacing(28);


        // // ----------------------------------------------

        Rectangle2D bounds = Screen.getPrimary().getBounds();
        double width = bounds.getWidth();
        System.out.println(width);
        menuPane.setPrefWidth(width);
        menuBox.setMaxWidth(width / 2);
        closeBar.setMaxWidth(width / 2);
        menuPane.getChildren().addAll(menuBox, closeBar);
        root.getChildren().addAll(menuPane);
        // ----------------------------------------------

        // 左边的门诊病人信息展示以及选择 -----------------------
        AnchorPane patientInfo = new AnchorPane();
        patientInfo.setPrefWidth(280);
//        patientInfo.setPrefHeight(800);
        AnchorPane.setTopAnchor(patientInfo, 38.0);
        AnchorPane.setLeftAnchor(patientInfo, 0.0);
        patientInfo.setStyle("-fx-background-color: #383838");


        Line line = new Line();
        root.getChildren().addAll(patientInfo);
        root.getChildren().addAll(line);

        line.setOnMouseEntered(event -> {
            line.setCursor(Cursor.H_RESIZE);
        });

        // ----------------------------------------------------
        // 右边相关医嘱已经病人详细信息
        AnchorPane doctorAdvice = new AnchorPane();
        AnchorPane.setTopAnchor(doctorAdvice, 38.0);
        AnchorPane.setRightAnchor(doctorAdvice, 0.0);
        doctorAdvice.setStyle("-fx-background-color: #cccccc");

        root.getChildren().addAll(doctorAdvice);
        // ----------------------------------------------------

        Scene scene = new Scene(root);


        primaryStage.setScene(scene);
        primaryStage.setTitle("门诊医生工作站 v1.0");

        primaryStage.getIcons().addAll(new Image("images/doc-title.png"));
        primaryStage.setWidth(1200);
        primaryStage.setHeight(800);
        primaryStage.setMaximized(true);
        primaryStage.setMinWidth(1200);
        primaryStage.setMinHeight(800);
        primaryStage.show();

        // 长度，宽度等架构设置 ---------------------------------
        patientInfo.setPrefHeight(root.getHeight() - menuPane.getHeight());

        double y2 = root.getHeight();
        double y1 = menuPane.getHeight() + 1;

        line.setStroke(Paint.valueOf("#4b4b4b"));
        line.setStrokeWidth(4);
        line.setStartX(280);
        line.setStartY(y1);
        line.setEndX(280);
        line.setEndY(y2);

        doctorAdvice.setPrefWidth(root.getWidth() - 284);
        doctorAdvice.setPrefHeight(root.getHeight() - menuPane.getHeight());


        // stage的高度的变化的监听
        primaryStage.heightProperty().addListener((observable, oldValue, newValue) -> {
            line.setEndY(newValue.doubleValue());
            patientInfo.setPrefHeight(newValue.doubleValue() - 38.0);
            doctorAdvice.setPrefHeight(newValue.doubleValue() - 38.0);
        });


        // stage的宽度改变监听
        primaryStage.widthProperty().addListener((observable, oldValue, newValue) -> {
            menuPane.setPrefWidth(newValue.doubleValue());
            menuBox.setMaxWidth(newValue.doubleValue() / 2);
            closeBar.setMaxWidth(newValue.doubleValue() / 2);
            System.out.println("patient:" + patientInfo.getWidth());
            System.out.println("LineX:" + line.getStartX());
            System.out.println("scene:" + scene.getWindow().getWidth());
            doctorAdvice.setPrefWidth(scene.getWindow().getWidth() - patientInfo.getWidth() -20);
            System.out.println("line:" + line.getStartX());
            System.out.println("doctorWidth:" + doctorAdvice.getWidth());
        });
        // --------------------------------------------------


        // 所有组件的鼠标移入移出事件 -----------------------------
        // menuBox的鼠标移入时样式
        menuBoxEnteredStyle(registerButton, zhenduanButton, instructionsButton, guideSheetButton);
        // menuBox鼠标移出时样式
        menuBoxExitedStyle(registerButton, zhenduanButton, instructionsButton, guideSheetButton);


        // ---------------------------------------------------
        // 鼠标拖拽事件 ----------------------------------------
        line.setOnMousePressed(event -> {
            x1 = event.getX();
            x2 = event.getX();
            System.out.println(x1);
            System.out.println(x2);
        });
        line.setOnMouseDragged(event -> {
            line.setStartX(event.getX());
            line.setEndX(event.getX());
            patientInfo.setPrefWidth(event.getSceneX());
            doctorAdvice.setPrefWidth(root.getWidth() - event.getSceneX() - 4);
        });


        // ---------------------------------------------------

        // 按钮点击事件
        registerButton.setOnAction(event -> {
            Stage stage = new Stage();
            stage.initOwner(primaryStage);
            stage.initModality(Modality.APPLICATION_MODAL);
            RegisterDocView view = new RegisterDocView();
            try {
                view.start(stage);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

    }


    /**
     * 鼠标移出菜单栏
     *
     * @param buttons
     */
    private void menuBoxExitedStyle(Button... buttons) {
        for (Button bu : buttons) {
            bu.setOnMouseExited(event -> {
                bu.setBackground(new Background(new BackgroundFill(Paint.valueOf("#9b9b9b"), null, null)));
            });
        }
    }

    /**
     * 鼠标移入菜单
     *
     * @param buttons
     */
    private void menuBoxEnteredStyle(Button... buttons) {
        for (Button bu : buttons) {
            bu.setOnMouseEntered(event -> {
                bu.setBackground(new Background(new BackgroundFill(Paint.valueOf("#bbbbbb"), null, null)));
            });
        }
    }


    /**
     * 设置menu的样式
     *
     * @param buttons
     */
    private void menuBoxStyle(Button... buttons) {
        for (Button bu : buttons) {
            bu.setPrefWidth(80);
            bu.setBackground(new Background(new BackgroundFill(Paint.valueOf("#9b9b9b"), null, null)));
            bu.setFont(Font.font("sans-serif"));
        }
    }
}
