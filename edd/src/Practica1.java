/**
 * Clase Practica para probar los metodos creados
 * @version 1
 * @author Javier Alejandro Mancera Quiroz
 */
package Clases;

import java.util.Iterator;

public class Practica1 {
    


    /**
     * Metodo que agrega un elemento a una lista ordenada en su correcta posicion por el valor que tenga.
     * 
     * El metodo en tiempo de ejecucion es de O(n) ya que en el peor caso es cuando entraria en la condicional
     * else donde ahi utiliza 1 ciclo while que realizan a lo mucho n+1 operaciones, cuando hacemos llamar
     * al metodo insert se tarda n veces y al final se sumarian junto a las lineas restantes, dando como
     * complejidad O(n). En espacio es de O(1) ya que unicamente ocupe un iterador y una variable de tipo
     * entero dando O(2), siendo constante.
     *
     * @param lista Lista que se va a ocupar para agregarle un elemento
     * @return La lista incluyendo el elemento que se le agrego
     */
    public static Lista<Integer> AgregaOrdenado(Lista<Integer> lista, int nuevo) {
        // Se crea un iterador en una direccion para poder recorrer la lista
	Iterator<Integer> iter = lista.iterator();
	// Se crea una variable posicion para insertarlo en la posicion indicada
	int posicion = 0;

	// Pregunta si la lista contiene al elemento nuevo
	if(lista.contains(nuevo)){
	    // Si esta, lo inserta antes del mismo
	    lista.insert(lista.indexOf(nuevo), nuevo);
	} // Fin de la condicional if
	else {
	    // Sino, lo inserta en la posicion que tiene que estar
	    // Mientras que iter tenga referencia al siguiente elemento, el elemento nuevo sea mayor mayor al siguiente y que la variable posicion menor al tamanio de la lista  
	    while(iter.hasNext() && nuevo > iter.next()){
		// Se le suma 1 a la variable posicion
		posicion++;	
	    } // Fin del ciclo while
	    // Pregunta si posicion es mayor al tamanio de la lista
	    if(posicion > lista.size()){
		// Se le suma 1 a la variable posicion
		posicion++;
	    } // Fin de la condicional if
	    // Inserta el elemento nuevo en el lugar que toma posicion
	    lista.insert(posicion, nuevo);
	} // Fin de la condicional else
	// Regresa la lista
	return lista;
    } // Fin de AgregaOrdenado

    /**
     * Metodo que realiza la Union de dos listas.
     * 
     * El metodo en tiempo de ejecucion es de O(n * m) ya que, sea en cualquier condicional que entraria, 
     * utilizan metodos que repercuten en que realicen a lo mucho n operaciones cada una y ya que estan 
     * anidados con el ciclo while por eso cumplen con la regla de la multiplicacion y al final se sumarian 
     * junto a las lineas restantes, dando como complejidad O(n * m). En espacio es de O(n + m) 
     * ya que se agregaron los enteros que cumplen con la condicion otorgando que sea O(n + m).
     *
     * La forma en que mejoraria el tiempo seria creando un metodo que agregue a las dos listas
     * de forma ordenada y para quitar los duplicados ya solo seria cuestion de preguntar si son lo mismo 
     * el elemento con el que le sigue para solo quitarle uno de ellos.
     *
     * @param lista1 Lista que se va a ocupar para sacar la union de las dos listas
     * @param lista2 Lista con la que se hara la union de las dos listas     
     */
    public static void Union(Lista<Integer> lista1,Lista<Integer> lista2) {
	// Se crea un iterador en una direccion para poder recorrer la lista 1
	Iterator<Integer> iter1 = lista1.iterator();
	// Se crea un iterador en una direccion para poder recorrer la lista 2
	Iterator<Integer> iter2 = lista2.iterator();
	// Se crea una variable posicion para insertarlo en la posicion indicada
	int posicion = 0;
	// Se crea elemLista2 que representa un elemento de la lista 2
	Integer elemLista2 = iter2.next();

	// Mientras que iter2 tenga referencia al siguiente elemento
	while(iter2.hasNext()){
	    // Pregunta si la lista 1 no contiene al elemento de la lista 2
	    if(! lista1.contains(elemLista2)){
		// Si no esta, lo inserta en la lista 1   
		lista1.insert(posicion,elemLista2);
	    } // Fin de la condicional if
	    else{
		// Si esta, se toma el siguiente elemento de la lista 2
		elemLista2 = iter2.next();
	    } // Fin de la condicional if
	} // Fin del ciclo while
	// Pregunta si la lista 1 no contiene al elemento de la lista 2
	if(! lista1.contains(elemLista2)){
	    // Inserta el elemento de la lista 2 en el lugar que toma posicion en la lista 1
	    lista1.insert(posicion,elemLista2);
	} // Fin de la condicional if
    } // Fin de Union

