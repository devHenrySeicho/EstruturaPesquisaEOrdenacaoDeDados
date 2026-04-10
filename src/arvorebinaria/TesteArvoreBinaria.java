package arvorebinaria;

public class TesteArvoreBinaria {

    public static void main(String[] args) {
        ArvoreBinaria arvoreBinaria = new ArvoreBinaria(new Folha(30));
        arvoreBinaria.Inserir(new Folha(15));
        arvoreBinaria.Inserir(new Folha(45));
        arvoreBinaria.Inserir(new Folha(7));
        arvoreBinaria.Inserir(new Folha(19));

        arvoreBinaria = ArvoreBinaria.deletarNo(arvoreBinaria, 15);

        System.out.println(arvoreBinaria.buscar(15)); //retorno esperado = false
        System.out.println(arvoreBinaria.buscar(45));


    }

}
