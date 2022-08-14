package br.com.alura.mvc.mudi.dto;

import br.com.alura.mvc.mudi.model.Pedido;
import br.com.alura.mvc.mudi.model.StatusPedido;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class RequisicaoNovoPedido {


    @NotNull(message = "Nome não pode ser nulo")
    @NotEmpty(message = "Nome não pode ser vazio")
    private String nomeProduto;
    @NotNull(message = "URL do produto não pode ser nulo")
    @NotEmpty(message = "URL do produto não pode ser vazia")
    private String urlProduto;
    @NotNull(message = "URL da imagem não pode ser nulo")
    @NotEmpty(message = "URL da imagem não pode ser vazia")
    private String urlImagem;
    @NotNull(message = "Descricao não pode ser nulo")
    @NotEmpty(message = "Descricao não pode ser vazio")
    private String descricao;

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public String getUrlProduto() {
        return urlProduto;
    }

    public void setUrlProduto(String urlProduto) {
        this.urlProduto = urlProduto;
    }

    public String getUrlImagem() {
        return urlImagem;
    }

    public void setUrlImagem(String urlImagem) {
        this.urlImagem = urlImagem;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Pedido toPedido() {
        Pedido pedido = new Pedido();
        pedido.setNome(nomeProduto);
        pedido.setDescricao(descricao);
        pedido.setUrlDoProduto(urlProduto);
        pedido.setUrlDaImagem(urlImagem);
        pedido.setStatus(StatusPedido.AGUARDANDO);
        return pedido;
    }

}
