/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.up.model.entity;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author G0042204
 */
@Entity
@Table(name = "LETSCOOK_ETAPA_RECEITA")
public class Etapa extends AbstractEntity {

    private String nome;

    @ManyToOne
    private Receita rec;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "etapa", cascade = CascadeType.PERSIST)
    private List<PassoEtapa> passos;

    public Etapa() {
        passos = new ArrayList<>();
    }

    public void adicionarPasso(PassoEtapa p) {
        passos.add(p);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<PassoEtapa> getPassos() {
        return passos;
    }

    public void setPassos(List<PassoEtapa> passos) {
        this.passos = passos;
    }

    public Receita getRec() {
        return rec;
    }

    public void setRec(Receita rec) {
        this.rec = rec;
    }

}
