This project is main portion of the QI-Bench application service. It includes
a RESTful interface and documentation, RDF triple store, external data services,
and more (To be enumerated and described later.)


System Assumptions:
====================
- Maven 2.0.9 or higher
- JBoss AS 7.1.1 or higher running standalone.
- RESTEasy will be pulled in during the build process.
- The path /projects/qibenchStore/ exists and is writable by the JBoss proces.

System preparations:
=====================
1. Set up JBoss to serve pages from its root rather than showing its welcome screen.
   - Find the file standalone.xml. In JBoss AS 7.1.1 the file is found at
     /<jboss installation base>/standalone/configuration/standalone.xml.
   - Change the attribute
     <server>
        <profile>
            <subsystem xmlns="urn:jboss:domain:web:1.1" default-virtual-server="default-host" native="false">
               <virtual-server name="default-host" enable-welcome-root="true">  <== FROM
               <virtual-server name="default-host" enable-welcome-root="false"> <== TO
     The allows JBoss to serve our pages at the root location rather than serving the
     default "Welcome to JBoss" screen.
2. This step intentionally left blank
   (Take a bio-break or get something to require one later.)
3. If /projects/qibenchStore/ does not exist, create it and ensure it is writable by
   the JBoss process.

Building the project:
====================
1. Start JBoss AS 7 manually
2. In root directory of this project build the WAR by running
    mvn clean package
3. Deploy ROOT.war in JBoss.
4. RESTful interface documentation is found at the root of the JBoss site where
   a welcome screen normally exists (e.g. http://localhost:8080)
