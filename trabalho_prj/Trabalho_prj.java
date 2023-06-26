/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package trabalho_prj;

import trabalho_prj.entrar;

/**
 *
 * @author Vinicius
 */
public class Trabalho_prj {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try {
            javax.swing.UIManager.setLookAndFeel(
                    javax.swing.UIManager.getSystemLookAndFeelClassName()
            );
        }catch(Exception e) {
            
        }
        
        entrar tela = new entrar(null, true);
        tela.setLocationRelativeTo(null);
        tela.setVisible(true);
    }
}
