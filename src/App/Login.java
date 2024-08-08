package App;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JFrame implements ActionListener {

    JTextField name, id;
    JButton next, exit;
    Login() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        ImageIcon login_photo = new ImageIcon(ClassLoader.getSystemResource("icons/login.jpg"));
        JLabel image = new JLabel(login_photo);
        image.setBounds(450,0,550,500);
        add(image); 
        
        JLabel heading = new JLabel("QUIZ TEST");
        heading.setBounds(130,60,300,45); 
        heading.setFont(new Font("Tahoma",Font.BOLD,40));
        heading.setForeground(new Color(136, 118, 226));
        add(heading); 
        
        JLabel nameLabel = new JLabel("Enter Your Name"); 
        nameLabel.setBounds(150,175,300,20);
        nameLabel.setFont(new Font("Tahoma", Font.BOLD,18));
        add(nameLabel);
        
        JLabel idLabel = new JLabel("Enter Your ID");
        idLabel.setBounds(165, 255, 300, 20);
        idLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
        add(idLabel);
        
        name = new JTextField();
        name.setBounds(80,200,300,25);
        name.setFont(new Font("Tahoma", Font.PLAIN,18));
        add(name);
        
        id = new JTextField();
        id.setBounds(80,280,300,25);
        id.setFont(new Font("Tahoma", Font.PLAIN,18));
        add(id);
        
        next = new JButton("Next");
        next.setBounds(95,330,120,25);
        next.setBackground(new Color(136, 118, 226));
        next.setForeground(Color.WHITE);
        next.addActionListener(this);
        add(next);
        
        exit = new JButton("Exit");
        exit.setBounds(245,330,120,25);
        exit.setBackground(Color.RED);
        exit.setForeground(Color.WHITE);
        exit.addActionListener(this);
        add(exit);
        
        setUndecorated(false);
        setSize(1000, 500);
        setLocation(200, 150);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == next){
            if (name.getText().equals("")){
                JOptionPane.showMessageDialog(null, "Please fill out Name");
            }
            else if (id.getText().equals("")){
                JOptionPane.showMessageDialog(null, "Please fill out ID");
            }
            else {
                setVisible(false);
                new Quiz();
            }
        } 
        else {
            System.exit(0);
        }
    }
    public static void main(String[] args) {
        new Login();
    }
}