package repositories;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import entities.Ameaca;

public class AmeacaRepository extends RepositoryBase {
	public void criarAmeaca(Ameaca ameaca) {
	    try {
	      conectar();
	      
	      PreparedStatement tipoStatement = prepareStatement("insert into tipos(tipo) values (?)");
	      tipoStatement.setString(1, ameaca.getTipo());
	      tipoStatement.executeUpdate();
	      int ameacaIdTipo = tipoStatement.getGeneratedKeys().getInt(1);
	      
	      PreparedStatement criticidadeStatement = prepareStatement("insert into criticidades(criticidade) values (?)");
	      criticidadeStatement.setString(1,  ameaca.getCriticidade());
	      criticidadeStatement.executeUpdate();
	      int ameacaIdCriticidade = criticidadeStatement.getGeneratedKeys().getInt(1);
	      
	      PreparedStatement produtoStatement = prepareStatement("insert into produtos(produto) values (?)");
	      produtoStatement.setString(1,  ameaca.getProduto());
	      produtoStatement.executeUpdate();
	      int ameacaIdProduto = produtoStatement.getGeneratedKeys().getInt(1);
	      
	      PreparedStatement versaoStatement = prepareStatement("insert into versoes(versao, id_produto) values (?,?)");
	      versaoStatement.setString(1, ameaca.getVersao());
	      versaoStatement.setInt(2, ameacaIdProduto);
	      versaoStatement.executeUpdate();
	      int ameacaIdVersao = versaoStatement.getGeneratedKeys().getInt(1);
	      
	      PreparedStatement statement = prepareStatement(
	          "insert into ameacas(cve, id_produto, id_versao, id_criticidade, id_tipo, data, path_correcao, solucao, consequencia) values (?,?,?,?,?,?,?,?,?)");
	      statement.setString(1, ameaca.getCve());
	      statement.setInt(2, ameacaIdProduto);
	      statement.setInt(3, ameacaIdVersao);
	      statement.setInt(4, ameacaIdCriticidade);
	      statement.setInt(5, ameacaIdTipo);
	      statement.setDate(6,  new java.sql.Date(ameaca.getData().getTime()));
	      
	      FileInputStream pathCorrecao = new FileInputStream(ameaca.getPathCorrecao());
	      statement.setBinaryStream(7, (InputStream)pathCorrecao, (int)ameaca.getPathCorrecao().length() );
	      
	      FileInputStream solucao = new FileInputStream(ameaca.getSolucao());
	      statement.setBinaryStream(8, (InputStream)solucao, (int)ameaca.getSolucao().length() );
	      
	      FileInputStream consequencia = new FileInputStream(ameaca.getConsequencia());
	      statement.setBinaryStream(9, (InputStream)consequencia, (int)ameaca.getConsequencia().length() );
	      
	      statement.executeUpdate();
	      desconectar();
	    } catch (Exception e) {
	      e.printStackTrace();
	      System.exit(0);
	    }
	}
	
	public void deletarAmeaca(int idAmeaca) {
		try {
			conectar();
			
			PreparedStatement statement = prepareStatement("delete from ameacas where id="+idAmeaca);
			
			statement.executeUpdate();
		    desconectar();
		} catch (Exception e) {
			 
		      e.printStackTrace();
		      System.exit(0);			 
		}
	}
	
