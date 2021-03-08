package calculoImc;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import conjuntoDeValores.Acoes;

public class Main implements ActionListener {
	JLabel label;
	JTextField altura;
	JTextField peso;
	JButton button;

	ImageIcon inicio = new ImageIcon("img/imc.jpg");
	ImageIcon muitoBaixo = new ImageIcon("img/imc01.jpg");
	ImageIcon abaixo = new ImageIcon("img/imc02.jpg");
	ImageIcon normal = new ImageIcon("img/imc03.jpg");
	ImageIcon acima = new ImageIcon("img/imc04.jpg");
	ImageIcon obesidad1 = new ImageIcon("img/imc05.jpg");
	ImageIcon obesidade2 = new ImageIcon("img/imc06.jpg");
	ImageIcon obesidade3 = new ImageIcon("img/imc07.jpg");

	public Main() {
		JFrame frame = new JFrame("IMC");
		frame.setVisible(true);
		frame.setSize(500, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new FlowLayout());

		label = new JLabel("Altura (cm)");
		frame.add(label);

		altura = new JTextField(10);
		altura.addActionListener(this);
		frame.add(altura);

		label = new JLabel("Peso (kg)");
		frame.add(label);

		peso = new JTextField(10);
		peso.addActionListener(this);
		frame.add(peso);

		button = new JButton("calcular");
		button.addActionListener(this);
		frame.add(button);

		label = new JLabel(inicio);
		frame.add(label);

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
		CalculoImc calculo = new CalculoImc();
		double imc = 0;

		imc = calculo.calcular(Double.parseDouble(altura.getText().trim()), Double.parseDouble(peso.getText().trim()));

		System.out.println(imc);

		if (imc < 17) {
			label.setIcon(muitoBaixo);

		} else if (imc >= 17 && imc <= 18.49) {
			label.setIcon(abaixo);
		} else if (imc >= 18.5 && imc <= 24.99) {
			label.setIcon(normal);
		} else if (imc >= 25 && imc <= 29.99) {
			label.setIcon(acima);
		} else if (imc >= 30 && imc <= 34.99) {
			label.setIcon(obesidad1);
		} else if (imc >= 35 && imc <= 39.99) {
			label.setIcon(obesidade2);
		} else if (imc < 40) {
			label.setIcon(obesidade3);
		}

	}

}
