/**
 * Clase Lista de T elemento que implementa la clase Collection
 * @version 1
 * @author Javier Alejandro Mancera Quiroz
 */
package Clases;

import java.util.Iterator;
import java.util.NoSuchElementException;
// iterador
//next

public class Lista<T> implements Collection<T> {

    // Clase Nodo
    private class Nodo {
        public T elemento;
        public Nodo anterior;
        public Nodo siguiente;

        public Nodo(T elemento){
            this.elemento = elemento;
        }
    }

    // Iterador
    private class Iterador implements IteradorLista<T> {
        public Nodo anterior;
        public Nodo siguiente; 

        public Iterador(){
            siguiente = cabeza;
        }

        @Override public boolean hasNext(){
            return siguiente != null;
        }

        @Override public T next(){
            if(!hasNext())
                throw new NoSuchElementException();
            T regresar = siguiente.elemento;
            
            this.anterior = this.siguiente ;
            this.siguiente=siguiente.siguiente;
            return regresar;

        }
        
        @Override
        public boolean hasPrevious() {
            return anterior != null;
        }
        
        @Override
        public T previous() {
            if (!hasPrevious())
                throw new NoSuchElementException();
            T regresar = anterior.elemento;

            this.siguiente = this.anterior;
            this.anterior = anterior.anterior;
            return regresar;

        }

        @Override
        public void start(){
            this.anterior = null;
            this.siguiente = cabeza;
        }
        
        @Override
        public void end() {
            this.anterior = ultimo;
            this.siguiente = null;
        }
        
    }

    private Nodo cabeza;
    private Nodo ultimo;
    private int longi;
    
    /**
     * Agrega un elemento a la lista.
     * 
     * @param elemento el elemento a agregar.
     * @throws IllegalArgumentException si <code>elemento</code> es
     *                                  <code>null</code>.
     */
    @Override
    public void add(T elemento){
        if(elemento == null){
            throw new IllegalArgumentException("El elemento es null");
        }
        agregaFinal(elemento);
    }
    
    
    /**
     * Agrega un elemento al inicio de la lista. Si la lista no tiene elementos,
     * el elemento a agregar será el primero y último.
     * @param elemento el elemento a agregar.
     * @throws IllegalArgumentException si <code>elemento</code> es
     *         <code>null</code>.
     */
    public void agregaInicio(T elemento) {
        if (elemento == null) {
            throw new IllegalArgumentException("El elemento es null");
        }
        Nodo nuevo = new Nodo(elemento);
        if (cabeza == null) {
            this.cabeza = this.ultimo = nuevo;
        } else {
            this.cabeza.anterior = nuevo;
            nuevo.siguiente = this.cabeza;
            this.cabeza = nuevo;
        }
        longi++;
    }

    /**
     * Agrega un elemento al final de la lista. Si la lista no tiene elementos,
     * el elemento a agregar será el primero y último.
     * @param elemento el elemento a agregar.
     * @throws IllegalArgumentException si <code>elemento</code> es
     *         <code>null</code>.
     */
    public void agregaFinal(T elemento) {
        if (elemento == null) {
            throw new IllegalArgumentException("El elemento es null");
        }
        Nodo nuevo = new Nodo(elemento);
        if(cabeza == null){
            this.cabeza = this.ultimo = nuevo;
        }
        else{
            this.ultimo.siguiente = nuevo;
            nuevo.anterior = this.ultimo;
            this.ultimo = nuevo;
        }
        longi++;
    }

    private Nodo buscaElemento(T elemento){
        Nodo n = cabeza;
        while(n !=null){
            if (elemento.equals(n.elemento)) {
                return n;
            }
            n=n.siguiente;
        }
        return null;
    }

