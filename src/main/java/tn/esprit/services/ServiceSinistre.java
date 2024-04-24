package tn.esprit.services;

import tn.esprit.entites.Sinistre;
import tn.esprit.utils.MyDataBase;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ServiceSinistre implements IService<Sinistre> {

    private Connection connection;

    public ServiceSinistre(){
        connection= MyDataBase.getInstance().getConnection();
    }


    public void ajouter(Sinistre sinistre) throws SQLException {
        String sql = "INSERT INTO sinistre (sinistre_client_id, sinistre_expert_id, is_fautif, pourcentage, rapport) VALUES (?, ?, ?, ?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, sinistre.getSinistre_client_id());
        preparedStatement.setInt(2, sinistre.getSinistre_expert_id());
        preparedStatement.setInt(3, sinistre.getIs_fautif());
        preparedStatement.setInt(4, sinistre.getPourcentage());
        preparedStatement.setString(5, sinistre.getRapport()); // Modifier ici pour utiliser setString pour la propriété "rapport"
        preparedStatement.executeUpdate();
    }

    public void modifier(Sinistre sinistre) throws SQLException {
        String sql = "UPDATE sinistre SET sinistre_client_id = ?, sinistre_expert_id = ?, is_fautif = ?, pourcentage = ?, rapport = ? WHERE id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, sinistre.getSinistre_client_id());
        preparedStatement.setInt(2, sinistre.getSinistre_expert_id());
        preparedStatement.setInt(3, sinistre.getIs_fautif());
        preparedStatement.setInt(4, sinistre.getPourcentage());
        preparedStatement.setString(5, sinistre.getRapport()); // Modifier ici pour utiliser setString pour la propriété "rapport"
        preparedStatement.setInt(6, sinistre.getId());
        preparedStatement.executeUpdate();
    }
    public void supprimer(int id) throws SQLException {
        String sql = "DELETE FROM sinistre WHERE id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, id);
        preparedStatement.executeUpdate();
    }


    public List<Sinistre> afficher() throws SQLException {
        List<Sinistre> sinistres = new ArrayList<>();
        String sql = "SELECT * FROM sinistre";
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery(sql);
        while (rs.next()) {
            Sinistre s = new Sinistre();
            s.setId(rs.getInt("id"));
            s.setSinistre_client_id(rs.getInt("sinistre_client_id"));
            s.setSinistre_expert_id(rs.getInt("sinistre_expert_id"));
            s.setIs_fautif(rs.getInt("is_fautif"));
            s.setPourcentage(rs.getInt("pourcentage"));
            s.setRapport(rs.getString("rapport")); // Modifier ici pour utiliser getString pour la propriété "rapport"
            sinistres.add(s);
        }
        return sinistres;
    }

}

