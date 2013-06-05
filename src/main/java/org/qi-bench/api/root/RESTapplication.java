package org.qi_bench.api.root;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

@ApplicationPath("/")
public class RESTapplication extends Application {
   private Set<Object> singletons = new HashSet<Object>();

   public RESTapplication() {
      singletons.add(new BuildDateResource());
      singletons.add(new VersionResource());
   }

   @Override
   public Set<Object> getSingletons() {
      return singletons;
   }
}
