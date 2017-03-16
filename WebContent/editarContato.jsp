<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Editar Contato</title>
<%@ page import="br.com.agendaTelefonica.Model.Telefone"%>
<%@ page import="br.com.agendaTelefonica.DAO.TelefoneDAO"%>
<%@ page import="java.util.List"%>
<%@ page import="javax.swing.JOptionPane" %>
<Link rel="Stylesheet" href="style.css" type="text/css">
</head>
<body>
	<div id="wrapper">

		<div id="header-wrapper">

			<div id="navigation">
				<ul>
					<li><a class="menu" href="cadastroTelefone.jsp">Novo
							Contato</a></li>
					<li><a class="menu" href="agendaTelefonica.jsp"
						style="position: relative; right: 10px;"> Lista de Contatos</a></li>
					<li><a class="menu" href="Logout"> Logout</a></li>

				</ul>
			</div>


			<div id="page">
				<div id="page-bgtop">

					<div id="page">
						<div id="page-bgtop2">
							<div id="page-bgbtm">

								<h2>Editar Contato</h2>
								<br>
								<br>
								<form action=EditarContato method="post">
									<input type="hidden" name="idTelefone" id="idTelefone"  value="<%=request.getParameter("idTelefone")%>">								
									Nome: <br><input name="nome" type="text" size="30" id="nome" placeholder="Informe o nome do contato." required value="<%=request.getParameter("nome")%>"><br><br>
									Telefone: <br><input name="telefone" type="tel" size="25" required placeholder="Informe o telefone do contato." id="telefone" value="<%=request.getParameter("telefone")%>"> <br><br>
									Email: <br><input name="email" type="email" size="50" id="email" placeholder="Informe o email do contato." value="<%=request.getParameter("email")%>"><br>
									<br>
									<br> <input class="bnt" name="salvar" type="submit" value="Editar">


								</form>

							</div>
						</div>
					</div>
					<div style="clear: both; height: 20px; padding-left: 130px;">&nbsp;</div>
				</div>
			</div>
		</div>



		<!-- End page -->


		<div id="footer">
			<p>Alline de Lara</p>

			<br>

		</div>
</body>
</html>