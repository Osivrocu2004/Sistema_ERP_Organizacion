package models;

import java.util.List;

public class Company {

    private String nameCompany;
    private String codeCompany;
    private List<Campus> campusCompany;

    public Company(String nameCompany, String codeCompany, List<Campus> campusCompany) {
        this.nameCompany = nameCompany;
        this.codeCompany = codeCompany;
        this.campusCompany = campusCompany;
    }
}