    /**
     * Elimina un elemento de la lista.
     * 
     * @param elemento el elemento a eliminar.
     */ 
    public boolean delete(T elemento){
        if(elemento == null)
            return false;
        Nodo n = buscaElemento(elemento);
        if(n==null){
            return false;
        }
        if(longi == 1){
            empty();
            return true;
        }
        if (n == cabeza) {
            cabeza = cabeza.siguiente;
            cabeza.anterior = null;
            longi --;
            return true;
        }
        if (n == ultimo) {
            ultimo = ultimo.anterior;
            ultimo.siguiente = null;
            longi --;
            return true;
        }
        n.siguiente.anterior = n.anterior;
        n.anterior.siguiente = n.siguiente;
        longi --;
        return true;
    }    



    /**
     * Regresa un elemento de la lista. (Ultimo)
     * y lo elimina.
     * 
     * @return El elemento a sacar.
     */
    public T pop(){
        T valor = ultimo.elemento;
        ultimo = ultimo.anterior;
        ultimo.siguiente = null;
        longi --;
        return valor;
    }

    /**
     * Regresa el número de elementos en la lista.
     * 
     * @return el número de elementos en la lista.
     */
    public int size(){
        return longi;
    }

    /**
     * Nos dice si un elemento está contenido en la lista.
     * 
     * @param elemento el elemento que queremos verificar si está contenido en
     *                 la lista.
     * @return <code>true</code> si el elemento está contenido en la lista,
     *         <code>false</code> en otro caso.
     */
    public boolean contains(T elemento){
        if(buscaElemento(elemento) == null){
            return false;
        }
        return true;
    }

    /**
     * Vacía la lista.
     * 
     */
    public void empty(){
        cabeza =ultimo= null;
        longi = 0;
    }

    /**
     * Nos dice si la lista es vacía.
     * 
     * @return <code>true</code> si la lista es vacía, <code>false</code> en
     *         otro caso.
     */
    public boolean isEmpty(){
        return longi == 0;
    }

    

    /**
     * Regresa una copia de la lista.
     * 
     * @return una copia de la lista.
     */
    public Lista<T> clone() {
        Lista<T> nueva = new Lista<T>();
        Nodo nodo = cabeza;
        while (nodo != null) {
            nueva.add(nodo.elemento);
            nodo = nodo.siguiente;
        }
        return nueva;
    }

    /**
     * Nos dice si la coleccion es igual a otra coleccion recibida.
     * 
     * @param coleccion la coleccion con el que hay que comparar.
     * @return <tt>true</tt> si la coleccion es igual a la coleccion recibido
     *         <tt>false</tt> en otro caso.
     */
    public boolean equals(Collection<T> coleccion){
        // lo vemos en clase
        if(coleccion instanceof Lista) {
            return true;
        }
        return false;
    }


    
    /**
     * Metodo que invierte el orden de la lista .
     * 
     * El metodo en tiempo de ejecucion es de O(n) ya que en el peor caso es cuando entraria en la condicional
     * else donde ahi utiliza 2 ciclos while que realizan a lo mucho n-1 operaciones cada una y al final se 
     * suman entre si  y aparte con las lineas restantes, dando como complejidad O(n). En espacio es de O(1) 
     * ya que unicamente ocupe un iterador y una variable de tipo entero dando O(2), siendo constante.
     */
    public void reverse() {
        // Se crea un iterador en una direccion para poder recorrer la lista
	Iterador iter = new Iterador();
	// Se crea la variable comparar para poder realizar las iteraciones necesarias
	int comparar = 0;

	// Pregunta si la lista vacia
	if(this.isEmpty()){
	    // Si es vacia entonces las referencias cabeza y ultimo apuntan a lo mismo
	    this.cabeza = this.ultimo;
	    this.ultimo = this.cabeza;
	} // Fin de la condicional if
	else {
	    // Si no entonces agrega a la lista su forma reversa y se elimina la parte en la que estaba antes  
	    // Iterador comienza desde ultimo de la lista
	    iter.end();
	    // Mientras que tenga referencia a un elemento previo en la que esta apuntando iter
	    while(iter.hasPrevious()){
		// Se agrega el elemento que esta antes
		add(iter.previous());
	    } // Fin de la condicional else
	    // Iterador comienza desde cabeza de la lista
	    iter.start();
	    // Mientras que comparar sea menor al tamanio de la lista y iter tenga referencia al siguiente elemento
	    while(comparar < this.longi && iter.hasNext()){
		// Se elimina el siguiente elemento 
		delete(iter.next());
		// Se le suma 1 a la variable comparar
		comparar++;
	    } // Fin del ciclo while
	} // Fin del ciclo while
    } // Fin de reverse

