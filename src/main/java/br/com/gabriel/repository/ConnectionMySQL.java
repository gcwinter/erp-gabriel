package br.com.gabriel.repository;


import java.sql.Connection;

import java.sql.DriverManager;

import java.sql.SQLException;

public class ConnectionMySQL {

    public static String status = "Não conectou...";

    private ConnectionMySQL() {
    }

    public static java.sql.Connection getConnectionMySQL() {
        Connection connection = null;          //atributo do tipo Connection
        try {
            String driverName = "com.mysql.jdbc.Driver";
            Class.forName(driverName);
            String serverName = "localhost:3306";    //caminho do servidor do BD
            String mydatabase ="ERP_Gabriel";        //nome do seu banco de dados
            String url = "jdbc:mysql://" + serverName + "/" + mydatabase;
            String username = "root";        //nome de um usuário de seu BD
            String password = "123456";      //sua senha de acesso
            connection = DriverManager.getConnection(url, username, password);
            //Testa sua conexão//
            if (connection != null) {
                status = ("STATUS--->Conectado com sucesso!");
            } else {
                status = ("STATUS--->Não foi possivel realizar conexão");
            }
            return connection;
        } catch (ClassNotFoundException e) {  //Driver não encontrado
            System.out.println("O driver expecificado nao foi encontrado.");
            return null;
        } catch (SQLException e) {
            System.out.println("Nao foi possivel conectar ao Banco de Dados.");
            return null;
        }
    }

    //Método que retorna o status da sua conexão//
    public static String statusConection() {
        return status;
    }


    //Método que fecha sua conexão//
    public static boolean FecharConexao() {

        try {
            ConnectionMySQL.getConnectionMySQL().close();
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    //Método que reinicia sua conexão//
    public static Connection ReiniciarConexao() {
        FecharConexao();
        return ConnectionMySQL.getConnectionMySQL();
    }
}
