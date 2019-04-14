
package mall.fo.board.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


@Component
@Path("/hello")
public class NoticeBoardController {
	
	static final Logger logger = LoggerFactory.getLogger(NoticeBoardController.class);
	
    @GET
    public String hello() {
        return "Hello Jersey";
    }
    
//    @GET
//    @Path("/test")
//    @Produces(MediaType.APPLICATION_JSON)
//    public Response hello() {
//    	String output = "Hello Jersey!";
//    	return Response.status(200).entity(output).build();
//    }
	
}
