package br.com.gabriel.model;

import java.util.ArrayList;
import java.util.List;

public class Client {

    private final String name;
    private String telephone;
    private String address;
    private final String cnpj;
    private String shippingCompany;
    private final List<Contact> contacts = new ArrayList<>();

    public Client(String name, String telephone, String address, String cnpj, String shippingCompany) {

        this.name = name;
        this.telephone = telephone;
        this.address = address;
        this.cnpj = cnpj;
        this.shippingCompany = shippingCompany;
    }
    public String getName() {
        return name;
    }
    public String getTelephone() {
        return telephone;
    }
    public String getAddress() {
        return address;
    }

    public String getCnpj() {
        return cnpj;
    }
    public String getShippingCompany() {
        return shippingCompany;
    }
    public List<Contact> getContacts() {
        return contacts;
    }

   public void addNewContact(Contact contact){
        this.contacts.add(contact);

    }



    public void contactList() {
        for (Contact contact : contacts) {
            System.out.println(contact.getContact());
        }
    }

//    TODO arrumando getInformation para o lugar certo que é o controller
    public void getInformation() {
        System.out.println(
                String.format("Name:      %s \nTelephone: %s \nAdress:    %s \nCNPJ:      %s \nCourrier:  %s \n",
                        this.name, this.telephone, this.address, this.cnpj, this.shippingCompany));
    }
}
