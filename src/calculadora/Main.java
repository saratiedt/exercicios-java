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
	JTextField valor1;
	JTextField valor2;
	JButton buttonSomar;
	JButton buttonMultiplicar;
	JButton buttonSubtrair;
	JButton buttonDividir;
	JLabel result;
	private String resultado;

	public Main() {
		JFrame frame = new JFrame("Calculadora");
		frame.setVisible(true);
		frame.setSize(400, 200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new FlowLayout());

		label = new JLabel("Digite dois numeros");
		frame.add(label);

		valor1 = new JTextField(10);
		valor1.addActionListener(this);
		frame.add(valor1);

		valor2 = new JTextField(10);
		valor2.addActionListener(this);
		frame.add(valor2);

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

		result = new JLabel(resultado);
		frame.add(result);

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
		Calculadora calculadora = new Calculadora();

		if (valor1.getText().isEmpty() || valor2.getText().isEmpty())
			result.setText("Falta um numero!");
		else {
			int val1 = Integer.parseInt(valor1.getText().trim());
			int val2 = Integer.parseInt(valor2.getText().trim());

			if (e.getActionCommand() == "multiplicar")
				resultado = calculadora.Multiplicar(val1, val2);

			else if (e.getActionCommand() == "somar") {
				resultado = calculadora.Somar(val1, val2);
			}

			else if (e.getActionCommand() == "subtrair")
				resultado = calculadora.Subtrair(val1, val2);

			else if (e.getActionCommand() == "sividir")
				resultado = calculadora.Dividir(val1, val2);

			result.setText(resultado);
		}

	}

}
