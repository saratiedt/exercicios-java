package anotacoes;

import javax.swing.DefaultListModel;

public class Acoes {
	Anotacao[] anotacoes;
	DefaultListModel listModel;

	public DefaultListModel adicionar(String titulo, String descricao) {
		listModel = new DefaultListModel();
		Anotacao anotacao = new Anotacao(titulo, descricao);

		this.listModel.addElement(anotacao);
		return this.listModel;
	}

	public void remover(String titulo) {
		int id = listModel.indexOf(titulo);
		listModel.remove(id);
	}

}
