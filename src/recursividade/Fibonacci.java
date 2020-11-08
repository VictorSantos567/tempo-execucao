package recursividade;

import java.util.Locale;

public class Fibonacci {

	// Escreva um m�todo recursivo que retorne o n-�simo elemento da s�rie de
	// Fibonacci. Para o teste, comece pelo 3� elemento e progrida sequencialmente,
	// de um em um, at� o momento em que o algoritmo gastar mais do que 30 segundos
	// para resolver o problema. Procure, para cada caso, executar algumas vezes e
	// fazer a m�dia do tempo gasto. Busque relacionar os resultados encontrados com
	// a poss�vel complexidade te�rica do algoritmo.

	static int fibonacci(int n) {
		if (n == 1 || n == 2) {
			return 1;
		} else
			return fibonacci(n - 1) + fibonacci(n - 2);
	}

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		long inicio = 0, fim = 0;
		double tempo = 0;
		int n = 3;
		int num = 0;

		while (tempo < 30) {
			System.out.println("");
			inicio = System.nanoTime();
			fibonacci(n);
			fim = System.nanoTime();
			tempo = (fim - inicio) / 1_000_000_000d;
			n++;
			num++;
			System.out.println("O numero eh: " + num);
			System.out.println("Tempo total: " + tempo);
		}

	}

}
