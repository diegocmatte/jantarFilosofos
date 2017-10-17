/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jantarfilosofos;

/**
 *
 * @author 08104810
 */
public class Semaforo {
    
    protected int contador;

    public Semaforo (){
        
        this.contador = 0;
        
    }

    public Semaforo (int valor){
        
        this.contador = valor;
    }

    public synchronized void decrementar(){

        while (this.contador == 0){
            try{
                wait();
            }catch (InterruptedException ex)
            {
                System.out.println("ERROR>" + ex.getMessage());
            }
        }
        
        this.contador--;
    }

    public synchronized void incrementar(){
        
        this.contador++;
        notify();
    }
    
}
