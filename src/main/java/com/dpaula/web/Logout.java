package com.dpaula.web;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import br.com.dpaula.Usuario;

public class Logout implements Tarefa {

	@Override
	public String executa(ServletRequest req, ServletResponse resp) {

		HttpServletRequest httpRequest = (HttpServletRequest) req;

		Usuario usuario = (Usuario) httpRequest.getSession().getAttribute("usuarioLogado");

		httpRequest.getSession().removeAttribute("usuarioLogado");

		return "/WEB-INF/paginas/logout.html";

	}

}
