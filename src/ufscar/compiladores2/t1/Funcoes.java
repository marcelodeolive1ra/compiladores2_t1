package ufscar.compiladores2.t1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by marcelodeoliveiradasilva on 19/11/16.
 */
public class Funcoes {
    private LinkedList<List<String>> pilha;

    public Funcoes() {
        pilha = new LinkedList<List<String>>();
    }

    public void addFuncao(String nome) {
        List<String> list = new ArrayList<String>();
        list.add(nome);
        pilha.push(list);
    }

    public List<String> topo() {
        return pilha.peek();
    }

    public List<String> getFuncTipos(String nome) {
        for (List<String> f : pilha) {
            if (f.get(0).equals(nome))
                return f.subList(1, f.size());
        }
        return null;
    }
}
