package com.dpaula.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;

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

		String filtro = "doce";

		Collection<Empresa> empresas = new EmpresaDAO().buscaPorSimilaridade(filtro);
		writer.println("<ul>");

		for (Empresa empresa : empresas) {
			writer.println("<li>");
			writer.println(empresa.getId() + ": " + empresa.getNome());
			writer.println("</li>");
		}

		writer.println("</ul>");

		writer.println("</body></html>");
	}

}
