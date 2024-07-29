import java.util.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class Grade_calculator extends JFrame {
    private JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9;
    private JTextField t1,t2,t3,t4,t5,t6;
    private JButton calc;

    public Grade_calculator(String s)
    {
        super(s);
        setSize(400,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        l1=new JLabel("GRADE CALCULATOR");
        l1.setBounds(130,20,250,50);
        add(l1);
        setTitle("GRADE CALCULATOR FOR STUDENT");
        l2=new JLabel("Enter marks:");
        l2.setBounds(150,60,180,50);
        add(l2);
        l3=new JLabel("Subject-1:");
        l3.setBounds(100,90,180,50);
        add(l3);
        t1=new JTextField("");
        t1.setBounds(250,105,80,20);
        add(t1);
        l4=new JLabel("Subject-2:");
        l4.setBounds(100,120,180,50);
        add(l4);
        t2=new JTextField("");
        t2.setBounds(250,135,80,20);
        add(t2);
        l5=new JLabel("Subject-3:");
        l5.setBounds(100,150,180,50);
        add(l5);
        t3=new JTextField("");
        t3.setBounds(250,165,80,20);
        add(t3);
        l6=new JLabel("Subject-4:");
        l6.setBounds(100,180,180,50);
        add(l6);
        t4=new JTextField("");
        t4.setBounds(250,195,80,20);
        add(t4);
        l7=new JLabel("Subject-5:");
        l7.setBounds(100,210,180,50);
        add(l7);
        t5=new JTextField("");
        t5.setBounds(250,225,80,20);
        add(t5);
        calc=new JButton("Calculate");
        calc.setBounds(150,250,100,30);
        add(calc);
        l8=new JLabel("");
        l9=new JLabel("");
        calc.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                totalmarks();
            }
        });


    }

    private void totalmarks()
    {
        double sum=0;
        double s1=Double.parseDouble(t1.getText());
        sum=sum+s1;
        double s2=Double.parseDouble(t2.getText());
        sum=sum+s2;
        double s3=Double.parseDouble(t3.getText());
        sum=sum+s3;
        double s4=Double.parseDouble(t4.getText());
        sum=sum+s4;
        double s5=Double.parseDouble(t5.getText());
        sum=sum+s5;

        double per=sum/500*100;
        l8.setText("Percentage: "+per+"%");
        l8.setBounds(150,280,180,50);
        add(l8);

        if (per >= 90) {
            l9.setText("GRADE: A");
            l9.setBounds(150,310,180,50);
            add(l9);
        } else if (per >= 80) {
            l9.setText("GRADE: B");
            l9.setBounds(150,310,180,50);
            add(l9);
        } else if (per >= 70) {
            l9.setText("GRADE: C");
            l9.setBounds(150,310,180,50);
            add(l9);
        } else if (per >= 60) {
            l9.setText("GRADE: D");
            l9.setBounds(150,310,180,50);
            add(l9);
        } else {
            l9.setText("GRADE: F");
            l9.setBounds(150,310,180,50);
            add(l9);
        }
        revalidate();
        repaint();
    }

    public static void main(String args[])
    {
        Grade_calculator calculator=new Grade_calculator("calculate");
        calculator.setVisible(true);
    }
}
