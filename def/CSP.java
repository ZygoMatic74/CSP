package csp.def;

import java.util.ArrayList;

public class CSP{
	
	public ArrayList<Variable> myVariables;
	public ConstraintList[][] myConstraints;
	
	public CSP() {
		
	}
	
	public CSP(ArrayList<Variable> variables, ConstraintList[][] constraints,int V) {
		myVariables = variables;
		
		myConstraints = new ConstraintList[V][V];
		myConstraints = constraints;
	}
	
	public void printVar() {
		for(int i = 0; i < myVariables.size(); i++) {
			myVariables.get(i).printVar();
		}
	}
	
	public void printConstraint() {
		for(int i = 0; i < myVariables.size();i++) {
			for(int j = 0; j < myVariables.size();j++) {
				if(myConstraints[i][j] != null) {
					System.out.print("Contrainte " + i + " -> " + j + " : [");
					myConstraints[i][j].printConstraint();
					System.out.println("]");
				}
			}
		}
	}
}
