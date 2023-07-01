package repositories;

import java.sql.*;

import entities.Tipo;

public class TipoRepository extends RepositoryBase {
	public void criarTipo(Tipo tipo) {
	    tipo.getTipo();
	    try {
	      conectar();
	      PreparedStatement statement = prepareStatement(
	          "insert into tipos(tipo) values (?)");
	      statement.setString(1, tipo.getTipo());
	      statement.executeUpdate();
	      desconectar();
	    } catch (Exception e) {
	      e.printStackTrace();
	      System.exit(0);
	    }
	}
	
}
