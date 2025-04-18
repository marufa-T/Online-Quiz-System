package quiz.application;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Rules extends JFrame implements ActionListener {
String name;
JButton start, back;
Rules(String name) {
this.name = name;
// Frame setup
getContentPane().setBackground(Color.WHITE);
setLayout(null);
// Heading
JLabel heading = new JLabel("Welcome " + name + " to Simple Minds");
heading.setBounds(50, 20, 700, 30);
heading.setFont(new Font("Viner Hand ITC", Font.BOLD, 28));
heading.setForeground(new Color(30, 144, 254));
add(heading);
// Rules Description
JLabel rules = new JLabel();
rules.setBounds(20, 90, 740, 350);
rules.setFont(new Font("Tahoma", Font.PLAIN, 16));
rules.setText(
"<html>" +
"1. This quiz is designed to test your knowledge on various topics. Answer the questions to
the best of your ability.<br><br>" +
"2. The quiz consists of 10 questions.<br><br>" +
"3. You will have a total of 15 seconds for each question of the quiz. A timer will be
displayed on the screen to help you keep track.<br><br>" +
"4. Each correct answer will earn you 10 points.<br><br>" +
"5. Once you submit, you'll immediately receive your score. You can also view the correct
answers to the questions you've answered.<br><br>" +
"6. Do not get nervous if your friend is answering more questions; they might just be
lucky!<br><br>" +
"7. Brace yourself; this quiz is not for the faint-hearted.<br><br>" +
"</html>"
);
add(rules);
// Back Button
back = new JButton("Back");
back.setBounds(250, 500, 100, 30);
back.setBackground(new Color(30, 144, 254));
back.setForeground(Color.WHITE);
back.addActionListener(this);
add(back);
// Start Button
start = new JButton("Start");
start.setBounds(400, 500, 100, 30);
start.setBackground(new Color(30, 144, 254));
start.setForeground(Color.WHITE);
start.addActionListener(this);
add(start);
// Frame properties
setSize(800, 650);
setLocationRelativeTo(null); // Center window
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Ensure proper closing
setVisible(true);
}
public void actionPerformed(ActionEvent ae) {
if (ae.getSource() == start) {
if (name == null || name.trim().isEmpty()) {
JOptionPane.showMessageDialog(this, "Name cannot be empty!", "Error",
JOptionPane.ERROR_MESSAGE);
setVisible(false);
new Login();
} else {
setVisible(false);
new Quiz(name);
}
} else if (ae.getSource() == back) {
setVisible(false);
new Login();
}
}
public static void main(String[] args) {
new Rules("Test User");
}
}