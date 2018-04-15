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
public class List <E> implements IList<E>  {
    
    private INode<E> primero;

    public List() 
    {
        primero = null;
    }

    public List(INode<E> unNodo) 
    {
        this.primero = unNodo;
    }

    @Override
    public void insert(INode<E> unNodo) 
    {
        if (isEmpty())
        {
            primero = unNodo;
        } 
        else 
        {
            INode<E> aux = primero;
            while (aux.getNext()!= null) 
            {
                aux = aux.getNext();
            }
            aux.setNext(unNodo);
        }
    }

    @Override
    public INode<E> search(Comparable key) 
    {
        INode<E> result = null;      
        if (!isEmpty()) 
        {
            INode<E> aux = primero;
            while (aux != null)
            {
                if (aux.getTag().equals(key)) 
                {
                    return aux;
                }
                aux = aux.getNext();
            }
        }     
        return result;
    }

    @Override
    public boolean remove(Comparable key) 
    {
        if (isEmpty())  return false;
        
        if (primero.getNext() == null) 
        {
            if (primero.getTag().equals(key)) 
            {
                primero = null;
                return true;
            }
        }
        INode<E> aux = primero;
        if (aux.getTag().compareTo(key) == 0) 
        {
            //Eliminamos el primer elemento
            INode<E> temp1 = aux;
            INode<E> temp = aux.getNext();
            primero = temp;
            return true;
        }
        while (aux.getNext()!= null) 
        {
            if (aux.getNext().getTag().equals(key)) 
            {
                INode<E> temp = aux.getNext();
                aux.setNext(temp.getNext());
                return true;
            }
            aux = aux.getNext();
        }
        return false;
    }

    @Override
    public String print() 
    {
        String aux = "";
        if (!isEmpty()) 
        {
            INode<E> temp = primero;
            
            while (temp != null) 
            {
                temp.printTag();
                temp = temp.getNext();
            }
        }
        return aux;
    }

    @Override
    public String print(String separador) 
    {
        String aux = "";
        if (!isEmpty()) 
        {
            INode<E> temp = primero;
            aux = temp.getData().toString();
            while (temp.getNext()!= null) 
            {
                aux = aux + separador + temp.getNext().getData().toString();
                temp = temp.getNext();
            }
        }     
        return aux;
    }

    @Override
    public int count() 
    {
        int count = 0;
        if (!isEmpty()) 
        {
            INode aux = primero;
            while (aux != null) 
            {
                count++;
                aux = aux.getNext();
            }
        } 
        
        return count;
    }

    @Override
    public boolean isEmpty() 
    {
        return primero == null;
    }

    @Override
    public INode<E> getFirst() 
    {
        return primero;
    }
    
    @Override
    public void append(IList<E> listToAppend)
    {
        INode<E> node = this.getFirst();
        if (node != null)
        {
            while (node.getNext()!= null)
            {
                node = node.getNext();
            }           
            node.setNext(listToAppend.getFirst());      
        } 
        else 
        {
            this.primero = listToAppend.getFirst();
        }        
    }
}
