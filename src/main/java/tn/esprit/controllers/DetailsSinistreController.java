package tn.esprit.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import tn.esprit.entites.Sinistre;

public class DetailsSinistreController {

    @FXML
    private Label clientIdLabel;

    @FXML
    private Label expertIdLabel;

    @FXML
    private Label isFautifLabel;

    @FXML
    private Label pourcentageLabel;

    @FXML
    private Label rapportLabel;

    public void initData(Sinistre sinistre) {
        clientIdLabel.setText(String.valueOf(sinistre.getSinistre_client_id()));
        expertIdLabel.setText(String.valueOf(sinistre.getSinistre_expert_id()));
        isFautifLabel.setText(String.valueOf(sinistre.getIs_fautif()));
        pourcentageLabel.setText(String.valueOf(sinistre.getPourcentage()));
        rapportLabel.setText(sinistre.getRapport());
    }
}
