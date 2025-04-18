package quiz.application;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class Score extends JFrame implements ActionListener {
JButton playAgain, exit;
private String playerName; // Renamed 'name' to 'playerName' to avoid conflict
Score(String name, int score) {
this.playerName = name; // Store the passed 'name' as 'playerName' to avoid conflict
// Set up frame
setBounds(400, 150, 750, 550);
getContentPane().setBackground(Color.WHITE);
setLayout(null);
// Display a thank-you message
JLabel heading = new JLabel("Thank you " + playerName + " for playing Simple Minds!");
heading.setBounds(100, 120, 700, 30);
heading.setFont(new Font("Tahoma", Font.BOLD, 26));
heading.setForeground(new Color(30, 144, 255));
add(heading);
// Display the score
JLabel lblscore = new JLabel("Your score is " + score);
lblscore.setBounds(250, 200, 300, 30);
lblscore.setFont(new Font("Tahoma", Font.BOLD, 26));
lblscore.setForeground(new Color(30, 144, 255));
add(lblscore);
// Play Again button
playAgain = new JButton("Play Again");
playAgain.setBounds(250, 300, 120, 30);
playAgain.setBackground(new Color(30, 144, 255));
playAgain.setForeground(Color.WHITE);
playAgain.setFont(new Font("Tahoma", Font.PLAIN, 18));
playAgain.addActionListener(this);
add(playAgain);
// Exit button
exit = new JButton("Exit");
exit.setBounds(400, 300, 120, 30);
exit.setBackground(new Color(255, 69, 0));
exit.setForeground(Color.WHITE);
exit.setFont(new Font("Tahoma", Font.PLAIN, 18));
exit.addActionListener(this);
add(exit);
// Frame settings
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Ensure application terminates correctly
setVisible(true);
}
@Override
public void actionPerformed(ActionEvent ae) {
if (ae.getSource() == playAgain) {
setVisible(false);
dispose();
new Rules(playerName); // Redirect to Rules with the user's name
} else if (ae.getSource() == exit) {
setVisible(false);
dispose(); // Close the application
}
}
public static void main(String[] args) {
new Score("Test User", 100); // Example usage for testing
}
}