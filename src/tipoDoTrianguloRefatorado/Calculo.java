package tipoDoTrianguloRefatorado;

public class Calculo {
	public String DefineTriangulo(int l1, int l2, int l3) {
		if (l1 + l2 < l3 || l1 + l3 < l2 || l3 + l2 < l1)
			return "Triagulo n�o valido";

		else if (l1 == l2 && l3 == l1 && l3 == l2)
			return "Triagulo Equil�tero";

		else if (l1 == l2 || l3 == l1 || l3 == l2)
			return "Triangulo is�scels";

		return "Triangulo escaleno";
	}
}
