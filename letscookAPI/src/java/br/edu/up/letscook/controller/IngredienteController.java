/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.up.letscook.controller;

import br.edu.up.letscook.model.entity.Ingrediente;
import br.edu.up.letscook.model.service.FactoryService;
import br.edu.up.letscook.model.service.InterfaceService;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

/**
 *
 * @author G0042204
 */
@Path("/ingrediente")
public class IngredienteController {

    private InterfaceService<Ingrediente> serv = FactoryService.createInterfaceIngredienteService();

    public IngredienteController() {
    }

    @POST
    @Path("add")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response cadastrar(Ingrediente r) {
        try {
            serv.cadastrar(r);
            return Response.status(Status.OK).entity(r).build();
        } catch (Exception e) {
            return Response.status(Status.INTERNAL_SERVER_ERROR).entity(e).build();
        }
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getIngrediente(@PathParam("id") int id) {
        try {
            Ingrediente r = new Ingrediente();
            r.setId(new Long(id));
            return Response.status(Status.OK).entity(serv.buscarPorId(r)).build();
        } catch (Exception e) {
            return Response.status(Status.INTERNAL_SERVER_ERROR).entity(e).build();
        }
    }

}
