package br.com.agendaTelefonica.Model;

public class Telefone {

	private int idTelefone, idUsuario_Tel;
	private String nome, numTelefone, email;

	public int getIdUsuario_Tel() {
		return idUsuario_Tel;
	}

	public void setIdUsuario_Tel(int idUsuario_Tel) {
		this.idUsuario_Tel = idUsuario_Tel;
	}

	public int getIdTelefone() {
		return idTelefone;
	}

	public void setIdTelefone(int idTelefone) {
		this.idTelefone = idTelefone;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNumTelefone() {
		return numTelefone;
	}

	public void setNumTelefone(String numTelefone) {
		this.numTelefone = numTelefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
