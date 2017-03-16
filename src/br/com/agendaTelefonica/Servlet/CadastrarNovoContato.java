package br.com.agendaTelefonica.Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import br.com.agendaTelefonica.DAO.TelefoneDAO;
import br.com.agendaTelefonica.Model.Telefone;

/**
 * Servlet implementation class cadastrarUsusario
 */
@WebServlet("/CadastrarNovoContato")
public class CadastrarNovoContato extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CadastrarNovoContato() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String nome = request.getParameter("nome");
		String email = request.getParameter("email");
		String telefone = request.getParameter("telefone");

		String idUsuario =  request.getSession().getAttribute("idUsuario").toString();
		TelefoneDAO dao = new TelefoneDAO();

		try{
			Telefone t = new Telefone();

			t.setEmail(email);
			t.setNome(nome);
			t.setNumTelefone(telefone);
			t.setIdUsuario_Tel(Integer.parseInt(idUsuario));

			dao.adicionar(t);
			//redirecionar aqui.		
			JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso");
			response.sendRedirect("agendaTelefonica.jsp");

		}catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Ocorreu um erro ao cadastrar o novo contato.");
			e.printStackTrace();


		}
	}



}


