package async.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.container.Suspended;
import javax.ws.rs.core.MediaType;

/**
 * @author Scott Kidder
 * 
 */
@Path("/rest")
public class AsyncResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public void get(@Suspended final AsyncResponse response) {
        new Runnable() {
            public void run() {
                // sleep for 10 seconds
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                response.resume("Hello World!");
            }
        }.run();
    }
}
