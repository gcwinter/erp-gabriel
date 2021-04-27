package br.com.gabriel.repository.impl;

import br.com.gabriel.model.Client;
import br.com.gabriel.model.Contact;
import br.com.gabriel.repository.ClientRepository;
import br.com.gabriel.repository.ConnectionMySQL;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



public class ClientMySQLRepository implements ClientRepository {

    private static final Connection CONNECTION_MY_SQL = ConnectionMySQL.getConnectionMySQL();

    @Override
    public void addNewClient(Client client) {
        try {
//TODO CRIAR BANCO DE DADOS GERAL QUE CONTENHA TODAS OS CLIENTES E CRIAR BANCO DE DADO DE CONTATO PARA CADA CLIENTE

            final var query = "INSERT INTO Clients(name,telephone,address,cnpj,shipping_company) VALUES (?,?,?,?,?)";

            final var preparedStatement = CONNECTION_MY_SQL.prepareStatement(query);
            preparedStatement.setString(1, client.getName());
            preparedStatement.setString(2, client.getTelephone());
            preparedStatement.setString(3, client.getAddress());
            preparedStatement.setString(4, client.getCnpj());
            preparedStatement.setString(5, client.getShippingCompany());

            preparedStatement.execute();


        } catch (SQLException throwables) {
            System.out.println(throwables.getErrorCode());

        }
    }



    @Override
    public List<Client> findAll() {
        return null;
    }

    @Override
    public void addNewContact(Client client, Contact contact) {

        //TODO ADICIONAR O CONTATO AO BANCO DE DADOS DE CONTATOS CRIADO EM CADA CLIENTE


    }

}
