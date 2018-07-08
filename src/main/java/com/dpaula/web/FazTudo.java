package com.dpaula.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

@WebServlet(urlPatterns = "/fazTudo")
public class FazTudo extends HttpServlet {

	@Override
	public void service(ServletRequest req, ServletResponse resp) throws ServletException, IOException {

		String tarefa = req.getParameter("tarefa");

		if (tarefa == null) {
			throw new IllegalArgumentException("Tarefa não informada!");
		}

		tarefa = "com.dpaula.web." + tarefa;

		try {
			Class<?> classe = Class.forName(tarefa);
			Tarefa instancia = (Tarefa) classe.newInstance();
			String uriDispatcher = instancia.executa(req, resp);
			RequestDispatcher requestDispatcher = req.getRequestDispatcher(uriDispatcher);
			requestDispatcher.forward(req, resp);

		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			throw new ServletException(e);
		}

	}

}
