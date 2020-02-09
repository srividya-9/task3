package com.epam.task2;
import java.awt.*;
import java.awt.event.*;

class Cal extends Frame implements ActionListener
{
	Button b[]=new Button[18];
	TextField t = new TextField(30);
		Panel p = new Panel();
		String s1="",s2="",x;
		char ch,op,c;
		Cal()
		{
			p.setLayout(new GridLayout(5,4,30,30));
			p.setVisible(true);
			p.setSize(500,500);
			for(int i=0;i<10;i++)
			{
				b[i]=new Button(""+i);
			}
			b[10]=new Button("+");
			b[11]=new Button("-");
			b[12]=new Button("*");
			b[13]=new Button("/");
			b[14]=new Button("%");
			b[15]=new Button(".");
			b[16]=new Button("C");
			b[17]=new Button("=");
			for(int i=0;i<18;i++)
			{
				b[i].addActionListener(this);
			}
			setLayout(new FlowLayout());
			setSize(300,500);
			setVisible(true);
			add(t);
			add(p);
			addWindowListener(new WindowAdapter(){
				public void windowClosing(WindowEvent w)
				{
					System.exit(0);
				}
			});
			for(int i=0;i<18;i++)
			{
				p.add(b[i]);
			}
			add(p);
		}
		public void actionPerformed(ActionEvent e)
		{
			x=e.getActionCommand();
			c = x.charAt(0);
			if(Character.isDigit(c)==true || c=='.')
			{
				t.setText(t.getText()+x);
			}
			else if(c=='C')
			{
				t.setText("");
				s1="";
				s2="";
			}
			else if(c=='=')
			{
				double a,b;
				s2=t.getText();
				a=Double.parseDouble(s1);
				b=Double.parseDouble(s2);
				double res;
				res=calculate(op,a,b);
				t.setText(String.valueOf(res));
			}
			else
			{
				s1=t.getText();
				op=c;
				t.setText("");
			}
			
		}
		public double calculate(char o,double a,double b){
			double res;
			if(op=='+')
				 res=a+b;
				else if(op=='-')
					res=a-b;
				else if(op=='*')
					res=a*b;
				else if(op=='/')
					res=a/b;
				else
					res=a%b;
 			return res;
		}
}
class Calculator extends Cal{

		public static void main(String args[])
		{
			Cal cal=new Cal();
		}
	
}