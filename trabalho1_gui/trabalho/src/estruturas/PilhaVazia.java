package estruturas;

public class PilhaVazia extends Exception {
        public PilhaVazia() {
                super("Tentativa de acesso a uma pilha vazia ou expressao inv�lida."
                		+ "\n exp de express�o: 2+(3+5)");
        }
}
