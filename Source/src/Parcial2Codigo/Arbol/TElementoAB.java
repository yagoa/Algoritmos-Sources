package Arbol;

/**
 * @author Programacion2
 * @param <T>
 *
 */
public class TElementoAB<T> implements IElementoAB<T> {

    private Comparable etiqueta;
    private IElementoAB hijoIzq;
    private IElementoAB hijoDer;
    private T datos;

    /**
     * @param unaEtiqueta
     * @param unosDatos
     */
    @SuppressWarnings("unchecked")
    public TElementoAB(Comparable unaEtiqueta, T unosDatos) {
        etiqueta = unaEtiqueta;
        datos = unosDatos;
    }

    public IElementoAB getHijoIzq() 
    {
        return hijoIzq;
    }

    public IElementoAB getHijoDer() 
    {
        return hijoDer;
    }

    /**
     * @param unElemento
     * @return
     */
    @SuppressWarnings("unchecked")
    public boolean insertar(IElementoAB unElemento) 
    {
        if (unElemento.getEtiqueta().compareTo(etiqueta) < 0) 
        {
            if (hijoIzq != null) 
            {
                return getHijoIzq().insertar(unElemento);
            }
            else 
            {
                hijoIzq = unElemento;
                return true;
            }
        } 
        else if (unElemento.getEtiqueta().compareTo(etiqueta) > 0) 
        {
            if (hijoDer != null) {
                return getHijoDer().insertar(unElemento);
            } else {
                hijoDer = unElemento;
                return true;
            }
        } 
        else {
            // ya existe un elemento con la misma etiqueta.-
            return false;
        }
    }

    /**
     * @param unaEtiqueta
     * @return
     */
    public IElementoAB buscar(Comparable unaEtiqueta) {

        if (unaEtiqueta.equals(etiqueta))
        {
            return this;
        }
        else if (unaEtiqueta.compareTo(etiqueta) < 0)
        {
            if (hijoIzq != null) 
            {
                return getHijoIzq().buscar(unaEtiqueta);
            } 
            else 
            {
                return null;
            }
        } 
        else if (hijoDer != null) 
        {
            return getHijoDer().buscar(unaEtiqueta);
        } 
        else 
        {
            return null;
        }
    }

    /**
     * @return recorrida en inorden del subArbol que cuelga del elemento actual
     */
    public String inOrden() 
    {
        StringBuilder tempStr = new StringBuilder();
        if (hijoIzq != null) 
        {
            tempStr.append(getHijoIzq().inOrden());
            tempStr.append(TArbolBB.SEPARADOR_ELEMENTOS_IMPRESOS);
        }
        
        tempStr.append(imprimir());
        
        if (hijoDer != null) 
        {
            tempStr.append(TArbolBB.SEPARADOR_ELEMENTOS_IMPRESOS);
            tempStr.append(getHijoDer().inOrden());
        }

        return tempStr.toString();
    }

    /**
     * @return recorrida en preOrden del subArbol que cuelga del elemento actual
     */
    public String preOrden() 
    {
        StringBuilder tempStr = new StringBuilder();
        tempStr.append(imprimir());
        
        if (hijoIzq != null) 
        {
            tempStr.append(TArbolBB.SEPARADOR_ELEMENTOS_IMPRESOS);
            tempStr.append(getHijoIzq().preOrden());
        }
        
        if (hijoDer != null) 
        {
            tempStr.append(TArbolBB.SEPARADOR_ELEMENTOS_IMPRESOS);
            tempStr.append(getHijoDer().preOrden());
        }
        return tempStr.toString();
    }

    /**
     * @return recorrida en postOrden del subArbol que cuelga del elemento
     * actual
     */
    public String postOrden() 
    {
        StringBuilder tempStr = new StringBuilder();
        if (hijoIzq != null)
        {
            tempStr.append(getHijoIzq().postOrden());
            tempStr.append(TArbolBB.SEPARADOR_ELEMENTOS_IMPRESOS);
        }
        if (hijoDer != null)
        {
            tempStr.append(getHijoDer().postOrden());
            tempStr.append(TArbolBB.SEPARADOR_ELEMENTOS_IMPRESOS);
        }
        
        tempStr.append(imprimir());
        return tempStr.toString();
    }

