# Sorteador de Números - Android

Este aplicativo permite que o usuário sorteie um número inteiro dentro de um intervalo pré-definido. Ele utiliza os padrões de design **Strategy** e **Singleton** e foi desenvolvido com o intuito de reforçar conceitos do **LinearLayout** e **desenvolvimento de aplicativos Android**. Como recurso adicional, os números sorteados são exibidos em um **ListView**.

## Funcionalidades

- Sorteio de um número aleatório dentro de um intervalo especificado pelo usuário.
- Exibição dos números sorteados em um **ListView**.
- Utilização do **padrão de design Strategy** para a escolha da estratégia de sorteio.
- Implementação do **padrão Singleton** para garantir que haja apenas uma instância do sorteador de números.
- Interface com **LinearLayout** para organizar os componentes da tela.

## Tecnologias Utilizadas

- **Android SDK** (Java/Kotlin)
- **LinearLayout** (para organização da interface)
- **ListView** (para exibição dos números sorteados)
- **Strategy Pattern** (para escolha da estratégia de sorteio)
- **Singleton Pattern** (para garantir uma única instância do sorteador)

## Padrões de Design

### Strategy

O padrão **Strategy** é utilizado para permitir a escolha flexível do algoritmo de sorteio. O aplicativo pode ser facilmente expandido para adicionar novas estratégias no futuro sem modificar o código principal.

### Singleton

O padrão **Singleton** é utilizado para garantir que o sorteador de números seja instanciado apenas uma vez durante a execução do aplicativo. Isso garante que o sorteio de números seja realizado de forma consistente.

## Como Usar

1. **Abrir o aplicativo**: Inicie o aplicativo em um dispositivo Android ou emulador.
2. **Definir o intervalo**: O usuário pode definir o intervalo de números (mínimo e máximo).
3. **Sortear o número**: Após definir o intervalo, clique no botão para sortear um número.
4. **Visualizar os sorteios**: Os números sorteados serão exibidos em um ListView.

## Como Rodar o Projeto

1. Clone este repositório:
   ```bash
   git clone https://github.com/seu-usuario/sorteador-de-numeros.git
