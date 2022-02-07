package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.DAO;
import model.JavaBeans;

@WebServlet(urlPatterns = { "/Controller", "/main", "/insert", "/select", "/update", "/delete" })
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DAO dao = new DAO();
	JavaBeans contato = new JavaBeans();

	public Controller() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getServletPath();
		System.out.println(action);
		if (action.equals("/main")) {
			contatos(request, response);
		} else if (action.equals("/insert")) {
			novoContato(request, response);
		} else if (action.equals("/select")) {
			listarContato(request, response);
		} else if (action.equals("/update")) {
			editarContato(request, response);
		} else if (action.equals("/delete")) {
			deletarContato(request, response);
		} else {
			response.sendRedirect("index.html");
		}

		// teste de conexão
		// dao.testeConexao();

	}

	// Listar contatos
	protected void contatos(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// sponse.sendRedirect("registro.jsp");

		// Criando um objeto que irá receber os dados JavaBeans
		ArrayList<JavaBeans> lista = dao.listarContato();
		// Encaminhar a lista ao documento registro.jsp
		request.setAttribute("contatos", lista);
		RequestDispatcher rd = request.getRequestDispatcher("registro.jsp");
		rd.forward(request, response);
		// Teste de recebimento da lista
		/*
		 * for (int i = 0; i < lista.size(); i++) {
		 * System.out.println(lista.get(i).getIdcon());
		 * System.out.println(lista.get(i).getNome());
		 * System.out.println(lista.get(i).getIdade());
		 * System.out.println(lista.get(i).getGenero());
		 * System.out.println(lista.get(i).getTelefone());
		 * System.out.println(lista.get(i).getEmail());
		 * System.out.println(lista.get(i).getCpf()); }
		 */
	}

	// Novo contato
	protected void novoContato(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// teste de recebimento dos dados do formulário
		/*
		 * System.out.println(request.getParameter("nome"));
		 * System.out.println(request.getParameter("idade"));
		 * System.out.println(request.getParameter("genero"));
		 * System.out.println(request.getParameter("telefone"));
		 * System.out.println(request.getParameter("email"));
		 * System.out.println(request.getParameter("cpf"));
		 */
		// Invocar o método inserirContato passando o objeto contato
		// setar variaveis
		contato.setNome(request.getParameter("nome"));
		contato.setIdade(request.getParameter("idade"));
		contato.setGenero(request.getParameter("genero"));
		contato.setTelefone(request.getParameter("telefone"));
		contato.setEmail(request.getParameter("email"));
		contato.setCpf(request.getParameter("cpf"));
		dao.inserirContato(contato);
		// redirecionar para o registro.jsp
		response.sendRedirect("main");
	}

	// Editar contato
	protected void listarContato(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Recebimento do id do contato que será editado
		String idcon = request.getParameter("idcon");
		// Seter a variável JavaBeans
		contato.setIdcon(idcon);

		// Executar o método selecionarContato (DAO)
		dao.selecionarContato(contato);
		// Setar os atributos do formulário com conteúdo JavaBeans
		request.setAttribute("idcon", contato.getIdcon());
		request.setAttribute("nome", contato.getNome());
		request.setAttribute("idade", contato.getIdade());
		request.setAttribute("genero", contato.getGenero());
		request.setAttribute("telefone", contato.getTelefone());
		request.setAttribute("email", contato.getEmail());
		request.setAttribute("cpf", contato.getCpf());
		// Encaminhar ao documento editar.jsp
		RequestDispatcher rd = request.getRequestDispatcher("edit.jsp");
		rd.forward(request, response);
		// System.out.println(idcon);

		// Teste de recebimento
		/*
		 * System.out.println(contato.getIdcon());
		 * System.out.println(contato.getNome());
		 * System.out.println(contato.getIdade());
		 * System.out.println(contato.getGenero());
		 * System.out.println(contato.getTelefone());
		 * System.out.println(contato.getEmail()); System.out.println(contato.getCpf());
		 */
	}

	protected void editarContato(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Setar as variáveis JavaBeans
		contato.setIdcon(request.getParameter("idcon"));
		contato.setNome(request.getParameter("nome"));
		contato.setIdade(request.getParameter("idade"));
		contato.setGenero(request.getParameter("genero"));
		contato.setTelefone(request.getParameter("telefone"));
		contato.setEmail(request.getParameter("emaail"));
		contato.setCpf(request.getParameter("cpf"));
		// Exercuta o mètodo alterarContato
		dao.alterarContato(contato);
		// Redirecionar para o documento registro.jsp (atualizando as alterações)
		response.sendRedirect("main");

		// Teste de recebimento
		/*
		 * System.out.println(request.getParameter("idcon"));
		 * System.out.println(request.getParameter("nome"));
		 * System.out.println(request.getParameter("idade"));
		 * System.out.println(request.getParameter("genero"));
		 * System.out.println(request.getParameter("telefone"));
		 * System.out.println(request.getParameter("email"));
		 * System.out.println(request.getParameter("cpf"));
		 */
	}

	// Deletar contato
	protected void deletarContato(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String idcon = request.getParameter("idcon");
		// Recebimento do id do contato a ser excluido
		contato.setIdcon(idcon);
		// Executar o método deletarContato
		dao.deletarContato(contato);

		// Redirecionar para o documento registro.jsp (atualizando as alterações)
		response.sendRedirect("main");

		// Testando o deletar
		// System.out.println(idcon);
	}
}
