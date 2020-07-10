package org.dominokit.rest.example.shared;

import org.dominokit.domino.rest.shared.request.service.annotations.RequestFactory;

import javax.ws.rs.*;
import java.util.List;

@RequestFactory
@Path("/service/api/persons")
public interface PersonService {

    @Path("")
    @POST
    @Produces("application/json")
    @Consumes("application/json")
    Person create(Person person);

    @Path("/{id}")
    @DELETE
    void delete(@PathParam("id") Long id);

    @Path("/{id}")
    @PUT
    @Produces("application/json")
    @Consumes("application/json")
    Person update(@PathParam("id") Long id, Person person);

    @Path("")
    @GET
    @Produces("application/json")
    List<Person> list();

    @Path("/{id}")
    @GET
    @Produces("application/json")
    Person load(@PathParam("id") Long id);
}
