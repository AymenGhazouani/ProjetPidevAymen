package tn.esprit.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import tn.esprit.entites.Sinistre;
import tn.esprit.services.ServiceSinistre;

import java.sql.SQLException;

public class AjouterSinistreController {

    @FXML
    private TextField clientIdTextField;

    @FXML
    private TextField expertIdTextField;

    @FXML
    private TextField isFautifTextField;

    @FXML
    private TextField pourcentageTextField;

    @FXML
    private TextField rapportTextField;

    public void initData(Sinistre sinistre) {
        clientIdTextField.setText(String.valueOf(sinistre.getSinistre_client_id()));
        expertIdTextField.setText(String.valueOf(sinistre.getSinistre_expert_id()));
        isFautifTextField.setText(String.valueOf(sinistre.getIs_fautif()));
        pourcentageTextField.setText(String.valueOf(sinistre.getPourcentage()));
        rapportTextField.setText(sinistre.getRapport());
    }

    @FXML
    void clicKAddSinistre(ActionEvent event) {
        ServiceSinistre serviceSinistre = new ServiceSinistre();
        Sinistre sinistre = new Sinistre();
        sinistre.setSinistre_client_id(Integer.parseInt(clientIdTextField.getText()));
        sinistre.setSinistre_expert_id(Integer.parseInt(expertIdTextField.getText()));
        sinistre.setIs_fautif(Integer.parseInt(isFautifTextField.getText()));
        sinistre.setPourcentage(Integer.parseInt(pourcentageTextField.getText()));
        sinistre.setRapport(rapportTextField.getText());
        try {
            serviceSinistre.ajouter(sinistre);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Succès");
            alert.setContentText("Le sinistre a été ajouté avec succès !!");
            alert.showAndWait();
        } catch (SQLException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Échec");
            alert.setContentText("Échec de l'ajout du sinistre !!");
            alert.showAndWait();
        }
    }
}
