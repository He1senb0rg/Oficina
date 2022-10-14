import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setTitle("Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 765, 355);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Oficina dos Carritos");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 37));
		lblNewLabel.setBounds(195, 11, 372, 67);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Num Funcion\u00E1rio:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 29));
		lblNewLabel_1.setBounds(10, 120, 244, 35);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Senha:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 29));
		lblNewLabel_1_1.setBounds(74, 174, 105, 38);
		contentPane.add(lblNewLabel_1_1);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField.setBounds(245, 120, 168, 35);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JPasswordField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField_1.setColumns(10);
		textField_1.setBounds(189, 175, 179, 36);
		contentPane.add(textField_1);
		
		JButton btnNewButton = new JButton("Entrar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try 
				{
					Class.forName("com.mysql.jdbc.Driver");
				    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/oficinabd","root","");
	                Statement stmt = con.createStatement();
	                String sql = "Select * from funcionário Where NumFuncionario = '" + textField.getText() + "' and Senha = '" + textField_1.getText() + "'and Ativo = '" + 1 + "'";
	                System.out.println("SQL executado");
	                ResultSet rs = stmt.executeQuery(sql);
	                rs.last();
	                
	                int count=rs.getRow();
	               
					if (count > 0)
	                {	    				
						setVisible(false);						
	    				Home f2 = new Home();
	    				f2.setVisible(true);
	    				System.out.println("Entrou");
	    			}
	    			else
	    			{
	    				JOptionPane.showMessageDialog(null,"Erro, verifique as credenciais","Erro!",JOptionPane.OK_OPTION);
	    			    System.out.println("Credenciais erradas");
	    				textField.setText("");
	    				textField_1.setText("");
	    			}
				}
				catch(Exception s)
				{
    			    System.out.println("ERRO " + s);
    				textField.setText("");
    				textField_1.setText("");
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.setBounds(83, 234, 186, 52);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\andre\\Pictures\\carro.png"));
		lblNewLabel_2.setBounds(404, 89, 337, 236);
		contentPane.add(lblNewLabel_2);
	}
}
