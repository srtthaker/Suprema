package War_Game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * This class represents the Map that the game is played on Credits to
 * youtube.com for the soundtrack
 * 
 * @author Swetank
 *
 */
@SuppressWarnings("serial")
public class WarGameBoard extends JPanel {
	private static BufferedImage image;
	private static Nation chosen;
	private int x, y;
	private static WarGameBoard w = new WarGameBoard();
	private static Nation[] nations = new Nation[] { new Nation("Russia"), new Nation("Mongolia"),
			new Nation("North Korea"), new Nation("South Korea"), new Nation("Japan"), new Nation("Taiwan"),
			new Nation("China"), new Nation("Bhutan"), new Nation("Nepal"), new Nation("India"),
			new Nation("Bangladesh"), new Nation("Pakistan"), new Nation("Afghanistan"), new Nation("Myanmar"),
			new Nation("Thailand"), new Nation("Malaysia"), new Nation("Laos"), new Nation("Cambodia"),
			new Nation("Philippenes"), new Nation("Vietnam"), new Nation("Singapore"), new Nation("Indonesia"),
			new Nation("Brunei") };

	/**
	 * Constructor that creates a game board of Asia
	 */
	public WarGameBoard() {
		try {
			image = ImageIO.read(new File("executable//AsiaMap4.png"));
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent me) {
				// Get x,y and store them
				x = me.getX();
				y = me.getY();
				repaint();
				System.out.println("{" + x + "," + y + "}");
			}
		});
	}

	/**
	 * gets the chosen nation
	 * 
	 * @return the chosen nation
	 */
	public Nation getChosen() {
		return chosen;
	}

	public void switchTurn() {
		if (chosen.equals(nations[nations.length - 1]))
			chosen = nations[0];
		else {
			int index = 0;
			for (int i = 0; i < nations.length; i++) {
				if (nations[i].equals(chosen)) {
					index = i;
					break;
				}
			}
			chosen = nations[index + 1];
		}

	}

	/**
	 * gets the image
	 * 
	 * @return image
	 */
	public BufferedImage getImage() {
		return image;
	}

	private Nation findNation(String nat) {
		int i = 0;
		for (Nation n : nations) {
			if (nations[i].getName().equals(nat))
				return n;
			i++;
		}
		return null;
	}

	/**
	 * paints the scene on a frame
	 * 
	 * @param g
	 *            - the graphics tool that draws components on the frame
	 */
	@Override
	/**
	 * draws the main image or images on the JFrame
	 * 
	 * @postcondition images are drawn on the JFrame
	 */
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(image, 0, 0, null);
		g.setColor(Color.WHITE);
		g.setFont(new Font("Consolas", Font.PLAIN, 18));
		for (Nation n : nations) {
			ArrayList<District> d = n.getDistricts();
			for (District d1 : d) {
				g.setColor(Color.BLACK);
				g.fillOval(d1.getX(), d1.getY(), 4, 4); // labels all districts
				g.setColor(Color.WHITE);
			}
		}
		// horizontal gridlines
		for (int i = 0; i < image.getHeight(); i++) {
			if (i % 50 == 0) {
				g.drawLine(0, i, image.getWidth(), i);
				g.drawString(i + "", 0, i);
			}
		}
		// vertical gridlines
		for (int i = 0; i < image.getWidth(); i++) {
			if (i % 50 == 0) {
				g.drawLine(i, 0, i, image.getHeight());
				g.drawString(i + "", i, 15);
			}
		}
		for (Nation n : nations)
			for (Troop t : n.getTroops())
				t.paintComponent(g);
		g.drawString("Click for coordinates: ", 1005, 700);
		g.drawString("(" + x + "," + y + ")", 1160, 720);
	}

	/**
	 * 
	 * Creates a JMenubar for several options and plays music
	 * 
	 * @postcondition there is a menu bar created at the top of the frame
	 *                creates the menu bar at the top of the frame
	 * 
	 * @return menuBar
	 * @throws IOException
	 * @throws UnsupportedAudioFileException
	 */
	public JMenuBar setUp() throws Exception {
		AudioInputStream inputStream = AudioSystem.getAudioInputStream(
				new File("executable//Entering the Stronghold (Official) - Epic Infiltration Music.wav"));
		Clip clip = AudioSystem.getClip();
		clip.open(inputStream);
		clip.loop(Clip.LOOP_CONTINUOUSLY);
		Thread.sleep(10); // looping as long as this thread is alive

		JMenuBar menuBar = new JMenuBar();
		JMenu menu = new JMenu("Options");
		menuBar.add(menu);
		JMenuItem[] items = new JMenuItem[10];
		/**
		 * There will be one menu on the menu bar 1. Exit 2. Help/How to play
		 * 3.Start Game by picking a nation and immediately open nation control
		 * 4.Play/stop music 5. New game - set everything about a nation to null
		 * 6. Kill all troops 7. Simulate Turn - Need a Good AI!!!
		 **/
		items[0] = new JMenuItem("Exit");
		items[0].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int response = JOptionPane.showConfirmDialog(null, "Do you want to leave your nation?", "Exit?",
						JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				if (response == JOptionPane.YES_OPTION)
					System.exit(0);
			}
		});
		items[1] = new JMenuItem("Help");
		items[1].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent a) {
				JOptionPane.showMessageDialog(null,
						"1. Choose a nation to begin.\n 2. Click on the control panel to purchase troops, and select which district to put them in.\n 3. Attack your opponents nation, and hopefully win. Good luck!",
						"How to play", JOptionPane.INFORMATION_MESSAGE, null);
			}
		});
		items[2] = new JMenuItem("Change your nation");
		items[2].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent a) {
				String[] choices = new String[24];
				int i = 0;
				for (Nation n : nations) {
					choices[i] = (n.getName());
					i++;
				}
				chosen = null;
				while (chosen == null)
					chosen = findNation(((String) JOptionPane.showInputDialog(null, "Choose your Nation",
							"Your nation is...", JOptionPane.QUESTION_MESSAGE, null, choices, choices[0])));
				// @SuppressWarnings("unused")
				ControlPanel panel = new ControlPanel();
				panel.open();
				System.out.println("You have chosen " + chosen.getName());
			}
		});
		items[3] = new JMenuItem("PlayMusic On/Off");
		items[3].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent a) {
				String[] choices = new String[2];
				String chosen = "On";
				choices[0] = "On";
				choices[1] = "Off";
				chosen = ((String) JOptionPane.showInputDialog(null, "Turn on/off music", "",
						JOptionPane.QUESTION_MESSAGE, null, choices, choices[0]));
				if (chosen.equals("Off"))
					clip.stop();
				if (!clip.isRunning() && chosen.equals("On")) {
					clip.loop(Clip.LOOP_CONTINUOUSLY);
				}
			}
		});
		items[4] = new JMenuItem("Kill all troops");
		items[4].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent a) {
				for (Nation n : nations)
					for (Troop t : n.getTroops())
						t.die();
				repaint();
			}
		});

		for (JMenuItem j : items)
			if (j != null)
				menu.add(j);
		return menuBar;
	}

	/**
	 * main method
	 * 
	 * @param args-command
	 *            line arguments
	 * @throws IOException
	 */

	public static void main(String[] args) throws Exception {
		JFrame jf = new JFrame();
		jf.setTitle("You know they say- Never get into a land war in Asia");
		jf.setSize(image.getWidth(), image.getHeight() + 40);
		jf.setVisible(true);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setJMenuBar(w.setUp());
		jf.add(w);
		jf.setResizable(false);
		String[] choices = new String[24];
		int i = 0;
		for (Nation n : nations) {
			choices[i] = (n.getName());
			i++;
		}
		chosen = w.findNation(((String) JOptionPane.showInputDialog(null, "Choose your Nation", "Your nation is...",
				JOptionPane.QUESTION_MESSAGE, null, choices, choices[0])));
		while (chosen == null)
			chosen = w.findNation(((String) JOptionPane.showInputDialog(null, "You must choose a nation!",
					"Your nation is...", JOptionPane.QUESTION_MESSAGE, null, choices, choices[0])));
		ControlPanel control = new ControlPanel();
		control.open();
	}
	
}
