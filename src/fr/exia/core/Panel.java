package fr.exia.core;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class Panel extends JPanel {
	
	private static final long serialVersionUID = 1L;
	
	private List<ElementVisuel> components = new ArrayList<>();
	private List<ElementVisuel> targets = new ArrayList<>();

	private BufferedImage canon;
	private BufferedImage background;
	private BufferedImage target;
	private BufferedImage bullet;

	private double COUNTER = 1;

	public static Panel INSTANCE;

	/**
	 * Create the panel.
	 */
	public Panel() {
		INSTANCE = this;
		setLayout(null);
//		JLabel imageLabel = new JLabel();
		try {
			//background = new ImageIcon(this.getClass().getResource("../img/shstagewaterfall084slow1.gif"));
			background = ImageIO.read(new File(Panel.class.getResource("../img/hCwEjhG.png").toURI()));
			canon = ImageIO.read(new File(Panel.class.getResource("../img/piq_50889_400x400.png").toURI()));
			target = ImageIO.read(new File(Panel.class.getResource("../img/piq_96231_400x400.png").toURI()));
			bullet = ImageIO.read(new File(Panel.class.getResource("../img/piq_149543_400x400.png").toURI()));
		}
		catch (Throwable ex) {
			throw new RuntimeException(ex);
		}
//		imageLabel.setIcon(background);
//		imageLabel.setBounds(0, -15, 560, 300);
//		add(imageLabel);
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(background, 0, 0, 1200, 700, 0, 0, 1920, 1080, this);
		
		for (ElementVisuel vs : components) {
			switch (vs.getClass().getSimpleName()) {
			case "Canon":
				g.drawImage(canon, (int)vs.x, (int)vs.y, (int)vs.x + 50, (int)vs.y + 50, 0, 0, 204, 182, this);
				break;
			case "Cible":
				g.drawImage(target, (int)vs.x, (int)vs.y, (int)vs.x + 40, (int)vs.y + 40, 0, 0, 400, 400, this);
				break;
			case "Boulet":
				if (((ElementQuiBouge)vs).initialVelocity != 0) {
					((ElementQuiBouge)vs).compute(COUNTER);
					COUNTER += 0.5;
					g.drawImage(bullet, (int)vs.x, 695-(int)vs.y, (int)vs.x + 15, 695-(int)vs.y - 15, 0, 0, 103, 95, this);
					for (ElementVisuel el : targets) {
						if (el.isInside(vs.x, vs.y)) {
							SwingUtilities.invokeLater(new Runnable() {
								public void run() {
									JOptionPane.showMessageDialog(null, "Vous avez réussi !", "Hit !", JOptionPane.INFORMATION_MESSAGE);
								}
							});
						}
					}
				}
				break;
			default :
				System.out.println("Non affichable : " + vs);	
			}
		}
		
//		
//		g.drawImage(target, 600, 450, 600 + 40, 450 + 40, 0, 0, 400, 400, this);
	}

	public void add(ElementVisuel elementVisuel) {
		this.components.add(elementVisuel);
		if (elementVisuel.getClass().getSimpleName().equals("Cible")) {
			this.targets.add(elementVisuel);
		}
	}

	public void remove(ElementVisuel elementVisuel) {
		this.components.remove(elementVisuel);
	}

}
