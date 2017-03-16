package br.com.agendaTelefonica.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.agendaTelefonica.Conexao.ConnectionFactory;
import br.com.agendaTelefonica.Model.Telefone;

public class TelefoneDAO {
	

	Connection connection = null ;

	public TelefoneDAO()  {
		try {
			this.connection = new ConnectionFactory().getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<Telefone> listar(int idUsuario) throws SQLException{
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT p.id, p.nome, p.numTelefone, p.email, f.id FROM telefones p ");
		sql.append("INNER JOIN users f ON f.id = p.users_id and p.users_id = ? ");


		PreparedStatement comando = connection.prepareStatement(sql.toString());	
		comando.setInt(1, idUsuario);
		ResultSet resultado = comando.executeQuery();

		ArrayList<Telefone> lista = new ArrayList<Telefone>();

		while (resultado.next()){
			Telefone t = new Telefone();
			t.setIdTelefone(resultado.getInt("p.id"));
			t.setNome(resultado.getString("p.nome"));
			t.setNumTelefone(resultado.getString("p.numTelefone"));
			t.setEmail(resultado.getString("p.email"));
			t.setIdUsuario_Tel(resultado.getInt("f.id"));
			
			lista.add(t);
		}

		return lista;
	}
	
	public void remover (int idTelefone) throws SQLException{
		StringBuilder sql = new StringBuilder();
		sql.append("DELETE FROM telefones ");
		sql.append("WHERE id = ? ");

		PreparedStatement comando = connection.prepareStatement(sql.toString());	
		comando.setInt(1, idTelefone);
		comando.executeUpdate();	
		
	}
	
	public void editar (Telefone t) throws SQLException{
		StringBuilder sql = new StringBuilder();
		sql.append("UPDATE telefones ");
		sql.append("SET nome = ?, email = ?, numTelefone = ? ");
		sql.append("WHERE id = ? and users_id = ?");
	
		
		PreparedStatement comando = connection.prepareStatement(sql.toString());	
		comando.setString(1, t.getNome());
		comando.setString(2, t.getEmail());
		comando.setString(3, t.getNumTelefone());
		comando.setInt(4, t.getIdTelefone());
		comando.setInt(5, t.getIdUsuario_Tel());
		comando.executeUpdate();
		
	}
	public void adicionar (Telefone t) throws SQLException{
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO telefones  ");
		sql.append("(nome, email, numTelefone, users_id) ");
		sql.append("VALUES (?, ?, ?, ?) ");

		PreparedStatement comando = connection.prepareStatement(sql.toString());	
		comando.setString(1, t.getNome());
		comando.setString(2, t.getEmail());
		comando.setString(3, t.getNumTelefone());
		comando.setInt(4, t.getIdUsuario_Tel());

		comando.executeUpdate();

		
	}
}
