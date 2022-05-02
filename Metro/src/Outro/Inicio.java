package Outro;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;

public class Inicio {
	public JFrame inicio;
	private JTextField textInicial;
	private JTextField textFinal;
	static Map<Integer, Node> mapa = new HashMap<Integer, Node>();
	
	public static void main(String[] args) {
		Node E1 = new Node(1);
	    Node E2 = new Node(5);
	    Node E3 = new Node(5);
	    Node E4 = new Node(5);
	    Node E5 = new Node(5);
	    Node E6 = new Node(1);
	    Node E7 = new Node(2);
	    Node E8 = new Node(5);
	    Node E9 = new Node(5);
	    Node E10 = new Node(2);
	    Node E11 = new Node(3);
	    Node E12 = new Node(4);
	    Node E13 = new Node(5);
	    Node E14 = new Node(4);
	    
	    E1.addBranch(11 , E2 );
	    E2.addBranch(11 , E1 );
	    E2.addBranch(11 , E9 );
	    E9.addBranch(11 , E2 );
	    E2.addBranch(4  , E10);
	    E10.addBranch(4 , E2 );
	    E2.addBranch(9  , E3 );
	    E3.addBranch(9  , E2 );
	    E9.addBranch(12 , E11);
	    E11.addBranch(12, E9 );
	    E3.addBranch(7  , E4 );
	    E4.addBranch(7  , E3 );
	    E3.addBranch(10 , E9 );
	    E9.addBranch(10 , E3 );
	    E3.addBranch(13 , E13);
	    E13.addBranch(13, E3 );
	    E4.addBranch(11 , E13);
	    E13.addBranch(11, E4 );
	    E4.addBranch(13 , E8 );
	    E8.addBranch(13 , E4 );
	    E4.addBranch(13 , E5 );
	    E5.addBranch(13 , E4 );
	    E5.addBranch(3  , E6 );
	    E6.addBranch(3  , E5 );
	    E5.addBranch(2  , E7 );
	    E7.addBranch(2  , E5 );
	    E5.addBranch(21 , E8 );
	    E8.addBranch(21 , E5 );
	    E8.addBranch(7  , E12);
	    E12.addBranch(7 , E8 );
	    E8.addBranch(9  , E9 );
	    E9.addBranch(9  , E8 );
	    E13.addBranch(5 , E14);
	    E14.addBranch(5 , E13);

	    mapa.put(1, E1);
	    mapa.put(2, E2);
	    mapa.put(3, E3);
	    mapa.put(4, E4);
	    mapa.put(5, E5);
	    mapa.put(6, E6);
	    mapa.put(7, E7);
	    mapa.put(8, E8);
	    mapa.put(9, E9);
	    mapa.put(10, E10);
	    mapa.put(11, E11);
	    mapa.put(12, E12);
	    mapa.put(13, E13);
	    mapa.put(14, E14);
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
		inicio.setBounds(0, 0, 420, 290);
		inicio.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		inicio.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(0, 11, 838, 47);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 40));
		inicio.getContentPane().add(lblNewLabel);
		
		JButton btnFechar = new JButton("Fechar");
		btnFechar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (JOptionPane.showConfirmDialog(inicio, "Você realmente quer sair?",
						"Sistema de Gerenciamento dos Funcionários", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION) {
					inicio.dispose();
				}
			}
		});
		btnFechar.setFont(new Font("Arial", Font.PLAIN, 16));
		btnFechar.setBounds(209, 198, 111, 47);
		inicio.getContentPane().add(btnFechar);
		
		JButton btnCalcular = new JButton("Calcular");
		btnCalcular.setFont(new Font("Arial", Font.PLAIN, 16));
		btnCalcular.setBounds(68, 198, 131, 47);
		inicio.getContentPane().add(btnCalcular);
		
		JLabel lblNewLabel_1 = new JLabel("Esta\u00E7\u00E3o Inicial");
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(78, 90, 101, 32);
		inicio.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Esta\u00E7\u00E3o Final");
		lblNewLabel_1_1.setFont(new Font("Arial", Font.PLAIN, 16));
		lblNewLabel_1_1.setBounds(78, 133, 101, 32);
		inicio.getContentPane().add(lblNewLabel_1_1);
		
		textInicial = new JTextField();
		textInicial.setBounds(189, 90, 131, 28);
		inicio.getContentPane().add(textInicial);
		textInicial.setColumns(10);
		
		textFinal = new JTextField();
		textFinal.setColumns(10);
		textFinal.setBounds(189, 129, 131, 28);
		inicio.getContentPane().add(textFinal);
		
		textFinal.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char Numero = e.getKeyChar();
				if (!(Character.isDigit(Numero) || Numero == KeyEvent.VK_BACK_SPACE || Numero == KeyEvent.VK_DELETE || Numero == '.')) {
					e.consume();
				}
			}
		});
		
		textInicial.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char Numero = e.getKeyChar();
				if (!(Character.isDigit(Numero) || Numero == KeyEvent.VK_BACK_SPACE || Numero == KeyEvent.VK_DELETE || Numero == '.')) {
					e.consume();
				}
			}
		});
		
		btnCalcular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int inic = 0;
				int fin = 0;
				if(!textInicial.getText().isEmpty()) inic = Integer.parseInt(textInicial.getText());
				if(!textFinal.getText().isEmpty()) fin = Integer.parseInt(textFinal.getText());
				if(inic > 0 && inic < 15 && fin > 0 && fin < 15 && inic != fin) {
				    int aux = 0;
				    if(inic > fin) {
				    	aux = inic;
				    	inic = fin;
				    	fin = aux;
				    }
				    mapa.get(fin).g = 0;
				    Node res = Node.aStar(mapa.get(fin), mapa.get(inic));
				    List<Integer> Caminho = Node.printPath(res);
				    if(aux == 0) Collections.reverse(Caminho);
				    JOptionPane.showMessageDialog(btnCalcular, "Pegue as estações " + Caminho, "Melhor caminho", 3, null);
				    inicio.dispose();
				} else {
					JOptionPane.showMessageDialog(btnCalcular, "Digite uma estação de 1 a 14 e a estação incial deve ser diferente da final", "Erro", 2, null);
				}
			}
		});
	}
}
