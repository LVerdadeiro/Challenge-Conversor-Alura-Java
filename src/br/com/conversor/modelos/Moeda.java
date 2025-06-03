package src.br.com.conversor.modelos;

public class Moeda {
    private String codigo;
    private String nome;

    public Moeda() {
    }

    public Moeda(String codigo, String nome) {
        this.codigo = codigo;
        this.nome = nome;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return nome != null ? nome + " (" + codigo + ")" : codigo;
    }
}