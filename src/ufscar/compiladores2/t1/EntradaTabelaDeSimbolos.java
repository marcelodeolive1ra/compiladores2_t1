package ufscar.compiladores2.t1;

public class EntradaTabelaDeSimbolos {

    private String nome;
    private String tipodado;
    private String tipotoken;

    public EntradaTabelaDeSimbolos(String nome, String tipodado, String tipotoken) {
        this.nome = nome;
        this.tipodado = tipodado;
        this.tipotoken = tipotoken;
    }

    public String getNome() {
        return this.nome;
    }

    public String getTipodado() {
        return this.tipodado;
    }

    public String getTipotoken() {
        return this.tipotoken;
    }

    @Override
    public String toString() {
        return this.nome + "(" + this.tipotoken + ":" + this.tipodado + ")";
    }
}
