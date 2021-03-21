package anotacoes;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class Main implements ListSelectionListener, ActionListener {
	JLabel label = new JLabel();
	JLabel label2 = new JLabel();
	JTextField titulo = new JTextField(35);
	JTextArea descricao = new JTextArea();
	JPanel panel = new JPanel(new BorderLayout());
	JButton adiconar = new JButton("Adicionar");
	JButton remover = new JButton("Remover");
	Anotacao anotacao = new Anotacao("titulo", "descricao");
	Anotacao[] anotacoes = { anotacao };
	DefaultListModel<Anotacao> listModel;
	JList<Anotacao> lista;

	public Main() {
		JPanel grid = new JPanel(new GridLayout(0, 1));
		listModel = new DefaultListModel<Anotacao>();
		listModel.addElement(new Anotacao("titulo de exemplo", "descrição de exemplo"));

		lista = new JList<Anotacao>(listModel);

		JFrame frame = new JFrame("Anotações");
		frame.setVisible(true);
		frame.setSize(400, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		lista.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		frame.add(lista, BorderLayout.WEST);

		label = new JLabel("Titulo");

		JPanel esquerda = new JPanel(new FlowLayout(FlowLayout.LEFT));
		esquerda.add(label);

		grid.add(esquerda);

		esquerda = new JPanel(new FlowLayout(FlowLayout.LEFT));
		esquerda.add(titulo);

		grid.add(esquerda);

		panel.add(grid, BorderLayout.NORTH);

		JScrollPane scrol = new JScrollPane(descricao);

		label2 = new JLabel("Descricao");
		grid.add(label2);

		panel.add(scrol, BorderLayout.CENTER);

		esquerda = new JPanel(new FlowLayout(FlowLayout.CENTER));
		esquerda.add(adiconar);
		esquerda.add(remover);

		panel.add(esquerda, BorderLayout.SOUTH);

		adiconar.addActionListener(this);
		remover.addActionListener(this);

		lista.addListSelectionListener(this);
		frame.add(panel, BorderLayout.CENTER);

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
	public void valueChanged(ListSelectionEvent e) {
		if (lista.getSelectedIndex() != -1) {
			lista.getSelectedValue();
			titulo.setText(lista.getSelectedValue().getTitulo());
			descricao.setText(lista.getSelectedValue().getDescricao());
		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equalsIgnoreCase("Adicionar")) {

			if (lista.getSelectedIndex() != -1) {
				listModel.set(lista.getSelectedIndex(), new Anotacao(titulo.getText(), descricao.getText()));
				lista.clearSelection();
				titulo.setText("");
				descricao.setText("");
			} else {
				listModel.addElement(new Anotacao(titulo.getText(), descricao.getText()));
				lista.clearSelection();
				titulo.setText("");
				descricao.setText("");
			}

		} else if (e.getActionCommand().equalsIgnoreCase("Remover")) {

			if (lista.getSelectedIndex() != -1) {
				listModel.removeElementAt(lista.getSelectedIndex());
				lista.clearSelection();
				titulo.setText("");
				descricao.setText("");
			}

		}

	}

}
