/*
 *--------------------------------------------------------
 * Administrateur
 *--------------------------------------------------------
 * Project     : Exercices-coding-games
 *
 * Copyright Administrateur,  All Rights Reserved.
 *
 *-------------------------------------------------------- 
 * 
 * Fichier 		:	Node.java
 * Créé le 		: 	10 févr. 2020 à 20:51:56
 * Auteur		: 	Merzouk
 * 
 * Description 	:
 * 
 *---------------------------------------------------------
 */

package org.com.nodes;

import java.io.Serializable;

/**
 * A Renseigner.
 * @author  : Merzouk
 * @project : Exercices-coding-games
 * @package : org.com.nodes
 * @date    : 10 févr. 2020 20:51:56
 */

public class Node implements Serializable
{
   /**
    * 
    */
   private static final long serialVersionUID = 7122425312652283587L;
   
   private int               value;
   
   private Node              left;
   
   private Node              right;
   /**
    * 
    * @param value
    */
   public Node( int value )
   {
      this.value = value;
   }
   
   /**
    * 
    * @param x
    * @param left
    * @param right
    */
   public Node( int x, Node left, Node right )
   {
      this.value = x;
      this.left = left;
      this.right = right;
   }
   
   public int getValeur()
   {
      return this.value;
   }
   
   public Node getSubNodeLeft()
   {
      return this.left;
   }
   
   public Node getSubNodeRight()
   {
      return this.right;
   }
   
   /**
    * 
    * @see java.lang.Object#toString()
    */
   public String toString()
   {
      return toString( "\t" );
   }
   
   /**
    * 
    * @param s
    * @return
    */
   public String toString( String s )
   {
      if( left != null )
      {
         if( right != null )
            return ( s + value + "\n" + left.toString( s + "\t" ) + right.toString( s + "\t" ) );
         else
            return ( s + value + "\n" + left.toString( s + "\t" ) + "\n" );
      }
      else if( right != null )
         return ( s + value + "\n\n" + right.toString( s + "\t" ) );
      else
         return ( s + value + "\n" );
   }
   
   /**
    * print prefixe tree
    */
   public void ParcoursPrefixe()
   {
      System.out.println( getValeur() );
      if( this.getSubNodeLeft() != null )
      {
         this.getSubNodeLeft().ParcoursPrefixe();
      }
      if( this.getSubNodeRight() != null )
      {
         this.getSubNodeRight().ParcoursPrefixe();
      }
   }
   
   /**
    *print infixe tree
    */
   public void ParcoursInfixe()
   {
      if( this.getSubNodeLeft() != null )
      {
         this.getSubNodeLeft().ParcoursInfixe();
      }
      System.out.println( getValeur() );
      if( this.getSubNodeRight() != null )
      {
         this.getSubNodeRight().ParcoursInfixe();
      }
   }
   
   /**
    * print postfixe tree
    */
   public void ParcoursPostfixe()
   {
      if( this.getSubNodeLeft() != null )
      {
         this.getSubNodeLeft().ParcoursPostfixe();
      }
      if( this.getSubNodeRight() != null )
      {
         this.getSubNodeRight().ParcoursPostfixe();
      }
      System.out.println( this.getValeur() );
   }
   
   /**
    * check if a is equals b
    * 
    * @param a tree
    * @param b tree
    * @return true if a is equals b et false otherwise
    */
   public static boolean nodesEquals( Node a, Node b )
   {
      if( ( a == null ) && ( b == null ) ) return true;
      if( ( a == null ) && ( b != null ) ) return false;
      if( ( a != null ) && ( b == null ) ) return false;
      // A ce point, a et b != null, on peut acceder a leurs champs
      if( a.getValeur() != b.getValeur() ) return false;
      return ( nodesEquals( a.getSubNodeLeft(), b.getSubNodeLeft() ) && nodesEquals( a.getSubNodeRight(), b.getSubNodeRight() ) );
   }
   
   @Override
   public int hashCode()
   {
      final int prime = 31;
      int result = 1;
      result = prime * result + ( ( left == null ) ? 0 : left.hashCode() );
      result = prime * result + ( ( right == null ) ? 0 : right.hashCode() );
      result = prime * result + value;
      return result;
   }
   
