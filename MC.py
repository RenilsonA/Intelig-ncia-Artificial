from operator import truediv
from pickle import NONE

estadoInicial = [3, 3, 0, 0, 0]
possiveisCanoas = [(1, 0), (1, 1), (2, 0), (0, 2)]
ultimosElementos = []
visitados = []

def Canoa(NM, NC, estadoAtual):
    if(NM + NC > 2):
        return
    if(estadoAtual[-1] == 0):
        mo = 0
        co = 1
        md = 2
        cd = 3
    else:
        mo = 2
        co = 3
        md = 0
        cd = 1
    if(estadoAtual[mo] == 0 and estadoAtual[co] == 0):
        return
    estadoAtual[-1] = 1 - estadoAtual[-1]
    for i in range(min(estadoAtual[mo], NM)):
        estadoAtual[mo] -= 1
        estadoAtual[md] += 1
    for i in range(min(estadoAtual[co], NC)):
        estadoAtual[co] -= 1
        estadoAtual[cd] += 1
    return estadoAtual

def estados(estado):
    sucessores = []
    for (i,j) in possiveisCanoas:
        s = Canoa(i, j, estado[:])
        if((s == NONE) or (s in visitados) or (s[0] < s[1] and s[0] > 0) or (s[2] < s[3] and s[2] > 0)):
            continue
        sucessores.append(s)
    return sucessores

def obtemAdNV(elemento):
    aux = estados(elemento)
    if(len(aux) > 0):
        return aux[0]
    return -1

def teste(estado):
    if(estado[2] >= 3 and estado[3] >= 3):
        return True
    return False

def DFS(estado):
    ultimosElementos.append(estado)
    while (len(ultimosElementos) != 0):
        elemento = ultimosElementos[len(ultimosElementos) - 1]
        if(teste(elemento)):
            break
        retorno = obtemAdNV(elemento)
        if(retorno == -1):
            ultimosElementos.pop()
        else:
            visitados.append(retorno)
            ultimosElementos.append(retorno)
    return ultimosElementos

solucao = DFS(estadoInicial)
for i in range(len(solucao)):
    print("{}\n".format(solucao[i][0:4]), end = "")