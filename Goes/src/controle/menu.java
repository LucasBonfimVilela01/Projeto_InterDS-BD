
package controle;

import javax.swing.JOptionPane;

/**
 *
 * @author Lucas
 */
public class menu {
        static void menuCliente(){
        int looper = 0;
        int menu;

        while (looper == 0) {
            try {
                menu = Integer.parseInt(JOptionPane.showInputDialog(
                    "Você já possui uma conta?:\n" +
                    "1 - Cadastrar-se\n" +
                    "2 - Entrar na conta\n" +
                    "3 - Sair"));

                switch (menu) {
                    case 1:
                        new cadastro_cliente().setVisible(true);
                        looper = 1;
                        break;
                    case 2:
                        //new login_cliente().setVisible(true);
                        looper = 1;
                        break;
                    case 3:
                        JOptionPane.showMessageDialog(null, "Saindo...");
                        looper = 1;
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Valor inválido. Tente novamente.");
                        break;
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Por favor, insira um número válido.");
            }
        }
        }
        static void menuMedico(){
            int looper = 0;
        int menu;

        while (looper == 0) {
            try {
                menu = Integer.parseInt(JOptionPane.showInputDialog(
                    "Você já possui uma conta?:\n" +
                    "1 - Cadastrar-se\n" +
                    "2 - Entrar na conta\n" +
                    "3 - Sair"));

                switch (menu) {
                    case 1:
                        new cadastro_medico().setVisible(true);
                        looper = 1;
                        break;
                    case 2:
                        new login_medico().setVisible(true);
                        looper = 1;
                        break;
                    case 3:
                        JOptionPane.showMessageDialog(null, "Saindo...");
                        looper = 1;
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Valor inválido. Tente novamente.");
                        break;
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Por favor, insira um número válido.");
            }
        }
        }
        static void menuInstrutor(){
            int looper = 0;
        int menu;

        while (looper == 0) {
            try {
                menu = Integer.parseInt(JOptionPane.showInputDialog(
                    "Você já possui uma conta?:\n" +
                    "1 - Cadastrar-se\n" +
                    "2 - Entrar na conta\n" +
                    "3 - Sair"));

                switch (menu) {
                    case 1:
                        new cadastro_instrutor().setVisible(true);
                        looper = 1;
                        break;
                    case 2:
                        //new login_instrutor().setVisible(true);
                        looper = 1;
                        break;
                    case 3:
                        JOptionPane.showMessageDialog(null, "Saindo...");
                        looper = 1;
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Valor inválido. Tente novamente.");
                        break;
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Por favor, insira um número válido.");
            }
        }
        }
    public static void main(String[] args) {
        int looper = 0;
        int menu;

        while (looper == 0) {
            try {
                menu = Integer.parseInt(JOptionPane.showInputDialog(
                    "Que tipo de usuário você é:\n" +
                    "1 - Cliente\n" +
                    "2 - Medico\n" +
                    "3 - Instrutor\n" +
                    "4 - Sair"));

                switch (menu) {
                    case 1:
                        menuCliente();
                        looper = 1;
                        break;
                    case 2:
                        menuMedico();
                        looper = 1;
                        break;
                    case 3:
                        menuInstrutor();
                        looper = 1;
                        break;
                    case 4:
                        JOptionPane.showMessageDialog(null, "Saindo...");
                        looper = 1;
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Valor inválido. Tente novamente.");
                        break;
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Por favor, insira um número válido.");
            }
        }            
    }
}

