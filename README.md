# 🏦 Projeto Banco Digital em Java (POO)

Este projeto simula o funcionamento de um banco com funcionalidades básicas de cadastro, movimentação bancária e controle de contas, usando exclusivamente Programação Orientada a Objetos (POO) e interação via terminal.

---

## 🎯 Funcionalidades Implementadas

- Cadastro de clientes com abertura de conta (corrente ou poupança)
- Depósito inicial obrigatório na abertura da conta
- Acesso à conta para:
  - Consultar extrato
  - Sacar
  - Depositar
  - Transferir entre contas
- Regras de limite de cheque especial e empréstimo pré-aprovado
- Impressão da carteira de clientes (apenas via acesso administrador)
- Menu em terminal com interação simples e clara

---

## 🧠 Regras de Negócio

### 🏦 Cheque Especial e Empréstimo:

O valor disponível para o cliente depende do saldo da conta no momento da abertura:

- 💰 **Saldo até R$ 500,00**:
  - Cheque especial de **20%**
  - Sem empréstimo pré-aprovado

- 💰 **Entre R$ 500,01 e R$ 2000,00**:
  - Cheque especial de **40%**
  - Empréstimo pré-aprovado de **60%**

- 💰 **Acima de R$ 2000,00**:
  - Cheque especial de **50%**
  - Empréstimo pré-aprovado de **75%**

> O uso do cheque especial desconta **10%** sobre o valor utilizado, como taxa.

---

## 🧱 Estrutura de Pastas e Classes

src/
- model/
- - Banco.java
- - Cliente.java
- - Conta.java (abstrata)
- - ContaCorrente.java
- - ContaPoupanca.java
- - IConta.java (interface)
- service/
- - ContaService.java
- - BancoService.java
- ui/
- - MenuUI.java
- Main.java


---

## 🚀 Como Executar

1. **Clone ou copie os arquivos do projeto**
2. **Abra no Eclipse ou IntelliJ**
3. Certifique-se de que todos os arquivos `.java` estão em seus respectivos pacotes.
4. Rode a classe `Main.java`
5. O menu será exibido no console.

---

## 🧾 Exemplo de Fluxo no Terminal

--- MENU PRINCIPAL ---
1. Abrir Conta Corrente
2. Abrir Conta Poupança
3. Acessar Conta
4. Ver Carteira de Clientes (admin)
5. Sair


Ao abrir uma conta, o usuário escolhe entre corrente ou poupança e informa o valor de depósito inicial.
Depois, pode realizar todas as operações bancárias básicas através do menu.


