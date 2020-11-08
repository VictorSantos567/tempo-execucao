package ordenacao;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Random;

/**
 * @author victo - Quicksort ou mergesort - à sua escolha Crescentemente, crie
 *         vetores com 100, 1.000, 10.000... elementos, até o momento em que um
 *         dos algoritmos gastar mais do que 10 segundos para ordená-lo.
 *         Procure, para cada caso, executar algumas vezes e fazer a média do
 *         tempo gasto. Compare os resultados em relação à complexidade teórica
 *         dos algoritmos.
 * 
 *         Complexidade de nlogn
 */
public class MergeSort {

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

	private static void mergeSort(int[] v, int[] w, int inicio, int fim) {
		if (inicio < fim) {
			int meio = (inicio + fim) / 2;
			mergeSort(v, w, inicio, meio);
			mergeSort(v, w, meio + 1, fim);
			merge(v, w, inicio, meio, fim);
		}

	}

	private static void merge(int[] v, int[] w, int inicio, int meio, int fim) {
		for (int k = inicio; k <= fim; k++) {
			w[k] = v[k];
		}

		int i = inicio;
		int j = meio + 1;

		for (int k = inicio; k <= fim; k++) {
			if (i > meio) {
				v[k] = w[j++];
			} else if (j > fim) {
				v[k] = w[i++];
			} else if (w[i] < w[j]) {
				v[k] = w[i++];
			} else {
				v[k] = w[j++];
			}
		}

	}

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		long inicio = 0, fim = 0;
		double tempo = 0;
		int[] v = preencher(100000000);
		int[] w = new int[v.length];
		int num = 0;
		ArrayList<Double> listTemp = new ArrayList<>();
		
		for (int i = 0; i < 15; i++) {
			System.out.println(" ");
			inicio = System.nanoTime();
			mergeSort(v, w, 0, v.length - 1);
			fim = System.nanoTime();
			// Arrays.toString(v);
			tempo = (fim - inicio) / 1_000_000_000d;
			System.out.println("Tempo total: " + tempo);
			num++;
			System.out.println("Quantidade eh: " + num);
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
