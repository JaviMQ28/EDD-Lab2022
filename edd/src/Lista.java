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
     */
    public void reverse() {
        // Tu codigo aqui
      
	//Iterator iter = iterator();
	//iter.start();
	
	//agregaInicio(cabeza.elemento);
	//delete(cabeza.elemento);

	Iterador iter = new Iterador();
	//Iterador iter2 = new Iterador();
	int comparar = 0;
	//Nodo auxiliar = cabeza.anterior;
	
	if(this.isEmpty()){
	    this.cabeza = this.ultimo;
	    this.ultimo = this.cabeza;
	} else {
	    //while(comparar == this.longi){
	    //iter.next();
	    iter.end();
	    while(comparar < this.longi && iter.hasPrevious()){
		//delete(iter.next());		
		add(iter.previous());
		//delete(ultimo.elemento);
		comparar++;
	    }

	    iter.start();
	    comparar = 0;
	    while(comparar < this.longi && iter.hasNext()){
		//delete(iter.next());		
		delete(iter.next());
		//delete(ultimo.elemento);
		comparar++;
	    }
	    //delete(iter.next());
	    //delete(iter.next());
	    //agregaInicio(iter.previous());
	    //iter.start();
	    //delete(ultimo.elemento);
	    //iter.start();
	    
	    //while(iter.hasNext()){
		//delete(iter.next());
	    //	delete(iter.previous());
	    //}
	    //}
	}
	/*
	if(this.isEmpty()){
	    cabeza = ultimo;
	    ultimo = cabeza;
	} else {
	    Nodo i = cabeza.siguiente;
	    Nodo j = ultimo.anterior;
  
	    delete(j.anterior.anterior.anterior.anterior.anterior.anterior.anterior.anterior.elemento);
	    agregaInicio(i.elemento);
	    delete(j.anterior.anterior.anterior.anterior.anterior.anterior.anterior.elemento);
	    agregaInicio(i.siguiente.elemento);
	    delete(j.anterior.anterior.anterior.anterior.anterior.anterior.elemento);
	    agregaInicio(i.siguiente.siguiente.elemento);
	    delete(j.anterior.anterior.anterior.anterior.anterior.elemento);
	    agregaInicio(i.siguiente.siguiente.siguiente.elemento);
	    delete(j.anterior.anterior.anterior.anterior.elemento);
	    agregaInicio(i.siguiente.siguiente.siguiente.siguiente.elemento);
	    delete(j.anterior.anterior.anterior.elemento);
	    agregaInicio(i.siguiente.siguiente.siguiente.siguiente.siguiente.elemento);
	    delete(j.anterior.anterior.elemento);
	    agregaInicio(i.siguiente.siguiente.siguiente.siguiente.siguiente.siguiente.elemento);
	    delete(j.anterior.elemento);
	    agregaInicio(i.siguiente.siguiente.siguiente.siguiente.siguiente.siguiente.siguiente.elemento);
	    delete(j.elemento);
	    agregaInicio(i.siguiente.siguiente.siguiente.siguiente.siguiente.siguiente.siguiente.siguiente.elemento);
	    delete(ultimo.elemento);
	    agregaInicio(i.siguiente.siguiente.siguiente.siguiente.siguiente.siguiente.siguiente.siguiente.siguiente.elemento);
	}
	*/
	
	
	//ultimo = ultimo.anterior;
	//agregaInicio(ultimo.elemento);
	//ultimo = ultimo.anterior;
	//agregaInicio(ultimo.elemento);
	
	//while(i < this.longi){
	    
	//  if (this.ultimo.anterior != null){
	//	iter.start();
	//	this.ultimo = this.ultimo.anterior;
	//	iter.end();
	//  }
	//  i++;
	//}

	//this.cabeza = this.ultimo;
	//if (this.ultimo == null){
	//  this.ultimo = this.cabeza;
	//} else {
	//  this.ultimo = this.ultimo.anterior;
	//}
        //return ;
    }

    /**
     * Regresa una representación en cadena de la coleccion.
     * 
     * @return una representación en cadena de la coleccion.
     * a -> b -> c -> d
     */
    public String toString(){
        // Tu codigo aqui
	Iterador iter = new Iterador();
        String coleccion = "";
	//int comparar = 0;
	
	//if(! iter.hasNext()){
	//return "";
	//} else {
	//  return iter.next() + " -> " + iter.next() + " -> " + iter.next() + " -> " + iter.next() + " -> " + iter.next() + " -> " + iter.next();
	//}

	if(iter.hasNext()){
	    for(int comparar = 0; comparar < this.longi-1; comparar++){
		coleccion += iter.next() + " -> ";
	    }
	    return coleccion + this.ultimo.elemento;
	} else {
	    return "";
	}
	/*
	if(this.isEmpty()){
	    return "";
	} else {
	    while(iter.hasNext() && comparar < this.longi-1){
		elem += iter.next() + " -> ";
		comparar++;
	    }
	    return elem + ultimo.elemento;
	}
	*/

	//if(! isEmpty()){
	//return cabeza.elemento + " -> " + cabeza.siguiente.elemento + " -> " + cabeza.siguiente.siguiente.elemento + " -> " + cabeza.siguiente.siguiente.siguiente.elemento + " -> " + cabeza.siguiente.siguiente.siguiente.siguiente.elemento + " -> " + cabeza.siguiente.siguiente.siguiente.siguiente.siguiente.elemento;
	//} else {
	//return "";
	//}
    
    }

    /**
     * Junta dos listas siempre y cuando sean del mismo tipo.
     * 
     */
    public void append(Lista<T> lista) {
        // Tu codigo aqui
	//Iterador iter = new Iterador();
	Nodo auxiliar = lista.cabeza;
	int tamanio = lista.size();
	int comparar = 0;

	while(comparar < tamanio){
	    //add(iter.next());
	    add(auxiliar.elemento);
	    //delete(auxiliar.elemento);
	    auxiliar = auxiliar.siguiente;
	    //delete(auxiliar.elemento);
	    //if(auxiliar == lista.ultimo){
	    //	delete(auxiliar.elemento);
	    //}
	    //add(lista.cabeza.elemento);
	    //auxiliar = lista.cabeza;
	    comparar++;
	}
	//return ;
    }

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
        // Tu codigo aqui
	Iterador iter = new Iterador();
	int contar = 0;

	if(elemento == null){
	    throw new NoSuchElementException ("El elemento no puede ser nulo");
	    //  break;
	} else if(this.contains(elemento)){
	    while(contar < this.longi){
	    //try{
	    //if(this.contains(elemento) && elemento == iter.next()){
		//return i;
		//} else {
		//throw new NoSuchElementException("El elemento no esta en la lista");
		//}
	    //} catch (NoSuchElementException Error){
	    //System.out.println("El elemento no esta en la lista");
	    //}
		if(elemento == iter.next()){
		    return contar;
		}
		    contar++;
	    }
	} else if(! this.contains(elemento) && ! this.isEmpty()){
	    throw new NoSuchElementException ("El elemento no esta en la lista");
	    //  break;
	} else {
	    throw new NoSuchElementException ("La lista esta vacia");
	}
	return contar;
    }
    
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
        // Tu codigo aqui
	Iterador iter = new Iterador();
	Nodo auxiliar = new Nodo(elemento);
	int j = 0;
	//int k = i;

	if (i < 0){
	    agregaInicio(elemento); 
	} else if(i >= this.longi) {
	    agregaFinal(elemento);
	} else {
	    //iter.next();
	    agregaInicio(auxiliar.elemento);
	    //auxiliar.siguiente = cabeza.siguiente;
	    //System.out.println(cabeza.elemento);
	    /*	    delete(iter.next());
	    add(iter.previous());
	    iter.next();
	    delete(iter.next());
	    add(iter.previous());*/

	     while(j < i){
		delete(iter.next());
		add(iter.previous());
		iter.next();
		j++;
	    }

	    j = 0;

	    iter.start();
	    while(j < this.longi-i){
		delete(iter.next());
		add(iter.previous());
		iter.next();
		j++;
	    }
	    
	    //while(j < i){
	    //delete(iter.next());
	    //	agregaInicio(iter.previous());
		//j++;
		//}
	    /*cabeza.siguiente.siguiente.siguiente = auxiliar.anterior;
	      auxiliar.siguiente = ultimo.anterior.anterior;*/
	    //auxiliar.anterior.elemento = cabeza.siguiente.elemento;
	    //System.out.println(auxiliar.elemento);
	    //agregaInicio(elemento);
	    //while(j < i){
	    
	    //}
	}
	/*if (i < 0){
	    agregaInicio(elemento); 
	} else if(i >= this.longi){
	    agregaFinal(elemento);
	}
	else {
	    
	    // while(i != 0){
	    //	iter.next();
		//iter.next();
	    	//i--;
	    //}

	    while(i != 0){
		add(iter.next());		
		i--;
	    }

	    if(i == 0){
		add(elemento);
	    }

	    while(j <= k){
		add(iter.next());
		j++;
	    }
	    
	    j = 0;
	    iter.start();
	    while(j < this.longi-1){
		delete(iter.next());
		j++;
		}
	    //this.cabeza.elemento = iter.next();
	    //delete(iter.next());
	    // agregaInicio(elemento);
	    //this.cabeza.elemento = elemento;

	    //while(j != i){
	    //	iter.next();
	    //	j++;
	    //}
	    
	    //this.cabeza.siguiente.elemento = this.cabeza.elemento;
	    }*/
	//return ;
    }

    // Tu comentario
    public void mezclaAlternada(Lista<T> lista){
	Iterador iter = new Iterador();
	int i = lista.longi;
	int k = longi;
	//Nodo auxiliar = lista.cabeza;
	int j = 0;

	
	//System.out.println(lista.cabeza.elemento);
	/*add(iter.next());
	delete(iter.previous());
	add(lista.cabeza.elemento);
	lista.delete(lista.cabeza.elemento);
	iter.next();
	add(iter.next());
	delete(iter.previous());
	add(lista.cabeza.elemento);
	lista.delete(lista.cabeza.elemento);*/

	if(lista.size() <= this.size()){
	    while(j < i){
		add(iter.next());
		delete(iter.previous());
		add(lista.cabeza.elemento);
		lista.delete(lista.cabeza.elemento);
		iter.next();
		//System.out.println(j);
		//this.insert(k, lista.cabeza.elemento);
		//k++;
		j++;
	    }
	    
	    //System.out.println(k);
	    //System.out.println(i);
	    j = 1;
	
	    //iter.start();
	    while(j <= k - i){
		add(iter.next());
		delete(iter.previous());
		iter.next();
		j++;
	    }
	} else {
	    //System.out.println(j);
	    //System.out.println(k);
	    //System.out.println(i);
	    while(j < k){
		add(iter.next());
		delete(iter.previous());
		add(lista.cabeza.elemento);
		lista.delete(lista.cabeza.elemento);
		iter.next();
		//System.out.println(j);
		//this.insert(k, lista.cabeza.elemento);
		//k++;
		j++;
	    }

	    //System.out.println(j);
	    //System.out.println(k);
	    //System.out.println(i);
	    while(j <= i - 1){
	        add(lista.cabeza.elemento);
		lista.delete(lista.cabeza.elemento);
		//iter.next();
		j++;
	    }
	    //add(lista.cabeza.elemento);
	    //lista.delete(lista.cabeza.elemento);
	}
	
	//delete(iter.next());
	//delete(iter.next());
	//Iterador iter2 = new Iterador();
	//add(iter.next());

	/*add(iter.next());
	add(lista.cabeza.elemento);
	add(iter.next());
	add(lista.cabeza.siguiente.elemento);
	add(iter.next());
	add(lista.cabeza.siguiente.siguiente.elemento);
	add(iter.next());
	add(lista.cabeza.siguiente.siguiente.siguiente.elemento);
	add(iter.next());
	add(lista.cabeza.siguiente.siguiente.siguiente.siguiente.elemento);
	add(iter.next());
	//add(lista.cabeza.siguiente.siguiente.siguiente.siguiente.siguiente.elemento);
	add(iter.next());

	iter.start();

	delete(iter.next());
	delete(iter.next());
	delete(iter.next());
	delete(iter.next());
	delete(iter.next());
	delete(iter.next());
	delete(iter.next());*/
	
	//while(j < this.longi){
	    //lista.add(iter.next());
	    //add(iter.next());
	//  iter.start();
	//  lista.add(iter.next());
	    //lista.add(iter.next());
	//  j++;
	//}
	//return;
    }

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
