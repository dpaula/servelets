package com.dpaula.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.dpaula.Empresa;
import br.com.dpaula.dao.EmpresaDAO;

@WebServlet(urlPatterns = "/busca")
public class BuscaEmpresa extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// rep = requisição = as informações que o cliente manda
		// resp = resposta = as informações que vou enviar para o cliente
		PrintWriter writer = resp.getWriter();
		writer.println("<html><body>");
		writer.println("Resultado da busca: <br/>");

		// http://localhost:8080/servlets/busca?filtro=doce

		String filtro = req.getParameter("filtro");

		Collection<Empresa> empresas = new EmpresaDAO().buscaPorSimilaridade(filtro);

		req.setAttribute("empresas", empresas);

		RequestDispatcher requestDispatcher = req.getRequestDispatcher("WEB-INF/paginas/buscaEmpresa.jsp");
		requestDispatcher.forward(req, resp);

	}

}
