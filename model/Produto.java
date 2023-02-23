package model;

public class Produto {
    private int codigo;
    private String descricao;
    private int quantidade;
    private double valorUnitario;
    public boolean continuado;

    public Produto(){
        continuado = true;
    }

    public Produto(int codigo, String descricao, double valor, int quantidade, double valorUnitario, boolean continuado) {
        this.codigo = codigo;
        this.descricao = descricao;
        this.quantidade = quantidade;
        this.valorUnitario = valorUnitario;
        this.continuado = continuado;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(double valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public boolean isContinuado() {
        return continuado;
    }

    public void setContinuado(boolean continuado) {
        this.continuado = continuado;
    }

    @Override
    public String toString() {
        return "Código: " + codigo + "\n" +
                "Descrição: " + descricao + "\n" +
                "Valor: " + valorUnitario + "\n" +
                "Quantidade: " + quantidade + "\n" +
                "Valor unitário: " + valorUnitario + "\n" +
                "Continuado: " + (continuado ? "sim" : "não") + "\n";
    }

    //métodos que atende os requisitos
    public void registrarEntrada(int qtdEntrada){
        quantidade += qtdEntrada;
    }

    public void registrarSaida(int qtdSaida){
        if (qtdSaida > quantidade){
            throw new IllegalArgumentException("Sem quantidade suficiente para a baixa");
        }
        quantidade -= qtdSaida;
    }
}