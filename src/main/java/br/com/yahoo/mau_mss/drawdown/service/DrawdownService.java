package br.com.yahoo.mau_mss.drawdown.service;

import org.apache.commons.collections4.CollectionUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class DrawdownService {

	public void runDrawdown(String[] args) {
		List<Double> values = convertSerie(Arrays.asList(args));
		double dd = calcMdd(values) * 100;
		System.out.println("Máximo Drawdown: " + dd + "%");
	}

	private List<Double> convertSerie(List<String> serie) {
		if (CollectionUtils.isEmpty(serie)) {
			throw new IllegalArgumentException("Chame o programa seguido de uma série de números separada por vírgula");
		}
		List<Double> result = serie.stream()
				.map(Double::valueOf)
				.collect(Collectors.toList());
		return result;
	}

  /**
   * Calcula o drawdown de uma lista de valores percentuais
   * @param values - A lista de valorizações percentuais alterada no tempo
   * @return - O máximo drawdown
   */
	public double calcMddPerc(List<Double> values) {
		List<Double> decimalValues = new ArrayList<>();
		decimalValues.add(10000.00);
		int i = 0;
		for (double v : values) {
			decimalValues.add(decimalValues.get(i++) * (1 + v / 100));
		}
		return calcMdd(decimalValues);
	}

  /**
   * Calcula o drawdown de uma lista de valores decimais
   * @param values - A lista de valores decimais alterada no tempo
   * @return - O máximo drawdown
   */
	public double calcMdd(List<Double> values) {
		Double maiorAltaAntesMaiorQueda = values.get(0);
		Double maiorQueda = values.get(0);
		Double maiorAlta = values.get(0);
		Double valorAnterior = values.get(0);
		double mdd = 0.0;
		for (Double valorAtual : values) {
			if (isBaixa(valorAtual, valorAnterior) && valorAtual < maiorQueda) {
				maiorQueda = valorAtual;
				maiorAltaAntesMaiorQueda = maiorAlta;
				mdd = Math.abs(maiorAltaAntesMaiorQueda - maiorQueda) / maiorAltaAntesMaiorQueda;
			}
			if (isAlta(valorAtual, valorAnterior) && valorAtual > maiorAlta) {
				maiorAlta = valorAtual;
			}
			valorAnterior = valorAtual;
		}
		return mdd;
	}

	private boolean isBaixa(Double valorAtual, Double valorAnterior) {
		return valorAnterior != null && valorAtual != null && valorAtual < valorAnterior;
	}

	private boolean isAlta(Double valorAtual, Double valorAnterior) {
		return valorAnterior != null && valorAtual != null && valorAtual > valorAnterior;
	}
}
