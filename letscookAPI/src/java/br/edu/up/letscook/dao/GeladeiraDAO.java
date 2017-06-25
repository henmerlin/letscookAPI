/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.up.letscook.dao;

import br.edu.up.letscook.model.entity.Dispensa;
import br.edu.up.letscook.model.entity.Usuario;
import java.util.List;

/**
 *
 * @author G0042204
 */
public class GeladeiraDAO extends AbstractHibernateDAO implements InterfaceGeladeiraDAO<Dispensa> {

    @Override
    public void cadastrar(Dispensa g) {
        super.persist(g);
    }

    @Override
    public void excluir(Dispensa g) {
        super.remove(g);
    }

    @Override
    public Dispensa editar(Dispensa g) {
        super.merge(g);
        return g;
    }

    @Override
    public List<Dispensa> listar(Dispensa g) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Dispensa buscarPorId(Dispensa g) {
        return em.find(Dispensa.class, g.getId());
    }

    @Override
    public Dispensa buscarPorUsuario(Usuario u) {
        try {
            return (Dispensa) em.createQuery("FROM Geladeira g WHERE g.dono = :param")
                    .setParameter("param", u)
                    .getSingleResult();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

}
