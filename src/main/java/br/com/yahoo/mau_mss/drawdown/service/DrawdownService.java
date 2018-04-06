package br.com.yahoo.mau_mss.drawdown.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.math.NumberUtils;

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
