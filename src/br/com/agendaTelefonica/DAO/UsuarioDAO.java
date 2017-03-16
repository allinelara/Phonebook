package br.com.agendaTelefonica.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.agendaTelefonica.Conexao.ConnectionFactory;
import br.com.agendaTelefonica.Model.Usuario;

public class UsuarioDAO {

	Connection connection = null ;

	public UsuarioDAO()  {
		try {
			this.connection = new ConnectionFactory().getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public Usuario efetuarLogin(Usuario u) throws SQLException{
		
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT id, nome FROM users ");
		sql.append("WHERE emaill = ? and senha = ?");
			
		PreparedStatement comando = connection.prepareStatement(sql.toString());	
		comando.setString(1, u.getLogin());
		comando.setString(2, u.getSenha());
		
		ResultSet resultado = comando.executeQuery();
		Usuario retorno = null;
		if(resultado.next()){
			retorno = new Usuario();
			retorno.setIdUsuario(resultado.getInt("id"));
			retorno.setNome(resultado.getString("nome"));
			retorno.setLogin(u.getLogin());
			retorno.setSenha(u.getSenha());
		}
		return retorno;
	}

	public void salvar(Usuario u) throws SQLException{
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO users  ");
		sql.append("(nome, emaill, senha) ");
		sql.append("VALUES (?, ?, ?) ");

		PreparedStatement comando = connection.prepareStatement(sql.toString());	
		comando.setString(1, u.getNome());
		comando.setString(2, u.getLogin());
		comando.setString(3, u.getSenha());

		comando.executeUpdate();
	}
/*	public static void main(String[] args) {
		
		UsuarioDAO dao = new UsuarioDAO();
		
		Usuario u = new Usuario();
		u.setLogin("alline@gmail.com");
		u.setNome("alline");
		u.setSenha("alline");
		try {
		//	dao.salvar(u);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}*/
}
