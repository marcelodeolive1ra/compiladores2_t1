package ufscar.compiladores2.t1;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by marcelodeoliveiradasilva on 19/11/16.
 */

public class PilhaDeTabelas {

    private LinkedList<TabelaDeSimbolos> pilha;

    public PilhaDeTabelas() {
        this.pilha = new LinkedList<>();
    }

    public void empilhar(TabelaDeSimbolos ts) {
        this.pilha.push(ts);
    }

    public TabelaDeSimbolos topo() {
        return this.pilha.peek();
    }

    //Retorna a tabela correspondente ao escopo global
    public TabelaDeSimbolos tabelaGlobal() {
        for (TabelaDeSimbolos ts : pilha) {
            if(ts.getName().equals("global"))
                return ts;
        }
        return null;
    }

    public boolean existeSimbolo(String nome) {
        for (TabelaDeSimbolos ts : this.pilha) {
            if (ts.existeSimbolo(nome)) {
                return true;
            }
        }
        return false;
    }

    public String getTypeData(String nome) {
        for(TabelaDeSimbolos ts : this.pilha) {
            if(ts.existeSimbolo(nome)) {
                return ts.getTypeData(nome);
            }
        }
        return "";
    }
    public String getVarTipo(String nome) {
        for (TabelaDeSimbolos ts : this.pilha) {
            if (ts.existeSimbolo(nome)) {
                return ts.getVarTipo(nome);
            }
        }
        return "false";
    }
    public void desempilhar() {
        TabelaDeSimbolos ret = this.pilha.pop();
        //Saida.println(ret.toString());
    }

    public List getTodasTabelas() {
        return this.pilha;
    }
}