    @Override
    public Comparable getEtiqueta() {
        return etiqueta;
    }

    /**
     * @return
     */
    public String imprimir()
    {
        return (etiqueta.toString());
    }

    @Override
    public T getDatos() 
    {
        return datos;
    }

    @Override
    public void setHijoIzq(IElementoAB elemento) 
    {
        this.hijoIzq = elemento;
    }

    @Override
    public void setHijoDer(IElementoAB elemento) 
    {
        this.hijoDer = elemento;
    }

    @Override
    public IElementoAB eliminar(Comparable unaEtiqueta)
    {
        if (unaEtiqueta.compareTo(this.getEtiqueta()) < 0) 
        {
            if (this.hijoIzq != null) {
                this.hijoIzq = hijoIzq.eliminar(unaEtiqueta);
            }
            return this;
        }

        if (unaEtiqueta.compareTo(this.getEtiqueta()) > 0) 
        {
            if (this.hijoDer != null) {
                this.hijoDer = hijoDer.eliminar(unaEtiqueta);

            }
            return this;
        }

        return quitaElNodo();
    }

    private IElementoAB quitaElNodo() 
    {
        if (hijoIzq == null) {
            return hijoDer;
        }

        if (hijoDer == null) {
            return hijoIzq;
        }

        IElementoAB elHijo = hijoIzq;
        IElementoAB elPadre = this;

        while (elHijo.getHijoDer() != null) {
            elPadre = elHijo;
            elHijo = elHijo.getHijoDer();
        }

        if (elPadre != this) {
            elPadre.setHijoDer(elHijo.getHijoIzq());
            elHijo.setHijoIzq(hijoIzq);
        }

        elHijo.setHijoDer(hijoDer);
        return elHijo;
    }

    @Override
    public int cantNodosInternosCompletos() 
    {
        if ( this.esHoja() )
        {
            return 0;
        } 
        else 
        {
            if ( this.esCompleto() )
            {
                return 1 + this.getHijoIzq().cantNodosInternosCompletos() + this.getHijoDer().cantNodosInternosCompletos();
            } 
            else 
            {
                if ( this.getHijoIzq() != null )
                {
                    return this.getHijoIzq().cantNodosInternosCompletos();
                } 
                else
                {
                    return this.getHijoDer().cantNodosInternosCompletos();
                }
            }
        }
    }
    
    private Boolean esHoja()
    {
        return ((this.getHijoIzq() == null ) && (this.getHijoDer() == null));
    }
    
    private Boolean esCompleto()
    {
        return ((this.getHijoIzq() != null ) && (this.getHijoDer() != null));
    }
    
    public int cantidadDeHojas(IElementoAB elemento) {
        int resultado = 0;
        
        if (elemento.getHijoIzq() == null && elemento.getHijoDer() == null) 
            return 1;

        if(elemento.getHijoIzq() != null)
            resultado += elemento.cantidadDeHojas(elemento.getHijoIzq());
        
        if (elemento.getHijoDer() != null)
            resultado += elemento.cantidadDeHojas(elemento.getHijoDer());

        return resultado;
    }
    
    
    public int ObtenerNivel(Comparable clave) {
        int temp1 = 0;
        if (this.getEtiqueta().compareTo(clave) == 0) {
            return temp1;
        }
        if (this.getEtiqueta().compareTo(clave) >0) {
            if (this.getHijoIzq() != null) {
                temp1 = this.getHijoIzq().ObtenerNivel(clave);
                if (temp1 >= 0) {
                    return temp1 += 1;
                } else {
                    return temp1;
                }
            } else 
                return -1;
        }    

            if (this.getHijoDer() != null) {
                temp1 = this.getHijoDer().ObtenerNivel(clave);
                if (temp1 >= 0) {
                    return temp1 += 1;
                } else {
                    return temp1;
                }
            } else {
                return -1;
            }
        }
    
    public int obtenerTamaño() {
        int resultado = 0;
        if (this.getHijoIzq() == null && this.getHijoDer() == null) {
            return 1;
        } if (this.getHijoIzq() != null) {
                resultado += getHijoIzq().obtenerTamaño();
         }if(this.getHijoDer()!=null) {
                resultado += getHijoDer().obtenerTamaño();
         }
  
        return resultado +1 ;
    }
}
