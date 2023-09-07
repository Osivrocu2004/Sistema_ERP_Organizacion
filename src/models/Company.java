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

    public String getNameCompany() {
        return nameCompany;
    }

    public void setNameCompany(String nameCompany) {
        this.nameCompany = nameCompany;
    }

    public String getCodeCompany() {
        return codeCompany;
    }

    public void setCodeCompany(String codeCompany) {
        this.codeCompany = codeCompany;
    }

    public List<Campus> getCampusCompany() {
        return campusCompany;
    }

    public void setCampusCompany(List<Campus> campusCompany) {
        this.campusCompany = campusCompany;
    }
}
