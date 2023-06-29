package view;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import entities.Ameaca;
import services.AmeacaService;

public class JFileChooserTest {
  public static void main(String[] args) {
		Ameaca ameaca = new Ameaca();
		AmeacaService ameacaService = new AmeacaService();
	    JFrame.setDefaultLookAndFeelDecorated(true);
	    JDialog.setDefaultLookAndFeelDecorated(true);
	    JFrame frame = new JFrame("JComboBox Test");
	    frame.setLayout(new FlowLayout());
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    JButton button = new JButton("Select File");
	    button.addActionListener(new ActionListener() {
	      public void actionPerformed(ActionEvent ae) {
	        JFileChooser fileChooser = new JFileChooser();
	        int returnValue = fileChooser.showOpenDialog(null);
	        if (returnValue == JFileChooser.APPROVE_OPTION) {
	        	File selectedFile = fileChooser.getSelectedFile();
	        	
				System.out.println(selectedFile.getName());
				ameaca.setPathCorrecao(selectedFile);
				ameaca.setConsequencia(selectedFile);
				ameaca.setSolucao(selectedFile);
				ameaca.setCve("teste");
				ameaca.setIdCriticidade(1);
				ameaca.setIdProduto(1);
				ameaca.setIdVersao(1);
				ameaca.setIdTipo(1);
				ameaca.setData(new Date());
				
				ameacaService.inserir(ameaca);
				JOptionPane.showMessageDialog(null,
				          "File has been uploaded successfully!", "Message",
				          JOptionPane.INFORMATION_MESSAGE);	
				
				
	        }
	      }
	    });
	    
	    
	    JButton button2 = new JButton("Download");
	    /*button2.addActionListener(new ActionListener() {
	      public void actionPerformed(ActionEvent ae) {
	        try {
				ameacaService.download(1, "path_correcao", "pdf");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	      }
	    });*/
	    
	    JButton button3 = new JButton("Importar");
	    button3.addActionListener(new ActionListener() {
	      public void actionPerformed(ActionEvent ae) {
	        JFileChooser fileChooser = new JFileChooser();
	        int returnValue = fileChooser.showOpenDialog(null);
	        if (returnValue == JFileChooser.APPROVE_OPTION) {
				File selectedFile = fileChooser.getSelectedFile();
				ameacaService.lerArquivo(selectedFile);
	        }
	        
	      }
	    });
	    
	    JButton button4 = new JButton("Exportar");
	    button4.addActionListener(new ActionListener() {
	      public void actionPerformed(ActionEvent ae) {
			ameacaService.exportar();
			JOptionPane.showMessageDialog(null,
			          "Arquivo exportado com sucesso!", "Message",
			          JOptionPane.INFORMATION_MESSAGE);	
	      }
	    });
	    
	    ArrayList<Ameaca> teste  = ameacaService.listarAmeacas();
	    System.out.println("TESTE: " + teste.get(0).getCve());
	    System.out.println("TESTE: " + teste.get(0).getProduto());
	    
	    frame.add(button);
	    frame.add(button2);
	    frame.add(button3);
	    frame.add(button4);
	    frame.pack();
	    frame.setVisible(true);
	  }
}