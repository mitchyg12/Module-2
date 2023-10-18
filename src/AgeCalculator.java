import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.Period;

public class AgeCalculator {
	public static void main(String[] args) {

		JFrame frame = new JFrame("Age Calculator");
		frame.setSize(300, 150);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel panel = new JPanel();

		JLabel dateLabel = new JLabel("Enter birthdate in format (yyyy-mm-dd):");
		JTextField dateField = new JTextField(10);

		JButton calculateButton = new JButton("Calculate Age");

		JLabel resultLabel = new JLabel();

		calculateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String birthDateStr = dateField.getText();

				LocalDate birthDate = LocalDate.parse(birthDateStr);
				LocalDate currentDate = LocalDate.now();

				int age = Period.between(birthDate, currentDate).getYears();
				resultLabel.setText("Your age is " + age + " years.");
			}
		});

		panel.add(dateLabel);
		panel.add(dateField);
		panel.add(calculateButton);
		panel.add(resultLabel);

		frame.add(panel);
		frame.setVisible(true);
	}
}