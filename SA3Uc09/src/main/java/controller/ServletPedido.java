package controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Pedido;
import model.Usuario;

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
	

	try

	{
		String acao = request.getParameter("acao");
		if (acao != null && !acao.isEmpty() && acao.equalsIgnoreCase("deletar")) {

			String idPedido = request.getParameter("id_Pedido");

			pedRepository.deletarPedido(idPedido);
			request.setAttribute("mensagem", "Excluído com Sucesso!");
			request.getRequestDispatcher("painel/cadastro.jsp").forward(request, response);

		} else if (acao != null && !acao.isEmpty() && acao.equalsIgnoreCase("deletarAjax")) {

			String idPedido = request.getParameter("id_Pedido");

			pedRepository.deletarPedido(idPedido);

			response.getWriter().write("Excluído com Ajax");

		} else if (acao != null && !acao.isEmpty() && acao.equalsIgnoreCase("consultarAjax")) {
			String id = request.getParameter("id_Pedido");

			List<Pedido> dadosPedido = pedRepository.consultarPedidoLista(id);

			ObjectMapper mapa = new ObjectMapper();

			String json = mapa.writeValueAsString(dadosPedido);

			response.getWriter().write(json);
		}
		else if (acao != null && !acao.isEmpty() && acao.equalsIgnoreCase("buscaEditar")) {
			String id = request.getParameter("id_Pedido");
			Pedido pedido = pedRepository.consultaridPedidoLista(String, id);

			request.setAttribute("menssagem", "Pedido em Edição");
			Object idPedido;
			request.setAttribute("idPedido", idPedido);
			request.getRequestDispatcher("painel/cadastro.jsp").forward(request, response);

		}

		else {

			request.getRequestDispatcher("painel/cadastro.jsp").forward(request, response);

		}
	}catch(
	Exception e)
	{
		e.printStackTrace();
		ServletRequest request;
		RequestDispatcher redireciona = request.getRequestDispatcher("painel/error.jsp");
		request.setAttribute("mensagem", e.getMessage());
		ServletResponse response;
		redireciona.forward(request, response);
	}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
