# Soluciones a los problemas propuestos del tema 2 (diseño de algoritmos)

Las soluciones a los ejercicios del 2.1 al 2.10 están en forma de código, cada una en el paquete correspondiente.

Las soluciones a los ejercicios del 3.1 al 3.10 aparecen a continuación.

## 3.1. Variable contador
Tenemos dos bucles `for` anidados. El externo va de $0$ a $N$, y el interno de $0$ a $i$.

* **Valor final en función de N:**
    El bucle interno se ejecuta 0 veces cuando $i=0$, 1 vez cuando $i=1$, 2 veces cuando $i=2$, y así sucesivamente hasta $N-1$.
    Se trata de la suma de los primeros enteros: $0 + 1 + 2 + ... + (N-1)$.
    La fórmula matemática es la suma aritmética:
    $$\frac{(N-1)N}{2}$$
    O simplificado: $\frac{N^2 - N}{2}$.

* **Complejidad computacional:**
    Al dominar el término cuadrático $N^2$ en la fórmula anterior, la complejidad es **$O(N^2)$** (Cuadrática).

## 3.2. Método misterioso

* **Estado del array tras $i=2$:**
    Array inicial: `{5, 2, 4, 6, 1, 3}`.
    * Iteración $i=1$ (Clave = 2): Se compara con 5, se desplaza el 5. Se inserta el 2. Array: `{2, 5, 4, 6, 1, 3}`.
    * Iteración $i=2$ (Clave = 4): Se compara con 5, se desplaza el 5. Se compara con 2, es mayor, se detiene. Se inserta el 4.
    * **Resultado:** `{2, 4, 5, 6, 1, 3}`[cite: 164].

* **Algoritmo:**
    [cite_start]Implementa **Insertion Sort** (Ordenación por inserción)[cite: 165].

* **Complejidad:**
    * **Peor caso ($O(N^2)$):** El array está ordenado al revés. El `while` interior se ejecuta completamente en cada paso.
    * **Mejor caso ($O(N)$):** El array ya está ordenado. [cite_start]La condición `datos[j] > clave` falla en la primera comprobación siempre, ejecutando el bucle interior 0 veces (tiempo constante por iteración externa)[cite: 166].

---

### 3.3. Bucles anidados (I)
[cite_start]**Código analizado:** Similar al 3.1, bucles dependientes `j < i` [cite: 168-176].

* **Valor final si $n=5$:**
    [cite_start]Suma: $0 (i=0) + 1 (i=1) + 2 (i=2) + 3 (i=3) + 4 (i=4) = 10$[cite: 177].

* **Ejecuciones en función de n:**
    Es la suma aritmética de $0$ a $n-1$:
    $$\sum_{i=0}^{n-1} i = \frac{n(n-1)}{2}$$

* **Complejidad:**
    Desarrollando la fórmula ($\frac{1}{2}n^2 - \frac{1}{2}n$), el término dominante es el cuadrado.
    [cite_start]Complejidad: **$O(n^2)$**[cite: 179].

---

### 3.4. Búsqueda binaria modificada
[cite_start]**Código analizado:** Búsqueda binaria recursiva [cite: 184-191].

* **Secuencia de valores de `medio`:**
    Array: `{2, 5, 8, 12, 16, 23, 38, 56, 72, 91}` (Índices 0-9). Buscando $x=23$.
    1.  `inicio=0`, `fin=9` $\rightarrow$ `medio` = 4 (Valor 16). $16 < 23$, buscar en derecha.
    2.  `inicio=5`, `fin=9` $\rightarrow$ `medio` = 7 (Valor 56). $56 > 23$, buscar en izquierda.
    3.  `inicio=5`, `fin=6` $\rightarrow$ `medio` = 5 (Valor 23). ¡Encontrado!
    [cite_start]**Secuencia:** 4, 7, 5[cite: 192].

* **Si no está ordenado:**
    El algoritmo **falla**. La búsqueda binaria asume que si $X$ es mayor que el medio, *debe* estar a la derecha. [cite_start]Sin orden, esta premisa es falsa y no encontrará el elemento correctamente[cite: 196].

* **Complejidad:**
    **$O(\log n)$**. [cite_start]En cada llamada recursiva, el espacio de búsqueda (`fin - inicio`) se divide por 2. El número de pasos es logarítmico respecto al tamaño del array[cite: 197].

---

### 3.5. Bucles anidados (II)
[cite_start]**Código analizado:** Bucle externo lineal, bucle interno multiplica el índice (`j *= 2`) [cite: 200-206].

