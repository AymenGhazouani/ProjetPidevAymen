package tn.esprit.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import tn.esprit.entites.Sinistre;
import tn.esprit.services.ServiceSinistre;

import java.sql.SQLException;
import java.util.List;

public class AfficheController {

    @FXML
    private TableView<Sinistre> sinistreTableView;

    @FXML
    private TableColumn<Sinistre, Integer> idColumn;

    @FXML
    private TableColumn<Sinistre, Integer> clientIdColumn;

    @FXML
    private TableColumn<Sinistre, Integer> expertIdColumn;

    @FXML
    private TableColumn<Sinistre, Integer> fautifColumn;

    @FXML
    private TableColumn<Sinistre, Integer> pourcentageColumn;

    @FXML
    private TableColumn<Sinistre, String> rapportColumn;

    @FXML
    public void initialize() {
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        clientIdColumn.setCellValueFactory(new PropertyValueFactory<>("sinistre_client_id"));
        expertIdColumn.setCellValueFactory(new PropertyValueFactory<>("sinistre_expert_id"));
        fautifColumn.setCellValueFactory(new PropertyValueFactory<>("is_fautif"));
        pourcentageColumn.setCellValueFactory(new PropertyValueFactory<>("pourcentage"));
        rapportColumn.setCellValueFactory(new PropertyValueFactory<>("rapport"));

        loadSinistres();
    }

    private void loadSinistres() {
        ServiceSinistre serviceSinistre = new ServiceSinistre();
        try {
            List<Sinistre> sinistres = serviceSinistre.afficher();
            sinistreTableView.getItems().addAll(sinistres);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
