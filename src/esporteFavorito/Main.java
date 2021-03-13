package esporteFavorito;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;


public class Main implements ActionListener {
	JFrame frame = new JFrame("Lanchonete");
	JButton btnAdd;
	JButton btnLimpar;
	JTextField result;
	int futebol = 0;
	int volei = 0;
	int basquete = 0;

	JCheckBox opcao1;
	JCheckBox opcao2;
	JCheckBox opcao3;
	JCheckBox opcao4;
	JCheckBox opcao5;
	
	Resultado resultado;


	public Main() {

		frame.setVisible(true);
		frame.setSize(250, 150);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new FlowLayout());

		JLabel info = new JLabel("Quais esportes você pratica?:");
		frame.add(info);

		opcao1 = new JCheckBox("Futebol");
		frame.add(opcao1);

		opcao2 = new JCheckBox("Volei");
		frame.add(opcao2);

		opcao3 = new JCheckBox("Basquete");
		frame.add(opcao3);

		btnAdd = new JButton("Votar");
		btnAdd.addActionListener(this);
		frame.add(btnAdd);


		btnLimpar = new JButton("Terminar");
		btnLimpar.addActionListener(this);
		frame.add(btnLimpar);
		
		resultado = new Resultado();
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
		if (e.getActionCommand() == "Votar") {
			if (opcao1.isSelected())
				futebol += 1;

			if (opcao2.isSelected())
				volei += 1;

			if (opcao3.isSelected())
				basquete += 1;
		}

		if (e.getActionCommand() == "Terminar") {
			if (e.getActionCommand().equalsIgnoreCase("Terminar")) {
				resultado.setVisible(true);
				resultado.getResultados(futebol, volei, basquete);
			}
		}
	}

}
