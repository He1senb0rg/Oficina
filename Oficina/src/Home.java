import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class Home extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home frame = new Home();
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
	public Home() {
		setTitle("Home");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 746, 496);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Funcion\u00E1rios");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);						
				Funcionario f2 = new Funcionario();
				f2.setVisible(true);
			}
		});
		btnNewButton.setBounds(184, 161, 165, 100);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Clientes");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);					
				Clientes f2 = new Clientes();
				f2.setVisible(true);
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btnNewButton_1.setBounds(184, 276, 165, 109);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("Bem-Vindo \u00E0 Oficina dos Carritos!");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel.setBounds(137, 11, 468, 59);
		contentPane.add(lblNewLabel);
		
		JButton btnCarros = new JButton("Carros");
		btnCarros.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);					
				Carros f2 = new Carros();
				f2.setVisible(true);
			}
		});
		btnCarros.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btnCarros.setBounds(364, 161, 165, 100);
		contentPane.add(btnCarros);
		
		JButton btnNewButton_2_1 = new JButton("Repara\u00E7\u00F5es");
		btnNewButton_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);					
				Reparações f2 = new Reparações();
				f2.setVisible(true);
			}
		});
		btnNewButton_2_1.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btnNewButton_2_1.setBounds(364, 276, 165, 109);
		contentPane.add(btnNewButton_2_1);
		
		JLabel lblOQuePretende = new JLabel("O que pretende fazer?");
		lblOQuePretende.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblOQuePretende.setBounds(230, 91, 278, 59);
		contentPane.add(lblOQuePretende);
		
		JButton btnNewButton_2_1_1 = new JButton("Sair");
		btnNewButton_2_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);					
				Login f2 = new Login();
				f2.setVisible(true);
			}
		});
		btnNewButton_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btnNewButton_2_1_1.setBounds(583, 377, 124, 59);
		contentPane.add(btnNewButton_2_1_1);
	}
}
