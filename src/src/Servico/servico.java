package Servico;

public class servico {
    int ID;
    String nome;
    String situacao;
    float valor;
    float recebido;

    public servico(String nome){
        this.nome = nome;
    }
    public String getSituacao() {
        return situacao;
    }
    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }
    public float getValor() {
        return valor;
    }
    public void setValor(float valor) {
        this.valor = valor;
    }
    public float getRecebido() {
        return recebido;
    }
    public void setRecebido(float recebido) {
        this.recebido = recebido;
    }
}