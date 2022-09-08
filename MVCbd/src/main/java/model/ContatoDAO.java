package model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ContatoDAO {

	Connection conn = null;
	PreparedStatement pstm = null;

	public void save(Contato contato) {

		// Isso é uma sql comum, os ? são os parâmetros que nós vamos adicionar na base
		// de dados

		String sql = "INSERT INTO contato(nome,idade,dataCadastro)" + " VALUES(?,?,?)";

		try {
			// Cria uma conexão com o banco
			conn = Conexao.createConnectionToMySQL();

			// Cria um PreparedStatment, classe usada para executar a query
			pstm = conn.prepareStatement(sql);

			// Adiciona o valor do primeiro parâmetro da sql
			pstm.setString(1, contato.getNome());
			// Adicionar o valor do segundo parâmetro da sql
			pstm.setInt(2, contato.getIdade());
			// Adiciona o valor do terceiro parâmetro da sql
			pstm.setDate(3, new Date(contato.getDataCadastro().getTime()));

			// Executa a sql para inserção dos dados
			pstm.execute();
		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			// Fecha as conexões
			try {
				if (pstm != null) {
					pstm.close();
				}

				if (conn != null) {
					conn.close();
				}

			} catch (Exception e) {

				e.printStackTrace();
			}
		}
	}

	public void removeById(int id) {

		String sql = "DELETE FROM contato WHERE id = ?";

		try {
			conn = Conexao.createConnectionToMySQL(); // cria a conexao

			pstm = conn.prepareStatement(sql); // passa comando sql para o objeto pstm

			pstm.setInt(1, id); // seta o id no comando sql

			pstm.execute(); // executa o comando sql que está no objeto pstm

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			try {
				if (pstm != null) {

					pstm.close();
				}

				if (conn != null) {
					conn.close();
				}

			} catch (Exception e) {

				e.printStackTrace();
			}
		}
	}

	public void update(Contato contato) {
		String sql = "UPDATE contato SET nome = ?, idade = ?, dataCadastro = ?" + "WHERE id = ?";

		try {
			conn = Conexao.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, contato.getNome());
			pstm.setInt(2, contato.getIdade());
			pstm.setDate(3, new Date(contato.getDataCadastro().getTime()));
			pstm.setInt(4, contato.getId());

			pstm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			try {
				if (pstm != null) {

					pstm.close();
				}

				if (conn != null) {
					conn.close();
				}

			} catch (Exception e) {

				e.printStackTrace();
			}
		}
	}

	public List<Contato> getContatos() {

		String sql = "SELECT * FROM contato";

		List<Contato> contatos = new ArrayList<Contato>();

		// Classe que vai recuperar os dados do banco de dados
		ResultSet rset = null;

		try {
			conn = Conexao.createConnectionToMySQL();

			pstm = conn.prepareStatement(sql);

			rset = pstm.executeQuery();

			// Enquanto existir dados no banco de dados, faça
			while (rset.next()) {

				Contato contato = new Contato();

				// Recupera o id do banco e atribui ele ao objeto
				contato.setId(rset.getInt("id"));

				// Recupera o nome do banco e atribui ele ao objeto
				contato.setNome(rset.getString("nome"));

				// Recupera a idade do banco e atribui ele ao objeto
				contato.setIdade(rset.getInt("idade"));

				// Recupera a data do banco e atribui ela ao objeto
				contato.setDataCadastro(rset.getDate("dataCadastro"));

				// Adiciono o contato recuperado, a lista de contatos
				contatos.add(contato);
			}
		} catch (Exception e) {

			e.printStackTrace();
		} finally {

			try {

				if (rset != null) {

					rset.close();
				}

				if (pstm != null) {

					pstm.close();
				}

				if (conn != null) {
					conn.close();
				}

			} catch (Exception e) {

				e.printStackTrace();
			}
		}

		return contatos;
	}

	public Contato getContatoById(int id) {
		String sql = "SELECT * FROM contato WHERE id = ?";

		Contato contato = new Contato();

		ResultSet rset = null;

		try {
			conn = Conexao.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, id);

			rset = pstm.executeQuery();
			rset.next();
			
			contato.setId(rset.getInt("id"));
			contato.setNome(rset.getString("nome"));
			contato.setIdade(rset.getInt("idade"));
			contato.setDataCadastro(rset.getDate("dataCadastro"));

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return contato;
	}

}
