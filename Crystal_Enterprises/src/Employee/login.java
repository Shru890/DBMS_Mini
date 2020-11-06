package Employee;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;

class login  implements ActionListener{

    JFrame f;
    JLabel l1,l2;
    JTextField t1;
    JPasswordField t2;
    JButton b1,b2,register,forgot;

    login(){

        f=new JFrame("Login");

        f.setBackground(new Color(227,227,227));
        f.setLayout(null);

        l1 = new JLabel("Username");
        l1.setBounds(190,250,100,30);
        l1.setFont(new Font("SOLOMON",Font.BOLD,20));
        f.add(l1);
        
        l2 = new JLabel("Password");
        l2.setBounds(190,320,100,30);
        l2.setFont(new Font("SOLOMON",Font.BOLD,20));
        f.add(l2);
 
        t1=new JTextField();
        t1.setBounds(300,250,300,30);
        t1.setFont(new Font("SOLOMON",Font.ROMAN_BASELINE,20));
        f.add(t1);

        t2=new JPasswordField();
        t2.setBounds(300,320,300,30);
        f.add(t2);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Employeee/icons/login.png"));
        Image i2 = i1.getImage().getScaledInstance(160,160,Image.SCALE_DEFAULT);
        ImageIcon i3 =  new ImageIcon(i2);
        JLabel l3 = new JLabel(i3);
        l3.setBounds(350,40,160,160);
        f.add(l3);


        b1 = new JButton("Login");
        b1.setBounds(200,420,140,40);
        b1.setFont(new Font("serif",Font.BOLD,20));
        b1.addActionListener(this);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        f.add(b1);

        b2=new JButton("Cancel");
        b2.setBounds(480,420,140,40);
        b2.setFont(new Font("serif",Font.BOLD,20));
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        f.add(b2);
        b2.addActionListener(this);

        register = new JButton("Click here to create new account");
        register.setBounds(220,520,320,50);
        register.setFont(new Font("serif",Font.BOLD,20));
        register.addActionListener(this);
        register.setBackground(Color.BLACK);
        register.setForeground(Color.WHITE);
        f.add(register);
        
        forgot = new JButton("Forgot Password");
        forgot.setBounds(220,600,320,50);
        forgot.setFont(new Font("serif",Font.BOLD,20));
        forgot.addActionListener(this);
        forgot.setBackground(Color.BLACK);
        forgot.setForeground(Color.WHITE);
        f.add(forgot);
        
        
        f.getContentPane().setBackground(new Color(220,220,220));
        f.setLocation(300,20);
        f.setVisible(true);
        f.setSize(800,700);

    }


    @Override
    public void actionPerformed(ActionEvent ae){

        try{
            conn c1 = new conn();
            String u = t1.getText();
            String v = t2.getText();
            
            String q = "select distinct(username),password from forgotpassjava where username='"+u+"' and password='"+v+"'";
            ResultSet rs = c1.s.executeQuery(q); 
            
            if(rs.next()){
                Manage m =new Manage();
                f.setVisible(false);
                m.setVisible(true);
            }
            else if (ae.getSource()==register){
            f.setVisible(false);
            Create_Acc rgf = new Create_Acc();
            rgf.setVisible(true);
            rgf.pack();
            rgf.setLocationRelativeTo(null);
            rgf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.dispose();
            }
            else if(ae.getSource()==b2){
                selective s = new selective();
                f.setVisible(false);
                s.setVisible(true);
                
            } else if(ae.getSource()==forgot){
                Sendcode sc = new Sendcode();
                sc.setVisible(true);
                f.setVisible(false);
                
            }else{
                JOptionPane.showMessageDialog(null, "Invalid login");
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public static void main(String[] arg){
        login l=new login();
    }

    void setVisible(boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    void pack() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    void setLocationRelativeTo(Object object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    void setDefaultCloseOperation(int EXIT_ON_CLOSE) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    void dispose() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}