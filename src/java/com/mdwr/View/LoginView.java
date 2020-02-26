package com.mdwr.View;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.*;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.stage.Stage;


public class LoginView extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    TextField account = new TextField();
    PasswordField password = new PasswordField();

    Stage primaryStage = null;

    @Override
    public void start(Stage primaryStage) {

        AnchorPane group = new AnchorPane();
        group.setStyle("-fx-background-color: #3b3b3b");


        // LOGO IMAGE
        ImageView logo = new ImageView();
        logo.setFitWidth(280);
        logo.setFitHeight(110);
        Image image = new Image(getClass().getClassLoader().getResource("images/5676caed1ee5f6abcb77b3b9a309d90d.gif").toExternalForm());
        logo.setImage(image);
        logo.setLayoutX(122);
        logo.setLayoutY(20);

        group.getChildren().addAll(logo);


        ImageView accountIcon = new ImageView(new Image(getClass().getClassLoader().getResource("images/safe-admin.png").toExternalForm()));
        accountIcon.setLayoutX(122);
        accountIcon.setLayoutY(152);

        ImageView passwordIcon = new ImageView(new Image(getClass().getClassLoader().getResource("images/password.png").toExternalForm()));
        passwordIcon.setLayoutX(122);
        passwordIcon.setLayoutY(212);

        account.setPrefWidth(280);
        account.setPrefHeight(40);
        account.setLayoutX(120);
        account.setLayoutY(140);
        account.setPromptText("enter your Doctor account.");
        account.setBorder(new Border(new BorderStroke(Paint.valueOf("#20B2AA"), BorderStrokeStyle.SOLID, null, new BorderWidths(0, 0, 1, 0))));
        account.setBackground(new Background(new BackgroundFill(Paint.valueOf("#3b3b3b"), null, null)));
        account.setFont(Font.font("sans-serif", 14));
        account.setPadding(new Insets(0, 0, 0, 34));
        account.setStyle("-fx-text-fill: #cccccc");

        password.setPrefWidth(280);
        password.setPrefHeight(40);
        password.setLayoutX(120);
        password.setLayoutY(200);
        password.setPromptText("enter your password.");
        password.setBorder(new Border(new BorderStroke(Paint.valueOf("#20B2AA"), BorderStrokeStyle.SOLID, null, new BorderWidths(0, 0, 1, 0))));
        password.setBackground(new Background(new BackgroundFill(Paint.valueOf("#3b3b3b"), null, null)));
        password.setFont(Font.font("sans-serif", 14));
        password.setPadding(new Insets(0, 0, 0, 34));
        password.setStyle("-fx-text-fill: #cccccc");


        account.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ENTER) {
                System.out.println("Enter");
            }
        });

        // 鼠标移入的提示
        account.setTooltip(new Tooltip("6~25个字符"));

        account.textProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue.length() > 25)
                account.setText(oldValue);
        });

        focuseChangeBorder(account);

        password.setTooltip(new Tooltip("6~16个字符，不包括特殊字符"));

        password.textProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue.length() > 16)
                password.setText(oldValue);
        });

        focuseChangeBorder(password);


        Button login = new Button("LoginView");
        login.setPrefWidth(280);
        login.setPrefHeight(40);
        login.setLayoutX(120);
        login.setLayoutY(280);
        login.setFont(Font.font("sans-serif", 14));
        login.setTextFill(Paint.valueOf("#20B2AA"));
        login.setTooltip(new Tooltip("登录"));


        initLoginButton(login);

        login.setOnMouseEntered(event -> {
             setOnMouseEnterd(login);
        });
        login.setOnMouseExited(event -> {
            initLoginButton(login);
        });
        login.setOnAction(event -> {
            showInformation();
        });


        group.getChildren().addAll(account, accountIcon, password, passwordIcon, login);

        Scene scene = new Scene(group);

        KeyCombination enterPut = new KeyCodeCombination(KeyCode.ENTER);
        scene.getAccelerators().put(enterPut, new Runnable() {
            @Override
            public void run() {
                showInformation();
            }
        });


        this.primaryStage = primaryStage;
        this.primaryStage.setResizable(false);

        this.primaryStage.getIcons().addAll(new Image(getClass().getClassLoader().getResource("images/login-icon.png").toExternalForm()));
        this.primaryStage.setScene(scene);
        this.primaryStage.setTitle("LOGIN");
        this.primaryStage.setWidth(520); // 520
        this.primaryStage.setHeight(400); // 300
        this.primaryStage.show();
    }

    private void focuseChangeBorder(Control control) {
        control.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue) {
                control.setBorder(new Border(new BorderStroke(Paint.valueOf("#EE2C2C"), BorderStrokeStyle.SOLID, null, new BorderWidths(0, 0, 1, 0))));
            }else {
                control.setBorder(new Border(new BorderStroke(Paint.valueOf("#20B2AA"), BorderStrokeStyle.SOLID, null, new BorderWidths(0, 0, 1, 0))));
            }
        });

    }

    private void showInformation() {
        Stage stage = new Stage();
        OTDoctorWorkingAdviceView view = new OTDoctorWorkingAdviceView();
        try {
            view.start(stage);
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.primaryStage.close();



//        Alert alert = new Alert(Alert.AlertType.INFORMATION ,"开始登录");
//        String accountText = account.getText();
//        String passwordText = password.getText();
//        alert.setHeaderText(accountText + ":" + passwordText);
//        alert.showAndWait();
    }

    private void setOnMouseEnterd(Button button) {
        button.setBackground(new Background(new BackgroundFill(Paint.valueOf("#458B7426"), new CornerRadii(20), Insets.EMPTY)));
        button.setBorder(new Border(new BorderStroke(Paint.valueOf("#20B2AA"), BorderStrokeStyle.SOLID, new CornerRadii(20), new BorderWidths(1))));
    }

    private void initLoginButton(Button button) {
        button.setBackground(new Background(new BackgroundFill(Paint.valueOf("#458B7400"), new CornerRadii(3), Insets.EMPTY)));
        button.setBorder(new Border(new BorderStroke(Paint.valueOf("#20B2AA"), BorderStrokeStyle.SOLID, new CornerRadii(3), new BorderWidths(1))));
    }
}
