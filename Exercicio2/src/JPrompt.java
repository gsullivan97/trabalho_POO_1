import java.util.HashMap;
import java.util.Scanner;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.ERROR_MESSAGE;
import static javax.swing.JOptionPane.INFORMATION_MESSAGE;
import static javax.swing.JOptionPane.PLAIN_MESSAGE;
import static javax.swing.JOptionPane.QUESTION_MESSAGE;
import static javax.swing.JOptionPane.WARNING_MESSAGE;
import static javax.swing.JOptionPane.YES_NO_OPTION;
import static javax.swing.JOptionPane.showConfirmDialog;
import static javax.swing.JOptionPane.showInputDialog;
import static javax.swing.JOptionPane.showMessageDialog;
import javax.swing.JTextField;

/**
 * Classe para leitura e escrita de dados pelo teclado via prompt e JOptionPane.
 *
 * @author Professor Moisés Henrique Ramos Pereira
 * @version 4.0
 */
public class JPrompt {
    
    // Declaração de classe interna.
    private static class Simbolo {
        
        public HashMap<String,Integer> tabela = new HashMap<>();
        
        public Simbolo() {
            tabela.put("x", ERROR_MESSAGE); 
            tabela.put("i", INFORMATION_MESSAGE); 
            tabela.put("?", QUESTION_MESSAGE);
            tabela.put("!", WARNING_MESSAGE);
            tabela.put("", PLAIN_MESSAGE);
            tabela.put(null, PLAIN_MESSAGE);
        }
        
        public Integer getIcone(String tipo) {
            return tabela.get(tipo);
        }
    }
    
    // Declaração dos atributos.
    private static final String erroSemDado = "Nenhum dado informado!";
    private static final String erroFormato = "Formato inválido na conversão!";
    private static final String erroNaoReal = "Nenhum número real informado!";
    private static final String erroNaoIntg = "Nenhum número inteiro informado!";
    
    private static final Simbolo tabela = new Simbolo();
    private static final Scanner prompt = new Scanner(System.in);
    
    // Declaração dos métodos.
    
    /*****************************************************************
     * Métodos para escrita no prompt, terminal ou janelas popup.    *
     *****************************************************************/
    
    /**
     * @param mensagem
     */
    public static void print(String mensagem) {
        System.out.print(mensagem);
    }
    
    /**
     * @param mensagem
     */
    public static void printLine(String mensagem) {
        System.out.println(mensagem);
    }
    
    /**
     * @param titulo
     * @param mensagem
     * @param icone
     */
    public static void printPane(String titulo, String mensagem, String icone) {
        JOptionPane.showMessageDialog(null, mensagem, titulo, tabela.getIcone(icone));
    }

    /**
     * @param titulo
     * @param mensagem
     */
    public static void printPane(String titulo, String mensagem) {
        printPane(titulo, mensagem, "i");
    }
    
    /**
     * @param mensagem
     */
    public static void printPane(String mensagem) {
        printPane("Informação", mensagem, "i");
    }
    
    /**
     * @param titulo
     * @param mensagem
     * @return Valor inteiro referente a opçao escolhida.
     */
    public static Integer printConf(String titulo, String mensagem) {
        return showConfirmDialog(null, mensagem, titulo, YES_NO_OPTION);
    }
    
    /*****************************************************************
     * Métodos para leitura a partir do teclado via prompt ou popup. *
     *****************************************************************/
    
    /**
     * @param mensagem
     * @return 
     */
    public static Integer readInt(String mensagem) {
        String entrada;
        Boolean existeErro;
        Integer numeroInt = 0;

        do {
            existeErro = false;
            try {
                System.out.print(mensagem);
                entrada = prompt.nextLine().trim();
                numeroInt = Integer.parseInt(entrada);
            } catch (NumberFormatException e) {
                printLine(erroNaoIntg);
                existeErro = true;
            }
        } while (existeErro);
        return numeroInt;
    }
    
