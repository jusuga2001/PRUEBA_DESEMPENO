package controller;

import entity.Empresa;
import entity.Vacante;
import model.EmpresaModel;
import model.VacanteModel;
import utils.Utils;

import javax.swing.*;

public class VacanteController {
    public static void create() {
        VacanteModel objVacModel = new VacanteModel();
        EmpresaModel objEmpModel = new EmpresaModel();

        String titulo = JOptionPane.showInputDialog("Ingresa el titulo de la vacante");
        String descripcion = JOptionPane.showInputDialog("Ingresa la descripcion de la vacante");
        String duracion = JOptionPane.showInputDialog("Ingresa la duracion de la vacante");
        String estado = JOptionPane.showInputDialog("Ingresa el estado de la vacante (activo o inactivo)");
        int id_empresa = Integer.parseInt(JOptionPane.showInputDialog(EmpresaController.getAllString()+"\nIngresa el id de la empresa"));
        String tecnologia = JOptionPane.showInputDialog("Ingresa la tecnologia que se requiere para la vacante");

        Vacante objVacante = new Vacante();

        objVacante.setTitulo(titulo);
        objVacante.setDescripcion(descripcion);
        objVacante.setDuracion(duracion);
        objVacante.setEstado(estado);
        objVacante.setId_empresa(id_empresa);
        objVacante.setTecnologia(tecnologia);

        objVacante = (Vacante) objVacModel.insert(objVacante);

        objVacante.setEmpresa(objEmpModel.findById(id_empresa));

        JOptionPane.showMessageDialog(null, objVacante.toString());
    }

    public static void getAll() {
        VacanteModel objVacModel = new VacanteModel();
        String listaVacantes = "LISTA DE VACANTES\n";

        for (Object iterator: objVacModel.findAll()){
            Vacante objVacante = (Vacante) iterator;
            listaVacantes += objVacante.toString() + "\n";
        }
        JOptionPane.showMessageDialog(null,listaVacantes);
    }

    public static String getAllString(){
        VacanteModel objVacModel = new VacanteModel();
        String listaVacantes = "LISTA DE VACANTES\n";

        for (Object iterator: objVacModel.findAll()){
            Vacante objVacante = (Vacante) iterator;
            listaVacantes += objVacante.toString()+ "\n";
        }

        return listaVacantes;
    }

    public static void delete(){
        VacanteModel objVacModel = new VacanteModel();
        Object[] opciones = Utils.fromListToArray(objVacModel.findAll());
        Vacante idDelete = (Vacante) JOptionPane.showInputDialog(null,
                "Ingresa el id de la vacante a eliminar",
                "",
                JOptionPane.QUESTION_MESSAGE,
                null,
                opciones,
                opciones[0]);

        Vacante objVacante = objVacModel.findById(idDelete.getId_vacante());

        int confirmed = 1;

        if (objVacante == null){
            JOptionPane.showMessageDialog(null,"Vacante no encontrada");
        } else {
            confirmed = JOptionPane.showConfirmDialog(null,"Estas seguro de eliminar la vacante?" + objVacante.toString());
            if (confirmed == 0) {
                objVacModel.delete(objVacante);
            }
        }
    }

    public static void update(){
        VacanteModel objVacModel = new VacanteModel();
        Object[] opciones = Utils.fromListToArray(objVacModel.findAll());
        Vacante idUpdate = (Vacante) JOptionPane.showInputDialog(null,
                "Ingresa el id de la vacante a actualizar",
                "",
                JOptionPane.QUESTION_MESSAGE,
                null,
                opciones,
                opciones[0]);

        Vacante objVacante = objVacModel.findById(idUpdate.getId_vacante());

        String titulo = JOptionPane.showInputDialog("Ingresa el titulo de la vacante",objVacante.getTitulo());
        String descripcion = JOptionPane.showInputDialog("Ingresa la descripcion de la vacante",objVacante.getDescripcion());
        String duracion = JOptionPane.showInputDialog("Ingresa la duracion de la vacante",objVacante.getDuracion());
        String estado = JOptionPane.showInputDialog("Ingresa el estado de la vacante",objVacante.getEstado());
        int id_empresa = Integer.parseInt(JOptionPane.showInputDialog(EmpresaController.getAllString()+"\nIngresa el id de la empresa"));
        String tecnologia = JOptionPane.showInputDialog("Ingresa la tecnologia requerida para la vacante",objVacante.getTecnologia());

        objVacante.setTitulo(titulo);
        objVacante.setDescripcion(descripcion);
        objVacante.setDuracion(duracion);
        objVacante.setEstado(estado);
        objVacante.setId_empresa(id_empresa);
        objVacante.setTecnologia(tecnologia);

        objVacModel.update(objVacante);
    }

}
