package org.qi_bench.api.root;

import org.qi_bench.api.domain.Customer;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.StreamingOutput;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.URI;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@Path("/version")
public class VersionResource {

    public VersionResource() {
    }

        // Handle the version request. If there is an explicit request for JSON in an accept
        //  header then honor the request otherwise return XML as the default.
   @GET
   public StreamingOutput VersionXmlInterface(final @HeaderParam("accept") @DefaultValue("header") String HPValue) {
        if (HPValue.equals("application/json")) {   // The only way to get JSON is explicit request in an accept header
            return new StreamingOutput() {
                public void write(OutputStream outputStream) throws IOException, WebApplicationException {
                    PrintStream writer = new PrintStream(outputStream);
                    writer.println("{\"qi-bench-api\": { \"version\": \"1.0\" }}");
                }
            };
        }
        return new StreamingOutput() {
            public void write(OutputStream outputStream) throws IOException, WebApplicationException {
                PrintStream writer = new PrintStream(outputStream);
                writer.println("<qi-bench-api>");
                writer.println("    <version>1.0</version>");
                writer.println("</qi-bench-api>");
            }
        };
   }

}
