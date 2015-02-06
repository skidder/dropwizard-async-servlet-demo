package async;

import async.server.AsyncServlet;
import io.dropwizard.Application;
import io.dropwizard.jetty.MutableServletContextHandler;
import io.dropwizard.setup.Environment;

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
        final MutableServletContextHandler app = env.getApplicationContext();
        app.addServlet(AsyncServlet.class, "/async");
    }

}
