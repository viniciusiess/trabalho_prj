package view;

import javax.swing.JOptionPane;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import entities.Ameaca;
import services.AmeacaService;
import utils.ButtonRenderTable;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import javax.swing.JPanel;
import javax.swing.ListSelectionModel;
import java.awt.Cursor;

public class Tabela extends javax.swing.JDialog {
    private TabelaDados tabelaDadosAmeaca;
    private AmeacaService ameacaService  = new AmeacaService();
    private Sobre sobre;
    
    public Tabela(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        getContentPane().setBackground(new Color(43, 62, 80));
        initComponents();
        tabelaDadosAmeaca = new TabelaDados(ameacaService.listarAmeacas());
        tabelaAmeaca.setModel(tabelaDadosAmeaca);
        sobre = new Sobre();
        sobre.setAlwaysOnTop(true);
        setTitle("CiberShield Security");
        UIManager.put("MenuBar.background", new Color(255, 153, 0));
        
        JButton button = new JButton("TEste");
        button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ameacaService.exportar();
    			JOptionPane.showMessageDialog(null,
    			          "Arquivo exportado com sucesso!", "Message",
    			          JOptionPane.INFORMATION_MESSAGE);	
            }
        });
        tabelaAmeaca.getColumnModel().getColumn(6).setCellRenderer(new ButtonRenderTable());
        tabelaAmeaca.getColumnModel().getColumn(7).setCellRenderer(new ButtonRenderTable());
        tabelaAmeaca.getColumnModel().getColumn(8).setCellRenderer(new ButtonRenderTable());
        
        tabelaAmeaca.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                int row = tabelaAmeaca.rowAtPoint(e.getPoint());
                int column = tabelaAmeaca.columnAtPoint(e.getPoint());
                int indice = tabelaAmeaca.getSelectedRow();
                if(indice >= 0) {
	                if (column == 6 || column == 7 || column == 8) {
	                	Ameaca ameaca = tabelaDadosAmeaca.pegaAmeaca(indice);
	                	
	                	String coluna = column == 6 ? "path_correcao" : column == 7 ? "solucao" : "consequencia";
	                	
	                	try {
							ameacaService.download(ameaca, coluna, column == 6 ? "zip" : "pdf");
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
	                	JOptionPane.showMessageDialog(null,
	      			          "Arquivo " + ameaca.getCve() + "-" + coluna +  " baixado com sucesso!", "Message",
	      			          JOptionPane.INFORMATION_MESSAGE);	
	                }
                }
            }
        });
    }
    
    @SuppressWarnings("unchecked")
    
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaAmeaca = new javax.swing.JTable();
        tabelaAmeaca.setFont(new Font("Inter", Font.PLAIN, 11));
        tabelaAmeaca.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tabelaAmeaca.setSurrendersFocusOnKeystroke(true);
        tabelaAmeaca.setFillsViewportHeight(true);
        tabelaAmeaca.setForeground(Color.WHITE);
        tabelaAmeaca.setBackground(new Color(43, 62, 80));
        jScrollPane1.setPreferredSize(new Dimension(200, 600));
        tabelaAmeaca.setPreferredSize(new Dimension(200, 600));
        jButton1 = new javax.swing.JButton();
        jButton1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        jButton1.setBackground(UIManager.getColor("Button.background"));
        jButton1.setForeground(UIManager.getColor("Button.foreground"));
        jButton1.setFont(new Font("Inter SemiBold", Font.PLAIN, 11));
        jButton2 = new javax.swing.JButton();
        jButton2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        jButton2.setBackground(UIManager.getColor("Button.background"));
        jButton2.setForeground(UIManager.getColor("Button.foreground"));
        jButton2.setFont(new Font("Inter SemiBold", Font.PLAIN, 11));
        jButton3 = new javax.swing.JButton();
        jButton3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        jButton3.setBackground(UIManager.getColor("Button.background"));
        jButton3.setForeground(UIManager.getColor("Button.foreground"));
        jButton3.setFont(new Font("Inter SemiBold", Font.PLAIN, 11));
        jButton4 = new javax.swing.JButton();
        jButton4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        jButton4.setBackground(UIManager.getColor("Button.background"));
        jButton4.setForeground(UIManager.getColor("Button.foreground"));
        jButton4.setFont(new Font("Inter SemiBold", Font.PLAIN, 11));
        exportarTxt = new javax.swing.JButton();
        exportarTxt.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        exportarTxt.setBackground(UIManager.getColor("Button.background"));
        exportarTxt.setFont(new Font("Inter SemiBold", Font.PLAIN, 11));
        exportarTxt.setForeground(UIManager.getColor("Button.foreground"));
        exportarBin = new javax.swing.JButton();
        exportarBin.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        exportarBin.setBackground(UIManager.getColor("Button.background"));
        exportarBin.setFont(new Font("Inter SemiBold", Font.PLAIN, 11));
        exportarBin.setForeground(UIManager.getColor("Button.foreground"));
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
        
        jButton1.setText("Adicionar");
        Image addIcon = new ImageIcon(this.getClass().getResource("/assets/addButton.png")).getImage();
        Image resizedAddIcon = addIcon.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        jButton1.setIcon(new ImageIcon(resizedAddIcon));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Atualizar");
        Image updateIcon = new ImageIcon(this.getClass().getResource("/assets/updateButton.png")).getImage();
        Image resizedUpdateIcon = updateIcon.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        jButton2.setIcon(new ImageIcon(resizedUpdateIcon));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Excluir");
        Image deleteIcon = new ImageIcon(this.getClass().getResource("/assets/deleteButton.png")).getImage();
        Image resizedDeleteIcon = deleteIcon.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        jButton3.setIcon(new ImageIcon(resizedDeleteIcon));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
                
            }
        });

        jButton4.setText("Importar");
        Image ImportIcon = new ImageIcon(this.getClass().getResource("/assets/importButton.png")).getImage();
        Image resizedImportIcon = ImportIcon.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        jButton4.setIcon(new ImageIcon(resizedImportIcon));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
                JFileChooser fileChooser = new JFileChooser();
    	        int returnValue = fileChooser.showOpenDialog(null);
    	        if (returnValue == JFileChooser.APPROVE_OPTION) {
    				File selectedFile = fileChooser.getSelectedFile();
    				Iterable<Ameaca> ameacas =  ameacaService.lerArquivo(selectedFile);
    				
    				for(Ameaca ameaca : ameacas) {
    					tabelaDadosAmeaca.adicionarAmeaca(ameaca);
    				}
    				
    				JOptionPane.showMessageDialog(null,
      			          "Arquivo importado com sucesso!", "Message",
      			          JOptionPane.INFORMATION_MESSAGE);	
    	        }
            }
        });
        
        Image ExportIcon = new ImageIcon(this.getClass().getResource("/assets/exportButton.png")).getImage();
        Image resizedExportIcon = ExportIcon.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        
        exportarBin.setText(".bin");
        exportarBin.setIcon(new ImageIcon(resizedExportIcon));
        exportarBin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ameacaService.exportarBin();
    			JOptionPane.showMessageDialog(null,
    			          "Arquivo exportado com sucesso!", "Message",
    			          JOptionPane.INFORMATION_MESSAGE);	
            }
        });
        
        exportarTxt.setText(".txt");
        exportarTxt.setIcon(new ImageIcon(resizedExportIcon));
        exportarTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ameacaService.exportar();
    			JOptionPane.showMessageDialog(null,
    			          "Arquivo exportado com sucesso!", "Message",
    			          JOptionPane.INFORMATION_MESSAGE);	
            }
        });
        JPanel panel = new JPanel();
        panel.setBackground(new Color(204, 102, 0));
        
        lblNewLabel_2 = new JLabel("Listagem de Ameaças");
        lblNewLabel_2.setFont(new Font("Inter SemiBold", Font.PLAIN, 16));
        lblNewLabel_2.setForeground(Color.WHITE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        layout.setHorizontalGroup(
        	layout.createParallelGroup(Alignment.TRAILING)
        		.addGroup(layout.createSequentialGroup()
        			.addGap(153)
        			.addComponent(jButton2)
        			.addGap(46)
        			.addComponent(jButton3)
        			.addContainerGap(453, Short.MAX_VALUE))
        		.addComponent(panel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        		.addGroup(layout.createSequentialGroup()
        			.addGap(25)
        			.addGroup(layout.createParallelGroup(Alignment.LEADING)
        				.addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 773, Short.MAX_VALUE)
        				.addComponent(lblNewLabel_2)
        				.addGroup(layout.createSequentialGroup()
        					.addComponent(jButton1)
        					.addPreferredGap(ComponentPlacement.RELATED, 504, Short.MAX_VALUE)
        					.addComponent(jButton4)
        					.addGap(26)
							.addComponent(exportarBin)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(exportarTxt)))
        			.addGap(20))
        );
        layout.setVerticalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addComponent(panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        			.addGap(21)
        			.addComponent(lblNewLabel_2)
        			.addGap(4)
        			.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 363, GroupLayout.PREFERRED_SIZE)
        			.addGap(18)
        			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(jButton1)
        				.addComponent(jButton4)
        				.addComponent(jButton2)
        				.addComponent(jButton3)
        				.addComponent(exportarBin)
        				.addComponent(exportarTxt))
        			.addContainerGap(63, Short.MAX_VALUE))
        );
        layout.linkSize(SwingConstants.HORIZONTAL, new Component[] {jButton1, jButton2, jButton3, jButton4});
        
        JButton btnNewButton = new JButton("sobre");
        btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnNewButton.setForeground(new Color(255, 255, 255));
        btnNewButton.setContentAreaFilled(false);
        btnNewButton.setFocusPainted(false);
        btnNewButton.setFocusTraversalKeysEnabled(false);
        btnNewButton.setFocusable(false);
        btnNewButton.setBackground(new Color(204, 102, 0));
        btnNewButton.setFont(new Font("Inter Medium", Font.PLAIN, 11));
        btnNewButton.addActionListener(new java.awt.event.ActionListener() {
        		public void actionPerformed(java.awt.event.ActionEvent evt) {
        			sobre.setVisible(true);
        			
        			
        	}
        });
        
        JLabel lblNewLabel_1 = new JLabel("CyberShield Security");
        lblNewLabel_1.setForeground(new Color(255, 255, 255));
        lblNewLabel_1.setFont(new Font("Inter Light", Font.PLAIN, 14));
        GroupLayout gl_panel = new GroupLayout(panel);
        gl_panel.setHorizontalGroup(
        	gl_panel.createParallelGroup(Alignment.TRAILING)
        		.addGroup(gl_panel.createSequentialGroup()
        			.addGap(25)
        			.addComponent(lblNewLabel_1)
        			.addPreferredGap(ComponentPlacement.RELATED, 571, Short.MAX_VALUE)
        			.addComponent(btnNewButton)
        			.addGap(21))
        );
        gl_panel.setVerticalGroup(
        	gl_panel.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_panel.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
        				.addComponent(lblNewLabel_1)
        				.addComponent(btnNewButton))
        			.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panel.setLayout(gl_panel);
        getContentPane().setLayout(layout);
  
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice gd = ge.getDefaultScreenDevice();
        Rectangle bounds = gd.getDefaultConfiguration().getBounds();
        int screenWidth = bounds.width;
        int screenHeight = bounds.height;
        int windowWidth = getSize().width;
        int windowHeight = getSize().height;
        int windowX = (screenWidth - windowWidth) / 4;
        int windowY = (screenHeight - windowHeight) / 4;
        setLocation(windowX, windowY);
        
        pack();
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
    	Ameaca ameaca = new Ameaca();
        if(Cad_ameaca.executar(null, ExecutarCadastro.adicionar, ameaca)) {
            tabelaDadosAmeaca.adicionarAmeaca(ameaca);
        }
    }

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
        int indice = tabelaAmeaca.getSelectedRow();
        if(indice >= 0) {
        	Ameaca ameaca = tabelaDadosAmeaca.pegaAmeaca(indice);
        	System.out.println("AMEACA ID: " + ameaca.getId());
            if(Cad_ameaca.executar(null, ExecutarCadastro.atualizar, ameaca)) {
            	ameacaService.atualizar(ameaca);
                tabelaDadosAmeaca.atualizarAmeaca(indice, ameaca);
            }
        }
    }

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {
        int indice = tabelaAmeaca.getSelectedRow();
        
        if(indice >= 0) {
        	Ameaca ameaca = tabelaDadosAmeaca.pegaAmeaca(indice);
            ameacaService.remover(ameaca.getId());
        	tabelaDadosAmeaca.deletarAmeaca(indice);
            
        }
    }

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {
        int indice = tabelaAmeaca.getSelectedRow();
        if(indice >= 0) {
            Ameaca ameaca = tabelaDadosAmeaca.pegaAmeaca(indice);
            Cad_ameaca.executar(null, ExecutarCadastro.consultar, ameaca);
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
     
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

    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton exportarBin;
    private javax.swing.JButton exportarTxt;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabelaAmeaca;
    private JLabel lblNewLabel_2;
}