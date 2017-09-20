/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.up.letscook.model.entity;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

/**
 *
 * @author G0042204
 */
@Entity
@Table(name = "etapa_receita")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class EtapaReceita extends AbstractNamedEntity {

    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "etapa_id", referencedColumnName = "id")
    private List<PassoEtapa> passos;

    @NotNull
    private Integer ordem;

    @ManyToOne(optional = false)
    @JoinColumn(name = "receita_id", nullable = false)
    private Receita receita;

    public EtapaReceita() {
        passos = new ArrayList<>();
    }

    public void adicionarPasso(PassoEtapa p) {
        passos.add(p);
    }

    public List<PassoEtapa> getPassos() {
        return passos;
    }

    public void setPassos(List<PassoEtapa> passos) {
        passos.forEach((t) -> {
            t.setEtapa(this);
        });
        this.passos = passos;
    }

    public Integer getOrdem() {
        return ordem;
    }

    public void setOrdem(Integer ordem) {
        this.ordem = ordem;
    }

    public Receita getReceita() {
        return receita;
    }

    public void setReceita(Receita receita) {
        this.receita = receita;
    }

}
