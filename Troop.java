package War_Game;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

@SuppressWarnings({ "serial" })
public class Troop extends JPanel implements Comparable<Troop> {
	private int x, y;
	private BufferedImage image;
	private Nation nationality;
	private String ID;
	private double XP;
	private double HP;
	private boolean fake;
	private District loc;
	protected int morale;

	/**
	 * 
	 * @param nation
	 *            - the nation that the troop serves
	 * @param division_Name
	 *            - the name of the division
	 */
	public Troop(Nation nation, String division_Name, double level, District recruit, boolean dummy) {
		fake = dummy;
		setNationality(nation);
		morale = (int) (100 + Math.random() * 10);
		ID = division_Name;
		XP = level;
		loc = recruit;
		if(loc != null)
			x = loc.getX();
			y = loc.getY();
		HP = 150 + XP * 4;
		if(this instanceof Tank)
			findImage("executable//Tank_" + nationality.getName()+ ".png");
		else if(this instanceof ArmoredDivision)
			findImage("executable//Armored Car_" + nationality.getName()+ ".png");
		else if(this instanceof Artillery)
			findImage("executable//Artillery_.png");
		else
			findImage("executable//Infantry_" + nationality.getName().toLowerCase() + ".png");
	}

	public void findImage(String name) {
		try {
			if((new File(name)).exists())
				image = (ImageIO.read(new File(name)));
			else if((new File(name.replace(nationality.getName(),""))).exists())
				image = (ImageIO.read(new File(name.replace(nationality.getName(),""))));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception x) {
		}
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		if (image != null) {
			g.drawImage(getImage(), x - image.getWidth() / 2, y - image.getHeight() + 5, null);
			if(this instanceof Commando)
				g.drawString("C", x, y);
			if(this instanceof HeavyTank)
				g.drawString("H", x, y);
			if(this instanceof SPG)
				g.drawString("SPG", x, y);
			if(this instanceof RocketArtillery)
				g.drawString("R", x, y);
		}
		g.setColor(null);
	}

	public int getCost() {
		if(!fake)
			return 100;
		else
			return 50;
	}

	public double getHP() {
		return HP;
	}

	public double getAttackPower() {
		return (100 + XP * XP);
	}

	public BufferedImage getImage() {
		return image;
	}

	public String getName() {
		return ID;
	}

	public void die() {
		x = Integer.MAX_VALUE;
		y = Integer.MAX_VALUE;
	}

	public void setName(String name) {
		ID = name;
	}

	public int getRange() {
		return 100;
	}

	public double getExperience() {
		return XP;
	}

	public void gainBattleXP(Troop defeated) {
		if(defeated instanceof HeavyTank)
			XP += .7;
		if (defeated instanceof Tank)
			XP += .55;
		else if(defeated instanceof ArmoredDivision)
			XP += .4;
		else if (defeated instanceof Artillery)
			XP += .3;
		else
			XP += .2;
	}

	public District getDistrict() {
		return loc;
	}

	public int[] getLoc() {
		return new int[] { loc.getX(), loc.getY() };
	}

	/**
	 * checks if the Troop division is still alive
	 * 
	 * @return true if HP is less than or equal to 0
	 */
	public boolean dead() {
		return HP <= 0;
	}

	/**
	 * The fight method, the defender always gets to strike first
	 * 
	 * @param other
	 *            - the defender Troop
	 */
	public void fight(Troop other) {
		if (!dead() && !other.dead()) {
			HP -= other.getAttackPower();
			if (dead()) {
				die();
				other.gainBattleXP(this);
				other.morale += 40;
				JOptionPane.showMessageDialog(new JFrame(), this + " has defeated fallen");
			} else {
				morale -= 10;
				other.fight(this);
			}
		} else if (!dead() && other.dead()) {
			other.die();
			morale += 80;
			gainBattleXP(other);
			moveTo(other.getDistrict());
			JOptionPane.showMessageDialog(new JFrame(), ID + " has defeated " + other.getName());
		}
	}

	/**
	 * returns a string representation of the Troop name and location
	 * 
	 * @return the name + location
	 */
	public String toString() {
		return ID + " (" + loc.getX() + ", " + loc.getY() + ") ";
	}

	/**
	 * moves the troop to a different District
	 * 
	 * @param d
	 *            - the district it intends to move to
	 */
	public void moveTo(District d) {
		if (canMoveTo(d)) {
			x = d.getX();
			y = d.getY();
		} else {
			JOptionPane.showMessageDialog(new JFrame(), "this unit cannot move to this district");
		}

	}

	private boolean canMoveTo(District d) {
		return Math.sqrt((x - d.getX()) * (x - d.getX()) + (y - d.getY()) * (y - d.getY())) <= getRange() && !d.isOccupied();
	}

	/**
	 * troop runs away from duty; called each turn 50% chance of defecting if
	 * morale is low
	 */
	public void defect() {
		if (morale < 30 && Math.random() < .5) {
			JOptionPane.showMessageDialog(new JFrame(), "Unit " + ID + " has run away from duty");
			die();
		}
	}

	public Nation getNationality() {
		return nationality;
	}

	public void setNationality(Nation nationality) {
		this.nationality = nationality;
	}

	public static int compare(Troop o1, Troop o2) {
		return o1.compareTo(o2);
	}

	@Override
	public int compareTo(Troop o) {
		// TODO Auto-generated method stub
		return (int) (this.HP - ((Troop) o).getHP());
	}

	public boolean equals(Troop t) {
		return (this.HP == t.HP);
	}
}
