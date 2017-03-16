<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html><html>
<head>
<meta charset="UTF-8">
<title>Novo Contato</title>
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

								<h2>Novo Contato</h2>
								<br>
								<br>
								<form action=CadastrarNovoContato method="post">
									Nome: <br><input name="nome" type="text" size="30" id="nome" required placeholder="Informe o nome do contato." ><br><br>
									Telefone: <br><input name="telefone" type="tel" size="25"  required id="telefone" placeholder="Informe o telefone do contato."> <br><br>
									Email: <br><input name="email" type="email" size="50" id="email" placeholder="Informe o email do contato."><br>
									<br>
									<br> <input class="bnt" name="salvar" type="submit" value="Cadastrar">


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