package com.prime.ev.register.gui;

import com.prime.ev.register.Factory;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import javax.xml.stream.FactoryConfigurationError;
import java.io.IOException;


public class Main extends Application {

    private Stage primaryStage;

    @Override
    public void start(Stage primaryStage) throws Exception{
        this.primaryStage = primaryStage;
        Factory.setMainInstance(this);
        Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
        root.getStylesheets().add(getClass().getResource("reg-style.css").toExternalForm());
        primaryStage.setTitle("Login");
        primaryStage.setScene(new Scene(root));//, 500, 400));
        primaryStage.show();

        primaryStage.setOnCloseRequest(e->{
            Platform.exit();
            System.exit(0);
        });
    }


    public void setRegistrationScene() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("view.fxml"));
        root.getStylesheets().add(getClass().getResource("reg-style.css").toExternalForm());

        Stage registrationStage = new Stage();
        registrationStage.setTitle("Register");
        registrationStage.setScene(new Scene(root));

        //registrationStage.setX(-5);
        //registrationStage.setY(0);

        registrationStage.setMaximized(true);
        registrationStage.show();
        primaryStage.close();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
