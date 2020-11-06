package Employee;
import java.awt.Color;
import java.awt.*;
import javax.swing.*;
import java.lang.Thread;
import java.awt.event.*;

class Front_Page implements ActionListener{
    JFrame f; 
    JLabel id,l1,l2;
    JButton b;

    Front_Page(){
 
        f=new JFrame("Employee Management System");
        f.setBackground(new Color(192,192,192));
        f.setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Employee/icons/front.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1200,700,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l1 = new JLabel(i3);
        
        l1.setBounds(0,150,1360,530);
        f.add(l1);


        b = new JButton("CLICK HERE TO CONTINUE");
        b.setBackground(Color.BLACK);
        b.setForeground(Color.WHITE);
        b.setFont(new Font("serif", Font.BOLD,22));
        

        b.setBounds(500,600,380,70);
        b.addActionListener(this);

        id=new JLabel();
        id.setBounds(0,0,1360,750);
        id.setLayout(null);
        
   

        JLabel lid=new JLabel("CRYSTAL SECURITY ENTERPRISES");
        lid.setBounds(80,30,1500,100);
        lid.setFont(new Font("serif",Font.PLAIN,70));
        lid.setForeground(new Color(0,100,0));
        id.add(lid);
        
        l2=new JLabel("PHONE : 6541237890");
        l2.setBounds(80,30,1600,200);
        l2.setFont(new Font("serif",Font.PLAIN,20));
        id.add(l2);

        id.add(b);
        f.add(id);
        
        
        f.getContentPane().setBackground(new Color(192,192,192));

        f.setVisible(true);
        f.setSize(1360,750);

        while(true){
            lid.setVisible(false);
            try{
                Thread.sleep(500);
            }catch(Exception e){} 
            lid.setVisible(true);
            try{
                Thread.sleep(500);
            }catch(Exception e){}
        }

    }
    @Override
    public void actionPerformed(ActionEvent ae){

        if(ae.getSource()==b){
            selective s=new selective();
            s.setVisible(true);
            f.setVisible(false);
            
        }
    }

    public static void main(String[] arg){
        Front_Page f = new Front_Page();
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
}