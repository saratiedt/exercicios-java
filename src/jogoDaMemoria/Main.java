package jogoDaMemoria;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

public class Main implements ActionListener {
	ImageIcon verso = new ImageIcon("img/atras.png");
	ImageIcon az = new ImageIcon("img/Az.png");
	ImageIcon copas = new ImageIcon("img/copas.png");
	ImageIcon ouro = new ImageIcon("img/ouro.png");
	ImageIcon paus = new ImageIcon("img/paus.png");

	JButton botaoAz1;
	JButton botaoAz2;
	JButton botaoCopas1;
	JButton botaoCopas2;
	JButton botaoOuro1;
	JButton botaoOuro2;
	JButton botaoPaus1;
	JButton botaoPaus2;
	String carta = "";
	JButton botao;
	int numeroPares = 0;

	JFrame frame = new JFrame("");

	public Main() {
		JFrame frame = new JFrame("");
		frame.setVisible(true);
		frame.setSize(400, 800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new FlowLayout());

		botaoCopas1 = new JButton(verso);
		botaoCopas1.addActionListener(this);
		frame.add(botaoCopas1);

		botaoPaus1 = new JButton(verso);
		botaoPaus1.addActionListener(this);
		frame.add(botaoPaus1);

		botaoCopas2 = new JButton(verso);
		botaoCopas2.addActionListener(this);
		frame.add(botaoCopas2);

		botaoAz1 = new JButton(verso);
		botaoAz1.addActionListener(this);
		frame.add(botaoAz1);

		botaoOuro1 = new JButton(verso);
		botaoOuro1.addActionListener(this);
		frame.add(botaoOuro1);

		botaoPaus2 = new JButton(verso);
		botaoPaus2.addActionListener(this);
		frame.add(botaoPaus2);

		botaoAz2 = new JButton(verso);
		botaoAz2.addActionListener(this);
		frame.add(botaoAz2);

		botaoOuro2 = new JButton(verso);
		botaoOuro2.addActionListener(this);
		frame.add(botaoOuro2);
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
		if (carta == "") {
			if (e.getSource() == botaoCopas1) {
				botao = botaoCopas1;
				carta = "copas1";
				botaoCopas1.setIcon(copas);
			} else if (e.getSource() == botaoCopas2) {
				botao = botaoCopas2;
				carta = "copas2";
				botaoCopas2.setIcon(copas);
			}

			else if (e.getSource() == botaoPaus1) {
				botao = botaoPaus1;
				carta = "paus1";
				botaoPaus1.setIcon(paus);
			} else if (e.getSource() == botaoPaus2) {
				botao = botaoPaus2;
				carta = "paus2";
				botaoPaus2.setIcon(paus);
			}

			else if (e.getSource() == botaoOuro1) {
				botao = botaoOuro1;
				carta = "ouro1";
				botaoOuro1.setIcon(ouro);
			} else if (e.getSource() == botaoOuro2) {
				botao = botaoOuro2;
				carta = "ouro2";
				botaoOuro2.setIcon(ouro);
			}

			else if (e.getSource() == botaoAz1) {
				botao = botaoAz1;
				carta = "az1";
				botaoAz1.setIcon(az);
			} else if (e.getSource() == botaoAz2) {
				botao = botaoAz2;
				carta = "az2";
				botaoAz2.setIcon(az);
			}
		} else {
			if (e.getSource() == botaoCopas1 && carta == "copas2") {
				botaoCopas1.setIcon(copas);
				numeroPares++;
			} else if (e.getSource() == botaoCopas2 && carta == "copas1") {
				botaoCopas2.setIcon(copas);
				numeroPares++;
			}

			else if (e.getSource() == botaoPaus1 && carta == "paus2") {
				botaoPaus1.setIcon(paus);
				numeroPares++;
			} else if (e.getSource() == botaoPaus2 && carta == "paus1") {
				botaoPaus2.setIcon(paus);
				numeroPares++;
			}

			else if (e.getSource() == botaoOuro1 && carta == "ouro2") {
				botaoOuro1.setIcon(ouro);
				numeroPares++;
			} else if (e.getSource() == botaoOuro2 && carta == "ouro1") {
				botaoOuro2.setIcon(ouro);
				numeroPares++;
			}

			else if (e.getSource() == botaoAz1 && carta == "az2") {
				botaoAz1.setIcon(az);
				numeroPares++;
			} else if (e.getSource() == botaoAz2 && carta == "az1") {
				botaoAz2.setIcon(az);
				numeroPares++;
			} else {
				botao.setIcon(verso);
			}

			if (numeroPares == 4) {
				JOptionPane.showMessageDialog(frame, "Voce venceu!");
			}

			carta = "";
			botao = null;
		}
	}

}
