package War_Game;

import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

@SuppressWarnings("serial")
public class ControlPanel extends JFrame {
	private JButton addTroop, addTank, addArtillery, addRocketArtillery, addSPG, addCommando, addHeavyTank, endTurn,
			update_district;
	private JLabel name, coordinates, status;
	private static WarGameBoard board = new WarGameBoard();
	private JComboBox<String> Select_Districts;
	private BufferedImage img;

	@SuppressWarnings("unused")
	protected ControlPanel() {
		super("Your nation is " + board.getChosen().getName());

		setSize(400, 800);
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		// create a new panel with GridBagLayout manager
		update_district = new JButton("Update District");
		addTroop = new JButton("Add Troop");
		addTank = new JButton("Add Tank");
		addArtillery = new JButton("Add Artillery");
		addRocketArtillery = new JButton("Add Rocket Artillery");
		addHeavyTank = new JButton("Add Heavy Tank");
		addSPG = new JButton("Add SPG");
		addCommando = new JButton("Add Commando");
		endTurn = new JButton("End Turn");
		// JPanel newPanel = new JPanel(new GridLayout());
		setLayout(new GridLayout(40, 10));
		add(addTroop);
		add(addTank);
		add(addArtillery);
		add(addCommando);
		add(addSPG);
		add(addRocketArtillery);
		add(addHeavyTank);
		add(endTurn);
		add(update_district);

		String[] district = new String[board.getChosen().getDistricts().size()];
		for (int i = 0; i < district.length; i++) {
			district[i] = board.getChosen().getDistricts().get(i).getName();
		}
		// THE DRAWSTRING STUFF
		Select_Districts = new JComboBox<String>(district);
		add(Select_Districts);
		District ref = findDistrict(board.getChosen(), (String) Select_Districts.getSelectedItem());
		imageSetting();
		if (ref != null) {
			if (ref.getTroop() != null)
				img = ref.getTroop().getImage();
			name = new JLabel(ref.getName());
			name.setVisible(true);
			add(name);
			coordinates = new JLabel(ref.toString());
			name.setVisible(true);
			add(coordinates);
			status = new JLabel(ref.getStatus());
			status.setVisible(true);
			add(status);
			repaint();

		} else {
			name = null;
			coordinates = null;
			status = null;
		}
		update_district.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (name != null)
					name.setText(
							findDistrict(board.getChosen(), (String) Select_Districts.getSelectedItem()).getName());
				if (coordinates != null)
					coordinates.setText(
							findDistrict(board.getChosen(), (String) Select_Districts.getSelectedItem()).toString());
				if (status != null) {
					status.setText(
							findDistrict(board.getChosen(), ((String) Select_Districts.getSelectedItem())).getStatus());
				}
				if (img != null && findDistrict(board.getChosen(), ((String) Select_Districts.getSelectedItem()))
						.getTroop() != null) {
					img = findDistrict(board.getChosen(), ((String) Select_Districts.getSelectedItem())).getTroop()
							.getImage();
					repaint();
				}
			}
		});

		endTurn.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent a) {
				board.switchTurn();
				setVisible(false);
				dispose(); // Destroy the JFrame object
				new ControlPanel().open();
			}
		});
		addTroop.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent a) {
				// TODO Auto-generated method stub
				ArrayList<District> districts = board.getChosen().getDistricts();
				String chosen = null;
				District recruit = null;
				int i = 0;
				String[] choicestoAdd = new String[100];
				for (District d : districts) {
					if (!d.isOccupied() && d.hasMajorCity()) {
						choicestoAdd[i] = d.getName();
						i++;
					}
				}

				chosen = (((String) JOptionPane.showInputDialog(null, "What district do you want to recruit troops",
						"Your nation is...", JOptionPane.QUESTION_MESSAGE, null, choicestoAdd, choicestoAdd[0])));
				if (chosen != null) {
					for (int b = 0; b < districts.size(); b++) {
						if (districts.get(b).getName().equals(chosen))
							recruit = districts.get(b);
					}
					Troop t = new Troop(board.getChosen(),
							board.getChosen().getName() + board.getChosen().getTroops().size(), 1, recruit, false);
					board.getChosen().add(t);

				}
			}
		});
		addTank.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent a) {
				// TODO Auto-generated method stub
				ArrayList<District> districts = board.getChosen().getDistricts();
				String chosen = null;
				District recruit = null;
				int i = 0;
				String[] choicestoAdd = new String[100];
				for (District d : districts) {
					if (!d.isOccupied() && d.hasMajorIndustry()) {
						choicestoAdd[i] = d.getName();
						i++;
					}
				}

				chosen = (((String) JOptionPane.showInputDialog(null, "What district do you want to recruit troops",
						"Your nation is...", JOptionPane.QUESTION_MESSAGE, null, choicestoAdd, choicestoAdd[0])));
				if (chosen != null) {
					for (int b = 0; b < districts.size(); b++) {
						if (districts.get(b).getName().equals(chosen))
							recruit = districts.get(b);
					}
					Troop t = new Tank(board.getChosen(),
							board.getChosen().getName() + board.getChosen().getTroops().size(), 1, recruit, false);
					board.getChosen().add(t);

				}
			}
		});
		addArtillery.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent a) {
				// TODO Auto-generated method stub
				ArrayList<District> districts = board.getChosen().getDistricts();
				String chosen = null;
				District recruit = null;
				int i = 0;
				String[] choicestoAdd = new String[100];
				for (District d : districts) {
					if (!d.isOccupied() && d.hasMajorIndustry()) {
						choicestoAdd[i] = d.getName();
						i++;
					}
				}

				chosen = (((String) JOptionPane.showInputDialog(null, "What district do you want to recruit troops",
						"Your nation is...", JOptionPane.QUESTION_MESSAGE, null, choicestoAdd, choicestoAdd[0])));
				if (chosen != null) {
					for (int b = 0; b < districts.size(); b++) {
						if (districts.get(b).getName().equals(chosen))
							recruit = districts.get(b);
					}
					Troop t = new Artillery(board.getChosen(),
							board.getChosen().getName() + board.getChosen().getTroops().size(), 1, recruit, false);
					board.getChosen().add(t);

				}
			}
		});
		addHeavyTank.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent a) {
				// TODO Auto-generated method stub
				ArrayList<District> districts = board.getChosen().getDistricts();
				String chosen = null;
				District recruit = null;
				int i = 0;
				String[] choicestoAdd = new String[100];
				for (District d : districts) {
					if (!d.isOccupied() && d.hasMajorIndustry()) {
						choicestoAdd[i] = d.getName();
						i++;
					}
				}

				chosen = (((String) JOptionPane.showInputDialog(null, "What district do you want to recruit troops",
						"Your nation is...", JOptionPane.QUESTION_MESSAGE, null, choicestoAdd, choicestoAdd[0])));
				if (chosen != null) {
					for (int b = 0; b < districts.size(); b++) {
						if (districts.get(b).getName().equals(chosen))
							recruit = districts.get(b);
					}
					Troop t = new HeavyTank(board.getChosen(),
							board.getChosen().getName() + board.getChosen().getTroops().size(), 1, recruit, false);
					board.getChosen().add(t);

				}
			}
		});
		addSPG.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent a) {
				// TODO Auto-generated method stub
				ArrayList<District> districts = board.getChosen().getDistricts();
				String chosen = null;
				District recruit = null;
				int i = 0;
				String[] choicestoAdd = new String[100];
				for (District d : districts) {
					if (!d.isOccupied() && d.hasMajorIndustry()) {
						choicestoAdd[i] = d.getName();
						i++;
					}
				}

				chosen = (((String) JOptionPane.showInputDialog(null, "What district do you want to recruit troops",
						"Your nation is...", JOptionPane.QUESTION_MESSAGE, null, choicestoAdd, choicestoAdd[0])));
				if (chosen != null) {
					for (int b = 0; b < districts.size(); b++) {
						if (districts.get(b).getName().equals(chosen))
							recruit = districts.get(b);
					}
					Troop t = new SPG(board.getChosen(),
							board.getChosen().getName() + board.getChosen().getTroops().size(), 1, recruit, false);
					board.getChosen().add(t);

				}
			}
		});
		addRocketArtillery.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent a) {
				// TODO Auto-generated method stub
				ArrayList<District> districts = board.getChosen().getDistricts();
				String chosen = null;
				District recruit = null;
				int i = 0;
				String[] choicestoAdd = new String[100];
				for (District d : districts) {
					if (!d.isOccupied() && d.hasMajorIndustry()) {
						choicestoAdd[i] = d.getName();
						i++;
					}
				}

				chosen = (((String) JOptionPane.showInputDialog(null, "What district do you want to recruit troops",
						"Your nation is...", JOptionPane.QUESTION_MESSAGE, null, choicestoAdd, choicestoAdd[0])));
				if (chosen != null) {
					for (int b = 0; b < districts.size(); b++) {
						if (districts.get(b).getName().equals(chosen))
							recruit = districts.get(b);
					}
					Troop t = new RocketArtillery(board.getChosen(),
							board.getChosen().getName() + board.getChosen().getTroops().size(), 1, recruit, false);
					board.getChosen().add(t);

				}
			}
		});
		addCommando.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent a) {
				// TODO Auto-generated method stub
				ArrayList<District> districts = board.getChosen().getDistricts();
				String chosen = null;
				District recruit = null;
				int i = 0;
				String[] choicestoAdd = new String[100];
				for (District d : districts) {
					if (!d.isOccupied() && d.hasMajorIndustry()) {
						choicestoAdd[i] = d.getName();
						i++;
					}
				}

				chosen = (((String) JOptionPane.showInputDialog(null, "What district do you want to recruit troops",
						"Your nation is...", JOptionPane.QUESTION_MESSAGE, null, choicestoAdd, choicestoAdd[0])));
				if (chosen != null) {
					for (int b = 0; b < districts.size(); b++) {
						if (districts.get(b).getName().equals(chosen))
							recruit = districts.get(b);
					}
					Troop t = new Commando(board.getChosen(),
							board.getChosen().getName() + board.getChosen().getTroops().size(), 1, recruit, false);
					board.getChosen().add(t);

				}
			}
		});
	}

	private void imageSetting() {
		try {
			img = ImageIO.read(new File("blank.png"));
		} catch (Exception e) {

		}
	}

	private District findDistrict(Nation n, String s) {
		for (District d : n.getDistricts()) {
			if (d.getName().equals(s))
				return d;
		}
		return null;
	}

	protected void open() {
		// set look and feel to the system look and feel
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new ControlPanel().setVisible(true);
			}
		});
	}
	/*
	public void paint(Graphics g) {
		if (img != null)
			g.drawImage(img, 50, 350, null);
	}
	*/
}
