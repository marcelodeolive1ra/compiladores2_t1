package ufscar.compiladores2.t1;


import java.util.ArrayList;
import java.util.List;

public class TabelaDeSimbolos {

    private String escopo;
    private List<EntradaTabelaDeSimbolos> simbolos;

    public TabelaDeSimbolos(String escopo) {
        this.simbolos = new ArrayList<>();
        this.escopo = escopo;
    }

    public void adicionarSimbolo(String nome, String tipodado, String tipotoken) {
        this.simbolos.add(new EntradaTabelaDeSimbolos(nome, tipodado, tipotoken));
    }

    public void adicionarSimbolos(List<String> nomes, String tipodado, String tipotoken) {
        for (String s : nomes) {
            simbolos.add(new EntradaTabelaDeSimbolos(s, tipodado, tipotoken));
        }
    }

    public boolean existeSimbolo(String nome) {
        for (EntradaTabelaDeSimbolos etds : simbolos) {
            if (etds.getNome().equals(nome)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        String ret = "Escopo: " + this.escopo;
        for (EntradaTabelaDeSimbolos etds : simbolos) {
            ret += "\n   " + etds;
        }
        return ret;
    }


    public String getTypeData(String nome) {
        for (EntradaTabelaDeSimbolos etds : simbolos) {
            if (etds.getNome().equals(nome)) {
                return etds.getTipodado();
            }
        }
        return "";
    }

    //Retorna o escopo associado a tabela
    public String getType() {
        if (this.escopo.contains("funcao"))
            return "funcao";
        else if (this.escopo.contains("procedimento"))
            return "procedimento";
        return "global";
    }

    public String getName() {
        return escopo;
    }

    //Metodo adicionado para retornar o tipo de uma entrada na tabela de simbolos
    public String getVarTipo(String nome) {
        for (EntradaTabelaDeSimbolos etds : simbolos) {
            if (etds.getNome().equals(nome)) {
                return etds.getTipodado();
            }
        }
        return "false";
    }
}
