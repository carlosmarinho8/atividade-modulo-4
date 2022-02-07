package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DAO {
	/* Módulo de Conexão */
	// Parametro de conexão
	private String driver = "com.mysql.cj.jdbc.Driver";
	private String url = "jdbc:mysql://127.0.0.1:3306/dbregistro?useTimezone=true&serverTimezone=UTC";

	private String user = "root";
	private String password = "password12345";

	// Método de conexão
	private Connection conectar() {
		Connection con = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
			return con;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	// teste de conexão
	/*
	 * public void testeConexao() { try { Connection con = conectar();
	 * System.out.println(con); con.close(); } catch (Exception e) {
	 * System.out.println(e); }
	 * 
	 * }
	 */
	/** CREATE **/
	public void inserirContato(JavaBeans contato) {
		String create = "insert into contatos (nome,idade,genero,telefone,email,cpf) values (?,?,?,?,?,?)";
		try {
			// abrir a conexão
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(create);
			// Substituir os parâmetros (?) pelo contéudo das variáveis Javabeans
			pst.setString(1, contato.getNome());
			pst.setString(2, contato.getIdade());
			pst.setString(3, contato.getGenero());
			pst.setString(4, contato.getTelefone());
			pst.setString(5, contato.getEmail());
			pst.setString(6, contato.getCpf());
			// Executar a query
			pst.executeUpdate();
			// Encerra a conexão com o banco
			con.close();

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	/* READ **/
	public ArrayList<JavaBeans> listarContato() {
		// Criando um objeto para acessar a classe JavaBeans
		ArrayList<JavaBeans> contatos = new ArrayList<>();
		String read = "select * from contatos order by nome";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(read);
			ResultSet rs = pst.executeQuery();
			// O laço abaixo sera executado enquanto houver contatos
			while (rs.next()) {
				// Variáveis de apoio que recebem os dados do banco
				String idcon = rs.getString(1);
				String nome = rs.getString(2);
				String idade = rs.getString(3);
				String genero = rs.getString(4);
				String telefone = rs.getString(5);
				String email = rs.getString(6);
				String cpf = rs.getString(7);
				// Populando o ArrayList
				contatos.add(new JavaBeans(idcon, nome, idade, genero, telefone, email, cpf));
			}
			con.close();
			return contatos;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	/** UPDATE **/
	// Selecionar o contato
	public void selecionarContato(JavaBeans contato) {
		String read2 = "select * from contatos where idcon = ?";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(read2);
			pst.setString(1, contato.getIdcon());
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				// Setar as variáveis JavaBeans
				
				contato.setIdcon(rs.getString(1));
				contato.setNome(rs.getString(2));
				contato.setIdade(rs.getString(3));
				contato.setGenero(rs.getString(4));
				contato.setTelefone(rs.getString(5));
				contato.setEmail(rs.getString(6));
				contato.setCpf(rs.getString(7));
				
			}
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	// Editar o contato
	public void alterarContato(JavaBeans contato) {
		String create = "update contatos set nome=?,idade=?,genero=?,telefone=?,email=?,cpf=? where idcon=?";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(create);
			pst.setString(1, contato.getNome());
			pst.setString(2, contato.getIdade());
			pst.setString(3, contato.getGenero());
			pst.setString(4, contato.getTelefone());
			pst.setString(5, contato.getEmail());
			pst.setString(6, contato.getCpf());
			pst.setString(7, contato.getIdcon());
			pst.executeUpdate();
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	/* DELETE*/
	public void deletarContato(JavaBeans contato) {
		String delete = "delete from contatos where idcon=?";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(delete);
			pst.setString(1, contato.getIdcon());
			pst.executeUpdate();
			con.close();
		} catch (Exception e) {
			System.out.println(e);
			
		}
	}
}