* **Ejecuciones si $n=10$:**
    * Bucle externo: 10 iteraciones.
    * Bucle interno ($j$ toma valores 1, 2, 4, 8): 4 iteraciones por cada vuelta externa.
    * [cite_start]Total aproximado: $10 \times 4 = 40$ veces[cite: 207].

* **Relación matemática:**
    [cite_start]El número de pasos del bucle interno es igual a $\log_2 n$, ya que $j$ crece exponencialmente ($2^k$) hasta llegar a $n$[cite: 208].

* **Complejidad:**
    El externo es $N$ y el interno es $\log N$. Al estar anidados se multiplican.
    [cite_start]Complejidad: **$O(n \log n)$**[cite: 209].

---

### 3.6. Bubble sort optimizado
[cite_start]**Código analizado:** Algoritmo de la burbuja con bandera `intercambiado` [cite: 212-229].

* **Comparaciones con array ordenado:**
    Entrada: `{1, 2, 3, 4, 5}`.
    El bucle `i=0` recorre todo el array una vez. Hace 4 comparaciones (`j` de 0 a 3). Como nunca entra en el `if` (nunca intercambia), la variable `intercambiado` sigue `false` y hace `break`.
    [cite_start]**Respuesta:** 4 comparaciones (o $n-1$)[cite: 230].

* **Variable `intercambiado`:**
    Sirve para detectar si el array ya está ordenado. [cite_start]Si se completa una pasada entera sin hacer ningún cambio, significa que no se necesita seguir ordenando y termina el algoritmo prematuramente para ahorrar tiempo[cite: 231].

* **Complejidad:**
    * **Mejor caso ($O(n)$):** Array ya ordenado (gracias a la bandera, solo hace una pasada).
    * **Peor caso ($O(n^2)$):** Array ordenado inversamente. Debe realizar todas las pasadas y comparaciones posibles.
    [cite_start]Son diferentes porque la optimización permite saltarse el trabajo restante si detecta orden[cite: 232].

---

### 3.7. Complejidad de un árbol N-ario
[cite_start]**Problema:** Recorrer un árbol completo para contar nodos[cite: 234].

* **Análisis:**
    Para contar todos los nodos, el algoritmo debe visitar **cada nodo exactamente una vez**.
* **Complejidad:**
    **$O(N)$**, donde N es el número total de nodos en el árbol. El trabajo es lineal respecto al tamaño de la estructura.

---

### 3.8. Método misterioso (II)
[cite_start]**Código analizado:** Función recursiva en árbol binario que retorna `1 + Math.max(izq, der)` [cite: 240-247].

* **Qué calcula:**
    Calcula la **altura** (o profundidad máxima) del árbol.
    Toma la altura del subárbol más profundo (izquierdo o derecho) y le suma 1 (el nivel del nodo actual). [cite_start]Si el nodo es nulo, retorna 0 (altura base)[cite: 239].

---

### 3.9. Árbol binario degenerado
[cite_start]**Problema:** Árbol donde cada nodo tiene un solo hijo (parecido a una lista enlazada)[cite: 249].

* **Complejidad de búsqueda (Peor caso):**
    En un árbol degenerado, no se puede descartar la mitad de los nodos en cada paso (el árbol no está balanceado). Hay que recorrer los nodos uno a uno.
    [cite_start]Complejidad: **$O(N)$** (Lineal)[cite: 250].

* **Mejor caso:**
    El elemento buscado es la raíz del árbol.
    [cite_start]Complejidad: **$O(1)$**[cite: 251].

---

### 3.10. Complejidad de método recursivo
[cite_start]**Código analizado:** `metodoRaro` que se llama a sí mismo dos veces con `n-1` [cite: 255-259].

* **Llamadas para $n=3$:**
    * $n=3$: Imprime 3. Llama a (2) y (2).
    * $n=2$ (x2 veces): Imprimen 2. Cada una llama a (1) y (1). Total 4 llamadas a $n=1$.
    * $n=1$ (x4 veces): Imprimen 1. Cada una llama a (0) y (0). Total 8 llamadas a $n=0$.
    * $n=0$ (x8 veces): Retornan.
    El número de llamadas sigue una progresión geométrica. Aproximadamente $2^0 + 2^1 + 2^2 + 2^3...$
    [cite_start]Total llamadas (sin contar las nulas): $1 + 2 + 4 = 7$ llamadas activas (o 15 si cuentas las llamadas base a 0).[cite: 260].

* **Complejidad:**
    Cada paso duplica el número de operaciones.
    [cite_start]Complejidad: **$O(2^n)$** (Exponencial)[cite: 261].