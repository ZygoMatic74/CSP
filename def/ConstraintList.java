package csp.def;

import java.util.ArrayList;

public class ConstraintList {
	public ArrayList<Constraint> myList;
	
	public ConstraintList(ArrayList<Constraint> list){
		myList = list;
	}

	public void printConstraint() {
		// TODO Auto-generated method stub
		for(int i = 0; i < myList.size(); i++) {
			myList.get(i).printConstraint();
		}
	}
	
	public Boolean Exist(int x, int y) {
		Boolean tamp = false;
		for(Constraint current : myList) {
			if(current.x == x && current.y == y) {
				tamp = true;
			}
		}
		return tamp && true;
	}
}
