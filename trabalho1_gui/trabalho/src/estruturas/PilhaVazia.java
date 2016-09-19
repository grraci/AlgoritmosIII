package estruturas;

public class PilhaVazia extends Exception {
        public PilhaVazia() {
                super("Tentativa de acesso a uma pilha vazia ou expressao inválida."
                		+ "\n exp de expressão: 2+(3+5)");
        }
}
