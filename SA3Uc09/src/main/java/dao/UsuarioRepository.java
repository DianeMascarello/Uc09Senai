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
		
		
		String insertsql = "INSERT INTO usuario(nome_Usuario, email_Usuario, login, senha) VALUES (?, ?, ?, ?);";
		PreparedStatement stmt = conn.prepareStatement(insertsql);
		stmt.setString(1, objeto.getNome());
		stmt.setString(2, objeto.getUsuario());
		stmt.setString(3, objeto.getUsuario());
		stmt.setString(4, objeto.getSenha());

		stmt.execute();

		conn.commit();	

		return this.consultarUsuario(objeto.getUsuario());
		
	}
	
	public Usuario consultarUsuario(String objeto) throws Exception {
		    Usuario user01 = new Usuario();
	
		    String sql = "SELECT * FROM usuario WHERE login = ?";
	
		    PreparedStatement stmt = conn.prepareStatement(sql);
		    stmt.setString(1, objeto);
	
		    ResultSet rst = stmt.executeQuery();
	
		    while (rst.next()) {
		        user01.setNome(rst.getString("nome"));
		        user01.setUsuario(rst.getString("email_Usuario"));
		        user01.setUsuario(rst.getString("login"));
		        user01.setSenha(rst.getString("senha"));
		    }
	
		    return user01;
		}
	
	public boolean vericaUsuario(String usuario) throws Exception{
		String sql = "SELECT COUNT(1) > 0 AS EXISTE FROM usuario where login = ? ";
		
		PreparedStatement stmt = conn.prepareStatement(sql);
	    stmt.setString(1, usuario);

		ResultSet res = stmt.executeQuery();
		
		res.next();
		return res.getBoolean("existe");
	}
	
	
}