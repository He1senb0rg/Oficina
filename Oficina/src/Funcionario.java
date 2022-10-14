import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.TableModel;

import net.proteanit.sql.DbUtils;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
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
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class Funcionario extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTable table;

	String id;
	int Trabalha;
	private JPasswordField textField_4;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Funcionario frame = new Funcionario();
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
	public Funcionario() {
		setTitle("Funcion\u00E1rios");
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				try {            

                    Class.forName("com.mysql.jdbc.Driver");
                    Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/oficinabd","root","");
                    Statement stmt=con.createStatement();
                    String sql="Select * from funcionário";
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
		setBounds(100, 100, 802, 536);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNome.setBounds(41, 77, 69, 37);
		contentPane.add(lblNome);
		
		JLabel lblApelido = new JLabel("Morada:");
		lblApelido.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblApelido.setBounds(29, 125, 81, 37);
		contentPane.add(lblApelido);
		
		JLabel lblFuno = new JLabel("Num SS:");
		lblFuno.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblFuno.setBounds(29, 178, 81, 37);
		contentPane.add(lblFuno);
		
		JLabel lblNib = new JLabel("NIB:");
		lblNib.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNib.setBounds(61, 226, 49, 37);
		contentPane.add(lblNib);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField.setBounds(120, 77, 178, 37);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_1.setColumns(10);
		textField_1.setBounds(120, 125, 178, 37);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_2.setColumns(10);
		textField_2.setBounds(120, 178, 178, 37);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_3.setColumns(10);
		textField_3.setBounds(120, 226, 178, 37);
		contentPane.add(textField_3);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 16));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Trabalha", "Despedido"}));
		comboBox.setBounds(120, 322, 181, 37);
		contentPane.add(comboBox);
		
		JButton btnNewButton = new JButton("Criar Funcion\u00E1rio");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if(comboBox.getSelectedItem() == "Trabalha") {
						Trabalha = 1;
					}else if(comboBox.getSelectedItem() == "Despedido"){
						Trabalha = 0;
					}
				    String sql="Insert into funcionário (Nome,Morada,NumSS,NIB,Senha,Ativo) Values ('"+textField.getText()+"', '"+textField_1.getText()+"','"+textField_2.getText()+"','"+textField_3.getText()+"','"+textField_4.getText()+"','"+Trabalha+"')";
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
					comboBox.setSelectedItem("Trabalha");
				}catch (Exception ex1) {
					JOptionPane.showMessageDialog(null, "Erro, verifique as credenciais", "Erro!", JOptionPane.OK_OPTION);
					System.out.println(ex1);
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton.setBounds(67, 370, 178, 48);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Editar Funcion\u00E1rio");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (JOptionPane.showConfirmDialog(null, "Pretende Editar este registo?", "Atenção!", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
					if(comboBox.getSelectedItem() == "Trabalha") {
						Trabalha = 1;
					}else if(comboBox.getSelectedItem() == "Despedido"){
						Trabalha = 0;
					}
					try {
						String sql="UPDATE funcionário SET Nome='"+textField.getText()+"', Morada='"+textField_1.getText()+"', NumSS='"+textField_2.getText()+"', NIB='"+textField_3.getText()+"', Ativo='"+Trabalha+"' WHERE NumFuncionario='"+id+"'";;
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
					    comboBox.setSelectedItem("Trabalha");
					}catch (Exception ex1) {
						JOptionPane.showMessageDialog(null, "Erro, verifique as credenciais", "Erro!", JOptionPane.OK_OPTION);
						System.out.println(ex1);
					}
				} 
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton_1.setBounds(66, 428, 179, 48);
		contentPane.add(btnNewButton_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(347, 81, 418, 347);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int index=table.getSelectedRow();
			    TableModel row=table.getModel();
			    id = row.getValueAt(index, 0).toString();
			    String Morada=row.getValueAt(index, 2).toString();
			    textField.setText(Morada);		   
			    String Nome=row.getValueAt(index, 1).toString();
			    textField_1.setText(Nome);		   
			    String NumSS=row.getValueAt(index, 3).toString();
			    textField_2.setText(NumSS);
			    String NIB=row.getValueAt(index, 4).toString();
			    textField_3.setText(NIB);
			    String Senha=row.getValueAt(index, 5).toString();
			    textField_4.setText(Senha);
			    String Ativo=row.getValueAt(index, 6).toString();
			    if(Ativo == "true") {
			    	comboBox.setSelectedItem("Trabalha");
			    }else if(Ativo == "false") {
			    	comboBox.setSelectedItem("Despedido");
			    }
			    
			}
		});
		scrollPane.setViewportView(table);
		
		JButton btnNewButton_2 = new JButton("Ver Funcion\u00E1rios");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {            

                    Class.forName("com.mysql.jdbc.Driver");
                    Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/oficinabd","root","");
                    Statement stmt=con.createStatement();
                    String sql="Select * from funcionário";
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
		btnNewButton_2.setBounds(427, 27, 202, 43);
		contentPane.add(btnNewButton_2);
		
		JLabel lblNib_1 = new JLabel("Senha:");
		lblNib_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNib_1.setBounds(41, 272, 69, 37);
		contentPane.add(lblNib_1);
		
		textField_4 = new JPasswordField();
		textField_4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_4.setColumns(10);
		textField_4.setBounds(120, 274, 178, 37);
		contentPane.add(textField_4);
		
		JLabel lblNib_1_1 = new JLabel("Ativo:");
		lblNib_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNib_1_1.setBounds(41, 323, 69, 37);
		contentPane.add(lblNib_1_1);
		
		JButton btnNewButton_1_1_1 = new JButton("---->");
		btnNewButton_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Home f2 = new Home();
				f2.setVisible(true);
			}
		});
		btnNewButton_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton_1_1_1.setBounds(690, 11, 75, 46);
		contentPane.add(btnNewButton_1_1_1);
		
		JLabel lblGerirFuncionrios = new JLabel("Gerir Funcion\u00E1rios");
		lblGerirFuncionrios.setFont(new Font("Tahoma", Font.PLAIN, 35));
		lblGerirFuncionrios.setBounds(41, 10, 340, 56);
		contentPane.add(lblGerirFuncionrios);
		
	}
}