    /**
     * Metodo que realiza la Interseccion de dos listas.
     * 
     * El metodo en tiempo de ejecucion es de O(n * m) ya que el peor de los casos es cuando no esta 
     * vacia completamente la lista despues del ciclo while, en el primer ciclo while cuando pregunta si 
     * contiene algun elemento a lo mucho se tarda n veces, como esta anidado el if con el while cumplen con 
     * la regla de la multiplicacion y al final se sumarian con las demas operaciones, dando como complejidad 
     * O(n * m). En espacio es de O(m) ya que se agregaron unicamente los elementos que al final se quedaron 
     * en la segunda lista.
     *
     * La forma en que mejoraria el tiempo seria creando un metodo que agregue a las dos listas
     * de forma ordenada, quitar los no duplicados y realizar lo mismo con la Union quitar los duplicados.
     *
     * @param lista1 Lista que se va a ocupar para sacar la interseccion de las dos listas
     * @param lista2 Lista con la que se hara la interseccion de las dos listas     
     */
    public static void Interseccion(Lista<Integer> lista,Lista<Integer> lista2) {
	// Se crea un iterador en una direccion para poder recorrer la lista 1
	Iterator<Integer> iter1 = lista.iterator();
	// Se crea un iterador en una direccion para poder recorrer la lista 2
	Iterator<Integer> iter2 = lista2.iterator();
	// Se crea elemLista2 que representa un elemento de la lista 2
	Integer elemLista2;

	// Mientras que iter2 tenga referencia al siguiente elemento
	while(iter2.hasNext()){
	    //elemLista2 se toma el siguiente elemento de la lista 2
	    elemLista2 = iter2.next();
	    // Pregunta si la lista no contiene al elemento de la lista 2
	    if(! lista.contains(elemLista2)){
		// Se elimina de la lista 2
		lista2.delete(elemLista2);
	    } // Fin de la condicional if
	} // Fin del ciclo while
	// Pregunta si la lista no esta vacia
	if(! lista.isEmpty()){
	    // La lista se vuelve vacia
	    lista.empty();
	} // Fin de la condicional if

	// Se crea un iterador en una direccion para poder recorrer la lista 2
	Iterator<Integer> iter3 = lista2.iterator();

	// Mientras que iter3 tenga referencia al siguiente elemento
	while(iter3.hasNext()){
	    // elemLista2 se toma el siguiente elemento de la lista 2
	    elemLista2 = iter3.next();
	    // Se agrega a la lista el elemento de la lista 2 
	    lista.add(elemLista2);
 	} // Fin del ciclo while
    } // Fin de Interseccion



