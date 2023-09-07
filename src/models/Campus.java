package models;

import java.util.List;

public class Campus {

    private String nameCampus;
    private int codeCampus;
    private List<Employee> employeeCampus;

    public Campus(String nameCampus, int codeCampus, List<Employee> employeeCampus) {
        this.nameCampus = nameCampus;
        this.codeCampus = codeCampus;
        this.employeeCampus = employeeCampus;
    }

    public String getNameCampus() {
        return nameCampus;
    }

    public int getCodeCampus() {
        return codeCampus;
    }

    public List<Employee> getEmployeeCampus() {
        return employeeCampus;
    }
}
