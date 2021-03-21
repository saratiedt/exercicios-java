package jogoPedraPapelTesoura;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingUtilities;

public class Main implements ActionListener {

	JRadioButton pedra;
	JRadioButton papel;
	JRadioButton tesoura;
	JButton jogar;
	JButton zerar;
	JLabel usuario;
	JLabel pc;
	JLabel potuacaoUsuario;
	JLabel pontuacaoPc;
	JLabel situacao;
	JPanel esquerda;
	JPanel opcoes;
	JPanel centro;
	JPanel direita;
	JPanel infos;
	JPanel imagemUsuario;
	JPanel imagemComputador;
	int usuarioPontuacao = 0, computadorPontuacao = 0;
	String jogada = "pedra", opcao;

	public Main() {
		JFrame frame = new JFrame("Radio Button");
		frame.setVisible(true);
		frame.setSize(720, 310);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		opcoes = new JPanel(new FlowLayout(FlowLayout.LEFT));

		pedra = new JRadioButton("Pedra");
		pedra.setSelected(true);
		pedra.setActionCommand("Pedra");
		pedra.addActionListener(this);
		opcoes.add(pedra);

		papel = new JRadioButton("Papel");
		papel.setActionCommand("Papel");
		papel.addActionListener(this);
		opcoes.add(papel);

		tesoura = new JRadioButton("Tesoura");
		tesoura.setActionCommand("Tesoura");
		tesoura.addActionListener(this);
		opcoes.add(tesoura);

		ButtonGroup group = new ButtonGroup();
		group.add(pedra);
		group.add(papel);
		group.add(tesoura);

		frame.add(opcoes, BorderLayout.NORTH);

		esquerda = new JPanel(new GridLayout(1, 1));
		imagemUsuario = new JPanel(new FlowLayout(FlowLayout.CENTER));

		usuario = new JLabel(new ImageIcon("img/pedra.jpg"));
		imagemUsuario.add(usuario);

		esquerda.add(imagemUsuario);
		frame.add(esquerda, BorderLayout.WEST);

		centro = new JPanel();
		infos = new JPanel(new GridLayout(5, 1));

		jogar = new JButton("Jogar");
		jogar.addActionListener(this);
		infos.add(jogar);

		situacao = new JLabel("");
		infos.add(situacao);

		potuacaoUsuario = new JLabel("Você: " + usuarioPontuacao);
		infos.add(potuacaoUsuario);

		pontuacaoPc = new JLabel("Computador: " + computadorPontuacao);
		infos.add(pontuacaoPc);

		zerar = new JButton("Zerar");
		zerar.addActionListener(this);
		infos.add(zerar);

		centro.add(infos);
		frame.add(centro, BorderLayout.CENTER);

		direita = new JPanel(new GridLayout(1, 1));
		imagemComputador = new JPanel(new FlowLayout(FlowLayout.CENTER));

		pc = new JLabel(new ImageIcon("img/computador.jpg"));
		imagemComputador.add(pc);

		direita.add(imagemComputador);
		frame.add(direita, BorderLayout.EAST);

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
		String Opcao[] = { "pedra", "papel", "tesoura" };
		Random random = new Random();

		String str = e.getActionCommand().toString();

		if (str.equalsIgnoreCase("pedra") || str.equalsIgnoreCase("papel") || str.equalsIgnoreCase("tesoura")) {
			jogada = str;
		}

		usuario.setIcon(new ImageIcon("img/" + jogada.toLowerCase() + ".jpg"));

		if (e.getActionCommand().equalsIgnoreCase("Jogar")) {

			opcao = Opcao[random.nextInt(Opcao.length)];
			pc.setIcon(new ImageIcon("img/" + opcao + "2.jpg"));

			if (opcao.equals(jogada.toLowerCase())) {
				situacao.setText("Empate");
			} else if (jogada.equals("Pedra")) {
				if (opcao.equals("tesoura")) {
					situacao.setText("Você ganhou! =)");
					usuarioPontuacao += 1;
				} else if (opcao.equals("papel")) {
					situacao.setText("Você perdeu! =(");
					computadorPontuacao += 1;
				}
			} else if (jogada.equals("Papel")) {
				if (opcao.equals("tesoura")) {
					situacao.setText("Você perdeu! =(");
					computadorPontuacao += 1;
				} else if (opcao.equals("pedra")) {
					situacao.setText("Você ganhou! =)");
					usuarioPontuacao += 1;
				}
			} else if (jogada.equals("Tesoura")) {
				if (opcao.equals("papel")) {
					situacao.setText("Você ganhou! =)");
					usuarioPontuacao += 1;
				} else if (opcao.equals("pedra")) {
					situacao.setText("Você perdeu! =(");
					computadorPontuacao += 1;
				}
			}

		} else if (e.getActionCommand().equalsIgnoreCase("Zerar")) {
			situacao.setText("");
			pc.setIcon(new ImageIcon("img/computador.jpg"));
			usuario.setIcon(new ImageIcon("img/pedra.jpg"));
			computadorPontuacao = 0;
			usuarioPontuacao = 0;
		}

		potuacaoUsuario.setText("Você: " + usuarioPontuacao);
		pontuacaoPc.setText("Computador: " + computadorPontuacao);

	}

}
