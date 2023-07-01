package view;

import javax.swing.*;
import java.awt.Panel;
import javax.swing.GroupLayout.Alignment;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.FlowLayout;
import javax.swing.LayoutStyle.ComponentPlacement;

public class Sobre extends JFrame {
    public Sobre() {
    	getContentPane().setBackground(new Color(43, 62, 80));
    	setTitle("CiberShield Security");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null); 
        setAlwaysOnTop(true);
        
        Panel panel = new Panel();
        panel.setBackground(new Color(204, 102, 0));
        panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        
        JLabel lblNewLabel = new JLabel("CyberShield Security");
        lblNewLabel.setForeground(new Color(255, 255, 255));
        lblNewLabel.setFont(new Font("Inter Light", Font.PLAIN, 14));
        panel.add(lblNewLabel);
        
        JLabel lblNewLabel_1 = new JLabel("Trabalho PRJ Noite");
        lblNewLabel_1.setFont(new Font("Inter Medium", Font.PLAIN, 12));
        lblNewLabel_1.setForeground(Color.WHITE);
        
        JLabel lblNewLabel_2 = new JLabel("Professor: Mozar Silva");
        lblNewLabel_2.setFont(new Font("Inter Medium", Font.PLAIN, 12));
        lblNewLabel_2.setForeground(Color.WHITE);
        
        JLabel lblNewLabel_2_1 = new JLabel("Alunos: Lucas Braz | Vinicius Siess");
        lblNewLabel_2_1.setFont(new Font("Inter Medium", Font.PLAIN, 12));
        lblNewLabel_2_1.setForeground(Color.WHITE);
        
        JLabel lblNewLabel_2_1_1 = new JLabel("Faculdade de Educação Tecnólogica do Estado do Rio de Janeiro");
        lblNewLabel_2_1_1.setHorizontalTextPosition(SwingConstants.CENTER);
        lblNewLabel_2_1_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_2_1_1.setAlignmentY(0.0f);
        Image addIcon = new ImageIcon(this.getClass().getResource("/assets/faeterj.png")).getImage();
        Image resizedAddIcon = addIcon.getScaledInstance(40, 40, Image.SCALE_SMOOTH);
        lblNewLabel_2_1_1.setIcon(new ImageIcon(resizedAddIcon));
        lblNewLabel_2_1_1.setForeground(Color.WHITE);
        lblNewLabel_2_1_1.setFont(new Font("Inter Light", Font.PLAIN, 10));
        GroupLayout groupLayout = new GroupLayout(getContentPane());
        groupLayout.setHorizontalGroup(
        	groupLayout.createParallelGroup(Alignment.LEADING)
        		.addGroup(groupLayout.createSequentialGroup()
        			.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
        				.addComponent(panel, GroupLayout.PREFERRED_SIZE, 384, GroupLayout.PREFERRED_SIZE)
        				.addGroup(groupLayout.createSequentialGroup()
        					.addGap(36)
        					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
        						.addComponent(lblNewLabel_2)
        						.addComponent(lblNewLabel_1)
        						.addComponent(lblNewLabel_2_1)
        						.addComponent(lblNewLabel_2_1_1))))
        			.addContainerGap(103, Short.MAX_VALUE))
        );
        groupLayout.setVerticalGroup(
        	groupLayout.createParallelGroup(Alignment.LEADING)
        		.addGroup(groupLayout.createSequentialGroup()
        			.addComponent(panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        			.addGap(26)
        			.addComponent(lblNewLabel_1)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(lblNewLabel_2)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(lblNewLabel_2_1)
        			.addPreferredGap(ComponentPlacement.RELATED, 128, Short.MAX_VALUE)
        			.addComponent(lblNewLabel_2_1_1)
        			.addContainerGap())
        );
        getContentPane().setLayout(groupLayout);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Sobre tela = new Sobre();
            tela.setLocationRelativeTo(null);
            tela.setVisible(true);
        });
    }
}
