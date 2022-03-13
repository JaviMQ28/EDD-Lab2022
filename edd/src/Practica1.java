package Clases;

import java.util.Iterator;

public class Practica1 {
    


    // Aqui va tu comentario
    public static Lista<Integer> AgregaOrdenado(Lista<Integer> lista, int nuevo) {
        //Tu codigo aqui
	Iterator<Integer> iter = lista.iterator();
	int j = 0;

	/*if(lista.contains(nuevo)){
	    while(j != nuevo){
		iter.next();
		j++;
	    }
	    lista.insert(j, nuevo);
	} else {

	    while(nuevo > iter.next() && j < lista.size()-1){
		//iter.next();
		//System.out.println(j + " - " + lista.size());
		
		j++;
		if(j+1 >= lista.size()){
		    j++;
		}
		
	    }
	    lista.insert(j, nuevo);
	    }*/

	if(lista.contains(nuevo)){
	    /*while(j != nuevo){
		iter.next();
		System.out.println(j + " - " + lista.size());
		j++;
	    }
	    //j = iter.next();
	    System.out.println(j);*/
	    lista.insert(lista.indexOf(nuevo), nuevo);
	} else {

	    while(iter.hasNext() && nuevo > iter.next() && j < lista.size()){
		//iter.next();
		//System.out.println(j + " - " + lista.size());
		
		j++;
		/*if(j >= lista.size()){
		    //while(! iter.hasNext()){
			j++;
			//}
			}*/
		
	    }
	    //System.out.println(j);
	    //System.out.println(iter.next());
	    if(j > lista.size()){
		//while(! iter.hasNext()){
		j++;
			//}
	    }
	    
	    lista.insert(j, nuevo);
	}
	
	//while(nuevo != j){
	    //System.out.print(iter.next() + " -> ");
	    //j = iter.next();
	    //return  j + " -> ";
	    //j++;
	//}
	
	//if(nuevo == j){
	    //return System.out.print(nuevo);
	//}

	//while(j != lista.size()){
	    //return System.out.print(" -> " + iter.next());
	//  j++;
	//}
	return lista;
	//System.out.println();
	//while(nuevo != lista.indexOf(nuevo)){
	//  System.out.println(iter.next());
	//  if(nuevo == lista.indexOf(nuevo)){
	//	lista.add(nuevo);
	//  }
	//}
	    //lista.add(nuevo);
        //return lista;
    }

    // Aqui va tu comentario
    public static void Union(Lista<Integer> lista1,Lista<Integer> lista2) {
 
	Iterator<Integer> iter1 = lista1.iterator();
	Iterator<Integer> iter2 = lista2.iterator();
	int i = 0;
	Integer j = iter1.next();
	Integer k = iter2.next();

	//lista1.insert(i,k);
	//System.out.println(k);
	//System.out.println(lista1.contains(k));
	//System.out.println();
	while(iter2.hasNext()){
	    //System.out.println(k);
	    //k = iter2.next();
	    
	    if(! lista1.contains(k)){
		//System.out.println();
		//System.out.println(k);
		lista1.insert(i,k);
		
		//	k = iter2.next();
	    }
	    else{
		//System.out.println("1- " + k);
		k = iter2.next();
		//System.out.println("2- " +k);
	    }
	    //System.out.println("i= " + i);
	    
	}
	if(! lista1.contains(k)){
	    //	    System.out.println();
	    //System.out.println(k);
	    lista1.insert(i,k);
		//	k = iter2.next();
	}

	/*while(iter1.hasNext()){
	    //System.out.println(k);
	    //k = iter2.next();
	    
	    if(j == ){
		System.out.println();
		System.out.println(k);
		lista1.insert(i,k);
		
		//	k = iter2.next();
	    }
	    else{
		System.out.println("1- " + k);
		k = iter2.next();
		System.out.println("2- " +k);
	    }
	    //System.out.println("i= " + i);
	    
	    }*/
	
	//k = iter2.next();
	//System.out.println(j);
	//System.out.println(k);
	//lista1.mezclaAlternada(lista2);

	//for(i = 0; i < lista1.size(); i++){
	//  if(j ){

	//  }
	//}
	/*j = iter1.next();
	while(j == k){
	    
	    lista1.delete(k);
	    k = iter2.next();
	    }*/
	//lista1.add(iter1.next());
	//lista2.add(iter2.next());
	//if(iter1.next() != iter1.next()){

	//compareTo(j,k);
	//while(iter2.hasNext()){
	//if(Lista.compareTo(j,k)){
	      
		//}
	    
		//}
	    //}
	//return ;
    }

