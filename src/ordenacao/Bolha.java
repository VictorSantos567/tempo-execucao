package ordenacao;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Random;

/**
 * @author victo - Cenário I: ordenação de um vetor de inteiros aleatórios -
 *         Bolha (bubblesort) - Crescentemente, crie vetores com 100, 1.000,
 *         10.000... * elementos, até o momento em que um dos algoritmos gastar
 *         mais do que 10 segundos para ordená-lo. Procure, para cada caso,
 *         executar algumas vezes e fazer a média do tempo gasto. Compare os
 *         resultados em relação à complexidade teórica dos algoritmos.
 * 
 *         Complexidade de O(n^2) - algoritmo quadratico
 */
public class Bolha {

	static Random sorteio = new Random(42);

	public static int[] preencher(int n) {
		int[] arr = new int[n];
		int ini = 1;
		int result = 0;
		int result1 = 0;
		int aux = 0;

		for (int i = 0; i < arr.length; i++) {
			arr[i] = ini;
			ini += sorteio.nextInt(10) + 1;
		}

		for (int i = 0; i < arr.length * 5; i++) {
			result = sorteio.nextInt(arr.length - 1);
			result1 = sorteio.nextInt(arr.length - 1);
			aux = arr[result];
			arr[result] = arr[result1];
			arr[result1] = aux;
		}

		return arr;
	}

	public static void bolha(int[] v) {
		for (int ultimo = v.length - 1; ultimo > 0; ultimo--) {
			for (int i = 0; i < ultimo; i++) {
				if (v[i] > v[i + 1]) {
					trocar(v, i, i + 1);
				}
			}
		}
	}

	public static void trocar(int[] v, int i, int j) {
		int aux = v[i];
		v[i] = v[j];
		v[j] = aux;

	}

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		long inicio = 0, fim = 0;
		double tempo = 0;
		int[] v = preencher(200000);
		int num = 0;

		ArrayList<Double> listTemp = new ArrayList<>();

		for (int i = 0; i < 15; i++) {
			System.out.println("");
			inicio = System.nanoTime();
			bolha(v);
			fim = System.nanoTime();
			tempo = (fim - inicio) / 1_000_000_000d;
			// System.out.println(Arrays.toString(v));
			System.out.println("Tempo total: " + tempo);
			num++;
			System.out.println("O numero eh: " + num);
			listTemp.add(tempo);

		}

		double total = 0;

		for (double temp : listTemp) {
			total += temp;
		}
		
		System.out.println("");
		System.out.println(total / 15);

	}

}
