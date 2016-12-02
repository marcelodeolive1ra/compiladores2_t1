package ufscar.compiladores2.t1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PilhaDeTabelas {

    private LinkedList<TabelaDeSimbolos> pilha;
    private LinkedList<List<String>> funcoes_ou_procedimentos;
    private LinkedList<String> nomes_das_funcoes;

    public PilhaDeTabelas() {
        this.pilha = new LinkedList<>();
        this.funcoes_ou_procedimentos = new LinkedList<>();
        this.nomes_das_funcoes = new LinkedList<>();
    }

    public void empilhar(TabelaDeSimbolos tabela_de_simbolos) {
        this.pilha.push(tabela_de_simbolos);
    }

    public TabelaDeSimbolos topo() {
        return this.pilha.peek();
    }

    //Retorna a tabela correspondente ao escopo global
    public TabelaDeSimbolos tabelaGlobal() {
        for (TabelaDeSimbolos tabela : this.pilha) {
            if (tabela.getName().equals("global"))
                return tabela;
        }
        return null;
    }

    public boolean existeSimbolo(String nome) {
        for (TabelaDeSimbolos tabela : this.pilha) {
            if (tabela.existeSimbolo(nome)) {
                return true;
            }
        }
        return false;
    }

    public String getTypeData(String nome) {
        for (TabelaDeSimbolos tabela : this.pilha) {
            if (tabela.existeSimbolo(nome)) {
                return tabela.getTypeData(nome);
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
        this.pilha.pop();
    }

    public void adicionarFuncaoOuProcedimento(String nome_da_funcao) {
        List<String> list = new ArrayList<>();
        this.nomes_das_funcoes.push(nome_da_funcao);
        this.funcoes_ou_procedimentos.push(list);
    }

    public List<String> topo_funcoes() {
        return this.funcoes_ou_procedimentos.peek();
    }

    public List<String> getTiposDasFuncoes(String funcao_procurada) {
        for (int i = 0; i < this.nomes_das_funcoes.size(); i++) {
            if (this.nomes_das_funcoes.get(i).compareTo(funcao_procurada) == 0) {
                return this.funcoes_ou_procedimentos.get(i);
            }
        }
        return null;
    }

    public void verificaCompatibilidadeDeParametros(List<String> parametros, String nome_funcao, int linha) {
        boolean compativel = true;
        List<String> tipos_dos_parametros = this.getTiposDasFuncoes(nome_funcao);

        if (tipos_dos_parametros != null) {
            for (int i = 0; i < tipos_dos_parametros.size() && compativel; i++) {
                try {
                    compativel = !(tipos_dos_parametros.get(i).compareTo(parametros.get(i)) != 0 &&
                                parametros.get(i).compareTo("") != 0);
                } catch (IndexOutOfBoundsException e) {
                    compativel = false;
                }
            }
        }
        if (!compativel) {
            Mensagens.erroIncompatibilidadeParametros(nome_funcao, linha);
        }
    }
}