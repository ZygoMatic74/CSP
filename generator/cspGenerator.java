package csp.generator;

import java.util.ArrayList;
import java.util.Random;

import csp.def.*;

public class cspGenerator {
	public int V;
	public int D;
	public double C;
	
	public cspGenerator(int V, int D, double C){
		this.V = V;
		this.D = D;
		this.C = C;
	}
	
	public CSP generate() {
		
		ArrayList<Variable> myVariableArray = new ArrayList<Variable>();
		ConstraintList[][] myConstraintArray = new ConstraintList[V][V];
		
		generateVariables(myVariableArray, V, D);
		generateConstraint(myConstraintArray,myVariableArray,C);
		
		CSP myCSP = new CSP(myVariableArray,myConstraintArray,V);
		return myCSP;
	}

	private void generateConstraint(ConstraintList[][] myConstraintArray, ArrayList<Variable> myVariableArray, double durete) {
		// TODO Auto-generated method stub
		ArrayList<Integer> temp = new ArrayList<Integer>();
		for(int i = 0; i < V; i ++) {
			for(int j = i; j < V; j++) {
				if(i !=j) {
					myConstraintArray[i][j] = new ConstraintList(generateConstraintList(myVariableArray.get(i), myVariableArray.get(j),C));
					temp.add(i * V + j);
				}
			}
		}
		
		Random rnd = new Random();
		
		int nbConstraint = temp.size();
		
		int maxConstraint = (int) Math.round(nbConstraint * durete);
		
		while(temp.size() > maxConstraint) {
			
			int indice = rnd.nextInt(temp.size());
			
			int column = temp.get(indice) % V;
			int row = temp.get(indice) / V;
			myConstraintArray[row][column] = null;
			
			temp.remove(indice);
		}
	}

	private ArrayList<Constraint> generateConstraintList(Variable variable, Variable variable2, double durete) {
		// TODO Auto-generated method stub
		ArrayList<Constraint> result = new ArrayList<Constraint>();
		
		for(int i = 0; i < D; i++) {
			for(int j = 0; j < D; j++) {
				Constraint c = new Constraint(variable.myDomaine.get(i),variable2.myDomaine.get(j));
				result.add(c);
			}
		}
		
		Random rnd = new Random();
		int maxSize = (int) Math.round(result.size() * durete);
		
		while(result.size() > maxSize) {
			result.remove(rnd.nextInt(result.size()));
		}
		
		return result;
	}

	private void generateVariables(ArrayList<Variable> myVariableArray, int V, int D) {
		// TODO Auto-generated method stub
		for(int i = 0; i < V; i++) {
			String name = "V" + i;
			ArrayList<Integer> myDomaine = new ArrayList<Integer>();
			
			for(int j = 0; j < D; j++) {
				myDomaine.add(j);
			}
			
			Variable newVariable = new Variable(name,myDomaine);
			myVariableArray.add(newVariable);
		}
	}
}
