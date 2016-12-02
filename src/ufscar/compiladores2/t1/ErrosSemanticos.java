package ufscar.compiladores2.t1;

// Classe que adiciona ao arquivo de saída mensagens de erros semânticos

public class ErrosSemanticos {
    private static String erros_semanticos = "";

    public static void erroVariavelJaExiste(String variavel, int linha) {
        erros_semanticos += "Linha " + linha + ": identificador " + variavel + " ja declarado anteriormente\n";
    }

    public static void erroVariavelNaoExiste(String variavel, int linha) {
        erros_semanticos += "Linha " + linha + ": identificador " + variavel + " nao declarado\n";
    }

    public static void escopoNaoPermitido(int linha) {
        erros_semanticos += "Linha " + linha + ": comando retorne nao permitido nesse escopo\n";
    }

    public static void erroTipoNaoExiste(String tipo, int linha) {
        erros_semanticos += "Linha " + linha + ": tipo " + tipo + " nao declarado\n";
    }

    public static void erroVariavelNaoCompativel(String variavel, int linha) {
        erros_semanticos += "Linha " + linha + ": atribuicao nao compativel para " + variavel + "\n";
    }

    public static void erroIncompatibilidadeParametros(String funcao, int linha) {
        erros_semanticos += "Linha " + linha + ": incompatibilidade de parametros na chamada de " + funcao + "\n";
    }

    public static String getErrosSemanticos() {
        return erros_semanticos;
    }
}