import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.TableModel;

import net.proteanit.sql.DbUtils;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Clientes extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTable table;
	String id;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Clientes frame = new Clientes();
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
	public Clientes() {
		setTitle("Clientes");
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				try {            

                    Class.forName("com.mysql.jdbc.Driver");
                    Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/oficinabd","root","");
                    Statement stmt=con.createStatement();
                    String sql="Select * from cliente";
                    ResultSet rs=stmt.executeQuery(sql);
                    table.setModel(DbUtils.resultSetToTableModel(rs));
                    table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
                    System.out.println("Carregar dados para a tabela");
                    con.close();

                    }

				catch(Exception ee){

						System.out.println(ee);

                     }
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 705, 452);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nome:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(35, 71, 75, 38);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField.setBounds(120, 74, 154, 37);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblTelefone = new JLabel("Telefone:");
		lblTelefone.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTelefone.setBounds(10, 128, 100, 38);
		contentPane.add(lblTelefone);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_1.setColumns(10);
		textField_1.setBounds(120, 131, 154, 37);
		contentPane.add(textField_1);
		
		JLabel lblNif = new JLabel("NIF:");
		lblNif.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNif.setBounds(48, 188, 49, 38);
		contentPane.add(lblNif);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_2.setColumns(10);
		textField_2.setBounds(120, 191, 154, 37);
		contentPane.add(textField_2);
		
		JLabel lblMorada = new JLabel("Morada:");
		lblMorada.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblMorada.setBounds(23, 247, 87, 38);
		contentPane.add(lblMorada);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_3.setColumns(10);
		textField_3.setBounds(120, 250, 154, 37);
		contentPane.add(textField_3);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
		});
		scrollPane.setBounds(310, 87, 352, 272);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int index=table.getSelectedRow();
			    TableModel row=table.getModel();
			    id = row.getValueAt(index, 0).toString();
			    String Morada=row.getValueAt(index, 1).toString();
			    textField.setText(Morada);		   
			    String Nome=row.getValueAt(index, 2).toString();
			    textField_1.setText(Nome);		   
			    String NIF=row.getValueAt(index, 3).toString();
			    textField_2.setText(NIF);
			    String Telefone=row.getValueAt(index, 4).toString();
			    textField_3.setText(Telefone);
			}
		});
		scrollPane.setViewportView(table);
		
		JButton btnNewButton = new JButton("Ver Clientes");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {            

                    Class.forName("com.mysql.jdbc.Driver");
                    Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/oficinabd","root","");
                    Statement stmt=con.createStatement();
                    String sql="Select * from cliente";
                    ResultSet rs=stmt.executeQuery(sql);
                    table.setModel(DbUtils.resultSetToTableModel(rs));
                    table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
                    System.out.println("Carregar dados para a tabela");
                    con.close();

                    }

				catch(Exception ee){

						System.out.println(ee);

                     }
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 21));
		btnNewButton.setBounds(375, 27, 174, 46);
		contentPane.add(btnNewButton);
		
		JButton btnAdicionar = new JButton("Criar Cliente");
		btnAdicionar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {

				    String sql="Insert into cliente (Nome,Telefone,Nif,Morada) Values ('"+textField.getText()+"', '"+textField_1.getText()+"','"+textField_2.getText()+"','"+textField_3.getText()+"')";
				    Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/oficinabd","root","");	
 					Statement stmt=con.createStatement();	
					int ok=stmt.executeUpdate(sql);	
					System.out.println("inseridas " + ok +  " linhas na BD");
				    textField.setText(""); 
				    textField_1.setText(""); 
				    textField_2.setText(""); 
				    textField_3.setText("");
					
				}catch (Exception ex1) {
					JOptionPane.showMessageDialog(null, "Erro, verifique as credenciais", "Erro!", JOptionPane.OK_OPTION);
					System.out.println(ex1);
				}
			}
		});
		btnAdicionar.setBounds(76, 313, 154, 46);
		contentPane.add(btnAdicionar);
		
		JButton btnNewButton_1_1 = new JButton("Editar Cliente");
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (JOptionPane.showConfirmDialog(null, "Pretende Editar este registo?", "Atenção!", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
					try {
						String sql="UPDATE cliente SET Nome='"+textField.getText()+"', Telefone='"+textField_1.getText()+"', NIF='"+textField_2.getText()+"', Morada='"+textField_3.getText()+"'  WHERE NumCliente='"+id+"'";;
					    Class.forName("com.mysql.jdbc.Driver");
					    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/oficinabd","root","");
					    Statement stmt=con.createStatement();
					    int ok=stmt.executeUpdate(sql);
					    System.out.println("Foi Editado " + ok +  " linha na BD");
					    textField.setText(""); 
					    textField_1.setText(""); 
					    textField_2.setText(""); 
					    textField_3.setText(""); 
					}catch (Exception ex1) {
						JOptionPane.showMessageDialog(null, "Erro, verifique as credenciais", "Erro!", JOptionPane.OK_OPTION);
						System.out.println(ex1);
					}
				} 
			}
		});
				
		btnNewButton_1_1.setBounds(76, 366, 154, 38);
		contentPane.add(btnNewButton_1_1);
		
		JButton btnNewButton_1 = new JButton("---->");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Home f2 = new Home();
				f2.setVisible(true);
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton_1.setBounds(606, 11, 75, 46);
		contentPane.add(btnNewButton_1);
		
		JLabel lblGerirClientes = new JLabel("Gerir Clientes");
		lblGerirClientes.setFont(new Font("Tahoma", Font.PLAIN, 35));
		lblGerirClientes.setBounds(65, 4, 221, 56);
		contentPane.add(lblGerirClientes);
	}
}
