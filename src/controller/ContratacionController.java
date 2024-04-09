package controller;

import entity.Contratacion;
import model.CoderModel;
import model.ContratacionModel;
import model.VacanteModel;

import javax.swing.*;

public class ContratacionController {

    public static void create(){
        ContratacionModel objContModel = new ContratacionModel();
        CoderModel objCoderMod = new CoderModel();
        VacanteModel objVacMod = new VacanteModel();

        String fecha_aplicacion = JOptionPane.showInputDialog(null,"Ingresa la fecha de aplicacion 'YYYY-MM-DD': ");
        String estado = JOptionPane.showInputDialog(null,"Ingresa el estado de la contratacion ");
        double salario = Double.parseDouble(JOptionPane.showInputDialog(null,"Ingresa el salario de contratacion "));
        int id_coder = Integer.parseInt(JOptionPane.showInputDialog(null,CoderController.getAllString()+"\nInserta el id del coder"));
        int id_vacante = Integer.parseInt(JOptionPane.showInputDialog(null,VacanteController.getAllString()+"\nInserta el id de la vacante"));


        Contratacion objContratacion = new Contratacion();

        objContratacion.setFecha_aplicacion(fecha_aplicacion);
        objContratacion.setEstado(estado);
        objContratacion.setSalario(salario);
        objContratacion.setId_coder(id_coder);
        objContratacion.setId_vacante(id_vacante);

        objContratacion = (Contratacion) objContModel.insert(objContratacion);

        objContratacion.setCoder(objCoderMod.findById(id_coder));
        objContratacion.setVacante(objVacMod.findById(id_vacante));
        JOptionPane.showMessageDialog(null,objContratacion.toString());

    }
}
