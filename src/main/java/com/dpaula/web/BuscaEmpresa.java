package com.dpaula.web;

import java.util.Collection;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import br.com.dpaula.Empresa;
import br.com.dpaula.dao.EmpresaDAO;

public class BuscaEmpresa implements Tarefa {

	@Override
	public String executa(ServletRequest req, ServletResponse resp) {
		// http://localhost:8080/servlets/fazTudo?tarefa=BuscaEmpresa&filtro=doce
		String filtro = req.getParameter("filtro");
		Collection<Empresa> empresas = new EmpresaDAO().buscaPorSimilaridade(filtro);

		req.setAttribute("empresas", empresas);

		// retorna a uri para que o fazTudo faça o redirecionamento correto
		return "WEB-INF/paginas/buscaEmpresa.jsp";
	}

}
