package Rest;

import DAO.UsuarioDAO;
import Model.Usuario;
import java.util.Collection;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("usuario")
public class UsuarioRest {
    private UsuarioDAO dao = new UsuarioDAO();

    public UsuarioRest() {
    }
    
    @Path("/listar")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Usuario> listar_GET(){
        return dao.findAll();
    }
    
    @Path("/buscar/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Usuario buscar_GET(@PathParam("id") int id){
        Usuario usuario = dao.findById(id);
        
        if (usuario == null){
            throw new WebApplicationException(404);
        }
        
        return usuario;
    }
    
    @Path("/registrar")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response registrar_POST(Usuario usuario){
        dao.insert(usuario);
        return Response.status(Response.Status.OK).entity("usuario registrado").build();
    }
    
    @Path("/editar/{id}")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response editar_PUT(@PathParam("id") int id, Usuario usuario){
        Usuario usuarioDb = dao.findById(id);
        
        if (usuarioDb != null){
            usuario.setId(id);
            dao.update(usuario);
            
            return Response.status(Response.Status.OK).entity("usuario actualizado").build();
        }
        throw new WebApplicationException(404);
    }
    
    @Path("/borrar/{id}")
    @DELETE
    @Produces(MediaType.TEXT_PLAIN)
    public Response borrar_DELETE(@PathParam("id") int id){
        Usuario usuarioDb = dao.findById(id);
        
        if (usuarioDb != null){
            dao.delete(id);
            return Response.status(Response.Status.OK).entity("usuario eliminado").build();
        }
        throw new WebApplicationException(404);
    }
}
