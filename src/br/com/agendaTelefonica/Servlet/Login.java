package br.com.agendaTelefonica.Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import br.com.agendaTelefonica.DAO.UsuarioDAO;
import br.com.agendaTelefonica.Model.Usuario;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String login = request.getParameter("login");
		String senha = request.getParameter("senha");

		try {		
			// Valida usuario
			UsuarioDAO user = new UsuarioDAO();
			Usuario usuario = new Usuario();
			usuario.setLogin(login);
			usuario.setSenha(senha);
			usuario = user.efetuarLogin(usuario);

			if(usuario != null) {

				if((usuario.getLogin().equals(login)) && (usuario.getSenha().equals(senha))) {
					request.getSession().setAttribute("logado", "ok");
					request.getSession().setAttribute("idUsuario", usuario.getIdUsuario());
					request.getSession().setAttribute("nome", usuario.getNome());

					response.sendRedirect("agendaTelefonica.jsp");
				} 
			}else{
				response.sendRedirect("home.jsp");
				JOptionPane.showMessageDialog(null, "Login ou Senha incorreto!");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}	
}

