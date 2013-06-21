package org.qi_bench.jena;

public class SPO_details {
	public String getTheURI() {
		return theURI;
	}

	public String getTheLocalName() {
		return theLocalName;
	}

	public String getTheNameSpace() {
		return theNameSpace;
	}

	private String theURI;
	private String theLocalName;
	private String theNameSpace;

	SPO_details(com.hp.hpl.jena.graph.Node theNode){
		if (theNode.isURI()) {
			theLocalName = theNode.getLocalName();
			theNameSpace = theNode.getNameSpace();
			theURI = theNode.getURI();
		}
		else if (theNode.isLiteral()) {
			theLocalName = "\"" + theNode.getLiteralLexicalForm() + "\"";
			theNameSpace = "literal";
			theURI = theNameSpace + theLocalName;
			}
		else {
		    System.out.println("Not a literal or uri");
			theLocalName = "";
			theNameSpace = "";
			theURI = "";
		}
	}
}

