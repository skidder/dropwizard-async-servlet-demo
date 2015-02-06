package async;

import io.dropwizard.Application;
import io.dropwizard.setup.Environment;
import async.rest.AsyncResource;
import async.server.AsyncServlet;

/**
 * @author Scott Kidder
 * 
 */
public class AsyncServerApplication extends Application<AsyncServerConfiguration> {

    public static void main(String[] args) throws Exception {
        new AsyncServerApplication().run(args);
    }


    /*
     * (non-Javadoc)
     * 
     * @see io.dropwizard.Application#run(io.dropwizard.Configuration,
     * io.dropwizard.setup.Environment)
     */
    @Override
    public void run(AsyncServerConfiguration config, Environment env) throws Exception {
        // plain servlet
        env.getApplicationContext().addServlet(AsyncServlet.class, "/async");

        // jersey endpoint
        final AsyncResource resource = new AsyncResource();
        env.jersey().register(resource);
    }

}
