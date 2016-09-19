package algoritmos;

import estruturas.PilhaCheia;
import estruturas.PilhaOperador;
import estruturas.PilhaString;
import estruturas.PilhaVazia;


import java.util.*;

public class InfixPosFixConverter {

	public static final int SOMAR = 1;
	public static final int SUBTRAIR = 2;
	public static final int MULTIPLICAR = 3;
	public static final int DIVIDIR = 4;
	public static final int PARENTESES = 5;

	public String saida = "";

	public boolean hh = true; 
	
	public String toPeek(String exp) throws PilhaCheia, PilhaVazia {

		PilhaString pilha = new PilhaString(50);

		Scanner sc = new Scanner(exp);

		while (sc.hasNext()) {
			if (sc.hasNextInt()) {
				saida +=" "+Integer.parseInt(sc.next());
			}
			else {	
				String expressao = sc.next();
				if (expressao.equals("(")){  
					pilha.push(expressao);    
				}  
				else if (expressao.equals(")")) {
					while (!pilha.isEmpty() && !pilha.peek().equals("(")) {  
						saida+=" "+pilha.pop();     
					}pilha.pop();
				}
				else if (pilha.isEmpty() || pilha.peek().equals("(") ||
						testPrioridade(testPrioridade(expressao), testPrioridade(pilha.peek()))) {
					pilha.push(expressao);
				} else {
					while (!pilha.isEmpty() && !pilha.peek().equals("(")){
						if (!testPrioridade(testPrioridade(expressao), testPrioridade(pilha.peek()))) {  
							saida+=" "+pilha.pop();     
							continue;  
						} 
						pilha.pop(); 
						break;
					}  pilha.push(expressao);  

				}
			}
		}
		while (!pilha.isEmpty()) {  
			saida+=" "+ pilha.pop();   
		}  
		sc.close();

		return saida; 
	}

	public int testPrioridade(String operador){
		if(operador.equals("+") )
		{  return SOMAR; }
		else if (operador.equals("-")){
			return SUBTRAIR;
		} else if (operador.equals("*")){
			return MULTIPLICAR;}
		else if( operador.equals("/")){
			return DIVIDIR;
		} else if (operador.equals("(") || operador.equals(")")){
			return PARENTESES;
		}
		return 0;
	}

	public boolean testPrioridade(int operador, int operadorPilha){
		if(operador > operadorPilha){
			return true;
		}
		return false;
	}
}
