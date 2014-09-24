/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fxcontrol;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Alex
 */
public class FXControlExample extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        FormattedTextField Control = new FormattedTextField();
        Control.setLimit(6);
        Control.setFormat("\\d*");
        
        stage.setScene(new Scene(Control));
        stage.setTitle("Test Custom Control");
        stage.setWidth(300);
        stage.setHeight(200);
        stage.show();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}
