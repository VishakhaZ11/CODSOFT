import java.util.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Numbergame_adv extends JFrame {

    private JLabel l1, l2, l3;
    private JButton b1, b2, b3, submit;
    private JTextField t1;
    private int rand_num;
    private int attempts = 0;
    private JPanel jp,jp1,jp2,jp4,jp5,jp6;
    private JButton ng;

    public Numbergame_adv(String s) {
        super(s);

        getContentPane().setBackground(new Color(0, 0, 139)); // blue
        Font friendlyFont = new Font("Comic Sans MS", Font.PLAIN, 16);

        l1 = new JLabel("# NUMBER GAME #");
        l1.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        l1.setForeground(Color.YELLOW);
        l2 = new JLabel("Choose your level:");
        l2.setFont(new Font("Comic Sans MS",Font.PLAIN,20));
        l2.setForeground(Color.yellow);

        t1 = new JTextField(10);
        t1.setEnabled(false); // Initially disabled
        //t1.setVisible(false);

        // buttons
        b1 = new JButton("EASY");
        b2 = new JButton("MEDIUM");
        b3 = new JButton("HARD");

        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.YELLOW);
        b1.setFont(friendlyFont);

        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.YELLOW);
        b2.setFont(friendlyFont);

        b3.setBackground(Color.BLACK);
        b3.setForeground(Color.YELLOW);
        b3.setFont(friendlyFont);
       
        // Setting action listeners
        b1.addActionListener(new EasyActionListener());
        b2.addActionListener(new MediumActionListener());
        b3.addActionListener(new HardActionListener());

        submit = new JButton("GUESS");
        submit.setEnabled(false); // Initially disabled
        submit.addActionListener(new SubmitActionListener());
        submit.setVisible(false);
        submit.setBackground(new Color(0, 0, 139));
        submit.setForeground(Color.YELLOW);
        submit.setFont(friendlyFont);

        ng=new JButton("NEW GAME");
        ng.setEnabled(false); // Initially disabled
        ng.addActionListener(new NewgameActionListener());
        ng.setVisible(false);
        ng.setFont(friendlyFont);
        ng.setBackground(new Color(0, 0, 139));
        ng.setForeground(Color.YELLOW);


        // size and title
        setSize(550, 400);
        setTitle("Number Guessing Game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        jp=new JPanel();
        jp.setOpaque(false);
        jp1=new JPanel();
        jp1.add(l1);
        jp1.setOpaque(false);
        jp2=new JPanel();
        jp2.add(l2);
        jp2.setOpaque(false);
        jp4=new JPanel();
        jp4.add(b1);
        jp4.setOpaque(false);
        jp5=new JPanel();
        jp5.add(b2);
        jp5.setOpaque(false);
        jp6=new JPanel();
        jp6.add(b3);
        jp6.setOpaque(false);

        // layout
        setLayout(new GridLayout(6, 2, 5, 5));
        add(jp1);
        add(jp2);
        add(jp);
        add(jp4);
        add(jp5);
        add(jp6);
    }

    private class EasyActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            jp.setLayout(new FlowLayout(FlowLayout.CENTER));
            jp.add(t1);
            jp.add(submit);
            //jp2.setLayout(new FlowLayout(FlowLayout.CENTER));
            jp.add(ng);
            ng.setVisible(true);
            ng.setEnabled(true);
            jp.setEnabled(true);
            jp.setVisible(true);
            startGame(20);
        }
    }

    private class MediumActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            jp.setLayout(new FlowLayout(FlowLayout.CENTER));
            jp.add(t1);
            jp.add(submit);
            //jp2.setLayout(new FlowLayout(FlowLayout.CENTER));
            jp.add(ng);
            ng.setVisible(true);
            ng.setEnabled(true);
            jp.setEnabled(true);
            jp.setVisible(true);
            startGame(50);
        }
    }

    private class HardActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            jp.setLayout(new FlowLayout(FlowLayout.CENTER));
            jp.add(t1);
            jp.add(submit);
            //jp2.setLayout(new FlowLayout(FlowLayout.CENTER));
            jp.add(ng);
            ng.setVisible(true);
            ng.setEnabled(true);
            jp.setEnabled(true);
            jp.setVisible(true);
            startGame(100);
        }
    }

    private void startGame(int max) {
        Random ran = new Random();
        rand_num = ran.nextInt(max + 1); // 0 to max
        l2.setText("Guess number from 0-" + max + ":");
       // add(jp);
        jp.setVisible(true);
        t1.setEnabled(true);
        submit.setEnabled(true);
        attempts = 0; // Reset attempts
        
        // Hide the level buttons
        b1.setVisible(false);
        b2.setVisible(false);
        b3.setVisible(false);

        // Show the submit button
        submit.setVisible(true);
    }

    private class SubmitActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
                int guess = Integer.parseInt(t1.getText());
                attempts++;
                if (rand_num == guess) {
                    l2.setText("CORRECT!! YOU WIN!!");
                    submit.setEnabled(false);
                    t1.setEnabled(false);
                } else if (attempts == 5) {
                    l2.setText("You've run out of attempts..Correct number was " + rand_num);
                    submit.setEnabled(false);
                    t1.setEnabled(false);
                } else if (rand_num > guess) {
                    l2.setText("Your guess is lower than the correct number");
                } else if (rand_num < guess) {
                    l2.setText("Your guess is higher than the correct number");
                }
                t1.setText("");
            } catch (NumberFormatException ex) {
                l2.setText("Please enter a valid number");
            }
        }
    }

    private class NewgameActionListener implements ActionListener{
        public void actionPerformed(ActionEvent n)
        {
            l2.setText("Choose your level:");
            jp.setVisible(false);
            jp.setEnabled(false);
            b1.setVisible(true);
            b2.setVisible(true);
            b3.setVisible(true);
    
        }
    }

    public static void main(String[] args) {
        Numbergame_adv game = new Numbergame_adv("Number Guessing Game");
        game.setVisible(true);
    }
}
