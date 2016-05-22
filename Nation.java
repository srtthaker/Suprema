package War_Game;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

public class Nation {
	private String Name;
	private WarGameBoard ref;
	private ArrayList<District> districts;
	private ArrayList<Troop> troops;
	private int capital[];
	private int PPPWealth;
	// private boolean teamAllies;

	/**
	 * 
	 * @param nam
	 *            - name of the nation
	 * @param allied
	 *            - true if on the side of the allies, otherwise false
	 */
	public Nation(String nam) {
		Name = nam;
		ref = new WarGameBoard();
		capital = getCapital();
		districts = new ArrayList<District>();
		setDistricts();
		PPPWealth = getWealth();
		troops = new ArrayList<Troop>();
		if (districts != null && districts.size() > 0) {
			setTroops();
			setTanks();
			setArmoredCars();
		}
	}
	
	public ArrayList<Troop> getTroops() {
		return troops;
	}

	public void add(Troop troop) {
		purchase(troop);
		troops.add(troop);
	}

	public String getName() {
		return Name;
	}

	public void addIncome() {
		for (District d : districts)
			PPPWealth += d.getIncome();
	}

	public boolean canBuy(Troop t) {
		return (PPPWealth - t.getCost() >= 0);
	}

	public boolean canBuy(int cost) {
		return (PPPWealth - cost >= 0);
	}

	public void purchase(Troop t) {
		if (canBuy(t))
			PPPWealth -= t.getCost();
	}

	public void purchase(int cost) {
		if (canBuy(cost))
			PPPWealth -= cost;
	}

