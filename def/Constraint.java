package csp.def;

public class Constraint {
	public int x;
	public int y;
	
	public Constraint (int v1, int v2) {
		x = v1;
		y = v2;
	}

	public void printConstraint() {
		// TODO Auto-generated method stub
		System.out.print("( " + x + ", " + y + " )");
	}
}
