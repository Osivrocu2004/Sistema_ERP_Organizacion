package models;

public class JobTitle {

    private int idJobTitle;
    private String nameJobTitle;

    public JobTitle(int idJobTitle, String nameJobTitle) {
        this.idJobTitle = idJobTitle;
        this.nameJobTitle = nameJobTitle;
    }

    public int getIdJobTitle() {
        return idJobTitle;
    }

    public void setIdJobTitle(int idJobTitle) {
        this.idJobTitle = idJobTitle;
    }

    public String getNameJobTitle() {
        return nameJobTitle;
    }

    public void setNameJobTitle(String nameJobTitle) {
        this.nameJobTitle = nameJobTitle;
    }
}
