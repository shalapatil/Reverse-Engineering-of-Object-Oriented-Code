package application_GUI;

import java.awt.*;

import javax.swing.*;

//import MainWindow.WindowHandler;

import java.awt.event.*;
import java.io.*;

public class MainWindow extends JFrame implements ActionListener, KeyListener {

	 private String fname = ""; 
	 private JMenuBar mbar;
	 private JMenu mnuFile, mnuEdit, mnuHelp;
	 private JMenuItem fileNew, fileOpen, fileSave,fileExit;
	 private JMenuItem editCut, editCopy, editPaste;
	 private JMenuItem helpAbout;
	 private Font f;
	    
	 private JToolBar tlbrEditor;
	 private JButton bttnNew, bttnOpen, bttnSave;
	 private JButton bttnCut, bttnCopy, bttnPaste;

	 private ImageIcon icoNew, icoOpen, icoSave;
	 private ImageIcon icoCut, icoCopy, icoPaste;
	    
	 private Container con;
	    

	 public MainWindow()
	 {
		 initIcons();
	     initMenu();
	     initToolbar();
	     con = getContentPane();
	        
	     f = new Font("Arial", Font.PLAIN, 24);
	     //set layout
	        /*
	         BorderLayout allows adding  
	         components at 5 places
	         east,west,north,south and center. 
	         */
	        con.setLayout(new BorderLayout());
	        setTitle("Reverse Engineering OOP");
	        setSize(600, 400);
	        setVisible(true);
	        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
	        addWindowListener(new WindowHandler());
	 }
	 
	 void initIcons(){
		    icoNew = new ImageIcon("D:/Java1/New_UI/icons/new.gif");
	        icoOpen = new ImageIcon("D:/Java1/New_UI/icons/open.gif");
	        icoSave = new ImageIcon("D:/Java1/New_UI/icons/save.gif");
	        icoCut = new ImageIcon("D:/Java1/New_UI/icons/cut.gif");
	        icoCopy = new ImageIcon("D:/Java1/New_UI/icons/copy.gif");
	        icoPaste = new ImageIcon("D:/Java1/New_UI/icons/paste.gif");
	 }
	 void initMenu(){
		 //create menubar
	        mbar = new JMenuBar();
	        
	        //create menus
	        mnuFile = new JMenu("File");
	        mnuEdit = new JMenu("Edit");
	        mnuHelp = new JMenu("Help");

	        //create menuitems
	        fileNew = new JMenuItem("New Project",icoNew);
	        fileOpen = new JMenuItem("Open Project", icoOpen);
	        fileSave = new JMenuItem("Save Project", icoSave);
	        fileExit = new JMenuItem("Exit");
	        
	        editCut = new JMenuItem("Cut", icoCut);
	        editCopy = new JMenuItem("Copy", icoCopy);
	        editPaste = new JMenuItem("Paste", icoPaste);
	      
	        
	        helpAbout = new JMenuItem("About");
	        
	        //add menuitems to menus
	        mnuFile.add(fileNew);
	        mnuFile.add(fileOpen);
	        mnuFile.add(fileSave);
	        mnuFile.addSeparator();
	        mnuFile.add(fileExit);
	        
	        mnuEdit.add(editCut);
	        mnuEdit.add(editCopy);
	        mnuEdit.add(editPaste);
	        //mnuEdit.addSeparator();
	     
	        mnuHelp.add(helpAbout);
	        
	        //add menus to menubar
	        mbar.add(mnuFile);
	        mbar.add(mnuEdit);
	        mbar.add(mnuHelp);
	        
	        //add menubar to window
	        setJMenuBar(mbar);
	        
	        //attach listeners
	        
	        fileNew.addActionListener(this);
	        fileOpen.addActionListener(this);
	        fileSave.addActionListener(this);
	        fileExit.addActionListener(this);
	        
	        editCut.addActionListener(this);
	        editCopy.addActionListener(this);
	        editPaste.addActionListener(this);
	     
	        helpAbout.addActionListener(this);
	 }
	 void initToolbar()
	 {
		 bttnNew = new JButton(icoNew);
	        bttnOpen = new JButton(icoOpen);
	        bttnSave = new JButton(icoSave);
	        
	        bttnCut = new JButton(icoCut);
	        bttnCopy = new JButton(icoCopy);
	        bttnPaste = new JButton(icoPaste);
	        
	        tlbrEditor = new JToolBar();
	        tlbrEditor.add(bttnNew);
	        tlbrEditor.add(bttnOpen);
	        tlbrEditor.add(bttnSave);
	        
	        tlbrEditor.addSeparator();
	        
	        tlbrEditor.add(bttnCut);
	        tlbrEditor.add(bttnCopy);
	        tlbrEditor.add(bttnPaste);
	    
	        //add action listeners to buttons
	        bttnNew.addActionListener(this);
	        bttnOpen.addActionListener(this);
	        bttnSave.addActionListener(this);
	        
	        bttnCut.addActionListener(this);
	        bttnCopy.addActionListener(this);
	        bttnPaste.addActionListener(this);

	 }
	 
