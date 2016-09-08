
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author zekken
 */
public class Principal {
    
    public static void main(String[] args)
    {
        int resposta; 
        
        do{
        Circulo ci1= new Circulo();
        ci1.setRaio(Double.parseDouble(JPrompt.readStringPane("Raio do Circulo 1", "Digite o Raio do cirulo 1: ", "?")));
        JPrompt.printPane("Equações do circulo 1", "A area do circulo é: "+ci1.area()+"\nA circuferencia do circulo é: "+ci1.circuferencia());
        
        Circulo ci2= new Circulo();
        ci2.setRaio(Double.parseDouble(JPrompt.readStringPane("Raio do Circulo 2", "Digite o Raio do cirulo 2: ", "?")));
        JPrompt.printPane("Equações do circulo 2", "A area do circulo é: "+ci2.area()+"\nA circuferencia do circulo é: "+ci2.circuferencia());
        
        Circulo ci3= new Circulo();
        ci3.setRaio(Double.parseDouble(JPrompt.readStringPane("Raio do Circulo 3", "Digite o Raio do cirulo 3: ", "?")));
        JPrompt.printPane("Equações do circulo 3", "A area do circulo é: "+ci3.area()+"\nA circuferencia do circulo é: "+ci3.circuferencia());
        
        resposta=JOptionPane.showConfirmDialog(null, "Deseja altera os dados: ");
        
        }while(resposta==0);
    }
    
}
