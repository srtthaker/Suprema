package War_Game;

@SuppressWarnings("serial")
public class ArmoredDivision extends Troop {
	public ArmoredDivision(Nation nation, String division_Name, double level, District recruit, boolean dummy) {
		super(nation, division_Name, level, recruit, dummy);
		// TODO Auto-generated constructor stub
	}
	

	public int getRange() {
		return super.getRange() + 50;
	}

	public double getAttackPower() {
		return super.getAttackPower() - 90;
	}
}
