package br.com.cotiinformatica.factories;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {

	public Connection getConnection() {

		try {
<<<<<<< HEAD
			var host = "jdbc:postgresql://localhost:5433/bd_agendatarefas";
			var user = "postgres";
			var pass = "coti";
=======
			var host = "jdbc:postgresql://localhost:5432/bd_agendatarefas";
			var user = "postgres";
			var pass = "sambonha";
>>>>>>> 0bf73ba (Adicionando novas funcionalidades e atualizações)

			return DriverManager.getConnection(host, user, pass);

		} catch (Exception e) {
			e.printStackTrace(); // imprimir log de erro
			return null;
		}

	}

}
