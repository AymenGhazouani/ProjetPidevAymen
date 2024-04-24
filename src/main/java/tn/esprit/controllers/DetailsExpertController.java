package tn.esprit.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class DetailsExpertController {

    @FXML
    private TextField ageOutPutTf;

    @FXML
    private TextField nomOutPutTf;

    @FXML
    private TextField prenomOutPutTf;

    public void setAgeOutPutTf(String ageOutPutTf) {
        this.ageOutPutTf.setText(ageOutPutTf);
    }

    public void setNomOutPutTf(String nomOutPutTf) {
        this.nomOutPutTf.setText(nomOutPutTf);
    }

    public void setPrenomOutPutTf(String prenomOutPutTf) {
        this.prenomOutPutTf.setText(prenomOutPutTf);
    }
}
