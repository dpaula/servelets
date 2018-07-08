package com.dpaula.web;

import javax.servlet.http.Cookie;

public class Cookies {

	private final Cookie[] cookies;

	public Cookies(Cookie[] cookies) {
		this.cookies = cookies;
	}

	public Cookie buscaUsuario() {

		if (this.cookies == null) {
			return null;
		}

		for (Cookie cookie : this.cookies) {
			if (cookie.getName().equals("usuarioLogado")) {
				return cookie;
			}
		}

		return null;
	}

}
