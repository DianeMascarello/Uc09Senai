package model;

import java.io.Serializable;

public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String email;
	private String usuario;
	private String senha;
	private String confirmarsenha;
	
	public boolean ehNovo() {
		if (this.email == null) {
			return true;
		}else if (this.email != null) {
			return false;
		}
		return email == null;
	}
	
	
	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getEmail() {
		return email;
	}
	
		public void setEmail(String email) {
			this.email = email;
		}

	public String getUsuario() {
		return usuario;
	}
	
		public void setUsuario(String usuario) {
			this.usuario = usuario;
	}
		
	public String getSenha() {
		return senha;
	}
	
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public String getconfirmarSenha() {
		return confirmarsenha;
	}
	
	public void setconfirmarSenha(String confirmarsenha) {
		this.confirmarsenha = confirmarsenha;
	}

}