    // Aqui va tu comentario
    public static void Interseccion(Lista<Integer> lista,Lista<Integer> lista2) {

	Iterator<Integer> iter1 = lista.iterator();
	Iterator<Integer> iter2 = lista2.iterator();
	//Iterator<Integer> iter3 = lista2.iterator();
	int i;
	Integer j = iter1.next();
	Integer k;
	//int l = 0;

	while(iter2.hasNext()){
	    k = iter2.next();
	    //System.out.println();
	    //System.out.println(k);	    
	    
	    if(! lista.contains(k)){

		//i = lista2.indexOf(k);
		//System.out.println(i);
		lista2.delete(k);
		//System.out.println(lista2.toString());
	    }
	    
	    
	}

	//lista.pop();
	
	//System.out.println();
	//System.out.println(lista2.toString());

	if(! lista.isEmpty()){
	    lista.empty();
	}

	//System.out.println();
	//System.out.println(lista.toString());

	Iterator<Integer> iter3 = lista2.iterator();
	
	while(iter3.hasNext()){
	    k = iter3.next();
	    lista.add(k);
 	}
	
	/*while(iter2.hasNext()){
	    k = iter2.next();
	    System.out.println();
	    System.out.println(k);	    
	    
	    if(lista.contains(k)){

		i = lista.indexOf(k);
		System.out.println(i);
		lista.delete(i);
		System.out.println(lista.toString());
	    }
	    
	    
	}*/

	/*if(lista.contains(3)){
	    
	    i = lista.indexOf(3);
	    System.out.println(i);
	    lista.delete(i+1);
	    System.out.println(lista.toString());
	    }*/

	/*lista.pop();
	
	System.out.println();
	System.out.println(lista.toString());*/

	/*while(iter1.hasNext()){
	    lista.delete(j);
	    j = iter1.next();
	    }*/

	/*if(! lista.isEmpty()){
	    lista.empty();
	}

	System.out.println();
	System.out.println(lista.toString());

	while(iter3.hasNext()){
	    k = iter3.next();
	    lista.add(k);
 	}*/
        //return ;
    }



