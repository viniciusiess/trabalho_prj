package view;

import javax.swing.GroupLayout.Alignment;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.LayoutStyle.ComponentPlacement;

import entities.Ameaca;
import services.AmeacaService;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JPanel;
import java.awt.Cursor;
import java.awt.Dimension;
import javax.swing.UIManager;

public class Cad_ameaca extends javax.swing.JDialog {
    private ExecutarCadastro executarCadastro;
    private Ameaca ameaca;
    private AmeacaService ameacaService = new AmeacaService();
    private boolean confirmado;
    
    
    public Cad_ameaca(java.awt.Frame parent, ExecutarCadastro executarCadastro, Ameaca ameaca) {
        super(parent, true);
        setAutoRequestFocus(false);
        confirmado = false;
        this.executarCadastro = executarCadastro;
        this.ameaca = ameaca;
        initComponents();
        setTitle("CiberShield Security");
        if(executarCadastro == executarCadastro.atualizar || executarCadastro == ExecutarCadastro.consultar) {
        	
            DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            aNumCve.setText(this.ameaca.getCve());
            aVersao.setText(ameaca.getVersao());
            aTipo.setText(ameaca.getTipo());
            aCriticidade.setText(ameaca.getCriticidade());
            aData.setText(dateFormat.format(ameaca.getData()));
            aPathCorrecao.setText(ameaca.getPathCorrecao().getName());
            aSolucao.setText(ameaca.getSolucao().getName());
            aConsequencia.setText(ameaca.getConsequencia().getName());
        }
    }
    
    public boolean confirmar() {
        return confirmado;
    }
    
    public static boolean executar(java.awt.Frame parent, ExecutarCadastro executarCadastro, Ameaca ameaca) {
        Cad_ameaca tela = new Cad_ameaca(parent, executarCadastro, ameaca);
        tela.setLocationRelativeTo(null);
        tela.setVisible(true);
        return tela.confirmar();
    }
    
    public Cad_ameaca(java.awt.Frame parent, boolean modal) {
        super(parent, modal);

        initComponents();
    }

    @SuppressWarnings("unchecked")
    
