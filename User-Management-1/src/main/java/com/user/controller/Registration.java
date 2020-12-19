package com.user.controller;

import java.awt.Button;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.ScrollPane;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.naming.directory.SearchResult;
import javax.persistence.Table;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.user.model.Add;
import com.user.model.User;
import com.user.model.Valid;
import com.user.service.RegisterService;
import com.user.service.RegisterServiceImpl;

@Component
public class Registration implements FocusListener{

	@Autowired
    RegisterService registerservice;


	
    User user=new User();
    Add  add=new Add();
    Valid valid=new Valid();
    
	private JFrame frame;
	private JTextField txtFn;
	private JTextField txtMn;
	private JTextField txtLn;
	private JTextField txtEma;
	private JTextField txtPho;
	private JTextField txtCountry;
	private JTextField txtCity;
	private JTextField txtPincode;
	private JTextField txtRegistrationForm;
	private JLabel emailvalid;
	private JLabel passvalid;
	private JPasswordField passwordField_1;
	int pos=0;
	int emailvalidity=1;
	int flag;
	int glob;
	private JLabel LABEL5;
	private JLabel LABEL6;
	private JPasswordField passwordField;
	private JLabel lblNewLabel_13;
	private JLabel LABEL3;
	private JLabel LABEL1;
	private Button button; 
	private JLabel LABEL7;
	private JLabel LABEL4;
	private JLabel LABEL8;
	private JButton btnNewButton_2;
	private JComboBox comboBox_1;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JTextField textField;
	private JPasswordField passwordFieldLogin;
	private JTable table_1;
	private JButton btnNewButton_0;
	private JButton btnNewButton_10;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12;
	private JTextField textField_13;
	private JTable table;
	private JScrollPane scrollPane;
	private DefaultTableModel model;
	
