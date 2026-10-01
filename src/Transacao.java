public class Transacao {
    private String tipo;
    private String descricao;
    private double valor;
    private String data;

    public Transacao(String tipo, String descricao, double valor, String data) {
        this.tipo = tipo;
        this.descricao = descricao;
        this.valor = valor;
        this.data = data;
    }

    public String getTipo() {
        return tipo;
    }

    public String getDescricao() {
        return descricao;
    }

    public double getValor() {
        return valor;
    }

    public String getData() {
        return data;
    }

    @Override
    public String toString() {
        return "[" + tipo + "] " + descricao + " | R$ " + valor + " | " + data;
    }
}