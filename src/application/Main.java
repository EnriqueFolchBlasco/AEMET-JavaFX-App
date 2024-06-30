package application;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.fxml.FXMLLoader;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			String fxml = "vista/AEMET.fxml";
			// Cargar la ventana
			Parent root = FXMLLoader.load(getClass().getClassLoader().getResource(fxml));
			// Cargar la Scene
			Scene scene = new Scene(root);
			// Asignar propiedades al Stage
			primaryStage.setTitle("Waether Calculator");
			primaryStage.getIcons().add(new Image(getClass().getResource("/vista/icono.png").toExternalForm()));
			primaryStage.setResizable(false);
			// Asignar la scene y mostrar
			primaryStage.setScene(scene);
			primaryStage.show();
			//scene.getStylesheets().add("/vista/aplication.css");

		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
