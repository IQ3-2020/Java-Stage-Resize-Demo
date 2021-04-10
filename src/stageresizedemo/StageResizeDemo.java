/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stageresizedemo;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 *
 * @author Jeffrey Gan
 */
public class StageResizeDemo extends Application {
    
    @Override
    public void start(Stage stage) {
        BorderPane bPane = new BorderPane();
        
        Rectangle redRect = new Rectangle(200, 200, Color.RED);
        redRect.setStroke(Color.BLACK);
        redRect.setStrokeWidth(10);
        
        Rectangle blueRect = new Rectangle(300, 300, Color.BLUE);
        blueRect.setStroke(Color.BLACK);
        blueRect.setStrokeWidth(10);
        
        Menu menu = new Menu();
        MenuBar menubar = new MenuBar(menu);
        
        MenuItem redItem = new MenuItem("Red");
        redItem.setOnAction((event) -> {
            menu.setText("Red");
            bPane.setCenter(redRect);
            
            bPane.autosize();
            stage.sizeToScene();
        });
        MenuItem blueItem = new MenuItem("Blue");
        blueItem.setOnAction((event) -> {
            menu.setText("Blue");
            bPane.setCenter(blueRect);
            
            bPane.autosize();
            stage.sizeToScene();
        });
        
        menu.getItems().addAll(redItem, blueItem);
        bPane.setTop(menubar);
        
        //initial rectangle
        menu.setText("Blue");
        bPane.setCenter(blueRect);
        
        
        Scene scene = new Scene(bPane);
        stage.setScene(scene);
        stage.sizeToScene();
        
        stage.setResizable(false);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
