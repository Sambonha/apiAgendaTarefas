package br.com.cotiinformatica.repositories;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import br.com.cotiinformatica.entities.Categoria;
import br.com.cotiinformatica.factories.ConnectionFactory;

public class CategoriaRepository {

	private ConnectionFactory connectionFactory = new ConnectionFactory();

	public List<Categoria> findAll() {
		try {
<<<<<<< HEAD

			var connection = connectionFactory.getConnection();

			var sql = """
						select id, nome
						from categoria
						order by nome
=======
			var connection = connectionFactory.getConnection();

			var sql = """
							select id, nome
							from categoria
							order by nome
>>>>>>> 0bf73ba (Adicionando novas funcionalidades e atualizações)
					""";

			var statement = connection.prepareStatement(sql);
			var result = statement.executeQuery();

			var lista = new ArrayList<Categoria>();

			while (result.next()) {

				var categoria = new Categoria();

				categoria.setId(UUID.fromString(result.getString("id")));
				categoria.setNome(result.getString("nome"));

				lista.add(categoria);
<<<<<<< HEAD

			}

			connection.close();
			return lista;

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
=======
			}

			connection.close();

			return lista;
		} catch (Exception e) {

			e.printStackTrace();

			return null;
		}

>>>>>>> 0bf73ba (Adicionando novas funcionalidades e atualizações)
	}
}
