package tipoDoTrianguloRefatorado;

public class Calculo {
	public String DefineTriangulo(int l1, int l2, int l3) {
		if (l1 + l2 < l3 || l1 + l3 < l2 || l3 + l2 < l1)
			return "Triagulo não valido";

		else if (l1 == l2 && l3 == l1 && l3 == l2)
			return "Triagulo Equilátero";

		else if (l1 == l2 || l3 == l1 || l3 == l2)
			return "Triangulo isóscels";

		return "Triangulo escaleno";
	}
}