    /**
     * @param titulo
     * @param mensagem
     * @param icone
     * @return 
     */
    public static Integer readIntPane(String titulo, String mensagem, String icone) {
        String entrada;
        Boolean existeErro;
        Integer numeroInt = 0;

        do {
            existeErro = false;
            try {
                entrada = showInputDialog(null, mensagem, titulo, tabela.getIcone(icone)).trim();
                numeroInt = Integer.parseInt(entrada);
            } catch (NumberFormatException e) {
                printPane(erroNaoIntg, "ERRO", "x");
                existeErro = true;
            } catch (NullPointerException e) {
                printPane(erroSemDado, "ERRO", "x");
                existeErro = true;
            }
        } while (existeErro);
        return numeroInt;
    }
    
    /**
     * @param mensagem
     * @return Integer
     */
    public static Integer readIntPane(String mensagem) {
        return readIntPane(mensagem, null, "?");
    }
    
    /**
     * @param mensagem
     * @return Float
     */
    public static Float readFloat(String mensagem) {
        String entrada;
        Boolean existeErro;
        Float numeroFloat = 0f;

        do {
            existeErro = false;
            try {
                print(mensagem);
                entrada = prompt.nextLine().trim();
                numeroFloat = Float.parseFloat(entrada);
            } catch (NumberFormatException e) {
                printLine(erroNaoReal);
                existeErro = true;
            }
        } while (existeErro);
        return numeroFloat;
    }
    
    /**
     * @param titulo
     * @param mensagem
     * @param icone
     * @return Float
     */
    public static Float readFloatPane(String titulo, String mensagem, String icone) {
        String entrada;
        Boolean existeErro;
        Float numeroFloat = 0.0f;

        do {
            existeErro = false;
            try {
                entrada = showInputDialog(null, mensagem, titulo, tabela.getIcone(icone)).trim();
                numeroFloat = Float.parseFloat(entrada);
            } catch (NumberFormatException e) {
                showMessageDialog(null, erroNaoReal, "ERRO", ERROR_MESSAGE);
                existeErro = true;
            } catch (NullPointerException e) {
                showMessageDialog(null, erroSemDado, "ERRO", ERROR_MESSAGE);
                existeErro = true;
            }
        } while (existeErro);
        return numeroFloat;
    }
    
    /**
     * @param mensagem
     * @return Float
     */
    public static Float readFloatPane(String mensagem) {
        String entrada;
        Boolean existeErro;
        Float numeroFloat = 0.0f;

        do {
            existeErro = false;
            try {
                entrada = showInputDialog(mensagem).trim();
                numeroFloat = Float.parseFloat(entrada);
            } catch (NumberFormatException e) {
                showMessageDialog(null, erroNaoReal, "ERRO", ERROR_MESSAGE);
                existeErro = true;
            } catch (NullPointerException e) {
                showMessageDialog(null, erroSemDado, "ERRO", ERROR_MESSAGE);
                existeErro = true;
            }
        } while (existeErro);
        return numeroFloat;
    }
    
    /**
     * @param mensagem
     * @return Double
     */
    public static Double readDouble(String mensagem) {
        String entrada;
        Boolean existeErro;
        Double numeroDouble = 0.0;

        do {
            existeErro = false;
            try {
                print(mensagem);
                entrada = prompt.nextLine().trim();
                numeroDouble = Double.parseDouble(entrada);
            } catch (NumberFormatException e) {
                printLine(erroNaoReal);
                existeErro = true;
            }
        } while (existeErro);
        return numeroDouble;
    }
    
    /**
     * @param titulo
     * @param mensagem
     * @param icone
     * @return Double
     */
    public static Double readDoublePane(String titulo, String mensagem, String icone) {
        String entrada;
        Boolean existeErro;
        Double numeroDouble = 0.0;

        do {
            existeErro = false;
            try {
                entrada = showInputDialog(null, mensagem, titulo, tabela.getIcone(icone)).trim();
                numeroDouble = Double.parseDouble(entrada);
            } catch (NumberFormatException e) {
                showMessageDialog(null, erroNaoReal, "ERRO", ERROR_MESSAGE);
                existeErro = true;
            } catch (NullPointerException e) {
                showMessageDialog(null, erroSemDado, "ERRO", ERROR_MESSAGE);
                existeErro = true;
            }
        } while (existeErro);
        return numeroDouble;
    }
    
