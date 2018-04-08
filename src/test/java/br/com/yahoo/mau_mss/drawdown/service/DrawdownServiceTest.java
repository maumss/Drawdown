package br.com.yahoo.mau_mss.drawdown.service;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@RunWith(Parameterized.class)
public class DrawdownServiceTest {
	private String valores;
	private String drawdown;

	public DrawdownServiceTest(String valores, String drawdown) {
		this.valores = valores;
		this.drawdown = drawdown;
	}

	@BeforeClass
	public static void setUpClass() {
	}

	@AfterClass
	public static void tearDownClass() {
	}

	@Before
	public void setUp() {
	}

	@After
	public void tearDown() {
	}

	@Parameterized.Parameters
	public static Collection<String[]> addedPassword() {
		return Arrays.asList(new String[][] {
				{ "500., 750., 400., 600., 350., 800.", "0.5333" },
				{ "500.", "0.0" },
				{ "100., 100.", "0.0" },
				{ "10000., 10530., 10536., 10563.39", "0.0"}
		});

	}

	@Test
	public void calcMddTest() {
		System.out.println("calcMdd");
		DrawdownService instance = new DrawdownService();
		double expectResult = Double.valueOf(this.drawdown);
		List<String> valoresStr = Arrays.asList(this.valores.split(","));
		List<Double> valoresDbl = valoresStr.stream()
				.map(Double::valueOf)
				.collect(Collectors.toList());
		double result = instance.calcMdd(valoresDbl);
		System.out.println("O valor MDD é " + result + " e era experado " + expectResult);
		Assert.assertEquals(expectResult, result, 0.0001);
	}
}