package calculoImc;

public class CalculoImc {
	double imc = 0;

	public double calcular(double altura, double peso) {
		imc = peso / (altura * altura);
		return imc;
	}

}
