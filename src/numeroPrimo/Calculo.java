package numeroPrimo;

public class Calculo {

	public String VerificaPrimo(int numero) {
		for (int i = 2; i < numero; i++) {
			if (numero % i == 0)
				return "O numero " + numero + " nao e primo!";

		}

		return "O numero " + numero + " e primo!";
	}
}
