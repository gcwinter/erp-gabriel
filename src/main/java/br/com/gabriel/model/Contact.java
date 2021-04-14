package br.com.gabriel.model;

public class Contact {

    private String name;
    private String telephone;
    private String cellphone;
    private String email;
    private String sector;

    public void setName(String name) {
        this.name = name;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    public String getContact() {
        return String.format("Name:      %s \nTelephone: %s \nCellphone:  %s \nE-mail:    %s \nSector:    %s \n",
                this.name, this.telephone, this.cellphone, this.email, this.sector);
    }
}
