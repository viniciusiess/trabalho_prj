/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trabalho_prj;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Vinicius
 */
public class Ameaca implements Serializable {
    private String numCve;
    private String produto;
    private String versao;
    private String tipo;
    private String criticidade;
    private String data;
    private String pathCorrecao;
    private String solucao;
    private String consequencia;
    ArrayList<String> ameacas = new ArrayList<String>();
    
    public String ameacaNumCve() {
        return numCve;
    }
    
    public String ameacaProduto() {
        return produto;
    }
    
    public String ameacaVersao() {
        return versao;
    }
    
    public String ameacaTipo() {
        return tipo;
    }
    
    public String ameacaCriticidade() {
        return criticidade;
    }
    
    public String ameacaData() {
        return data;
    }
    
    public String ameacaPathCorrecao() {
    	return pathCorrecao;
    }
    
    public String ameacaSolucao() {
    	return solucao;
    }
    
    public String ameacaConsequencia() {
    	return consequencia;
    }
    
    public void atualizarNumCve(String numCve) {
        this.numCve = numCve;
    }
    
    public void atualizarProduto(String produto) {
        this.produto = produto;
    }
    
    public void atualizarVersao(String versao) {
        this.versao = versao;
    }
    
    public void atualizarTipo(String tipo) {
        this.tipo = tipo;
    }
    
    public void atualizarCriticidade(String criticidade) {
        this.criticidade = criticidade;
    }
    
    public void atualizarData(String data) {
        this.data = data;
    }
    
    public void atualizarPathCorrecao(String pathCorrecao) {
        this.pathCorrecao = pathCorrecao;
    }
    
    public void atualizarSolucao(String solucao) {
    	this.solucao = solucao;
    }
    
    public void atualizarConsequencia(String consequencia) {
    	this.consequencia = consequencia;
    }
    
    public void salvar() {
        ObjectOutputStream output = null;
        try {
            try {
                output = new ObjectOutputStream(new FileOutputStream("ameacas.dat"));
                
                for(int i=0; i<ameacas.size(); i++) {
                    output.writeObject(ameacas.get(i));
                }
                System.out.println("salvo com sucesso");
            }finally {
                if(output != null)
                    output.close();
            }
        }catch(Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
    public void abrir() {
        ObjectInputStream input = null;
        try {
            try {
                input = new ObjectInputStream(new FileInputStream("ameacas.dat"));
                Object obj = null;
                ameacas.clear();
                do {
                    obj = input.readObject();
                    ameacas.add(numCve);
                }while(obj != null);
            }finally {
                if(input != null)
                    input.close();
            }
        }catch(EOFException e) {
        }catch(Exception e) {
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
    }
}