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
import javax.swing.JSpinner;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextArea;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.Color;

public class Reparações extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_5;
	private JTable table;
	String id;
	String tabela = "rep";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Reparações frame = new Reparações();
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
	public Reparações() {
		setTitle("Repara\u00E7\u00F5es");
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				try {            
					tabela = "rep";
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/oficinabd","root","");
                    Statement stmt=con.createStatement();
                    String sql="Select * from reparação";
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
		setBounds(100, 100, 797, 530);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Num Func:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(10, 24, 96, 29);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField.setBounds(105, 24, 157, 29);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblMatricula = new JLabel("Matricula:");
		lblMatricula.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblMatricula.setBounds(20, 74, 80, 27);
		contentPane.add(lblMatricula);
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_1.setColumns(10);
		textField_1.setBounds(105, 76, 157, 29);
		contentPane.add(textField_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Data:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1_1.setBounds(42, 289, 59, 27);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("KM:");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1_1_1.setBounds(62, 128, 44, 27);
		contentPane.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("Descri\u00E7\u00E3o:");
		lblNewLabel_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1_1_2.setBounds(10, 172, 96, 27);
		contentPane.add(lblNewLabel_1_1_2);
		
		JLabel lblNewLabel_1_1_3 = new JLabel("Valor:");
		lblNewLabel_1_1_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1_1_3.setBounds(40, 239, 59, 27);
		contentPane.add(lblNewLabel_1_1_3);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_2.setColumns(10);
		textField_2.setBounds(105, 291, 184, 29);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_3.setColumns(10);
		textField_3.setBounds(105, 128, 184, 29);
		contentPane.add(textField_3);
		
		textField_5 = new JTextField();
		textField_5.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_5.setColumns(10);
		textField_5.setBounds(105, 241, 184, 29);
		contentPane.add(textField_5);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(343, 125, 419, 342);
		contentPane.add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(105, 176, 184, 54);
		contentPane.add(textArea);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(tabela == "rep") {	
					int index=table.getSelectedRow();
				    TableModel row=table.getModel();
				    id = row.getValueAt(index, 0).toString();
				    String NumFuncionario=row.getValueAt(index, 1).toString();
				    textField.setText(NumFuncionario);		   
				    String Matricula=row.getValueAt(index, 2).toString();
				    textField_1.setText(Matricula);		   
				    String Data=row.getValueAt(index, 3).toString();
				    textField_2.setText(Data);
				    String KM=row.getValueAt(index, 4).toString();
				    textField_3.setText(KM);
				    String Descricao=row.getValueAt(index, 5).toString();
				    textArea.setText(Descricao);
				    String Valor=row.getValueAt(index, 6).toString();
				    textField_5.setText(Valor);
				}else if(tabela == "auto") {
					int index=table.getSelectedRow();
				    TableModel row=table.getModel();
				    String Matricula=row.getValueAt(index, 0).toString();
				    textField_1.setText(Matricula);	
				}else if(tabela == "func") {
					int index=table.getSelectedRow();
				    TableModel row=table.getModel();
				    String NumFunc=row.getValueAt(index, 0).toString();
				    textField.setText(NumFunc);	
				}
					
			}
				
		});
		scrollPane.setViewportView(table);
		
		JButton btnNewButton = new JButton("Ver Repara\u00E7\u00F5es");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 21));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {            
					tabela = "rep";
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/oficinabd","root","");
                    Statement stmt=con.createStatement();
                    String sql="Select * from reparação";
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
		btnNewButton.setBounds(436, 71, 193, 43);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Criar Repara\u00E7\u00E3o");
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {

				    String sql="Insert into reparação (NumFuncionario,Matricula,Data,KM,Descricao,Valor) Values ('"+textField.getText()+"', '"+textField_1.getText()+"','"+textField_2.getText()+"','"+textField_3.getText()+"','"+textArea.getText()+"','"+textField_5.getText()+"')";
				    Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/oficinabd","root","");	
 					Statement stmt=con.createStatement();	
					int ok=stmt.executeUpdate(sql);	
					System.out.println("inseridas " + ok +  " linhas na BD");
				    textField.setText(""); 
				    textField_1.setText(""); 
				    textField_2.setText(""); 
				    textField_3.setText("");
				    textArea.setText(""); 
				    textField_5.setText("");
				    
				}catch (Exception ex1) {
					JOptionPane.showMessageDialog(null, "Erro, verifique as credenciais", "Erro!", JOptionPane.OK_OPTION);
					System.out.println(ex1);
				}
			}
		});
		btnNewButton_1.setBounds(105, 370, 166, 43);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("Editar\r\n Repara\u00E7\u00E3o");
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (JOptionPane.showConfirmDialog(null, "Pretende Editar este registo?", "Atenção!", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
					try {
						String sql="UPDATE reparação SET NumFuncionario='"+textField.getText()+"', Matricula='"+textField_1.getText()+"', Data='"+textField_2.getText()+"', KM='"+textField_3.getText()+"', Descricao='"+textArea.getText()+"', Valor='"+textField_5.getText()+"'  WHERE ID='"+id+"'";;
					    Class.forName("com.mysql.jdbc.Driver");
					    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/oficinabd","root","");
					    Statement stmt=con.createStatement();
					    int ok=stmt.executeUpdate(sql);
					    System.out.println("Foi Editado " + ok +  " linha na BD");
					    textField.setText(""); 
					    textField_1.setText(""); 
					    textField_2.setText(""); 
					    textField_3.setText(""); 
					    textArea.setText("");
					    textField_5.setText(""); 
					}catch (Exception ex1) {
						JOptionPane.showMessageDialog(null, "Erro, verifique as credenciais", "Erro!", JOptionPane.OK_OPTION);
						System.out.println(ex1);
					}
				} 
			}
		});
		btnNewButton_1_1.setBounds(105, 424, 166, 43);
		contentPane.add(btnNewButton_1_1);
		
		JButton btnNewButton_1_1_1 = new JButton("---->");
		btnNewButton_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Home f2 = new Home();
				f2.setVisible(true);
			}
		});
		btnNewButton_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton_1_1_1.setBounds(687, 18, 75, 46);
		contentPane.add(btnNewButton_1_1_1);
		
		JLabel lblGerirReparaes = new JLabel("Gerir Repara\u00E7\u00F5es");
		lblGerirReparaes.setFont(new Font("Tahoma", Font.PLAIN, 35));
		lblGerirReparaes.setBounds(373, 3, 292, 56);
		contentPane.add(lblGerirReparaes);
		
		JButton btnNewButton_1_1_1_1 = new JButton("Ver");
		btnNewButton_1_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {            
					tabela = "func";
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
		btnNewButton_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton_1_1_1_1.setBounds(272, 24, 59, 29);
		contentPane.add(btnNewButton_1_1_1_1);
		
		JButton btnNewButton_1_1_1_1_1 = new JButton("Ver");
		btnNewButton_1_1_1_1_1.addActionListener(new ActionListener() {
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
		btnNewButton_1_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton_1_1_1_1_1.setBounds(272, 74, 59, 29);
		contentPane.add(btnNewButton_1_1_1_1_1);
		
		JLabel lblNewLabel_1_1_4 = new JLabel("Ex: AAAA-MM-DD");
		lblNewLabel_1_1_4.setForeground(Color.LIGHT_GRAY);
		lblNewLabel_1_1_4.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1_1_4.setBounds(115, 332, 174, 27);
		contentPane.add(lblNewLabel_1_1_4);
	}
}
