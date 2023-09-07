package models;

public class Charge {

    private String idCharge;
    private String nameCharge;

    public Charge(String idCharge, String nameCharge) {
        this.idCharge = idCharge;
        this.nameCharge = nameCharge;
    }

    public String getIdCharge() {
        return idCharge;
    }

    public String getNameCharge() {
        return nameCharge;
    }
}
