package War_Game;

@SuppressWarnings("serial")
public class Artillery extends Troop{
	public Artillery(Nation nation, String name, double level, District recruit, boolean dummy)
	{
		super(nation, name, level, recruit, dummy);
	}
	public int getRange()
	{
		return 70;
	}
	public double getAttackPower()
	{
		return (200 + super.getExperience()*super.getExperience());
	}
}
