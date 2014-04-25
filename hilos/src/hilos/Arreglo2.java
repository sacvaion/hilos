package hilos;

import java.awt.*;
import java.applet.*;
import java.util.*;
import java.text.*;

import javax.swing.JOptionPane;

public class Arreglo2 extends Applet implements Runnable {

	public Arreglo2(){
		this.setVisible(true);
		
		
	}
	
	//inicializo el hilo
	   Thread hilo = null;
	   int anchoApplet, altoApplet;
	   
	 //variables
	   int c=100,r=20;
	  
	  //Doble buffer
	   
	   Image imag;
	   Graphics gBuffer;
	   
	   public void init() {
		    try {
		    jbInit();
		    }
		    catch (Exception e) {
		    e.printStackTrace();
		    }
		  }
		  private void jbInit() throws Exception {
		    this.setBackground(Color.white);
		    anchoApplet=200; //getSize().width;
		    altoApplet=300;//getSize().height;
		  }
		  
		  public void start(){
			  if(hilo==null){
				  hilo = new Thread(this);
				  hilo.start();
			  }
		  }
		  
		  public void stop(){
			  hilo.stop();
			  hilo=null;
		  }
		  		  
		  public void dibujar(Graphics g){
			  	g.setColor(Color.yellow);
		        g.setColor (Color.red);
				g.drawOval ( this.c, this.c,  this.r, this.r);  
				
				
				c=c-10;
				r=r+20;
		  }
		  
		  public void update(Graphics g){
			  if(gBuffer == null){
				  imag=createImage(anchoApplet, altoApplet);
				  gBuffer=imag.getGraphics();
			  }
			  
			  if (c==10)
				  hilo.stop();
			  
			  dibujar(gBuffer);
			  g.drawImage(imag, 0, 0, null);
			  
		  }
		  
		  public boolean isAlive(){			  
			  return hilo.isAlive();
		  }
		  
		  public void suspend(){
			  hilo.suspend();
		  }
		  
		  public void resume(){
			  hilo.resume();
		  }
		  
	// cambio  nuevo
		  
		  
		  int[][] Matriz = new int[3][3];
			int lleno = 0;
			int Valor;
			int Cordx,Cordy;
			String Cord ="00";
			
			
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
								repaint();

							}catch(InterruptedException ie){
								System.out.println(ie.getMessage());
							}	
					}
				}
				
					 /* while(true){
						  try{
							  Thread.sleep(1000);
							 
						  }catch(InterruptedException e){}
						   repaint();
					  }*/
					  
					  
					  
				  
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
