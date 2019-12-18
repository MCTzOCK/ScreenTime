package de.mctzcok.screentime;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

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
		setTitle("ScreenTime v1");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 880, 539);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton aus = new JButton("Auswerten");
		aus.setFont(new Font("Tahoma", Font.BOLD, 50));
		aus.setBounds(10, 11, 414, 239);
		contentPane.add(aus);
		
		JButton reset = new JButton("Reset");
		reset.setFont(new Font("Tahoma", Font.BOLD, 50));
		reset.setBounds(434, 11, 414, 239);
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
		
		JButton setPassword = new JButton("Set Psswd");
		setPassword.setFont(new Font("Tahoma", Font.BOLD, 50));
		setPassword.setBounds(434, 261, 414, 239);
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
		close.setBounds(10, 261, 414, 239);
		contentPane.add(close);
		aus.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				long time = System.currentTimeMillis() - ScreenTime.startTime;
				System.out.println(time / 1000 + "s (" + time + "milis)");
				JOptionPane.showMessageDialog(null, time / 1000 + "s (" + time + "milis)");
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
