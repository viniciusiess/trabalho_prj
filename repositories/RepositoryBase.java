package repositories;

import java.sql.*;
import java.util.*;
import java.io.*;

public class RepositoryBase {
	private static final String _NOME_BANCO_ = "db.db";
	   private Connection _con;

	   public RepositoryBase() {
	      try {
	         Class.forName("org.sqlite.JDBC");
	         File f = new File(_NOME_BANCO_);
	         if (!f.exists())
	            criarBanco();
	      } catch (Exception e) {
	         e.printStackTrace();
	         System.exit(0);
	      }
	   }

	   private void criarBanco() {
	      try {
	         conectar();
	         Statement statement = _con.createStatement();
	         statement.executeUpdate(
	               "create table produtos (\r\n"
	               + "	id integer primary key autoincrement not null,\r\n"
	               + "	produto varchar(50)\r\n"
	               + ");");
	         statement.executeUpdate(
	               "create table versoes (\r\n"
	               + "	id integer primary key autoincrement not null,\r\n"
	               + "	id_produto integer not null,\r\n"
	               + "	versao varchar(20),\r\n"
	               + "	foreign key (id_produto) references produtos(id)\r\n"
	               + ");");
	         statement.executeUpdate("create table tipos (\r\n"
	         		+ "	id integer primary key autoincrement not null,\r\n"
	         		+ "	tipo varchar(30)\r\n"
	         		+ ");");
	         statement.executeUpdate("create table criticidades(\r\n"
	         		+ "	id integer primary key autoincrement not null,\r\n"
	         		+ "	criticidade varchar(30)\r\n"
	         		+ ");");
	         statement.executeUpdate("create table ameacas(\r\n"
	         		+ "	id integer primary key autoincrement not null,\r\n"
	         		+ "	cve varchar(20),\r\n"
	         		+ "	id_produto int not null, \r\n"
	         		+ "  	id_versao  int not null, \r\n"
	         		+ "   	id_tipo int not null, \r\n"
	         		+ "   	id_criticidade int not null, \r\n"
	         		+ "	data datetime,\r\n"
	         		+ "	path_correcao blob,\r\n"
	         		+ "	solucao blob,\r\n"
	         		+ "	consequencia blob,\r\n"
	         		+ "	\r\n"
	         		+ "	foreign key (id_produto) references produtos(id),\r\n"
	         		+ "	foreign key (id_versao) references versoes(id),\r\n"
	         		+ "	foreign key (id_tipo) references tipos(id),\r\n"
	         		+ "	foreign key (id_criticidade) references criticidades(id)\r\n"
	         		+ ");");
	         desconectar();
	      } catch (Exception e) {
	         e.printStackTrace();
	         System.exit(0);
	      }
	   }

	   protected Connection conectar() {
	      try {
	         if (_con == null)
	            _con = DriverManager.getConnection("jdbc:sqlite:" + _NOME_BANCO_);
	         return _con;
	      } catch (Exception e) {
	         e.printStackTrace();
	         System.exit(0);
	         return null;
	      }
	   }

	   protected void desconectar() {
	      try {
	         _con.close();
	         _con = null;
	      } catch (Exception e) {
	         e.printStackTrace();
	         System.exit(0);
	      }
	   }

	   protected PreparedStatement prepareStatement(String sql) {
	      try {
	         return _con.prepareStatement(sql);
	      } catch (Exception e) {
	         e.printStackTrace();
	         System.exit(0);
	         return null;
	      }
	   }
}
