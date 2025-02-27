package br.unitins.tp1.controller;

import java.util.List;

import br.unitins.tp1.model.Marca;
import br.unitins.tp1.service.MarcaService;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/marcas") // Endpoint
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class MarcaController {

    @Inject
    MarcaService marcaService;

    // Endpoint para listar todas as marcas
    @GET
    public Response listarTodasMarcas() {
        List<Marca> marcas = marcaService.listarTodasMarcas();
        return Response.ok(marcas).build();
    }

    // Endpoint para buscar uma marca pelo ID
    @GET
    @Path("/{id}")
    public Response buscarMarcaPorId(@PathParam("id") Long id) {
        Marca marca = marcaService.buscarMarcaPorId(id);
        if (marca == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(marca).build();
    }

    // Endpoint para salvar uma nova marca
    @POST
    @Transactional
    public Response salvarMarca(Marca marca) {
        Marca novaMarca = marcaService.salvarMarca(marca);
        return Response.status(Response.Status.CREATED).entity(novaMarca).build();
    }

    // Endpoint para atualizar uma marca
    @PUT
    @Path("/{id}")
    @Transactional
    public Response atualizarMarca(@PathParam("id") Long id, Marca marca) {
        Marca marcaAtualizada = marcaService.atualizarMarca(id, marca);
        if (marcaAtualizada == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(marcaAtualizada).build();
    }

    // Endpoint para excluir uma marca
    @DELETE
    @Path("/{id}")
    @Transactional
    public Response excluirMarca(@PathParam("id") Long id) {
        boolean excluida = marcaService.excluirMarca(id);
        if (!excluida) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.noContent().build();
    }
}
