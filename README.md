# 🌳 Árvore Binária de Busca em Java

Implementação didática de uma **Árvore Binária de Busca (ABB)** em Java, sem o uso de bibliotecas prontas. O projeto cobre inserção recursiva, busca, remoção com os três casos clássicos e os três tipos de percurso.

---

## 📁 Estrutura dos arquivos

```
projeto/
├── No.java                  # Classe que representa um nó da árvore
├── ArvoreBinariaBusca.java  # Lógica principal da ABB
├── Main.java                # Demonstração de uso
└── README.md
```

---

## 🧩 Classes e responsabilidades

### `No`
Representa um único nó da árvore.

| Campo | Tipo | Descrição |
|---|---|---|
| `valor` | `int` | Valor armazenado no nó |
| `esquerda` | `No` | Filho esquerdo |
| `direita` | `No` | Filho direito |

---

### `ArvoreBinariaBusca`
Contém toda a lógica da estrutura de dados.

#### Métodos públicos

| Método | Descrição |
|---|---|
| `inserir(int valor)` | Insere um valor na árvore de forma recursiva |
| `buscar(int valor)` | Retorna `true` se o valor existir na árvore |
| `remover(int valor)` | Remove um valor tratando os três casos possíveis |
| `emOrdem()` | Percurso Em Ordem — produz saída **ordenada** |
| `preOrdem()` | Percurso Pré-Ordem — raiz antes dos filhos |
| `posOrdem()` | Percurso Pós-Ordem — raiz depois dos filhos |

---

## ⚙️ Como funciona

### Inserção
A inserção é feita de forma **recursiva**. A cada chamada, o método retorna o nó atual de volta ao pai, atualizando os ponteiros automaticamente — sem necessidade de referência ao nó pai.

```
Inserindo: 50, 30, 70, 20, 40

        50
       /  \
      30   70
     /  \
    20   40
```

### Busca
Compara o valor buscado com o nó atual e desce para a subárvore correta até encontrar ou chegar a um nó nulo.

### Remoção — 3 casos

| Caso | Situação | Solução |
|---|---|---|
| **1. Nó folha** | Não tem filhos | Remove diretamente |
| **2. Um filho** | Tem só filho esquerdo ou direito | Substitui o nó pelo filho |
| **3. Dois filhos** | Tem ambos os filhos | Substitui pelo **sucessor em ordem** (menor valor da subárvore direita) e remove o sucessor |

### Percursos

| Percurso | Ordem de visita | Utilidade |
|---|---|---|
| Em Ordem | Esquerda → Raiz → Direita | Lê os valores em ordem crescente |
| Pré-Ordem | Raiz → Esquerda → Direita | Útil para copiar/serializar a árvore |
| Pós-Ordem | Esquerda → Direita → Raiz | Útil para deletar a árvore |

---

## 🚀 Como executar

### Pré-requisitos
- **Java JDK 8+** instalado — [download aqui](https://www.oracle.com/java/technologies/downloads/)

Verifique a instalação:
```bash
java -version
javac -version
```

### Passo a passo

**1. Clone ou baixe os arquivos** na mesma pasta.

**2. Compile os três arquivos:**
```bash
javac No.java ArvoreBinariaBusca.java Main.java
```

**3. Execute:**
```bash
java Main
```

---

## 📊 Saída esperada

```
=== Inserindo valores: 50, 30, 70, 20, 40, 60, 80, 10, 25 ===

── Árvore após inserção ──
Em Ordem    : 10 20 25 30 40 50 60 70 80
Pré-Ordem   : 50 30 20 10 25 40 70 60 80
Pós-Ordem   : 10 25 20 40 30 60 80 70 50

=== Busca ===
Buscar(40 ) → ENCONTRADO
Buscar(99 ) → NÃO ENCONTRADO
Buscar(10 ) → ENCONTRADO

=== Remover nó folha (10) ===
Em Ordem    : 20 25 30 40 50 60 70 80

=== Remover nó com um filho (20) ===
Em Ordem    : 25 30 40 50 60 70 80

=== Remover nó com dois filhos (30) ===
(Sucessor em ordem de 30 é 40 → substitui 30)
Em Ordem    : 25 40 50 60 70 80

── Árvore final (todos os percursos) ──
Em Ordem    : 25 40 50 60 70 80
Pré-Ordem   : 50 40 25 70 60 80
Pós-Ordem   : 25 40 60 80 70 50
```

---

## 📈 Complexidade

| Operação | Caso médio | Pior caso (árvore degenerada) |
|---|---|---|
| Inserção | O(log n) | O(n) |
| Busca | O(log n) | O(n) |
| Remoção | O(log n) | O(n) |

> O pior caso ocorre quando os elementos são inseridos em ordem crescente ou decrescente, formando uma lista encadeada. Para evitar isso, utilize uma **Árvore AVL** ou **Árvore Rubro-Negra**.

---

## 🛠️ Tecnologias

- **Java** — sem bibliotecas externas
- Estrutura de dados implementada do zero
