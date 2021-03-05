package calculadora;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class Main implements ActionListener {

	JLabel label;
	JTextField textField1;
	JTextField textField2;
	JButton buttonSomar;
	JButton buttonMultiplicar;
	JButton buttonSubtrair;
	JButton buttonDividir;

	public Main() {
		JFrame frame = new JFrame("Clculadora");
		frame.setVisible(true);
		frame.setSize(500, 150);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new FlowLayout());

		label = new JLabel("Digite dois numeros");
		frame.add(label);

		textField1 = new JTextField(10);
		textField1.addActionListener(this);
		frame.add(textField1);

		textField2 = new JTextField(10);
		textField2.addActionListener(this);
		frame.add(textField2);

		buttonSomar = new JButton("somar");
		buttonSomar.addActionListener(this);
		frame.add(buttonSomar);

		buttonMultiplicar = new JButton("multiplicar");
		buttonMultiplicar.addActionListener(this);
		frame.add(buttonMultiplicar);

		buttonSubtrair = new JButton("subtrair");
		buttonSubtrair.addActionListener(this);
		frame.add(buttonSubtrair);

		buttonDividir = new JButton("dividir");
		buttonDividir.addActionListener(this);
		frame.add(buttonDividir);

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
		// TODO Auto-generated method stub

	}

}
