package numeroPrimo;

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
	JTextField entrada;
	JLabel result;

	public Main() {
		JFrame frame = new JFrame("Verificador de numeros");
		frame.setVisible(true);
		frame.setSize(200, 150);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new FlowLayout());

		JLabel info = new JLabel("Digite um numero:");
		frame.add(info);

		entrada = new JTextField(10);
		frame.add(entrada);

		JButton button = new JButton("Verificar");
		frame.add(button);

		button.addActionListener(this);

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
		Calculo vrNum = new Calculo();

		resultado = vrNum.VerificaPrimo(Integer.parseInt(entrada.getText().trim()));
		result.setText(resultado);

	}

}
