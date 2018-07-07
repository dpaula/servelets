package com.dpaula.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.dpaula.Usuario;
import br.com.dpaula.dao.UsuarioDAO;

@WebServlet(urlPatterns = "/login")
public class Login extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String login = req.getParameter("login");
		String senha = req.getParameter("senha");

		Usuario usuario = new UsuarioDAO().buscaPorEmailESenha(login, senha);

		PrintWriter writer = resp.getWriter();
		writer.println("<html><body>");
		if (usuario == null) {
			writer.println("Usuário inválido!");
		} else {

			HttpSession session = req.getSession();
			session.setAttribute("usuario.logado", usuario);

			writer.println("Usuário logado: " + usuario.getEmail());
		}
		writer.println("</body></html>");
	}

}
