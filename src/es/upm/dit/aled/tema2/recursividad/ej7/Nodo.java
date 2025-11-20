package es.upm.dit.aled.tema2.recursividad.ej7;

public class Nodo {
	int valor;
	Nodo izq, der;

	public Nodo(int valor) {
		this.valor = valor;
	}

	public Nodo getIzq() {
		return izq;
	}

	public void setIzq(Nodo izq) {
		this.izq = izq;
	}

	public Nodo getDer() {
		return der;
	}

	public void setDer(Nodo der) {
		this.der = der;
	}

	public int getValor() {
		return valor;
	}

	public static boolean esBST(Nodo nodo) {
		return esBSTAux(nodo, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	private static boolean esBSTAux(Nodo nodo, int min, int max) {
		// Caso base: llegar a una hoja (null) es válido
		if (nodo == null) {
			return true;
		}

		// Validación del nodo actual
		// Debe ser estrictamente mayor que min y menor que max
		if (nodo.valor <= min || nodo.valor >= max) {
			return false;
		}

		// Paso recursivo:
		// Subárbol izquierdo: debe ser menor que el nodo actual (nuevo max)
		// Subárbol dererecho: debe ser mayor que el nodo actual (nuevo min)
		return esBSTAux(nodo.izq, min, nodo.valor) && esBSTAux(nodo.der, nodo.valor, max);
	}

}