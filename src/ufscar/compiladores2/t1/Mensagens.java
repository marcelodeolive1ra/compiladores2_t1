package ufscar.compiladores2.t1;

// Classe que adiciona ao arquivo de saída mensagens de erros semânticos

public class Mensagens {
    private static String mensagens_de_erro = "";

    public static void erroVariavelJaExiste(String variavel, int linha) {
        mensagens_de_erro += "Linha " + linha + ": identificador " + variavel + " ja declarado anteriormente\n";
    }

    public static void erroVariavelNaoExiste(String variavel, int linha) {
        mensagens_de_erro += "Linha " + linha + ": identificador " + variavel + " nao declarado\n";
    }

    public static void escopoNaoPermitido(int linha) {
        mensagens_de_erro += "Linha " + linha + ": comando retorne nao permitido nesse escopo\n";
    }

    public static void erroTipoNaoExiste(String tipo, int linha) {
        mensagens_de_erro += "Linha " + linha + ": tipo " + tipo + " nao declarado\n";
    }

    public static void erroVariavelNaoCompativel(String variavel, int linha) {
        mensagens_de_erro += "Linha " + linha + ": atribuicao nao compativel para " + variavel + "\n";
    }

    public static void erroIncompatibilidadeParametros(String funcao, int linha) {
        mensagens_de_erro += "Linha " + linha + ": incompatibilidade de parametros na chamada de " + funcao + "\n";
    }

    public static String getText() {
        return mensagens_de_erro;
    }
}