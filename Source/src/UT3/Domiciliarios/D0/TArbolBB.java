package UT3.Domiciliarios.D0;
import java.util.LinkedList;

public class TArbolBB<T>{

    private TElementoAB<T> raiz;

    /**
     * Separador utilizado entre elemento y elemento al imprimir la lista
     */
    public static final String SEPARADOR_ELEMENTOS_IMPRESOS = "-";

    public TArbolBB() {
        raiz = null;
    }

    /**
     * @param unElemento
     * @return
     */
    public boolean insertar(TElementoAB<T> unElemento) {
        if (esVacio()) {
            raiz = unElemento;
            return true;
        } else {
            return raiz.insertar(unElemento);
        }
    }

    /**
     * @param unaEtiqueta
     * @return
     */
    @SuppressWarnings("unchecked")
    public TElementoAB<T> buscar(Comparable unaEtiqueta) {
        if (esVacio()) {
            return null;
        } else {
            return raiz.buscar(unaEtiqueta);
        }
    }

    /**
     * @return recorrida en inorden del arbol, null en caso de ser vacío
     */
    public String inOrden() {
        if (esVacio()) {
            return null;
        } else {
            return raiz.inOrden();
        }
    }

    /**
     * @return recorrida en preOrden del arbol, null en caso de ser vacío
     */
   
    /**
     * @return
     */
    public boolean esVacio() {
        return (raiz == null);
    }


    /**
     * @return True si habían elementos en el árbol, false en caso contrario
     */
    public boolean vaciar() {
        if (!esVacio()) {
            raiz = null;
            return true;
        }
        return false;
    }

    public LinkedList<Comparable> inorden() {
        LinkedList<Comparable> listaInorden = new LinkedList<>();
        if (!esVacio()){
         raiz.inOrden(listaInorden);
        }
        return listaInorden;
            
        
    }
    
     public void eliminar(Comparable unaEtiqueta) {
        if(this.raiz!=null){
            this.raiz=this.raiz.eliminar(unaEtiqueta);
        }else{
            System.out.print("El arbol esta vacio");
        }
    }

  
 
}
