# Construção de Compiladores 2 - Trabalho 1

Universidade Federal de São Carlos - Semestre 2016/2 - Prof.ª Helena Caseli

## Descrição do trabalho

Este trabalho consiste na implementação de um compilador para a linguagem LA. O mesmo deverá portanto ser capaz de realizar análise léxica, sintática e semântica da linguagem. O compilador deverá ainda realizar geração de código C, para que os programas possam ser executados.

A análise léxica e sintática deve ser feita de acordo com a especificaço da gramática. Com relação à análise semântica, o compilador deve ser capaz de identificar os seguintes erros:

1. Identificador já declarado anteriormente no escopo
2. Tipo não declarado
3. Identificador não declarado
4. Incompatibilidade entre argumentos e parâmetros formais (número, ordem e tipo) nas chamadas de procedimentos e funções
5. Atribuição não compatível com o tipo declarado
6. Uso do comando `retorne` em um escopo não permitido

Como ferramenta de auxílio, utilizamos o gerador automático ANTLR [https://github.com/antlr/antlr4] versão 4.5.3.

O compilador foi escrito em Java, e como ambiente de desenvolvimento, utilizamos o IntelliJ IDEA 2016.3 versão Ultimate. O projeto foi testado também na versão Community do IntelliJ e também no Netbeans. Como sistema operacional, foi utilizado o macOS Sierra, mas testes também foram realizados no Ubuntu.

## Configurando o ambiente de desenvolvimento

O processo de instalação e configuração das ferramentas necessárias difere de acordo com o sistema operacional. A seguir, temos as instruções para macOS Sierra e Ubuntu 12+:

### Instale o ANTLR no sistema operacional

#### macOS Sierra ou Ubuntu 12+

Com os comandos a seguir, é possível instalar o ANTLR 4.5.3. Para que o projeto funcione corretamente, é necessário ainda colocar o caminho do ANTLR no `CLASSPATH` do sistema.

    $ cd /usr/local/lib
    $ sudo curl -O http://www.antlr.org/download/antlr-4.5.3-complete.jar
    $ export CLASSPATH=".:/usr/local/lib/antlr-4.5.3-complete.jar:$CLASSPATH"
    $ alias antlr4='java -jar /usr/local/lib/antlr-4.5.3-complete.jar'

### Configure o IntelliJ IDEA

Por padrão, construir um projeto no IntelliJ não gera automaticamente o arquivo .jar como acontece no NetBeans. É necessário configurar o IntelliJ para criar um artefato. Para fazer isso:

1. Abra o IntelliJ IDEA
2. Abra o projeto em File -> Open...
3. Entre no menu File -> Project Structure...
4. Na seção Project Settings, clique em Artifacts
5. Clique no botão "+", em seguida escolha a opção "JAR" e por fim escolha "From module with dependencies..."
6. Na caixa de diálogo apresentada, no campo `Main Class`, clique no botão "..." e escolha a classe `Main (ufscar.compiladores2.t1)`
7. Ainda na caixa de diálogo, na seção "JAR files from libraries", selecione "extract to the target JAR" e clique em OK
8. Selecione o artefato criado e na opção `Class Path` coloque: `/usr/local/lib/antlr-4.5.3-complete.jar`
9. Opcional: inclua a construção do artefato durante a construço do projeto selecionado a opção "Include in project build" e selecione o local em que o IntelliJ deverá colocar o arquivo .jar na opção "Output directory"
10. Clique em OK

### Compile o projeto

Com o projeto aberto, construa-o indo no menu Build -> Build Project. Se o passo 9 da etapa anterior tiver sido executado, o arquivo .jar já vai ter sido criado. Por padrão o arquivo ficaria na pasta `/out/artifacts/T1_CC2_IntelliJ/` dentro da pasta do projeto. Caso tenha alterado o caminho no passo 9 anteriormente, o arquivo deve estar na pasta especificada.

Caso o passo 9 da etapa anterior não tenha sido executado, é necessário gerar o arquivo .jar. Isso é feito indo no menu Build -> Build Artifacts... -> Build.
4. Gere o artefato .jar do projeto: Build -> Build Artifacts... -> Build

Como o nome do projeto no IntelliJ é "T1_CC2_IntelliJ", o executável gerado terá o nome "T1_CC2_IntelliJ.jar"

## Utilizando o compilador

Utilizar o compilador é bem simples. O programa aceita dois parâmetros do tipo `string`, sendo o primeiro o arquivo de entrada, que deve conter um programa escrito em linguagem LA; e o segundo o nome do arquivo de saída. Neste arquivo de saída, o compilador colocará:

* o código C gerado pelo compilador, caso o programa escrito em linguagem LA não tenha erros;
* um reporte de erros sintáticos ou semânticos encontrados no arquivo de entrada.

Exemplo de execução (supondo que você já esteja no diretório correto no terminal):

    $ java -jar T1_CC2_IntelliJ.jar arquivo_de_entrada.txt arquivo_de_saida.c
   
