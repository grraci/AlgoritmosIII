package controller;

import model.SpreadsheetModel;
import view.Spreadsheet;

public class CalcMachine {

	public static void main(String[] args) {
		(new CalcMachine()).run();
	}

	private void run() {
		SpreadsheetModel m = new SpreadsheetModel() {
			@Override
			public void setFormula(String cell, String formula) {
				System.out.println(cell + " : " + formula);
			}
			
			@Override
			public String getValue(String cell) {
				return String.format("%06g", Math.random()*100 - 50);
			}

			@Override
			public String getFormula(String cell) {
				return "Celula: " + cell;
			}
		};
		
		(new Spreadsheet(m)).start();
	}
}