	public void setTroops() {
		switch (Name) {
		case "Russia":
			for (int i = 1; i < 8; i++) {
				District d = districts.get((int) (Math.random() * districts.size()));
				if (!d.isOccupied())
					troops.add(new Troop(this, "Russia" + i + "", (int) (5 * Math.random()), d, false));
				else
					i--;
			}
			break;
		case "India":
			for (int i = 1; i < 13; i++) {
				District d = districts.get((int) (Math.random() * districts.size()));
				if (!d.isOccupied())
					troops.add(new Troop(this, "India" + i + "", (int) (5 * Math.random()), d, false));
				else
					i--;
			}
			break;
		case "China":
			for (int i = 1; i < 16; i++) {
				District d = districts.get((int) (Math.random() * districts.size()));
				if (!d.isOccupied())
					troops.add(new Troop(this, "China" + i + "", (int) (5 * Math.random()), d, false));
				else
					i--;
			}
			break;
		case "Bhutan":
			for (int i = 1; i < 2; i++) {
				District d = districts.get((int) (Math.random() * districts.size()));
				if (!d.isOccupied())
					troops.add(new Troop(this, "Bhutan" + i + "", 15, d, false));
				else
					i--;
			}
			break;
		case "Nepal":
			for (int i = 1; i < 3; i++) {
				District d = districts.get((int) (Math.random() * districts.size()));
				if (!d.isOccupied())
					troops.add(new Troop(this, "Nepal" + i + "", (int) (5 * Math.random()), d, false));
				else
					i--;
			}
			break;
		case "Bangladesh":
			for (int i = 1; i < 4; i++) {
				District d = districts.get((int) (Math.random() * districts.size()));
				if (!d.isOccupied())
					troops.add(new Troop(this, "Bangladesh" + i + "", (int) (5 * Math.random()), d, false));
				else
					i--;
			}
			break;
		case "Pakistan":
			for (int i = 1; i < 7; i++) {
				District d = districts.get((int) (Math.random() * districts.size()));
				if (!d.isOccupied())
					troops.add(new Troop(this, "Pakistan" + i + "", (int) (5 * Math.random()), d, false));
				else
					i--;
			}
			break;
		case "Afghanistan":
			for (int i = 1; i < 4; i++) {
				District d = districts.get((int) (Math.random() * districts.size()));
				if (!d.isOccupied())
					troops.add(new Troop(this, "Afghanistan" + i + "", (int) (5 * Math.random()), d, false));
				else
					i--;
			}
			break;
		case "Myanmar":
			for (int i = 1; i < 5; i++) {
				District d = districts.get((int) (Math.random() * districts.size()));
				if (!d.isOccupied())
					troops.add(new Troop(this, "Myanmar" + i + "", (int) (5 * Math.random()), d, false));
				else
					i--;
			}
			break;
		case "Thailand":
			for (int i = 1; i < 5; i++) {
				District d = districts.get((int) (Math.random() * districts.size()));
				if (!d.isOccupied())
					troops.add(new Troop(this, "Thailand" + i + "", (int) (5 * Math.random()), d, false));
				else
					i--;
			}
			break;
		case "Malaysia":
			for (int i = 1; i < 3; i++) {
				District d = districts.get((int) (Math.random() * districts.size()));
				if (!d.isOccupied())
					troops.add(new Troop(this, "Malaysia" + i + "", (int) (5 * Math.random()), d, false));
				else
					i--;
			}
			break;
		case "Laos":
			for (int i = 1; i < 3; i++) {
				District d = districts.get((int) (Math.random() * districts.size()));
				if (!d.isOccupied())
					troops.add(new Troop(this, "Laos" + i + "", (int) (5 * Math.random()), d, false));
				else
					i--;
			}
			break;
		case "Philippines":
			for (int i = 1; i < 3; i++) {
				District d = districts.get((int) (Math.random() * districts.size()));
				if (!d.isOccupied())
					troops.add(new Troop(this, "Philippines" + i + "", (int) (5 * Math.random()), d, false));
				else
					i--;
			}
			break;
		case "Vietnam":
			for (int i = 1; i < 4; i++) {
				District d = districts.get((int) (Math.random() * districts.size()));
				if (!d.isOccupied())
					troops.add(new Troop(this, "Vietnam" + i + "", (int) (5 * Math.random()), d, false));
				else
					i--;
			}
			break;
		case "Singapore":
			for (int i = 1; i < 1; i++) {
				District d = districts.get((int) (Math.random() * districts.size()));
				if (!d.isOccupied())
					troops.add(new Troop(this, "Singapore" + i + "", 13, d, false));
			}
			break;
		case "Indonesia":
			for (int i = 1; i < 7; i++) {
				District d = districts.get((int) (Math.random() * districts.size()));
				if (!d.isOccupied())
					troops.add(new Troop(this, "Indonesia" + i + "", (int) (5 * Math.random()), d, false));
				else
					i--;
			}
			break;
		case "Cambodia":
			for (int i = 1; i < 3; i++) {
				District d = districts.get((int) (Math.random() * districts.size()));
				if (!d.isOccupied())
					troops.add(new Troop(this, "Cambodia" + i + "", (int) (5 * Math.random()), d, false));
				else
					i--;
			}
			break;
		case "Brunei":
			for (int i = 1; i < 3; i++) {
				District d = districts.get((int) (Math.random() * districts.size()));
				if (!d.isOccupied())
					troops.add(new Troop(this, "Brunei" + i + "", (int) (5 * Math.random()), d, false));
				else
					i--;
			}
			break;
		case "Sri Lanka":
			for (int i = 1; i < 3; i++) {
				District d = districts.get((int) (Math.random() * districts.size()));
				if (!d.isOccupied())
					troops.add(new Troop(this, "Sri Lanka" + i + "", (int) (5 * Math.random()), d, false));
				else
					i--;
			}
			break;
		case "Mongolia":
			for (int i = 1; i < 3; i++) {
				District d = districts.get((int) (Math.random() * districts.size()));
				if (!d.isOccupied())
					troops.add(new Troop(this, "Mongolia" + i + "", (int) (5 * Math.random()), d, false));
				else
					i--;
			}
			break;
		case "North Korea":
			for (int i = 1; i < 3; i++) {
				District d = districts.get((int) (Math.random() * districts.size()));
				if (!d.isOccupied())
					troops.add(new Troop(this, "North Korea" + i + "", (int) (5 * Math.random()), d, false));
				else
					i--;
			}
			break;
		case "South Korea":
			for (int i = 1; i < 3; i++) {
				District d = districts.get((int) (Math.random() * districts.size()));
				if (!d.isOccupied())
					troops.add(new Troop(this, "South Korea" + i + "", (int) (5 * Math.random()), d, false));
				else
					i--;
			}
			break;
		case "Japan":
			for (int i = 1; i < 7; i++) {
				District d = districts.get((int) (Math.random() * districts.size()));
				if (!d.isOccupied())
					troops.add(new Troop(this, "Japan" + i + "", (int) (5 * Math.random()), d, false));
				else
					i--;
			}
			break;
		case "Taiwan":
			for (int i = 1; i < 2; i++) {
				District d = districts.get((int) (Math.random() * districts.size()));
				if (!d.isOccupied())
					troops.add(new Troop(this, "Taiwan" + i + "", 13, d, false));
				else
					i--;
			}
			break;
		}
	}

