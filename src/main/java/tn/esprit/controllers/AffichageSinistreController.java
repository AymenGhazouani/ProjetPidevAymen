package tn.esprit.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import tn.esprit.entites.Sinistre;
import tn.esprit.services.ServiceSinistre;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class AffichageSinistreController {

    @FXML
    private ListView<Sinistre> sinistreListView;

    private ObservableList<Sinistre> sinistreObservableList;

    private ServiceSinistre serviceSinistre;

    @FXML
    public void initialize() {
        serviceSinistre = new ServiceSinistre();
        populateListView();
    }

    private void populateListView() {
        try {
            List<Sinistre> sinistres = serviceSinistre.afficher();
            sinistreObservableList = FXCollections.observableArrayList(sinistres);
            sinistreListView.setItems(sinistreObservableList);
        } catch (SQLException e) {
            afficherMessageErreur("Erreur", "Une erreur est survenue lors de la récupération des sinistres.");
        }
    }

    @FXML
    private void modifierSinistre() {
        Sinistre selectedSinistre = sinistreListView.getSelectionModel().getSelectedItem();
        if (selectedSinistre != null) {
            // Implement the logic for modification here
            // You should display a UI to allow the user to modify the fields of the Sinistre
        } else {
            afficherMessageErreur("Aucun sinistre sélectionné", "Veuillez sélectionner un sinistre à modifier.");
        }
    }

    @FXML
    private void supprimerSinistre() {
        Sinistre selectedSinistre = sinistreListView.getSelectionModel().getSelectedItem();
        if (selectedSinistre != null) {
            try {
                serviceSinistre.supprimer(selectedSinistre.getId());
                sinistreObservableList.remove(selectedSinistre);
                afficherMessageInformation("Suppression réussie", "Le sinistre a été supprimé avec succès.");
            } catch (SQLException e) {
                afficherMessageErreur("Erreur", "Une erreur est survenue lors de la suppression du sinistre.");
            }
        } else {
            afficherMessageErreur("Aucun sinistre sélectionné", "Veuillez sélectionner un sinistre à supprimer.");
        }
    }

    private void afficherMessageErreur(String titre, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(titre);
        alert.setContentText(message);
        alert.showAndWait();
    }

    private void afficherMessageInformation(String titre, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(titre);
        alert.setContentText(message);
        alert.showAndWait();
    }

    @FXML
    private void voirdetails() {
        Sinistre selectedSinistre = sinistreListView.getSelectionModel().getSelectedItem();
        if (selectedSinistre != null) {
            try {
                // Load the FXML file for the details view
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/AjoutSinistre.fxml"));
                Parent root = fxmlLoader.load();

                // Get the controller of the details view
                // Set data to the controller if needed
                AjouterSinistreController controller = fxmlLoader.getController();
                controller.initData(selectedSinistre); // Assuming AjoutSinistreController has a method initData(Sinistre sinistre)

                // Create a new window to display the details
                Stage stage = new Stage();
                stage.setScene(new Scene(root));
                stage.show();
            } catch (IOException e) {
                afficherMessageErreur("Erreur", "Une erreur est survenue lors du chargement de la vue des détails.");
            }
        } else {
            afficherMessageErreur("Aucun sinistre sélectionné", "Veuillez sélectionner un sinistre pour voir les détails.");
        }
    }
}
