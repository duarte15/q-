package q;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.io.*;
public class NovoFrame extends JPanel implements ActionListener{
	private JLabel label;
	private JLabel label2;
  	private JButton botao;  	
  	private JButton botao2;
	public NovoFrame(){
		label = new JLabel("Gerar Arquivo \n TXT");
    	botao = new JButton("Gerar");
    	label2 = new JLabel("Converter Arquivo \n HTML");
    	botao2 = new JButton("Converter");
    	this.label.setBounds(100,100,100,20);
    	this.botao.setBounds(200,100,100,20);
    	this.label2.setBounds(300,200,200,20);
    	this.botao2.setBounds(400,200,200,20);
    	this.add(this.label);
    	this.add(this.botao);
    	this.add(this.label2);
    	this.add(this.botao2);
    	this.botao.addActionListener(this);
    	this.botao2.addActionListener(this);
	}
	public void actionPerformed(ActionEvent e){
		String codigo, linha;
		if(e.getSource()==this.botao){
			codigo = JOptionPane.showInputDialog(null,"Entre com o codigo do aluno");
			codigo = codigo + ".txt";
			try{
				File outputFile = new File(codigo);
				FileWriter gravar = new FileWriter(new File(codigo),true);
      			//Indica que vc ira iniciar a escrever no arquivo
      			PrintWriter saida = new PrintWriter(gravar,true);
      			linha = JOptionPane.showInputDialog(null,"Entre com as respostas");
      			saida.println(linha);
      			saida.close();
      			gravar.close();					
			}catch(IOException ioe){
				ioe.printStackTrace();
			}
		}
		if(e.getSource()==this.botao2){
			String doc = "<TABLE WIDTH=100% BORDER=1 CELLPADDING=4 CELLSPACING=3><THEAD>";
			codigo = JOptionPane.showInputDialog(null,"Entre com o codigo do aluno");
			System.out.println(codigo);
			try{
				//FileWriter gravar = new FileWriter(new File(codigo+".txt"),true);
				BufferedReader br = new BufferedReader(new FileReader(codigo+".txt"));
				while(br.ready()){
					linha = br.readLine();
					for(int i = 0; i < linha.length(); i++){
						doc = doc+"<TR VALIGN=TOP><TD WIDTH=20%><P><BR>" + 
						linha.charAt(i) + "</P></TD></TR>";
					}
				System.out.println(doc);		
				}
				br.close();
				doc = doc + "</TABLE></THEAD>";
				File saidaHtm = new File(codigo+".html");
				FileWriter gravar = new FileWriter(new File(codigo+".html"),true);
				PrintWriter saida = new PrintWriter(gravar,true);
				saida.println(doc);
	      		saida.close();
	      		gravar.close();							
			}catch(IOException ioe){
				ioe.printStackTrace();
			}
    	}
  	}
}