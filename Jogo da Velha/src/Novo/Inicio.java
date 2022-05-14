package Novo;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class Inicio {
	public JFrame inicio;
	private static JTextField textField;
	private static JTextField textField_3;
	private static JTextField textField_6;
	private static JTextField textField_1;
	private static JTextField textField_4;
	private static JTextField textField_7;
	private static JTextField textField_8;
	private static JTextField textField_5;
	private static JTextField textField_2;
	static Map<Integer, JTextField> mapa = new HashMap<Integer, JTextField>();
	static Preencher p = new Preencher();
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Inicio window = new Inicio();
					window.inicio.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public Inicio() {
		initialize();
	}
	
	public void initialize(){
		inicio = new JFrame();
		inicio.setBounds(0, 0, 420, 390);
		inicio.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		inicio.getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setFont(new Font("Arial", Font.PLAIN, 30));
		textField.setBounds(90, 100, 67, 47);
		inicio.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setHorizontalAlignment(SwingConstants.CENTER);
		textField_3.setFont(new Font("Arial", Font.PLAIN, 30));
		textField_3.setColumns(10);
		textField_3.setBounds(90, 158, 67, 47);
		inicio.getContentPane().add(textField_3);
		
		textField_6 = new JTextField();
		textField_6.setHorizontalAlignment(SwingConstants.CENTER);
		textField_6.setFont(new Font("Arial", Font.PLAIN, 30));
		textField_6.setColumns(10);
		textField_6.setBounds(90, 216, 67, 47);
		inicio.getContentPane().add(textField_6);
		
		textField_1 = new JTextField();
		textField_1.setHorizontalAlignment(SwingConstants.CENTER);
		textField_1.setFont(new Font("Arial", Font.PLAIN, 30));
		textField_1.setColumns(10);
		textField_1.setBounds(167, 100, 67, 47);
		inicio.getContentPane().add(textField_1);
		
		textField_4 = new JTextField();
		textField_4.setHorizontalAlignment(SwingConstants.CENTER);
		textField_4.setFont(new Font("Arial", Font.PLAIN, 30));
		textField_4.setColumns(10);
		textField_4.setBounds(167, 158, 67, 47);
		inicio.getContentPane().add(textField_4);
		
		textField_7 = new JTextField();
		textField_7.setHorizontalAlignment(SwingConstants.CENTER);
		textField_7.setFont(new Font("Arial", Font.PLAIN, 30));
		textField_7.setColumns(10);
		textField_7.setBounds(167, 216, 67, 47);
		inicio.getContentPane().add(textField_7);
		
		textField_8 = new JTextField();
		textField_8.setHorizontalAlignment(SwingConstants.CENTER);
		textField_8.setFont(new Font("Arial", Font.PLAIN, 30));
		textField_8.setColumns(10);
		textField_8.setBounds(244, 216, 67, 47);
		inicio.getContentPane().add(textField_8);
		
		textField_5 = new JTextField();
		textField_5.setHorizontalAlignment(SwingConstants.CENTER);
		textField_5.setFont(new Font("Arial", Font.PLAIN, 30));
		textField_5.setColumns(10);
		textField_5.setBounds(244, 158, 67, 47);
		inicio.getContentPane().add(textField_5);
		
		textField_2 = new JTextField();
		textField_2.setHorizontalAlignment(SwingConstants.CENTER);
		textField_2.setFont(new Font("Arial", Font.PLAIN, 30));
		textField_2.setColumns(10);
		textField_2.setBounds(244, 100, 67, 47);
		inicio.getContentPane().add(textField_2);
		
		JButton btnConfirmar = new JButton("Recomeçar");
		btnConfirmar.setFont(new Font("Arial", Font.PLAIN, 16));
		btnConfirmar.setBounds(129, 274, 143, 47);
		inicio.getContentPane().add(btnConfirmar);
		
		textField.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char Numero = e.getKeyChar();
				if (!(Numero == 'X' || Numero == 'x')) {
					e.consume();
				} else 
					p.jogar(0, 0, false, textField);
			}
		});
		
		textField_1.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char Numero = e.getKeyChar();
				if (!(Numero == 'X' || Numero == 'x')) {
					e.consume();
				} else 
					p.jogar(0, 1, false, textField_1);
			}
		});
		
		textField_2.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char Numero = e.getKeyChar();
				if (!(Numero == 'X' || Numero == 'x')) {
					e.consume();
				} else 
					p.jogar(0, 2, false, textField_2);
			}
		});
		
		textField_3.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char Numero = e.getKeyChar();
				if (!(Numero == 'X' || Numero == 'x')) {
					e.consume();
				} else 
					p.jogar(1, 0, false, textField_3);
			}
		});
		
		textField_4.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char Numero = e.getKeyChar();
				if (!(Numero == 'X' || Numero == 'x')) {
					e.consume();
				} else 
					p.jogar(1, 1, false, textField_4);
			}
		});
		
		textField_5.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char Numero = e.getKeyChar();
				if (!(Numero == 'X' || Numero == 'x')) {
					e.consume();
				} else 
					p.jogar(1, 2, false, textField_5);
			}
		});
		
		textField_6.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char Numero = e.getKeyChar();
				if (!(Numero == 'X' || Numero == 'x')) {
					e.consume();
				} else 
					p.jogar(2, 0, false, textField_6);
			}
		});
		
		textField_7.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char Numero = e.getKeyChar();
				if (!(Numero == 'X' || Numero == 'x')) {
					e.consume();
				} else 
					p.jogar(2, 1, false, textField_7);
			}
		});
		textField_8.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char Numero = e.getKeyChar();
				if (!(Numero == 'X' || Numero == 'x')) {
					e.consume();
				} else 
					p.jogar(2, 2, false, textField_8);
			}
		});
		
		mapa.put(0, textField);
		mapa.put(1, textField_1);
		mapa.put(2, textField_2);
		mapa.put(3, textField_3);
		mapa.put(4, textField_4);
		mapa.put(5, textField_5);
		mapa.put(6, textField_6);
		mapa.put(7, textField_7);
		mapa.put(8, textField_8);
		
		JLabel lblNewLabel = new JLabel("Jogue com \"X\" ou \"x\"");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 24));
		lblNewLabel.setBounds(10, 19, 384, 47);
		inicio.getContentPane().add(lblNewLabel);
		
		Primeiro();
		
		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for(int i = 0; i < 3; i++) 
					for(int j = 0; j < 3; j++)
						Preencher.comando[i][j] = 0;
				for(int i = 0; i < 9; i++) {
					JTextField x = mapa.get(i);
					x.removeAll();
					x.setText("");
					x.setEnabled(true);
					x.setEditable(true);
				}
				Primeiro();
			}
		});
	}
	
	private void Primeiro() {
		Random random = new Random();
		int x = random.nextInt(10);
		if(x <= 5)
			return;
		else {
			JOptionPane.showMessageDialog(null, "Máquina joga primerio", "Inicio", 0, null);
			p.jogar(1, 1, true, null);
		}
	}
}