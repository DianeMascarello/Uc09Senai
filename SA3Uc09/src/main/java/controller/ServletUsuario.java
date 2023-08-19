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
