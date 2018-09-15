package q;

import javax.swing.*;
import java.awt.event.*;
public class GerarConverter extends JFrame
{
	public GerarConverter(){
		this.setTitle("{- HENDRIX -}");
	    this.setSize(300, 150);
	    //Adiciona a capacidade de fechar a janela
	    addWindowListener(new WindowAdapter(){
	    	public void windowClosing(WindowEvent e){
	        System.exit(0);
	      }
	    });
	    //Instancia um novo JPanel
	    NovoFrame panel = new NovoFrame(); 
	    //adicona o JPanel a este JFrame
	    this.getContentPane().add( panel ); 
	    //manda mostrar o JFrame
	    this.show(); 
  }
	 public static void main (String args[])
	 {
	 	new GerarConverter();
	 }
}