package contador;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class Main implements ActionListener {
	JFrame frame = new JFrame("Contador");
	JTextField textfield;
	ImageIcon icon1, icon2;
	JButton button;
	JComboBox<Integer> comboBox;
	int valor = 0;
	int soma = 0;

	public Main() {

		frame.setVisible(true);
		frame.setSize(400, 200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new FlowLayout());

		Integer[] valores = { 1, 2, 3, 4, 5 };
		icon1 = new ImageIcon("img/add.png");
		icon2 = new ImageIcon("img/minus.png");

		JLabel label = new JLabel("Contador");
		frame.add(label);

		textfield = new JTextField(15);
		frame.add(textfield);

		comboBox = new JComboBox<Integer>(valores);
		comboBox.addActionListener(this);
		frame.add(comboBox);

		button = new JButton("somar");
		button.setIcon(icon1);
		button.addActionListener(this);
		frame.add(button);

		button = new JButton("subtrair");
		button.setIcon(icon2);
		button.addActionListener(this);
		frame.add(button);
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				new Main();

			}
		});

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (comboBox.getSelectedItem().equals(1)) {
			soma = 1;
		} else if (comboBox.getSelectedItem().equals(2)) {
			soma = 2;
		} else if (comboBox.getSelectedItem().equals(3)) {
			soma = 3;
		} else if (comboBox.getSelectedItem().equals(4)) {
			soma = 4;
		} else if (comboBox.getSelectedItem().equals(5)) {
			soma = 5;
		}

		if (e.getActionCommand().equalsIgnoreCase("somar")) {
			valor += soma;
			textfield.setText(String.valueOf(valor));
		} else if (e.getActionCommand().equalsIgnoreCase("subtrair")) {
			valor -= soma;
			textfield.setText(String.valueOf(valor));
		}

	}

}
