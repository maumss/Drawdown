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
public class DrawdownService2Test {
  private String valores;
  private String drawdown;

  public DrawdownService2Test(String valores, String drawdown) {
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
        { "5.30, 0.06, 0.26", "0.0" },
        { "5.30, -6.06, 0.26", "0.0606" }
    });

  }

  @Test
  public void calcMddTest() {
    System.out.println("calcMddPerc");
    DrawdownService instance = new DrawdownService();
    double expectResult = Double.valueOf(this.drawdown);
    List<String> valoresStr = Arrays.asList(this.valores.split(","));
    List<Double> valoresDbl = valoresStr.stream()
        .map(Double::valueOf)
        .collect(Collectors.toList());
    double result = instance.calcMddPerc(valoresDbl);
    System.out.println("O valor MDD é " + result + " e era experado " + expectResult);
    Assert.assertEquals(expectResult, result, 0.0001);
  }
}