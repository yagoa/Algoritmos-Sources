/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TDAList;

/**
 *
 * @author yago
 */
public interface IList<E> {
     /**
     * Método encargado de agregar un nodo al final de la lista.
     *
     * @param node - Nodo a agregar
     */
    public void insert(INode<E> node);

    /**
     * Método encargado de buscar un nodo cuya clave es la indicada.
     *
     * @param key - Clave del nodo a buscar.
     * @return El nodo encontrado. En caso de no encontrarlo, retornar null.
     */
    public INode search(Comparable key);

    /**
     * Método encargado de eliminar un nodo cuya clave es la indicada.
     *
     * @param key Clave del nodo a eliminar.
     * @return True en caso de que la eliminaci�n haya sido efectuada con �xito.
     */
    public boolean remove(Comparable key);

    /**
     * Método encargado de imprimir en consola las claves de los nodos
     * contenidos en la lista.
     */
    public String print();

    /**
     * Retorna un String con las claves separadas por el separador pasado por
     * parámetro.
     *
     * @param separator Separa las claves
     * @return
     */
    public String print(String separator);

    /**
     * Retorna la cantidad de elementos de la lista. En caso de que la lista
     * este vacía, retornar 0.
     *
     * @return Cantidad de elementos de la lista.
     */
    public int count();

    /**
     * Indica si la lista contiene o no elementos.
     *
     * @return Si tiene elementos o no.
     */
    public boolean isEmpty();

    /**
     * Retorna el primer nodo de la lista.
     *
     * @return Primer nodo de la lista.
     */
    public INode<E> getFirst();
    
    /**
     * Une dos IListas en una. 
     * @param listToAppend
     */
    public void append(IList<E> listToAppend);
}
