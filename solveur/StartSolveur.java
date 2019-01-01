package csp.solveur;

import csp.generator.cspGenerator;
import csp.algo.*;
import csp.def.*;

public class StartSolveur {

	public static void main(String[] args) {
		String result;
		int success = 0;
		int i = 0;
		
		cspGenerator myGenerator = new cspGenerator(10,5,0.5);
		
		for(i =0; i < 1; i++) {
			CSP myCSP = myGenerator.generate();
			myCSP.printVar();
			myCSP.printConstraint();
			BackTracking Algo1 = new BackTracking();

			result = Algo1.compute(myCSP);
			if(result != "UNSAT") { System.out.println(result); success++;}
		}
		
		System.out.println("Taux de réussite : " + success + " / " + i);
	}
}
