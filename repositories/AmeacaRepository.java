package repositories;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
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
import utils.BlobToFileConverter;

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
	
	public void atualizarAmeacas(Ameaca ameaca) {
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
	          "update ameacas set cve=(?), id_produto=(?), id_versao=(?), id_criticidade=(?), id_tipo=(?), data=(?), path_correcao=(?), solucao=(?), consequencia=(?) where id=(?)");
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
	      
	      statement.setInt(10, ameaca.getId());
	      
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
			
			System.out.println("ID: " + idAmeaca);
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
	          
	            
	            byte[] blobBytesPathCorrecao = resultado.getBytes("path_correcao");
	            Blob blobPathCorrecao = new javax.sql.rowset.serial.SerialBlob(blobBytesPathCorrecao);
	            File pathCorrecao = BlobToFileConverter.convertBlobToFile(blobPathCorrecao);
	            ameaca.setPathCorrecao(pathCorrecao);
	            
	            byte[] blobBytesSolucao = resultado.getBytes("solucao");
	            Blob blobSolucao = new javax.sql.rowset.serial.SerialBlob(blobBytesSolucao);
	            File solucao = BlobToFileConverter.convertBlobToFile(blobSolucao);
	            ameaca.setSolucao(solucao);
	            
	            byte[] blobBytesConsequencia = resultado.getBytes("consequencia");
	            Blob blobConsequencia = new javax.sql.rowset.serial.SerialBlob(blobBytesConsequencia);
	            File consequencia = BlobToFileConverter.convertBlobToFile(blobConsequencia);
	            ameaca.setConsequencia(consequencia);
	            
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
	
	public Ameaca pesquisar(String produto, String cve) {
		Ameaca ameaca = new Ameaca(); 
		
		try {
			conectar();
			
			PreparedStatement statementProduto = prepareStatement("select * from produtos where produto=(?)");
			statementProduto.setString(1, produto);
			int idProduto  = statementProduto.executeQuery().getInt("id");
			
			PreparedStatement statement = prepareStatement("select * from ameacas where id_produto=(?) AND cve=(?)");
			statement.setInt(1, idProduto);
			statement.setString(2, cve);
			
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
	
	public void download (Ameaca ameaca, String coluna, String tipoArquivo) throws IOException, SQLException {
		
		String nomeArquivo = ameaca.getCve()+"-"+coluna+"."+tipoArquivo;        
        String diretorio = System.getProperty("user.dir");
        String urlBanco = "jdbc:sqlite:" + diretorio + "/db.db";
        
        Connection conexao = DriverManager.getConnection(urlBanco);
        
        String query = "SELECT " + coluna +" FROM ameacas WHERE id = ?";
        PreparedStatement stmt = conexao.prepareStatement(query);
        stmt.setInt(1, ameaca.getId());
        
        ResultSet resultado = stmt.executeQuery();
        
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
            System.out.println("Não foi encontrado o registro com id = " + ameaca.getId());
        }
        
        conexao.close();
	}
	
	public void exportar() {
		ArrayList<Ameaca> ameacas = this.listarAmeacas();
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		String diretorio = System.getProperty("user.dir");
		
		try{
	          FileOutputStream fs = new FileOutputStream("arquivoExportado.txt");
	          OutputStreamWriter sr = new OutputStreamWriter(fs);
	          BufferedWriter
	          bw = new BufferedWriter(sr);  
	          for(Ameaca ameaca : ameacas){
	        	  File newFile = new File(diretorio+"/tmp");
	        	  Path consequencia = Files.move(ameaca.getConsequencia().toPath(), newFile.toPath().resolve("consequencia-"+ameaca.getCve()+"-"+ameaca.getData()+".pdf"), StandardCopyOption.REPLACE_EXISTING);
	        	  Path solucao = Files.move(ameaca.getSolucao().toPath(), newFile.toPath().resolve("solucao-"+ameaca.getCve()+"-"+ameaca.getData()+".pdf"), StandardCopyOption.REPLACE_EXISTING);
	        	  Path pathCorrecao = Files.move(ameaca.getPathCorrecao().toPath(), newFile.toPath().resolve("path_correcao-"+ameaca.getCve()+"-"+ameaca.getData()+".zip"), StandardCopyOption.REPLACE_EXISTING);
	        	  
	        	  bw.write(ameaca.getCve()+",");
	        	  bw.write(ameaca.getProduto()+",");
	        	  bw.write(ameaca.getVersao()+",");
	        	  bw.write(ameaca.getTipo()+",");
	        	  bw.write(ameaca.getCriticidade()+",");
	        	  bw.write(formato.format(ameaca.getData())+",");
	        	  bw.write(pathCorrecao+",");
	        	  bw.write(solucao+",");
	        	  bw.write(consequencia+"");
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
	
	public void exportarBinario() {		
		ArrayList<Ameaca> ameacas = this.listarAmeacas();
		String diretorio = System.getProperty("user.dir");
		
		try{
	          FileOutputStream fileOutput = new FileOutputStream("arquivoExportado.bin");
	            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutput);

	            System.out.println(ameacas.get(1).getPathCorrecao());
	            for(Ameaca ameaca : ameacas ) {
	            	File newFile = new File(diretorio+"/tmp");
		        	  Path consequencia = Files.move(ameaca.getConsequencia().toPath(), newFile.toPath().resolve("consequencia-"+ameaca.getCve()+"-"+ameaca.getData()+".pdf"), StandardCopyOption.REPLACE_EXISTING);
		        	  Path solucao = Files.move(ameaca.getSolucao().toPath(), newFile.toPath().resolve("solucao-"+ameaca.getCve()+"-"+ameaca.getData()+".pdf"), StandardCopyOption.REPLACE_EXISTING);
		        	  Path pathCorrecao = Files.move(ameaca.getPathCorrecao().toPath(), newFile.toPath().resolve("path_correcao-"+ameaca.getCve()+"-"+ameaca.getData()+".zip"), StandardCopyOption.REPLACE_EXISTING);
	            	
	            	ameaca.setPathCorrecao(pathCorrecao.toFile());
	            	
	            	ameaca.setSolucao(solucao.toFile());
	            	
	            	ameaca.setConsequencia(consequencia.toFile());
	            }

	            objectOutputStream.writeObject(ameacas);
	            objectOutputStream.close();

	            System.out.println("Dados exportados com sucesso!");
       }catch(Exception e){
          e.printStackTrace();
          System.exit(0);
       }
	}
	
	public Iterable<Ameaca> ler(File pathName){
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		
		String extensao = pathName.getPath().substring(pathName.getPath().lastIndexOf(".") + 1).intern();
		
		System.out.println(extensao);
		
		if(extensao == "bin") {
			try {
	            FileInputStream fileInputStream = new FileInputStream(pathName);

	            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
	            
	            ArrayList<Ameaca> lista = (ArrayList<Ameaca>) objectInputStream.readObject();
	
	            objectInputStream.close();
	
	            for (Ameaca item : lista) {
	                  this.criarAmeaca(item);
	            }
	            
	            return lista;
	
	        } catch (Exception e) {
	            e.printStackTrace();
	            return null;
	        }
		}else {	
		 try{
	         ArrayList<Ameaca> lista = new ArrayList<Ameaca>();
	         if (pathName.exists())
	         {
	            FileInputStream fs = new FileInputStream(pathName);
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

	                  SimpleDateFormat lerYT = new SimpleDateFormat("dd/MM/yyyy");
	                  
	                  java.util.Date data = formato.parse(campos[5]) ;
	                  System.out.println(data);
	                  ameaca.setData(data);
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
	
	public Iterable<Ameaca> importarBin (File file){
		 try {
	            FileInputStream fileInputStream = new FileInputStream(file);
	
	            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
	
	            ArrayList<Ameaca> lista = (ArrayList<Ameaca>) objectInputStream.readObject();
	
	            objectInputStream.close();
	            
	            for (Ameaca item : lista) {
	                  this.criarAmeaca(item);
	            }
	            
	            return lista;
	
	        } catch (Exception e) {
	            e.printStackTrace();
	            return null;
	        }
		}
	

}

	
