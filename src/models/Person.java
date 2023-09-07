package models;

public class Person {

    private int id_person;
    private String nameLastName;

    public Person(int id_person, String nameLastName) {
        this.id_person = id_person;
        this.nameLastName = nameLastName;
    }

    public int getId_person() {
        return id_person;
    }

    public void setId_person(int id_person) {
        this.id_person = id_person;
    }

    public String getNameLastName() {
        return nameLastName;
    }

    public void setNameLastName(String nameLastName) {
        this.nameLastName = nameLastName;
    }
}
