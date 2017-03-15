package fr.exia;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class Panel extends JPanel {
	
	private static final long serialVersionUID = 1L;

	/**
	 * @author rbello
	 *
	 */
	public interface Animation {
		public double compute(double x);
	}

	private BufferedImage image;
	//private ImageIcon background;
	private BufferedImage background;
	private BufferedImage target;

	/**
	 * Create the panel.
	 */
	public Panel(Animation anim) {
		setLayout(null);
//		JLabel imageLabel = new JLabel();
		try {
			//background = new ImageIcon(this.getClass().getResource("img/shstagewaterfall084slow1.gif"));
			background = ImageIO.read(new File(Panel.class.getResource("img/hCwEjhG.png").toURI()));
			image = ImageIO.read(new File(Panel.class.getResource("img/piq_50889_400x400.png").toURI()));
			target = ImageIO.read(new File(Panel.class.getResource("img/piq_96231_400x400.png").toURI()));
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
		g.drawImage(image, 20, 620, 20 + 50, 620 + 50, 0, 0, 204, 182, this);
		g.drawImage(target, 600, 450, 600 + 40, 450 + 40, 0, 0, 400, 400, this);
	}

}
