/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author zekken
 */
public class Circulo {
    
    double Raio;
    
    public double circuferencia()
    {
        //circuferencia = 2·π·raio
        double C, PI=3.14;
        
        C= PI*3.14 * Raio;
        
        return C;
    }
    
    public double area()
    {
        //area = π * (raio)^2
        double A, PI=3.14;
        
        A= PI * (Raio*Raio);
        
        return A;
    }

    public double getRaio() {
        return Raio;
    }

    public void setRaio(double Raio) {
        this.Raio = Raio;
    }
    
}
