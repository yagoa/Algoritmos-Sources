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
public class Node<T> implements INode<T>
{
    private final Comparable tag;
    private T data;
    private INode<T> next = null;

    public Node(T data, Comparable etiqueta) 
    {
        this.data = data;
        this.tag = etiqueta;
    }

    public T getData() 
    {
        return this.data;
    }

    public void setData(T data) 
    {
        this.data = data;
    }

    public Comparable getTag() 
    {
        return this.tag;
    }

    public void setNext(INode<T> node) 
    {
        this.next = node;
    }

    public INode<T> getNext()
    {
        return this.next;
    }

    public void print() 
    {
        System.out.println(data.toString());
    }

    @Override
    public void printTag() 
    {
        System.out.println(this.tag);
    }

    public INode<T> clone() 
    {
        return new Node<T>(this.data, this.tag);
    }

    @Override
    public boolean equals(INode<T> unNodo) 
    {
        return this.data.equals(unNodo.getData());
    }

    @Override
    public int compareTo(Comparable etiqueta) 
    {
        return this.tag.compareTo(etiqueta);
    }
}
