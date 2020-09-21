package com.mycompany.proyectoconcurrente;
import javax.swing.*;

public class Ball extends Thread{
    private PanelBall panel;
    private MiX x;
    private MiY y;
    private int posX;
    private int posY;
    
    Ball (PanelBall panel, MiX x, MiY y){
        this.panel = panel;
        this.x = x;
        this.y = y;
        this.posX = 5; 
        this.posY = 5;
    }
      
    public void run(){
        while(true){
            dibujar(this.posX, this.posY);
            if(this.x.getX() > 480){ 
                this.setPosX(-this.getPosX());
            }
            if(this.y.getY() > 300){
                this.setPosY(-this.getPosY()); 
            }
            if(this.x.getX() < 0 ){
                this.setPosX(-this.getPosX());
            }
            if(this.y.getY() < 0 ){
                this.setPosY(-this.getPosY());
            }
        }
    }

    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }
    
    public void dibujar(int posX, int posY){
        try{    
            this.x.setX(this.x.getX() + posX);
            this.y.setY(this.y.getY() + posY);
            panel.repaint();
            Thread.sleep(100);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}

