# ProjetoJava - Concessionária em Java

### GRUPO:
João Vitor D El Rey

Leander Antonio Reblin Hallu

Miguel Wihby Rezende

------------------------------------------------

## Descrição
Este projeto consiste em uma aplicação para uma loja de carros, onde os usuários podem visualizar e adquirir veículos. A plataforma permite acessar a ficha técnica de cada carro, incluindo informações como portas, cor, potência, ano, cilindros e preço. Os clientes podem realizar compras utilizando seu saldo disponível.

## Funcionalidades
#### Cadastro de Clientes: 
Os clientes podem ser registrados com informações como nome, idade, saldo e CPF.
#### Concessionária: 
Informações sobre a concessionária, incluindo nome, CNPJ e lucro (acessível apenas para administradores).
#### Listagem de Carros: 
Os usuários podem visualizar a ficha técnica dos carros disponíveis, que incluem diferentes modelos, como Kwid, Sandero, Chevette, entre outros.
#### Compra de Carros: 
Implementação de diferentes métodos de pagamento (Transferência, Débito) e gerenciamento do estado das compras.

## Estrutura do Projeto
### Classes Principais:
#### Concessionária: 
Representa a concessionária com seus dados e estoque de carros.
#### Cliente: 
Armazena as informações dos clientes e seu saldo.
#### Compra (Abstrata): 
Classe abstrata que define a estrutura de uma compra, com métodos para Transferência, Débito e gerenciamento da Situação.
#### Carro (Superclasse): 
Representa um carro genérico com atributos comuns.
#### Modelos de Carro (Subclasses): 
Inclui classes específicas para cada modelo de carro, como Kwid, Sandero, Chevette, Focus, Celta, Kombi, Fusca e HB20.

## Linguagem de desenvolvimento
### Java
