package org.qi_bench.api.domain;

import javax.ws.rs.*;
import javax.ws.rs.core.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.URI;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;


public class ServeStaticFile {

    public ServeStaticFile() {
    }

    public StreamingOutput StaticFile(final String theFileName) {
        return new StreamingOutput() {
            public void write(OutputStream outputStream) throws IOException, WebApplicationException {
                PrintStream writer = new PrintStream(outputStream);
                InputStream in = null;

                try{
                    in = this.getClass().getClassLoader().getResourceAsStream(theFileName);
                    BufferedReader ibr = new BufferedReader( new InputStreamReader(in) );
                    String l;
                    while ((l=ibr.readLine()) != null) {
                        writer.println(l);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    if (in != null) {
                        try{
                            in.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        };
    }

}
