package presenters;

import models.Person;
import views.View;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Presenter {
    private static List<Person> personList = new ArrayList<>();
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private View view;


    public Presenter() {
        this.view = new View();
    }

    public void menu() {
        int opcionMainMenu, opcionSubMenu;

        do {
            view.showMenu();
            opcionMainMenu = leerOpcion();


            switch (opcionMainMenu) {
                case 1 -> {
                    do{
                        view.showMenuPerson();
                        opcionSubMenu = leerOpcion();
                        switch(opcionSubMenu) {
                            case 1 -> verPersonasRegistradas();
                            case 2 -> registrarEstudiante();
                            case 3 -> modificarEstudiante();
                            case 4 -> eliminarEstudiante();
                            case 0 -> view.showBye();
                            default -> view.showInvalidateOption();
                        }
                    }while (opcionSubMenu != 0);
                }
                case 2 -> {
                    do {
                        view.showMenuProgram();
                        opcionSubMenu = leerOpcion();
                        switch (opcionSubMenu) {
                            case 1 -> crearProgramaAcademico();
                            case 2 -> modificarProgramaAcademico();
                            case 3 -> eliminarProgramaAcademico();
                            case 4 -> verProgramasAcademicosRegistrados();
                            case 0 -> view.showBye();
                            default -> view.showInvalidateOption();
                        }
                    }while(opcionSubMenu != 0);
                }
                case 3 -> {
                    do{
                        view.showMenuSubject();
                        opcionSubMenu = leerOpcion();
                        switch (opcionSubMenu) {
                            case 1 -> crearAsignatura();
                            case 2 -> modificarAsignatura();
                            case 3 -> eliminarAsignatura();
                            case 4 -> verAsignaturasRegistradas();
                            case 0 -> view.showBye();
                            default -> view.showInvalidateOption();
                        }
                    }while(opcionSubMenu != 0);
                }
                case 4 -> {
                    do{
                        view.showMenuRegisterStudentProgram();
                        opcionSubMenu = leerOpcion();
                        switch (opcionSubMenu) {
                            case 1 -> matricularEstudiante_programa();
                            case 2 -> verEstudiantesMatriculados_programa();
                            case 3 -> eliminar_Matricula_Estudiante_programa();
                            case 0 -> view.showBye();
                            default -> view.showInvalidateOption();
                        }
                    }while(opcionSubMenu != 0);
                }
                case 5 ->{
                    do{
                        view.showMenuRegisterStudentSubject();
                        opcionSubMenu = leerOpcion();
                        switch (opcionSubMenu) {
                            case 1 -> matricularEstudiante_asigantura();
                            case 2 -> verEstudiantesMatriculadosEnAsignatura();
                            case 3 -> eliminarEstudianteDeAsignatura();
                        }
                    }while(opcionSubMenu != 0);
                }
                case 0 ->
                        view.showBye();
                default ->
                        view.showInvalidateOption();
                // Guardar los datos antes de salir

            }
        } while (opcionMainMenu != 0);

    }

    private static int leerOpcion() {
        int opcion;
        while (true) {
            try {
                System.out.print("Ingrese una opción: ");
                String input = reader.readLine().trim();
                if (!input.isEmpty()) {
                    opcion = Integer.parseInt(input);
                    if (opcion >= 0 && opcion <= 18) {
                        break;
                    } else {
                        System.out.println("Opción no válida. Intente nuevamente.");
                    }
                } else {
                    System.out.println("No se permiten campos vacíos. Intente nuevamente.");
                }
            } catch (NumberFormatException | IOException e) {
                System.out.println("Error: Ingrese un número válido.");
            }
        }
        return opcion;
    }

    private static void verPersonasRegistradas() {                       //método para leer lista de personas
        if (personList.isEmpty()) {                                        //Verifica si la lista de personas está vacía
            System.out.println("No hay Personas registradas.");
        } else {
            System.out.println("=== Personas Registradas ===");
            int index = 0;
            for (Person person : personList) {                     //bucle for-each que recorre la lista de personas
                System.out.println("Índice " + index + ": " + person);
                index++;
            }
        }
    }

    private static void registrarEstudiante() {
        System.out.println("=== Registrar Personas ===");

        // Declaración de variables para almacenar los datos del estudiante
        String id_person = null;
        String fistName = null;
        String lastName = null;

        // Ciclo para validar y registrar los datos del estudiante
        while (true) {
            // Si la identificación del estudiante aún no se ha ingresado
            if (id_person == null) {
                System.out.print("Identificación Persona: ");
                id_person = leerCadenaNoVacia();

                // Validar si el estudiante ya está registrado por identificación
                for (Person person : personList) {
                    if (person.getId_person().equalsIgnoreCase(id_person)) {
                        System.out.println("El estudiante con esta identificación ya está registrado.");
                        id_person = null; // Reiniciar para volver a pedir el dato
                        break;
                    }
                }
            } // Si los nombres y apellidos del estudiante aún no se han ingresado
            else if (fistName == null) {
                System.out.print("Nombres: ");
                fistName = leerCadenaNoVaciaTexto();
            } // Si el correo electrónico del estudiante aún no se ha ingresado
            else if (lastName == null) {
                System.out.print("Correo Electrónico: ");
                lastName = leerCadenaNoVaciaTexto();
            }

            // Si se han ingresado todos los datos requeridos, registrar el estudiante
            if (id_person != null && fistName != null && lastName != null) {
                personList.add(new Person(id_person, fistName, lastName));
                System.out.println("Estudiante registrado exitosamente.");
                //guardarEstudiantesEnArchivo();
                break; // Salir del bucle en caso de éxito
            }
        }
    }
    private static String leerCadenaNoVacia() {
        String input;
        while (true) {
            try {
                input = reader.readLine().trim();
                if (!input.isEmpty()) {
                    return input;
                }
                System.out.println("No se permiten campos vacíos. Intente nuevamente.");
            } catch (IOException e) {
                System.out.println("Error al leer la entrada.");
            }
        }
    }
    private static String leerCadenaNoVaciaTexto() {
        String input;
        while (true) {
            try {
                input = reader.readLine().trim();
                if (!input.isEmpty() && input.matches("^[a-zA-Z\\s]+$")) {
                    return input;
                }
                System.out.println("Ingrese un valor válido (solo texto). Intente nuevamente.");
            } catch (IOException e) {
                System.out.println("Error al leer la entrada.");
            }
        }
    }

}