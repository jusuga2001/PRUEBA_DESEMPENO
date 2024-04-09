package model;

import database.CRUD;
import database.ConfigDB;
import entity.Empresa;
import entity.Vacante;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VacanteModel implements CRUD {
    @Override
    public Object insert(Object obj) {
        Connection objConnection = ConfigDB.openConnection();
        Vacante objVacante = (Vacante) obj;
        try {
            String sql = "INSERT INTO vacante (titulo,descripcion,duracion,estado,id_empresa,tecnologia) VALUES (?,?,?,?,?,?);";
            PreparedStatement objPrepare = objConnection.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);

            objPrepare.setString(1,objVacante.getTitulo());
            objPrepare.setString(2,objVacante.getDescripcion());
            objPrepare.setString(3,objVacante.getDuracion());
            objPrepare.setString(4,objVacante.getEstado());
            objPrepare.setInt(5,objVacante.getId_empresa());
            objPrepare.setString(6,objVacante.getTecnologia());


            objPrepare.execute();
            ResultSet objResult = objPrepare.getGeneratedKeys();
            while (objResult.next()){
                objVacante.setId_vacante(objResult.getInt(1));
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,e.getMessage());
        } finally {
            ConfigDB.closeConnection();
        }
        return objVacante;
    }

    @Override
    public List<Object> findAll() {
        List<Object> listaVacantes = new ArrayList<>();
        Connection objConnection = ConfigDB.openConnection();

        try {
            String sql = "SELECT * FROM vacante INNER JOIN empresa ON vacante.id_empresa = empresa.id_empresa;";
            PreparedStatement objPrepare = objConnection.prepareStatement(sql);
            ResultSet objResult = objPrepare.executeQuery();

            while (objResult.next()){

                Vacante objVacante = new Vacante();

                objVacante.setId_vacante(objResult.getInt("id_vacante"));
                objVacante.setTitulo(objResult.getString("titulo"));
                objVacante.setDescripcion(objResult.getString("descripcion"));
                objVacante.setDuracion(objResult.getString("duracion"));
                objVacante.setEstado(objResult.getString("estado"));
                objVacante.setId_empresa(objResult.getInt("id_empresa"));
                objVacante.setEmpresa(new Empresa(objResult.getInt("empresa.id_empresa"),objResult.getString("empresa.nombre"),objResult.getString("empresa.sector"),objResult.getString("empresa.ubicacion"), objResult.getString("empresa.contacto")));

                listaVacantes.add(objVacante);
            }
        } catch (SQLException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally {
            ConfigDB.closeConnection();
        }

        return listaVacantes;
    }

    @Override
    public boolean delete(Object obj) {
        Connection objConnection = ConfigDB.openConnection();
        Vacante objVacante = (Vacante) obj;
        boolean isDeleted = false;
        try {
            String sql = "DELETE FROM vacante WHERE id_vacante = ?;";
            PreparedStatement objPrepare = objConnection.prepareStatement(sql);

            objPrepare.setInt(1,objVacante.getId_vacante());

            int totalRowsAffected = objPrepare.executeUpdate();

            if (totalRowsAffected > 0){
                isDeleted = true;
                JOptionPane.showMessageDialog(null,"La vacante fue eliminada exitosamente!");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally {
            ConfigDB.closeConnection();
        }

        return isDeleted;
    }

    @Override
    public boolean update(Object obj) {
        Connection objConnection = ConfigDB.openConnection();
        Vacante objVacante = (Vacante) obj;
        boolean isUpdated = false;
        try {
            String sql = "UPDATE vacante SET titulo = ?, descripcion = ?,duracion = ?, estado = ?,id_empresa = ?, tecnologia = ? WHERE id_vacante = ?;";
            PreparedStatement objPrepare = objConnection.prepareStatement(sql);

            objPrepare.setString(1,objVacante.getTitulo());
            objPrepare.setString(2,objVacante.getDescripcion());
            objPrepare.setString(3,objVacante.getDuracion());
            objPrepare.setString(4,objVacante.getEstado());
            objPrepare.setInt(5,objVacante.getId_empresa());
            objPrepare.setString(6,objVacante.getTecnologia());
            objPrepare.setInt(7,objVacante.getId_vacante());

            int totalRowsAffected = objPrepare.executeUpdate();

            if (totalRowsAffected > 0){
                isUpdated = true;
                JOptionPane.showMessageDialog(null,"La vacante fue actualizada exitosamente!");
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally {
            ConfigDB.closeConnection();
        }
        return isUpdated;
    }

    public Vacante findById(int id_vacante){
        Connection objConnection = ConfigDB.openConnection();
        Vacante objVacante = null;
        try {
            String sql = "SELECT * FROM vacante INNER JOIN empresa ON vacante.id_empresa = empresa.id_empresa WHERE id_vacante = ?;";
            PreparedStatement objPrepare = objConnection.prepareStatement(sql);

            objPrepare.setInt(1,id_vacante);
            ResultSet objResult = objPrepare.executeQuery();
            if (objResult.next()){
                objVacante = new Vacante();
                objVacante.setId_vacante(objResult.getInt("id_vacante"));
                objVacante.setTitulo(objResult.getString("titulo"));
                objVacante.setDescripcion(objResult.getString("descripcion"));
                objVacante.setDuracion(objResult.getString("duracion"));
                objVacante.setEstado(objResult.getString("estado"));
                objVacante.setId_empresa(objResult.getInt("id_empresa"));
                objVacante.setEmpresa(new Empresa(objResult.getInt("empresa.id_empresa"),objResult.getString("empresa.nombre"),objResult.getString("empresa.sector"),objResult.getString("empresa.ubicacion"), objResult.getString("empresa.contacto")));
            }
        } catch (SQLException e){
            JOptionPane.showMessageDialog(null,e.getMessage());
        } finally {
            ConfigDB.closeConnection();
        }
        return objVacante;
    }
}
