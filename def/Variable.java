package csp.def;

import java.util.ArrayList;

public class Variable {
	public String myName;
	public ArrayList<Integer> myDomaine;
	
	public Variable (String name, ArrayList<Integer> domaine) {
		myName = name;
		myDomaine = domaine;	
	}
	
	public void printVar() {
		System.out.print(myName + " ");
		System.out.println(myDomaine);
	}
}
