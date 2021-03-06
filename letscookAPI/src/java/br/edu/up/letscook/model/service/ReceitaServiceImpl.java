/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.up.letscook.model.service;

import br.edu.up.letscook.model.service.exception.ServiceException;
import br.edu.up.letscook.dao.FactoryDAO;
import br.edu.up.letscook.model.entity.CategoriaReceita;
import br.edu.up.letscook.model.entity.Receita;
import java.util.List;
import br.edu.up.letscook.dao.ReceitaDAO;
import br.edu.up.letscook.model.domain.BuscaInteligente;
import br.edu.up.letscook.model.domain.BuscaInteligenteImpl;
import br.edu.up.letscook.model.enums.StatusPublicacao;
import java.util.Calendar;

/**
 *
 * @author G0042204
 */
public class ReceitaServiceImpl implements ReceitaService {

    private final ReceitaDAO dao = FactoryDAO.createInterfaceReceitaDAO();

    private BuscaInteligente bserv = new BuscaInteligenteImpl();

    @Override
    public void cadastrar(Receita r) throws Exception {

        if (r.getIngts().isEmpty() || r.getEtapas().isEmpty()) {
            throw new ServiceException("RN002 - Validação de receitas");
        }
        r.setStatus(StatusPublicacao.POSTADA);
        r.setDataPublicacao(Calendar.getInstance().getTime());
        r.setDataAtualizacao(Calendar.getInstance().getTime());
        dao.cadastrar(r);
    }

    @Override
    public List<Receita> buscarPorNome(String nome) {
        return dao.buscarPorNome(nome);
    }

//    @Override
//    public List<Receita> buscarPorNacionalidade(NacionalidadeEnum nasc) {
//        return dao.buscarPorNacionalidade(nasc);
//    }
    @Override
    public List<Receita> buscarPorCategoria(CategoriaReceita cat) {
        return dao.buscarPorCategoria(cat);
    }

    @Override
    public Receita editar(Receita t) {
        t.setDataAtualizacao(Calendar.getInstance().getTime());
        return dao.editar(t);
    }

    @Override
    public void excluir(Receita t) {
        dao.excluir(t);
    }

    @Override
    public Receita buscarPorId(Receita t) throws Exception {
        return dao.buscarPorId(t);
    }

    @Override
    public List<Receita> listar() {
        return dao.listar();
    }

    @Override
    public List<Receita> buscarBemAvaliadas() {
        return dao.buscarBemAvaliadas();
    }

}
