/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.up.letscook.dao;

import br.edu.up.letscook.dao.exception.UsuarioInexistenteException;
import br.edu.up.letscook.model.entity.Usuario;

/**
 *
 * @author G0042204
 */
public interface UsuarioDAO extends GenericDAO<Usuario> {

    public Usuario buscarPorEmail(Usuario u) throws UsuarioInexistenteException;

}