    public static void main(String[] args) {
        Lista<Integer> primera = new Lista<Integer>();
        Lista<Integer> segunda = new Lista<Integer>();
        Lista<Integer> tercera = new Lista<Integer>();
        
	
        // Tests toString
        for (int i = 0; i <= 5; i++) {
	    primera.add(i);
	}

        String test = "0 -> 1 -> 2 -> 3 -> 4 -> 5";
	if (!primera.toString().equals(test)) {
            System.out.println("1 El toString no funciona!");
        }
        primera = new Lista<Integer>();
	if (!primera.toString().equals("")) {
            System.out.println("2 El toString no funciona!");
        }
            
        // Tests Reverse
        primera = new Lista<Integer>();
        segunda = new Lista<Integer>();

	
        for (int i = 0; i <= 10; i++) {
            primera.add(i);
            segunda.agregaInicio(i);
	}
        primera.reverse();
	if (!primera.toString().equals(segunda.toString())) {
            System.out.println("1 El reverse no funciona!");    
        }
        primera = new Lista<Integer>();
        segunda = new Lista<Integer>();
	primera.reverse();
	if (!primera.toString().equals(segunda.toString())) {
            System.out.println("2 El reverse no funciona!");
        }

        // Tests Append
        primera = new Lista<Integer>();
        segunda = new Lista<Integer>();
        for (int i = 0; i <= 10; i++) {
            primera.add(i);
            segunda.add(i);
        }
        for (int i = 0; i <= 10; i++) {
            segunda.add(i);
	}
	primera.append(primera.clone());
        
        if (!primera.toString().equals(segunda.toString())) {
            System.out.println("1 El Append no funciona!");
        }

        // Tests IndexOf
        if (primera.indexOf(0) != 0) {
            System.out.println("1 El IndexOf no funciona!");
        }
        if (primera.indexOf(1) != 1) {
            System.out.println("2 El IndexOf no funciona!");
        }
        if (primera.indexOf(10) != 10) {
            System.out.println("3 El IndexOf no funciona!");
        }

        // Tests Insert
        primera = new Lista<Integer>();
        segunda = new Lista<Integer>();
        for (int i = 0; i <= 10; i++) {
            primera.add(i);
            
	}
	for (int i = 0; i <= 4; i++) {
	  segunda.add(i);
	  
        }
        segunda.add(6);
        for (int i = 5; i <= 10; i++) {
	    segunda.add(i);
	    
	}
	
        primera.insert(5, 6);
        if (!primera.toString().equals(segunda.toString())) {
            System.out.println("1 El insert no funciona!");
        }

        // Tests Mezcla Alternada
        primera = new Lista<Integer>();
        segunda = new Lista<Integer>();
        for (int i = 0; i <= 10; i++) {
            if (i % 2 == 0) {
                primera.add(i);
            }   
        }
        primera.add(11);
	for (int i = 0; i <= 10; i++) {
            if (i % 2 != 0) {
                segunda.add(i);
            }

        }
        for (int i = 0; i <= 11; i++) {
            
	    tercera.add(i);
	    
	}


	primera.mezclaAlternada(segunda);
	if (!primera.toString().equals(tercera.toString())) {
            System.out.println("1 la mezclaAlternada no funciona!");
        }


        // Tests Agrega Ordenado
        primera = new Lista<Integer>();
        segunda = new Lista<Integer>();
        for (int i = 0; i <= 10; i++) {
            primera.add(i);
        }
        for (int i = 0; i <= 9; i++) {
            segunda.add(i);
        }
        segunda.add(9);
        segunda.add(10);

        tercera = AgregaOrdenado(primera,9);
        if (!tercera.toString().equals(segunda.toString())) {
            System.out.println("1 el agregaOrdenado no funciona!");
        }
        
        // Tests Union
        primera = new Lista<Integer>();
        segunda = new Lista<Integer>();
        tercera = new Lista<Integer>();
        primera.add(1);
        primera.add(2);
        primera.add(3);
        segunda.add(2);
	Union(primera, segunda);
		
        if (!(primera.contains(1) && primera.contains(2) && primera.contains(3) && primera.size() == 3)) {
            System.out.println("1 La union no funciona!");
        }
        
        // Tests interseccion
        primera = new Lista<Integer>();
        segunda = new Lista<Integer>();
        tercera = new Lista<Integer>();
        primera.add(1);
        primera.add(2);
        primera.add(3);
        segunda.add(2);
        Interseccion(primera, segunda);

        if (!(primera.contains(2) && primera.size() == 1)) {
            System.out.println("1 La intersección no funciona!");
        }
        
        



    }   
   

    


}
