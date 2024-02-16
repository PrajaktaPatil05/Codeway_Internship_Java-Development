package QuizApplication;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Score extends JFrame implements ActionListener {

    Score(String name, int score){
        setBounds(400,150,750,550);
        getContentPane().setBackground(new Color(255,255,255));
        setLayout(null);

        //set image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/score.png"));
        Image i2 = i1.getImage().getScaledInstance(300,250,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 200, 300,250);
        add(image);


        JLabel heading = new JLabel("Thank You " + name + " for playing Puzzlerama");
        heading.setBounds(45,30,700,30);
        heading.setFont(new Font("Tahoma",Font.PLAIN,26));
        add(heading);

        JLabel myScore = new JLabel("Your Score is " + score);
        myScore.setBounds(350,200,300,30);
        myScore.setFont(new Font("Tahoma",Font.PLAIN,26));
        add(myScore);

        JButton submit = new JButton("Play Again");
        submit.setBounds(380,270,120,30);

        submit.setBackground(new Color(30,144,254));
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);


        add(submit);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        setVisible(false);
        new Login();
    }

    public static void main(String[] args){
        new Score("User",0);
    }
}
