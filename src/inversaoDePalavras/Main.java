package inversaoDePalavras;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class Main implements ActionListener {
	private String resultado;
	JLabel result;
	JButton botton;
	JTextField entrada;

	public Main() {
		JFrame frame = new JFrame("Inverter");
		frame.setVisible(true);
		frame.setSize(200, 200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new FlowLayout());

		JLabel info = new JLabel("Digite um texto:");
		frame.add(info);

		entrada = new JTextField(10);
		frame.add(entrada);

		botton = new JButton("Inverter");
		botton.addActionListener(this);
		frame.add(botton);

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
		resultado = entrada.getText().trim();

		Inverte inv = new Inverte();

		result.setText(inv.Inverter(resultado));

	}

}
