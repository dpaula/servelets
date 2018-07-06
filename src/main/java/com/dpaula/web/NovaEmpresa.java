package com.dpaula.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.dpaula.Empresa;
import br.com.dpaula.dao.EmpresaDAO;

@WebServlet(urlPatterns = "/novaEmpresa")
public class NovaEmpresa extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// http://localhost:8080/servlets/novaEmpresa?nome=Philips

		String nome = req.getParameter("nome");
		Empresa empresa = new Empresa(nome);

		new EmpresaDAO().adiciona(empresa);

		PrintWriter writer = resp.getWriter();
		writer.println("<html><body>Empresa " + empresa.getNome() + " cadastrada com sucesso!</body></html>");
	}

}
