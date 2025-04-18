package quiz.application;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Login extends JFrame implements ActionListener {
JButton rules, back;
JTextField tfname;
Login() {
getContentPane().setBackground(Color.WHITE);
setLayout(null);
// Removed the image part from here
// You can add other components here as needed
// Set up the heading label
JLabel heading = new JLabel("Simple Minds");
heading.setBounds(250, 60, 300, 45);
heading.setFont(new Font("Viner Hand ITC", Font.BOLD, 40));
heading.setForeground(new Color(30, 144, 254));
add(heading);
// Set up the name label
JLabel nameLabel = new JLabel("Enter your name");
nameLabel.setBounds(250, 150, 300, 20);
nameLabel.setFont(new Font("Mongolian Baiti", Font.BOLD, 18));
nameLabel.setForeground(new Color(30, 144, 254));
add(nameLabel);
// Set up the text field for the name input
tfname = new JTextField();
tfname.setBounds(250, 200, 300, 25);
tfname.setFont(new Font("Times New Roman", Font.BOLD, 20));
add(tfname);
// Set up the "Rules" button
rules = new JButton("Rules");
rules.setBounds(250, 270, 120, 25);
rules.setBackground(new Color(30, 144, 254));
rules.setForeground(Color.WHITE);
rules.addActionListener(this);
add(rules);
// Set up the "Back" button
back = new JButton("Back");
back.setBounds(400, 270, 120, 25);
back.setBackground(new Color(30, 144, 254));
back.setForeground(Color.WHITE);
back.addActionListener(this);
add(back);
// Set up the frame size and position
setSize(800, 500);
setLocation(200, 150);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setVisible(true);
}
// Action handling for buttons
public void actionPerformed(ActionEvent ae) {
if (ae.getSource() == rules) {
String name = tfname.getText();
if (name.isEmpty()) {
JOptionPane.showMessageDialog(this, "Please enter your name!", "Error",
JOptionPane.ERROR_MESSAGE);
} else {
setVisible(false);
new Rules(name); // Transition to Rules screen
}
} else if (ae.getSource() == back) {
setVisible(false);
dispose(); // Close the current window
}
}
public static void main(String[] args) {
new Login(); // Start the login window
}
}