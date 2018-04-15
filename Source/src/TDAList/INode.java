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
public interface INode<E> {
        /**
     * Retorna el dato contenido en el nodo.
     *
     * @return data contenido en el nodo.
     */
    public E getData();

    /**
     * Asigna un dato al nodo.
     *
     * @param data a asignar.
     */
    public void setData(E data);

    /**
     * Asigna el siguiente nodo al nodo actual.
     *
     * @param nodo Nodo a asignar como siguiente.
     */
    public void setNext(INode<E> nodo);

    /**
     * Retorna el siguiente nodo al nodo actual.
     *
     * @return Siguiente nodo del actual
     */
    public INode<E> getNext();

    /**
     * Imprime los datos del nodo
     */
    public void print();

    /**
     * Imprime la etiqueta del nodo
     */
    public void printTag();

    /**
     *
     * @param node
     * @return si son iguales, por la clave
     */
    public boolean equals(INode<E> node);

    /**
     * Retorna la etiqueta del nodo
     *
     * @return etiqueta del nodo
     */
    public Comparable getTag();

    /**
     * Compara las etiquetas de dos INode
     * @param tag
     * @return devueve -1 si this tiene una etiqueta menor, 0 si son iguales, 1
     * si es mayor
     */
    public int compareTo(Comparable tag);
}
