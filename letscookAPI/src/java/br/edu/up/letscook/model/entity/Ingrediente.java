/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.up.letscook.model.entity;

import javax.persistence.MappedSuperclass;

/**
 *
 * @author G0042204
 */
@MappedSuperclass
public abstract class Ingrediente extends AbstractNamedEntity {

    public Ingrediente() {
    }

}