	 public void actionPerformed(ActionEvent e){
		 if(e.getSource().equals(fileNew) || e.getSource().equals(bttnNew) )
	            fNew();
	        else if(e.getSource().equals(fileOpen) || e.getSource().equals(bttnOpen))
	            fOpen();
	        else if(e.getSource().equals(fileSave) || e.getSource().equals(bttnSave))
	            fSave();
	        else if(e.getSource().equals(fileExit))
	            fExit();
	    
	     }
	 
	 void fNew()
	    {
	      int ch;  
	      if( true)
	      {
	        ch = JOptionPane.showConfirmDialog
	        (
	            this, //parent
	            "Do You Want To Save Changes", //message
	            "File Open", //title
	            JOptionPane.YES_NO_CANCEL_OPTION //message type
	        );  
	        
	        if(ch == JOptionPane.YES_OPTION)
	        {
	            fSave();
	        }
	        else if(ch == JOptionPane.NO_OPTION)
	        {
	            //no code reqd as chgs are not
	            //to be saved and file will be
	            //opened after else
	        }
	        else //cancel
	        {   
	            return; //to terminate fn
	        }
	      }        
	     // txtChanged = false;
	      fname = "";
	      //jtaEditor.setText("");
	    }
	    
	    void fOpen()
	    {
	      int ch;
	     if( true)
	      {
	        ch = JOptionPane.showConfirmDialog
	        (
	            this, //parent
	            "Do You Want To Save Changes", //message
	            "File Open", //title
	            JOptionPane.YES_NO_CANCEL_OPTION //message type
	        );  
	        
	        if(ch == JOptionPane.YES_OPTION)
	        {
	            fSave();
	        }
	        else if(ch == JOptionPane.NO_OPTION)
	        {
	            //no code reqd as chgs are not
	            //to be saved and file will be
	            //opened after else
	        }
	        else //cancel
	        {   
	            return; //to terminate fn
	        }
	      }
	      JFileChooser jfc = new JFileChooser();
	      ch = jfc.showOpenDialog(this);//this : parent
	      if(ch == jfc.APPROVE_OPTION)
	      {//open
	         //get file object
	         //use it to fetch file name and path
	         File f = jfc.getSelectedFile(); 
	         String path = f.getAbsolutePath();
	         fRead(path); 
	      }
	    }
	    
	    
	    void fSave()
	    {
	      if(fname.length() == 0)
	      {
	        int ch;
	        JFileChooser jfc = new JFileChooser();
	        ch = jfc.showSaveDialog(this);//this : parent
	        if(ch == jfc.APPROVE_OPTION)
	        {//save
	           //get file object
	           //use it to fetch file name and path
	           File f = jfc.getSelectedFile(); 
	           String path = f.getAbsolutePath();
	           fWrite(path); 
	        }
	      }
	      else
	          fWrite(fname);
	    }
	    
	    void fWrite(String path)
	    {
	       try
	       {
	        FileWriter fw = new FileWriter(path);
	        BufferedWriter bw = new BufferedWriter(fw);
	       // bw.write(jtaEditor.getText());
	        bw.flush();
	        bw.close();
	       // txtChanged = false;
	        fname = path;
	       }
	       catch(IOException e)
	       {
	           JOptionPane.showMessageDialog
	             (
	               this, //parent    
	               "File Save Error", //title
	               "Error " + e.getMessage(), //message
	               JOptionPane.ERROR_MESSAGE //error type
	           );
	       }
	    
	    }
	    
	    void fRead(String path)
	    {
	       try
	       {
	        FileReader fr = new FileReader(path);
	        BufferedReader br = new BufferedReader(fr);
	        String data;
	        
	        //jtaEditor.setText("");
	        while((data = br.readLine())!= null)
	        {
	            data = data + "\n";
	          //  jtaEditor.append(data);
	        }
	        br.close();
	        //txtChanged = false;
	        fname = path;
	       }
	       catch(IOException e)
	       {
	           JOptionPane.showMessageDialog
	             (
	               this, //parent    
	               "File Open Error", //title
	               "Error " + e.getMessage(), //message
	               JOptionPane.ERROR_MESSAGE //error type
	           );
	       }
	    
	    }
	    
	    void fExit()
	    {
	      if(true)
	      {
	        int ch;
	        ch = JOptionPane.showConfirmDialog
	        (
	            this, //parent
	            "Do You Want To Save Changes", //message
	            "File Exit", //title
	            JOptionPane.YES_NO_CANCEL_OPTION //message type
	        );  
	        
	        if(ch == JOptionPane.YES_OPTION)
	        {
	            fSave();
	            dispose();
	        }
	        else if(ch == JOptionPane.NO_OPTION)
	        {
	    //close this window, free all the resources
	    //used by it
	            dispose();
	        }
	        else //cancel
	        {   
	            return;
	        }
	      }
	      else
	          dispose();
	    }
	    
	   

	    public void keyPressed(KeyEvent e) 
	    {}

	    public void keyReleased(KeyEvent e) 
	    {}
	    
	    public void keyTyped(KeyEvent e) 
	    {
	      
	    }

	    class WindowHandler extends WindowAdapter
	    {
	        public void windowClosing(WindowEvent e)
	        {
	            fExit();
	        }
	    }
	}


