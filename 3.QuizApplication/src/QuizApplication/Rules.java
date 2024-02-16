package QuizApplication;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Rules extends JFrame implements ActionListener {
    JButton start,back;
    String name;
    Rules(String name){
        this.name = name;
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel heading = new JLabel(" Welcome " + name + " to Puzzlerama");
        heading.setBounds(50,20,700,60);
        heading.setFont(new Font("Comic Sans MS",Font.BOLD,40));
        heading.setForeground(new Color(30,144,254));
        add(heading);

        JLabel rules = new JLabel();
        rules.setBounds(150,90,700,350);
        rules.setFont(new Font("Tahoma",Font.PLAIN,16));
        rules.setText(
                "<html>"+
                "1. Answer all questions to the best of your ability."+ "<br><br>" +
                "2. Each question has a time limit, so respond promptly." + "<br><br>" +
                "3. Only one attempt is allowed per question." + "<br><br>" +
                "4. Points are awarded for correct answers and deducted for incorrect ones." +"<br><br>" +
                "5. Do not use external resources or assistance during the quiz."+ "<br><br>" +
                "6. Complete the quiz within the specified time frame."+ "<br><br>" +
                "7. Enjoy the challenge and have fun!"+ "<br><br>" +
                "</html>"
        );

        rules.setForeground(new Color(0,0,0));
        add(rules);

        //buttons
        back = new JButton("Back");
        back.setBounds(250,500,100,30);
        back.setBackground((new Color(30,144,254)));
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);

        start = new JButton("Start");
        start.setBounds(400,500,100,30);
        start.setBackground((new Color(30,144,254)));
        start.setForeground(Color.WHITE);
        start.addActionListener(this);
        add(start);


        setSize(800,650);
        setLocation(350,100);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == start){
            setVisible(false);
            new Quiz(name);

        }else if(ae.getSource() == back){
            setVisible(false);//hide the frame
            new Login();
        }

    }

    public static void main(String[] args){
        new Rules("User");
    }
}
