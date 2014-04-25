package hilos;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import javax.swing.JOptionPane;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Circulo extends JFrame{
	int c,r=0;	
	private JPanel contentPane;
	
	public Circulo(){		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        setBounds(200,100,400,400);
	}
	
	public void paint(Graphics g)
    {
        super.paint(g);
        g.setColor (Color.red);
		g.drawOval (this.c, this.c, this.r, this.r);        
	}
	
	public void Coordenadas(){		
		this.c=Integer.parseInt(JOptionPane.showInputDialog(null,"Centro del circulo:","Capturar Datos",3));
		this.r=Integer.parseInt(JOptionPane.showInputDialog(null,"Radio:","Capturar Datos",3));		
	}
	
	public void Coordenadas(int x, int y){
		this.c=x;
		this.r=y;
		repaint();
	}
	
    public void update( Graphics g ) {
        paint(g);
        }
}