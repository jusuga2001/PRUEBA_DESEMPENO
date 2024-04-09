package controller;

import entity.Empresa;
import model.EmpresaModel;

import javax.swing.*;

public class EmpresaController {

    public static String getAllString(){
        EmpresaModel objEspModel = new EmpresaModel();
        String listaEmpresa = "EMPRESAS\n";


        for (Object iterator: objEspModel.findAll()){
            Empresa objEsp = (Empresa) iterator;
            listaEmpresa += objEsp.toString()+ "\n" ;
        }
        return listaEmpresa;
    }

    public static void getAll() {
        EmpresaModel objEmpModel = new EmpresaModel();
        String listaEmpresa = "EMPRESAS\n";

        /*objEspModel.findAll().forEach(temp -> {
            Especialidad obj = (Especialidad) temp;
            listaEspec.concat(obj.toString() + "\n");
        });*/
        for (Object iterator: objEmpModel.findAll()){
            Empresa objEsp = (Empresa) iterator;
            listaEmpresa += objEsp.toString()+ "\n" ;
        }
        JOptionPane.showMessageDialog(null,listaEmpresa);
    }
}
