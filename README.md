# Drawdown

Command line Java application to calculates the maximum `drawdown`.

## Feature

A drawdown is the peak-to-trough decline during a specific recorded period of an investment, fund or commodity. A drawdown is usually quoted as the percentage between the peak and the subsequent trough. Those tracking the entity measure from the time a retrenchment begins to when it reaches a new high.

Drawdowns present a significant risk to investors when considering the [uptick](https://www.investopedia.com/terms/u/uptick.asp) in share price needed to overcome a drawdown. For example, it may not seem like much if a stock loses 1%, as it only needs an increase of 1.01% to recover to its previously held position. However, a drawdown of 20% requires a 25% return, while a 50% drawdown – seen during the 2008 to 2009 Great [Recession](https://www.investopedia.com/terms/r/recession.asp) – requires a whopping 100% increase to recover the same position. Most investors want to avoid drawdowns of 20% or greater before cutting their losses and turning a position into [cash investments](https://www.investopedia.com/terms/c/cashinvestment.asp).

A stock’s total volatility is measured by its standard deviation, yet many investors, especially retirees who are withdrawing funds from pensions and retirement accounts, are concerned about drawdowns. During volatile markets, and markets that have a possibility of a correction, drawdown is a serious concern for retirees. Many are starting to look at the drawdown of their investments, from stocks to mutual funds, and considering their possible [maximum drawdown (MDD)](https://www.investopedia.com/terms/m/maximum-drawdown-mdd.asp) potential. 

This application read comma separate values and calculates its maximum drawdown.

## Install

Create a install with `batch file`:

```shell
@echo off

set "JAVA_EXEC=javaw"
set "JAVA_OPTS= -Xms1024m -Xmx1024m"

START "Drawdown" /B %JAVA_EXEC% %JAVA_OPTS% -cp "lib\*;" br.com.yahoo.mau_mss.drawdown.Drawdown >> logs\stdout.log 2>&1
```

##Usage

Call the main programa with the values

- Digit the numbers of the serie

## Credits
[Mauricio Soares da Silva](mailto:maumss.git@gmail.com).

## License

[GNU General Public License (GPL) v3](http://www.gnu.org/licenses/)

Copyright &copy; 2018 Mauricio Soares da Silva

This program is free software: you can redistribute it and/or modify it under the terms of the GNU General Public License as published by the Free Software Foundation, either version 3 of the License, or (at your option) any later version.

This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License for more details.

You should have received a copy of the GNU General Public License along with this program.  If not, see <http://www.gnu.org/licenses/>.
