package br.com.yahoo.mau_mss.drawdown;

import br.com.yahoo.mau_mss.drawdown.service.DrawdownService;

public class Drawdown {

	public static void main(String[] args) {
		DrawdownService drawdown = new DrawdownService();
		drawdown.runDrawdown(args);
	}
}
