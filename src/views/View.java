package views;

public class View {
    public static final String MAIN_MENU = "=== MENÚ - Sistema ERP - Organizacion ===\n1. PERSONA\n2. EMPLEADO\n3. SEDE\n4. EMPRESA\n0. Salir";
    public static final String LOAD_EXIT = "Guardando datos antes de salir...";
    public static final String BYE = "¡Gracias por visitarnos!";
    public static final String MENU_PERSON = "=== MENÚ - ESTUDIANTES ===\n1. Ver personas registradas"
            + "\n2. Registrar una nueva persona\n3. Modificar registro de persona\n4. Eliminar registro de persona\n0. Salir";
    public static final String NOT_REGISTERED_PERSON = "No hay Personas registradas.";


    public void showMenu() {// mostrar opciones menú
        System.out.println(MAIN_MENU);
    }

    public void showMenuPerson(){
        System.out.println(MENU_PERSON);
    }
    public void showMenuEmployees(){
        System.out.println("=== MENÚ - EMPLEADO ===\n1. Ver empleados registrados\n2. Registrar un nuevo empleado" +
                "\n3. Modificar registro empleado\n4. Eliminar registro empleado\n0. Salir");
    }




    public void enterOption(){
        System.out.print("Ingrese una opción: ");
    }

    public void noRegisteredPerson(){
        System.out.println(NOT_REGISTERED_PERSON);
    }
    public void showBye(){
        System.out.println(BYE);
    }
    public void showInvalidateOption() {
        System.out.println("Opción no válida. Intente nuevamente.");
    }
}
