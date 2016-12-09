package ufscar.compiladores2.t1;

import org.antlr.v4.runtime.misc.Pair;

import java.util.*;

public class PilhaDeTabelas {

    private LinkedList<TabelaDeSimbolos> pilha;
    private LinkedList<List<String>> funcoes_ou_procedimentos;
    private LinkedList<String> nomes_das_funcoes;
    private Map<String, List<Pair>> tipos;

    public PilhaDeTabelas() {
        this.pilha = new LinkedList<>();
        this.funcoes_ou_procedimentos = new LinkedList<>();
        this.nomes_das_funcoes = new LinkedList<>();
        tipos = new HashMap<>();
        List<Pair> tipo_basico = new ArrayList<>();
        tipos.put("inteiro", tipo_basico);
        tipos.put("real", tipo_basico);
        tipos.put("literal", tipo_basico);
        tipos.put("logico", tipo_basico);
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

    public String getTipoDoSimbolo(String nome) {
        for (TabelaDeSimbolos tabela : this.pilha) {
            if (tabela.existeSimbolo(nome)) {
                return tabela.getTypeData(nome);
            }
        }
        return "";
    }

    public String getTipoDaVariavel(String nome) {
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

        if (tipos_dos_parametros != null && parametros.size() > 0) {
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
            ErrosSemanticos.parametrosIncompativeis(nome_funcao, linha);
        }
    }

    public void verificaAtribuicaoDePonteiro(String nome_variavel, int linha, String tipo_expressao) {
        String tipo_variavel = this.getTipoDoSimbolo(nome_variavel).replace("^", "");

        if (tipo_variavel.compareTo(tipo_expressao) != 0) {
            ErrosSemanticos.atribuicaoIncompativel("^" + nome_variavel, linha);
        }
    }

    public void verificaCompatibilidadeDeAtribuicao(boolean compativel, String tipo, String variavel, String atributo, int indice, int linha) {
        if (!this.existeSimbolo(variavel)) {
            ErrosSemanticos.identificadorInexistente(variavel, linha);
        } else if (!compativel && !tipo.equals("") && !this.getTipoDoSimbolo(variavel).equals(tipo)) {
            if (!(this.getTipoDoSimbolo(variavel).equals("real") && tipo.equals("inteiro"))) {
                if (indice != -1) {
                      ErrosSemanticos.atribuicaoIncompativel(variavel + "[" + indice + "]", linha);
                } else if (!atributo.equals("")) {
                     if (!this.getTipoDoAtributo(atributo).equals(tipo)) {
                        if (!(this.getTipoDoAtributo(atributo).equals("real") && tipo.equals("inteiro"))) {
                            if (!this.getTipoDoAtributo(atributo).equals(this.getTipoDoSimbolo(variavel))) {
                                ErrosSemanticos.atribuicaoIncompativel(variavel + "." + atributo, linha);
                            }
                        }
                     }
                } else {
                      ErrosSemanticos.atribuicaoIncompativel(variavel, linha);
                }
            }
        }
    }

    public void verificaVariavelInexistente(String variavel, String nome_atributo, String id_atributo, int linha) {
        if (!this.existeSimbolo(variavel)) {
            ErrosSemanticos.identificadorInexistente(variavel, linha);
        } else if (id_atributo.compareTo("") != 0) {
            if (!this.existeAtributo(this.getTipoDaVariavel(variavel), nome_atributo)) {
                ErrosSemanticos.identificadorInexistente(variavel + id_atributo, linha);
            }
        }
    }

    public void verificaVariavelExistente(Pair primeira_variavel, List<Pair> variaveis, String tipo_variavel) {
        variaveis.add(primeira_variavel);
        for (Pair variavel: variaveis) {
            if (this.existeSimbolo(variavel.a.toString())) {
                ErrosSemanticos.identificadorExistente(variavel.a.toString(), Integer.parseInt(variavel.b.toString()));
            } else {
                this.topo().adicionarSimbolo(variavel.a.toString(), tipo_variavel, "variavel");
            }
        }
    }

    public void adicionarTipo(String tipo, List<Pair> atributos) {
        tipos.put(tipo, atributos);
    }

    public boolean existeAtributo(String tipo, String atributo) {
        for (Map.Entry<String, List<Pair>> entry : tipos.entrySet()) {
            String key = entry.getKey();
            if (key.equals(tipo)) {
                List<Pair> value = entry.getValue();
                for (Pair pair : value) {
                    if (pair.a.toString().equals(atributo))
                        return true;
                }
                break;
            }
        }
        return false;
    }

    public String getTipoDoAtributo(String atributo) {
        for (Map.Entry<String, List<Pair>> entry : tipos.entrySet()) {
            String key = entry.getKey();
            List<Pair> value = entry.getValue();
            for (Pair pair : value) {
                if (pair.a.toString().equals(atributo))
                    return pair.b.toString();
            }
        }
        return "";
    }

    public boolean existeTipo(String tipo) {
        for (String _tipo : tipos.keySet()) {
            if (_tipo.equals(tipo))
                return true;
        }
        return false;
    }
}