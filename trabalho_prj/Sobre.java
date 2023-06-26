package trabalho_prj;

import javax.swing.JOptionPane;

public class Sobre {

    public static void main(String[] args) {
        exibirTelaSobre();
    }

    public static void exibirTelaSobre() {
        String mensagem = "Sobre a Empresa de Controle de Ameaças Cibernéticas:\n\n" +
                "Nome: CyberSecurity Solutions\n" +
                "Endereço: Rua Exemplo, 1234\n" +
                "Cidade: Cidade Exemplo\n" +
                "Telefone: (00) 1234-5678\n" +
                "Email: contato@cybersecurity.com\n\n" +
                "Somos especializados em fornecer soluções de segurança cibernética para empresas e organizações. " +
                "Nossa equipe altamente qualificada trabalha para proteger seus sistemas e dados contra ameaças " +
                "cibernéticas, garantindo a segurança e a confiabilidade de suas operações.\n\n" +
                "Visite nosso site em www.cybersecurity.com para obter mais informações.";

        JOptionPane.showMessageDialog(null, mensagem, "Sobre a Empresa", JOptionPane.INFORMATION_MESSAGE);
    }
}
