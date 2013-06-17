package org.qi_bench.api.root;

import org.qi_bench.api.domain.ServeStaticFile;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.StreamingOutput;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;

@Path("/")
public class ElectronicRegulatoryPortalsResource {

    public ElectronicRegulatoryPortalsResource() {
    }

        // Handle the request. If there is an explicit request for XML in an accept
        //  header then honor the request otherwise return JSON as the default.
    @GET
    @Path("electronic-regulatory-portals")
    public StreamingOutput ResourceInterface(@HeaderParam("accept") @DefaultValue("application/json") String HPValue) {
        if (HPValue.equals("application/xml")) {   // The only way to get XML is explicit request in an accept header
            return new StreamingOutput() {
                public void write(OutputStream outputStream) throws IOException, WebApplicationException {
                    PrintStream writer = new PrintStream(outputStream);
                    writer.println("<qi-bench-api>");
                    writer.println("    <electronic-regulatory-portals>NOT YET IMPLEMENTED</electronic-regulatory-portals>");
                    writer.println("</qi-bench-api>");
                }
            };
        }
        return new StreamingOutput() {
            public void write(OutputStream outputStream) throws IOException, WebApplicationException {
                PrintStream writer = new PrintStream(outputStream);
                writer.println("{\"qi-bench-api\": " +
                               "{\"electronic-regulatory-portals\": \"NOT YET IMPLEMENTED\"" +
                               "}}");
            }
        };
    }

    @GET
    @Path("api-docs/electronic-regulatory-portals")
    @Produces("application/json")
    public StreamingOutput SO_API_DOCS_JSON() {
        ServeStaticFile ssf = new ServeStaticFile();
        return ssf.StaticFile("apiDocs/electronic-regulatory-portals.json");
    }

}
