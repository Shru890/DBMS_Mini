/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Employee;
import javax.swing.*;
import javax.swing.JFrame;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import javax.swing.JFrame;

public class employee_list extends JFrame implements ActionListener{
    DefaultTableModel model = new DefaultTableModel();
    Container cnt = this.getContentPane();
    JTable jtbl = new JTable(model);
   public employee_list() {
        cnt.setLayout(new FlowLayout(FlowLayout.CENTER));
        model.addColumn("Emp_Id");
        model.addColumn("Name");
        model.addColumn("Post");
        model.addColumn("Password");
        model.addColumn("Edit");
        model.addColumn("Delete");
        try {
            conn con = new conn();
            String str = "select emp_id,name,post,password from employee";
            ResultSet rs= con.s.executeQuery(str);
            while(rs.next()){
                model.addRow(new Object[]{rs.getInt(1), rs.getString(2),rs.getString(3),rs.getString(4),"Edit","Delete"});
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        JScrollPane pg = new JScrollPane(jtbl);
        cnt.add(pg);
        this.pack();
    }
    public static void main() {
        JButton b1;
        JFrame frame = new employee_list();
        frame.setTitle("Employees in the company");
        frame.setSize(600,500);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
   
