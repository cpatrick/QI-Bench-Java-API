/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.qi_bench.jena;

import com.hp.hpl.jena.query.Dataset;
import com.hp.hpl.jena.query.ReadWrite;
import com.hp.hpl.jena.sparql.core.Quad;
import com.hp.hpl.jena.tdb.TDBFactory;
import com.hp.hpl.jena.tdb.base.file.Location;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Iterator;
import java.util.ArrayList;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.StreamingOutput;


@Path("/TripleTest")
public class TripleDisplay {

    public TripleDisplay() {
    }

    static final String BetweenNameElements = "&nbsp;&nbsp;&nbsp;";
    static final String EndOfDoc = "</div></body></html>";
    static final String StartOfDoc = "<?xml version=\"1.0\" encoding=\"utf-8\"?>" +
    "<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Strict//EN\"" +
    "    \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd\">" +
    "<html xmlns='http://www.w3.org/1999/xhtml' xml:lang='en' lang='en'>" +
    "<head><meta http-equiv=\"content-type\" content=\"text/html; charset=utf-8\" />" +
    "<title>QI-Bench Jena TDB Contents</title><link rel='stylesheet' href='css/qibench.css' type='text/css' />" +
    "</head><body><div id='main'>";

    private static String MakeCell(String NS, String LN) {
        return "<span class='NS'>" + NS + "</span>" + 
        BetweenNameElements +
        "<span class='LN'>" + LN + "</span>";
    }


    @GET
    public StreamingOutput ResourceInterface() {

            // Create an ArrayList to hold all of the output until the very end.
        final ArrayList<String> tripleArray = new ArrayList<String>();
            // Define the location of the TDB store
        Location location = new Location ("/projects/qibenchStore");
            // Create the linkage to the TDB store
        Dataset dataset = TDBFactory.createDataset(location);

            // Operate on the store
        dataset.begin(ReadWrite.READ);
        try {
                // Create the table and rows
            tripleArray.add(StartOfDoc);
            Iterator<Quad> iter = dataset.asDatasetGraph().find();
            while ( iter.hasNext() ) {
                Quad quad = iter.next();
                SPO_details mySubject = new SPO_details (quad.getSubject());
                SPO_details myPredicate = new SPO_details (quad.getPredicate());
                SPO_details myObject = new SPO_details (quad.getObject());
                tripleArray.add("<div class='triple'>");
                tripleArray.add("<div class='subject'>" + MakeCell(mySubject.getTheNameSpace(), mySubject.getTheLocalName()) + "</div>");
                tripleArray.add("<div class='predicate'>" + MakeCell(myPredicate.getTheNameSpace(), myPredicate.getTheLocalName()) + "</div>");
                tripleArray.add("<div class='object'>" + MakeCell(myObject.getTheNameSpace(), myObject.getTheLocalName()) + "</div>");
                tripleArray.add("</div>");
            }
        } finally {
            dataset.end();
            tripleArray.add(EndOfDoc);
        }

        return new StreamingOutput() {
            public void write(OutputStream outputStream) throws IOException, WebApplicationException {
                    // All the output is in "tripleArray" and can be sent to the reader
                PrintStream writer = new PrintStream(outputStream);
                for (int index = 0; index < tripleArray.size(); index++) {
                    writer.println(tripleArray.get(index));
                }
            }
        };
    }

}
