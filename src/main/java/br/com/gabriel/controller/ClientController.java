package br.com.gabriel.controller;

import br.com.gabriel.model.Client;
import br.com.gabriel.model.Contact;
import br.com.gabriel.service.ClientService;
import br.com.gabriel.service.impl.ClientServiceImpl;

public class ClientController {
    private final ClientService clientServiceImpl = new ClientServiceImpl();


    public void newContact(Client client, String name, String telephone, String email, String sector, String celphone) {


        clientServiceImpl.newContact(client, name, telephone, email, sector, celphone);
    }

//        marelli.contactList();
//        marelli.setData("Magneti Marelli", "11 4555-6666", "Av blablabla 165", "000-2222,222/0001", "ashuhuashusa ");
//        marelli.getInformation();


}
