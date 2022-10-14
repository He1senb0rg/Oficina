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
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
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

public class Carros extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTable table;
	String id;
	private JTextField textField_4;
	String tabela = "auto";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Carros frame = new Carros();
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
	public Carros() {
		setTitle("Carros");
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				try {            
					tabela = "auto";
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/oficinabd","root","");
                    Statement stmt=con.createStatement();
                    String sql="Select * from automóvel";
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
		setBounds(100, 100, 734, 490);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Matricula:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(32, 61, 109, 50);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField.setBounds(131, 70, 150, 37);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblMarca = new JLabel("Marca:");
		lblMarca.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblMarca.setBounds(44, 174, 74, 39);
		contentPane.add(lblMarca);
		
		JLabel lblNewLabel_1_1 = new JLabel("Ano:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_1.setBounds(58, 218, 60, 50);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Modelo:");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_1_1.setBounds(32, 267, 86, 50);
		contentPane.add(lblNewLabel_1_1_1);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_1.setColumns(10);
		textField_1.setBounds(131, 177, 150, 37);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_2.setColumns(10);
		textField_2.setBounds(131, 227, 150, 37);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_3.setColumns(10);
		textField_3.setBounds(131, 276, 150, 37);
		contentPane.add(textField_3);
		
		JButton btnNewButton = new JButton("Criar Carro");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
				    String sql="Insert into automóvel (Matricula,NumCliente,Marca,Ano,Modelo) Values ('"+textField.getText()+"', '"+textField_4.getText()+"', '"+textField_1.getText()+"','"+textField_2.getText()+"','"+textField_3.getText()+"')";
				    Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/oficinabd","root","");	
 					Statement stmt=con.createStatement();	
					int ok=stmt.executeUpdate(sql);	
					System.out.println("inseridas " + ok +  " linhas na BD");
				    textField.setText(""); 
				    textField_1.setText(""); 
				    textField_2.setText(""); 
				    textField_3.setText("");
				    textField_4.setText(""); 
				    
				}catch (Exception ex1) {
					JOptionPane.showMessageDialog(null, "Erro, verifique as credenciais", "Erro!", JOptionPane.OK_OPTION);
					System.out.println(ex1);
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton.setBounds(74, 326, 150, 44);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Editar Carro");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					if (JOptionPane.showConfirmDialog(null, "Pretende Editar este registo?", "Atenção!", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
						try {
							String sql="UPDATE automóvel SET Matricula='"+textField.getText()+"', NumCliente='"+textField_4.getText()+"', Marca='"+textField_1.getText()+"', Ano='"+textField_2.getText()+"', Modelo='"+textField_3.getText()+"'  WHERE Matricula='"+id+"'";;
						    Class.forName("com.mysql.jdbc.Driver");
						    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/oficinabd","root","");
						    Statement stmt=con.createStatement();
						    int ok=stmt.executeUpdate(sql);
						    System.out.println("Foi Editado " + ok +  " linha na BD");
						    textField.setText(""); 
						    textField_1.setText(""); 
						    textField_2.setText(""); 
						    textField_3.setText(""); 
						    textField_4.setText(""); 
						}catch (Exception ex1) {
							JOptionPane.showMessageDialog(null, "Erro, verifique as credenciais", "Erro!", JOptionPane.OK_OPTION);
							System.out.println(ex1);
						}
					} 
				}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton_1.setBounds(71, 381, 153, 46);
		contentPane.add(btnNewButton_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(332, 100, 359, 274);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(tabela == "auto") {
					int index=table.getSelectedRow();
				    TableModel row=table.getModel();
				    String Matricula=row.getValueAt(index, 0).toString();
				    textField.setText(Matricula);		   
				    id = row.getValueAt(index, 0).toString();
				    String NumCliente=row.getValueAt(index, 1).toString();
				    textField_4.setText(NumCliente);
				    String Marca=row.getValueAt(index, 2).toString();
				    textField_1.setText(Marca);		   
				    String Ano=row.getValueAt(index, 3).toString();
				    textField_2.setText(Ano);
				    String Modelo=row.getValueAt(index, 4).toString();
				    textField_3.setText(Modelo);
				}else if(tabela == "clie") {
					int index=table.getSelectedRow();
				    TableModel row=table.getModel();
				    String NumCliente=row.getValueAt(index, 0).toString();
				    textField_4.setText(NumCliente);		   
				}
				
			}
			
		});
		scrollPane.setViewportView(table);
		
		JButton btnNewButton_2 = new JButton("Ver Carros");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {            
					tabela = "auto";
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/oficinabd","root","");
                    Statement stmt=con.createStatement();
                    String sql="Select * from automóvel";
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
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 21));
		btnNewButton_2.setBounds(365, 35, 210, 43);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_1_1 = new JButton("---->");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Home f2 = new Home();
				f2.setVisible(true);
			}
		});
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton_1_1.setBounds(633, 11, 75, 46);
		contentPane.add(btnNewButton_1_1);
		
		JLabel lblNumCliente = new JLabel("Num Cliente:");
		lblNumCliente.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNumCliente.setBounds(2, 113, 119, 50);
		contentPane.add(lblNumCliente);
		
		textField_4 = new JTextField();
		textField_4.setEditable(false);
		textField_4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_4.setColumns(10);
		textField_4.setBounds(131, 122, 124, 37);
		contentPane.add(textField_4);
		
		JLabel lblGerirCarros = new JLabel("Gerir Carros");
		lblGerirCarros.setFont(new Font("Tahoma", Font.PLAIN, 35));
		lblGerirCarros.setBounds(71, 3, 210, 56);
		contentPane.add(lblGerirCarros);
		
		JButton btnNewButton_1_1_1_1_1 = new JButton("Ver");
		btnNewButton_1_1_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {            
					tabela = "clie";
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
		btnNewButton_1_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton_1_1_1_1_1.setBounds(263, 122, 59, 38);
		contentPane.add(btnNewButton_1_1_1_1_1);
	}
}
