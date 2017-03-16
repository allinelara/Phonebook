<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%
	if (session.getAttribute("logado") == null) {
		response.sendRedirect("home.jsp");
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Agenda Telefonica</title>

<%@ page import="br.com.agendaTelefonica.Model.Telefone"%>
<%@ page import="br.com.agendaTelefonica.DAO.TelefoneDAO"%>
<%@ page import="java.util.List"%>
<%@ page import="javax.swing.JOptionPane"%>
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


								<h2>Agenda</h2>
								<br> <br>

								<%
									String delete = request.getParameter("delete");
									if (delete != null) {
										String idTelefone = request.getParameter("idTelefone");

										if (idTelefone == "" || idTelefone == null) {
											JOptionPane.showMessageDialog(null, "Erro ao tentar excluir o contato.");
											response.sendRedirect("agendaTelefonica.jsp");
										} else {
											int idTelefoneInt = Integer.parseInt(idTelefone);
											TelefoneDAO dao = new TelefoneDAO();

											dao.remover(idTelefoneInt);
											session.setAttribute("logado", "ok");
											JOptionPane.showMessageDialog(null, "Contato excluído com sucesso.");
											response.sendRedirect("agendaTelefonica.jsp");

										}
									}
								%>
								<table class="cadastro3">

									<tr>
										<th>Nome</th>
										<th>Telefone</th>
										<th>Email</th>
										<th></th>
										<th></th>
									</tr>
									<%
										TelefoneDAO telDAO = new TelefoneDAO();
										String idUsuario = session.getAttribute("idUsuario").toString();
										List<Telefone> listaTelefone = telDAO.listar(Integer.parseInt(idUsuario));
										int a = listaTelefone.size();
										System.out.println("valor da lista" + a);
										for (int i = 0; i < listaTelefone.size(); i++) {
											Telefone telefone = listaTelefone.get(i);
											System.out.println("contador" + i);
									%>
									<tr>
										<td name="telefone" id="telefone"><%=telefone.getNome()%></td>
										<td name="telefone" id="telefone"><%=telefone.getNumTelefone()%></td>
										<td name="telefone" id="telefone"><%=telefone.getEmail()%></td>
										<td><a
											href="editarContato.jsp?idTelefone=<%=telefone.getIdTelefone()%>&telefone=<%=telefone.getNumTelefone()%>&nome=<%=telefone.getNome()%>&email=<%=telefone.getEmail()%>">Editar</a></td>
										<td><a
											href="agendaTelefonica.jsp?delete=true&idTelefone=<%=telefone.getIdTelefone()%>">Apagar</a>
										</td>
									</tr>

									<%
										}
									%>

								</table>


							</div>
						</div>
					</div>
					<div style="clear: both; height: 20px; padding-left: 130px;">&nbsp;</div>
				</div>
			</div>
			<b class="border_radius page" style="width: 980px; margin: 0 auto;"><b
				class="r5">&nbsp;</b><b class="r4">&nbsp;</b><b class="r3">&nbsp;</b><b
				class="r2">&nbsp;</b><b class="r1">&nbsp;</b></b>
		</div>


		<div id="footer">
			<p>Alline de Lara</p>

			<br>

		</div>
	</div>

</body>
</html>