package conjuntoDeValores;

import java.io.Console;
import java.util.ArrayList;
import java.util.List;

public class Acoes {
	int valor = 0;
	int maior = 0;
	int menor = 0;
	int media = 0;

	ArrayList<Integer> valores = new ArrayList<Integer>();

	void adicionar(int valor) {
		this.valores.add(valor);
		System.out.println(valores);
	}

	String verificaMaior() {

		for (int i = 0; i < valores.size(); i++) {
			if (valores.get(i) > maior) {
				menor = maior;
				maior = valores.get(i);

			}

		}

		return String.valueOf(maior);
	}

	String verificaMenor() {

		for (int i = 0; i < valores.size(); i++) {
			if (valores.get(i) < menor) {
				menor = valores.get(i);

			}

		}

		return String.valueOf(menor);
	}

	String verificaMedia() {
		int total = 0;
		int calMedia = 0;
		for (int i = 0; i < valores.size(); i++) {
			total += valores.get(i);
			System.out.println(total);

		}
		System.out.println(valores.size());
		calMedia = total / valores.size();

		return String.valueOf(calMedia);
	}
}
