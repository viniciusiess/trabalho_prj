package services;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;


import entities.Ameaca;
import repositories.AmeacaRepository;

public class AmeacaService {
	private AmeacaRepository ameacaRepository = new AmeacaRepository();
    ArrayList<String> ameacas = new ArrayList<String>();

	  public void inserir(Ameaca ameaca) {
		  System.out.println("Salvando....");
		  ameacaRepository.criarAmeaca(ameaca);
		  System.out.println("Ameaça salva com sucesso!");
	  }
	  
	  public void atualizar(Ameaca ameaca) {
		  System.out.println("Atualizando....");
		  ameacaRepository.atualizarAmeacas(ameaca);
		  System.out.println("Ameaça atualizada com sucesso!");
	  }
	  
	  public void remover(int ameacaId) {
		  System.out.println("Removendo....");
		  ameacaRepository.deletarAmeaca(ameacaId);
		  System.out.println("Ameaça removida com sucesso!");
	  }
	  
	  public void download (Ameaca ameaca, String coluna, String tipoArquivo) throws IOException, SQLException {
		  System.out.println("Salvando....");
		  ameacaRepository.download(ameaca, coluna, tipoArquivo);
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
	  
	  public Iterable<Ameaca> importarBin (File pathName){
		  System.out.println("pathName: " + pathName);
		  return ameacaRepository.importarBin(pathName);
	  }
	  
	  public void exportar(){
		  System.out.println("Exportando...");
		  ameacaRepository.exportar();
	  }
	  
	  public void exportarBin(){
		  System.out.println("Exportando...");
		  ameacaRepository.exportarBinario();
	  }
}
