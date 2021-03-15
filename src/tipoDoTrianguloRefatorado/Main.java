package tipoDoTrianguloRefatorado;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class Main implements ActionListener {

	JLabel result;
	JButton botton;
	JTextField num1;
	JTextField num2;
	JTextField num3;
	JLabel lebelImagem;

	ImageIcon imgDefoult = new ImageIcon("img/tri.jpg");
	ImageIcon imgErro = new ImageIcon("img/erro.png");
	ImageIcon imgEquilatero = new ImageIcon("img/tri-equilatero.jpg");
	ImageIcon imgEscaleno = new ImageIcon("img/tri-escaleno.jpg");
	ImageIcon imgIsoceles = new ImageIcon("img/tri-isoceles.jpg");

	public Main() {
		JFrame frame = new JFrame("Inverter");
		frame.setVisible(true);
		frame.setSize(400, 250);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel panel = new JPanel();
		JPanel panel1 = new JPanel(new GridLayout(5, 1));
		
		JLabel info = new JLabel("Insira os lados");
		panel1.add(info);
		
		num1 = new JTextField(10);
		panel1.add(num1);
		
		num2 = new JTextField(10);
		panel1.add(num2);
		
		num3 = new JTextField(10);
		panel1.add(num3);
		
		botton = new JButton("Verificar");
		botton.addActionListener(this);
		panel1.add(botton);
		
		panel.add(panel1);
		frame.add(panel);

		JPanel panel2 = new JPanel();
		
		lebelImagem = new JLabel(imgDefoult);
		panel2.add(lebelImagem);
		
		frame.add(panel2,  BorderLayout.EAST);
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
		if (e.getActionCommand() == "Verificar") {
			if (num1.getText().isEmpty() || num2.getText().isEmpty() || num3.getText().isEmpty()) {
				lebelImagem.setIcon(imgErro);
			} else {
				Calculo calculo = new Calculo();

				String retorno = calculo.DefineTriangulo(Integer.parseInt(num1.getText().trim()),
						Integer.parseInt(num2.getText().trim()), Integer.parseInt(num3.getText().trim()));

				if (retorno == "Triagulo Equilátero")
					lebelImagem.setIcon(imgEquilatero);

				else if (retorno == "Triangulo isóscels")
					lebelImagem.setIcon(imgIsoceles);

				else if (retorno == "Triangulo escaleno")
					lebelImagem.setIcon(imgEscaleno);
				else
					lebelImagem.setIcon(imgErro);
			}
		} else {
			num1.setText("");
			num2.setText("");
			num3.setText("");
			lebelImagem.setIcon(imgDefoult);
		}

	}

}
