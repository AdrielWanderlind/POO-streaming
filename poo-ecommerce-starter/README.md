# 🛒 Sistema de E-Commerce - Projeto Starter (POO)

Este projeto é uma base prática para o estudo de **Programação Orientada a Objetos** aplicada a um cenário de mercado real: um sistema de vendas online. O foco aqui é entender como diferentes objetos se relacionam para formar um pedido de compra.

## 📂 Estrutura de Pastas e Arquivos

O projeto está organizado para separar a execução dos testes da lógica de dados:

### 📦 `br.com.ecommerce.model`
Este pacote contém o "coração" do sistema, representando as entidades envolvidas em uma venda.

*   **`Produto.java`**: Representa os itens disponíveis no catálogo (ex: Smartphone, Notebook). Deve conter atributos como nome, preço e quantidade em estoque.
*   **`Cliente.java`**: Representa quem está comprando. Armazena dados como nome, CPF e endereço.
*   **`ItemPedido.java`**: Esta é uma classe intermediária fundamental. Ela representa uma "linha" do carrinho de compras. Ela liga um **Produto** à **Quantidade** que está sendo comprada naquele momento.
*   **`Pedido.java`**: É o fechamento da compra. Ele associa o **Cliente** a uma lista de vários **Itens de Pedido**, calcula o valor total e armazena a data da venda.

### 📦 `br.com.ecommerce.main`
O ponto de partida do sistema.

*   **`MainTeste.java`**: Onde a mágica acontece. Aqui você irá instanciar produtos, criar um cliente, adicionar itens ao carrinho (lista) e gerar um pedido final, imprimindo o resumo na tela.

---

## 🛠️ O que você deve desenvolver (Desafios)

Este projeto está em branco para que você possa construir a estrutura do zero, seguindo os conceitos de POO:

1.  **Atributos e Encapsulamento**: Defina os atributos privados em cada classe e gere seus `Getters` e `Setters`.
2.  **Construtores**: Crie construtores para facilitar a criação dos objetos (ex: criar um Produto já passando nome e preço).
3.  **Relacionamentos (Composição)**:
    *   O `ItemPedido` deve ter um atributo do tipo `Produto`.
    *   O `Pedido` deve ter um atributo do tipo `Cliente` e uma `List<ItemPedido>`.
4.  **Métodos de Negócio**:
    *   No `Pedido`, crie um método para calcular o **Valor Total** somando todos os itens.
    *   No `ItemPedido`, crie um método para calcular o **Subtotal** (preço do produto × quantidade).
5.  **Sobrescrita**: Implemente o método `toString()` para exibir os dados de forma organizada no console.

---

## 🚀 Como testar
1. Abra o projeto em sua IDE (VS Code, IntelliJ ou Eclipse).
2. Vá até `MainTeste.java`.
3. Utilize o `System.out.println` para verificar se os cálculos de total e os dados dos clientes estão aparecendo corretamente conforme você codifica.

---
*Dica: Pense no ItemPedido como o cupom fiscal: ele diz qual produto foi levado, quantos e qual o preço naquele momento!*