    private void initComponents() {

        aNumCve = new javax.swing.JTextField();
        aNumCve.setFont(new Font("Inter Medium", Font.PLAIN, 11));
        aProduto = new javax.swing.JTextField();
        aProduto.setFont(new Font("Inter Medium", Font.PLAIN, 11));
        aVersao = new javax.swing.JTextField();
        aVersao.setFont(new Font("Inter Medium", Font.PLAIN, 11));
        aTipo = new javax.swing.JTextField();
        aTipo.setFont(new Font("Inter Medium", Font.PLAIN, 11));
        aCriticidade = new javax.swing.JTextField();
        aCriticidade.setFont(new Font("Inter Medium", Font.PLAIN, 11));
        aData = new javax.swing.JTextField();
        aData.setFont(new Font("Inter Medium", Font.PLAIN, 11));
        aPathCorrecao = new javax.swing.JTextField();
        aSolucao = new javax.swing.JTextField();
        aConsequencia = new javax.swing.JTextField();
        buttonConfirmar = new javax.swing.JButton();
        buttonConfirmar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        buttonConfirmar.setBackground(UIManager.getColor("Button.background"));
        buttonConfirmar.setForeground(UIManager.getColor("Button.foreground"));
        buttonConfirmar.setFont(new Font("Inter SemiBold", Font.PLAIN, 11));
        buttonSolucao = new javax.swing.JButton();
        buttonSolucao.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        buttonSolucao.setHorizontalAlignment(SwingConstants.LEFT);
        buttonSolucao.setBackground(UIManager.getColor("Button.background"));
        buttonSolucao.setForeground(UIManager.getColor("Button.foreground"));
        buttonSolucao.setFont(new Font("Inter SemiBold", Font.PLAIN, 11));
        buttonPathCorrecao = new javax.swing.JButton();
        buttonPathCorrecao.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        buttonPathCorrecao.setHorizontalAlignment(SwingConstants.LEFT);
        buttonPathCorrecao.setBackground(UIManager.getColor("Button.background"));
        buttonPathCorrecao.setForeground(UIManager.getColor("Button.foreground"));
        buttonPathCorrecao.setFont(new Font("Inter SemiBold", Font.PLAIN, 11));
        buttonConsequencia = new javax.swing.JButton();
        buttonConsequencia.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        buttonConsequencia.setHorizontalAlignment(SwingConstants.LEFT);
        buttonConsequencia.setBackground(UIManager.getColor("Button.background"));
        buttonConsequencia.setForeground(UIManager.getColor("Button.foreground"));
        buttonConsequencia.setFont(new Font("Inter SemiBold", Font.PLAIN, 11));
        jLabel1 = new javax.swing.JLabel();
        jLabel1.setForeground(Color.WHITE);
        jLabel1.setFont(new Font("Inter SemiBold", Font.PLAIN, 12));
        jLabel2 = new javax.swing.JLabel();
        jLabel2.setForeground(Color.WHITE);
        jLabel2.setFont(new Font("Inter SemiBold", Font.PLAIN, 12));
        jLabel3 = new javax.swing.JLabel();
        jLabel3.setForeground(Color.WHITE);
        jLabel3.setFont(new Font("Inter SemiBold", Font.PLAIN, 12));
        jLabel4 = new javax.swing.JLabel();
        jLabel4.setForeground(Color.WHITE);
        jLabel4.setFont(new Font("Inter SemiBold", Font.PLAIN, 12));
        jLabel5 = new javax.swing.JLabel();
        jLabel5.setForeground(Color.WHITE);
        jLabel5.setFont(new Font("Inter SemiBold", Font.PLAIN, 12));
        jLabel6 = new javax.swing.JLabel();
        jLabel6.setForeground(Color.WHITE);
        jLabel6.setFont(new Font("Inter SemiBold", Font.PLAIN, 12));
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setPreferredSize(new Dimension(600, 400));
        setMinimumSize(new Dimension(600, 400));
        setMaximumSize(new Dimension(600, 400));

        aNumCve.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aNumCveActionPerformed(evt);
            }
        });

        buttonConfirmar.setText("confirmar");
        Image confirmIcon = new ImageIcon(this.getClass().getResource("/assets/confirmButton.png")).getImage();
        Image resizedConfirmIcon = confirmIcon.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        buttonConfirmar.setIcon(new ImageIcon(resizedConfirmIcon));
        buttonConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonConfirmarActionPerformed(ameaca);
            }
        });
        Image importIcon = new ImageIcon(this.getClass().getResource("/assets/importButton.png")).getImage();
        Image resizedIcon = importIcon.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        
        buttonConsequencia.setText("Consequencia");
        buttonConsequencia.setIcon(new ImageIcon(resizedIcon));
        buttonConsequencia.addActionListener(new ActionListener() {
	      public void actionPerformed(ActionEvent ae) {
	        JFileChooser fileChooser = new JFileChooser();
	        int returnValue = fileChooser.showOpenDialog(null);
	        if (returnValue == JFileChooser.APPROVE_OPTION) 
	        	ameaca.setConsequencia(fileChooser.getSelectedFile());
	      }
	    });
		    
        buttonSolucao.setText("Solucao");
        buttonSolucao.setIcon(new ImageIcon(resizedIcon));
        buttonSolucao.addActionListener(new ActionListener() {
  	      public void actionPerformed(ActionEvent ae) {
  	        JFileChooser fileChooser = new JFileChooser();
  	        int returnValue = fileChooser.showOpenDialog(null);
  	        if (returnValue == JFileChooser.APPROVE_OPTION) 
  	        	ameaca.setSolucao(fileChooser.getSelectedFile());
  	      }
  	    });
        
        buttonPathCorrecao.setText("Path Correcao");
        buttonPathCorrecao.setIcon(new ImageIcon(resizedIcon));
        buttonPathCorrecao.addActionListener(new ActionListener() {
  	      public void actionPerformed(ActionEvent ae) {
  	        JFileChooser fileChooser = new JFileChooser();
  	        int returnValue = fileChooser.showOpenDialog(null);
  	        if (returnValue == JFileChooser.APPROVE_OPTION) 
  	        	ameaca.setPathCorrecao(fileChooser.getSelectedFile());
  	      }
  	    });
        
        jLabel1.setText("Número CVE:");

        jLabel2.setText("Produto:");

        jLabel3.setText("Versão:");

        jLabel4.setText("Tipo:");

        jLabel5.setText("Criticidade:");

        jLabel6.setText("Data:");
        
        jLabel7.setText("Path Correção");
        
        jLabel8.setText("Solução");
        
        jLabel9.setText("Consequência");
        
        JList list = new JList();
        
        JList list_1 = new JList();
        
        JPanel panel = new JPanel();
        panel.setBackground(new Color(204, 102, 0));
	    
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        layout.setHorizontalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addGap(138)
        			.addComponent(list, GroupLayout.PREFERRED_SIZE, 1, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap(454, Short.MAX_VALUE))
        		.addComponent(panel, GroupLayout.DEFAULT_SIZE, 593, Short.MAX_VALUE)
        		.addGroup(layout.createSequentialGroup()
        			.addGap(34)
        			.addGroup(layout.createParallelGroup(Alignment.TRAILING)
        				.addComponent(list_1, GroupLayout.PREFERRED_SIZE, 1, GroupLayout.PREFERRED_SIZE)
        				.addGroup(layout.createSequentialGroup()
        					.addGroup(layout.createParallelGroup(Alignment.LEADING)
        						.addComponent(jLabel1)
        						.addComponent(jLabel2)
        						.addComponent(jLabel4))
        					.addGap(18)
        					.addGroup(layout.createParallelGroup(Alignment.LEADING)
        						.addGroup(layout.createParallelGroup(Alignment.LEADING, false)
        							.addGroup(layout.createSequentialGroup()
        								.addComponent(aNumCve, GroupLayout.PREFERRED_SIZE, 163, GroupLayout.PREFERRED_SIZE)
        								.addGap(30)
        								.addComponent(jLabel3))
        							.addComponent(aVersao))
        						.addGroup(layout.createParallelGroup(Alignment.TRAILING)
        							.addComponent(buttonConsequencia, GroupLayout.PREFERRED_SIZE, 145, GroupLayout.PREFERRED_SIZE)
        							.addGroup(layout.createSequentialGroup()
        								.addComponent(aTipo, GroupLayout.PREFERRED_SIZE, 165, GroupLayout.PREFERRED_SIZE)
        								.addGap(33)
        								.addComponent(jLabel6))))
        					.addGroup(layout.createParallelGroup(Alignment.LEADING)
        						.addGroup(layout.createSequentialGroup()
        							.addGap(18)
        							.addGroup(layout.createParallelGroup(Alignment.LEADING, false)
        								.addGroup(layout.createSequentialGroup()
        									.addComponent(jLabel5)
        									.addPreferredGap(ComponentPlacement.UNRELATED)
        									.addComponent(aCriticidade))
        								.addComponent(aProduto, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)))
        						.addGroup(layout.createSequentialGroup()
        							.addPreferredGap(ComponentPlacement.UNRELATED)
        							.addGroup(layout.createParallelGroup(Alignment.TRAILING)
        								.addComponent(buttonSolucao, GroupLayout.PREFERRED_SIZE, 137, GroupLayout.PREFERRED_SIZE)
        								.addComponent(aData, GroupLayout.PREFERRED_SIZE, 167, GroupLayout.PREFERRED_SIZE)
        								.addComponent(buttonConfirmar)))))
        				.addGroup(Alignment.LEADING, layout.createSequentialGroup()
        					.addComponent(buttonPathCorrecao)
        					.addPreferredGap(ComponentPlacement.RELATED)))
        			.addContainerGap(49, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addComponent(panel, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addGroup(layout.createParallelGroup(Alignment.TRAILING)
        				.addComponent(list, GroupLayout.PREFERRED_SIZE, 1, GroupLayout.PREFERRED_SIZE)
        				.addComponent(list_1, GroupLayout.PREFERRED_SIZE, 1, GroupLayout.PREFERRED_SIZE))
        			.addGap(18)
        			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(jLabel1)
        				.addComponent(aNumCve, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        				.addComponent(jLabel3)
        				.addComponent(aProduto, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        			.addGap(28)
        			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(jLabel2)
        				.addComponent(aVersao, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        				.addComponent(jLabel5)
        				.addComponent(aCriticidade, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        			.addGap(33)
        			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(jLabel4)
        				.addComponent(aTipo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        				.addComponent(jLabel6)
        				.addComponent(aData, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        			.addGap(40)
        			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(buttonPathCorrecao)
        				.addComponent(buttonConsequencia)
        				.addComponent(buttonSolucao))
        			.addGap(38)
        			.addComponent(buttonConfirmar)
        			.addContainerGap(177, Short.MAX_VALUE))
        );
        
        JLabel lblNewLabel = new JLabel("CyberShield Security");
        lblNewLabel.setForeground(new Color(255, 255, 255));
        lblNewLabel.setFont(new Font("Inter Light", Font.PLAIN, 14));
        panel.add(lblNewLabel);
        
        getContentPane().setLayout(layout);
        this.getContentPane().setBackground(Color.decode("#2B3E50"));
        
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice gd = ge.getDefaultScreenDevice();
        Rectangle bounds = gd.getDefaultConfiguration().getBounds();
        int screenWidth = bounds.width;
        int screenHeight = bounds.height;
        int windowWidth = getSize().width;
        int windowHeight = getSize().height;
        int windowX = (screenWidth - windowWidth) / 2;
        int windowY = (screenHeight - windowHeight) / 2;
        setLocation(windowX, windowY);

        pack();
    }

    private void buttonConfirmarActionPerformed(Ameaca ameaca) {
    	
    	if(ameaca.getConsequencia() == null || ameaca.getPathCorrecao() == null || ameaca.getSolucao() == null) {
    		JOptionPane.showMessageDialog(null,
			          "Selecione os arquivos de Solucção, Consequencia e path_correcao!", "Message",
			          JOptionPane.INFORMATION_MESSAGE);	
    	}else {
    		
	        if(executarCadastro != ExecutarCadastro.consultar) {
	            ameaca.setCve(aNumCve.getText());
	            ameaca.setProduto(aProduto.getText());
	            ameaca.setVersao(aVersao.getText());
	            ameaca.setTipo(aTipo.getText());
	            ameaca.setCriticidade(aCriticidade.getText());
	            ameaca.setData(new Date(aData.getText()));
	                
	            ameacaService.inserir(ameaca);
	            
	            confirmado = true;
	        }
	        dispose();
    	}
    }

    private void aNumCveActionPerformed(java.awt.event.ActionEvent evt) {
       
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
            java.util.logging.Logger.getLogger(Cad_ameaca.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Cad_ameaca.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Cad_ameaca.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Cad_ameaca.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Cad_ameaca dialog = new Cad_ameaca(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    private javax.swing.JButton buttonConfirmar;
    private javax.swing.JButton buttonSolucao;
    private javax.swing.JButton buttonPathCorrecao;
    private javax.swing.JButton buttonConsequencia;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField aNumCve;
    private javax.swing.JTextField aProduto;
    private javax.swing.JTextField aVersao;
    private javax.swing.JTextField aTipo;
    private javax.swing.JTextField aCriticidade;
    private javax.swing.JTextField aData;
    private javax.swing.JTextField aPathCorrecao;
    private javax.swing.JTextField aSolucao;
    private javax.swing.JTextField aConsequencia;
}

