package ufscar.compiladores2.t1;

/**
 * Created by marcelodeoliveiradasilva on 19/11/16.
 */
public class OutputBuffer {

    private StringBuffer conteudo;
    private boolean modificado;

    public OutputBuffer() {
        this.conteudo = new StringBuffer();
        this.modificado = false;
    }

    public void print(String texto) {
        if (!this.modificado) {
            this.modificado = true;
        }

        this.conteudo.append(texto);
    }

    public void println(String texto) {
        if (!this.modificado) {
            this.modificado = true;
        }

        this.conteudo.append(texto);
        this.conteudo.append("\n");
    }

    public boolean isModificado() {
        return this.modificado;
    }

    @Override
    public String toString() {
        return this.conteudo.toString();
    }
}
