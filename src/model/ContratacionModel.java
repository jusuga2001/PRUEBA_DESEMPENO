package model;

import database.CRUD;
import database.ConfigDB;
import entity.Coder;
import entity.Contratacion;
import entity.Vacante;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ContratacionModel implements CRUD {
    @Override
    public Object insert(Object obj) {
        Contratacion objContratacion = (Contratacion) obj;

        Connection objConnection = ConfigDB.openConnection();

        try {
            String sql = "INSERT INTO contratacion (fecha_aplicacion,estado,salario,id_vacante,id_coder) VALUE (?,?,?,?,?);";
            PreparedStatement objPrepare = objConnection.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
            objPrepare.setString(1,objContratacion.getFecha_aplicacion());//YYYY-MM-DD
            objPrepare.setString(2,objContratacion.getEstado());
            objPrepare.setDouble(3,objContratacion.getSalario());
            objPrepare.setInt(4,objContratacion.getId_vacante());
            objPrepare.setInt(5,objContratacion.getId_coder());

            objPrepare.execute();

            ResultSet objResult = objPrepare.getGeneratedKeys();
            while (objResult.next()){
                objContratacion.setId_contratacion(objResult.getInt(1));
            }

        } catch (SQLException e){
            JOptionPane.showMessageDialog(null,e.getMessage());
        } finally {
            ConfigDB.closeConnection();
        }
        return objContratacion;
    }

    @Override
    public List<Object> findAll() {
        Connection objConnection = ConfigDB.openConnection();
        List<Object> listaContratacion = new ArrayList<>();
        try {

            String sql = "SELECT * FROM contratacion INNER JOIN vacante ON contratacion.id_vacante = vacante.id_vacante" +
                    " INNER JOIN coder ON contratacion.id_coder = coder.id_coder;";
            PreparedStatement objPrepare = objConnection.prepareStatement(sql);
            ResultSet objResult = objPrepare.executeQuery();
            while (objResult.next()){
                Contratacion objContratacion = new Contratacion();
                Vacante objVacante = new Vacante();
                Coder objCoder = new Coder();

                objContratacion.setId_contratacion(objResult.getInt("contratacion.id_contratacion"));
                objContratacion.setFecha_aplicacion(objResult.getString("contratacion.fecha_aplicacion"));
                objContratacion.setEstado(objResult.getString("contratacion.estado"));
                objContratacion.setSalario(objResult.getDouble("contratacion.salario"));
                objContratacion.setId_vacante(objResult.getInt("contratacion.id_vacante"));
                objContratacion.setId_coder(objResult.getInt("contratacion.id_coder"));

                objVacante.setId_vacante(objResult.getInt("vacante.id_vacante"));
                objVacante.setTitulo(objResult.getString("vacante.titulo"));
                objVacante.setDescripcion(objResult.getString("vacante.descripcion"));
                objVacante.setDuracion(objResult.getString("vacante.duracion"));
                objVacante.setEstado(objResult.getString("vacante.estado"));
                objVacante.setId_empresa(objResult.getInt("vacante.id_empresa"));

                objCoder.setId_coder(objResult.getInt("coder.id_coder"));
                objCoder.setNombre(objResult.getString("coder.nombre"));
                objCoder.setApellidos(objResult.getString("coder.apellidos"));
                objCoder.setDocumento(objResult.getString("coder.documento"));
                objCoder.setCohorte(objResult.getInt("coder.cohorte"));
                objCoder.setCv(objResult.getString("coder.cv"));
                objCoder.setClan(objResult.getString("coder.clan"));

                objContratacion.setVacante(objVacante);
                objContratacion.setCoder(objCoder);

                listaContratacion.add(objContratacion);
            }
        } catch (SQLException e){
            JOptionPane.showMessageDialog(null,e.getMessage());
        } finally {
            ConfigDB.closeConnection();
        }
        return listaContratacion;
    }

    @Override
    public boolean delete(Object obj) {
        return false;
    }

    @Override
    public boolean update(Object obj) {
        return false;
    }
}
