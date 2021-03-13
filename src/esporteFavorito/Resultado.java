package esporteFavorito;

import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Resultado extends JFrame {

	JLabel label;
	JTextField maisVotado;
	JTextField votos;
	JLabel lebelImagem;

	ImageIcon imagemFutebol = new ImageIcon("img/futebol.png");
	ImageIcon imagemVolei = new ImageIcon("img/volei.png");
	ImageIcon imagemBasquete = new ImageIcon("img/basquete.png");

	public Resultado() {
		setTitle("Resultado");
		setSize(300, 250);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new FlowLayout());

		label = new JLabel("Mais Votado: ");
		add(label);

		maisVotado = new JTextField("");
		add(maisVotado);

		label = new JLabel("Qtd. de Votos: ");
		add(label);

		votos = new JTextField("");
		add(votos);

		lebelImagem = new JLabel("");
		add(lebelImagem);
	}

	void getResultados(int futebol, int volei, int basquete) {
		if (futebol > volei && futebol > basquete) {
			maisVotado.setText("Futebol");
			votos.setText(String.valueOf(futebol));
			lebelImagem.setIcon(imagemFutebol);
		} else if (volei > futebol && volei > basquete) {
			maisVotado.setText("Volei");
			votos.setText(String.valueOf(volei));
			lebelImagem.setIcon(imagemVolei);
		} else if (basquete > futebol && basquete > volei) {
			maisVotado.setText("Basquete");
			votos.setText(String.valueOf(basquete));
			lebelImagem.setIcon(imagemBasquete);
		}
	}
}
