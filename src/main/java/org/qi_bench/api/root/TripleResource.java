package org.qi_bench.api.root;

import com.hp.hpl.jena.query.Dataset;
import com.hp.hpl.jena.query.ReadWrite;
import com.hp.hpl.jena.sparql.core.Quad;
import com.hp.hpl.jena.tdb.TDBFactory;
import com.hp.hpl.jena.tdb.TDBLoader;
import com.hp.hpl.jena.tdb.base.file.Location;
import com.hp.hpl.jena.tdb.sys.TDBInternal;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;

import javax.json.Json;
import javax.json.stream.JsonParser;
import javax.json.stream.JsonParser.Event;
import javax.ws.rs.Consumes;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.POST;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.StreamingOutput;

import org.qi_bench.api.domain.ServeStaticFile;
import org.qi_bench.api.domain.Triple;

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

    @POST
    @Path("triple")
    @Consumes("application/json")
    public Response createTriple(InputStream is) {
        Triple triple = readTriple(is);

        String ntTriple = "<http://example.org/" +
                          triple.getSubject() + "> <http://example.org/" +
                          triple.getPredicate() + "> <http://example.org/" +
                          triple.getObject() + "> .";
System.out.println("The stream is... |" + ntTriple + "|");
        ByteArrayInputStream tripleStream = null;
        try {
            tripleStream = new ByteArrayInputStream(ntTriple.getBytes("UTF-8"));
        } catch (Exception e) {
            System.out.println("exception on the stream");
            throw new WebApplicationException(e, Response.Status.BAD_REQUEST);
        }


            // Define the location of the TDB store
        Location location = new Location ("/projects/qibenchStore");
            // Create the linkage to the TDB store
        Dataset dataset = TDBFactory.createDataset(location);


            // Load the new triple
        TDBLoader.load(TDBInternal.getBaseDatasetGraphTDB(TDBFactory.createDatasetGraph(location)), tripleStream, false);



        return Response.status(200).entity("Created triple:" +
                                           "\n   S: " + triple.getSubject() +
                                           "\n   P: " + triple.getPredicate() +
                                           "\n   O: " + triple.getObject()).build();
    }


    @GET
    @Path("api-docs/triple")
    @Produces("application/json")
    public StreamingOutput SO_API_DOCS_JSON() {
        ServeStaticFile ssf = new ServeStaticFile();
        return ssf.StaticFile("apiDocs/triple.json");
    }




   protected Triple readTriple(InputStream is) {

      try
      {
         JsonParser         ourParser = Json.createParser(is);
         Triple             ourTriple = new Triple();
         Event              event = ourParser.next();    // START_OBJECT
         String             curKEY = "";
         while (ourParser.hasNext())
         {
            event = ourParser.next();   // this should be a KEY_NAME
            if (event == Event.KEY_NAME) {
                curKEY = ourParser.getString().toLowerCase();
                event = ourParser.next();   // If the above was a KEY_NAME we should
                                            // have a VALUE_STRING here
                if (event == Event.VALUE_STRING) {
                    if ("subject".equals(curKEY)) {
                        ourTriple.setSubject(ourParser.getString());
                    } else if ("predicate".equals(curKEY)){
                        ourTriple.setPredicate(ourParser.getString());
                    } else if ("object".equals(curKEY)){
                        ourTriple.setObject(ourParser.getString());
                    }
                }
            }
         }
            // make sure we have a triple here and then return it
            // need to do this but how is not obvious to me at the moment (need to understand Java better)
         return ourTriple;
      }
      catch (Exception e)
      {
         throw new WebApplicationException(e, Response.Status.BAD_REQUEST);
      }
   }




}
