import java.awt.*;
import java.applet.*;
import java.awt.event.*;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.plaf.ComboBoxUI;

import hilos.*;
import reloj.*;

public class ppl extends Applet implements ActionListener {
	Button btnIniciar;
	TextField txt,txt2;
	Label lbl1,lbl2,lbl3;
	int c=10,r=10;
	
	Applet Contenedor = new Applet();
	
    public void setContenedor(Applet contenedor) {
		Contenedor = contenedor;
	    //contentPane.setLayout(null);
	    setBounds(200,100,400,400);
	}
    

	
	
	//Matriz Mz =new Matriz();
	//Circulo Cir = new Circulo();
	Arreglo2 Mz = new Arreglo2();
	
	JComboBox Combo;
	
	Panel pnlForm,pnlPaint,pnlArreglo;

	public void init(){
		Mz.getGraphics();
		Combo =new JComboBox();
		Combo.setBounds(10, 10, 80, 20);
		Combo.addItem("Triangulo");
		Combo.addItem("Circulo");
		Combo.addItem("Rectangulo");
		
		
		txt  = new TextField("",10);
		txt2 = new TextField("",10);
		lbl1 = new Label("Digite Dato: ");
		lbl2 = new Label("Seleccione Figura: ");
		lbl3 = new Label("");
		
		btnIniciar = new Button("Iniciar");
		btnIniciar.addActionListener(this);
		
		txt.addActionListener(this);
		
		pnlForm = new Panel(new GridLayout(1,5,1,1));
		pnlPaint = new Panel(new GridLayout(1,1,1,1));
		pnlArreglo = new Panel(new GridLayout(1,1,1,1));
		
		
		pnlForm.add(lbl1);
		pnlForm.add(txt);
		pnlForm.add(lbl2);
		pnlForm.add(Combo);
		pnlForm.add(btnIniciar);
		
		pnlArreglo.add(txt2);
		pnlArreglo.add(lbl3);
		
		pnlPaint.add(Mz);
		
		add(pnlForm,BorderLayout.NORTH);
		add(pnlArreglo,BorderLayout.EAST);
		add(pnlPaint,BorderLayout.SOUTH);
		Contenedor.add(Mz);
		this.add(Mz);//(Mz,BorderLayout.SOUTH);
		this.show();
		
	}

	@Override
	public void actionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
		int x = 1 , y = 1;
		int puntox=0,puntoy=0;
		
		if(evt.getSource() == btnIniciar){
			String Cadena="";
			String Cadena2="";
			if (Mz.getMatrizLlena() == 1)
			{
				Mz.start();
				while(Mz.isAlive()){
					//Cir.setVisible(false);
					
					x+=3;
					y+=3;
					//Traigo coordenada
					

					
					txt2.setText(""+ Mz.getValor());
					//Cadena = Cadena + Mz.getValor();
					//Cir.Coordenadas(x,y);
					//Cir.setVisible(true);
					c=c+1;
					r=r+1;
					
					//lbl3.setText(""+ Mz.getValor());					
					
					
					if(!Cadena.equals(Mz.getCord()))//Mz.getCordx() != puntox && Mz.getCordy()!=puntoy)
					{
						Mz.suspend();
						
						//JOptionPane.showMessageDialog(null, "x" + puntox + "y" + puntoy +" Mz.getCord()"+Mz.getCord() +"Cadena"+Cadena , "dentro de if", JOptionPane.INFORMATION_MESSAGE);
						Cadena = Mz.getCord();
						puntox = Mz.getCordx();
						puntoy = Mz.getCordy();
						
						Cadena2 = Cadena2 + Mz.getValor();
						//Cadena2 = Cadena2 + "\n";
						lbl3.setText(Cadena2);
						Mz.resume();
						
						//Mz.setVisible(true);
						
						
					}
					
				}	

			}

		}
		
		if(evt.getSource() == txt){
			if(!txt.equals("")){
				int Numero;				
				try{
					//JOptionPane.showMessageDialog(null, "Txt="+txt.getText());
					Numero = Integer.parseInt(txt.getText());
					
					Mz.setMatriz(Numero);
					txt.setText("");

				}catch(NumberFormatException ex){
					JOptionPane.showMessageDialog(null, "Ingrese un valor Numerico", "Error Numero", JOptionPane.ERROR_MESSAGE);
					
				}
				
			}
			
			
		}
	}
	
	public void paint(Graphics g){
		
        super.paint(g);
        g.setColor (Color.red);
        g.drawOval (this.c, this.c, this.r, this.r);    
		g.drawRoundRect(this.c,this.c,this.r,this.r,0,0);

	}
	
   /* public void update( Graphics g ) {
        paint(g);
        }
	
    public void pintaCir(int a, int b,Graphics g ){    	
    	update(g);
    }*/
	

}