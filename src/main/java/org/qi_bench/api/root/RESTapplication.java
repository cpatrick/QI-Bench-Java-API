package org.qi_bench.api.root;

import org.qi_bench.jena.TripleDisplay;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

@ApplicationPath("/")
public class RESTapplication extends Application {
   private Set<Object> singletons = new HashSet<Object>();

   public RESTapplication() {
      singletons.add(new AssayMethodsResource());
      singletons.add(new AssertionsResource());
      singletons.add(new BiomarkersResource());
      singletons.add(new BuildDateResource());
      singletons.add(new ClinicalContextsResource());
      singletons.add(new ComputeServicesResource());
      singletons.add(new DataServicesResource());
      singletons.add(new DataSetsResource());
      singletons.add(new ElectronicRegulatoryPortalsResource());
      singletons.add(new HypothesesResource());
      singletons.add(new InstancesResource());
      singletons.add(new InvestigationsResource());
      singletons.add(new ObservationsResource());
      singletons.add(new OntologiesResource());
      singletons.add(new QueriesResource());
      singletons.add(new RegulatoryDocumentsResource());
      singletons.add(new SwaggerBase());
      singletons.add(new TripleDisplay());
      singletons.add(new TripleResource());
      singletons.add(new TriplesResource());
      singletons.add(new VersionResource());
      singletons.add(new WorkflowManagersResource());
      singletons.add(new WorkflowsResource());
   }

   @Override
   public Set<Object> getSingletons() {
      return singletons;
   }
}
