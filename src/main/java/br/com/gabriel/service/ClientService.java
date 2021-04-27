package br.com.gabriel.service;

import br.com.gabriel.model.Client;
import br.com.gabriel.model.Contact;

import java.util.List;

public interface ClientService {
    void newClient(String name, String telephone, String address, String cnpj, String shippingCompany);
    void newContact(Client client, String name, String telephone, String email, String sector, String celphone);
    List<Client> findAll();
    void getInformation();
}
