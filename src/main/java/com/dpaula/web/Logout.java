package com.dpaula.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.dpaula.Usuario;

@WebServlet(urlPatterns = "/logout")
public class Logout extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		Usuario usuario = (Usuario) req.getSession().getAttribute("usuario.logado");

		PrintWriter writer = resp.getWriter();
		if (usuario == null) {
			writer.println("<html><body>Usuário não estava logado!</body></html>");
			return;
		}

		req.getSession().removeAttribute("usuario.logado");

		resp.sendRedirect("logout.html");

		// writer.println("<html><body>Usuário: " + usuario.getEmail() + " Deslogado com
		// sucesso!</body></html>");
	}

}