    /**
     * Regresa una representación en cadena de la coleccion.
     * 
     * @return una representación en cadena de la coleccion.
     * a -> b -> c -> d
     */
    public String toString(){
        // Se crea un iterador en una direccion para poder recorrer la lista
	Iterador iter = new Iterador();
	// Se crea una variable coleccion para poder imprimir toda la lista
        String coleccion = "";

	// Pregunta si iter tiene referencia al siguiente elemento
	if(iter.hasNext()){
	    // Se crea un ciclo for para poder guardar los siguientes elementos en la variable coleccion 
	    for(int comparar = 0; comparar < this.longi-1; comparar++){
		coleccion += iter.next() + " -> ";
	    } // Fin del ciclo for
	    // Regresa la variable coleccion y el ultimo elemento de la lista
	    return coleccion + this.ultimo.elemento;
	} // Fin de la condicional if
	else { 
	    // Si no entonces no regresara nada  
	    return "";
	} // Fin de la condicional else
    } // Fin de toString

    /**
     * Junta dos listas siempre y cuando sean del mismo tipo.
     * 
     */
    public void append(Lista<T> lista) {
        // Se crea un nodo auxiliar que apunta a la cabeza de la lista a juntar
	Nodo auxiliar = lista.cabeza;
	// Se crea una variable tamanio para poder representar el tamanio de la lista a juntar
	int tamanio = lista.size();
	// Se crea una variable comparar para realizar las iteraciones necesarias
	int comparar = 0;

	// Mientras que comparar sea menor a tamanio se agregan los elementos de la lista a juntar
	while(comparar < tamanio){
	    // Se agrega el elemento que tiene como referencia auxiliar
	    add(auxiliar.elemento);
	    // Auxiliar apunta ahora al siguiente elemento de lista
	    auxiliar = auxiliar.siguiente;
	    // Se le suma 1 a comparar
	    comparar++;
	} // Fin del ciclo while
	// Se actualiza la longitud de la lista 
	comparar = this.longi;
    } // Fin de append

    /**
     * Regresa un entero con la posicion del elemento.
     * Solo nos importara la primera aparición del elemento
     * Empieza a contar desde 0.
     * 
     * @param elemento elemento del cual queremos conocer la posición.
     * @return entero con la posicion del elemento
     * @throws IllegalArgumentException si <code>elemento</code> es
     *         <code>null</code>.
     */
    public int indexOf(T elemento) {
	// Se crea un iterador en una direccion para poder recorrer la lista
	Iterador iter = new Iterador();
	// Se crea una variable contar que representa el indice
	int contar = 0;

	// Pregunta si el elemento es nulo  
	if(elemento == null){
	    // Si es nulo entonces manda un error
	    throw new NoSuchElementException ("El elemento no puede ser nulo");
	} // Fin de la condicional if
	else if(this.contains(elemento)){
	    // Si lo contiene la lista entonces manda la posicion
	    // Mientras que contar sea menor al tamanio de la lista 
	    while(contar < this.longi){
		// Pregunta si el elemento es igual al siguiente elemento de la referencia iter
		if(elemento == iter.next()){
		    // Regresa el valor de contar
		    return contar;
		} // Fin de la condicional if
		// Se le suma 1 a contar 
		contar++;
	    } // Fin del ciclo while
	} // Fin de la condicional else if
	// Si la lista no lo contiene 
	else if(! this.contains(elemento) && ! this.isEmpty()){
	    // Manda un error
	    throw new NoSuchElementException ("El elemento no esta en la lista");
	} // Fin de la condicional else if
	else {
	    // Si no manda error
	    throw new NoSuchElementException ("La lista esta vacia");
	} // Fin de la condicional else
	// Regresa el valor de contar
	return contar;
    } // Fin de indexOf 
    
