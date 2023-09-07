package models;

public class JobTitle {

    private String idJobTitle;
    private String nameJobTitle;

    public JobTitle(String idJobTitle, String nameJobTitle) {
        this.idJobTitle = idJobTitle;
        this.nameJobTitle = nameJobTitle;
    }

    public String getIdJobTitle() {
        return idJobTitle;
    }

    public void setIdJobTitle(String idJobTitle) {
        this.idJobTitle = idJobTitle;
    }

    public String getNameJobTitle() {
        return nameJobTitle;
    }

    public void setNameJobTitle(String nameJobTitle) {
        this.nameJobTitle = nameJobTitle;
    }
}
