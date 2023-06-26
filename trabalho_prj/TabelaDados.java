/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trabalho_prj;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

import trabalho_pav_vinicius.Usuario;

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
    
       
    private String[] colunas = new String[]{"NumCVE", "Produto", "Versão", "Tipo", "Criticidade", "Data"};
    private List<Ameaca> ameacas;
    
    public TabelaDados(List<Ameaca>ameacas) {
        this.ameacas = new ArrayList<Ameaca>(ameacas);
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
        Ameaca ameaca = ameacas.get(linha);
        switch(coluna) {
            case COL_NUMCVE:
                return ameaca.ameacaNumCve();
            case COL_PRODUTO:
                return ameaca.ameacaProduto();
            case COL_VERSAO:
                return ameaca.ameacaVersao();
            case COL_TIPO:
                return ameaca.ameacaTipo();
            case COL_CRITICIDADE:
            	return ameaca.ameacaCriticidade();
            case COL_DATA:
            	return ameaca.ameacaData();
        }
        return "";
    }
    
    public void setValueAt(Object valor, int linha, int coluna) {
        Ameaca ameaca= ameacas.get(linha);
        switch(coluna) {
            case COL_NUMCVE:
                ameaca.atualizarNumCve(valor.toString());
                break;
            case COL_PRODUTO:
                ameaca.atualizarProduto(valor.toString());
                break;
            case COL_VERSAO:
                ameaca.atualizarVersao(valor.toString());
                break;
            case COL_TIPO:
                ameaca.atualizarTipo(valor.toString());
                break;
            case COL_CRITICIDADE:
                ameaca.atualizarCriticidade(valor.toString());
                break;
            case COL_DATA:
                ameaca.atualizarData(valor.toString());
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
