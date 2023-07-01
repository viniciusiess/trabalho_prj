package entities;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class Ameaca implements Serializable{
	private int id;
	private int idProduto;
	private int idVersao;
	private int idTipo;
	private int idCriticidade;
	private String produto;
	private String versao;
	private String tipo;
	private String criticidade;
	private String cve;
	private Date data;
	private File pathCorrecao;
	private File solucao;
	private File consequencia;
	ArrayList<Ameaca> ameacas = new ArrayList<Ameaca>();
	
	public String getCve() {
		return cve;
	}
	
	public int getIdProduto() {
		return idProduto;
	}
	
	public int getIdVersao() {
		return idVersao;
	}
	
	public Date getData() {
		return data;
	}
	
	public void setCve(String cve) {
		this.cve = cve;
	}
	
	public void setIdProduto(int idProduto) {
		this.idProduto = idProduto;
	}
	
	public void setIdVersao(int idVersao) {
		this.idVersao = idVersao;
	}
	
	public void setData(Date data) {
		this.data = data;
	}

	public File getPathCorrecao() {
		return pathCorrecao;
	}

	public void setPathCorrecao(File pathCorrecao) {
		this.pathCorrecao = pathCorrecao;
	}

	public File getSolucao() {
		return solucao;
	}

	public void setSolucao(File solucao) {
		this.solucao = solucao;
	}

	public File getConsequencia() {
		return consequencia;
	}

	public void setConsequencia(File consequencia) {
		this.consequencia = consequencia;
	}

	public int getIdCriticidade() {
		return idCriticidade;
	}

	public void setIdCriticidade(int idCriticidade) {
		this.idCriticidade = idCriticidade;
	}

	public int getIdTipo() {
		return idTipo;
	}

	public void setIdTipo(int idTipo) {
		this.idTipo = idTipo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getProduto() {
		return produto;
	}

	public void setProduto(String produto) {
		this.produto = produto;
	}

	public String getVersao() {
		return versao;
	}

	public void setVersao(String versao) {
		this.versao = versao;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getCriticidade() {
		return criticidade;
	}

	public void setCriticidade(String criticidade) {
		this.criticidade = criticidade;
	}
	
	
    
}
