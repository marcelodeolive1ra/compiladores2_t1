# Construção de Compiladores 2 - Trabalho 1

Universidade Federal de São Carlos - Semestre 2016/2 - Prof.ª Helena Caseli

## Descrição do trabalho

Este trabalho consiste na implementação de um compilador para a linguagem LA. O mesmo deverá portanto ser capaz de realizar análise léxica, sintática e semântica da linguagem. O compilador deverá ainda realizar geração de código C, para que os programas possam ser executados.

Como ferramenta de auxílio, utilizamos o ANTLR.

Como ambiente de desenvolvimento, utilizamos o IntelliJ IDEA 2016.3 versão Ultimate. O projeto foi testado também na versão Community do IntelliJ e também no Netbeans. Como sistema operacional, foi utilizado o macOS Sierra.

## Configurando o ambiente de desenvolvimento

O processo de instalação e configuração das ferramentas necessárias difere de acordo com o sistema operacional. A seguir, temos as instruções:

### Instale o ANTLR no sistema operacional

#### macOS Sierra ou Ubuntu 12+

Com os comandos a seguir, é possível instalar o ANTLR 4.5.3. Para que o projeto funcione corretamente, é necessário ainda colocar o caminho do ANTLR no `CLASSPATH` do sistema.

    $ cd /usr/local/lib
    $ sudo curl -O http://www.antlr.org/download/antlr-4.5.3-complete.jar
    $ export CLASSPATH=".:/usr/local/lib/antlr-4.5.3-complete.jar:$CLASSPATH"
    $ alias antlr4='java -jar /usr/local/lib/antlr-4.5.3-complete.jar'

### Configure o IntelliJ IDEA

...


### Compile o projeto

#### Pelo IntelliJ

1. Abra o IntelliJ
2. Abra o projeto em File -> Open...
3. Construa o projeto em Build -> Build Project
4. Gere o artefato .jar do projeto: Build -> Build Artifacts... -> Build

O .jar criado ficara na pasta `out/artifacts` dentro da pasta do projeto. Este arquivo é o executável do nosso compilador. Como o nome do projeto no IntelliJ é "T1_CC2_IntelliJ", o executável gerado terá o nome "T1_CC2_IntelliJ.jar"

## Utilizando o compilador

Utilizar o compilador é bem simples. O programa aceita dois parâmetros do tipo string, sendo o primeiro o arquivo de entrada, que deve conter um programa escrito em linguagem LA; e o segundo o nome do arquivo de saída. Neste arquivo de saída, o compilador escreverá:

1. o código C gerado pelo compilador, caso o programa escrito em linguagem LA não tenha erros;
2. um reporte de erros sintáticos ou semânticos encontrados no arquivo de entrada.

Exemplo:

    $ java -jar T1_CC2_IntelliJ.jar arquivo_de_entrada.txt arquivo_de_saida.c
   
