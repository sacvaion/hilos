package hilos;
import java.awt.*;
import java.applet.*;
import java.awt.event.*;
import javax.swing.*;

import javax.swing.JOptionPane;

public class Matriz extends Thread{
	int[][] Matriz = new int[3][3];
	int lleno = 0;
	int Valor;
	int Cordx,Cordy;
	String Cord ="00";
	
	public void Matriz(){
		
		
	}
	
	public void run()
	{
		Valor = Matriz[0][0];
		for(int i = 0;i<3;i++){
			for(int j =0;j<3;j++){
					try{
						Thread.sleep(1000);
						System.out.println(Matriz[i][j]);
						Valor=Matriz[i][j];
						Cordx=i;
						Cordy=j;
						Cord = ""+i+""+j;

					}catch(InterruptedException ie){
						System.out.println(ie.getMessage());
					}	
			}
		}		
	}
	
	
	public void setMatriz(int x){
		int band = 0;
		try{
			for(int i = 0;i<3;i++){
				for(int j =0;j<3;j++){
					if(Matriz[i][j] == 0)
					{
						Matriz[i][j]=x;
						i=3;
						j=3;					
						band=1;					
					}	
				}
			}
			
			if (band == 0){
				Matriz[4][4]=3;
			}
		}catch(ArrayIndexOutOfBoundsException ex)
		{
			JOptionPane.showMessageDialog(null, "Matriz LLena", "Mensaje Matriz", JOptionPane.INFORMATION_MESSAGE);
			lleno=1;
		}		
	}
	
	public void printMatriz(){
		String sM="";
		for(int i = 0;i<3;i++){
			for(int j =0;j<3;j++){
				sM= sM + Matriz[i][j];
				sM = sM + "   ";
			}
			sM=sM + "\n";
		}
		JOptionPane.showMessageDialog(null, "arreglo: \n" + sM,"Matriz", JOptionPane.PLAIN_MESSAGE);
	}

	public int getMatrizLlena()	{		
		return lleno;
	}
	
	public int getMatriz(int a, int b){	
		return Matriz[a][b];
	}
	
	public int getValor(){
		return Valor;
	}	
	
	public int getCordx(){		
		return Cordx;
	}
	
	public int getCordy(){
		
		return Cordy;
	}
	
	public String getCord(){
		
		return Cord;
	}
	
}

