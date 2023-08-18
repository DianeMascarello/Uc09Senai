package controller;

import java.io.IOException;

import dao.UsuarioRepository;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Usuario;

//@WebServlet("/ServletUsuario")
public class ServletUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private UsuarioRepository userRepository = new UsuarioRepository();

	public ServletUsuario() {

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//			try {
//				String acao = request.getParameter("acao");
//				if (acao != null && !acao.isEmpty() && acao.equalsIgnoreCase("deletar")) {
//					
//					String userEmail = request.getParameter("email");
//					
//					userRepository.deletarUsuario(userEmail);
//					request.setAttribute("mensagem", "Excluído com Sucesso!");
//					request.getRequestDispatcher("painel/cadastro.jsp").forward(request, response);
//					
//				}else if(acao != null && !acao.isEmpty() && acao.equalsIgnoreCase("deletarAjax")) {
//					
//					String userEmail = request.getParameter("email");
//					
//					userRepository.deletarUsuario(userEmail);
//					
//					response.getWriter().write("Excluído com Ajax");
//					
//				}else if(acao != null && !acao.isEmpty() && acao.equalsIgnoreCase("consultarAjax")) {
//					String nome = request.getParameter("nomeBusca");
//					
//					List<Usuario> dadosUsuario = userRepository.consultarUsuarioLista(nome);
//					
//					ObjectMapper mapa = new ObjectMapper();
//					
//					String json = mapa.writeValueAsString(dadosUsuario);
//					
//					response.getWriter().write(json);
//				}
//				
//				else if(acao != null && !acao.isEmpty() && acao.equalsIgnoreCase("buscaEditar")) {
//					String email = request.getParameter("email");
//					Usuario user01 = userRepository.consultarUsuarioEmail(email);
//					
//					request.setAttribute("menssagem", "Usuário em Edição");
//					request.setAttribute("user01", user01);
//					request.getRequestDispatcher("painel/cadastro.jsp").forward(request, response);
//					
//				}
//				
//				else {
//					
//					request.getRequestDispatcher("painel/cadastro.jsp").forward(request, response);
//					
//				}
//			} catch (Exception e) {
//				
//				// TODO: handle exception
//				e.printStackTrace();
//				RequestDispatcher redireciona = request.getRequestDispatcher("painel/error.jsp");
//				request.setAttribute("mensagem", e.getMessage());
//				redireciona.forward(request, response);
//				
//			}
//			
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String nome = request.getParameter("nome");
			String email = request.getParameter("email");
			String senha = request.getParameter("senha");

			Usuario user01 = new Usuario();
			user01.setNome(nome);
			user01.setUsuario(email);
			user01.setSenha(senha);

			if (!user01.getNome().isEmpty() && !user01.getUsuario().isEmpty() && !user01.getSenha().isEmpty()) {
				if (userRepository.vericaUsuario(user01.getUsuario())) {
					request.getRequestDispatcher("Cadastro.jsp").forward(request, response);
					request.setAttribute("erro2", "Usuário já cadastrado, insira outro!");
					request.setAttribute("user01", user01);
				} else {
					Usuario usuarioInserido = userRepository.insereUsuario(user01);
					request.getRequestDispatcher("Cadastro.jsp").forward(request, response);
					request.setAttribute("erro1", "Preencha todos os campos!");
					request.setAttribute("user01", user01);
					if (usuarioInserido != null && usuarioInserido.ehNovo()) {
						request.getRequestDispatcher("Cadastro.jsp").forward(request, response);
						request.setAttribute("mensagem", "Usuário cadastrado com sucesso!");
					}
				}
			}
		}

		catch (Exception e) {
			e.printStackTrace();
			RequestDispatcher redireciona = request.getRequestDispatcher("painel/error.jsp");
			request.setAttribute("mensagem", e.getMessage());
			redireciona.forward(request, response);
		}
	}
}
