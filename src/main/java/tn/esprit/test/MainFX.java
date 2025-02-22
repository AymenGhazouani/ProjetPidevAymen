package tn.esprit.test;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainFX extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Charger le fichier FXML
        Parent root = FXMLLoader.load(getClass().getResource("/Affichagesinistre.fxml"));

        // Créer la scène
        Scene scene = new Scene(root);

        // Configurer la scène et afficher la fenêtre
        primaryStage.setScene(scene);
        primaryStage.setTitle("Affichage des sinistres");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
