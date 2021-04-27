package br.com.gabriel.service.impl;

import br.com.gabriel.model.Client;
import br.com.gabriel.model.Contact;
import br.com.gabriel.repository.ClientRepository;
import br.com.gabriel.repository.impl.ClientMySQLRepository;
import br.com.gabriel.service.ClientService;

import java.util.List;

public class ClientServiceImpl implements ClientService {
    public ClientRepository clientRepository = new ClientMySQLRepository();

    @Override
    public void newClient(String name, String telephone, String address, String cnpj, String shippingCompany) {
        final Client client = new Client(name, telephone, address, cnpj, shippingCompany);
        clientRepository.addNewClient(client);

    }

    @Override

    public void newContact(Client client, String name, String telephone, String email, String sector, String celphone) {
        Contact contact = new Contact();
        contact.setName(name);
        contact.setTelephone(telephone);
        contact.setEmail(email);
        contact.setSector(sector);
        contact.setCellphone(celphone);
        clientRepository.addNewContact(client, contact);
    }

    @Override
    public List<Client> findAll() {
        return null;
    }

    @Override
    public void getInformation() {


    }


}
