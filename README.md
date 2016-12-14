# Construção de Compiladores 2 - Trabalho 1

**UNIVERSIDADE FEDERAL DE SÃO CARLOS**<br>
Centro de Ciências Exatas e de Tecnologia<br>
Construção de Compiladores 2 - Semestre 2016/2<br>
Prof. Dr. Daniel Lucrédio e Prof.ª Dr.ª Helena Caseli

## Descrição do trabalho

Este trabalho consiste na implementação de um compilador para a linguagem LA. O mesmo deverá, portanto, ser capaz de realizar análise léxica, sintática e semântica da linguagem. O compilador deverá ainda, quando códigos escritos em linguagem LA estiverem corretos, realizar geração de código em linguagem C, para que os programas possam ser executados.

A análise léxica e sintática deve ser feita de acordo com a especificação da gramática. Com relação à análise semântica, o compilador desenvolvido neste trabalho deve ser capaz de identificar os seguintes erros:

1. Identificador já declarado anteriormente no escopo
2. Tipo não declarado
3. Identificador não declarado
4. Incompatibilidade entre argumentos e parâmetros formais (número, ordem e tipo)
nas chamadas de procedimentos e funções
5. Atribuição não compatível com o tipo declarado
6. Uso do comando retorne em um escopo não permitido

Como ferramenta de auxílio, utilizamos o gerador automático ANTLR (ANother Tool for Language Recognition) versão 4.5.3 [http://www.antlr.org].

O compilador foi escrito em Java e, como ambiente de desenvolvimento, utilizamos o IntelliJ IDEA 2016.3 versão Ultimate. O projeto foi testado também na versão Community do IntelliJ e também no NetBeans 8.1. Como sistema operacional, foi utilizado o macOS Sierra, mas testes também foram realizados no Ubuntu.

## Configurando o ambiente de desenvolvimento

O processo de instalação e configuração das ferramentas necessárias difere de acordo com o sistema operacional. A seguir, temos as instruções para macOS Sierra e Ubuntu (versões 12 ou superiores):

### Instale o ANTLR no sistema operacional

#### macOS Sierra ou Ubuntu 12+

Com os comandos a seguir, é possível instalar o ANTLR 4.5.3. Para que o projeto funcione corretamente, é necessário ainda colocar o caminho do ANTLR no `CLASSPATH` do sistema.

    $ cd /usr/local/lib
    $ sudo curl -O http://www.antlr.org/download/antlr-4.5.3-complete.jar
    $ export CLASSPATH=".:/usr/local/lib/antlr-4.5.3-complete.jar:$CLASSPATH"
    $ alias antlr4='java -jar /usr/local/lib/antlr-4.5.3-complete.jar'

### Configure o IntelliJ IDEA

#### Instale o plugin do ANTLR

Os arquivos incluídos neste projeto já contam com o parser da gramática gerado pelo ANTLR. Entretanto, na necessidade de realizar alterações na gramática e gerar novamente o parser, a maneira mais simples de realizar isso é instalando o plugin ANTLR Works no IntelliJ IDEA. Além de permitir a geração fácil do parser a partir do arquivo da gramática, o plugin adiciona syntax highlighting aos arquivos de gramáticas (arquivos com extensão .g4) e configura o ambiente para ter suporte a importações de bibliotecas do ANTLR. O plugin permite ainda gerar árvores de análise e é capaz de verificar existência de ambiguidade na gramática, o que ajuda muito no desenvolvimento.
Para instalar o plugin:

1. Abra o IntelliJ IDEA
2. No macOS Sierra: entre no menu **IntelliJ IDEA** :arrow_forward: **Preferences...** :arrow_forward: seção **Plugins** :arrow_forward: **Browse repositories...**
3. No Ubuntu: entre no menu **File** :arrow_forward: **Settings** :arrow_forward: seção **Plugins** :arrow_forward: **Browse repositories...**
4. Procure pelos plugins **ANTLR v4 grammar plugin** e **ANTLR Works** e instale-os
5. Reinicie o IntelliJ IDEA

As opções de geração de parsers para a gramática ficam no menu Tools do IntelliJ, entretanto, as mesmas só aparecem quando um arquivo .g4 está aberto. Para o contexto do nosso compilador, é necessário apenas a geração do Visitor. O Listener não é necessário. Para configurar o ANTLR para não gerar arquivos desnecessários ao projeto, basta ir em **Tools** :arrow_forward: **Configure ANTLR...**

#### Configure a criação de um artefato JAR

Por padrão, construir um projeto no IntelliJ não gera automaticamente o arquivo .jar como acontece no NetBeans. É necessário configurar o IntelliJ para criar um artefato JAR. Para fazer isso:

1. Abra o IntelliJ IDEA
2. Abra o projeto em **File** :arrow_forward: **Open...**
3. Entre no menu **File** :arrow_forward: **Project Structure...**
4. Na seção **Project Settings**, clique em **Artifacts**
5. Clique no botão **"+"**, em seguida escolha a opção **"JAR"** e por fim escolha **"From
module with dependencies..."**
6. Na caixa de diálogo apresentada, no campo **Main Class**, clique no botão **"..."** e
escolha a classe **Main (ufscar.compiladores2.t1)**
7. Ainda na caixa de diálogo, na seção **"JAR files from libraries"**, selecione **"extract
to the target JAR"** e clique em **OK**
8. Selecione o artefato criado e na opção Class Path coloque:
   `/usr/local/lib/antlr-4.5.3-complete.jar`
9. Opcional: inclua a construção do artefato durante a construção do projeto selecionado a opção **"Include in project build"** e selecione o local em que o IntelliJ deverá colocar o arquivo .jar na opção **"Output directory"**
10. Clique em **OK**

### Compilando o projeto

Com o projeto aberto, construa-o indo no menu **Build** :arrow_forward: **Build Project**. Se o passo 9 da etapa anterior tiver sido executado, o arquivo .jar já vai ter sido criado. Por padrão o arquivo ficaria na pasta `/out/artifacts/T1_CC2_IntelliJ/` dentro da pasta do projeto. Caso tenha alterado o caminho no passo 9 anteriormente, o arquivo deve estar na pasta especificada.
Caso o passo 9 da etapa anterior não tenha sido executado, é necessário gerar o arquivo .jar manualmente. Isso é feito indo no menu **Build** :arrow_forward: **Build Artifacts...** :arrow_forward: **Build**.
Como o nome do projeto no IntelliJ é **"T1_CC2_IntelliJ"**, o executável gerado terá o nome **"T1_CC2_IntelliJ.jar"**. Após este passo, o compilador está pronto para ser utilizado como indicado na seção a seguir.

## Utilizando o compilador

Após compilar o projeto, o arquivo **T1_CC2_IntelliJ.jar** será gerado. Este arquivo é o nosso compilador. Utilizá-lo é bem simples. O programa aceita dois parâmetros do tipo `String`, sendo o primeiro o arquivo de entrada, que deve conter um programa escrito em linguagem LA; e o segundo o nome do arquivo de saída. Neste arquivo de saída, o compilador colocará:

+ o código C gerado pelo compilador, caso o programa escrito em linguagem LA não tenha erros; ou
+ um reporte de erros sintáticos ou semânticos encontrados no arquivo de entrada.

Supondo que você já esteja em uma sessão do terminal no diretório que contém os arquivos, o computador esteja com Java 8 instalado e o ANTLR esteja instalado e configurado, segue um exemplo de utilização do compilador:

    $ java -jar T1_CC2_IntelliJ.jar arquivo_de_entrada.la arquivo_de_saida.c

