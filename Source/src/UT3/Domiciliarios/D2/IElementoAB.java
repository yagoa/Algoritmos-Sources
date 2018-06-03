package UT3.Domiciliarios.D2;
import java.util.LinkedList;

public interface IElementoAB<T> {

    /**
     * Obtiene el valor de la etiqueta del nodo.
     *
     * @return Etiqueta del nodo.
     */
    public Comparable getEtiqueta();

    /**
     * Obtiene el hijo izquierdo del nodo.
     *
     * @return Hijo Izquierdo del nodo.
     */
    public IElementoAB getHijoIzq();

    /**
     * Obtiene el hijo derecho del nodo.
     *
     * @return Hijo derecho del nodo.
     */
    public IElementoAB getHijoDer();

    /**
     * Asigna el hijo izquierdo del nodo.
     *
     * @return Elemento a ser asignado como hijo izquierdo.
     */
    public void setHijoIzq(IElementoAB elemento);

    /**
     * Asigna el hijo derecho del nodo.
     *
     * @return Elemento a ser asignado como hijo derecho.
     */
    public void setHijoDer(IElementoAB elemento);

    /**
     * Busca un elemento dentro del arbol con la etiqueta indicada.
     *
     * @param unaEtiqueta del nodo a buscar
     * @return Elemento encontrado. En caso de no encontrarlo, retorna nulo.
     */
    public IElementoAB buscar(Comparable unaEtiqueta);

 

    /**
     * Inserta un elemento dentro del arbol.
     *
     * @param elemento Elemento a insertar.
     * @return Exito de la operaci�n.
     */
    public boolean insertar(IElementoAB elemento);

  
    /**
     * Imprime en inorden el arbol separado por guiones.
     *
     * @return String conteniendo el InOrden
     */
    public String inOrden();

     /**
     * pone las etiquetas del recorrido en inorden en una linkedlist.
     *
     * @param unaLista
     */
    public void inOrden(LinkedList<Comparable> unaLista);

    /**
     * Retorna los datos contenidos en el elemento.
     *
     * @return
     */
        public T getDatos();
	
/**
	 * Retorna la altura del arbol cuya raiz es la del nodo actual.
	 * @return Altura del subarbol.
	 */
	public int obtenerAltura();
	
	/**
	 * Retorna el tama�o del arbol cuya raiz es la del nodo actual.
	 * @return Tama�o del subarbol.
	 */
	public int obtenerTamanio();
	
	/**
	 * Retorna el nivel del elemento cuya etiqueta es la pasada por par�metro.
	 * @param unaEtiqueta
	 * @return Nivel
	 */
	public int obtenerNivel(Comparable unaEtiqueta);
	
	/**
	 * Retorna la cantidad de hojas del arbol cuya raiz es la del nodo actual.
	 * @return Cantidad de hojas del subarbol.
	 */
	public int obtenerCantidadHojas();
        public IElementoAB eliminar(Comparable unaEtiqueta);

}
