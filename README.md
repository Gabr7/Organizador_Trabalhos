# Organizador de Serviços
Esse projeto nao tera continuidade no momento

Este projeto é um organizador de serviços, onde você pode adicionar, modificar e excluir serviços.


## Funcionalidades

- **Adicionar Serviços**: Você pode adicionar novos serviços com detalhes como nome, descrição, data, situação, valor e valor recebido.
- **Modificar Serviços**: Você pode modificar os detalhes de um serviço existente.
- **Excluir Serviços**: Você pode excluir um serviço existente.
- **Interface**: Este projeto usa a biblioteca Swing do Java para criar a interface gráfica do usuário.

## Como usar

1. **Adicionar um Serviço**: Para adicionar um serviço, você precisa fornecer detalhes como nome, descrição, data, situação, valor e valor recebido.
2. **Modificar um Serviço**: Para modificar um serviço, você pode selecionar o serviço que deseja modificar e clicar no botão 'Modificar'. Isso abrirá uma nova janela onde você pode modificar os detalhes do serviço.
3. **Excluir um Serviço**: Para excluir um serviço, você pode selecionar o serviço que deseja excluir e clicar no botão 'Excluir'. Será solicitada uma confirmação antes de excluir o serviço.

## Como Compilar e Executar

Este projeto usa o Apache Maven para gerenciar as dependências e compilar o código. Aqui estão os passos para compilar e executar o projeto:

2. **Compile o projeto**: Depois de navegar para o diretório do projeto, você pode compilar o projeto com o seguinte comando:

```bash
mvn compile
```
3. **Execute o projeto**: Se a compilação for bem-sucedida, você pode executar o projeto com o seguinte comando:
```bash
mvn exec:java -Dexec.mainClass="src.Main"
```


## Código de Exemplo

   Parte do codigo da Classe Servico, classe principal do projeto:


```java
public class Servico {
    private String nome;
    private String descricao;
    private LocalDate data;
    private String situacao;
    private float valor;
    private float recebido;


