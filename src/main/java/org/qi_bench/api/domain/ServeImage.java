package org.qi_bench.api.domain;

import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;


public class ServeImage {

    public ServeImage() {
    }

    public StreamingOutput StreamImage(final String theFileName) {
        return new StreamingOutput() {
            public void write(OutputStream outputStream) throws IOException, WebApplicationException {
                PrintStream writer = new PrintStream(outputStream);
                InputStream in = null;

                try{
                    int c;

                    in = this.getClass().getClassLoader().getResourceAsStream(theFileName);
                    while ((c = in.read()) != -1) {
                        writer.write(c);
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