    public static void main(String[] args) {
        Lista<Integer> primera = new Lista<Integer>();
        Lista<Integer> segunda = new Lista<Integer>();
        Lista<Integer> tercera = new Lista<Integer>();
        
	
        // Tests toString
        for (int i = 0; i <= 5; i++) {
	    primera.add(i);
	}

	//System.out.println(primera.toString());
        String test = "0 -> 1 -> 2 -> 3 -> 4 -> 5";
	if (!primera.toString().equals(test)) {
            System.out.println("1 El toString no funciona!");
        }
        primera = new Lista<Integer>();
	//System.out.println(primera.toString());
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
	//System.out.println();
	//System.out.println(primera.toString());
	//System.out.println(segunda.toString());
        primera.reverse();
	//System.out.println();
	//System.out.println(primera.toString());
	//System.out.println(segunda.toString());
	if (!primera.toString().equals(segunda.toString())) {
            System.out.println("1 El reverse no funciona!");    
        }
        primera = new Lista<Integer>();
        segunda = new Lista<Integer>();
	//System.out.println();
	//System.out.println(primera.toString());
	//System.out.println(segunda.toString());
	primera.reverse();
	//System.out.println();
	//System.out.println(primera.toString());
	//System.out.println(segunda.toString());
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
	//for (int i = 0; i <= 10; i++) {
	//  primera.add(i);
            //segunda.add(i);
        //}
	//for (int i = 1; i <= 10; i++) {
	//  tercera.add(i);
            //segunda.add(i);
	//}
	//for (int i = 10; i > 0; i--) {
	//  segunda.add(i);
            //segunda.add(i);
        //}
        //for (int i = 0; i <= 10; i++) {
	//segunda.add(i);
	//}
	//System.out.println();
	//System.out.println(primera.toString());
	//System.out.println(segunda.toString());
	primera.append(primera.clone());
	//primera.reverse();
	//System.out.println(tercera.toString());
	//primera.append(tercera);
	//System.out.println();
	//System.out.println(primera.toString());
	//System.out.println(segunda.toString());
        
        if (!primera.toString().equals(segunda.toString())) {
            System.out.println("1 El Append no funciona!");
        }

        // Tests IndexOf
	//primera = new Lista<Integer>();
	//primera.add(4);
	//primera.add(5);
	//primera.add(10);
	//primera.add(1);
	//primera.add(10);
	//primera.add(0);
	//System.out.println(primera.toString());
	//System.out.println();
	//System.out.println(primera.indexOf(0));
        if (primera.indexOf(0) != 0) {
            System.out.println("1 El IndexOf no funciona!");
        }
	//System.out.println();
	//System.out.println(primera.indexOf(1));
        if (primera.indexOf(1) != 1) {
            System.out.println("2 El IndexOf no funciona!");
        }
	//System.out.println();
	//System.out.println(primera.indexOf(10));
        if (primera.indexOf(10) != 10) {
            System.out.println("3 El IndexOf no funciona!");
        }

        // Tests Insert
        primera = new Lista<Integer>();
        segunda = new Lista<Integer>();
        for (int i = 0; i <= 10; i++) {
            primera.add(i);
            
	}
	//for (int i = 0; i <= 3; i++) {
	//primera.add(0);
	    
	//}
	for (int i = 0; i <= 4; i++) {
	  segunda.add(i);
	  
        }
        segunda.add(6);
        for (int i = 5; i <= 10; i++) {
	    segunda.add(i);
	    
	}
	
	//for (int i = 0; i <= 2; i++) {
	//segunda.add(6);
	//segunda.add(0);
	//segunda.add(1);
	//segunda.add(2);
	//segunda.add(3);
	//}
	//for (int i = 3; i <= 4; i++) {
	//segunda.add(i);
	//}
	//System.out.println();
	//System.out.println(primera.toString());
	//System.out.println(segunda.toString());
        primera.insert(5, 6);
	//System.out.println();
	//System.out.println(primera.toString());
	//System.out.println(segunda.toString());
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


	//for (int i = 0; i <= 10; i++) {
	//  if (i % 2 == 0) {
	//      primera.add(i);
	//  }   
        //}
	//for (int i = 0; i <= 11; i++) {
	//  if (i % 2 != 0) {
	//      segunda.add(i);
	//  }

        //}
        //for (int i = 0; i <= 17; i++) {
            
	//  tercera.add(i);
            
	//}
	//System.out.println();
	//System.out.println(primera.toString());
	//System.out.println(segunda.toString());
	//System.out.println(tercera.toString());
	primera.mezclaAlternada(segunda);
	//System.out.println();
	//System.out.println(primera.toString());
	//System.out.println(segunda.toString());
	//System.out.println(tercera.toString());
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

	//primera.add(-11);
	//primera.add(1);
	//primera.add(3);
	//primera.add(4);
	//primera.add(7);
	//primera.add(11);
	//primera.add(15);
	//primera.add(17);
        //segunda.add(8);
        //segunda.add(8);
	//segunda.add(9);
	//segunda.add(10);
	//segunda.add(11);
	//System.out.println();
        //System.out.println(primera.toString());
	//System.out.println(segunda.toString());
        tercera = AgregaOrdenado(primera,9);
	//tercera = AgregaOrdenado(primera,-20);
	//System.out.println();
	//System.out.println(tercera.toString());
	//System.out.println(segunda.toString());
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
	/*primera.add(1);
        primera.add(2);
	primera.add(2);
	primera.add(3);
        segunda.add(2);
	segunda.add(0);
	segunda.add(50);
	segunda.add(3);
	segunda.add(4);
	segunda.add(5);*/
	System.out.println();
        System.out.println(primera.toString());
	System.out.println(segunda.toString());
	Union(primera, segunda);
	System.out.println();
        System.out.println(primera.toString());
	System.out.println(segunda.toString());
	
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
	//primera.add(0);
	//primera.add(0);
	//primera.add(1);
        //primera.add(2);
        //primera.add(3);
	//primera.add(2);
	//segunda.add(4);
        //segunda.add(2);
	//segunda.add(3);
	//segunda.add(0);
	//System.out.println();
	//System.out.println(primera.toString());
	//System.out.println(segunda.toString());	
        Interseccion(primera, segunda);
	//System.out.println();
	//System.out.println(primera.toString());
	//System.out.println(segunda.toString());     

        if (!(primera.contains(2) && primera.size() == 1)) {
            System.out.println("1 La intersección no funciona!");
        }
        
        



    }   
   

    


}
