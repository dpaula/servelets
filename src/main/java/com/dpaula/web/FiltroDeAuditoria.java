package com.dpaula.web;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

@WebFilter(urlPatterns = "/*")
public class FiltroDeAuditoria implements Filter {

	@Override
	public void destroy() {
	}

	// O conceito de filtro é amplamente utilizado em aplicações web como uma
	// maneira de
	// adicionar características a parte da aplicação. Usando a API de servlets
	// basta
	// criar uma classe que implementa Filter e anotá-la com WebFilter.
	// Em outras APIs é comum encontrar o nome de Interceptor ao invés de Filter
	// para o mesmo conceito.
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest req = (HttpServletRequest) request;
		// pegando a uri do request
		String uri = req.getRequestURI();

		String usuario = getUsuarioLogado(req);

		System.out.println("Usuário : " + usuario + " acessando a URI: " + uri);

		// continuando com a requisição
		chain.doFilter(request, response);
	}

	/**
	 * @param req
	 * @return
	 */
	private String getUsuarioLogado(HttpServletRequest req) {
		String usuario = "<deslogado>";

		if (req.getCookies() instanceof Cookie[]) {
			Cookie[] cookies = (Cookie[]) req.getCookies();

			for (Cookie cookie : cookies) {
				if (cookie.getName().equals("usuario.logado")) {
					usuario = cookie.getValue();
				}
			}
		}
		return usuario;
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
	}

}