	public void setArmoredCars() {
		switch (Name) {
		case "Russia":
			for (int i = 1; i < 8; i++) {
				District d = districts.get((int) (Math.random() * districts.size()));
				if (!d.isOccupied())
					troops.add(new ArmoredDivision(this, "Russia" + i + "", (int) (5 * Math.random()), d, false));
				else
					i--;
			}
			break;
		case "India":
			for (int i = 1; i < 13; i++) {
				District d = districts.get((int) (Math.random() * districts.size()));
				if (!d.isOccupied())
					troops.add(new ArmoredDivision(this, "India" + i + "", (int) (5 * Math.random()), d, false));
				else
					i--;
			}
			break;
		case "China":
			for (int i = 1; i < 16; i++) {
				District d = districts.get((int) (Math.random() * districts.size()));
				if (!d.isOccupied())
					troops.add(new ArmoredDivision(this, "China" + i + "", (int) (5 * Math.random()), d, false));
				else
					i--;
			}
			break;
		case "Bhutan":
			for (int i = 1; i < 2; i++) {
				District d = districts.get((int) (Math.random() * districts.size()));
				if (!d.isOccupied())
					troops.add(new ArmoredDivision(this, "Bhutan" + i + "", 15, d, false));
				else
					i--;
			}
			break;
		case "Nepal":
			for (int i = 1; i < 3; i++) {
				District d = districts.get((int) (Math.random() * districts.size()));
				if (!d.isOccupied())
					troops.add(new ArmoredDivision(this, "Nepal" + i + "", (int) (5 * Math.random()), d, false));
				else
					i--;
			}
			break;
		case "Bangladesh":
			for (int i = 1; i < 4; i++) {
				District d = districts.get((int) (Math.random() * districts.size()));
				if (!d.isOccupied())
					troops.add(new ArmoredDivision(this, "Bangladesh" + i + "", (int) (5 * Math.random()), d, false));
				else
					i--;
			}
			break;
		case "Pakistan":
			for (int i = 1; i < 7; i++) {
				District d = districts.get((int) (Math.random() * districts.size()));
				if (!d.isOccupied())
					troops.add(new ArmoredDivision(this, "Pakistan" + i + "", (int) (5 * Math.random()), d, false));
				else
					i--;
			}
			break;
		case "Afghanistan":
			for (int i = 1; i < 4; i++) {
				District d = districts.get((int) (Math.random() * districts.size()));
				if (!d.isOccupied())
					troops.add(new ArmoredDivision(this, "Afghanistan" + i + "", (int) (5 * Math.random()), d, false));
				else
					i--;
			}
			break;
		case "Myanmar":
			for (int i = 1; i < 5; i++) {
				District d = districts.get((int) (Math.random() * districts.size()));
				if (!d.isOccupied())
					troops.add(new ArmoredDivision(this, "Myanmar" + i + "", (int) (5 * Math.random()), d, false));
				else
					i--;
			}
			break;
		case "Thailand":
			for (int i = 1; i < 5; i++) {
				District d = districts.get((int) (Math.random() * districts.size()));
				if (!d.isOccupied())
					troops.add(new ArmoredDivision(this, "Thailand" + i + "", (int) (5 * Math.random()), d, false));
				else
					i--;
			}
			break;
		case "Malaysia":
			for (int i = 1; i < 3; i++) {
				District d = districts.get((int) (Math.random() * districts.size()));
				if (!d.isOccupied())
					troops.add(new ArmoredDivision(this, "Malaysia" + i + "", (int) (5 * Math.random()), d, false));
				else
					i--;
			}
			break;
		case "Laos":
			for (int i = 1; i < 3; i++) {
				District d = districts.get((int) (Math.random() * districts.size()));
				if (!d.isOccupied())
					troops.add(new ArmoredDivision(this, "Laos" + i + "", (int) (5 * Math.random()), d, false));
				else
					i--;
			}
			break;
		case "Philippines":
			for (int i = 1; i < 3; i++) {
				District d = districts.get((int) (Math.random() * districts.size()));
				if (!d.isOccupied())
					troops.add(new ArmoredDivision(this, "Philippines" + i + "", (int) (5 * Math.random()), d, false));
				else
					i--;
			}
			break;
		case "Vietnam":
			for (int i = 1; i < 4; i++) {
				District d = districts.get((int) (Math.random() * districts.size()));
				if (!d.isOccupied())
					troops.add(new ArmoredDivision(this, "Vietnam" + i + "", (int) (5 * Math.random()), d, false));
				else
					i--;
			}
			break;
		case "Singapore":
			for (int i = 1; i < 1; i++) {
				District d = districts.get((int) (Math.random() * districts.size()));
				if (!d.isOccupied())
					troops.add(new ArmoredDivision(this, "Singapore" + i + "", 13, d, false));
			}
			break;
		case "Indonesia":
			for (int i = 1; i < 7; i++) {
				District d = districts.get((int) (Math.random() * districts.size()));
				if (!d.isOccupied())
					troops.add(new ArmoredDivision(this, "Indonesia" + i + "", (int) (5 * Math.random()), d, false));
				else
					i--;
			}
			break;
		case "Cambodia":
			for (int i = 1; i < 3; i++) {
				District d = districts.get((int) (Math.random() * districts.size()));
				if (!d.isOccupied())
					troops.add(new ArmoredDivision(this, "Cambodia" + i + "", (int) (5 * Math.random()), d, false));
				else
					i--;
			}
			break;
		case "Brunei":
			for (int i = 1; i < 3; i++) {
				District d = districts.get((int) (Math.random() * districts.size()));
				if (!d.isOccupied())
					troops.add(new ArmoredDivision(this, "Brunei" + i + "", (int) (5 * Math.random()), d, false));
				else
					i--;
			}
			break;
		case "Sri Lanka":
			for (int i = 1; i < 3; i++) {
				District d = districts.get((int) (Math.random() * districts.size()));
				if (!d.isOccupied())
					troops.add(new ArmoredDivision(this, "Sri Lanka" + i + "", (int) (5 * Math.random()), d, false));
				else
					i--;
			}
			break;
		case "Mongolia":
			for (int i = 1; i < 3; i++) {
				District d = districts.get((int) (Math.random() * districts.size()));
				if (!d.isOccupied())
					troops.add(new ArmoredDivision(this, "Mongolia" + i + "", (int) (5 * Math.random()), d, false));
				else
					i--;
			}
			break;
		case "North Korea":
			for (int i = 1; i < 3; i++) {
				District d = districts.get((int) (Math.random() * districts.size()));
				if (!d.isOccupied())
					troops.add(new ArmoredDivision(this, "North Korea" + i + "", (int) (5 * Math.random()), d, false));
				else
					i--;
			}
			break;
		case "South Korea":
			for (int i = 1; i < 3; i++) {
				District d = districts.get((int) (Math.random() * districts.size()));
				if (!d.isOccupied())
					troops.add(new ArmoredDivision(this, "South Korea" + i + "", (int) (5 * Math.random()), d, false));
				else
					i--;
			}
			break;
		case "Japan":
			for (int i = 1; i < 7; i++) {
				District d = districts.get((int) (Math.random() * districts.size()));
				if (!d.isOccupied())
					troops.add(new ArmoredDivision(this, "Japan" + i + "", (int) (5 * Math.random()), d, false));
				else
					i--;
			}
			break;
		case "Taiwan":
			for (int i = 1; i < 2; i++) {
				District d = districts.get((int) (Math.random() * districts.size()));
				if (!d.isOccupied())
					troops.add(new ArmoredDivision(this, "Taiwan" + i + "", 13, d, false));
				else
					i--;
			}
			break;
		}
	}

