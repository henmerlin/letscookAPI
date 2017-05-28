/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.up.model.entity;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
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

    @ManyToOne
    private CategoriaReceita categoria;

    private String descricao;

    private String foto;

    private Integer minsPreparo;

    @Enumerated(EnumType.STRING)
    private NascionalidadeEnum nasc;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "receita")
    private List<IngredienteReceita> ingts;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "receita")
    private List<Etapa> etapas;

    @ManyToOne
    private Usuario criador;

    public Receita() {
        ingts = new ArrayList<>();
        etapas = new ArrayList<>();
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

    public NascionalidadeEnum getNasc() {
        return nasc;
    }

    public void setNasc(NascionalidadeEnum nasc) {
        this.nasc = nasc;
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

}
