package services;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import entities.Ameaca;
import repositories.AmeacaRepository;

public class AmeacaService {
	private AmeacaRepository ameacaRepository = new AmeacaRepository();

	  public void inserir(Ameaca ameaca) {
		  System.out.println("Salvando....");
		  ameacaRepository.criarAmeaca(ameaca);
		  System.out.println("Ameaça salva com sucesso!");
	  }
	  
	  public void download (int idRegistro, String coluna, String tipoArquivo) throws IOException, SQLException {
		  System.out.println("Salvando....");
		  ameacaRepository.download(idRegistro, coluna, tipoArquivo);
		  System.out.println("Ameaça salva com sucesso!");
	  }
	  
	  public ArrayList<Ameaca> listarAmeacas() {
		  System.out.println("Carregando ameaças!");
		  return ameacaRepository.listarAmeacas();
	  }
	  
	  public Iterable<Ameaca> lerArquivo(File pathName){
		  System.out.println("pathName: " + pathName);
		  return ameacaRepository.ler(pathName);
	  }
	  
	  public void exportar(){
		  System.out.println("Exportando...");
		  ameacaRepository.exportar();
	  }
}
