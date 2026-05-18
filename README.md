# Relatório Técnico - Implementação de Estruturas de Dados

## 1. Identificação
**Aluno:** Max Dezan Rossi

## 2. Introdução
A implementação manual de estruturas de dados é fundamental para a compreensão profunda de como a memória é gerenciada e como os algoritmos operam em baixo nível. Ao não utilizar classes prontas da API Java (como `LinkedList` ou `Stack`), o desenvolvedor é forçado a lidar diretamente com ponteiros (referências) e a lógica de encadeamento, o que proporciona um controle preciso sobre o comportamento da aplicação e eficiência no uso de recursos.

## 3. Implementação

### Estrutura do Nó
- **Lista Simplesmente Ligada (Cafeteria/Anúncios):** Cada nó (`Pedido`, `Anuncio`) contém os dados do objeto e uma referência `proximo` para o elemento seguinte. Na lista circular, o `proximo` do último nó aponta de volta para o primeiro.
- **Lista Duplamente Ligada (Músicas):** O nó (`Musica`) contém referências `proximo` e `anterior`, permitindo a navegação bidirecional.

### Casos Críticos e Tratamento
- **Remoção em Lista Vazia:** Em todas as implementações, antes de realizar operações de remoção ou acesso, verifica-se se a referência inicial (`inicio` ou `topo`) é `null`, retornando mensagens informativas ou valores nulos para evitar `NullPointerException`.
- **Atualização de Ponteiros (Início/Fim):** 
    - Na **Fila**, ao remover o último elemento, ambos `inicio` e `fim` são definidos como `null`.
    - Na **Lista Duplamente Ligada**, a inserção/remoção atualiza os ponteiros do vizinho anterior e posterior simultaneamente.
- **Prevenção de Loops em Estruturas Circulares:** Para listar os anúncios, utiliza-se o tamanho da lista ou uma marcação de parada baseada no nó inicial, garantindo que o ciclo seja percorrido exatamente uma vez.
- **Remoção do Atual:** Na lista circular e na playlist, se o nó removido for o "atual" (ponteiro de exibição/reprodução), o ponteiro é movido para o próximo nó válido antes da exclusão.

## 4. Evidências de Execução
As classes principais (`SistemaCafeteria`, `PlayerMusica`, `PainelDigital`) fornecem menus interativos no terminal que realizam:
- Inserção e remoção correta em pilhas e filas (Parte 1).
- Navegação entre músicas e ordenação por título/artista (Parte 2).
- Rotação infinita e remoção segura em ciclo circular (Parte 3).
(Pasta prints com evidências)

## 5. Conclusão
As principais dificuldades envolveram a manutenção dos ponteiros em listas circulares durante a remoção, especialmente quando a lista possui apenas um ou dois elementos. A resolução passou pelo desenho manual dos estados dos nós e testes exaustivos de casos de borda. O aprendizado obtido reforça a lógica de programação e a habilidade de criar soluções customizadas sem dependências externas.
