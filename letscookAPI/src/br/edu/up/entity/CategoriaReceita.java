/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.up.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *
 * @author G0042204
 */

@Entity
@Table(name = "LETSCOOK_CATEGORIARECEITA")
public class CategoriaReceita extends AbstractEntity{
    
    private String nome;
    
}
