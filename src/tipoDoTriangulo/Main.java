package tipoDoTriangulo;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class Main implements ActionListener {

	private String resultado;
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
		JFrame frame = new JFrame("Inverter :p");
		frame.setVisible(true);
		frame.setSize(200, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new FlowLayout());

		JLabel lado1 = new JLabel("Lado 1");
		frame.add(lado1);

		num1 = new JTextField(10);
		frame.add(num1);

		JLabel lado2 = new JLabel("Lado 2");
		frame.add(lado2);

		num2 = new JTextField(10);
		frame.add(num2);

		JLabel lado3 = new JLabel("Lado 3");
		frame.add(lado3);

		num3 = new JTextField(10);
		frame.add(num3);

		botton = new JButton("Verificar");
		botton.addActionListener(this);
		frame.add(botton);

		botton = new JButton("Limpar");
		botton.addActionListener(this);
		frame.add(botton);

		result = new JLabel(resultado);
		frame.add(result);

		lebelImagem = new JLabel(imgDefoult);
		frame.add(lebelImagem);
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
				result.setText("Digite todos os valores!");
				lebelImagem.setIcon(imgErro);
			} else {
				Calculo calculo = new Calculo();

				String retorno = calculo.DefineTriangulo(Integer.parseInt(num1.getText().trim()),
						Integer.parseInt(num2.getText().trim()), Integer.parseInt(num3.getText().trim()));
				result.setText(retorno);

				System.out.println(result.toString());
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
