package Novo;

public class IA {
	
	Preencher p = new Preencher();
	
	public IA() {
		int[] a = melhorJogada();
		if(!p.cheio(Preencher.comando)) p.jogar(a[0], a[1], true, null);
	}
	
	private int[] melhorJogada() {
		int minimax, melhorValor = -10;
		int[] melhorMovimento = new int[2];
		for(int x = 0; x < 3; x++) {
			for(int y = 0; y < 3; y++) {
				if(Preencher.comando[x][y] == 0) {
					Preencher.comando[x][y] = -1;
					minimax = minimax(Preencher.comando, false);
					Preencher.comando[x][y] = 0;
					if(minimax > melhorValor) {
						melhorValor = minimax;
						melhorMovimento[0] = x;
						melhorMovimento[1] = y;
					}
				}
			}
		}
		return melhorMovimento;
	}
	
	private int minimax(int[][] copia, boolean maquina) {	//0 = maquina, 1 = jogador
		int pp = p.Checa(false, copia);
		if(pp == 1 && maquina) return -1;
		else if(pp == -1 && !maquina) return 1;
		else if(p.cheio(copia)) return 0;
		int minimax, melhorValor = 100, valor = 1;
		if(maquina) {
			melhorValor = -100;
			valor = -1;
		}
		for(int x = 0; x < 3; x++) {
			for(int y = 0; y < 3; y++) {
				if(copia[x][y] == 0) {
					copia[x][y] = valor;
					minimax = minimax(copia, !maquina);
					copia[x][y] = 0;
					if(minimax > melhorValor && maquina) 		//max maquina
						melhorValor = minimax;
					else if(minimax < melhorValor && !maquina) 	//min jogador
						melhorValor = minimax;
				}
			}
		}
		return melhorValor;
	}
}
