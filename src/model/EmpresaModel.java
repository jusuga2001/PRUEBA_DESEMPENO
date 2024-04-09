package model;

import database.CRUD;
import database.ConfigDB;
import entity.Empresa;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmpresaModel implements CRUD{

    @Override
    public Object insert(Object obj) {
        return null;
    }

    @Override
    public List<Object> findAll() {

        List<Object> listEmpresa = new ArrayList<>();
        Connection objConnection = ConfigDB.openConnection();

        try {
            String sql = "SELECT * FROM empresa;";
            PreparedStatement objPrepare = objConnection.prepareStatement(sql);
            ResultSet objResult = objPrepare.executeQuery();

            while (objResult.next()){
                Empresa objEmpresa = new Empresa();

                objEmpresa.setId_empresa(objResult.getInt("id_empresa"));
                objEmpresa.setNombre(objResult.getString("nombre"));
                objEmpresa.setSector(objResult.getString("sector"));
                objEmpresa.setUbicacion(objResult.getString("ubicacion"));
                objEmpresa.setContacto(objResult.getString("contacto"));


                listEmpresa.add(objEmpresa);
            }
        } catch (SQLException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally {
            ConfigDB.closeConnection();
        }
        return listEmpresa;
    }

    @Override
    public boolean delete(Object obj) {
        return false;
    }

    @Override
    public boolean update(Object obj) {
        return false;
    }

    public Empresa findById(int id_empresa){
        Connection objConnection = ConfigDB.openConnection();
        Empresa objEmpresa = null;
        try {
            String sql = "SELECT * FROM empresa WHERE id_empresa = ?;";
            PreparedStatement objPrepare = objConnection.prepareStatement(sql);

            objPrepare.setInt(1,id_empresa);
            ResultSet objResult = objPrepare.executeQuery();
            if (objResult.next()){
                objEmpresa = new Empresa();
                objEmpresa.setId_empresa(objResult.getInt("id_empresa"));
                objEmpresa.setNombre(objResult.getString("nombre"));
                objEmpresa.setSector(objResult.getString("sector"));
                objEmpresa.setUbicacion(objResult.getString("ubicacion"));
                objEmpresa.setContacto(objResult.getString("contacto"));
            }
        } catch (SQLException e){
            JOptionPane.showMessageDialog(null,e.getMessage());
        } finally {
            ConfigDB.closeConnection();
        }

        return objEmpresa;
    }


}
