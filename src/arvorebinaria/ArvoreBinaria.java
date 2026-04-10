package arvorebinaria;

import java.util.*;

public class ArvoreBinaria {
    private Folha folha;
    private ArvoreBinaria esquerda;
    private ArvoreBinaria direita;

    public ArvoreBinaria(){
        this.folha = null;
        this.esquerda = null;
        this.direita = null;
    }

    public ArvoreBinaria(Folha folha){
        this.folha = folha;
        this.esquerda = null;
        this.direita = null;
    }

    public boolean isEmpty(){
        return this.folha == null;
    }

    public void Inserir(Folha novo){
        if(isEmpty()){
            this.folha = novo;
        }
        else{
            ArvoreBinaria novaArvoreBinaria = new ArvoreBinaria(novo);
            if(novo.getValor() < this.folha.getValor()){
                if(this.esquerda == null){
                    this.esquerda = novaArvoreBinaria;
                    System.out.println("Folha: "+novo.getValor()+" está à esquerda de: "+this.folha.getValor());
                }
                else{
                    this.esquerda.Inserir(novo);
                }
            }
            else if(novo.getValor() > this.folha.getValor()){
                if(this.direita == null){
                    this.direita = novaArvoreBinaria;
                    System.out.println("Folha: "+novo.getValor()+" está à direita de: "+this.folha.getValor());
                }
                else{
                    this.direita.Inserir(novo);
                }
            }
        }

    }

    static ArvoreBinaria getSucessor(ArvoreBinaria atual){
        atual = atual.direita;
        while(atual != null && atual.esquerda != null){
            atual = atual.esquerda;
        }
        return atual;
    }

    static ArvoreBinaria deletarNo(ArvoreBinaria arvoreBinaria, int x){
        if(arvoreBinaria == null || arvoreBinaria.isEmpty()){
            return null;
        }

        if(arvoreBinaria.folha.getValor() > x){
            arvoreBinaria.esquerda = deletarNo(arvoreBinaria.esquerda, x);
        }

        else if(arvoreBinaria.folha.getValor() < x){
            arvoreBinaria.direita = deletarNo(arvoreBinaria.direita, x);
        }

        else {
            if (arvoreBinaria.esquerda == null && arvoreBinaria.direita == null){
                return null;
            }


        if(arvoreBinaria.esquerda == null){
            return arvoreBinaria.direita;
        }

        else if(arvoreBinaria.direita == null){
            return arvoreBinaria.esquerda;
        }

        ArvoreBinaria sucessor = getSucessor(arvoreBinaria);
        arvoreBinaria.folha = sucessor.folha;

        arvoreBinaria.direita = deletarNo(arvoreBinaria.direita, sucessor.folha.getValor());
        }
        return arvoreBinaria;
    }

    public boolean buscar(int valor){
        if(isEmpty()){
            return false;
        }

        if(valor == this.folha.getValor()){
            return true;
        }
        else if(valor < this.folha.getValor()){
            if(this.esquerda == null){
                return false;
            }
            return this.esquerda.buscar(valor);
        }
        else{
            if(this.direita == null){
                return false;
            }
            return this.direita.buscar(valor);
        }
    }

    public int altura(){
        if(isEmpty()){
            return -1;
        }

        int alturaEsquerda = -1;
        int alturaDireita = -1;

        if(this.esquerda != null){
            alturaEsquerda = this.esquerda.altura();
        }

        if(this.direita != null){
            alturaDireita = this.direita.altura();
        }

        return 1 + Math.max(alturaEsquerda, alturaDireita); //Descobri essa classe que calcula o máximo entre dois parâmetros :D
    }

    public void exibirPorAltura() {
        if (isEmpty()) {
            System.out.println("Árvore vazia");
            return;
        }

        Queue<ArvoreBinaria> fila = new LinkedList<>();
        fila.add(this);

        while (!fila.isEmpty()) {
            int tamanhoNivel = fila.size();
            System.out.print("[");

            for (int i = 0; i < tamanhoNivel; i++) {
                ArvoreBinaria atual = fila.poll();
                System.out.print(atual.folha.getValor());

                if (i < tamanhoNivel - 1) {
                    System.out.print(" ");
                }

                if (atual.esquerda != null) {
                    fila.add(atual.esquerda);
                }

                if (atual.direita != null) {
                    fila.add(atual.direita);
                }
            }

            System.out.print("] ");
        }
    }

}
