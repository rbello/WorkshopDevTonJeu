package fr.exia.core;

import java.awt.CardLayout;
import java.awt.EventQueue;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Fenetre extends JFrame {

	private static final long serialVersionUID = 1L;

	private JPanel contentPane;

	private Panel panelAnimation;
	
	/**
	 * Create the frame.
	 */
	public Fenetre() {
		setResizable(false);
		setTitle("Balistik - Click mouse to fire !");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(20, 20, 1200, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
//		Panel.Animation anim = new MonAnimation();
		panelAnimation = new Panel();
	}

	public void afficher() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Fenetre frame = new Fenetre();
					
					
					frame.addKeyListener(new KeyAdapter() {
						public void keyPressed(KeyEvent e) {
							if (e.getKeyCode() != KeyEvent.VK_ENTER) return;
							System.out.println("Fire !!");
						}
					});
					frame.getContentPane().add(panelAnimation);
					frame.setVisible(true);
					
					Timer t = new Timer();
					t.schedule(new TimerTask() {
						@Override
						public void run() {
							panelAnimation.repaint();
						}
					}, 0, 250);
					
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});		
	}
	
	@FunctionalInterface
	public static interface MouseClick {
		public void onClick(MouseEvent e);
	}
	
	public void auClic(MouseClick task) {
		panelAnimation.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				task.onClick(e);
			}
		});
	}

}