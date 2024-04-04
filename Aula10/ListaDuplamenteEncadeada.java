package Aula10;

public class ListaDuplamenteEncadeada {
	private No inicio;
    private No fim;
    private int tamanho;

    public void inserirInicio(int elemento) {
        No novoNo = new No(elemento);
        if (inicio == null) {
            inicio = fim = novoNo;
        } else {
            novoNo.setProximo(inicio);
            inicio.setAnterior(novoNo);
            inicio = novoNo;
        }
        tamanho++;
    }

    public void inserirFim(int elemento) {
        No novoNo = new No(elemento);
        if (inicio == null) {
            inicio = fim = novoNo;
        } else {
            fim.setProximo(novoNo);
            novoNo.setAnterior(fim);
            fim = novoNo;
        }
        tamanho++;
    }

    public void inserirMeio(int elemento) {
        No novoNo = new No(elemento);
        if (inicio == null || inicio.getElemento() >= elemento) {
            inserirInicio(elemento);
            return;
        }
        No atual = inicio;
        while (atual.getProximo() != null && atual.getProximo().getElemento() < elemento) {
            atual = atual.getProximo();
        }
        novoNo.setProximo(atual.getProximo());
        if (atual.getProximo() != null) {
            atual.getProximo().setAnterior(novoNo);
        }
        novoNo.setAnterior(atual);
        atual.setProximo(novoNo);
        tamanho++;
    }

    public void removerInicio() {
        if (inicio != null) {
            inicio = inicio.getProximo();
            if (inicio != null) {
                inicio.setAnterior(null);
            } else {
                fim = null;
            }
            tamanho--;
        }
    }

    public void removerFim() {
        if (fim != null) {
            fim = fim.getAnterior();
            if (fim != null) {
                fim.setProximo(null);
            } else {
                inicio = null;
            }
            tamanho--;
        }
    }

    public void removerMeio(int elemento) {
        No atual = inicio;
        while (atual != null && atual.getElemento() != elemento) {
            atual = atual.getProximo();
        }
        if (atual == null) {
            return;
        }
        if (atual == inicio) {
            removerInicio();
            return;
        }
        if (atual == fim) {
            removerFim();
            return;
        }
        atual.getAnterior().setProximo(atual.getProximo());
        atual.getProximo().setAnterior(atual.getAnterior());
        tamanho--;
    }

    public int getTamanho() {
        return tamanho;
    }

    public boolean estaVazia() {
        return tamanho == 0;
    }

    public void imprimir() {
        No atual = inicio;
        while (atual != null) {
            System.out.print(atual.getElemento() + " ");
            atual = atual.getProximo();
        }
        System.out.println();
    }

    public static void main(String[] args) {

        ListaDuplamenteEncadeada lista = new ListaDuplamenteEncadeada();

        lista.inserirInicio(5);
        lista.inserirInicio(7);
        lista.inserirInicio(6);
        lista.inserirInicio(10);

        lista.imprimir();

        lista.inserirFim(12);
        lista.imprimir();

        lista.inserirMeio(8);
        lista.imprimir();

        lista.removerInicio();
        lista.imprimir();

        lista.removerFim();
        lista.imprimir();

        lista.removerMeio(7);
        lista.imprimir();

        System.out.println("Tamanho da lista: " + lista.getTamanho());
        System.out.println("A lista está vazia? " + lista.estaVazia());
    }

}
