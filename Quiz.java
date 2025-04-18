package quiz.application;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Quiz extends JFrame implements ActionListener {
String[][] questions = new String[10][5];
String[][] answers = new String[10][2];
String[][] useranswers = new String[10][1];
JLabel qno, question;
JRadioButton opt1, opt2, opt3, opt4;
ButtonGroup groupoptions;
JButton next, submit;
Timer timer;
int count = 0, score = 0;
boolean ans_given = false;
String name;
int timerCount = 15; // Initial timer value
Quiz(String name) {
this.name = name;
setBounds(50, 0, 900, 700);
getContentPane().setBackground(Color.WHITE);
setLayout(null);
// Timer label
qno = new JLabel("Time left - " + timerCount + " seconds");
qno.setBounds(100, 100, 300, 30);
qno.setFont(new Font("Tahoma", Font.PLAIN, 24));
add(qno);
question = new JLabel();
question.setBounds(150, 150, 900, 30);
question.setFont(new Font("Tahoma", Font.PLAIN, 24));
add(question);
// Options for questions
opt1 = new JRadioButton();
opt2 = new JRadioButton();
opt3 = new JRadioButton();
opt4 = new JRadioButton();
groupoptions = new ButtonGroup();
groupoptions.add(opt1);
groupoptions.add(opt2);
groupoptions.add(opt3);
groupoptions.add(opt4);
opt1.setBounds(70, 200, 150, 30);
opt2.setBounds(70, 250, 150, 30);
opt3.setBounds(70, 300, 150, 30);
opt4.setBounds(70, 350, 150, 30);
for (JRadioButton opt : new JRadioButton[]{opt1, opt2, opt3, opt4}) {
opt.setBackground(Color.WHITE);
opt.setFont(new Font("Dialog", Font.PLAIN, 20));
add(opt);
}
// Buttons
next = new JButton("Next");
next.setBounds(600, 200, 200, 40);
submit = new JButton("Submit");
submit.setBounds(600, 250, 200, 40);
submit.setEnabled(false);
for (JButton button : new JButton[]{next, submit}) {
button.setFont(new Font("Tahoma", Font.PLAIN, 22));
button.setBackground(new Color(30, 144, 255));
button.setForeground(Color.WHITE);
button.addActionListener(this);
add(button);
}
loadQuestions();
startQuiz(count);
// Timer
timer = new Timer(1000, e -> updateTimer());
timer.start();
setVisible(true);
}
private void loadQuestions() {
// Question 1
questions[0][0] = "Which is used to find and fix bugs in the Java programs?";
questions[0][1] = "JVM";
questions[0][2] = "JDB";
questions[0][3] = "JDK";
questions[0][4] = "JRE";
answers[0][1] = "JDB"; // Correct answer
// Question 2
questions[1][0] = "What is the capital of France?";
questions[1][1] = "Berlin";
questions[1][2] = "Madrid";
questions[1][3] = "Paris";
questions[1][4] = "Rome";
answers[1][1] = "Paris"; // Correct answer
// Question 3
questions[2][0] = "Which programming language is primarily used for Android development?";
questions[2][1] = "Java";
questions[2][2] = "Kotlin";
questions[2][3] = "Python";
questions[2][4] = "C#";
answers[2][1] = "Kotlin"; // Correct answer
// Question 4
questions[3][0] = "Who is the author of 'Harry Potter'?";
questions[3][1] = "J.K. Rowling";
questions[3][2] = "J.R.R. Tolkien";
questions[3][3] = "George R.R. Martin";
questions[3][4] = "C.S. Lewis";
answers[3][1] = "J.K. Rowling"; // Correct answer
// Question 5
questions[4][0] = "Which planet is known as the Red Planet?";
questions[4][1] = "Venus";
questions[4][2] = "Mars";
questions[4][3] = "Jupiter";
questions[4][4] = "Saturn";
answers[4][1] = "Mars"; // Correct answer
// Question 6
questions[5][0] = "What is the square root of 64?";
questions[5][1] = "6";
questions[5][2] = "7";
questions[5][3] = "8";
questions[5][4] = "9";
answers[5][1] = "8"; // Correct answer
// Question 7
questions[6][0] = "Which gas do plants absorb during photosynthesis?";
questions[6][1] = "Oxygen";
questions[6][2] = "Carbon Dioxide";
questions[6][3] = "Nitrogen";
questions[6][4] = "Hydrogen";
answers[6][1] = "Carbon Dioxide"; // Correct answer
// Question 8
questions[7][0] = "Who painted the Mona Lisa?";
questions[7][1] = "Vincent Van Gogh";
questions[7][2] = "Leonardo da Vinci";
questions[7][3] = "Michelangelo";
questions[7][4] = "Pablo Picasso";
answers[7][1] = "Leonardo da Vinci"; // Correct answer
// Question 9
questions[8][0] = "What is the chemical symbol for water?";
questions[8][1] = "H";
questions[8][2] = "O";
questions[8][3] = "H2O";
questions[8][4] = "HO2";
answers[8][1] = "H2O"; // Correct answer
// Question 10
questions[9][0] = "What is the largest ocean on Earth?";
questions[9][1] = "Atlantic Ocean";
questions[9][2] = "Indian Ocean";
questions[9][3] = "Pacific Ocean";
questions[9][4] = "Arctic Ocean";
answers[9][1] = "Pacific Ocean"; // Correct answer
}
private void updateTimer() {
if (timerCount > 0) {
qno.setText("Time left - " + timerCount + " seconds");
timerCount--;
} else {
ans_given = true;
timer.stop(); // Stop the timer when it reaches 0
nextQuestion(); // Automatically move to the next question
}
}
private void nextQuestion() {
if (count == 9) { // Last question
submitQuiz();
} else {
count++;
startQuiz(count);
resetTimer(); // Reset timer after moving to the next question
}
}
private void resetTimer() {
timerCount = 15; // Reset timer to 15 seconds
timer.restart(); // Restart the timer for the next question
}
private void startQuiz(int questionIndex) {
question.setText(questions[questionIndex][0]);
opt1.setText(questions[questionIndex][1]);
opt1.setActionCommand(questions[questionIndex][1]);
opt2.setText(questions[questionIndex][2]);
opt2.setActionCommand(questions[questionIndex][2]);
opt3.setText(questions[questionIndex][3]);
opt3.setActionCommand(questions[questionIndex][3]);
opt4.setText(questions[questionIndex][4]);
opt4.setActionCommand(questions[questionIndex][4]);
groupoptions.clearSelection();
}
private void submitQuiz() {
for (int i = 0; i < useranswers.length; i++) {
if (useranswers[i][0] != null && useranswers[i][0].equals(answers[i][1])) {
score += 10;
}
}
setVisible(false);
new Score(name, score);
}
@Override
public void actionPerformed(ActionEvent ae) {
if (ae.getSource() == next) {
ans_given = true;
if (groupoptions.getSelection() == null) {
useranswers[count][0] = ""; // No answer selected
} else {
useranswers[count][0] = groupoptions.getSelection().getActionCommand();
}
if (count == 8) {
next.setEnabled(false);
submit.setEnabled(true); // Enable submit button
}
nextQuestion(); // Move to the next question and reset the timer
} else if (ae.getSource() == submit) {
ans_given = true;
if (groupoptions.getSelection() == null) {
useranswers[count][0] = ""; // No answer selected
} else {
useranswers[count][0] = groupoptions.getSelection().getActionCommand();
}
submitQuiz();
}
}
public static void main(String[] args) {
new Quiz("User");
}
}