package QuizApplication;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JFrame implements ActionListener {
    //globally decalred
    JButton rules,back;
    JTextField tfname;
    Login(){
        //set  background color for the frame
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);//make your own layout

        //set image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/login.jpeg"));

        //Image ko frame ke uper add karna
        JLabel image = new JLabel(i1);
        image.setBounds(0, 0, 600,500);
        add(image);

        //frame ke upar heading dalane ke liye
        JLabel heading = new JLabel(" Puzzlerama  ");
        heading.setBounds(760,60,300,45);
        heading.setFont(new Font("Comic Sans MS",Font.BOLD,40));
        heading.setForeground(new Color(30,144,254));
        add(heading);


        JLabel name = new JLabel("Enter your name");
        name.setBounds(810,150,300,20);
        name.setFont(new Font("Fredoka One",Font.BOLD,18));
        name.setForeground(new Color(30,144,254));
        add(name);

        tfname = new JTextField();
        tfname.setBounds(735,200,300,25);
        tfname.setFont(new Font("Times New Roman",Font.BOLD,15));
        add(tfname);


        rules = new JButton("Rules");
        rules.setBounds(735,270,120,25);
        rules.setBackground((new Color(30,144,254)));
        rules.setForeground(Color.WHITE);
        rules.addActionListener(this);
        add(rules);


        back = new JButton("Back");
        back.setBounds(915,270,120,25);
        back.setBackground((new Color(30,144,254)));
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);

        setSize(1200,500);
        setLocation(200,150);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == rules){
            String name = tfname.getText();
            setVisible(false);
            new Rules(name);

        }else if(ae.getSource() == back){
            setVisible(false);//hide the frame
        }

    }
    public static void main(String[] args) {
        new Login();
    }
}