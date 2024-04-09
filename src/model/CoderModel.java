package model;

import database.CRUD;
import database.ConfigDB;
import entity.Coder;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CoderModel implements CRUD {
    @Override
    public Object insert(Object obj) {
        Connection objConnection = ConfigDB.openConnection();
        Coder objCoder = (Coder) obj;

        try {
            String sql = "INSERT INTO coder(nombre,apellidos,documento,cohorte,cv,clan) VALUES (?,?,?,?,?,?);";
            PreparedStatement objPrepare = objConnection.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);

            objPrepare.setString(1,objCoder.getNombre());
            objPrepare.setString(2, objCoder.getApellidos());
            objPrepare.setString(3, objCoder.getDocumento());
            objPrepare.setInt(4, objCoder.getCohorte());
            objPrepare.setString(5, objCoder.getCv());
            objPrepare.setString(6, objCoder.getClan());

            objPrepare.execute();
            ResultSet objResult = objPrepare.getGeneratedKeys();
            while (objResult.next()){
                objCoder.setId_coder(objResult.getInt(1));
            }
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }finally {
            ConfigDB.closeConnection();
        }
        return objCoder;
    }

    @Override
    public List<Object> findAll() {
        List<Object> listaCoders = new ArrayList<>();
        Connection objConnection = ConfigDB.openConnection();

        try {
            String sql = "SELECT * FROM coder;";
            PreparedStatement objPrepare = objConnection.prepareStatement(sql);
            ResultSet objResult = objPrepare.executeQuery();

            while (objResult.next()){
                Coder objCoder = new Coder();

                objCoder.setId_coder(objResult.getInt("id_coder"));
                objCoder.setNombre(objResult.getString("nombre"));
                objCoder.setApellidos(objResult.getString("apellidos"));
                objCoder.setDocumento(objResult.getString("documento"));
                objCoder.setCohorte(objResult.getInt("cohorte"));
                objCoder.setCv(objResult.getString("cv"));
                objCoder.setClan(objResult.getString("clan"));

                listaCoders.add(objCoder);
            }
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }finally {
            ConfigDB.closeConnection();
        }
        return listaCoders;
    }

    @Override
    public boolean delete(Object obj) {
        Connection objConnection = ConfigDB.openConnection();
        Coder objCoder = (Coder) obj;
        boolean isDeleted = false;

        try {
            String sql = "DELETE FROM coder WHERE id_coder = ?;";
            PreparedStatement objPrepare = objConnection.prepareStatement(sql);

            objPrepare.setInt(1,objCoder.getId_coder());

            int totalRowsAffected = objPrepare.executeUpdate();

            if (totalRowsAffected > 0){
                isDeleted = true;
                JOptionPane.showMessageDialog(null, "El coder fue eliminado exitosamente!");
            }
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }finally {
            ConfigDB.closeConnection();
        }
        return isDeleted;
    }

    @Override
    public boolean update(Object obj) {
        Connection objConnection = ConfigDB.openConnection();
        Coder objCoder = (Coder) obj;
        boolean isUpdate = false;

        try {
            String sql = "UPDATE coder SET nombre = ?, apellidos = ?, documento = ?, cohorte = ?, cv = ?, clan = ? WHERE id_coder = ?;";
            PreparedStatement objPrepare = objConnection.prepareStatement(sql);


            objPrepare.setString(1, objCoder.getNombre());
            objPrepare.setString(2, objCoder.getApellidos());
            objPrepare.setString(3, objCoder.getDocumento());
            objPrepare.setInt(4, objCoder.getCohorte());
            objPrepare.setString(5, objCoder.getCv());
            objPrepare.setString(6, objCoder.getClan());
            objPrepare.setInt(7, objCoder.getId_coder());

            int totalRowsAffected = objPrepare.executeUpdate();

            if (totalRowsAffected > 0){
                isUpdate = true;
                JOptionPane.showMessageDialog(null, "El coder fue actualizado exitosamente!");
            }
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }finally {
            ConfigDB.closeConnection();
        }
        return isUpdate;
    }

    public Coder findById(int id_coder){
        Connection objConnection = ConfigDB.openConnection();
        Coder objCoder = null;
        try {
            String sql = "SELECT * FROM coder WHERE id_coder = ?;";
            PreparedStatement objPrepare = objConnection.prepareStatement(sql);

            objPrepare.setInt(1,id_coder);
            ResultSet objResult = objPrepare.executeQuery();
            if (objResult.next()){
                objCoder = new Coder();
                objCoder.setId_coder(objResult.getInt("id_coder"));
                objCoder.setNombre(objResult.getString("nombre"));
                objCoder.setApellidos(objResult.getString("apellidos"));
                objCoder.setDocumento(objResult.getString("documento"));
                objCoder.setCohorte(objResult.getInt("cohorte"));
                objCoder.setCv(objResult.getString("cv"));
                objCoder.setClan(objResult.getString("clan"));
            }
        } catch (SQLException e){
            JOptionPane.showMessageDialog(null,e.getMessage());
        } finally {
            ConfigDB.closeConnection();
        }
        return objCoder;
    }
}
