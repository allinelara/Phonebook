package br.com.agendaTelefonica.Conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory{
    
    public Connection getConnection() throws Exception {
        try {
        	Class.forName("com.mysql.jdbc.Driver").newInstance();
        	return DriverManager.getConnection("jdbc:mysql://localhost:3306/telefones", "root", "alline");
        } catch (SQLException ex) {
        	ex.printStackTrace();
            throw new RuntimeException(ex);
        } catch (ClassNotFoundException e){
        	e.printStackTrace();
        	throw new RuntimeException(e);
        } catch (Exception e){
        	e.printStackTrace();
        	throw new RuntimeException(e);
        }
    }
}