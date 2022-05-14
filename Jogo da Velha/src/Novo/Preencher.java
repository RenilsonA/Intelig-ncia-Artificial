package Novo;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Preencher {
	public static int[][] comando = new int[][]{{0, 0, 0}, {0, 0, 0}, {0, 0, 0}};

	public Preencher() {
		
	}
	
	public void jogar(int linha, int coluna, boolean jogador, JTextField texto) {
		if(!jogador) {
			texto.removeAll();
			comando[linha][coluna] = 1;
			texto.setText("X");
			texto.setEnabled(false);
			texto.setEditable(false);
			if(Checa(false, comando) == 0) {
				new IA();
				Checa(true, comando);
			}
		}
		else {
			comando[linha][coluna] = -1;
			int x = linha*3 + coluna;
			JTextField texto2 = Inicio.mapa.get(x);
			texto2.setText("O");
			texto2.setEnabled(false);
			texto2.setEditable(false);
		}
	}
	
	public int Checa(boolean x, int[][] tabuleiro) {
		int ganhador = 0;	//1 = player, -1 = maquina
		for(int i = 0; i < 3; i++) {
			if(tabuleiro[0][i] == tabuleiro[1][i] && tabuleiro[1][i] == tabuleiro[2][i] && tabuleiro[1][i] != 0) {
				ganhador = tabuleiro[1][i];
				i = 3;
			} else if(tabuleiro[i][0] == tabuleiro[i][1] && tabuleiro[i][1] == tabuleiro[i][2] && tabuleiro[i][2] != 0) {
				ganhador = tabuleiro[i][0];
				i = 3;
			}
		}
		if((tabuleiro[0][0] == tabuleiro[1][1] && tabuleiro[1][1] == tabuleiro[2][2] && tabuleiro[2][2] != 0) ||
		   (tabuleiro[0][2] == tabuleiro[1][1] && tabuleiro[1][1] == tabuleiro[2][0] && tabuleiro[2][0] != 0)) {
			ganhador = tabuleiro[1][1];
		}
		if(!x) return ganhador;
		if(cheio(tabuleiro)) ganhador(3);
		if(ganhador != 0)
			ganhador(ganhador);
		return ganhador;
	}
	
	public void ganhador(int ganhador) {
		if(ganhador == 1) 
			JOptionPane.showMessageDialog(null, "Parabéns, você ganhou", "Vitória", 2, null);
		 else if(ganhador == -1)
			 JOptionPane.showMessageDialog(null, "Infelizmente, você perdeu", "Derrota", 0, null);
		 else
			 JOptionPane.showMessageDialog(null, "Empate", "Empate", 0, null);
	}
	
	public boolean cheio(int[][] tabuleiro) {
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				if(tabuleiro[i][j] == 0)
					return false;
			}
		}
		return true;
	}
}
