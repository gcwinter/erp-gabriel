package br.com.gabriel.service.impl;

import br.com.gabriel.model.Client;
import br.com.gabriel.service.ClientService;

public class ClientServiceImpl implements ClientService {

    private Client client;

    @Override
    public void newContact() {
        client = new Client("Magneti Marelli", "11 4555-6666", "Av blablabla 165", "000-2222,222/0001", "ashuhuashusa ");
        client.newContact("Gabriel", "1155625", "gwinter", "", "");
    }

    @Override
    public void contactList() {
        client.contactList();
    }

    @Override
    public void getInformation() {
        client.getInformation();
    }


}
