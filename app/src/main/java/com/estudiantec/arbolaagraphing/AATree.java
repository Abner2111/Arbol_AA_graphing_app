package com.estudiantec.arbolaagraphing;

import com.estudiantec.arbolaagraphing.AANode;

import java.util.LinkedList;

public class AATree
{
    private static AANode deletedNode;
    private static AANode lastNode;
    private AANode root;
    private int elements;

    public AATree( )
    {
        root = nullNode;
    }

    /**
     * Inserta un elemento al arbol
     * @param x es el valor del nodo
     */
    public void insert( Comparable x )
    {
        root = insert( x, root );
    }

    /**
     * Elimina un elemento del arbol
     * @param x es el valor del nodo
     */
    public void remove( Comparable x )
    {
        deletedNode = nullNode;
        root = remove( x, root );
    }

    /**
     * Busca un elemento en el arbol. Si este existe, lo retorna
     * @param x es el valor del nodo a buscar
     * @return
     */
    public Comparable find( Comparable x )
    {
        AANode current = root;
        nullNode.element = x;

        for( ; ; )
        {
            if( x.compareTo( current.element ) < 0 )
                current = current.left;
            else if( x.compareTo( current.element ) > 0 )
                current = current.right;
            else if( current != nullNode )
                return current.element;
            else
                return null;
        }
    }

    /**
     * Empties the tree
     */
    public void makeEmpty( )
    {
        root = nullNode;
    }

    /**
     * Revisa si el arbol está vacío
     * @return true si el arbol está vacío, false si no
     */
    public boolean isEmpty( )
    {
        return root == nullNode;
    }

    /**
     * Print the tree contents in sorted order.
     */
    public void printTree( )
    {
        if( isEmpty( ) )
            System.out.println( "Empty tree" );
        else
            printTree( root );
    }

    /**
     * Internal method to insert into a subtree.
     * @param x the item to insert.
     * @param t the node that roots the tree.
     * @return the new root.
     */
    private AANode insert( Comparable x, AANode t )
    {
        if( t == nullNode ){
            t = new AANode( x, nullNode, nullNode );
            this.elements+=1;}
        else if( x.compareTo( t.element ) < 0 ){
            t.left = insert( x, t.left );
            this.elements+=1;}
        else if( x.compareTo( t.element ) > 0 ){
            t.right = insert( x, t.right );
            this.elements+=1;
        }
        else
            return t;

        t = skew( t );
        t = split( t );
        return t;
    }

    /**
     * Internal method to remove from a subtree.
     * @param x the item to remove.
     * @param t the node that roots the tree.
     * @return the new root.
     */
    private AANode remove( Comparable x, AANode t )
    {
        if( t != nullNode )
        {
            //busca el elemento hasta llegar a él
            lastNode = t;
            if( x.compareTo( t.element ) < 0 )
                t.left = remove( x, t.left );
            else
            {
                deletedNode = t;
                t.right = remove( x, t.right );
            }

            // Step 2: Al llegar al elemento, lo elimina (si existe)
            //
            if( t == lastNode )
            {
                if( deletedNode == nullNode || x.compareTo( deletedNode.element ) != 0 )
                    return t;   // Item not found; do nothing
                deletedNode.element = t.element;
                this.elements-=1;
                t = t.right;
            }

            // //Rebalanceo
            else
            if( t.left.level < t.level - 1 || t.right.level < t.level - 1 )
            {
                if( t.right.level > --t.level )
                    t.right.level = t.level;
                t = skew( t );
                t.right = skew( t.right );
                t.right.right = skew( t.right.right );
                t = split( t );
                t.right = split( t.right );
            }
        }
        return t;
    }

    /**
     * Internal method to print a subtree in sorted order.
     * @param t the node that roots the tree.
     */
    private void printTree( AANode t )
    {
        if( t != t.left )
        {
            printTree( t.left );
            System.out.println( t.element.toString( ) );
            printTree( t.right );
        }
    }

    /**
     * Skew primitive for AA-trees.
     * @param t the node that roots the tree.
     * @return the new root after the rotation.
     */
    private AANode skew( AANode t )
    {
        if( t.left.level == t.level )
            t = rotateWithLeftChild( t );
        return t;
    }

    /**
     * Split primitive for AA-trees.
     * @param t the node that roots the tree.
     * @return the new root after the rotation.
     */
    private AANode split( AANode t )
    {
        if( t.right.right.level == t.level )
        {
            t = rotateWithRightChild( t );
            t.level++;
        }
        return t;
    }

    /**
     * Rotate binary tree node with left child.
     */
    static AANode rotateWithLeftChild( AANode k2 )
    {
        AANode k1 = k2.left;
        k2.left = k1.right;
        k1.right = k2;
        return k1;
    }

    /**
     * Rotate binary tree node with right child.
     */
    static AANode rotateWithRightChild( AANode k1 )
    {
        AANode k2 = k1.right;
        k1.right = k2.left;
        k2.left = k1;
        return k2;
    }


    private static AANode nullNode;
    static         // static initializer for nullNode
    {
        nullNode = new AANode( null );
        nullNode.left = nullNode.right = nullNode;
        nullNode.level = 0;
    }



    public String getTreeCode() {
        int range = 1;
        int c = 0;
        LinkedList<AANode> lista = new LinkedList<>();
        lista.add(this.root);
        String codigo = String.valueOf(this.root.element);
        String subcodigo;
        int top = 1;

        while (top < this.elements) {
            codigo += "/";
            subcodigo = "";
            for (int i = c; i < range + c; i++) {

                if (lista.get(i) != null) {

                    if (lista.get(i).getLeft() != null) {
                        lista.add(lista.get(i).getLeft());
                        subcodigo += ",";
                        subcodigo += String.valueOf(lista.get(i).getLeft().element);
                        top += 1;
                    } else {
                        lista.add(null);
                        subcodigo += ",";
                        subcodigo += "null";
                    }


                    if (lista.get(i).getRight() != null) {
                        lista.add(lista.get(i).getRight());
                        subcodigo += ",";
                        subcodigo += String.valueOf(lista.get(i).getRight().element);
                        top += 1;
                    } else {
                        lista.add(null);
                        subcodigo += ",";
                        subcodigo += "null";

                    }
                } else {
                    lista.add(null);
                    subcodigo += ",";
                    subcodigo += "null";


                    lista.add(null);
                    subcodigo += ",";
                    subcodigo += "null";


                }
            }

            c = range + c;
            range = range * 2;

            codigo += subcodigo.substring(1);
        }
        return codigo;
    }

}