	    /**
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Registration window = new Registration();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Registration() {
		initializeLand();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		frame = new JFrame();
		frame.setVisible(true);
		frame.getContentPane().setFont(new Font("Tahoma", Font.BOLD, 11));
		frame.getContentPane().setForeground(SystemColor.activeCaption);
		frame.getContentPane().setBackground(SystemColor.menu);
		frame.setBounds(100, 100, 1133, 617);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("First Name*");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setBounds(22, 84, 79, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		txtFn = new JTextField();
		txtFn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		txtFn.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if((txtFn.getText().length() == 0 )) {
					LABEL1.setVisible(true);
					  Border border = BorderFactory.createLineBorder(Color.RED, 1);
					txtFn.setBorder(border);
					
	                }
				
			}
			@Override
			public void focusLost(FocusEvent e) {
				Border border = BorderFactory.createLineBorder(Color.BLACK, 1);
				 txtFn.setBorder(border);
				 LABEL1.setVisible(false);
			}
		});
		txtFn.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
                String firstname = txtFn.getText();
				char c=e.getKeyChar();
				if(!(Character.isLetter(c) || (c==KeyEvent.VK_BACK_SPACE)|| c==KeyEvent.VK_DELETE)) {
                    Toolkit.getDefaultToolkit().beep();
                    e.consume();
                    

                
                }
				
  				
              
                else if(firstname.length()>=20) {
                    Toolkit.getDefaultToolkit().beep();
                    e.consume();
                    JOptionPane.showMessageDialog(null, "characters exceeded its length");
                    
                 }
                else {
                	LABEL1.setVisible(false);
     	          
                }
				check();
				
			}
			@Override
			public void keyReleased(KeyEvent e) {
				int position = txtFn.getCaretPosition();
				txtFn.setText(txtFn.getText().toUpperCase());
				txtFn.setCaretPosition(position);
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				valid();
			}
		});
		txtFn.setBounds(111, 82, 150, 31);
		frame.getContentPane().add(txtFn);
		txtFn.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Middle Name");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2.setBounds(349, 84, 86, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		txtMn = new JTextField();
		txtMn.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				String middlename = txtMn.getText();
				char c=e.getKeyChar();
				 if(!(Character.isLetter(c) || (c==KeyEvent.VK_BACK_SPACE)|| c==KeyEvent.VK_DELETE)) {
	                    Toolkit.getDefaultToolkit().beep();
	                    e.consume();
	                }
	                else if(middlename.length()>=20) {
	                    Toolkit.getDefaultToolkit().beep();
	                    JOptionPane.showMessageDialog(null,"characters exceeded its length");
	                    e.consume();
	                 }
			}
			@Override
			public void keyReleased(KeyEvent e) {
				int position = txtMn.getCaretPosition();
				txtMn.setText(txtMn.getText().toUpperCase());
				txtMn.setCaretPosition(position);
			}
			
		});
		txtMn.setBounds(476, 82, 140, 31);
		frame.getContentPane().add(txtMn);
		txtMn.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Last Name");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_3.setBounds(734, 84, 72, 14);
		frame.getContentPane().add(lblNewLabel_3);
		
		txtLn = new JTextField();
		txtLn.setHorizontalAlignment(SwingConstants.CENTER);
		txtLn.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				String lastname = txtLn.getText();
				char c=e.getKeyChar();
				 if(!(Character.isLetter(c) || (c==KeyEvent.VK_BACK_SPACE)|| c==KeyEvent.VK_DELETE)) {
	                    Toolkit.getDefaultToolkit().beep();
	                    e.consume();
	                }
	                else if(lastname.length()>=20) {
	                    Toolkit.getDefaultToolkit().beep();
	                    e.consume();
	                    JOptionPane.showMessageDialog(null,"characters exceeded its length");
	                 }
			}
			@Override
			public void keyReleased(KeyEvent e) {
				int position = txtLn.getCaretPosition();
				txtLn.setText(txtLn.getText().toUpperCase());
				txtLn.setCaretPosition(position);
			}
		});
		txtLn.setBounds(832, 82, 140, 31);
		frame.getContentPane().add(txtLn);
		txtLn.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Email*");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_4.setBounds(22, 191, 46, 14);
		frame.getContentPane().add(lblNewLabel_4);
		
		txtEma = new JTextField();
		txtEma.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(txtEma.getText().length()==0) {
				emailvalid.setVisible(true);
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				emailvalid.setVisible(false);
			}
			
		});
		txtEma.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				boolean status = EmailValidation.email_validation(txtEma.getText());
				if(status) {
//					btnNewButton.setEnabled(true);
					emailvalid.setVisible(false);
					
				
//					flag=0;
				}else {
//					btnNewButton.setEnabled(false);
					emailvalid.setVisible(false);
					
//					flag=1;
				}
				
				valid();
				
				
			}
			
			
			@Override
			public void keyReleased(KeyEvent e) {
				String emailid=txtEma.getText();
				try {
                    if(registerservice.emailvalid(emailid)) {

                          JOptionPane.showMessageDialog(null, "email already exists");
                          emailvalidity=0;
                          
                      }
		            else {
		            	if(e.getExtendedKeyCode()==KeyEvent.VK_BACK_SPACE || e.getExtendedKeyCode()==KeyEvent.VK_DELETE) 
						e.consume();
		            	emailvalidity=1;
		            }
		            	
		            
				} catch (Exception e2) {
					
					System.out.println(emailid);
				}
				
				check();
			}
			
			@Override
			public void keyTyped(KeyEvent e) {
				if(txtEma.getText().length()>=50) {
                    e.consume();
                }
                if((txtEma.getText() == null)) {
					emailvalid.setVisible(true);
	                }
			}
		});
		txtEma.setBounds(111, 188, 150, 31);
		frame.getContentPane().add(txtEma);
		txtEma.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Gender");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_5.setBounds(734, 191, 46, 14);
		frame.getContentPane().add(lblNewLabel_5);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"--select--","male","female","others"}));
		comboBox.setBounds(832, 188, 140, 31);
		frame.getContentPane().add(comboBox);
		
		
		
       
        
        
		JLabel lblNewLabel_6 = new JLabel("Phone Number*");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_6.setBounds(349, 191, 101, 14);
		frame.getContentPane().add(lblNewLabel_6);
		
		txtPho = new JTextField();
		txtPho.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				 if (txtPho.getText().length()==0) {
						LABEL3.setVisible(true);
						  Border border = BorderFactory.createLineBorder(Color.RED, 1);
						txtPho.setBorder(border);
						LABEL3.setForeground(Color.red);
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				Border border = BorderFactory.createLineBorder(Color.BLACK, 1);
				 txtPho.setBorder(border);
				 LABEL3.setVisible(false);
			}
		});
		txtPho.addKeyListener(new KeyAdapter() {
			
			@Override
			public void keyPressed(KeyEvent e) {
				String phonenumber = txtPho.getText();
				int length = phonenumber.length();
				char c=e.getKeyChar();
				if(e.getKeyChar()>='0' && e.getKeyChar()<='9') {
					if(length!=10) {
						txtPho.setEditable(true);
//					    btnNewButton.setEnabled(true);
						
//						flag=0;
					}
					else {
//						btnNewButton.setEnabled(false);
						txtPho.setEditable(false);
					
						
						
//						flag=1;
//						
					}
					if(Character.isLetter(c)) {
						txtPho.setEditable(false);
//						btnNewButton.setEnabled(false);
						
						
					}
				}
				else {
					if(e.getExtendedKeyCode()==KeyEvent.VK_BACK_SPACE || e.getExtendedKeyCode()==KeyEvent.VK_DELETE || Character.isDigit(c)) {
						txtPho.setEditable(true);
					}
					else {
						txtPho.setEditable(false);
					}
					
				}
				
				valid();
				
				
			}
			
			
			@Override
			public void keyReleased(KeyEvent e) {
				check();
			}
		});
		txtPho.setBounds(476, 189, 140, 30);
		frame.getContentPane().add(txtPho);
		txtPho.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("Country*");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_7.setBounds(349, 388, 86, 14);
		frame.getContentPane().add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Password*");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_8.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_8.setBounds(22, 296, 79, 14);
		frame.getContentPane().add(lblNewLabel_8);
		
		txtCountry = new JTextField();
		txtCountry.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				
				 if (txtCountry.getText().length()==0) {
						LABEL4.setVisible(true);
						  Border border = BorderFactory.createLineBorder(Color.RED, 1);
						txtCountry.setBorder(border);
						LABEL4.setForeground(Color.red);
				};
			}
			@Override
			public void focusLost(FocusEvent e) {
				LABEL4.setVisible(false);
				 Border border = BorderFactory.createLineBorder(Color.BLACK, 1);
				 txtCountry.setBorder(border);
			}
		});
		txtCountry.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				String username = txtCountry.getText();
				
				char c=e.getKeyChar();
				if(!(Character.isLetter(c) || (c==KeyEvent.VK_BACK_SPACE)|| c==KeyEvent.VK_DELETE)) {
                    Toolkit.getDefaultToolkit().beep();
//                    btnNewButton.setEnabled(false);
                    LABEL4.setVisible(false);
                  
                   
                    e.consume();
                }
                else if(username.length()>=20) {
                    Toolkit.getDefaultToolkit().beep();
                    e.consume();
//                    btnNewButton.setEnabled(false);
                   JOptionPane.showMessageDialog(null, "characters exceeded its length");
               
                   
                 }
                else {
//                	btnNewButton.setEnabled(true);
                	LABEL4.setVisible(false);
               
                }
				
				check();
			}
			@Override
			public void keyReleased(KeyEvent e) {
				
				int position = txtCountry.getCaretPosition();
				txtCountry.setText(txtCountry.getText().toUpperCase());
				txtCountry.setCaretPosition(position);
				
				check();
			}
			
			
			@Override
			public void keyPressed(KeyEvent e) {
				valid();
			}
		});
		txtCountry.setBounds(476, 388, 140, 30);
		frame.getContentPane().add(txtCountry);
		txtCountry.setColumns(10);
		
		JLabel lblNewLabel_9 = new JLabel("State");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_9.setBounds(22, 393, 46, 14);
		frame.getContentPane().add(lblNewLabel_9);
		
		comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"--select--","Andhra Pradesh",
                "Arunchal Pradesh",
                "Assam",
                "Bihar",
                "Chhattisgarh",
                "Goa",
                "Gujarat",
                "Haryana",
                "Himachal Pradesh",
                "Jharkhand",
                "Karnataka",
                "Kerala",
                "Madhaya Pradesh",
                "Maharashtra",
                "Manipur",
                "Meghalaya",
                "Mizoram",
                "Nagaland",
                "Odisha",
                "Punjab",
                "Rajasthan",
                "Sikkim",
                "Tamil Nadu",
                "Telangana",
                "Tripura",
                "Uttar Pradesh",
                "Uttarakhand",
                "West Bengal",
                "Andaman & Nicobar",
                "Chandigarh",
                "Dadra & Nagar Haveli & Daman & Diu",
                "Delhi",
                "Jammu & Kashmir",
                "Ladakh",
                "Lakshadweep",
                "Puducherry"}));
		comboBox_1.setBounds(111, 387, 150, 31);
		frame.getContentPane().add(comboBox_1);
		
		
		JLabel lblNewLabel_10 = new JLabel("City*");
		lblNewLabel_10.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_10.setBounds(734, 296, 46, 14);
		frame.getContentPane().add(lblNewLabel_10);
		
		txtCity = new JTextField();
		txtCity.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (txtCity.getText().length()==0) {
					LABEL7.setVisible(true);
					  Border border = BorderFactory.createLineBorder(Color.RED, 1);
					txtCity.setBorder(border);
					
			}
			}
			@Override
			public void focusLost(FocusEvent e) {
				LABEL7.setVisible(false);
				 Border border = BorderFactory.createLineBorder(Color.BLACK, 1);
				 txtCity.setBorder(border);
			}
		});
		txtCity.setHorizontalAlignment(SwingConstants.CENTER);
		txtCity.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				String city= txtCity.getText();
				char c=e.getKeyChar();
				
				if(!(Character.isLetter(c) || (c==KeyEvent.VK_BACK_SPACE)|| c==KeyEvent.VK_DELETE)) {
                    Toolkit.getDefaultToolkit().beep();
//                    btnNewButton.setEnabled(false);
                    e.consume();
                   
                }
                else if(city.length()>=20) {
                    Toolkit.getDefaultToolkit().beep();
                    e.consume();
                    JOptionPane.showMessageDialog(null, "characters exceeded its length");
//                    btnNewButton.setEnabled(false);

                   
                 }
                else {
//                	btnNewButton.setEnabled(true);

                	
                }
				check();
				
			}
			@Override
			public void keyReleased(KeyEvent e) {
				int position = txtCity.getCaretPosition();
				txtCity.setText(txtCity.getText().toUpperCase());
				txtCity.setCaretPosition(position);
				
			}
			@Override
			public void keyPressed(KeyEvent e) {
				valid();
			}
		});
		txtCity.setBounds(832, 294, 140, 31);
		frame.getContentPane().add(txtCity);
		txtCity.setColumns(10);
		
		JLabel lblNewLabel_11 = new JLabel("Pincode*");
		lblNewLabel_11.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_11.setBounds(734, 396, 66, 12);
		frame.getContentPane().add(lblNewLabel_11);
		
		txtPincode = new JTextField();
		txtPincode.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (txtPincode.getText().length()==0) {
					LABEL8.setVisible(true);
					  Border border = BorderFactory.createLineBorder(Color.RED, 1);
					txtPincode.setBorder(border);
					
			}
			}
			@Override
			public void focusLost(FocusEvent e) {
				LABEL8.setVisible(false);
				Border border = BorderFactory.createLineBorder(Color.BLACK, 1);
				 txtPincode.setBorder(border);
			}
		});
		txtPincode.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
                String pincode = txtPincode.getText();

				int length = pincode.length();
				
				char c=e.getKeyChar();
				
				if(e.getKeyChar()>='0' && e.getKeyChar()<='9') {
					if(length<6) {
//					btnNewButton.setEnabled(true);
					txtPincode.setEditable(true);
//					flag=0;
					
				
				}
				else {
					txtPincode.setEditable(false);
//					btnNewButton.setEnabled(false);
//					flag=1;
//					
				}
				}
				else {
					if(e.getExtendedKeyCode()==KeyEvent.VK_BACK_SPACE || e.getExtendedKeyCode()==KeyEvent.VK_DELETE ) {
						txtPincode.setEditable(true);
					}
					else {
						txtPincode.setEditable(false);
					}
					
					if(Character.isLetter(c)){ 
//						btnNewButton.setEnabled(false);
						txtPho.setEditable(false);
						
						
					}
					else {
						txtPho.setEditable(true);
						
					}
					
					
					
		
					
				}
				
				valid();
				
				}
			
			
			@Override
			public void keyReleased(KeyEvent e) {
				check();
			}
		});
		txtPincode.setBounds(832, 388, 140, 30);
		frame.getContentPane().add(txtPincode);
		txtPincode.setColumns(10);
	
		
		btnNewButton = new JButton("REGISTER");
	btnNewButton.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton.setBackground(UIManager.getColor("Button.background"));
		btnNewButton.setEnabled(false);
		try {
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				user.setFirstname(txtFn.getText());
                user.setMiddlename(txtMn.getText());
                user.setLastname(txtLn.getText());
                user.setEmailid(txtEma.getText());
                user.setGender(comboBox.getSelectedItem().toString());
                user.setMobilenumber(txtPho.getText());
                
                
                add.setEmailid(txtEma.getText());
                add.setCity(txtCity.getText());
                add.setState(comboBox_1.getSelectedItem().toString());
                add.setPincode(txtPincode.getText());
                add.setCountry(txtCountry.getText());
                
                valid.setEmailid(txtEma.getText());
                valid.setPassword(passwordField.getText());
                valid.setConfirm(passwordField_1.getText() );
				
				
			     System.out.println("user entered");
			     System.out.println(user);
				 registerservice.saveData(valid,user,add);
                 JOptionPane.showMessageDialog(btnNewButton, "your account is successfully created");
		        
	
				}
						
				
				
					
				
				
				
			
			
		});
		}
		catch (Exception e) {
			System.out.println("hello");
		}
		btnNewButton.setBounds(304, 484, 140, 44);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("CLEAR");
		btnNewButton_1.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_1.setBackground(UIManager.getColor("Button.background"));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				txtFn.setText(null);
                txtMn.setText(null);
                txtLn.setText(null);
               txtEma.setText(null);
                
                txtPho.setText(null);
                
                
                
                txtCity.setText(null);
                
               txtPincode.setText(null);
                txtCountry.setText(null);
                
             
                passwordField.setText(null);
                passwordField_1.setText(null) ;
				
				
			    

					
				
			}
		
		
		
		
		
		});
		
		
		
		btnNewButton_1.setBounds(661, 484, 140, 44);
		frame.getContentPane().add(btnNewButton_1);
		
		emailvalid = new JLabel("please enter email");
		emailvalid.setVisible(false);
		emailvalid.setForeground(Color.RED);
		emailvalid.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 10));
		emailvalid.setBounds(111, 219, 150, 14);
		frame.getContentPane().add(emailvalid);
		
		
		
		JLabel lblNewLabel_13 = new JLabel("Confirm Password*");
		lblNewLabel_13.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_13.setForeground(new Color(0, 0, 0));
		lblNewLabel_13.setBounds(349, 296, 127, 14);
		frame.getContentPane().add(lblNewLabel_13);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(!passwordField.getText().equals(passwordField_1.getText())) {
					LABEL6.setVisible(true);
					  Border border = BorderFactory.createLineBorder(Color.RED, 1);
					  passwordField_1.setBorder(border);
					  LABEL6.setForeground(Color.red);
				}
					if(passwordField.getText().equals(passwordField_1.getText())) {
	        			LABEL6.setVisible(false);
	        			Border border = BorderFactory.createLineBorder(Color.BLACK, 1);
	   				 passwordField_1.setBorder(border);
	        		}
				
				
			}
			@Override
			public void focusLost(FocusEvent e) {
				LABEL6.setVisible(false);
				Border border = BorderFactory.createLineBorder(Color.BLACK, 1);
				  passwordField_1.setBorder(border);
			}
		});
		passwordField_1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				String password= passwordField_1.getText();
				String password1=passwordField.getText();
				if(password.equals(password1)) {
//					btnNewButton.setEnabled(true);
					LABEL6.setVisible(false);
					
					
				}
				else {
//					btnNewButton.setEnabled(false);
					LABEL6.setVisible(false);
					
				}
				check();
				
				
			}
			@Override
			public void keyPressed(KeyEvent e) {
				valid();
			}
		});
		passwordField_1.setBounds(476, 294, 140, 31);
		frame.getContentPane().add(passwordField_1);
		
		LABEL3 = new JLabel("please enter phonenumber");
		LABEL3.setVisible(false);
		LABEL3.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 10));
		LABEL3.setForeground(Color.RED);
		LABEL3.setBounds(476, 219, 163, 14);
		frame.getContentPane().add(LABEL3);
		
		LABEL1 = new JLabel("please enter firstname");
		LABEL1.setVisible(false);
		
		LABEL1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 10));
		LABEL1.setForeground(new Color(255, 0, 0));
		LABEL1.setBounds(111, 122, 150, 14);
		frame.getContentPane().add(LABEL1);
		
		LABEL4 = new JLabel("please enter country");
		LABEL4.setVisible(false);
		LABEL4.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 10));
		LABEL4.setForeground(Color.RED);
		LABEL4.setBounds(476, 418, 148, 14);
		frame.getContentPane().add(LABEL4);
		
		LABEL5 = new JLabel("please enter password");
		LABEL5.setVisible(false);
		LABEL5.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 10));
		LABEL5.setForeground(Color.RED);
		LABEL5.setBounds(111, 324, 148, 14);
		frame.getContentPane().add(LABEL5);
		
		LABEL6 = new JLabel("password not matched");
		LABEL6.setVisible(false);
		LABEL6.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 10));
		LABEL6.setForeground(Color.RED);
		LABEL6.setBounds(476, 324, 140, 14);
		frame.getContentPane().add(LABEL6);
		
		LABEL7 = new JLabel("please enter city");
		LABEL7.setVisible(false);
		LABEL7.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 10));
		LABEL7.setForeground(Color.RED);
		LABEL7.setBounds(832, 324, 127, 14);
		frame.getContentPane().add(LABEL7);
		
		passwordField = new JPasswordField();
		passwordField.setToolTipText("pss");
		passwordField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if( (passwordField.getText().length()<8)) {

					 LABEL5.setVisible(true);
					  Border border = BorderFactory.createLineBorder(Color.RED, 1);
					  passwordField.setBorder(border);
					  LABEL5.setForeground(Color.red);
					 
	                }
				 Border border = BorderFactory.createLineBorder(Color.BLACK, 1);
				 passwordField.setBorder(border);
			}
			@Override
			public void focusLost(FocusEvent e) {
				LABEL6.setVisible(false);
				 Border border = BorderFactory.createLineBorder(Color.BLACK, 1);
				 passwordField.setBorder(border);
			}
		});
		passwordField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				boolean status = PassValid.Pass_validation(passwordField.getText());
				if(status) {
//					btnNewButton.setEnabled(true);
					LABEL5.setVisible(false);
					
				}else {
//					btnNewButton.setEnabled(false);
					LABEL5.setVisible(false);
					
				}
				check();
				
				
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				valid();
			}
		});
		passwordField.setBounds(111, 293, 150, 31);
		frame.getContentPane().add(passwordField);
		
		LABEL8 = new JLabel("please enter pincode");
		LABEL8.setVisible(false);
		LABEL8.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 10));
		LABEL8.setForeground(Color.RED);
		LABEL8.setBackground(new Color(240, 240, 240));
		LABEL8.setBounds(832, 418, 109, 14);
		frame.getContentPane().add(LABEL8);
		
		btnNewButton_2 = new JButton("HOME");
		btnNewButton_2.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton_2.setForeground(new Color(0, 0, 0));
		btnNewButton_2.setBackground(UIManager.getColor("Button.background"));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				initializeLand();
				
				
			}
		});
		btnNewButton_2.setBounds(10, 5, 132, 38);
		frame.getContentPane().add(btnNewButton_2);
		
		JLabel lblNewLabel = new JLabel("Registration Form");
		lblNewLabel.setFont(new Font("Tw Cen MT", Font.BOLD, 30));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(152, 5, 793, 38);
		frame.getContentPane().add(lblNewLabel);
		
	}
    @Override
	public void focusGained(FocusEvent e) {
		
		txtFn.setText(txtFn.getText());
		txtMn.setText(txtMn.getText());
		txtLn.setText(txtLn.getText());
		txtEma.setText(txtEma.getText());
		txtPho.setText(txtPho.getText());
		passwordField.setText(passwordField.getText());
		txtCountry.setText(txtCountry.getText());
		txtCity.setText(txtCity.getText());
		txtPincode.setText(txtPincode.getText());
		passwordField_1.setText(passwordField.getText()); 
		
	}

	@Override
	public void focusLost(FocusEvent e) {
		txtFn.setText(txtFn.getText());
		txtMn.setText(txtMn.getText());
		txtLn.setText(txtLn.getText());
		txtEma.setText(txtEma.getText());
		txtPho.setText(txtPho.getText());
		passwordField.setText(passwordField.getText());
		txtCountry.setText(txtCountry.getText());
		txtCity.setText(txtCity.getText());
		txtPincode.setText(txtPincode.getText());
		passwordField_1.setText(passwordField.getText());
	
		
	}
	public void check() {
		if(txtFn.getText().trim().length() > 0 && txtEma.getText().trim().length()>0 && txtPho.getText().trim().length()>0 && txtCountry.getText().trim().length()>0 && passwordField.getText().trim().length()>0 && passwordField_1.getText().trim().length()>0 && txtCity.getText().trim().length()>0 && txtPincode.getText().trim().length()>0 && (!(emailvalidity==0)))

	        btnNewButton.setEnabled(true);
	    else 
	        btnNewButton.setEnabled(false);

		
	}
	public void valid() {
		if((!(name(txtFn.getText().trim())==1))  && (!(mail(txtEma.getText().trim())==1)) && txtEma.getText().trim().length()==0 && txtCountry.getText().trim().length()==0 && passwordField.getText().trim().length()==0 && passwordField_1.getText().trim().length()==0 && txtCity.getText().trim().length()==0 && (!(pincode(txtPincode.getText().trim())==1)) &&  txtEma.getText().trim().length()>50) {
			btnNewButton.setEnabled(false);
		}
		else {
			btnNewButton.setEnabled(true);
		}
	}
	
	public int name(String firstName2) {
        // TODO Auto-generated method stub
                int value=1;
                if(firstName2.toString().length()==0)
                    value=0;
                return value;
                // TODO Auto-generated method stub
               
    }
//	protected int mail(String email) {
//		int value=1;
//		if(email.toString().length()==0)
//            value=0;
//        return value;
//		
//	}
//	protected int phone(String phonenumber) {
//		int value=1;
//		KeyEvent e = null;
//		int c= e.getKeyChar();
//		if(phone(Character.isAlphabetic(c))==0)
//			value=0;
//		return value;
//	}

	public int mail(String email) {
		int value=1;
       String pattern1 = "^[a-zA-Z0-9]{1,20}@[a-zA-Z0-9]{1,20}.[a-zA-Z]{1,3}$";
		
		Pattern pattern = Pattern.compile(pattern1);
		Matcher matcher = pattern.matcher(email);
		if(!(matcher.matches()) || email.toString().length()==0) {
			value=0;
        
		
	}
		return value;
	

	
	
}
	public int pincode(String pin) {
		int value=1;
		if(pin.toString().length()!=6) {
			value=0;
		}
		return value;
	}
	public int phone(String phonenumber) {
		int value=1;
		if(phonenumber.toString().length()!=10) {
            value=0;
		}
        return value;
		
	}



	void initializeLogin() {
		frame = new JFrame();
		frame.setVisible(true);
		frame.getContentPane().setBackground(SystemColor.menu);
		frame.setBounds(100, 100, 579, 389);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Sign In");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tw Cen MT", Font.BOLD, 30));
		lblNewLabel.setBounds(120, 0, 301, 34);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Email");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_1.setBounds(111, 104, 46, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Password");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2.setForeground(new Color(0, 0, 0));
		lblNewLabel_2.setBounds(111, 161, 75, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setBounds(196, 98, 183, 28);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				checked();
			}
			public void keyPressed(KeyEvent e) {
				validate();
			}
			});
		
		passwordFieldLogin = new JPasswordField();
		passwordFieldLogin.setBounds(196, 155, 183, 28);
		frame.getContentPane().add(passwordFieldLogin);
		passwordFieldLogin.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				checked();
			}
			public void keyPressed(KeyEvent e) {
				validate();
			}
			});
		
		
		btnNewButton_0 = new JButton("Submit");
		
		btnNewButton_0.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
       			 try {
       			 if((textField.getText().length()==0)||(passwordFieldLogin.getText().length()==0)) {
       				 JOptionPane.showMessageDialog(button, "Enter Username & Password");
       			 }
       			
       			 valid.setEmailid(textField.getText());
       			 valid.setPassword(passwordFieldLogin.getText());
       			if(registerservice.authenticate(valid)) {
       				System.out.println("Logged in");
       				frame.dispose();
       				initializeSecond();
//       				new Secondpage(valid);
       				
       			}
       			else {
       				  JOptionPane.showMessageDialog(button, "Wrong Email & Password");
       			}
				} 
       			catch (Exception e1) {
					// TODO Auto-generated catch block
					System.out.println("no such value is present in database");
//       			 System.out.println("handled");
				}
			}
		
		});
	
       		 
		
		btnNewButton_0.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnNewButton_0.setBackground(UIManager.getColor("Button.background"));
		btnNewButton_0.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton_0.setBounds(224, 219, 128, 34);
		frame.getContentPane().add(btnNewButton_0);
		
		JLabel lblNewLabel_3 = new JLabel("Click here for Registration-->");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_3.setBounds(80, 291, 183, 14);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("<HTML><U>Click here</U></HTML>");
		lblNewLabel_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
				initialize();
				
			}
		});
		lblNewLabel_4.setForeground(Color.RED);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_4.setBounds(265, 291, 75, 14);
		frame.getContentPane().add(lblNewLabel_4);
		
		btnNewButton_10 = new JButton("HOME");
		btnNewButton_10.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
				initializeLand();
				
			}
		});
		btnNewButton_10.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton_10.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnNewButton_10.setBackground(UIManager.getColor("Button.background"));
		btnNewButton_10.setBounds(431, 12, 122, 34);
		frame.getContentPane().add(btnNewButton_10);
	}
	public void checked() {
	if(textField.getText().trim().length()>0 && passwordFieldLogin.getText().trim().length()>0) {
		btnNewButton_0.setEnabled(true);
    }
    else {
    	btnNewButton_0.setEnabled(false);
    }
	}
	public void validate() {
		if(textField.getText().trim().length()==0 && passwordFieldLogin.getText().trim().length()==0) {
			btnNewButton_0.setEnabled(false);
	    }
	    else {
	    	btnNewButton_0.setEnabled(true);
	    }
		}

	private void initializeLand() {
		frame = new JFrame();
		frame.setVisible(true);
		frame.getContentPane().setBackground(SystemColor.menu);
		frame.setBounds(100, 100, 626, 405);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Registration Form");
		lblNewLabel.setFont(new Font("Tw Cen MT", Font.BOLD, 30));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 0, 610, 53);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Register");
		btnNewButton.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				initialize();
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setBackground(UIManager.getColor("Button.background"));
		btnNewButton.setBounds(217, 189, 164, 36);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Sign In");
		btnNewButton_1.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				initializeLogin();
				
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_1.setBackground(UIManager.getColor("Button.background"));
		btnNewButton_1.setBounds(217, 265, 164, 36);
		frame.getContentPane().add(btnNewButton_1);
	}
	private void initializeSecond() {
		frame = new JFrame();
		frame.setVisible(true);
		frame.getContentPane().setBackground(SystemColor.menu);
		frame.setBounds(100, 100, 1000, 800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("EDIT");
		btnNewButton.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnNewButton.setBackground(UIManager.getColor("Button.background"));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				initializeUpdate();
			}
		});
		btnNewButton.setBounds(150, 163, 134, 34);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("SEARCH");
		btnNewButton_1.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnNewButton_1.setBackground(UIManager.getColor("Button.background"));
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				 System.out.println("Search Pressed");
	                String firstname= "";
	                String lastname = "";
	                String middlename = "";
	                String emailid="";
	                String mobilenumber="";
	                Optional<User> user=registerservice.search(valid.getEmailid());
	                firstname = user.get().getFirstname();
	                System.out.println(firstname);
	                middlename= user.get().getMiddlename();
	                lastname = user.get().getLastname(); 
	                emailid=user.get().getEmailid();
	                mobilenumber = user.get().getMobilenumber(); 
	                model.addRow(new Object[]{firstname, middlename, lastname,emailid,mobilenumber});
				
			}
				catch(Exception e1) {
					System.out.println("cannot select, data no longer not exists");
				}
			}
		});
		
		
		
		btnNewButton_1.setBounds(300, 163, 134, 34);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("DELETE");
		btnNewButton_2.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnNewButton_2.setBackground(UIManager.getColor("Button.background"));
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int res = JOptionPane.showConfirmDialog( btnNewButton_1 ,"Sure? You want to Delete?", "Delete Confirmation",
	                        JOptionPane.YES_NO_OPTION,
	                        JOptionPane.QUESTION_MESSAGE);
	                     if(res == JOptionPane.YES_OPTION){
	                         registerservice.deleteData(valid);
	                         frame.dispose();
	                         initializeLand();
	                     }else
	                     {
	                          JOptionPane.showMessageDialog( btnNewButton_1 , "You have selected NO");
	                     }
				
			}
				catch(Exception e2) {
				System.out.println("no data to delete");	
				}
				}
		});
		btnNewButton_2.setBounds(450, 163, 134, 34);
		frame.getContentPane().add(btnNewButton_2);
		
		JLabel lblNewLabel = new JLabel("Modify Form");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tw Cen MT", Font.BOLD, 30));
		lblNewLabel.setBounds(250, 0, 395, 34);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton_3 = new JButton("Log Out");
		btnNewButton_3.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnNewButton_3.setBackground(UIManager.getColor("Button.background"));
		btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				initializeLogin();
				
			}
		});
		btnNewButton_3.setBounds(600, 163, 134, 34);
		frame.getContentPane().add(btnNewButton_3);
		
		scrollPane = new JScrollPane();
        scrollPane.setBounds(65, 221, 836, 362);
        frame.getContentPane().add(scrollPane);
		
		model = new DefaultTableModel();
        table = new JTable();
        table.setBackground(new Color(176, 224, 230));
        scrollPane.setViewportView(table);
        model=new DefaultTableModel();
        Object[] columnNames = {"firstname", "lastname", "middlename","emailid","mobilenumber"};
        Object[] row=new Object[0];
        model.setColumnIdentifiers(columnNames);
        table.setModel(model);
		
		}
	public void initializeUpdate() {
		frame = new JFrame();
		frame.setVisible(true);
		frame.setBounds(100, 100, 468, 452);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel_10 = new JLabel("Edit Form");
		lblNewLabel_10.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_10.setFont(new Font("Tw Cen MT", Font.BOLD, 30));
		lblNewLabel_10.setBounds(60, 0, 395, 34);
		frame.getContentPane().add(lblNewLabel_10);
		
		JLabel lblNewLabel = new JLabel("First Name");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(37, 40, 83, 14);
		frame.getContentPane().add(lblNewLabel);
		
		textField_10 = new JTextField();
		textField_10.setBounds(138, 38, 188, 20);
		frame.getContentPane().add(textField_10);
		textField_10.setColumns(10);
		
		textField_11 = new JTextField();
		textField_11.setBounds(138, 93, 188, 20);
		frame.getContentPane().add(textField_11);
		textField_11.setColumns(10);
		
		textField_12 = new JTextField();
		textField_12.setBounds(138, 151, 188, 20);
		frame.getContentPane().add(textField_12);
		textField_12.setColumns(10);
		
		textField_13 = new JTextField();
		textField_13.setBounds(138, 212, 188, 20);
		frame.getContentPane().add(textField_13);
		textField_13.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Middle Name");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setBounds(37, 95, 83, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Last Name");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2.setBounds(37, 153, 83, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Mobile Number");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_3.setBounds(37, 214, 91, 14);
		frame.getContentPane().add(lblNewLabel_3);
		
		JButton btnNewButton = new JButton("Update");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				user.setEmailid(textField.getText());
                user.setFirstname(textField_10.getText());
                user.setMiddlename(textField_11 .getText());
                user.setLastname(textField_12.getText());
                user.setMobilenumber(textField_13.getText());
                registerservice.saveUpdate(user);
                frame.dispose();
                initializeSecond();
				
			}catch(Exception e3) {
				System.out.println("No data to update");
			}
				}
		});
		btnNewButton.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnNewButton.setBackground(UIManager.getColor("Button.background"));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton.setBounds(165, 312, 124, 33);
		frame.getContentPane().add(btnNewButton);
	}
	}
