package view;


import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

import entities.Ameaca;
import services.AmeacaService;


/**
 *
 * @author Vincius
 */
public class TabelaDados extends AbstractTableModel {
    private static final int COL_NUMCVE= 0;
    private static final int COL_PRODUTO = 1;
    private static final int COL_VERSAO = 2;
    private static final int COL_TIPO = 3;
    private static final int COL_CRITICIDADE = 4;
    private static final int COL_DATA = 5;
    private static final int COL_PATHCORRECAO = 6;
    private static final int COL_SOLUCAO = 7;
    private static final int COL_CONSEQUENCIA = 8;
    
    private String[] colunas = new String[]{"NumCVE", "Produto", "Versão", "Tipo", "Criticidade", "Data", "Path Correção", "Solução", "Consequência"};
    private List<Ameaca> ameacas;
    private AmeacaService ameacaService = new AmeacaService();
    
    public TabelaDados(List<Ameaca> arrayList) {
        this.ameacas = new ArrayList<Ameaca>(arrayList);
    }
    
    
    public int getColumnCount() {
        return colunas.length;
    }
    
    public int getRowCount() {
        return ameacas.size();
    }
    
    public String getColumnName(int colIndice) {
        return colunas[colIndice];
    }
    
    public boolean isCellEditable(int linhaIndice, int colunaIndice) {
        return false;
    }
    
    public Object getValueAt(int linha, int coluna) {
    	SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
    	Ameaca ameaca = ameacas.get(linha);
        
        switch(coluna) {
            case COL_NUMCVE:
                return ameaca.getCve();
            case COL_PRODUTO:
                return ameaca.getProduto();
            case COL_VERSAO:
                return ameaca.getVersao();
            case COL_TIPO:
                return ameaca.getTipo();
            case COL_CRITICIDADE:
            	return ameaca.getCriticidade();
            case COL_DATA:
            	return formato.format(ameaca.getData());
            case COL_PATHCORRECAO:
            	return ameaca.getPathCorrecao();
            case COL_SOLUCAO:
            	return ameaca.getSolucao().getName();
            case COL_CONSEQUENCIA:
            	return ameaca.getConsequencia().getName();
            
            
        }
        return "";
    }
    
    public void setValueAt(Object valor, int linha, int coluna) {
        Ameaca ameaca= ameacas.get(linha);
        switch(coluna) {
            case COL_NUMCVE:
                ameaca.setCve(valor.toString());
                break;
            case COL_PRODUTO:
                ameaca.setProduto(valor.toString());
                break;
            case COL_VERSAO:
                ameaca.setVersao(valor.toString());
                break;
            case COL_TIPO:
                ameaca.setTipo(valor.toString());
                break;
            case COL_CRITICIDADE:
                ameaca.setCriticidade(valor.toString());
                break;
            case COL_DATA:
                ameaca.setData(new java.util.Date(valor.toString()));
                break;
            case COL_PATHCORRECAO:
            	File pathCorrecao = new File(valor.toString());
            	ameaca.setPathCorrecao(pathCorrecao);
            	break;
            case COL_SOLUCAO:
            	File solucao = new File(valor.toString());
            	ameaca.setSolucao(solucao);
            	break;
            case COL_CONSEQUENCIA:
            	File consequencia = new File(valor.toString());
            	ameaca.setConsequencia(consequencia);
            	break;
        }
    }
    
    public Ameaca pegaAmeaca(int indice) {
        return ameacas.get(indice);
    }
    
    public void adicionarAmeaca(Ameaca ameaca) {
        ameacas.add(ameaca);
        int n = getRowCount()-1;
        fireTableRowsInserted(n, n);
    }
    
    public void atualizarAmeaca(int indice, Ameaca ameaca) {
        ameacas.set(indice, ameaca);
        fireTableRowsUpdated(indice, indice);
    }
    
    public void deletarAmeaca(int indice) {
        ameacas.remove(indice);
        fireTableRowsDeleted(indice, indice);
    }
}
