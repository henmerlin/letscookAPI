/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.up.letscook.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

/**
 *
 * @author G0042204
 */
@Entity
@Table(name = "passo_etapa")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class PassoEtapa extends AbstractEntity {

    @NotNull
    @Column(name = "descricao")
    private String descricao;

    private String dica;

    private Double minPasso;

    @NotNull
    private Integer ordem;

    @ManyToOne(optional = false)
    @JoinColumn(name = "etapa_id", nullable = false)
    private EtapaReceita etapa;

    @Transient
    private boolean checked;

    @Transient
    private boolean done;

    public PassoEtapa() {
    }

    public PassoEtapa(String desc) {
        this.descricao = desc;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getMinPasso() {
        return minPasso;
    }

    public void setMinPasso(Double minPasso) {
        this.minPasso = minPasso;
    }

    public Integer getOrdem() {
        return ordem;
    }

    public void setOrdem(Integer ordem) {
        this.ordem = ordem;
    }

    public String getDica() {
        return dica;
    }

    public void setDica(String dica) {
        this.dica = dica;
    }

    public void setEtapa(EtapaReceita etapa) {
        this.etapa = etapa;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

}
