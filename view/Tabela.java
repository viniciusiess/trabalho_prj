/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;

import entities.Ameaca;
import services.AmeacaService;
import utils.ButtonRenderTable;

import java.awt.Component;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.io.File;
/**
 *
 * @author Vinicius
 */
public class Tabela extends javax.swing.JDialog {
    private TabelaDados tabelaDadosAmeaca;
    private AmeacaService ameacaService  = new AmeacaService();
    /**
     * Creates new form Tabela
     */
    public Tabela(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        tabelaDadosAmeaca = new TabelaDados(ameacaService.listarAmeacas());
        tabelaAmeaca.setModel(tabelaDadosAmeaca);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaAmeaca = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        tabelaAmeaca.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        
        
        
        jScrollPane1.setViewportView(tabelaAmeaca);
        //tabelaAmeaca.getColumnModel().getColumn(7).setCellRenderer(new ButtonRenderTable());

        jButton1.setText("Adicionar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Atualizar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Excluir");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Importar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
                JFileChooser fileChooser = new JFileChooser();
    	        int returnValue = fileChooser.showOpenDialog(null);
    	        if (returnValue == JFileChooser.APPROVE_OPTION) {
    				File selectedFile = fileChooser.getSelectedFile();
    				ameacaService.lerArquivo(selectedFile);
    				JOptionPane.showMessageDialog(null,
      			          "Arquivo importado com sucesso!", "Message",
      			          JOptionPane.INFORMATION_MESSAGE);	
    	        }
            }
        });
        
        jButton5.setText("Exportar");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ameacaService.exportar();
    			JOptionPane.showMessageDialog(null,
    			          "Arquivo exportado com sucesso!", "Message",
    			          JOptionPane.INFORMATION_MESSAGE);	
            }
        });
        
        textField = new JTextField();
        textField.setBackground(new Color(204, 0, 0));
        textField.setColumns(10);
        
        JLabel lblNewLabel = new JLabel("NÍVEL DE CRITICIDADE:");
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
        
        JLabel lblAlto = new JLabel("1 - ALTO");
        
        textField_1 = new JTextField();
        textField_1.setColumns(10);
        textField_1.setBackground(new Color(204, 204, 0));
        
        JLabel lblMdio = new JLabel("2 - MÉDIO");
        
        textField_2 = new JTextField();
        textField_2.setColumns(10);
        textField_2.setBackground(new Color(51, 204, 0));
        
        JLabel lblBaixo = new JLabel("3 - BAIXO");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        layout.setHorizontalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addGap(38)
        			.addGroup(layout.createParallelGroup(Alignment.LEADING)
        				.addComponent(lblNewLabel)
        				.addGroup(layout.createSequentialGroup()
        					.addComponent(textField, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addComponent(lblAlto, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
        					.addPreferredGap(ComponentPlacement.UNRELATED)
        					.addComponent(lblMdio, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)
        					.addPreferredGap(ComponentPlacement.UNRELATED)
        					.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
        					.addPreferredGap(ComponentPlacement.UNRELATED)
        					.addComponent(lblBaixo, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE))
        				.addGroup(layout.createParallelGroup(Alignment.LEADING, false)
        					.addGroup(layout.createSequentialGroup()
        						.addComponent(jButton1)
        						.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        						.addComponent(jButton2)
        						.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        						.addComponent(jButton3)
        						.addGap(160)
        						.addComponent(jButton4)
        						.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	    						.addComponent(jButton5))
        					.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 592, GroupLayout.PREFERRED_SIZE)))
        			.addContainerGap(40, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addGap(39)
        			.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 363, GroupLayout.PREFERRED_SIZE)
        			.addGap(37)
        			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(jButton1)
        				.addComponent(jButton2)
        				.addComponent(jButton3)
        				.addComponent(jButton4)
        				.addComponent(jButton5))
        			.addGap(18)
        			.addComponent(lblNewLabel)
        			.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(textField, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
        				.addComponent(lblAlto)
        				.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
        				.addComponent(lblMdio)
        				.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
        				.addComponent(lblBaixo))
        			.addContainerGap())
        );
        layout.linkSize(SwingConstants.HORIZONTAL, new Component[] {jButton1, jButton2, jButton3, jButton4});
        getContentPane().setLayout(layout);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    	Ameaca ameaca = new Ameaca();
        if(cad_ameaca.executar(null, ExecutarCadastro.adicionar, ameaca)) {
            tabelaDadosAmeaca.adicionarAmeaca(ameaca);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        int indice = tabelaAmeaca.getSelectedRow();
        if(indice >= 0) {
        	Ameaca ameaca = tabelaDadosAmeaca.pegaAmeaca(indice);
            if(cad_ameaca.executar(null, ExecutarCadastro.atualizar, ameaca)) {
                tabelaDadosAmeaca.atualizarAmeaca(indice, ameaca);
            }
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        int indice = tabelaAmeaca.getSelectedRow();
        if(indice >= 0) {
            tabelaDadosAmeaca.deletarAmeaca(indice);
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        int indice = tabelaAmeaca.getSelectedRow();
        if(indice >= 0) {
            Ameaca ameaca = tabelaDadosAmeaca.pegaAmeaca(indice);
            cad_ameaca.executar(null, ExecutarCadastro.consultar, ameaca);
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Tabela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Tabela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Tabela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Tabela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Tabela dialog = new Tabela(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabelaAmeaca;
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;
}