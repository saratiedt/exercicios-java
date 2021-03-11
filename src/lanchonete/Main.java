package lanchonete;

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
	int valor = 0;

	JCheckBox opcao1;
	JCheckBox opcao2;
	JCheckBox opcao3;
	JCheckBox opcao4;
	JCheckBox opcao5;

	public Main() {

		frame.setVisible(true);
		frame.setSize(150, 320);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new FlowLayout());

		JLabel info = new JLabel("Itens Selecionados:");
		frame.add(info);

		opcao1 = new JCheckBox("Opção1");
		frame.add(opcao1);

		opcao2 = new JCheckBox("Opção2");
		frame.add(opcao2);

		opcao3 = new JCheckBox("Opção3");
		frame.add(opcao3);

		opcao4 = new JCheckBox("Opção4");
		frame.add(opcao4);

		opcao5 = new JCheckBox("Opção5");
		frame.add(opcao5);

		btnAdd = new JButton("Adicionar");
		btnAdd.addActionListener(this);
		frame.add(btnAdd);

		JLabel txtValor = new JLabel("Valor total:");
		frame.add(txtValor);

		result = new JTextField(10);
		frame.add(result);

		btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(this);
		frame.add(btnLimpar);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand() == "Adicionar") {
			if (opcao1.isSelected())
				valor += 1;

			if (opcao2.isSelected())
				valor += 2;

			if (opcao3.isSelected())
				valor += 3;

			if (opcao4.isSelected())
				valor += 4;

			if (opcao5.isSelected())
				valor += 5;

			result.setText("" + valor);
		}

		if (e.getActionCommand() == "Limpar") {
			valor = 0;
			result.setText("" + valor);
		}
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new Main();
			}
		});
	}
}