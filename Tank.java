package War_Game;

@SuppressWarnings("serial")
public class Tank extends ArmoredDivision {
	public Tank(Nation nation, String division_Name, double level, District recruit, boolean dummy) {
		super(nation, division_Name, level, recruit, dummy);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int getRange() {
		return super.getRange() + 50;
	}

	public double getAttackPower() {
		return (200 + super.getExperience() * super.getExperience());
	}
}
