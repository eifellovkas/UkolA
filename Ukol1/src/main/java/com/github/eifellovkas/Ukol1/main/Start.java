package com.github.eifellovkas.Ukol1.main;

import com.github.eifellovkas.Ukol1.logika.Hra;
import com.github.eifellovkas.Ukol1.ui.Controller;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Start extends Application{

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		FXMLLoader loader = new FXMLLoader();
    	loader.setLocation(getClass().getResource("/com/github/eifellovkas/Ukol1/ui/window.fxml"));    	
    	Parent root = loader.load();

    	Controller controller = loader.getController(); 	
    	Hra hra = new Hra();
    	controller.inicializuj(hra, this);

    	primaryStage.setScene(new Scene(root));
    	primaryStage.show();
    	primaryStage.setTitle("Hra se zvířátky");
		
	}

}
