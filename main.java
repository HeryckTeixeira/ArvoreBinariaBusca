public class ArvoreBinariaBusca {
    public static void main(String[] args) {
        ArvoreBinariaBusca abb = new ArvoreBinariaBusca();

        //  Inserir valores 
        System.out.println("=== Inserindo valores: 50, 30, 70, 20, 40, 60, 80, 10, 25 ===");
        int[] valores = {50, 30, 70, 20, 40, 60, 80, 10, 25};
        for (int v : valores) abb.inserir(v);

        System.out.println("\n── Árvore após inserção ──");
        abb.emOrdem();
        abb.preOrdem();
        abb.posOrdem();

        //  Busca 
        System.out.println("\n=== Busca ===");
        int[] alvos = {40, 99, 10};
        for (int alvo : alvos) {
            System.out.printf("Buscar(%-3d) → %s%n", alvo, abb.buscar(alvo) ? "ENCONTRADO" : "NÃO ENCONTRADO");
        }

        //  Remover: nó folha (10) 
        System.out.println("\n=== Remover nó folha (10) ===");
        abb.remover(10);
        abb.emOrdem();

        //  Remover: um filho (20, cujo único filho era 10) 
        System.out.println("\n=== Remover nó com um filho (20) ===");
        abb.remover(20);
        abb.emOrdem();

        //  Remover: dois filhos (30) 
        System.out.println("\n=== Remover nó com dois filhos (30) ===");
        System.out.println("(Sucessor em ordem de 30 é 40 → substitui 30)");
        abb.remover(30);
        abb.emOrdem();

        //  Estado final 
        System.out.println("\n── Árvore final (todos os percursos) ──");
        abb.emOrdem();
        abb.preOrdem();
        abb.posOrdem();
    }
}