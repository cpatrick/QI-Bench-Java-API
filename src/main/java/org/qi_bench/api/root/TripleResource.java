package org.qi_bench.api.root;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.StreamingOutput;
import org.qi_bench.api.domain.ServeStaticFile;

@Path("/")
public class TripleResource {

    public TripleResource() {
    }

        // Handle the request. If there is an explicit request for XML in an accept
        //  header then honor the request otherwise return JSON as the default.
    @GET
    @Path("triple/{id}")
    public StreamingOutput ResourceInterface(final @PathParam("id") int id,
                                             @HeaderParam("accept") @DefaultValue("application/json") String HPValue) {
        if (HPValue.equals("application/xml")) {   // The only way to get XML is explicit request in an accept header
            return new StreamingOutput() {
                public void write(OutputStream outputStream) throws IOException, WebApplicationException {
                    PrintStream writer = new PrintStream(outputStream);
                    writer.println("<qi-bench-api>");
                    writer.println("    <triple>");
                    writer.println("        <id>" + id + "</id>");
                    writer.println("        <data>NOT YET IMPLEMENTED</data>");
                    writer.println("    </triple>");
                    writer.println("</qi-bench-api>");
                }
            };
        }
        return new StreamingOutput() {
            public void write(OutputStream outputStream) throws IOException, WebApplicationException {
                PrintStream writer = new PrintStream(outputStream);
                writer.println("{\"qi-bench-api\": " +
                               "{\"triple\": {" +
                               "\"id\": \"" + id + "\"," +
                               "\"data\": \"NOT YET IMPLEMENTED\"" +
                               "}}}");
            }
        };
    }

    @GET
    @Path("api-docs/triple")
    @Produces("application/json")
    public StreamingOutput SO_API_DOCS_JSON() {
        ServeStaticFile ssf = new ServeStaticFile();
        return ssf.StaticFile("apiDocs/triple.json");
    }

}
