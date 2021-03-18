package anotacoes;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class Main implements ListSelectionListener, ActionListener {
	Acoes acoes = new Acoes();
	JLabel label = new JLabel();
	JTextField titulo = new JTextField();
	JTextArea descricao = new JTextArea();
	JPanel panel = new JPanel();
	JButton adiconar = new JButton("Adicionar");
	JButton remover = new JButton("Remover");
	Anotacao anotacao = new Anotacao("titulo", "descricao");
	Anotacao[] anotacoes = { anotacao };
	DefaultListModel listModel;
	JList lista;

	public Main() {
		listModel = new DefaultListModel();
		panel.setLayout(new GridLayout(6, 2, 5, 5));

		System.out.println(anotacao);

		lista = new JList(listModel);

		JFrame frame = new JFrame("Anotações");
		frame.setVisible(true);
		frame.setSize(400, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		lista.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		lista.setPreferredSize(new Dimension(150, 300));

		label = new JLabel("Titulo");

		panel.add(lista);
		panel.add(label);
		panel.add(label);
		panel.add(titulo);
		panel.add(descricao);
		frame.add(panel);
		panel.add(adiconar);
		panel.add(remover);
		
		adiconar.addActionListener(this);

		lista.addListSelectionListener(this);

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
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand() == "Adicionar") {
			listModel = acoes.adicionar(titulo.getText().trim(), descricao.getText().trim());
			for (int i = 0; i < lista.getModel().getSize(); i++) {
				System.out.println(lista.getModel().getElementAt(i));
			}
			
		} else if (e.getActionCommand().equals("Remover")) {
			acoes.remover(titulo.getText().trim());
		}

	}

}