	public ArrayList<Ameaca> listarAmeacas() {
		ArrayList<Ameaca> ameacas = new ArrayList<Ameaca>();
		
		try {
			conectar();
			
			PreparedStatement statement = prepareStatement("select * from ameacas a join tipos t on t.id = a.id_tipo join produtos p on p.id = a.id_produto join versoes v  on v.id = a.id_versao join criticidades c on c.id = a.id_criticidade");
			
			ResultSet resultado  = statement.executeQuery();
			
			
			while(resultado.next()) {
				Ameaca ameaca = new Ameaca(); 
	            ameaca.setId(resultado.getInt("id"));
	            ameaca.setIdTipo(resultado.getInt("id_tipo"));
	            ameaca.setIdVersao(resultado.getInt("id_versao"));
	            ameaca.setIdProduto(resultado.getInt("id_produto"));
	            ameaca.setIdCriticidade(resultado.getInt("id_criticidade"));
	            ameaca.setTipo(resultado.getString("tipo"));
	            ameaca.setVersao(resultado.getString("versao"));
	            ameaca.setProduto(resultado.getString("produto"));
	            ameaca.setCriticidade(resultado.getString("criticidade"));
	            ameaca.setCve(resultado.getString("cve"));
	            ameaca.setData(resultado.getDate("data"));
	            /*ameaca.setPathCorrecao((File) resultado.getBlob("path_correcao"));
	            ameaca.setSolucao((File) resultado.getBlob("solucao"));
	            ameaca.setConsequencia(resultado.getBlob("consequencia"));*/
	            
	            System.out.println("CVE: " + resultado.getString("cve"));
	            System.out.println("PRODUTO: " + resultado.getString("produto"));
	            System.out.println("VERSAO: " + resultado.getString("versao"));
	            ameacas.add(ameaca);
			}
			
		    desconectar();
		} catch (Exception e) {
			 
		      e.printStackTrace();
		      System.exit(0);			 
		}
		
		return ameacas;
	}
	
	public Ameaca getAmeaca(int idAmeaca) {
		Ameaca ameaca = new Ameaca(); 
		
		try {
			conectar();
			
			PreparedStatement statement = prepareStatement("select * from ameacas where id="+idAmeaca);
			
			ResultSet resultado  = statement.executeQuery();
			
			if(resultado.next()) {
				ameaca.setId(resultado.getInt("id"));
				ameaca.setIdTipo(resultado.getInt("id_tipo"));
				ameaca.setIdVersao(resultado.getInt("id_versao"));
				ameaca.setIdProduto(resultado.getInt("id_produto"));
				ameaca.setIdCriticidade(resultado.getInt("id_criticidade"));
				ameaca.setCve(resultado.getString("cve"));
				ameaca.setData(resultado.getDate("data"));
				
			}
			
		    desconectar();
		} catch (Exception e) {
		      e.printStackTrace();
		      System.exit(0);			 
		}
		
		return ameaca;
	}
	
	public void atualizarAmeaca(Ameaca ameaca) {
	    try {
	      conectar();	
	      PreparedStatement statement = prepareStatement(
	          "insert into ameacas(cve, id_produto, id_versao, id_criticidade, id_tipo, data, path_correcao, solucao, consequencia) values (?,?,?,?,?,?,?,?,?)");
	      statement.setString(1, ameaca.getCve());
	      statement.setInt(2, ameaca.getIdProduto());
	      statement.setInt(3, ameaca.getIdVersao());
	      statement.setInt(4, ameaca.getIdCriticidade());
	      statement.setInt(5, ameaca.getIdTipo());
	      statement.setDate(6,  new java.sql.Date(ameaca.getData().getTime()));
	      
	      FileInputStream pathCorrecao = new FileInputStream(ameaca.getPathCorrecao());
	      statement.setBinaryStream(7, (InputStream)pathCorrecao, (int)ameaca.getPathCorrecao().length() );
	      
	      FileInputStream solucao = new FileInputStream(ameaca.getSolucao());
	      statement.setBinaryStream(8, (InputStream)solucao, (int)ameaca.getSolucao().length() );
	      
	      FileInputStream consequencia = new FileInputStream(ameaca.getConsequencia());
	      statement.setBinaryStream(9, (InputStream)consequencia, (int)ameaca.getConsequencia().length() );
	      
	      statement.executeUpdate();
	      desconectar();
	    } catch (Exception e) {
	      e.printStackTrace();
	      System.exit(0);
	    }
	}
	
