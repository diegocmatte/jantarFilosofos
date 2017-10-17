/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jantarfilosofos;

import java.util.Random;

/**
 *
 * @author 08104810
 */
public class Filosofo extends Thread{
    
    private int id;
    
    final int pensando = 0;
    final int tentando_comer = 1;
    final int comendo = 2;
    
    public Filosofo(String nome, int id){
        super(nome);
        this.id = id;
    }
    
    public void TentandoComer(){
        this.id = 1;
        System.out.println("O filosofo "+getName()+" esta tentando comer");
        
        try{
            Random r = new Random();
            Thread.sleep(r.nextInt(1001));
        } catch (InterruptedException ex){
            System.out.println("Erro: "+ex);
        }
    }
    
    public void Comendo(){
        this.id = 2;
        System.out.println("O filosofo "+getName()+" esta comendo!");
        
        try{
            Thread.sleep(1000);
        } catch (InterruptedException ex){
            System.out.println("Erro: "+ex);
        }
    }
    
    public void Pensando(){
        this.id = 0;
        System.out.println("O filosofo "+getName()+" esta pensando!");
        
        try{
            Thread.sleep(5000);
        } catch (InterruptedException ex){
            System.out.println("Erro: "+ex);
        }
         
    }
    
    public void LargarGarfo(){
        
        mutex.decrementar();
        Pensando();
        VizinhoEsquerda().TentarObterGarfos();
        VizinhoDireita().TentarObterGarfos();
        mutex.incrementar();
        
    }
    
    public void PegarGarfo(){
        
        mutex.decrementar();
        TentandoComer();
        TentarObterGarfos();
        mutex.incrementar();
        semaforos[this.id].decrementar();
        
    }
    
    public void TentarObterGarfos(){
        
        if(this.id == 1 && VizinhoEsquerda() != 2 && VizinhoDireita() != 2){
            Comendo();
            Semaforo[this.id].incrementar()
        } 
        
    }
}
    
