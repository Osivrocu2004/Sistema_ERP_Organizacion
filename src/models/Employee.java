package models;

import java.util.List;

public class Employee {

    private JobTitle jobTitle;

    List<Person> person_employees;

    Person person;

    public Employee(JobTitle jobTitle, Person person) {
        this.jobTitle = jobTitle;
        this.person = person;
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

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public List<Person> getPersonEmployees() {
        return person_employees;
    }

    public void setPersonEmployees(List<Person> person_employees) {
        this.person_employees = person_employees;
    }

    @Override
    public String toString() {
        return "Cargo: " + jobTitle +
                ", person_employees: " + person_employees +
                ", person: " + person;
    }
}
