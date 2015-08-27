package com.uberdist.usuario;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class LoginBean {

	private Usuario usuario = new Usuario();
	
	private Usuarios usuarios = new HibernateUsuarioDao();
	
	public String login() {
		if (usuarios.existe(usuario)) {
			return "produto";
		}
		return "login";
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
}