	public void setTanks() {
		switch (Name) {
		case "Russia":
			for (int i = 1; i < 8; i++) {
				District d = districts.get((int) (Math.random() * districts.size()));
				if (!d.isOccupied())
					troops.add(new Tank(this, "Russia" + i + "", (int) (5 * Math.random()), d, false));
				else
					i--;
			}
			break;
		case "India":
			for (int i = 1; i < 13; i++) {
				District d = districts.get((int) (Math.random() * districts.size()));
				if (!d.isOccupied())
					troops.add(new Tank(this, "India" + i + "", (int) (5 * Math.random()), d, false));
				else
					i--;
			}
			break;
		case "China":
			for (int i = 1; i < 16; i++) {
				District d = districts.get((int) (Math.random() * districts.size()));
				if (!d.isOccupied())
					troops.add(new Tank(this, "China" + i + "", (int) (5 * Math.random()), d, false));
				else
					i--;
			}
			break;
		case "Bhutan":
			for (int i = 1; i < 2; i++) {
				District d = districts.get((int) (Math.random() * districts.size()));
				if (!d.isOccupied())
					troops.add(new Tank(this, "Bhutan" + i + "", 15, d, false));
				else
					i--;
			}
			break;
		case "Nepal":
			for (int i = 1; i < 3; i++) {
				District d = districts.get((int) (Math.random() * districts.size()));
				if (!d.isOccupied())
					troops.add(new Tank(this, "Nepal" + i + "", (int) (5 * Math.random()), d, false));
				else
					i--;
			}
			break;
		case "Bangladesh":
			for (int i = 1; i < 4; i++) {
				District d = districts.get((int) (Math.random() * districts.size()));
				if (!d.isOccupied())
					troops.add(new Tank(this, "Bangladesh" + i + "", (int) (5 * Math.random()), d, false));
				else
					i--;
			}
			break;
		case "Pakistan":
			for (int i = 1; i < 7; i++) {
				District d = districts.get((int) (Math.random() * districts.size()));
				if (!d.isOccupied())
					troops.add(new Tank(this, "Pakistan" + i + "", (int) (5 * Math.random()), d, false));
				else
					i--;
			}
			break;
		case "Afghanistan":
			for (int i = 1; i < 4; i++) {
				District d = districts.get((int) (Math.random() * districts.size()));
				if (!d.isOccupied())
					troops.add(new Tank(this, "Afghanistan" + i + "", (int) (5 * Math.random()), d, false));
				else
					i--;
			}
			break;
		case "Myanmar":
			for (int i = 1; i < 5; i++) {
				District d = districts.get((int) (Math.random() * districts.size()));
				if (!d.isOccupied())
					troops.add(new Tank(this, "Myanmar" + i + "", (int) (5 * Math.random()), d, false));
				else
					i--;
			}
			break;
		case "Thailand":
			for (int i = 1; i < 5; i++) {
				District d = districts.get((int) (Math.random() * districts.size()));
				if (!d.isOccupied())
					troops.add(new Tank(this, "Thailand" + i + "", (int) (5 * Math.random()), d, false));
				else
					i--;
			}
			break;
		case "Malaysia":
			for (int i = 1; i < 3; i++) {
				District d = districts.get((int) (Math.random() * districts.size()));
				if (!d.isOccupied())
					troops.add(new Tank(this, "Malaysia" + i + "", (int) (5 * Math.random()), d, false));
				else
					i--;
			}
			break;
		case "Laos":
			for (int i = 1; i < 3; i++) {
				District d = districts.get((int) (Math.random() * districts.size()));
				if (!d.isOccupied())
					troops.add(new Tank(this, "Laos" + i + "", (int) (5 * Math.random()), d, false));
				else
					i--;
			}
			break;
		case "Philippines":
			for (int i = 1; i < 3; i++) {
				District d = districts.get((int) (Math.random() * districts.size()));
				if (!d.isOccupied())
					troops.add(new Tank(this, "Philippines" + i + "", (int) (5 * Math.random()), d, false));
				else
					i--;
			}
			break;
		case "Vietnam":
			for (int i = 1; i < 4; i++) {
				District d = districts.get((int) (Math.random() * districts.size()));
				if (!d.isOccupied())
					troops.add(new Tank(this, "Vietnam" + i + "", (int) (5 * Math.random()), d, false));
				else
					i--;
			}
			break;
		case "Singapore":
			for (int i = 1; i < 1; i++) {
				District d = districts.get((int) (Math.random() * districts.size()));
				if (!d.isOccupied())
					troops.add(new Tank(this, "Singapore" + i + "", 13, d, false));
			}
			break;
		case "Indonesia":
			for (int i = 1; i < 7; i++) {
				District d = districts.get((int) (Math.random() * districts.size()));
				if (!d.isOccupied())
					troops.add(new Tank(this, "Indonesia" + i + "", (int) (5 * Math.random()), d, false));
				else
					i--;
			}
			break;
		case "Cambodia":
			for (int i = 1; i < 3; i++) {
				District d = districts.get((int) (Math.random() * districts.size()));
				if (!d.isOccupied())
					troops.add(new Tank(this, "Cambodia" + i + "", (int) (5 * Math.random()), d, false));
				else
					i--;
			}
			break;
		case "Brunei":
			for (int i = 1; i < 3; i++) {
				District d = districts.get((int) (Math.random() * districts.size()));
				if (!d.isOccupied())
					troops.add(new Tank(this, "Brunei" + i + "", (int) (5 * Math.random()), d, false));
				else
					i--;
			}
			break;
		case "Sri Lanka":
			for (int i = 1; i < 3; i++) {
				District d = districts.get((int) (Math.random() * districts.size()));
				if (!d.isOccupied())
					troops.add(new Tank(this, "Sri Lanka" + i + "", (int) (5 * Math.random()), d, false));
				else
					i--;
			}
			break;
		case "Mongolia":
			for (int i = 1; i < 3; i++) {
				District d = districts.get((int) (Math.random() * districts.size()));
				if (!d.isOccupied())
					troops.add(new Tank(this, "Mongolia" + i + "", (int) (5 * Math.random()), d, false));
				else
					i--;
			}
			break;
		case "North Korea":
			for (int i = 1; i < 2; i++) {
				District d = districts.get((int) (Math.random() * districts.size()));
				if (!d.isOccupied())
					troops.add(new Tank(this, "North Korea" + i + "", (int) (5 * Math.random()), d, false));
				else
					i--;
			}
			break;
		case "South Korea":
			for (int i = 1; i < 3; i++) {
				District d = districts.get((int) (Math.random() * districts.size()));
				if (!d.isOccupied())
					troops.add(new Tank(this, "South Korea" + i + "", (int) (5 * Math.random()), d, false));
				else
					i--;
			}
			break;
		case "Japan":
			for (int i = 1; i < 7; i++) {
				District d = districts.get((int) (Math.random() * districts.size()));
				if (!d.isOccupied())
					troops.add(new Tank(this, "Japan" + i + "", (int) (5 * Math.random()), d, false));
				else
					i--;
			}
			break;
		case "Taiwan":
			for (int i = 1; i < 2; i++) {
				District d = districts.get((int) (Math.random() * districts.size()));
				if (!d.isOccupied())
					troops.add(new Tank(this, "Taiwan" + i + "", 13, d, false));
				else
					i--;
			}
			break;
		}
	}

