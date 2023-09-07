package views;

public class View {
    public static final String MAIN_MENU = "=== MENÚ - Sistema ERP - Organizacion ===\n1. PERSONA\n2. EMPLEADO\n3. SEDE\n4. EMPRESA\n0. Salir";
    public static final String LOAD_EXIT = "Guardando datos antes de salir...";
    public static final String BYE = "¡Gracias por visitarnos!";
    public static final String MENU_PERSON = "=== MENÚ - ESTUDIANTES ===\n1. Ver personas registradas"
            + "\n2. Registrar una nueva persona\n3. Modificar registro de persona\n4. Eliminar registro de persona\n0. Salir";


    public void showMenu() {// mostrar opciones menú
        System.out.println(MAIN_MENU);
    }

    public void showMenuPerson(){
        System.out.println(MENU_PERSON);
    }

}
