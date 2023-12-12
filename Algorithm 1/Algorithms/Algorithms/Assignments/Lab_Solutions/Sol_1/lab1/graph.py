import numpy as np
import matplotlib.pyplot as plt

lines = np.loadtxt('times.txt')
x = lines[:,0]
ys = lines[:,1:]
ys = np.transpose(ys)
for y in ys:
	plt.plot(x, y)

plt.xlabel('Array Length')
plt.ylabel('Milliseconds')
plt.legend(['Alg 1', 'Alg 2', 'Alg 3', 'Alg 4'], loc=2)
plt.show()