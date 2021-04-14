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

    public void newContact(String name, String telephone, String email, String sector, String celphone) {
        Contact contact = new Contact();
//        TODO Esse codigo deveria ser movido para o controller, pois o controler normalmente se encarrega de fazer todas as validações de uma entrada/saida de dado
        if (name == null) {
            name = "***Não cadastrado***";
        }
        if (telephone == null) {
            telephone = "***Não cadastrado***";
        }
        if (email == null) {
            email = "***Não cadastrado***";
        }
        if (sector == null) {
            sector = "***Não cadastrado***";
        }
        if (celphone == null) {
            celphone = "***Não cadastrado***";
        }

        contact.setName(name);
        contact.setTelephone(telephone);
        contact.setEmail(email);
        contact.setSector(sector);
        contact.setCellphone(celphone);
        contacts.add(contact);
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
