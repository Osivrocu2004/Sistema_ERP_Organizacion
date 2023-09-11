package presenters;

import enums.TypeJob;
import models.Campus;
import models.Employee;
import models.JobTitle;
import models.Person;
import views.View;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Presenter {
    private static List<Person> personList;
    private static List<Employee> employeeList;

    private static List<Campus> campusList;
    private static BufferedReader reader;
    private View view;


    public Presenter() {
        this.view = new View();
        personList = new ArrayList<>();
        employeeList = new ArrayList<>();
        campusList = new ArrayList<>();
        reader = new BufferedReader(new InputStreamReader(System.in));
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
                            case 1 -> showRegisterPerson();
                            case 2 -> registerPerson();
                            case 3 -> changePerson();
                            case 4 -> deletePerson();
                            case 0 -> view.showBye();
                            default -> view.showInvalidateOption();
                        }
                    }while (opcionSubMenu != 0);
                }
                case 2 -> {
                    do {
                        view.showMenuEmployees();
                        opcionSubMenu = leerOpcion();
                        switch (opcionSubMenu) {
                            case 1 -> matricularEstudiante_programa();
                            //case 2 -> modificarProgramaAcademico();
                            //case 3 -> eliminarProgramaAcademico();
                            case 4 -> showRegisterEmployees();
                            case 0 -> view.showBye();
                            default -> view.showInvalidateOption();
                        }
                    }while(opcionSubMenu != 0);
                }
                case 3 -> {
                    do {
                        view.showMenuCampus();
                        opcionSubMenu = leerOpcion();
                        switch (opcionSubMenu) {
                            case 1 -> registerCampus();
                            //case 2 -> modificarProgramaAcademico();
                            //case 3 -> eliminarProgramaAcademico();
                            case 4 -> showRegisterEmployees();
                            //case 5 ->
                            //case 6 ->
                            case 0 -> view.showBye();
                            default -> view.showInvalidateOption();
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

    public void showRegisterPerson() {                       //método para leer lista de personas
        if (personList.isEmpty()) {                                        //Verifica si la lista de personas está vacía
            view.noRegisteredPerson();
        } else {
            System.out.println("=== Personas Registradas ===");
            int index = 0;
            for (Person person : personList) {                     //bucle for-each que recorre la lista de personas
                System.out.println("Índice " + index + ": " + person);
                index++;
            }
        }
    }


    private static void registerPerson() {
        System.out.println("=== Registrar Personas ===");

        // Declaración de variables para almacenar los datos del estudiante
        String id_person = null;
        String fistName = null;
        String lastName = null;

        // Ciclo para validar y registrar los datos del estudiante
        while (true) {
            // Si la identificación del estudiante aún no se ha ingresado
            if (id_person == null) {
                System.out.print("Id Persona: ");
                id_person = leerCadenaNoVacia();

                // Validar si el estudiante ya está registrado por identificación
                for (Person person : personList) {
                    if (person.getId_person().equalsIgnoreCase(id_person)) {
                        System.out.println("Ya se encuentra una persona con esta identificación ya registrada.");
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
                System.out.print("Apellidos: ");
                lastName = leerCadenaNoVaciaTexto();
            }

            // Si se han ingresado todos los datos requeridos, registrar la persona
            if (id_person != null && fistName != null && lastName != null) {
                personList.add(new Person(id_person, fistName, lastName));
                System.out.println("Persona registrado exitosamente.");
                //guardarEstudiantesEnArchivo();
                break; // Salir del bucle en caso de éxito
            }
        }
    }
    public void changePerson() {
        System.out.println("=== Modificar Registro de Estudiante ===");

        // Verificar si hay estudiantes registrados
        if (personList.isEmpty()) {
            System.out.println("No hay estudiantes registrados.");
            return;
        }

        // Mostrar la lista de personas registradas
        showRegisterPerson();

        // Solicitar al usuario que ingrese el índice del estudiante que desea modificar
        System.out.print("Ingrese el índice del estudiante que desea modificar: ");
        int indice = leerIndiceValido(personList.size());
        Person personaSeleccionada = personList.get(indice);

        // Inicializar variables con los valores actuales del estudiante seleccionado
        String nuevoIdPersona = personaSeleccionada.getId_person();
        String nuevoNombrePersona = personaSeleccionada.getFistName();
        String nuevoApellidoPersona = personaSeleccionada.getLastName();

        // Solicitar al usuario que ingrese el nuevo código de estudiante
        while (true) {
            System.out.print("Nuevo ID de la Persona (" + nuevoIdPersona + "): ");
            String input = leerCodigoNumerico();
            boolean idPersonaRegistrada = false;
            if (!input.isEmpty()) {
                for (Person person : personList) {
                    if (person.getId_person().equals(input) && !person.getId_person().equals(nuevoIdPersona)) {
                        System.out.println("La persona con este código ya está registrado.");
                        idPersonaRegistrada = true;
                        break;
                    }
                }
                if (!idPersonaRegistrada) {
                    nuevoIdPersona = input;
                    break;
                }
            } else {
                System.out.println("No se permiten campos vacíos. Intente nuevamente.");
            }
        }

        // Solicitar al usuario que ingrese el nuevo nombre
        while (true) {
            System.out.print("Nuevo Nombres (" + nuevoNombrePersona + "): ");
            String input = leerCadenaNoVaciaTexto();
            if (!input.isEmpty()) {
                nuevoNombrePersona = input;
                break;
            } else {
                System.out.println("Ingrese un valor válido (solo texto). Intente nuevamente.");
            }
        }
        // Solicitar al usuario que ingrese el nuevo apellido
        while (true) {
            System.out.print("Nuevo Nombres (" + nuevoApellidoPersona + "): ");
            String input = leerCadenaNoVaciaTexto();
            if (!input.isEmpty()) {
                nuevoApellidoPersona = input;
                break;
            } else {
                System.out.println("Ingrese un valor válido (solo texto). Intente nuevamente.");
            }
        }

        // Actualizar los datos del estudiante con los valores nuevos
        personaSeleccionada.setId_person(nuevoIdPersona);
        personaSeleccionada.setFistName(nuevoNombrePersona);
        personaSeleccionada.setLastName(nuevoApellidoPersona);

        System.out.println("Estudiante modificado exitosamente.");
        //guardarEstudiantesEnArchivo();
    }

    public void deletePerson() {                                      //método para eliminar estudiantes registrados de la lista estudiantes
        System.out.println("=== Eliminar Registro de Estudiante ===");
        if (personList.isEmpty()) {
            System.out.println("No hay estudiantes registrados.");
            return;
        }
        showRegisterPerson();
        System.out.print("Ingrese el índice del estudiante que desea eliminar: ");
        int indice = leerIndiceValido(personList.size());
        personList.remove(indice);
        System.out.println("Estudiante eliminado exitosamente.");
        //guardarEstudiantesEnArchivo();
    }



    public void matricularEstudiante_programa() {
        System.out.println("=== EMPLEADO - PERSONA ===");

        if (personList.isEmpty()) {
            System.out.println("No hay personas registradas.");
            return;
        }

        showRegisterPerson();

        System.out.print("Ingrese el índice del estudiante que desea matricular: ");
        int indexPerson = leerIndiceValido(personList.size());

        Person person = personList.get(indexPerson);

        System.out.println("=== CARGOS DISPONIBLES ===\n1. " + TypeJob.DIRECTIVO + "(D)" + "\n2. " + TypeJob.ASISTENCIAL + "(A)" + "\n3. " + TypeJob.OPERATIVO + "(O)" +
                "\nIngrese el número del cargo en el que desea registrar a la persona: ");

        int indexJobTitle = leerIndiceValido(TypeJob.values().length);
        String jobTitle = "";
        switch (indexJobTitle){
            case 1 -> jobTitle = String.valueOf(TypeJob.DIRECTIVO);
        }



        int idCount = 0;


        Employee selectEmployee = new Employee(new JobTitle(idCount,jobTitle),person);
        //TODO REVISAR COMO ASOCIAR A LA PERSONA PARA QUE SEA EMPLEADO! ESTA BOTANDO NullPointerException EN LA SENTENCIA 289
        // Validar si el estudiante ya está matriculado en el programa
        boolean estudianteMatriculado = selectEmployee.getPerson_employees().contains(selectEmployee);

        if (estudianteMatriculado) {
            System.out.println("El estudiante ya está matriculado en este programa.");
        } else {
            selectEmployee.person_assigned_employee(selectEmployee);
            System.out.println("Estudiante matriculado exitosamente en el programa académico.");
        }
    }


    private static void registerCampus() {
        System.out.println("=== Registrar Sedes ===");

        String nameCampus= null;
        String codeCampus = null;
        boolean centralCampus = false;
        List<Employee> employeList = new ArrayList<>();

        // Ciclo para validar y registrar los datos del estudiante
        while (true) {
            // Si el codigo del campus no se ha registrado
            if (codeCampus == null) {
                System.out.print("Id Sede: ");
                codeCampus = leerCadenaNoVacia();

                // Validar si el campus ya esta registrado codeCampus
                for (Campus campus : campusList) {
                    if (campus.getCodeCampus().equalsIgnoreCase(codeCampus)) {
                        System.out.println("Ya se encuentra una sede con el codigo proporcionado");
                        codeCampus= null; // Reiniciar para volver a pedir el dato
                        break;
                    }
                }
            } // Si el nombre de la sede no se ha ingresado
            else if (nameCampus == null) {
                System.out.print("Nombres: ");
                nameCampus = leerCadenaNoVaciaTexto();
            } // Validar si es la sede principal
            else if(centralCampus == false){
                String auxCode = null;
                System.out.println("Este es el campus central (SI/NO):");
                auxCode = leerCadenaNoVacia();
                if (auxCode.equalsIgnoreCase("si")) {
                    centralCampus = true;
                }else{
                  centralCampus = false;
                }
            }

            // Si se han ingresado todos los datos requeridos, registrar la persona
            if (codeCampus != null && nameCampus!= null) {
                campusList.add(new Campus(nameCampus, codeCampus, centralCampus,employeList));
                System.out.println("Campus registrado exitosamente");
                //guardarCampusEnArchivo();
                break; // Salir del bucle en caso de éxito
            }
        }
    }
    public void registerEmployeeCampus() {
        System.out.println("=== EMPLEADO - SEDE ===");
        if (employeeList.isEmpty()) {
            System.out.println("No hay empleados registradas.");
            return;
        }

        showRegisterEmployees();

        System.out.print("Ingrese el índice de la sede en la que desee inscribir el empleado: ");
        int indexCampus = leerIndiceValido(campusList.size());

        Campus campusSelected = campusList.get(indexCampus);

        if(campusList.isEmpty()){
            System.out.println("No hay Sedes creadas ");
            return;
        }

        showRegisterCampus();

        System.out.println("Ingrese el indice del empleado que desea inscribir en la sede");
        int indexEmployee = leerIndiceValido(employeeList.size());

        Employee employeSelected = employeeList.get(indexEmployee);

        boolean checkEmployeeSelected= employeSelected.getPerson_employees().contains(employeSelected);

        if (checkEmployeeSelected) {
            System.out.println("El empleado ya esta registrado en esta sede");
        } else {
            campusSelected.employeeCampus(employeSelected);
            System.out.println("Empleado registrado en la sede exitosamente");
        }
    }

    private static void showRegisterEmployees() {
        System.out.println("=== Empleados Registrados ===");

        if (employeeList.isEmpty()) {
            System.out.println("No hay empleados registrados.");
        } else {
            int index = 0;
            for (Employee employee : employeeList) {
                System.out.println("Índice " + index + ": " + employee.getPerson_employees() + " (Cargo: " + employee.getJobTitle() + ")");
                index++;
            }
        }
    }

    private static void showRegisterCampus() {
        System.out.println("=== Sedes Registradas ===");

        if (campusList.isEmpty()) {
            System.out.println("No hay sedes registradas.");
        } else {
            int index = 0;
            for (Campus campus : campusList) {
                System.out.println("Índice " + index + ": " + campus);
                index++;
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

    private static int leerIndiceValido(int maximo) {
        int indice;
        while (true) {
            try {
                System.out.print("Ingrese un índice válido: ");
                String input = reader.readLine().trim();
                indice = Integer.parseInt(input);
                if (indice >= 0 && indice < maximo) {
                    break;
                }
                System.out.println("Índice no válido. Intente nuevamente.");
            } catch (NumberFormatException | IOException e) {
                System.out.println("Error: Ingrese un número válido.");
            }
        }
        return indice;
    }

    private static String leerCodigoNumerico() {
        String input;
        while (true) {
            try {
                input = reader.readLine().trim();
                if (!input.isEmpty() && input.matches("^[0-9]+$")) { // Verifica que la entrada contenga solo números
                    return input;
                }
                System.out.println("Ingrese un valor válido (solo números). Intente nuevamente.");
            } catch (IOException e) {
                System.out.println("Error al leer la entrada.");
            }
        }
    }

}