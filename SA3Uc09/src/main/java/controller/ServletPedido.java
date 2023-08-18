package controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Pedido;

import java.io.IOException;
import java.util.List;

import dao.PedidoRepository;

public class ServletPedido extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private PedidoRepository pedRepository = new PedidoRepository();

	public ServletPedido() {
		super();

	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			List<Pedido> listaPedidos = pedRepository.consultarPedidoLista();

			request.setAttribute ("listaPedidos", listaPedidos);

			request.getRequestDispatcher("relatorio.jsp").forward(request, response);
		} catch (NumberFormatException e) {
			e.printStackTrace();
			RequestDispatcher redireciona = request.getRequestDispatcher("painel/error.jsp");
			request.setAttribute("mensagem", "Pedidos não encontrados!");
			redireciona.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			RequestDispatcher redireciona = request.getRequestDispatcher("painel/error.jsp");
			request.setAttribute("mensagem", e.getMessage());
			redireciona.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