	public void download (int idRegistro, String coluna, String tipoArquivo) throws IOException, SQLException {
		
		String nomeArquivo = coluna+"."+tipoArquivo;        
        String diretorio = System.getProperty("user.dir");
        String urlBanco = "jdbc:sqlite:" + diretorio + "/db.db";
        
        // Abre a conexão com o banco de dados SQLite
        Connection conexao = DriverManager.getConnection(urlBanco);
        
        // Monta a query SQL para obter o valor da coluna PDF
        String query = "SELECT " + coluna +" FROM ameacas WHERE id = ?";
        PreparedStatement stmt = conexao.prepareStatement(query);
        stmt.setInt(1, idRegistro);
        
        ResultSet resultado = stmt.executeQuery();
        
        // Lê o conteúdo da coluna PDF e grava em um arquivo
        if (resultado.next()) {
            InputStream input = resultado.getBinaryStream(coluna);
            FileOutputStream output = new FileOutputStream(nomeArquivo);
            
            byte[] buffer = new byte[1024];
            int tamanho;
            while ((tamanho = input.read(buffer)) != -1) {
                output.write(buffer, 0, tamanho);
            }
            
            input.close();
            output.close();
            System.out.println("Arquivo baixado com sucesso!");
        } else {
            System.out.println("Não foi encontrado o registro com id = " + idRegistro);
        }
        
        // Fecha a conexão com o banco de dados
        conexao.close();
	}
	
	public void exportar() {
		ArrayList<Ameaca> ameacas = this.listarAmeacas();
		
		System.out.println(ameacas.get(0).getCve());
		System.out.println(ameacas.get(1).getCve());
		System.out.println(ameacas.get(2).getCve());
		
		try{
	          FileOutputStream fs = new FileOutputStream("arquivoExportado.txt");
	          OutputStreamWriter sr = new OutputStreamWriter(fs);
	          BufferedWriter
	          bw = new BufferedWriter(sr);  
	          for(Ameaca ameaca : ameacas){
	        	  bw.write(ameaca.getCve()+",");
	        	  bw.write(ameaca.getProduto()+",");
	        	  bw.write(ameaca.getVersao()+",");
	        	  bw.write(ameaca.getTipo()+",");
	        	  bw.write(ameaca.getCriticidade()+",");
	        	  bw.write(ameaca.getData()+",");
	        	  //bw.write(ameaca.getPathCorrecao()+",");
	        	  ///bw.write(ameaca.getSolucao()+",");
	        	  //bw.write(ameaca.getConsequencia()+",");
	        	  bw.newLine();
	          }
	          bw.close();
	          sr.close();
	          fs.close();
       }catch(Exception e){
          e.printStackTrace();
          System.exit(0);
       }
		
	}
	
	public Iterable<Ameaca> ler(File pathName){
		SimpleDateFormat formato = new SimpleDateFormat("yyyy/MM/dd");
			
		 try{
	         File f = pathName;
	         ArrayList<Ameaca> lista = new ArrayList<Ameaca>();
	         if (f.exists())
	         {
	            FileInputStream fs = new FileInputStream(f);
	            InputStreamReader sr = new InputStreamReader(fs);
	            BufferedReader br = new BufferedReader(sr);  
	            String linha;
	            
	            while ( (linha = br.readLine())!=null ){
	               if (linha.trim().length()>0){
	                  String []campos = linha.split(",");
	                  Ameaca ameaca = new Ameaca();
	                  ameaca.setCve(campos[0]);
	                  ameaca.setProduto(campos[1]);
	                  ameaca.setVersao(campos[2]);
	                  ameaca.setTipo(campos[3]);
	                  ameaca.setCriticidade(campos[4]);
	                  ameaca.setData(formato.parse(campos[5]));
	                  ameaca.setPathCorrecao(new File(campos[6]));
	                  ameaca.setSolucao(new File(campos[7]));
	                  ameaca.setConsequencia(new File(campos[8]));
	                  
	                  System.out.println("Salvando....");
	                  this.criarAmeaca(ameaca);
	                  lista.add(ameaca);
	               }      
	            }
	            br.close();
	            sr.close();
	            fs.close();
	         }
	         return lista;
	       }catch(Exception e){
	          e.printStackTrace();
	          System.exit(0);
	          return null;
	       }
	}
 }
	

