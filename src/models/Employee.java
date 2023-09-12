package models;

import java.util.List;

public class Employee {

    private JobTitle jobTitle;

    List<Employee> person_employees;

    Person person;

    public Employee(JobTitle jobTitle, Person person) {
        this.jobTitle = jobTitle;
        this.person = person;
    }

    public void person_assigned_employee(Employee employee) {
        person_employees.add(employee);
    }

    public JobTitle getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(JobTitle jobTitle) {
        this.jobTitle = jobTitle;
    }

    public List<Employee> getPerson_employees() {
        return person_employees;
    }

    public void setPerson_employees(List<Employee> person_employees) {
        this.person_employees = person_employees;
    }

    @Override
    public String toString() {
        return "Cargo: " + jobTitle +
                ", person_employees: " + person_employees +
                ", person: " + person;
    }
}
