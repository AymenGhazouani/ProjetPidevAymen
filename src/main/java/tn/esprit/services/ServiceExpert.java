package tn.esprit.services;

import tn.esprit.entites.Expert;
import tn.esprit.utils.MyDataBase;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ServiceExpert implements IService<Expert> {

    private Connection connection;

    public ServiceExpert(){
        connection= MyDataBase.getInstance().getConnection();
    }


    @Override
    public void ajouter(Expert expert) throws SQLException {
        String sql = "INSERT INTO `personne`(`nom`, `prenom`, `age`) VALUES ('"+ expert.getNom()+"','"+ expert.getPrenom()+"',"+ expert.getAge()+")";
        Statement  statement = connection.createStatement();
        statement.executeUpdate(sql);

    }

    @Override
    public void modifier(Expert expert) throws SQLException {
        String sql = "Update personne set nom = ?, prenom= ? , age= ? where id = ?";
        PreparedStatement preparedStatement= connection.prepareStatement(sql);
        preparedStatement.setString(1, expert.getNom());
        preparedStatement.setString(2, expert.getPrenom());
        preparedStatement.setInt(3, expert.getAge());
        preparedStatement.setInt(4, expert.getId());
        preparedStatement.executeUpdate();
    }

    @Override
    public void supprimer(int id) throws SQLException {

        String sql= "delete from personne where id = ?";
        PreparedStatement preparedStatement= connection.prepareStatement(sql);
        preparedStatement.setInt(1,id);
        preparedStatement.executeUpdate();

    }

    @Override
    public List<Expert> afficher() throws SQLException {
        List<Expert> experts = new ArrayList<>();
        String sql = "select * from personne";
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery(sql);
        while (rs.next()){
            Expert p = new Expert();
            p.setId(rs.getInt("id"));
            p.setNom(rs.getString("nom"));
            p.setPrenom(rs.getString("prenom"));
            p.setAge(rs.getInt("age"));
            experts.add(p);
        }
        return experts;
    }
}
