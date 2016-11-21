package ufscar.compiladores2.t1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.antlr.v4.runtime.misc.Pair;

/**
 * Created by marcelodeoliveiradasilva on 19/11/16.
 */
public class Tipos {

    private Map<String, List<Pair>> tipos;

    public Tipos() {
        tipos = new HashMap<String, List<Pair>>();
        List<Pair> tipo_basico = new ArrayList<Pair>();
        tipos.put("inteiro", tipo_basico);
        tipos.put("real", tipo_basico);
        tipos.put("literal", tipo_basico);
        tipos.put("logico", tipo_basico);
    }

    public void addTipo(String tipo, List<Pair> atributos) {
        tipos.put(tipo, atributos);
    }

    public boolean existeAtributo(String tipo, String atributo) {
        for (Map.Entry<String, List<Pair>> entry : tipos.entrySet()) {
            String key = entry.getKey();
            if (key.equals(tipo)) {
                List<Pair> value = entry.getValue();
                for (Pair pair : value) {
                    if(pair.a.toString().equals(atributo))
                        return true;
                }
                break;
            }
        }
        return false;
    }

    public String getTipoAtr(String atributo) {
        for (Map.Entry<String, List<Pair>> entry : tipos.entrySet()) {
            String key = entry.getKey();
            List<Pair> value = entry.getValue();
            for (Pair pair : value) {
                if(pair.a.toString().equals(atributo))
                    return pair.b.toString();
            }
        }
        return "";
    }

    public boolean existeTipo(String tipo) {
        for (String t : tipos.keySet()) {
            if (t.equals(tipo))
                return true;
        }
        return false;
    }
}