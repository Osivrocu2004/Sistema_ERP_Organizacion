package models;

import java.util.List;

public class Campus {

    private String nameCampus;
    private String codeCampus;
    private List<Employee> employeeCampus;

    public Campus(String nameCampus, String codeCampus, List<Employee> employeeCampus) {
        this.nameCampus = nameCampus;
        this.codeCampus = codeCampus;
        this.employeeCampus = employeeCampus;
    }

    public String getNameCampus() {
        return nameCampus;
    }

    public String getCodeCampus() {
        return codeCampus;
    }

    public List<Employee> getEmployeeCampus() {
        return employeeCampus;
    }
}
