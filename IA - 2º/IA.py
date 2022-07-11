import pandas as pd
import numpy as np
import matplotlib.pyplot as plt
from matplotlib.colors import ListedColormap
import matplotlib.patches as mpatches
from sklearn.preprocessing import MinMaxScaler
from sklearn.neighbors import KNeighborsClassifier
from sklearn.model_selection import train_test_split
from sklearn.metrics import classification_report
from sklearn.metrics import confusion_matrix

#Ler base
df = pd.read_csv("Pasta1.csv")
X = df[['Massa', 'Largura', 'Altura', 'Cor']]
Y = df["ID"]

#Treinamento
TrainX, TestX, TrainY, TestY = train_test_split(X, Y, random_state = 0)
escalar = MinMaxScaler()
TrainX = escalar.fit_transform(TrainX)
TestX = escalar.transform(TestX)

#KNN
KNN = KNeighborsClassifier() 
KNN.fit(TrainX, TrainY) 
p = KNN.predict(TestX)
matriz = confusion_matrix(TestY, p)
classi = classification_report(TestY, p)
print("Matriz de confusão:\n", matriz)

#Grafico
k = 1
x = X[['Altura', 'Largura']].to_numpy()
y = Y.to_numpy()
clf = KNeighborsClassifier(k, weights='uniform')
clf.fit(x, y)
minX = x[:, 0].min() - 1
maxX = x[:, 0].max() + 1
minY = x[:, 1].min() - 1
maxY = x[:, 1].max() + 1
xx, yy = np.meshgrid(np.arange(minX, maxX, 0.01), np.arange(minY, maxY, 0.01))
z = clf.predict(np.c_[xx.ravel(), yy.ravel()]).reshape(xx.shape)
plt.figure()
cor1, cor2, cor3, cor4 = 'red', 'yellow', 'orange', 'green'
plt.pcolormesh(xx, yy, z, cmap = ListedColormap(['lightsalmon', 'lightyellow', 'wheat', 'lightgreen']))
plt.scatter(x[:, 0], x[:, 1], s = 50, c = y, cmap = ListedColormap([cor1, cor2, cor3, cor4]), edgecolor = 'black')
plt.xlim(xx.min(), xx.max())
plt.ylim(yy.min(), yy.max())
a = mpatches.Patch(color = cor1, label='Maçã')
b = mpatches.Patch(color = cor2, label='Tangerina')
c = mpatches.Patch(color = cor3, label='Laranja')
d = mpatches.Patch(color = cor4, label='Limão')
plt.legend(handles = [a, b, c, d])
plt.xlabel('Altura (cm)')
plt.ylabel('Largura (cm)')
plt.title("Classificação (k = %i)" % (k))    
plt.show()
