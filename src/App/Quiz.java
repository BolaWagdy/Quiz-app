package App;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Quiz extends JFrame implements ActionListener {

    String questions[][] = new String[10][5];
    String answers[][] = new String[10][2];
    String useranswers[][] = new String[10][1];
    JLabel qno, question;
    JRadioButton opt1, opt2, opt3, opt4;
    ButtonGroup groupoptions;
    JButton next, submit;

    public static int timer = 30;
    public static int ans_given = 0;
    public static int count = 0;
    public static int score = 0;

    Quiz() {
        setBounds(50, 0, 1440, 850);
        getContentPane().setBackground(Color.WHITE);
        setUndecorated(true);
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/quiz.jpg"));
        JLabel image = new JLabel(i1);
        image.setBounds(0, 0, 1440, 392);
        add(image);

        qno = new JLabel();
        qno.setBounds(100, 450, 50, 30);
        qno.setFont(new Font("Tahoma", Font.PLAIN, 24));
        add(qno);

        question = new JLabel();
        question.setBounds(150, 450, 900, 30);
        question.setFont(new Font("Tahoma", Font.PLAIN, 24));
        add(question);

        questions[0][0] = "Which of the following countries is known as the Land of the Rising Sun?";
        questions[0][1] = "China";
        questions[0][2] = "Japan";
        questions[0][3] = "South Korea";
        questions[0][4] = "Thailand";

        questions[0][0] = "The Renaissance originated in which country?" ;
        questions[0][1] = "Italy";
        questions[0][2] = "France";
        questions[0][3] = "Endland";
        questions[0][4] = "Spain";

        questions[2][0] = "Which of the following is not a state of matter?";
        questions[2][1] = "Solid";
        questions[2][2] = "Gas";
        questions[2][3] = "Plasma";
        questions[2][4] = "Light";

        questions[3][0] = "Who wrote the famous novel 1984?";
        questions[3][1] = "George Orwell";
        questions[3][2] = "F.Scott Fitzgerald";
        questions[3][3] = "Ernest Hemingway";
        questions[3][4] = "Aldous Huxley";

        questions[4][0] = "In what year did Christopher Columbus discover America?";
        questions[4][1] = "1492";
        questions[4][2] = "1500";
        questions[4][3] = "1607";
        questions[4][4] = "1776";

        questions[5][0] = "What is the chemical symbol for iron?";
        questions[5][1] = "Ir";
        questions[5][2] = "Fe";
        questions[5][3] = "Au";
        questions[5][4] = "Ag";

        questions[6][0] = "What is the largest organ in the human body?";
        questions[6][1] = "Heart";
        questions[6][2] = "Brain";
        questions[6][3] = "Skin";
        questions[6][4] = "Liver";

        questions[7][0] = "Who was the first President of the United States to be impeached?";
        questions[7][1] = "Bill Clinton";
        questions[7][2] = "Richard Nixon";
        questions[7][3] = "Andrew Johnson";
        questions[7][4] = "Donald Trump";

        questions[8][0] = "What is the chemical symbol for oxygen?";
        questions[8][1] = "O";
        questions[8][2] = "H";
        questions[8][3] = "C";
        questions[8][4] = "O2";

        questions[9][0] = "What is the capital of France?";
        questions[9][1] = "London";
        questions[9][2] = "Paris";
        questions[9][3] = "Berlin";
        questions[9][4] = "Rome";

        answers[0][1] = "Italy";
        answers[1][1] = "Mongols";
        answers[2][1] = "Light";
        answers[3][1] = "George Orwell";
        answers[4][1] = "1492";
        answers[5][1] = "Fe";
        answers[6][1] = "Skin";
        answers[7][1] = "Andrew Johnson";
        answers[8][1] = "O2";
        answers[9][1] = "Paris";

        opt1 = new JRadioButton();
        opt1.setBounds(170, 520, 700, 30);
        opt1.setBackground(Color.WHITE);
        opt1.setFont(new Font("Dialog", Font.PLAIN, 20));
        add(opt1);

        opt2 = new JRadioButton();
        opt2.setBounds(170, 560, 700, 30);
        opt2.setBackground(Color.WHITE);
        opt2.setFont(new Font("Dialog", Font.PLAIN, 20));
        add(opt2);

        opt3 = new JRadioButton();
        opt3.setBounds(170, 600, 700, 30);
        opt3.setBackground(Color.WHITE);
        opt3.setFont(new Font("Dialog", Font.PLAIN, 20));
        add(opt3);

        opt4 = new JRadioButton();
        opt4.setBounds(170, 640, 700, 30);
        opt4.setBackground(Color.WHITE);
        opt4.setFont(new Font("Dialog", Font.PLAIN, 20));
        add(opt4);

        groupoptions = new ButtonGroup();
        groupoptions.add(opt1);
        groupoptions.add(opt2);
        groupoptions.add(opt3);
        groupoptions.add(opt4);

        next = new JButton("Next");
        next.setBounds(900, 750, 200, 30);
        next.setFont(new Font("Tahoma", Font.PLAIN, 18));
        next.setBackground(new Color(136, 118, 226));
        next.setForeground(Color.BLACK);
        next.addActionListener(this);
        add(next);

        submit = new JButton("Submit");
        submit.setBounds(1150, 750, 200, 30);
        submit.setForeground(Color.BLACK);
        submit.setFont(new Font("Tahoma", Font.PLAIN, 18));
        submit.setBackground(new Color(30, 215, 96));

        submit.addActionListener(this);
        submit.setEnabled(false);
        add(submit);

        start(count);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == next) {
            updateOptionsState(true);
            recordAnswer();
            updateButtonState();
            count++;
            start(count);
        } 
        else if (ae.getSource() == submit) {
            recordAnswer();
            calculateScore();
            setVisible(false);
            new Score(score);
        }
    }
    
    public void paint(Graphics g) {
        super.paint(g);
        drawTimer(g);
        handleTimerExpiration();
    }
    
    private void updateOptionsState(boolean state) {
        opt1.setEnabled(state);
        opt2.setEnabled(state);
        opt3.setEnabled(state);
        opt4.setEnabled(state);
    }
    
    private void recordAnswer() {
        ans_given = 1;
        useranswers[count][0] = (groupoptions.getSelection() == null) ? "" : groupoptions.getSelection().getActionCommand();
    }
    
    private void updateButtonState() {
        next.setEnabled(count != 8);
        submit.setEnabled(count == 8);
    }
    
    private void calculateScore() {
        for (int i = 0; i < useranswers.length; i++) {
            if (useranswers[i][0].equals(answers[i][1])) {
                score++;
            }
        }
    }
    
    private void drawTimer(Graphics g) {
        String time = "Time left - " + timer + " seconds";
        g.setFont(new Font("Tahoma", Font.BOLD, 25));
        if (timer < 10) {
            g.setColor(Color.RED);
        } 
        else {
            g.setColor(Color.BLACK);
        }
        if (timer > 0) {
            g.drawString(time, 1100, 500);
        } 
        else {
            g.drawString("Times up!!", 1100, 500);
        }
    }
    
    private void handleTimerExpiration() {
        timer--;
        try {
            Thread.sleep(1000);
            repaint();
        } 
        catch (Exception e) {
            e.getMessage();
        }
        if (ans_given == 1) {
            ans_given = 0;
            timer = 30;
        } 
        else if (timer < 0) {
            timer = 30;
            updateOptionsState(true);
            if (count == 8) {
                next.setEnabled(false);
                submit.setEnabled(true);
            }
            if (count == 9) {
                recordAnswer();
                calculateScore();
                setVisible(false);
                new Score(score);
            } 
            else {
                recordAnswer();
                count++;
                start(count);
            }
        }
    }

    public void start(int count) {
        qno.setText((count + 1) + ". ");
        question.setText(questions[count][0]);
        opt1.setText(questions[count][1]);
        opt1.setActionCommand(questions[count][1]);

        opt2.setText(questions[count][2]);
        opt2.setActionCommand(questions[count][2]);

        opt3.setText(questions[count][3]);
        opt3.setActionCommand(questions[count][3]);

        opt4.setText(questions[count][4]);
        opt4.setActionCommand(questions[count][4]);

        groupoptions.clearSelection();
        count = 0;
    }

    public static void main(String[] args) {
        new Quiz();
    }
}