package trabalho_prj;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import java.awt.Dimension;

public class Sobre {

    public static void main(String[] args) {
        exibirTelaSobre();
    }

    public static void exibirTelaSobre() {
        String mensagem = "Trabalho PRJ - Noite\n\n" +
                "Sistema de Gerenciamento de Ameaças\n" +
                "Lucas Braz | Vinicius Siess \n" +
                "Email: contato@fature.com\n\n" +
                "Somos especializados em fornecer soluções de segurança cibernética para empresas e organizações. " +
                "Nossa equipe altamente qualificada trabalha para proteger seus sistemas e dados contra ameaças " +
                "cibernéticas, garantindo a segurança e a confiabilidade de suas operações.\n\n" +
                "Visite nosso site em www.fature.com para obter mais informações.";

        JTextArea textArea = new JTextArea(mensagem);
        textArea.setEditable(false);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);

        JDialog dialog = new JDialog();
        dialog.setTitle("Sobre a Empresa");
        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        dialog.setResizable(false);

        dialog.add(textArea);

        dialog.setSize(new Dimension(400, 400));

        dialog.setLocationRelativeTo(null);

        dialog.setVisible(true);
        dialog.pack();
    }
}
