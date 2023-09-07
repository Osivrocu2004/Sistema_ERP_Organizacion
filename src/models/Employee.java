package models;

import java.util.List;

public class Employee {

    private JobTitle jobTitle;

    List<Person> person_employees;

    public Employee(JobTitle jobTitle, List<Person> person_employees) {
        this.jobTitle = jobTitle;
        this.person_employees = person_employees;
    }

    public JobTitle getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(JobTitle jobTitle) {
        this.jobTitle = jobTitle;
    }

    public List<Person> getPerson_employees() {
        return person_employees;
    }

    public void setPerson_employees(List<Person> person_employees) {
        this.person_employees = person_employees;
    }
}
