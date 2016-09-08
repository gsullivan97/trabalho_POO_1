
import javax.swing.JOptionPane;
import javax.swing.JTextField;


/**
 *
 * @author 115115697
 */
public class Principal {
    
    public static void main(String[] args) {
        /*
        int resposta;
        
        do{
        Contato c1 = new Contato();
        c1.setNome(JPrompt.readStringPane("Contato 1", "Digite seu nome: ", "?"));
        c1.setTelefone(JPrompt.readStringPane("Contato 1", "Digite seu telefone: ", "?"));
        
        Contato c2 = new Contato();
        c2.setNome(JPrompt.readStringPane("Contato 2", "Digite seu nome: ", "?"));
        c2.setTelefone(JPrompt.readStringPane("Contato 2", "Digite seu telefone: ", "?"));
        
        Contato c3 = new Contato();
        c3.setNome(JPrompt.readStringPane("Contato 3", "Digite seu nome: ", "?"));
        c3.setTelefone(JPrompt.readStringPane("Contato 3", "Digite seu telefone: ", "?"));
        
        JPrompt.printPane("Contato 1", "Nome: "+c1.getNome()+"\nTelefone: " + c1.getTelefone());
        
        JPrompt.printPane("Contato 2", "Nome: " + c2.getNome() + "\nTelefone: " + c2.getTelefone());
        
        JPrompt.printPane("Contato 3", "Nome: " + c3.getNome() + "\nTelefone: " + c3.getTelefone());
        
        resposta = JOptionPane.showConfirmDialog(null, "Deseja alterar os contatos");
        
        }while(resposta == 0);
        */
        int resposta;
        
        do{
        String[] contato = new String[2];
        
        contato = JPrompt.readTwoStringPane("Conato 1", "Digite seu nome: ", "Digite seu Telefone: ", "?");
        Contato c1 = new Contato();
        c1.setNome(contato[0]);
        c1.setTelefone(contato[1]);
        
        contato = JPrompt.readTwoStringPane("Conato 2", "Digite seu nome: ", "Digite seu Telefone: ", "?");
        Contato c2 = new Contato();
        c2.setNome(contato[0]);
        c2.setTelefone(contato[1]);
        
        contato = JPrompt.readTwoStringPane("Conato 3", "Digite seu nome: ", "Digite seu Telefone: ", "?");
        Contato c3 = new Contato();
        c3.setNome(contato[0]);
        c3.setTelefone(contato[1]);
        
        JPrompt.printPane("Contatos","Conato1 \nNome: "+c1.getNome()+"\nTelefone: " + c1.getTelefone()+"\n"
                          +"Conato2 \nNome: "+c2.getNome()+"\nTelefone: " + c2.getTelefone()+"\n"
                          +"Conato3 \nNome: "+c3.getNome()+"\nTelefone: " + c3.getTelefone());
        
        resposta = JOptionPane.showConfirmDialog(null, "Deseja alterar os contatos");
        
        }while(resposta == 0);
    }
}
