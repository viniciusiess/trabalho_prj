
package view;

import trabalho_prj.Ameaca;
import view.Entrar;
import java.awt.Font;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import java.awt.Color;
import javax.swing.JLayeredPane;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.UIManager;
import javax.swing.JMenuBar;
import java.awt.Cursor;

public class Entrar extends javax.swing.JDialog {
	private Sobre sobre;
    
    public Entrar(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        setForeground(UIManager.getColor("CheckBox.interiorBackground"));
        getContentPane().setBackground(UIManager.getColor("CheckBox.background"));
        sobre = new Sobre();
        JMenuBar menuBar = new JMenuBar();
        menuBar.setForeground(UIManager.getColor("CheckBox.foreground"));
        menuBar.setBackground(UIManager.getColor("CheckBox.focus"));
        setJMenuBar(menuBar);
        jButton1 = new javax.swing.JButton();
        menuBar.add(jButton1);
        
                jButton1.setBackground(Color.DARK_GRAY);
                jButton1.setFont(new Font("Inter", Font.PLAIN, 11)); // NOI18N
                jButton1.setForeground(Color.WHITE);
                jButton1.setText("cadastrar");
                jButton1.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
                
                JButton btnSobre = new JButton("sobre");
                btnSobre.setFont(new Font("Inter", Font.PLAIN, 11));
                btnSobre.setForeground(Color.WHITE);
                btnSobre.setBackground(Color.DARK_GRAY);
                menuBar.add(btnSobre);
                
                btnSobre.addActionListener(new java.awt.event.ActionListener() {
                	public void actionPerformed(java.awt.event.ActionEvent evt) {
                		sobre.setVisible(true);
                	}
                });
                jButton1.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        jButton1ActionPerformed(evt);
                    }
                });
        initComponents();
        setResizable(false);
        setPreferredSize(new java.awt.Dimension(300, 300));
        pack();
    }

    @SuppressWarnings("unchecked")
    
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();

        jMenuItem1.setText("jMenuItem1");

        setBackground(UIManager.getColor("Button.shadow"));
        
        JLayeredPane layeredPane = new JLayeredPane();
        
        JLabel lblNewLabel = new JLabel("CADASTRAR AMEAÇAS");
        lblNewLabel.setFont(new Font("Inter ExtraBold", Font.PLAIN, 16));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        layout.setHorizontalGroup(
        	layout.createParallelGroup(Alignment.TRAILING)
        		.addGroup(layout.createSequentialGroup()
        			.addGroup(layout.createParallelGroup(Alignment.LEADING)
        				.addGroup(layout.createSequentialGroup()
        					.addGap(100)
        					.addComponent(layeredPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        				.addGroup(layout.createSequentialGroup()
        					.addGap(42)
        					.addComponent(lblNewLabel)))
        			.addContainerGap(51, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addGap(66)
        			.addComponent(lblNewLabel)
        			.addGap(263)
        			.addComponent(layeredPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        );
        getContentPane().setLayout(layout);
        pack();
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        Tabela obj = new Tabela(null, true);
        obj.setLocationRelativeTo(null);
        obj.setVisible(true);
        
        Ameaca ameaca= new Ameaca();
        ameaca.abrir();
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
            java.util.logging.Logger.getLogger(Entrar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Entrar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Entrar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Entrar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
            	Entrar dialog = new Entrar(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    public void windowClosing(java.awt.event.WindowAdapter e) {
                        System.exit(0);
                    }
                });
                dialog.pack();
                dialog.setLocationRelativeTo(null);
                dialog.setVisible(true);
            }
        });
    }

    private javax.swing.JButton jButton1;
    private javax.swing.JMenuItem jMenuItem1;
}