    /**
     * Inserta un elemento en un índice explícito.
     *
     * Si el índice es menor que cero, el elemento se agrega al inicio de la
     * lista. Si el índice es mayor o igual que el número de elementos en la
     * lista, el elemento se agrega al fina de la misma. En otro caso, después
     * de mandar llamar el método, el elemento tendrá el índice que se
     * especifica en la lista.
     * 
     * @param i        el índice dónde insertar el elemento. Si es menor que 0 el
     *                 elemento se agrega al inicio, y si es mayor o igual que el
     *                 número
     *                 de elementos en la lista se agrega al final.
     * @param elemento el elemento a insertar.
     * @throws IllegalArgumentException si <code>elemento</code> es
     *                                  <code>null</code>.
     */
    public void insert(int i, T elemento) {
        // Se crea un iterador en una direccion para poder recorrer la lista
	Iterador iter = new Iterador();
	// Se crea un nodo auxiliar que contiene al elemento a insertar
	Nodo auxiliar = new Nodo(elemento);
	// Se crea una variable posicion para insertarlo en la posicion indicada
	int posicion = 0;
	
	// Pregunta si el entero i es menor a 0
	if (i < 0){
	    // Si es menor a 0 entonces se agrega al inicio de la lista el elemento 
	    agregaInicio(elemento);
	    // Se le suma 1 a la longitud de la lista
	    this.longi++;
	} // Fin de la condicional if
	// Si i es mayor o igual al tamanio de la lista
	else if(i >= this.longi) {
	    // Agrega al final de la lista el elemento
	    agregaFinal(elemento);
	    // Se le suma 1 a la longitud de la lista
	    this.longi++;
	} // Fin de la condicional else if
	else {
	    // Si no se agrega a la posicion indicada
	    // Se agrega al inicio de la lista el elemento que tiene como referencia auxiliar
	    agregaInicio(auxiliar.elemento);
	    // Mientras que la variable posicion sea menor al valor de i 
	    while(posicion < i){
		// Se elimina el siguiente elemento de la referencia iter
		delete(iter.next());
		// Se agrega el anterior elemento de la referencia iter
		add(iter.previous());
		// Se recorre al siguiente elemento la referencia iter
		iter.next();
		// Se le suma 1 a posicion
		posicion++;
	    } // Fin del ciclo while
	    // Se le asigna el 0 a posicion
	    posicion = 0;
	    // Iterador comienza desde cabeza de la lista
	    iter.start();
	    // Mientras que posicion sea menor al tamanio menos el valor de i para poder reacomodar bien la lista
	    while(posicion < this.size()-i){
		// Se elimina el siguiente elemento de la referencia iter
		delete(iter.next());
		// Se agrega el anterior elemento de la referencia iter
		add(iter.previous());
		// Se recorre al siguiente elemento la referencia iter
		iter.next();
		// Se le suma 1 a posicion
		posicion++;
	    } // Fin del ciclo while
	    // Se actualiza la longitud de la lista
	    this.longi = this.size();
	} // Fin de la condicional else
    } // Fin de insert 

