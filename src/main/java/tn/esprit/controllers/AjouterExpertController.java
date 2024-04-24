package tn.esprit.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import tn.esprit.entites.Expert;
import tn.esprit.services.ServiceExpert;

import java.io.IOException;
import java.sql.SQLException;

public class AjouterExpertController {

    @FXML
    private TextField ageTextField1;

    @FXML
    private TextField nomTextField;

    @FXML
    private TextField prenomTextField;

    @FXML
    void clicKAddPerson(ActionEvent event) {
        ServiceExpert serviceExpert = new ServiceExpert();
        Expert expert = new Expert(nomTextField.getText(),prenomTextField.getText(),Integer.parseInt(ageTextField1.getText()));
        try {
            serviceExpert.ajouter(expert);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Succées");
            alert.setContentText("La personne a été a jouté avec succées !!");
            alert.showAndWait();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/DetailsPersonne.fxml"));
            try {
                Parent root = fxmlLoader.load();
                DetailsExpertController detailsExpertController = fxmlLoader.getController();
                detailsExpertController.setAgeOutPutTf(ageTextField1.getText());
                detailsExpertController.setNomOutPutTf(nomTextField.getText());
                detailsExpertController.setPrenomOutPutTf(prenomTextField.getText());
                ageTextField1.getScene().setRoot(root);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        } catch (SQLException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Echec");
            alert.setContentText("Echec de l'ajout de la personne !!");
            alert.showAndWait();        }


    }

}