	public void setDistricts() {
		// add
		switch (Name) {
		case "Russia":
			break;
		case "Mongolia":
			districts.add(new District("Hovd"));
			districts.add(new District("Uvs"));
			districts.add(new District("Govi-Altai"));
			districts.add(new District("Hovsgol"));
			districts.add(new District("Selenge"));
			districts.add(new District("South Govi"));
			districts.add(new District("East Govi"));
			districts.add(new District("Dornod"));
			break;
		case "North Korea":
			districts.add(new District("Changang-Do"));
			districts.add(new District("Yanggan-Do"));
			districts.add(new District("Hamgyong-Bukto"));
			districts.add(new District("PiYongang Namdo"));
			districts.add(new District("Pyongyang"));
			districts.add(new District("Kangwon-Do"));
			break;
		case "South Korea":
			break;
		case "Japan":
			break;
		case "Taiwan":
			break;
		case "China":
			districts.add(new District("Beijing"));
			districts.add(new District("Tianjin"));
			districts.add(new District("Canzhou"));
			districts.add(new District("Yantai"));
			districts.add(new District("Qingdao"));
			districts.add(new District("Liyanyangang"));
			districts.add(new District("Yancheng"));
			districts.add(new District("Nantong"));
			districts.add(new District("Shanghai"));
			districts.add(new District("Suzhou"));
			districts.add(new District("Hangzhou"));
			districts.add(new District("Jinhua"));
			districts.add(new District("Zhoushan"));
			districts.add(new District("Taizhou"));
			districts.add(new District("Wenzhou"));
			districts.add(new District("Ningde"));
			districts.add(new District("Fuzhou"));
			districts.add(new District("Putian"));
			districts.add(new District("Xiamen"));
			districts.add(new District("Hong Kong"));
			districts.add(new District("Macau"));
			districts.add(new District("Guangzhou"));
			districts.add(new District("Zhanjiang"));
			districts.add(new District("Hainan Dao"));
			districts.add(new District("Guigang"));
			districts.add(new District("Wuzhou"));
			districts.add(new District("Chenzhou"));
			districts.add(new District("Longyan"));
			districts.add(new District("Sanming"));
			districts.add(new District("Quzhou"));
			districts.add(new District("Huangshan"));
			districts.add(new District("Jiulong"));
			districts.add(new District("Changde"));
			districts.add(new District("Yichang"));
			districts.add(new District("Yueyang"));
			districts.add(new District("Huaihua"));
			districts.add(new District("Hechi"));
			districts.add(new District("Nanning"));
			districts.add(new District("Wenshan"));
			districts.add(new District("Dali"));
			districts.add(new District("Nyingchi"));
			districts.add(new District("Lhasa"));
			districts.add(new District("Ngari"));
			districts.add(new District("Gerze"));
			districts.add(new District("Kashgar"));
			districts.add(new District("Aksu"));
			districts.add(new District("Yili"));
			districts.add(new District("Karamay"));
			districts.add(new District("Kumul"));
			districts.add(new District("Jiuquan"));
			districts.add(new District("Haixi"));
			districts.add(new District("Xining"));
			districts.add(new District("Xian"));
			districts.add(new District("Wuhan"));
			districts.add(new District("Zhuzhou"));
			districts.add(new District("Yichun"));
			districts.add(new District("Nanjing"));
			districts.add(new District("Heifei"));
			districts.add(new District("Huainan"));
			districts.add(new District("Bengbu"));
			districts.add(new District("Xuzhou"));
			districts.add(new District("Bayingol"));
			districts.add(new District("Urumqi"));
			districts.add(new District("Ruoqiang"));
			districts.add(new District("Dulan"));
			districts.add(new District("Zekog"));
			districts.add(new District("Gangu"));
			districts.add(new District("Chongxin"));
			districts.add(new District("Chenggu"));
			districts.add(new District("Qingchuan"));
			districts.add(new District("Chengdu"));
			districts.add(new District("Muli"));
			districts.add(new District("Lhari"));
			districts.add(new District("Qumarleb"));
			districts.add(new District("Alxa"));
			districts.add(new District("Datong"));
			districts.add(new District("Fengzhen"));
			districts.add(new District("Chengde"));
			districts.add(new District("Xilin Gol"));
			districts.add(new District("Shenyang"));
			districts.add(new District("Changchun"));
			districts.add(new District("Mudanjiang"));
			districts.add(new District("Da Hinggan Ling"));
			districts.add(new District("Hulun Buir"));
			districts.add(new District("Baoji"));
			districts.add(new District("Kunming"));
			districts.add(new District("Chongquing"));
			districts.add(new District("Changsha"));
			districts.add(new District("Chaoyang"));
			districts.add(new District("Harbin"));
			districts.add(new District("Suihua"));
			break;
		case "Bhutan":
			break;
		case "Nepal":
			break;
		case "India":
			districts.add(new District("Delhi"));
			districts.add(new District("Haryana"));
			districts.add(new District("Bathinda"));
			districts.add(new District("Amritsar"));
			districts.add(new District("Jammu"));
			districts.add(new District("Kashmir Valley"));
			districts.add(new District("Ladakh"));
			districts.add(new District("Aksai Chin"));
			districts.add(new District("Himachal"));
			districts.add(new District("Uttrakhand"));
			districts.add(new District("Derhadun"));
			districts.add(new District("Agra"));
			districts.add(new District("Kanpur"));
			districts.add(new District("Allahabad"));
			districts.add(new District("Jaipur"));
			districts.add(new District("Ajmer"));
			districts.add(new District("Jodhpur"));
			districts.add(new District("Ahmedabad"));
			districts.add(new District("Rann of Kutch"));
			districts.add(new District("Rajkot"));
			districts.add(new District("Vadodara"));
			districts.add(new District("Surat"));
			districts.add(new District("Mumbai"));
			districts.add(new District("Godhra"));
			districts.add(new District("Bhopal"));
			districts.add(new District("Jalagaon"));
			districts.add(new District("Aurangabad"));
			districts.add(new District("Poona"));
			districts.add(new District("Goa"));
			districts.add(new District("Mangalore"));
			districts.add(new District("Kochi"));
			districts.add(new District("Thiruvananthapuram"));
			districts.add(new District("Madurai"));
			districts.add(new District("Tirucirappali"));
			districts.add(new District("Puducherry"));
			districts.add(new District("Tirvannamalai"));
			districts.add(new District("Chennai"));
			districts.add(new District("Ongole"));
			districts.add(new District("Vishakapatnam"));
			districts.add(new District("Cuttack"));
			districts.add(new District("Rourkela"));
			districts.add(new District("Kolkatta"));
			districts.add(new District("Asansol"));
			districts.add(new District("Silliguri"));
			districts.add(new District("Sikkim"));
			districts.add(new District("Guwahati"));
			districts.add(new District("Tezpur"));
			districts.add(new District("Arunachal Pradesh"));
			districts.add(new District("Imphal"));
			districts.add(new District("Mizoram"));
			districts.add(new District("Muzaffarpur"));
			districts.add(new District("Patna"));
			districts.add(new District("Gaya"));
			districts.add(new District("Ranchi"));
			districts.add(new District("Jamshedpur"));
			districts.add(new District("Sitapur"));
			districts.add(new District("Bliaspur"));
			districts.add(new District("Raipur"));
			districts.add(new District("Jagdalpur"));
			districts.add(new District("Jaisalmer"));
			districts.add(new District("Palanpur"));
			districts.add(new District("Hubli"));
			districts.add(new District("Bangalore"));
			districts.add(new District("Kozhikode"));
			districts.add(new District("Tirupati"));
			districts.add(new District("Cuddupa"));
			districts.add(new District("Gulbarga"));
			districts.add(new District("Mysore"));
			districts.add(new District("Hyderabad"));
			districts.add(new District("Vijayapura"));
			districts.add(new District("Solapur"));
			districts.add(new District("Nanded"));
			districts.add(new District("Suryapet"));
			districts.add(new District("Nagpur"));
			districts.add(new District("Chandrapur"));
			districts.add(new District("Jhansi"));
			districts.add(new District("Rewa"));
			districts.add(new District("Jabalpur"));
			districts.add(new District("Gwalior"));
			districts.add(new District("Merut"));
			districts.add(new District("Lucknow"));
			districts.add(new District("Faziabad"));
			districts.add(new District("Bikaner"));
			districts.add(new District("Tripura"));
			districts.add(new District("Nizamabad"));
			districts.add(new District("Bhagalpur"));
			districts.add(new District("Kota"));
			districts.add(new District("Combiatore"));
			districts.add(new District("Balangir"));
			districts.add(new District("Ganghinagar"));
			break;
		case "Bangladesh":

			break;
		case "Pakistan":
			break;
		case "Afghanistan":
			break;
		case "Myanmar":
			break;
		case "Thailand":
			break;
		case "Malaysia":
			break;
		case "Laos":
			break;
		case "Philippines":
			break;
		case "Vietnam":
			break;
		case "Singapore":
			break;
		case "Indonesia":
			break;
		case "Cambodia":
			break;
		case "Brunei":
			break;
		case "Sri Lanka":
			break;
		default:
		}
		for (

		District d : districts)
			d.setOccupiedBy(this);

	}

