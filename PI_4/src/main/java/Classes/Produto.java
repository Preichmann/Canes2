/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.util.ArrayList;

/**
 *
 * @author nik_r
 */
public class Produto{
    private int idProd;
    private String nome;
    private double preco;
    private String descricao;
    private String nomeImg;
    private int idImg;
    private int quantidade;
    private int idUsuário;
    private boolean status;

    public Produto(String nome, double preco, String descricao, int quantidade, boolean status) {
        this.nome = nome;
        this.preco = preco;
        this.descricao = descricao;
        this.quantidade = quantidade;
        this.status = status;
    }

    public Produto(int idProd, String nome, double preco, String descricao, String nomeImg, int idImg, int quantidade, int idUsuário, boolean status) {
        this.idProd = idProd;
        this.nome = nome;
        this.preco = preco;
        this.descricao = descricao;
        this.nomeImg = nomeImg;
        this.idImg = idImg;
        this.quantidade = quantidade;
        this.idUsuário = idUsuário;
        this.status = status;
    }

    public String getNomeImg() {
        return nomeImg;
    }

    public void setNomeImg(String nomeImg) {
        this.nomeImg = nomeImg;
    }

    public int getIdImg() {
        return idImg;
    }

    public void setIdImg(int idImg) {
        this.idImg = idImg;
    }

    public int getIdUsuário() {
        return idUsuário;
    }

    public void setIdUsuário(int idUsuário) {
        this.idUsuário = idUsuário;
    }
    
    public Produto() {
    }
    
    public Produto(int idProd, String nome, double preco, String descricao, int quantidade, boolean status) {
		super();
		this.idProd = idProd;
		this.nome = nome;
		this.preco = preco;
		this.descricao = descricao;
		this.quantidade = quantidade;
		this.status = status;
	}


	public int getIdProd() {
        return idProd;
    }

    public void setIdProd(int idProd) {
        this.idProd = idProd;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
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

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