    /**
     * Metodo que mezcla la lista con otra lista.
     * 
     * El metodo en tiempo de ejecucion es de O(n + m) ya que, sea en cualquier condicional que entraria,  
     * utilice 2 ciclos while que realizan a lo mucho n-1 y m-1 operaciones respectivamente y al final se 
     * suman entre si  y aparte con las lineas restantes, dando como complejidad O(n+m). En espacio es de O(1) 
     * ya que unicamente ocupe un iterador y 3 variables de tipo entero dando O(4), siendo constante.
     *
     * @param lista Lista que se va a ocupar para hacer la mezcla con la lista original. 
     */
    public void mezclaAlternada(Lista<T> lista){
	// Se crea un iterador en una direccion para poder recorrer la lista
	Iterador iter = new Iterador();
	// Se crea una variable tamanioLista2 para poder representar el tamanio de la lista 
	int tamanioLista2 = lista.longi;
	// Se crea una variable tamanioLista1 para poder representar el tamanio de la lista original 
	int tamanioLista1 = this.longi;
	// Se crea una variable comparar para realizar las iteraciones necesarias
	int comparar = 0;

	// Pregunta si el tamanio de la lista es menor o igual al tamanio de la lista original
	if(lista.size() <= this.size()){
	    // Mientras que la varible comparar sea menor al tamanio de la lista 
	    while(comparar < tamanioLista2){
		// Se agrega el siguiente elemento de la referencia iter
		add(iter.next());
		// Se elimina el anterior elemento de la referencia iter
		delete(iter.previous());
		// Se agrega a la lista el elemento de la referencia cabeza de la lista 
		add(lista.cabeza.elemento);
		// Se elimina el elemento de la referencia cabeza de la lista 
		lista.delete(lista.cabeza.elemento);
		// Se recorre al siguiente elemento la referencia iter
		iter.next();
		// Se le suma 1 a posicion
		comparar++;
	    } // Fin del ciclo while
	    // Se le asigna el 1 a comparar
	    comparar = 1;
	    // Mientras que comparar sea menor o igual al tamanio de la lista original menos el tamanio de la lista se acomodaran los elementos faltantes de la lista original
	    while(comparar <= tamanioLista1 - tamanioLista2){
		// Se agrega el siguiente elemento de la referencia iter
		add(iter.next());
		// Se elimina el anterior elemento de la referencia iter
		delete(iter.previous());
		// Se recorre al siguiente elemento la referencia iter
		iter.next();
		// Se le suma 1 a posicion
		comparar++;
	    } // Fin del ciclo while
	} // Fin de la condicional if
	else {
	    // Sino se realiza lo mismo solo que agregandole los elementos que hacen falta de la lista
	    // Mientras que la varible comparar sea menor al tamnaio de la lista original
	    while(comparar < tamanioLista1){
		// Se agrega el siguiente elemento de la referencia iter
		add(iter.next());
		// Se elimina el anterior elemento de la referencia iter
		delete(iter.previous());
		// Se agrega a la lista el elemento de la referencia cabeza de la lista 
		add(lista.cabeza.elemento);
		// Se elimina el elemento de la referencia cabeza de la lista
		lista.delete(lista.cabeza.elemento);
		// Se recorre al siguiente elemento la referencia iter
		iter.next();
		// Se le suma 1 a posicion
		comparar++;
	    } // Fin del ciclo while
	    // Mientras que la varible comparar sea menor o igual al tamanio de la lista menos 1
	    while(comparar <= tamanioLista2 - 1){
		// Se agrega a la lista original el elemento de la referencia cabeza de la lista
		add(lista.cabeza.elemento);
		// Se elimina el elemento de la referencia cabeza de la lista
		lista.delete(lista.cabeza.elemento);
		// Se le suma 1 a posicion
		comparar++;
	    } // Fin del ciclo while
	} // Fin de la condicional else
	// Se actualiza la longitud de la lista
	this.longi = this.size();
    } // Fin de mezclaAlternada

    /**
     * Regresa un iterador para recorrer la lista en una dirección.
     * @return un iterador para recorrer la lista en una dirección.
     */
    public Iterator<T> iterator() {
        return new Iterador();
    }

    /**
     * Regresa un iterador para recorrer la lista en ambas direcciones.
     * @return un iterador para recorrer la lista en ambas direcciones.
     */
    public IteradorLista<T> iteradorLista() {
        return new Iterador();
    }
}
