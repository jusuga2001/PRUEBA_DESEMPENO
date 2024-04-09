import controller.CoderController;
import controller.ContratacionController;
import controller.EmpresaController;
import controller.VacanteController;
import database.ConfigDB;

import javax.swing.*;
import java.sql.Connection;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        String optionMain = "";
        do {
            optionMain = JOptionPane.showInputDialog("""
                    Elige la opción a administrar
                    1. Coder.
                    2. Contratacion.
                    3. Empresa.
                    4. Vacante.
                    5. Salir.
                    
                    """);
            switch (optionMain) {
                case "1" -> {
                    String option1 = "";
                    do {
                        option1 = JOptionPane.showInputDialog("""
                                1. Listar Coders.
                                2. Insertar Coders.
                                3. Actualizar Coders.
                                4. Eliminar Coders.
                                5. Salir
                                """);
                        switch (option1){
                            case "1" -> CoderController.getAll();
                            case "2" -> CoderController.create();
                            case "3" -> CoderController.update();
                            case "4" -> CoderController.delete();
                        }
                    } while (!option1.equals("5"));
                }
                case "2" -> {
                    String option2 = "";
                    do {
                        option2 = JOptionPane.showInputDialog("""
                                1. Listar Contratacion.
                                2. Insertar Contratacion.
                                3. Actualizar Contratacion.
                                4. Eliminar Contratacion.
                                5. Salir
                                """);
                        switch (option2){
                            case "1" -> CoderController.getAll();
                            case "2" -> ContratacionController.create();
                            case "3" -> CoderController.update();
                            case "4" -> CoderController.delete();
                        }
                    } while (!option2.equals("5"));
                }

                case "3" -> {
                    String option3 = "";
                    do {
                        option3 = JOptionPane.showInputDialog("""
                                1. Listar Empresa.                              
                                2. Salir
                                """);
                        switch (option3){
                            case "1" -> EmpresaController.getAll();
                        }
                    } while (!option3.equals("2"));
                }

                case "4" -> {
                    String option4 = "";
                    do {
                        option4 = JOptionPane.showInputDialog("""
                                1. Listar Vacantes.
                                2. Insertar Vacante.
                                3. Actualizar Vacante.
                                4. Eliminar Vacante.
                                5. Salir
                                """);
                        switch (option4){
                            case "1" -> VacanteController.getAll();
                            case "2" -> VacanteController.create();
                            case "3" -> VacanteController.update();
                            case "4" -> VacanteController.delete();
                        }
                    } while (!option4.equals("5"));
                }
            }
        } while (!optionMain.equals("5"));

    }
}