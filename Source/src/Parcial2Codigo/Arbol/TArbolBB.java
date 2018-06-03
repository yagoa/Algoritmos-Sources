package Arbol;

/**
 * @author Programacion2
 * @param <T>
 *
 */
public class TArbolBB<T> implements IArbolBB<T> {

    private IElementoAB<T> raiz;
    private int altura;

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
    public boolean insertar(IElementoAB<T> unElemento) {
        if (esVacio()) 
        {
            raiz = unElemento;
            return true;
        } 
        else 
        {
            return raiz.insertar(unElemento);
        }
    }

    /**
     * @param unaEtiqueta
     * @return
     */
    @SuppressWarnings("unchecked")
    public IElementoAB<T> buscar(Comparable unaEtiqueta) {
        if (esVacio()) 
        {
            return null;
        } 
        else 
        {
            return raiz.buscar(unaEtiqueta);
        }
    }

    /**
     * @return recorrida en inorden del arbol, null en caso de ser vacío
     */
    public String inOrden() 
    {
        if (esVacio()) 
        {
            return null;
        } 
        else 
        {
            return raiz.inOrden();
        }
    }

    /**
     * @return recorrida en preOrden del arbol, null en caso de ser vacío
     */
    public String preOrden() 
    {
        if (esVacio()) 
        {
            return null;
        } 
        else 
        {
            return raiz.preOrden();
        }
    }

    /**
     * @return recorrida en postOrden del arbol, null en caso de ser vacío
     */
    public String postOrden()
    {
        if (esVacio()) 
        {
            return null;
        } 
        else 
        {
            return raiz.postOrden();
        }
    }

    public void eliminar(Comparable unaEtiqueta) {
        if (!esVacio()) 
        {
            this.raiz = this.raiz.eliminar(unaEtiqueta);
        }
    }

    /**
     * @return
     */
    public boolean esVacio()
    {
        return (raiz == null);
    }
    
    public boolean vaciar() {
        if (!esVacio()) 
        {
            raiz = null;
            return true;
        }
        return false;
    }
    
    @Override
    public int cantNodosInternosCompletos(){
        IElementoAB nodoActual = this.raiz;
        
        if (nodoActual == null){
            return 0;
        } else {
            return nodoActual.cantNodosInternosCompletos();
        }
    }
    
     public int cantdadHojas()
      {
        int resultado = 0;
        
        if(this.raiz==null)
            return resultado;
        
        resultado = this.raiz.cantidadDeHojas(raiz);
       
        return resultado;
    }
     
    @Override
    public int altura() throws Exception 
    {
        if (raiz == null){
            throw new Exception("El arbol no tiene altura");
        }
        altura = 0;
        retornarAltura(raiz, 0);
        return altura;
    }
      
    private void retornarAltura(IElementoAB<T> reco, int nivel) 
    {
      if (reco != null) {
          retornarAltura(reco.getHijoIzq(), nivel + 1);
          if (nivel > altura) {
              altura = nivel;
          }
          retornarAltura(reco.getHijoDer(), nivel + 1);
        }
    }
    
    public int obtenerNivel(Comparable clave){
        if(raiz.getEtiqueta().compareTo(clave)==0){
            return 0;
        }
        if(raiz.getEtiqueta().compareTo(clave)<0){
            if(raiz.getHijoDer()!=null){
               int resultadoDer= raiz.getHijoDer().ObtenerNivel(clave);
               if(resultadoDer!=-1){
                return resultadoDer+1;
            }
        }}else{
              if(raiz.getHijoIzq()!=null){
               int resultadoIzq= raiz.getHijoIzq().ObtenerNivel(clave);
               if(resultadoIzq!=-1){
                return resultadoIzq+1;  
                }
            }
        }
            return -1;  
    }
    
    public int obtenerTamaño(){
        int resultado=0;
        if(this.raiz==null){
            return resultado;
        }
            if( this.raiz.getHijoIzq()==null && this.raiz.getHijoDer()==null){
                return 1;
            }if (this.raiz.getHijoIzq()!=null){
                resultado+= this.raiz.getHijoIzq().obtenerTamaño();
            }if( this.raiz.getHijoDer()!=null){
                resultado+= this.raiz.getHijoDer().obtenerTamaño();
            }
        
        return resultado+1;
    }
}
