package conjuntoDeValores;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import calculadora.Calculadora;

public class Main implements ActionListener {
	Acoes acoes = new Acoes();
	JLabel label;
	JTextField valor;
	JButton adicionar;
	JButton calcular;
	JTextField maior;
	JTextField menor;
	JTextField media;

	public Main() {
		JFrame frame = new JFrame("Calculadora");
		frame.setVisible(true);
		frame.setSize(100, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new FlowLayout());

		label = new JLabel("Digite dois numeros");
		frame.add(label);

		valor = new JTextField(10);
		valor.addActionListener(this);
		frame.add(valor);

		adicionar = new JButton("adicionar");
		adicionar.addActionListener(this);
		frame.add(adicionar);

		label = new JLabel("Maior");
		frame.add(label);
		maior = new JTextField(10);
		maior.addActionListener(this);
		frame.add(maior);

		label = new JLabel("menor");
		frame.add(label);
		menor = new JTextField(10);
		menor.addActionListener(this);
		frame.add(menor);

		label = new JLabel("Média");
		frame.add(label);
		media = new JTextField(10);
		media.addActionListener(this);
		frame.add(media);

		calcular = new JButton("calcular");
		calcular.addActionListener(this);
		frame.add(calcular);

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

		if (e.getActionCommand() == "adicionar") {

			acoes.adicionar(Integer.parseInt(valor.getText().trim()));

		} else if (e.getActionCommand() == "calcular") {
			maior.setText(acoes.verificaMaior());

			menor.setText(acoes.verificaMenor());

			media.setText(acoes.verificaMedia());
		}
	}

}
