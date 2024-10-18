package ui;

import java.util.Scanner;
import model.Controller;

public class Executable {

    private Controller control;
    private Scanner reader;

    public Executable() {

        control = new Controller();
        reader = new Scanner(System.in);

    }

    public static void main(String[] args) {

        Executable exe = new Executable();
        exe.menu();
    }
    
    /** 
     * Descripcion: Despliega el menu principal de funcionalidades al usuario
    */
    public void menu() {

        boolean flag = true;

        do {

            System.out.println("\nBienvenido a Icesi Sostenible!");
            System.out.println("\nMENU PRINCIPAL");
            System.out.println("----------------------");
            System.out.println("1) Registrar un Proyecto en un Pillar");
            System.out.println("2) Consultar Proyectos por Pilar");
            System.out.println("0) Salir");
            int option = reader.nextInt();

            switch (option) {
                case 1:
                    registerProject();
                    break;
                case 2:
                    showProjectsByPillar();
                    break;
                case 0:
                    System.out.println("Gracias por usar nuestros servicios. Adios!");
                    flag = false;
                    break;

                default:
                    System.out.println("Opcion invalida, intente nuevamente");
                    break;
            }

        } while (flag);

    }

    /** 
     * Descripcion: Solicita al usuario la informacion necesaria para registrar un Project 
     * en un Pillar en el sistema
    */
    public void registerProject() {
        System.out.println("coloque el pilar (0: biodiversidad, 1: agua, 2: tratamiento de basuras, 3: energia) ");
        int pillarType = reader.nextInt();
        reader.nextLine(); 

        System.out.println("coloca el ID del proyecto");
        String id = reader.nextLine();

        System.out.println("coloca el Nombre del proyecto");
        String name = reader.nextLine();

        System.out.println("coloca la descripcion del proyecto ");
        String description = reader.nextLine();

        System.out.println("esta el proyecto activo? (true/false) ");
        boolean status = reader.nextBoolean();

        boolean success = control.registerProjectInPillar(pillarType, id, name, description, status);
        if (success) {
            System.out.println("proyecto registrado exitosamente");
        } else {
            System.out.println("error al registrar el proyecto, asegurate de que el pilar sea valido");
        }
    }
    

    

    /** 
     * Descripcion: Muestra al usuario los Projects registrados en un Pillar 
    */
    public void showProjectsByPillar() {
        System.out.println("coloque el pilar (0: biodiversidad, 1: agua, 2: tratamiento de basuras, 3: energia): ");
        int pillarType = reader.nextInt();

        String projectList = control.queryProjectsByPillar(pillarType);
        System.out.println("Proyectos en el Pilar seleccionado" + projectList);
    }

}
