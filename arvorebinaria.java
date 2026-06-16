class ArvoreBinariaBusca {
    private No raiz;

    public ArvoreBinariaBusca() {
        this.raiz = null;
    }

     
    // INSERÇÃO
    // Ponto de entrada público; delega ao método recursivo
     
    public void inserir(int valor) {
        raiz = inserirRecursivo(raiz, valor);
    }

    // Encontra recursivamente a posição correta e insere o nó
    private No inserirRecursivo(No atual, int valor) {
        // Caso base: posição vazia encontrada — insere o novo nó aqui
        if (atual == null) {
            return new No(valor);
        }

        if (valor < atual.valor) {
            // Valor pertence à subárvore esquerda
            atual.esquerda = inserirRecursivo(atual.esquerda, valor);
        } else if (valor > atual.valor) {
            // Valor pertence à subárvore direita
            atual.direita = inserirRecursivo(atual.direita, valor);
        }
        // Valores duplicados são ignorados (propriedade da ABB)

        return atual;
    }

     
    // BUSCA
    // Retorna true se o valor existir na árvore

    public boolean buscar(int valor) {
        return buscarRecursivo(raiz, valor);
    }

    private boolean buscarRecursivo(No atual, int valor) {
        // Caso base: chegou a um nó nulo — valor não encontrado
        if (atual == null) return false;

        if (valor == atual.valor) return true;

        // Restringe a busca à subárvore correta
        return valor < atual.valor
            ? buscarRecursivo(atual.esquerda, valor)
            : buscarRecursivo(atual.direita, valor);
    }

     
    // REMOÇÃO
    // Trata três casos:
    //   1. Nó folha            → simplesmente remove
    //   2. Um filho            → substitui o nó pelo seu filho
    //   3. Dois filhos         → substitui pelo sucessor em ordem,
    //                            depois remove o sucessor

    public void remover(int valor) {
        raiz = removerRecursivo(raiz, valor);
    }

    private No removerRecursivo(No atual, int valor) {
        // Caso base: valor não encontrado na árvore
        if (atual == null) return null;

        if (valor < atual.valor) {
            // Alvo está na subárvore esquerda
            atual.esquerda = removerRecursivo(atual.esquerda, valor);

        } else if (valor > atual.valor) {
            // Alvo está na subárvore direita
            atual.direita = removerRecursivo(atual.direita, valor);

        } else {
            //  Nó a ser removido encontrado 

            // Caso 1 e 2: Sem filho esquerdo → promove filho direito (cobre nó folha também)
            if (atual.esquerda == null) return atual.direita;

            // Caso 2: Sem filho direito → promove filho esquerdo
            if (atual.direita == null) return atual.esquerda;

            // Caso 3: Dois filhos
            // Encontra o sucessor em ordem: menor valor na subárvore direita
            int valorSucessor = encontrarMinimo(atual.direita);

            // Substitui o valor do nó atual pelo valor do sucessor
            atual.valor = valorSucessor;

            // Remove o sucessor em ordem da subárvore direita
            atual.direita = removerRecursivo(atual.direita, valorSucessor);
        }

        return atual;
    }

    // Retorna o valor mínimo de uma subárvore (nó mais à esquerda)
    private int encontrarMinimo(No no) {
        while (no.esquerda != null) {
            no = no.esquerda;
        }
        return no.valor;
    }

    // PERCURSOS

    // Em Ordem: Esquerda → Raiz → Direita  (produz saída ordenada)
    public void emOrdem() {
        System.out.print("Em Ordem    : ");
        emOrdemRecursivo(raiz);
        System.out.println();
    }

    private void emOrdemRecursivo(No no) {
        if (no == null) return;
        emOrdemRecursivo(no.esquerda);
        System.out.print(no.valor + " ");
        emOrdemRecursivo(no.direita);
    }

    // Pré-Ordem: Raiz → Esquerda → Direita  (útil para copiar a árvore)
    public void preOrdem() {
        System.out.print("Pré-Ordem   : ");
        preOrdemRecursivo(raiz);
        System.out.println();
    }

    private void preOrdemRecursivo(No no) {
        if (no == null) return;
        System.out.print(no.valor + " ");
        preOrdemRecursivo(no.esquerda);
        preOrdemRecursivo(no.direita);
    }

    // Pós-Ordem: Esquerda → Direita → Raiz  (útil para deletar a árvore)
    public void posOrdem() {
        System.out.print("Pós-Ordem   : ");
        posOrdemRecursivo(raiz);
        System.out.println();
    }

    private void posOrdemRecursivo(No no) {
        if (no == null) return;
        posOrdemRecursivo(no.esquerda);
        posOrdemRecursivo(no.direita);
        System.out.print(no.valor + " ");
    }
}