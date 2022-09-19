from random import shuffle
from random import randrange
import copy

rota = [i for i in range(0, 10)]
troca = copy.copy(rota)
partida = -1

def partida():
	print("Digite um número de 1 a 10 correspondente a cidade:")
	partida = int(input())
	return partida - 1

distancias = [ ( 0, 30,  84,  56,  -1,  -1,  -1,  75,  -1, 80), 
	           (30,  0,  65,  -1,  -1,  -1,  70,  -1,  -1, 40), 
	           (84, 65,   0,  74,  52,  55,  -1,  60, 143, 48), 
	           (56, -1,  74,   0, 135,  -1,  -1,  20,  -1, -1),
	           (-1, -1,  52, 135,   0,  70,  -1, 122,  98, 80), 
	           (70, -1,  55,  -1,   70,  0,  63,  -1,  82, 35),
	           (-1, 70,  -1,  -1,   -1, 63,   0,  -1, 120, 57),	
	           (75, -1, 135,  20,  122, -1,  -1,   0,  -1, -1), 
	           (-1, -1, 143,  -1,   98, 82, 120,  -1,   0, -1),
	           (80, 40,  48,  -1,   80, 35,  57,  -1,  -1,  0) 
         ]

hamiltoniano = [ (0,  1,  1,  1,  0,  0,  0,  1,  0,  1),
	             (1,  0,  1,  0,  0,  0,  1,  0,  0,  1), 
	             (1,  1,  0,  1,  1,  1,  0,  1,  1,  1), 
	             (1,  0,  1,  0,  1,  0,  0,  1,  0,  0),
	             (0,  0,  1,  1,  0,  1,  0,  1,  1,  1), 
	             (1,  0,  1,  0,  1,  0,  1,  0,  1,  1), 
	             (0,  1,  0,  0,  0,  1,  0,  0,  1,  1), 
	             (1,  0,  1,  1,  1,  0,  0,  0,  0,  0), 
                 (0,  0,  1,  0,  1,  1,  1,  0,  0,  0), 
	             (1,  1,  1,  0,  1,  1,  1,  0,  0,  0) 
           ]

def Checa(aux, x, troca):
	if(aux != -1 and aux < x):
		rota = troca
		return aux
	else:
		return x

def Troca(a, x, y):
	troca = copy.copy(a)
	temp = troca[x]
	troca[x] = troca[y]
	troca[y] = temp
	return troca

def percurso(rota):
	if len(rota) == 11:
		del rota[10]
	shuffle(rota)
	rota.append(partida)
	for j in range(0, 10):
		if rota[j] == rota[10]:
			temp = rota[0]
			rota[0] = rota[j]
			rota[j] = temp
			break

def CicloHamiltoniano(a):
	km = 0
	for i in range (0, len(a)-1):
		if hamiltoniano[a[i]][a[i+1]] == 0:
			return -1
		km += distancias[a[i]][a[i+1]]
	return km

partida = partida()
percurso(rota)

x = CicloHamiltoniano(rota)
k = 0
while x == -1 and k < 10000:
	percurso(rota)
	x = CicloHamiltoniano(rota)
	k += 1

for i in range(1, 300000):
	troca = Troca(troca, randrange(1, 10), randrange(1, 10))
	custo_filho1 = CicloHamiltoniano(troca)
	x = Checa(custo_filho1, x, troca)

print("Rota:", end = "")
for i in range(len(rota)):
    print("C{} ".format(rota[i]+1), end = "")

print("\nDistancia: {} km".format(x))