package App;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Score extends JFrame implements ActionListener {
    JTextArea feedbackTextArea;
    JButton send;

    Score(int score) {
        setSize(810, 674);
        setLocation(350, 80);
        setUndecorated(false);
        setLayout(null);

        ImageIcon score_photo = new ImageIcon(ClassLoader.getSystemResource("icons/score.jpg"));
        JLabel image = new JLabel(score_photo);
        image.setBounds(0, 0, 800, 650);
        add(image);

        ImageIcon crown_photo = new ImageIcon(ClassLoader.getSystemResource("icons/crown.png"));
        JLabel image2 = new JLabel(crown_photo);
        image2.setBounds(70, 180, 250, 250);
        image.add(image2);

        JLabel heading = new JLabel("Thank you ");
        heading.setBounds(90, 10, 700, 200);
        heading.setFont(new Font("Tahoma", Font.BOLD, 30));
        heading.setForeground(Color.BLACK);
        image.add(heading);

        JLabel Score = new JLabel("Your Result is " + score + " / 10");
        Score.setBounds(380, 170, 300, 30);
        Score.setFont(new Font("Tahoma", Font.BOLD, 26));
        image.add(Score);

        JButton back = new JButton("BACK");
        back.setBounds(460, 225, 120, 30);
        back.setBackground(new Color(71, 155, 81));
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        image.add(back);

        JLabel feed = new JLabel("Feedback");
        feed.setBounds(450, 330, 280, 30);
        feed.setFont(new Font("Tahoma", Font.BOLD, 30));
        image.add(feed);

        feedbackTextArea = new JTextArea();
        feedbackTextArea.setBounds(370, 380, 300, 80);
        feedbackTextArea.setFont(new Font("Tahoma", Font.PLAIN, 18));
        image.add(feedbackTextArea);

        send = new JButton("Send"); 
        send.setBounds(460, 480, 120, 30);
        send.setBackground(new Color(41, 161, 221));
        send.setForeground(Color.WHITE);
        send.addActionListener(this);
        image.add(send);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == send) {
            if (!feedbackTextArea.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Feedback has been sent!");
                feedbackTextArea.setText("");
            } 
            else {
                JOptionPane.showMessageDialog(this, "Please provide feedback!");
            }
        } 
        else {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new Score(0);
    }
}
