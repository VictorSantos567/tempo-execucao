package tempo;

import java.util.Locale;
import java.util.Scanner;

public class MediaTempo {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		double[] valor = new double[10];
		Scanner sc = new Scanner(System.in);
		double soma = 0;
		double media = 0;

		for (int i = 0; i < 10; i++) {
			System.out.println("Preencha com o tempo: ");
			valor[i] = sc.nextDouble();
			soma = soma + valor[i];
		}

		for (int i = 0; i < 10; i++) {
			System.out.println("Os valores são " + (i+1) + ": " + valor[i]);
		}
		System.out.println("");
		media = soma / 10;
		System.out.println("A media de tempo eh: " + media);

		sc.close();
	}

}