    /**
     * @param mensagem
     * @return Double
     */
    public static Double readDoublePane(String mensagem) {
        String entrada;
        Boolean existeErro;
        Double numeroDouble = 0.0;

        do {
            existeErro = false;
            try {
                entrada = showInputDialog(mensagem).trim();
                numeroDouble = Double.parseDouble(entrada);
            } catch (NumberFormatException e) {
                showMessageDialog(null, erroNaoReal, "ERRO", ERROR_MESSAGE);
                existeErro = true;
            } catch (NullPointerException e) {
                showMessageDialog(null, erroSemDado, "ERRO", ERROR_MESSAGE);
                existeErro = true;
            }
        } while (existeErro);
        return numeroDouble;
    }
    
    public static String readString(String mensagem) {
        print(mensagem);
        return prompt.nextLine().trim();
    }
    
    /**
     * @param titulo
     * @param mensagem
     * @param icone
     * @return String
     */
    public static String readStringPane(String titulo, String mensagem, String icone) {
        String entrada = new String();
        Boolean existeErro;

        do {
            existeErro = false;
            try {
                entrada = showInputDialog(null, mensagem, titulo, tabela.getIcone(icone));
            } catch (NullPointerException e) {
                showMessageDialog(null, erroSemDado, "ERRO", ERROR_MESSAGE);
                existeErro = true;
            }
        } while (existeErro);
        return entrada;
    }
    
    public static String[] readTwoStringPane(String titulo, String mensagem1,String mensagem2, String icone) {
        String[] entrada = new String[2];
        Boolean existeErro;

        do {
            existeErro = false;
            try 
            {
                //entrada = showInputDialog(null, mensagem, titulo, tabela.getIcone(icone));
                
                 JTextField field1 = new JTextField();
                 JTextField field2 = new JTextField();

                Object[] message = {
                    mensagem1, field1,
                    mensagem2, field2,
                };
                int option = JOptionPane.showConfirmDialog(null, message, titulo, JOptionPane.OK_CANCEL_OPTION,tabela.getIcone(icone));
                if (option == JOptionPane.OK_OPTION)
                {
                    entrada[0] = field1.getText();
                    entrada[1]= field2.getText();
                }
            } 
            catch (NullPointerException e) 
            {
                showConfirmDialog(null, erroSemDado, "ERRO", ERROR_MESSAGE);
                existeErro = true;
            }
        } while (existeErro);
        return entrada;
    }
    
    /**
     * @param mensagem
     * @return String
     */
    public static String readStringPane(String mensagem) {
        String entrada = new String();
        Boolean existeErro;

        do {
            existeErro = false;
            try {
                entrada = showInputDialog(mensagem);
            } catch (NullPointerException e) {
                showMessageDialog(null, erroSemDado, "ERRO", ERROR_MESSAGE);
                existeErro = true;
            }
        } while (existeErro);
        return entrada;
    }
    
    /**
     * @param titulo
     * @param mensagem
     * @param icone
     * @return Character
     */
    public static Character readCharPane(String titulo, String mensagem, String icone) {
        String entrada = new String();
        Boolean existeErro;

        do {
            existeErro = false;
            try {
                entrada = showInputDialog(null, mensagem, titulo, tabela.getIcone(icone)).trim();
            } catch (NullPointerException e) {
                showMessageDialog(null, erroSemDado, "ERRO", ERROR_MESSAGE);
                existeErro = true;
            }
        } while (existeErro);
        return entrada.charAt(0);
    }
    
    /**
     * @param mensagem
     * @return Character
     */
    public static Character readCharPane(String mensagem) {
        String entrada = new String();
        Boolean existeErro;

        do {
            existeErro = false;
            try {
                entrada = showInputDialog(mensagem).trim();
            } catch (NullPointerException e) {
                showMessageDialog(null, erroSemDado, "ERRO", ERROR_MESSAGE);
                existeErro = true;
            }
        } while (existeErro);
        return entrada.charAt(0);
    }
}
