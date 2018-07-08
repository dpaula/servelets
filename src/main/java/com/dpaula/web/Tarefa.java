package com.dpaula.web;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public interface Tarefa {

	String executa(ServletRequest req, ServletResponse resp);

}
