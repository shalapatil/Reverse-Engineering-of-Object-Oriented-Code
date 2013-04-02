package application_GUI;
import javax.swing.*;


import java.awt.*;
import java.awt.event.*;


public class StartWindow extends JFrame implements ActionListener {

	private JLabel select_lang;
	private JButton nextbtn;
	private String[] languages1 = {
		    "C", "C++", "Java", "Python",
		    "JavaScript", "Perl", "Ruby", "C#"
		  };
	private JComboBox langs=new JComboBox();
	JFrame frm=new JFrame();
    int count=0;
    String selected_lang;
	
	
	public StartWindow()
	{
		 for(int i = 0; i < languages1.length; i++)
			   langs.addItem(languages1[count++]);
		initComponents();
		frm.setSize(380, 270);
		frm.setVisible(true);
		frm.setTitle("Reverse Engineering OOP");
		frm.setResizable(false);
		//frm.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	//	frm.setDefaultCloseOperation(getDefaultCloseOperation());
	}
	public void initComponents()
	{
		frm.setLayout(null);
        select_lang=new JLabel("Select your Language");
		select_lang.setBounds(60,60, 140, 60);
		
		langs.setBounds(210, 80, 90, 25);
		
		nextbtn=new JButton("Next");
		nextbtn.setBounds(210, 170, 90, 32);
		nextbtn.addActionListener(this);
		
		//language=new JComboBox();
		//setLayout(new FlowLayout());
		

		frm.add(select_lang);
		frm.add(nextbtn);
		frm.add(langs);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==nextbtn)
		{
			
			new MainWindow();
			this.dispose();
			//new CheckCompilation();
			
		}
	}
	
}
