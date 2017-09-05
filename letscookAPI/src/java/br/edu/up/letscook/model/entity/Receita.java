/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.up.letscook.model.entity;

import br.edu.up.letscook.model.enums.NacionalidadeEnum;
import br.edu.up.letscook.model.enums.StatusPublicacao;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author G0042204
 */
@Entity
@Table(name = "LETSCOOK_RECEITA")
public class Receita extends AbstractEntity {

    private String nome;

    @ManyToOne(targetEntity = CategoriaReceita.class)
    private CategoriaReceita categoria;

    private String descricao;

    private String foto;

    private Integer minsPreparo;

    @Enumerated(EnumType.STRING)
    private StatusPublicacao status;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "RECEITA_ID")
    private List<IngredienteReceita> ingts;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "RECEITA_ID")
    private List<Etapa> etapas;

    @ManyToOne(fetch = FetchType.EAGER)
    private Usuario criador;

    public Receita() {
        ingts = new ArrayList<>();
        etapas = new ArrayList<>();
        status = StatusPublicacao.PENDENTE;
    }

    public void adicionarIngrediente(IngredienteReceita i) {
        ingts.add(i);
    }

    public void adicionarEtapa(Etapa e) {
        etapas.add(e);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public CategoriaReceita getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaReceita categoria) {
        this.categoria = categoria;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public Integer getMinsPreparo() {
        return minsPreparo;
    }

    public void setMinsPreparo(Integer minsPreparo) {
        this.minsPreparo = minsPreparo;
    }

    public List<Etapa> getEtapas() {
        return etapas;
    }

    public void setEtapas(List<Etapa> etapas) {
        this.etapas = etapas;
    }

    public Usuario getCriador() {
        return criador;
    }

    public void setCriador(Usuario criador) {
        this.criador = criador;
    }

    public List<IngredienteReceita> getIngts() {
        return ingts;
    }

    public void setIngts(List<IngredienteReceita> ingts) {
        this.ingts = ingts;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public StatusPublicacao getStatus() {
        return status;
    }

    public void setStatus(StatusPublicacao status) {
        this.status = status;
    }

}
