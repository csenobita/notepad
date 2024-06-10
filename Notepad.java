package com.mycompany.notepad;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.io.*;
import java.util.*;

class Notepad implements ActionListener {
    JFrame f;
    
    JTextArea ta;
    JMenuBar mb;
    JMenu file, edit, Font_size, format;
    JMenuItem newi, openi, savei;
    JMenuItem cuti, copyi, pastei, selectalli;
    JMenuItem bg,fg;
    JMenuItem f12,f14,f16,f18,f22,f24,f28,f32;
    

    Notepad() {
        f = new JFrame();
        ta = new JTextArea();
        mb = new JMenuBar();
        file = new JMenu("File");
        Font_size= new JMenu("Size");
      
        edit = new JMenu("Edit");
        format = new JMenu("Format");
        newi = new JMenuItem("New");
        openi = new JMenuItem("Open");
        savei=new JMenuItem("Save");
        
        cuti = new JMenuItem("Cut");
        copyi = new JMenuItem("Copy");
        pastei = new JMenuItem("Paste");
        selectalli = new JMenuItem("Select All");
        
        bg=new JMenuItem("Set Background") ;
        fg=new  JMenuItem("Set Foreground");
     
        f12= new JMenuItem("12");
        f14= new JMenuItem("14");
        f16= new JMenuItem("16");
        f18= new JMenuItem("18");
        f22= new JMenuItem("22");
        f24= new JMenuItem("24");
        f28= new JMenuItem("28");
        f32= new JMenuItem("32");
        f12.addActionListener(this);
        f14.addActionListener(this);
         f16.addActionListener(this);
         f18.addActionListener(this);
         f22.addActionListener(this);
          f24.addActionListener(this); 
          f28.addActionListener(this);
           f32.addActionListener(this);
        cuti.addActionListener(this);
        copyi.addActionListener(this);
        pastei.addActionListener(this);
        selectalli.addActionListener(this);
       
        bg.addActionListener(this);
        fg.addActionListener(this);
        
        newi.addActionListener(this);
        openi.addActionListener(this);
        savei.addActionListener(this);
       
        selectalli.addActionListener(this);
      
        file.add(newi);
        file.add(openi);
        file.add(savei);
       
        
        edit.add(cuti);
        edit.add(copyi);
        edit.add(pastei);
        edit.add(selectalli);
        
        format.add(bg);
        format.add(fg);
        
        Font_size.add(f12);
        Font_size.add(f14);
        Font_size.add(f16);
        Font_size.add(f18);
        Font_size.add(f22);
        Font_size.add(f24);
        Font_size.add(f28);
        Font_size.add(f32);
        

        mb.add(file);
        mb.add(edit);
        mb.add(format);
        mb.add(Font_size);
        mb.setBounds(4, 4, 990, 30);
        ta.setBounds(4, 5, 995, 995);
        
        f.add(ta);
        f.setJMenuBar(mb);
        f.setLayout(null);
        f.setTitle("My Notepad");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.getContentPane().setBackground(Color.white);
        f.setSize(900, 600);
       
       
            
        f.setVisible(true);
        
    } 
    

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == cuti) 
        {
            ta.cut();
       } 
         if (e.getSource() == copyi)
        {
            ta.copy();
        }
        Object SelectAlli = null;
       if (e.getSource() == pastei) 
        {
            ta.paste();
       } 
        else if (e.getSource() == SelectAlli)
        {
            ta.selectAll();
        }
       else if (e.getSource() == bg)
        {
        JColorChooser color_box= new JColorChooser();
        Color c=color_box.showDialog(f,"Select a Color",Color.white);
        //change bacground color of text
        ta.setBackground(c);
        }
       else if (e.getSource() == fg)
        {
        JColorChooser color_box= new JColorChooser();
        Color c=color_box.showDialog(f,"Select a Color",Color.white);
        //change bacground color of text
        ta.setForeground(c);
        }
        else if (e.getSource() == newi)
        {
       ta.setText("");
       ta.setBackground(Color.white);
        }
       else if (e.getSource() == openi)
        {
        JFileChooser fileChooser= new JFileChooser();
        int option=fileChooser.showOpenDialog(f);
        File f=fileChooser.getSelectedFile();
        try
        {
          Scanner sc=new Scanner(f);
          while(sc.hasNextLine());
          {
              ta.append("\n"+sc.nextLine());
          }
        }
        catch(Exception ex)
        {}
        }
     
        if(e.getSource()==f12){
            ta.setFont(new Font("arial",Font.PLAIN,12));
            ta.setVisible(true);
         }
         if(e.getSource()==f14){
            ta.setFont(new Font("arial",Font.PLAIN,14));
            ta.setVisible(true);
         }
         if(e.getSource()==f16){
            ta.setFont(new Font("arial",Font.PLAIN,16));
            ta.setVisible(true);
         }
         if(e.getSource()==f18){
            ta.setFont(new Font("arial",Font.PLAIN,18));
            ta.setVisible(true);
         }
         if(e.getSource()==f22){
            ta.setFont(new Font("arial",Font.PLAIN,22));
            ta.setVisible(true);
         }
         if(e.getSource()==f24){
            ta.setFont(new Font("arial",Font.PLAIN,24));
            ta.setVisible(true);
         }
          if(e.getSource()==f28){
            ta.setFont(new Font("arial",Font.PLAIN,28));
            ta.setVisible(true);
         }
           if(e.getSource()==f32){
            ta.setFont(new Font("arial",Font.PLAIN,32));
            ta.setVisible(true);
         }
        
        if(e.getSource()== savei);
       {
        JFileChooser fileChooser= new JFileChooser();
        fileChooser.setDialogTitle("Specify a file to save");
        int option=fileChooser.showSaveDialog(f);
        System.out.print(fileChooser);
        if(option==JFileChooser.APPROVE_OPTION)       
        {
          try
            {
              File f=fileChooser.getSelectedFile();
              String text=ta.getText();
              FileWriter myw= new FileWriter(f);
              myw.write(text);
              myw.close();
              System.out.println("Succesful");
            }
          catch(Exception ex)
          {
          }  
        }
       }
    }

    public static void main(String args[]) {
        Notepad n = new Notepad();
    }

}


