package controller;

import entity.Coder;
import model.CoderModel;
import utils.Utils;

import javax.swing.*;

public class CoderController {

    public static void create(){
        CoderModel objCoderModel = new CoderModel();

        String nombre = JOptionPane.showInputDialog("Ingresa el nombre del coder:");
        String apellidos = JOptionPane.showInputDialog("Ingresa apellidos del coder");
        String documento = JOptionPane.showInputDialog("Ingresa el documento del paciente");
        int cohorte = Integer.parseInt(JOptionPane.showInputDialog("Ingresa que numero de cohorte es el paciente"));
        String cv = JOptionPane.showInputDialog("Ingresa una descripcion de hoja de vida del coder");
        String clan = JOptionPane.showInputDialog("Ingresa el clan del coder");

        Coder objCoder = new Coder();

        objCoder.setNombre(nombre);
        objCoder.setApellidos(apellidos);
        objCoder.setDocumento(documento);
        objCoder.setCohorte(cohorte);
        objCoder.setCv(cv);
        objCoder.setClan(clan);

        objCoder = (Coder) objCoderModel.insert(objCoder);
        JOptionPane.showMessageDialog(null,objCoder.toString());
    }

    public static void getAll(){
        CoderModel objCoderModel = new CoderModel();
        String listaCoders = "LISTA CODERS \n";

        for (Object iterator: objCoderModel.findAll()){
            Coder objCoder = (Coder) iterator;
            listaCoders += objCoder.toString()+ "\n";
        }
        JOptionPane.showMessageDialog(null,listaCoders);
    }

    public static String getAllString(){
       CoderModel objCoderModel = new CoderModel();
        String listaCoders = "LISTA CODERS\n";


        for (Object iterator: objCoderModel.findAll()){
            Coder objCoder = (Coder) iterator;
            listaCoders += objCoder.toString()+ "\n";
        }
        return listaCoders;
    }

    public static void delete(){
        CoderModel objCoderModel = new CoderModel();
        Object[] opciones = Utils.fromListToArray(objCoderModel.findAll());
        Coder idDelete = (Coder) JOptionPane.showInputDialog(null, "Ingresa el id del coder a eliminar",
                "",
                JOptionPane.QUESTION_MESSAGE,
                null,
                opciones,
                opciones[0]);

        Coder objCoder = objCoderModel.findById(idDelete.getId_coder());

        int confirmed = 1;

        if (objCoder == null){
            JOptionPane.showMessageDialog(null,"Coder no encontrad@");
        } else {
            confirmed = JOptionPane.showConfirmDialog(null,"Estas seguro de eliminar al coder? " + objCoder.toString());
            if (confirmed == 0) {
                objCoderModel.delete(objCoder);
            }
        }
    }


    public static void update(){
        CoderModel objCoderModel = new CoderModel();
        Object[] opciones = Utils.fromListToArray(objCoderModel.findAll());

        Coder idUpdate = (Coder) JOptionPane.showInputDialog(null, "Ingresa el id del coder a actualizar",
                "",
                JOptionPane.QUESTION_MESSAGE,
                null,
                opciones,
                opciones[0]);


        Coder objCoder = objCoderModel.findById(idUpdate.getId_coder());

        String nombre = JOptionPane.showInputDialog("Ingresa el nombre del coder",objCoder.getNombre());
        String apellidos = JOptionPane.showInputDialog("Ingresa los apellidos del coder",objCoder.getApellidos());
        String documento = JOptionPane.showInputDialog("Ingresa el documento del coder",objCoder.getDocumento());
        int cohorte = Integer.parseInt(JOptionPane.showInputDialog("Ingresa la cohorte del coder",objCoder.getCohorte()));
        String cv = JOptionPane.showInputDialog("Ingresa cv del coder", objCoder.getCv());
        String clan = JOptionPane.showInputDialog("Ingresa el clan del coder", objCoder.getClan());

        objCoder.setNombre(nombre);
        objCoder.setApellidos(apellidos);
        objCoder.setDocumento(documento);
        objCoder.setCohorte(cohorte);
        objCoder.setCv(cv);
        objCoder.setClan(clan);


        objCoderModel.update(objCoder);
    }
}



