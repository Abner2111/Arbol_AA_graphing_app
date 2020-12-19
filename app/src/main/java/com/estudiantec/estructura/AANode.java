package com.estudiantec.estructura;


class AANode
{
    public Comparable element;
    public AANode left;
    public AANode right;
    public  int level;

    /**
     * Constructor
     * @param theElement
     */
    AANode( Comparable theElement )
    {
        this( theElement, null, null );
    }

    /**
     * Constructor
     * @param theElement
     * @param lt
     * @param rt
     */
    AANode( Comparable theElement, AANode lt, AANode rt )
    {
        element  = theElement;
        left     = lt;
        right    = rt;
        level    = 1;
    }

    public Comparable getElement() {
        return element;
    }

    public AANode getLeft() {
        return left;
    }

    public AANode getRight() {
        return right;
    }

    public int getLevel() {
        return level;
    }
}