package com.mdwr.View;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.time.LocalDate;

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
        hBox.setAlignment(Pos.BOTTOM_CENTER);
        hBox.setPrefHeight(80);
        hBox.setPrefWidth(450);
        AnchorPane.setTopAnchor(hBox, 0.0);
        Label welcom = new Label("挂号服务");
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
        formInfo.setStyle("-fx-background-color: #383838");
        formInfo.setAlignment(Pos.TOP_CENTER);
        formInfo.setSpacing(4.0);

        AnchorPane namePane = new AnchorPane();
        Label name = new Label("姓名");
        TextField nameFiled = new TextField();
        namePane.getChildren().addAll(nameFiled, name);
        formLabelFiledStyle(name, nameFiled);

        AnchorPane birthdayPane = new AnchorPane();
        // // 性别 ---------------
        ComboBox<String> sexBox = new ComboBox<>();
        Label sex = new Label("性别");
        sexBox.getItems().addAll("女", "男");
        sexBox.getSelectionModel().select(0);
        AnchorPane.setLeftAnchor(sex, 36.0);
        sex.setTextFill(Paint.valueOf("#0092cc"));
        AnchorPane.setLeftAnchor(sexBox, 78.0);
        sex.setFont(Font.font("sans-serif", 16));
        AnchorPane.setTopAnchor(sexBox, 10.0);
        AnchorPane.setTopAnchor(sex, 20.0);
        sexBox.setPrefWidth(80);
        sexBox.setBorder(new Border(new BorderStroke(Paint.valueOf("#adadad"), BorderStrokeStyle.SOLID, null, new BorderWidths(0, 0, 1, 0))));
        sexBox.setBackground(new Background(new BackgroundFill(Paint.valueOf("383838"), null, null)));


        // 日期
        Label birthday = new Label("出生日期");
        AnchorPane.setTopAnchor(birthday, 20.0);
        AnchorPane.setLeftAnchor(birthday, 170.0);
        birthday.setTextFill(Paint.valueOf("#0092cc"));
        birthday.setFont(Font.font("sans-serif", 16));
        DatePicker birDate = new DatePicker();
        birDate.setValue(LocalDate.now());
        AnchorPane.setLeftAnchor(birDate, 248.0);
        AnchorPane.setTopAnchor(birDate, 20.0);
        birDate.setPrefWidth(150);
        birDate.setBackground(new Background(new BackgroundFill(Paint.valueOf("#383838"), null, null)));

        TextField editor = birDate.getEditor();
        editor.setBackground(new Background(new BackgroundFill(Paint.valueOf("#383838"), null, null)));
        editor.setBorder(new Border(new BorderStroke(Paint.valueOf("#adadad"), BorderStrokeStyle.SOLID, null, new BorderWidths(0, 0, 1, 0))));
        editor.setStyle("-fx-text-fill: #adadad");



        birthdayPane.getChildren().addAll(sex, sexBox, birthday, birDate);


        // // 年龄 ---------------

        AnchorPane phonePane = new AnchorPane();
        Label phone = new Label("联系方式");
        TextField phoneFiled = new TextField();
        phonePane.getChildren().addAll(phoneFiled, phone);
        formLabelFiledStyle(phone, phoneFiled);

        // 科室
        AnchorPane departmentPane = new AnchorPane();
        departmentPane.setStyle("-fx-background-color: #cccccc");
        ComboBox<String> deptBox = new ComboBox<>();
        Label dept = new Label("科室");
        deptBox.getItems().addAll("门诊骨科", "门诊外科", "门诊内科", "门诊儿科", "门诊妇科", "门诊口鼻喉科",
                "门诊眼科", "门诊眼科", "门诊口腔科", "门诊皮肤科", "中医科", "心里咨询室");
        deptBox.getSelectionModel().select(0);
        AnchorPane.setLeftAnchor(dept, 36.0);
        dept.setTextFill(Paint.valueOf("#0092cc"));
        AnchorPane.setLeftAnchor(deptBox, 78.0);
        dept.setFont(Font.font("sans-serif", 16));
        AnchorPane.setTopAnchor(deptBox, 10.0);
        AnchorPane.setTopAnchor(dept, 20.0);
        deptBox.setPrefWidth(315);
        deptBox.setVisibleRowCount(4);
        deptBox.setBorder(new Border(new BorderStroke(Paint.valueOf("#adadad"), BorderStrokeStyle.SOLID, null, new BorderWidths(0, 0, 1, 0))));
        deptBox.setBackground(new Background(new BackgroundFill(Paint.valueOf("383838"), null, null)));


        departmentPane.getChildren().addAll(dept, deptBox);

        formItemsStyle(namePane, birthdayPane, phonePane, departmentPane);

        formInfo.getChildren().addAll(namePane, birthdayPane, phonePane, departmentPane);

        root.getChildren().addAll(formInfo);
        // ----------------------------------------------------

        // 提交按钮 ---------------------------------------------
        Button submit = new Button("挂号提交");
        submit.setPrefWidth(280);
        submit.setPrefHeight(38);
        submit.setFont(Font.font("sans-serif", 16));
        AnchorPane.setBottomAnchor(submit, 28.0);
        AnchorPane.setLeftAnchor(submit, 85.0);
        submit.setTextFill(Paint.valueOf("#4b4b4b"));
        submit.setBackground(new Background(new BackgroundFill(Paint.valueOf("#41a9c9b3"), null, null)));

        submit.setOnMouseEntered(event -> {
            submit.setCursor(Cursor.HAND);
        });

        root.getChildren().addAll(submit);
        // ----------------------------------------------------
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("挂号");
        primaryStage.getIcons().add(new Image("images/register-title.png"));
        primaryStage.setWidth(450);
        primaryStage.setHeight(600);
        primaryStage.setResizable(false);
        primaryStage.show();

        scene.getStylesheets().addAll("css/registerDocCss.css");


        // 高度度，宽度 -----------------------------------------------


        // --------------------------------------------------------



    }

    /**
     * form中输入框样式
     *
     * @param label
     * @param field
     */
    private void formLabelFiledStyle(Label label, TextField field) {
        AnchorPane.setLeftAnchor(label, 36.0);
        AnchorPane.setLeftAnchor(field, 36.0);
        AnchorPane.setTopAnchor(field, 10.0);
        AnchorPane.setTopAnchor(label, 20.0);
        field.setPadding(new Insets(0, 0, 0, 80));
        field.setPrefWidth(360);
        field.setPrefHeight(40);
        label.setFont(Font.font("sans-serif", 16));
        label.setTextFill(Paint.valueOf("#0092cc"));
        field.setBackground(new Background(new BackgroundFill(Paint.valueOf("#383838"), null, null)));
        field.setStyle("-fx-text-fill: #adadad");
        field.setFont(Font.font("sans-serif", 16));
        field.setBorder(new Border(new BorderStroke(Paint.valueOf("#a2a2a2"), BorderStrokeStyle.SOLID, null, new BorderWidths(0, 0, 1, 0))));
    }


    /**
     * 设置form表单中位于VBox中的顶层Pane中的样式
     *
     * @param panes
     */
    private void formItemsStyle(Pane... panes) {
        for (Pane pane : panes) {
            pane.setPrefWidth(450);
            pane.setPrefHeight(60);
            pane.setStyle("-fx-background-color: #383838");
            pane.setPadding(new Insets(24, 0, 24, 0));
        }
    }
}
