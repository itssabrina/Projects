package exam;


/*Online Java Paper Test*/

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class OnlineTest extends JFrame implements ActionListener
{
	JLabel l;
	JRadioButton jb[]=new JRadioButton[5];
	JButton b1,b2;
	ButtonGroup bg;
	int count=0,current=0,x=1,y=1,now=0;
	int m[]=new int[10];
	OnlineTest(String s)
	{
		super(s);
		l=new JLabel();
		add(l);
		bg=new ButtonGroup();
		for(int i=0;i<5;i++)
		{
			jb[i]=new JRadioButton();
			add(jb[i]);
			bg.add(jb[i]);
		}
		b1=new JButton("Next");
		b2=new JButton("Bookmark");
		b1.addActionListener(this);
		b2.addActionListener(this);
		add(b1);add(b2);
		set();
		l.setBounds(30,40,450,20);
		jb[0].setBounds(50,80,100,20);
		jb[1].setBounds(50,110,100,20);
		jb[2].setBounds(50,140,100,20);
		jb[3].setBounds(50,170,100,20);
		b1.setBounds(100,240,100,30);
		b2.setBounds(270,240,100,30);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		setLocation(250,100);
		setVisible(true);
		setSize(600,350);
	}
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==b1)
		{
			if(check())
				count=count+1;
			current++;
			set();
			if(current==9)
			{
				b1.setEnabled(false);
				b2.setText("Result");
			}
		}
		if(e.getActionCommand().equals("Bookmark"))
		{
			JButton bk=new JButton("Bookmark"+x);
			bk.setBounds(480,20+30*x,100,30);
			add(bk);
			bk.addActionListener(this);
			m[x]=current;
			x++;
			current++;
			set();
			if(current==9)
				b2.setText("Result");
			setVisible(false);
			setVisible(true);
		}
		for(int i=0,y=1;i<x;i++,y++)
		{
		if(e.getActionCommand().equals("Bookmark"+y))
		{
			if(check())
				count=count+1;
			now=current;
			current=m[y];
			set();
			((JButton)e.getSource()).setEnabled(false);
			current=now;
		}
		}

		if(e.getActionCommand().equals("Result"))
		{
			if(check())
				count=count+1;
			current++;
			//System.out.println("correct ans="+count);
			JOptionPane.showMessageDialog(this,"correct ans="+count);
			System.exit(0);
		}
	}
	void set()
	{
		jb[4].setSelected(true);
		if(current==0)
		{
			l.setText("Que1: Sabrinar nick name ki?");
			jb[0].setText("Model");jb[1].setText("rashid");jb[2].setText("pagli");jb[3].setText("angry bird");
		}
		if(current==1)
		{
			l.setText("Que2: what is the capital of bd");
			jb[0].setText("chitagong");jb[1].setText("dhaka");jb[2].setText("noakhali");jb[3].setText("kalkata");
		}
		if(current==2)
		{
			l.setText("Que3: who is the best footballer now");
			jb[0].setText("lm10");jb[1].setText("cr7");jb[2].setText("zlatan");jb[3].setText("hurrycane");
		}
		if(current==3)
		{
			l.setText("Que4: cureent cricket world cup ke jitse");
			jb[0].setText("india");jb[1].setText("bd");jb[2].setText("england");jb[3].setText("australia");
		}
		if(current==4)
		{
			l.setText("Que5: Which institute is best for java coaching");
			jb[0].setText("Utek");jb[1].setText("Aptech");jb[2].setText("SSS IT");jb[3].setText("jtek");
		}
		if(current==5)
		{
			l.setText("Que6: Which is the best pc game ?");
			jb[0].setText("assasins creed");jb[1].setText("gta v");jb[2].setText("dbz");jb[3].setText("watch dog");
		}
		if(current==6)
		{
			l.setText("Que7: Which one among these is not a class ");
			jb[0].setText("Swing");jb[1].setText("Actionperformed");jb[2].setText("ActionEvent");jb[3].setText("Button");
		}
		if(current==7)
		{
			l.setText("Que8: mdel r last name ki?");
			jb[0].setText("begum");jb[1].setText("rashid");jb[2].setText("kabir");jb[3].setText("sokina");
		}
		if(current==8)
		{
			l.setText("Que9: mbl r best game ki ?");
			jb[0].setText("candy crush");jb[1].setText("boob beach");jb[2].setText("coc");jb[3].setText("destroy");
		}
		if(current==9)
		{
			l.setText("Que10: world r best car knta ?");
			jb[0].setText("laborgini");jb[1].setText("ferari");jb[2].setText("alpha romero");jb[3].setText("toyota");
		}
		l.setBounds(30,40,450,20);
		for(int i=0,j=0;i<=90;i+=30,j++)
			jb[j].setBounds(50,80+i,200,20);
	}
	boolean check()
	{
		if(current==0)
			return(jb[0].isSelected());
		if(current==1)
			return(jb[1].isSelected());
		if(current==2)
			return(jb[3].isSelected());
		if(current==3)
			return(jb[0].isSelected());
		if(current==4)
			return(jb[2].isSelected());
		if(current==5)
			return(jb[2].isSelected());
		if(current==6)
			return(jb[0].isSelected());
		if(current==7)
			return(jb[1].isSelected());
		if(current==8)
			return(jb[1].isSelected());
		if(current==9)
			return(jb[1].isSelected());
		return false;
	}
	public static void main(String s[])
	{
		new OnlineTest("Online Test Of Java");
	}


}
