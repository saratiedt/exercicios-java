package conjuntoDeValores;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JTextField;

public class Acoes {
	ArrayList<Integer> valores = new ArrayList<Integer>();

	void adicionar(int valor) {
		valores.add(valor);

	}

	String verificaMaior() {
		for (int i = 0; i < valores.size(); i++) {
			System.out.println(valores.get(i));
		}
		int valor = 0;
		int maior = 0;

		for (int i = 0; i < valores.size(); i++) {
			if (valores.get(i) > maior) {
				maior = valores.get(i);
			}
		}

		return String.valueOf(maior);
	}

	String verificaMenor() {
		return "menor";
	}

	String verificaMedia() {
		return "media";
	}
}
