package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import conexao.ConexaoBanco;
import model.Usuario;

public class UsuarioRepository {
	private Connection conn;
	
	public UsuarioRepository() {
		conn = ConexaoBanco.getConnection();
	}
	
	public Usuario insereUsuario(Usuario objeto) throws Exception{
		if (objeto.ehNovo()) {
		String sql = "INSERT INTO usuario(nome_Usuario, email_Usuario, login, senha) VALUES (?, ?, ?, ?);";

		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1, objeto.getUsuario());
		stmt.setString(2, objeto.getEmail());
		stmt.setString(3, objeto.getEmail());
		stmt.setString(4, objeto.getSenha());

		stmt.execute();

		conn.commit();	
		}else {
			String sql = "UPDATE usuario SET nome_Usuario = ?, email_Usuario = ?, login = ?, senha = ? WHERE email_Usuario = ?";			
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, objeto.getUsuario());
			stmt.setString(2, objeto.getEmail());
			stmt.setString(3, objeto.getEmail());
			stmt.setString(4, objeto.getSenha());
			stmt.setString(5, objeto.getEmail());
			
			stmt.executeUpdate();
			
			conn.commit();
		}
		return this.consultarUsuario(objeto.getUsuario());
	}
	
	public Usuario consultarUsuario(String usuario) throws Exception{
		Usuario user01 = new Usuario();
		
		
		return user01;
	}
	
	public boolean vericaUsuario(String usuario) throws Exception{
		String sql = "SELECT COUNT(1) > 0 AS EXISTE FROM usuario where login = '"+usuario+"';";
		
		PreparedStatement stmt = conn.prepareStatement(sql);
	    stmt.setString(1, usuario);

		ResultSet res = stmt.executeQuery();
		
		res.next();
		return res.getBoolean("existe");
	}
}