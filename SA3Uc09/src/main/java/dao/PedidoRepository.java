package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import java.util.List;

import conexao.ConexaoBanco;
import model.Pedido;

public class PedidoRepository {
	private Connection conn;

	public PedidoRepository() {
		conn = ConexaoBanco.getConnection();
	}

	public List<Pedido> consultarPedidoLista() throws Exception{
		List<Pedido> listaPedidos = new ArrayList<>();
		
		try {
			String sql = "SELECT * FROM pedido";
			PreparedStatement stmt = conn.prepareStatement(sql);
		    ResultSet rst = stmt.executeQuery();
		    
		    if (rst.next()) {
		    //	    while (rst.next()) {
				Pedido relatorio = new Pedido();

		        relatorio.setId(rst.getInt("id_Pedido"));
		        relatorio.setData(rst.getDate("data_Pedido"));
		        relatorio.setTotal(rst.getDouble("total_Pedido"));
		        relatorio.setTransportador("transportador");
		        
		        listaPedidos.add(relatorio);
		        
		       
		    }else {
		    	System.out.print("Nenhum pedido encontrado!");
		    }
		    	}catch (SQLException e) {
		    		return null;
		    	}
		return null;
	}
}
