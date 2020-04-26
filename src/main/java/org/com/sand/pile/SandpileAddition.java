
package org.com.sand.pile;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * <p>
 * A sandpile is a square matrix of natural numbers between 0 and 3, representing how many grains of sand there is on each square
 * To add two sandpiles, just start by adding the two matrices element by element. Except the matrix you generate might not be a sandpile, 
 * </p>
 * <p>
 * if one of its element is higher than 3 you must transform this matrix into a sandpile, and this is how it is done :
 * </p>
 * <p>
 * - If a square has 4 grains of sand or more, it "loses" four and distributes it to its four neighbors (if the square touches an edge, the grain of sand is lost)
 * </p>
 * <p>
 * - Keep doing that to all the squares with 4 grains or more until all the squares have 3 grains or less
 * </p>
 * 
 * Example :
 * 
 * <pre>
 * 000   000   000    010
 * 020 + 020 = 040 -> 101
 * 000   000   000    010
 * </pre>
 * 
 * @author : Merzouk
 * @project : codingGame
 * @package : org.com.test
 * @date : 7 févr. 2020 21:00:56
 */
@Service("sandpileAddition")
public class SandpileAddition
{
   private static final Logger logger = LoggerFactory.getLogger( SandpileAddition.class );
   /**
    * 
    * @param lmt
    * @param r1
    * @param r2
    */
   public int[][] sandPile( int lmt, String[] r1, String[] r2 )
   {
      logger.info( "sand Pile Addition" );
      int[][] a = new int[r1.length][r1.length];
      for( int i = 0; i < r1.length; i++ )
      {
         String s = r1[i];
         String t = r2[i];
         for( int j = 0; j < r1.length; j++ )
            a[i][j] = Integer.parseInt( s.substring( j, j + 1 ) ) + Integer.parseInt( t.substring( j, j + 1 ) );
      }
      return formaterResultatSortie( distribuerGrainsSurCase( a, lmt ) );
   }
   
   private int[][] formaterResultatSortie( int[][] a )
   {
      for( int i = 0; i < a.length; i++ )
      {
         for( int j = 0; j < a[i].length; j++ )
         {
            //System.out.print( a[i][j] );
         }
         //System.out.println();
      }
      return a;
   }
   
   private int[][] distribuerGrainsSurCase( int[][] a, int lmt )
   {
      CaseTrouvee caseTrouvee = null;
      while( ( caseTrouvee = chercherCase( a, lmt ) ) != null )
         distribuerSurLesCases( a, caseTrouvee, lmt );
      return a;
   }
   
   private void distribuerSurLesCases( int[][] a, CaseTrouvee c, int lmt )
   {
      int lgn = c.lgn;
      int col = c.col;
      int n = a.length;
      if( a[lgn][col] >= lmt )
      {
         a[lgn][col] -= lmt;
         if( lgn - 1 >= 0 && lgn - 1 < n ) a[lgn - 1][col] += 1;
         if( lgn + 1 < n ) a[lgn + 1][col] += 1;
         if( col - 1 >= 0 && col - 1 < n ) a[lgn][col - 1] += 1;
         if( col + 1 < n ) a[lgn][col + 1] += 1;
      }
   }
   
   private CaseTrouvee chercherCase( int[][] a, int lmt )
   {
      for( int i = 0; i < a.length; i++ )
      {
         for( int j = 0; j < a[i].length; j++ )
            if( a[i][j] >= lmt ) return new CaseTrouvee( i, j );
      }
      return null;
   }
   /**
    * 
    * compte les coordonnees du point dont la valeur est superieure a la limite
    * 
    * @author  : Merzouk
    * @project : codingGames
    * @package : org.com.sand.pile
    * @date : 7 févr. 2020 21:00:56
    */
   class CaseTrouvee
   {
      final int lgn;
      
      final int col;
      /**
       * 
       * @param lgn : indice de la ligne
       * @param col : indice de la colonne
       */
      public CaseTrouvee( int lgn, int col )
      {
         this.lgn = lgn;
         this.col = col;
      }
   }
}