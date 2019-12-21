package de.mctzcok.screentime;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Color;

public class ScreenTimeUI extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void init() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ScreenTimeUI frame = new ScreenTimeUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ScreenTimeUI() {
		setResizable(false);
		setTitle("ScreenTime v1.2");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 1583, 369);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton aus = new JButton("Get Time");
		aus.setFont(new Font("Tahoma", Font.BOLD, 50));
		aus.setBounds(10, 11, 414, 318);
		contentPane.add(aus);
		
		JButton reset = new JButton("Reset");
		reset.setFont(new Font("Tahoma", Font.BOLD, 50));
		reset.setBounds(858, 11, 383, 55);
		contentPane.add(reset);
		reset.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String gp = JOptionPane.showInputDialog("Please insert password");
				if(ScreenTimePsswd.getPassword().equals(gp))
				{
					ScreenTime.startTime = System.currentTimeMillis();
					JOptionPane.showMessageDialog(null, "Reseted!");
				}else
				{
					JOptionPane.showMessageDialog(null, "Incorrect!");
				}
			}
		});
		
		JButton setPassword = new JButton("Set Password");
		setPassword.setFont(new Font("Tahoma", Font.BOLD, 50));
		setPassword.setBounds(434, 11, 414, 55);
		contentPane.add(setPassword);
		setPassword.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(ScreenTimePsswd.getPassword().equals(""))
				{
					String gp = JOptionPane.showInputDialog("Please insert password");
					String gp1 = JOptionPane.showInputDialog("Please insert password again");
					if(gp.equals(gp1))
					{
						try {
							Compiler.compile(gp, "Löwe.Kappe.Turnschuhe.Schwarz");
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}else
					{
						JOptionPane.showMessageDialog(null, "Error!");
					}
				}else
				{
					JOptionPane.showMessageDialog(null, "Already set!");
				}
			}
		});
		
		JButton close = new JButton("Close");
		close.setFont(new Font("Tahoma", Font.BOLD, 50));
		close.setBounds(1251, 11, 307, 318);
		contentPane.add(close);
		
		JLabel lblScreentimeVersion = new JLabel("ScreenTime Version 1.2");
		lblScreentimeVersion.setForeground(Color.CYAN);
		lblScreentimeVersion.setBackground(Color.CYAN);
		lblScreentimeVersion.setHorizontalAlignment(SwingConstants.CENTER);
		lblScreentimeVersion.setFont(new Font("Lato", Font.BOLD, 68));
		lblScreentimeVersion.setBounds(86, 92, 1481, 199);
		contentPane.add(lblScreentimeVersion);
		
		JLabel lblWerAreNot = new JLabel("Copyright (c) 2019 YouTime. A MCTzOCK.DE Company. All rights reserved.");
		lblWerAreNot.setHorizontalAlignment(SwingConstants.CENTER);
		lblWerAreNot.setForeground(new Color(255, 255, 255, 255));
		lblWerAreNot.setBounds(10, 265, 1548, 72);
		contentPane.add(lblWerAreNot);
		
		JLabel bg = new JLabel("");
		bg.setBounds(0, 0, 1577, 340);
		bg.setIcon(new ImageIcon("database/bg.png"));
		contentPane.add(bg);
		aus.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				long time = System.currentTimeMillis() - ScreenTime.startTime;
				System.out.println(time / 1000 / 60 + " Minuten");
				JOptionPane.showMessageDialog(null, time / 1000 / 60 + " Minuten (Sekunden: " + time / 1000 + ")");
			}
		});
		close.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String gp = JOptionPane.showInputDialog("Please insert password");
				if(ScreenTimePsswd.getPassword().equals(gp))
				{
					System.out.println("exit");
					System.exit(0);
				}else
				{
					JOptionPane.showMessageDialog(null, "Incorrect!");
				}
			}
		});
	}
}