	public int getWealth() {
		// add
		switch (Name) {
		case "Russia":
			return 6750;
		case "Mongolia":
			return 1800;
		case "North Korea":
			return 1900;
		case "South Korea":
			return 1560;
		case "Japan":
			return 4800;
		case "Taiwan":
			return 2300;
		case "China":
			return 10300;
		case "Bhutan":
			return 1610;
		case "Nepal":
			return 1800;
		case "India":
			return 8030;
		case "Bangladesh":
			return 2600;
		case "Pakistan":
			return 2930;
		case "Afghanistan":
			return 1965;
		case "Myanmar":
			return 1900;
		case "Thailand":
			return 4300;
		case "Malaysia":
			return 2850;
		case "Laos":
			return 1400;
		case "Philippines":
			return 2750;
		case "Vietnam":
			return 3550;
		case "Singapore":
			return 770;
		case "Indonesia":
			return 5000;
		case "Cambodia":
			return 1400;
		case "Brunei":
			return 1500;
		case "Sri Lanka":
			return 2050;
		default:
			return 1000;
		}
	}

	public int[] getCapital() {
		if (Name.equals("Russia"))
			return new int[] { 300, 50 };
		else if (Name.equals("Mongolia"))
			return new int[] { 690, 130 };
		else if (Name.equals("North Korea"))
			return new int[] { 1000, 300 };
		else if (Name.equals("South Korea"))
			return new int[] { 1030, 340 };
		else if (Name.equals("Japan"))
			return new int[] { 1210, 376 };
		else if (Name.equals("Taiwan"))
			return new int[] { 934, 588 };
		else if (Name.equals("China"))
			return new int[] { 842, 331 };
		else if (Name.equals("Bhutan"))
			return new int[] { 450, 515 };
		else if (Name.equals("Nepal"))
			return new int[] { 371, 513 };
		else if (Name.equals("India"))
			return new int[] { 240, 500 };
		else if (Name.equals("Bangladesh"))
			return new int[] { 450, 575 };
		else if (Name.equals("Pakistan"))
			return new int[] { 175, 415 };
		else if (Name.equals("Afghanistan"))
			return new int[] { 118, 386 };
		else if (Name.equals("Myanmar"))
			return new int[] { 530, 600 };
		else if (Name.equals("Thailand"))
			return new int[] { 610, 745 };
		else if (Name.equals("Malaysia"))
			return new int[] { 637, 932 };
		else if (Name.equals("Laos"))
			return new int[] { 637, 932 };
		else if (Name.equals("Philippines"))
			return new int[] { 930, 725 };
		else if (Name.equals("Vietnam"))
			return new int[] { 684, 628 };
		else if (Name.equals("Singapore"))
			return new int[] { 655, 945 };
		else if (Name.equals("Indonesia"))
			return new int[] { 754, 1086 };
		else if (Name.equals("Cambodia"))
			return new int[] { 678, 772 };
		else if (Name.equals("Brunei"))
			return new int[] { 827, 900 };
		else if (Name.equals("Sri Lanka"))
			return new int[] { 300, 856 };
		else
			return new int[] { 0, 0 };
	}

	public ArrayList<District> getDistricts() {
		return districts;
	}

	protected Color getNationColor() {
		int clr = ref.getImage().getRGB(capital[0], capital[1]);
		int red = (clr & 0x00ff0000) >> 16;
		int green = (clr & 0x0000ff00) >> 8;
		int blue = clr & 0x000000ff;
		return (new Color(red, green, blue));
	}

}
