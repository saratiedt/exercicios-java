package calculadora;

public class Calculadora {
	public String Somar(int n1, int n2) {
		return "Resultado: " + n1 + " + " + n2 + " = " + (n1 + n2);
	}

	public String Multiplicar(int n1, int n2) {
		return "Resultado: " + n1 + " * " + n2 + " = " + (n1 * n2);
	}

	public String Subtrair(int n1, int n2) {
		return "Resultado: " + n1 + " - " + n2 + " = " + (n1 - n2);
	}

	public String Dividir(int n1, int n2) {
		if (n2 == 0)
			return "Nao e possivel dividir por zero";

		return "Resultado: " + n1 + " / " + n2 + " = " + (n1 / n2);
	}
}