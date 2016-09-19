package estruturas;


import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Locale;
import java.util.Scanner;

/**
 * Esta classe implementa um avaliador de expressaes aritmeticas
 * baseada em pilhas.
 */
public class ExpressionEvaluator {
	
	private static String toPostfix(String expression) {
		Scanner sc = new Scanner(expression);
		sc.useLocale(Locale.US);
		String out = "";
		
		Deque<String> opStack = new ArrayDeque<String>();
		
		while (sc.hasNext()) {
			if (sc.hasNextDouble()) {
				out += " " + sc.nextDouble();
			} else {
				String op = sc.next();
				switch (op) {
					case ")":
						while (!opStack.peek().equals("("))
							out += " " + opStack.pop();
						opStack.pop();
						break;
					case "(":
						opStack.push(op);
						break;
					case "*":
					case "/":
						if ("*/".contains(opStack.peek())) {
							out += " " + opStack.pop();
						}
						opStack.push(op);
						break;
					case "+":
					case "-":
						while(!opStack.isEmpty() && !opStack.peek().equals("("))
						{
							out += " " + opStack.pop();
						}
						opStack.push(op);
						break;
					default:
						break;
				}
			}
		}
		while (!opStack.isEmpty())
			out += " " + opStack.pop();

		sc.close();
		return out;
	}
	
	/**
	 * Calcula o valor de uma expressão aritmetica.
	 * A expressao pode utilizar ponto flutuante, no entanto,
	 * o separador decimal deve ser o "ponto" (ex.: 3.141516).
	 * @param exp A expressao a ser avaliada.
	 * @return O resultado da expressao.
	 */
	public static double compute(String exp) {
		
		if(exp != null) {
			String rep =
					exp.substring(0,1)+
					exp.substring(1).replaceAll("([\\*\\+\\-\\/\\(\\)])", " $1 ");
			String expression = toPostfix(rep);
			Scanner sc = new Scanner(expression);
			sc.useLocale(Locale.US);
			Deque<Double> operands = new ArrayDeque<Double>();
			while (sc.hasNext()) {
				if (sc.hasNextDouble()) {
					operands.push(sc.nextDouble());
				} else {
					double rhs = operands.pop();
					double lhs = operands.pop();
					switch (sc.next()) {
					case "*":
						operands.push(lhs * rhs);
						break;
					case "/":
						operands.push(lhs / rhs);
						break;
					case "-":
						operands.push(lhs - rhs);
						break;
					case "+":
						operands.push(lhs + rhs);
						break;
					}
				}
			}
			sc.close();
			return operands.pop();
		} else {
			return 0.0;
		}
	}
	
}