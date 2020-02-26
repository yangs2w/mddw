package com.mdwr.test;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.DatePicker;
import javafx.scene.layout.*;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;

import java.time.LocalDate;
import java.time.chrono.HijrahChronology;
import java.time.chrono.ThaiBuddhistChronology;
import java.util.Arrays;
import java.util.List;

public class DropDownMenuTextVirw extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        AnchorPane root = new AnchorPane();

        // 下拉菜单的一个VBOX --------------------------------------
        VBox vBox = new VBox();
        AnchorPane.setTopAnchor(vBox, 100.0);
        AnchorPane.setLeftAnchor(vBox, 200.0);
        vBox.setPrefWidth(300);
        vBox.setPrefHeight(120);
        vBox.setStyle("-fx-background-color: #ffffff");
        vBox.setAlignment(Pos.CENTER);

        // // ComboBox下拉框 --------------------------------------
        List<String> snackList = Arrays.asList("鱼香肉丝饭", "香菇滑鸡饭", "黑椒牛排饭",
                "梅菜扣肉饭", "糖醋里脊饭", "红烧排骨饭", "台式卤肉饭");
        ObservableList<String> obList = FXCollections.observableArrayList(snackList);

        ComboBox<String> comboBox = new ComboBox<>(obList);
        comboBox.setPrefWidth(300);
//        comboBox.setEditable(true);
        comboBox.setVisibleRowCount(5);

        comboBox.getSelectionModel().select(0);
        comboBox.setBackground(new Background(new BackgroundFill(Paint.valueOf("#ffffff"), null, null)));
        comboBox.setBorder(new Border(new BorderStroke(Paint.valueOf("#8b8b8b"), BorderStrokeStyle.SOLID, null, new BorderWidths(0, 0, 1, 0))));



        vBox.getChildren().addAll(comboBox);

        // // ----------------------------------------------------

        DatePicker datePicker = new DatePicker();
        datePicker.setValue(LocalDate.MIN);
        datePicker.setValue(LocalDate.MAX);
        datePicker.setValue(LocalDate.now());
//        datePicker.setChronology(ThaiBuddhistChronology.INSTANCE);


        root.getChildren().addAll(vBox, datePicker);
        // ------------------------------------------------------

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);

        primaryStage.setTitle("下拉菜单测试");
        primaryStage.setWidth(800);
        primaryStage.setHeight(600);
        primaryStage.show();

        scene.getStylesheets().addAll("css/main.css");

    }
}