   @Override
   public boolean equals( Object obj )
   {
      if( this == obj ) return true;
      if( obj == null ) return false;
      if( getClass() != obj.getClass() ) return false;
      Node other = (Node) obj;
      if( left == null )
      {
         if( other.left != null ) return false;
      }
      else if( !left.equals( other.left ) ) return false;
      if( right == null )
      {
         if( other.right != null ) return false;
      }
      else if( !right.equals( other.right ) ) return false;
      if( value != other.value ) return false;
      return true;
   }
   
   /**
    * @param a Tree
    * 
    * @return heigh of tree a
    */
   public static int hauteur( Node a )
   {
      if( a == null )
      {
         return 0;
      }
      else
      {
         return ( 1 + Math.max( hauteur( a.getSubNodeLeft() ), hauteur( a.getSubNodeRight() ) ) );
      }
   }
   /**
    * Affiche l'arbre selon un parcours en largeur
    */
   //      public void ParcoursLargeur()
   //      {
   //         File file = new File();
   //         file.ajouter( this );
   //         Arbre a, b;
   //         while( !file.estVide() )
   //         {
   //            a = (Arbre) file.retirer();
   //            System.out.println( a.getValeur() );
   //            b = a.getSousArbreGauche();
   //            if( b != null ) file.ajouter( b );
   //            b = a.getSousArbreDroit();
   //            if( b != null ) file.ajouter( b );
   //         }
   //      }
   
   /**
    * @param a node
    * @return check if a is Tree
    */
   public static boolean isNode( Node a )
   {
      if( a == null )
      {
         return true;
      }
      if( a.getSubNodeLeft() != null && a.getSubNodeLeft().getValeur() > a.getValeur() )
      {
         return false;
      }
      if( a.getSubNodeRight() != null && a.getValeur() > a.getSubNodeRight().getValeur() )
      {
         return false;
      }
      return ( isNode( a.getSubNodeLeft() ) && isNode( a.getSubNodeRight() ) );
   }
   
   /**
    * @param value searched in tree
    * 
    * @return true if value founded in tree et false otherwise
    */
   public boolean searchNodeByValue( int value )
   {
      if( value == this.getValeur() )
      {
         return true;
      }
      if( value < this.getValeur() && this.getSubNodeLeft() != null )
      {
         return ( this.getSubNodeLeft().searchNodeByValue( value ) );
      }
      if( value > this.getValeur() && this.getSubNodeRight() != null )
      {
         return ( this.getSubNodeRight().searchNodeByValue( value ) );
      }
      return false;
   }
   
   /**
    * insert value in tree 
    * 
    * @param value to insert in tree
    */
   public void insertion( int value )
   {
      if( value == this.getValeur() ) return; // the value found in tree
      if( value < this.getValeur() )
      {
         if( this.getSubNodeLeft() != null )
            this.getSubNodeLeft().insertion( value );
         else
            this.left = new Node( value );
      }
      if( value > this.getValeur() )
      {
         if( this.getSubNodeRight() != null )
            this.getSubNodeRight().insertion( value );
         else
            this.right = new Node( value );
      }
   }
   
   public static void main( String[] arg )
   {
      Node b = new Node( 2, new Node( 1 ), new Node( 4, new Node( 3 ), new Node( 5 ) ) );
      Node c = new Node( 10, new Node( 8 ), new Node( 12 ) );
      Node a = new Node( 6, b, c );
      System.out.println( "L'arbre a est " + a );
      System.out.println( "Le parcours infixe de l'arbre a donne :" );
      a.ParcoursPrefixe();
      System.out.println( "Le parcours infixe de l'arbre a donne :" );
      a.ParcoursInfixe();
      System.out.println( "Le parcours postfixe de l'arbre a donne :" );
      a.ParcoursPostfixe();
      System.out.println( "Le parcours en largeur de l'arbre a donne :" );
      // a.ParcoursLargeur();
      System.out.println( "L'arbre a est-il egal a lui-meme? " + nodesEquals( a, a ) );
      System.out.println( "Les arbres a et b sont-ils egaux? " + nodesEquals( a, b ) );
      System.out.println( "La hauteur de l'arbre a est " + hauteur( a ) );
      System.out.println( "L'arbre a est-il un ABR? " + isNode( a ) );
      System.out.println( "7 est-il present dans a? " + a.searchNodeByValue( 7 ) );
      System.out.println( "12 est-il present dans a? " + a.searchNodeByValue( 12 ) );
      a.insertion( 7 );
      System.out.println( "Le resultat de l'ajout de 7 dans a " + a );
   }
}
