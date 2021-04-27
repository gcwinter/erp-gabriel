package br.com.gabriel.repository;

import br.com.gabriel.model.Client;
import br.com.gabriel.model.Contact;

import java.util.List;

public interface ClientRepository {

    void addNewClient(Client client);

    List<Client> findAll();

    void addNewContact(Client client, Contact contact);


}
