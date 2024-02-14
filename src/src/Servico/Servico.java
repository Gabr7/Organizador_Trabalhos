package Servico;

import java.time.LocalDate;

public class Servico {
    private String nome;
    private String situacao;
    private float valor;
    private float recebido;
    private String descricao;
    private LocalDate data;
    public Servico(String nome){
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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }
}
