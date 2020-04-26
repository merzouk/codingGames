
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
    * @param limitSupCase
    * @param row1
    * @param row2
    */
   public int[][] sandPile( int limitSupCase, String[] row1, String[] row2 )
   {
      logger.info( "sand Pile Addition" );
      int[][] array = new int[row1.length][row1.length];
      for( int i = 0; i < row1.length; i++ )
      {
         String s = row1[i];
         String t = row2[i];
         for( int j = 0; j < row1.length; j++ )
            array[i][j] = Integer.parseInt( s.substring( j, j + 1 ) ) + Integer.parseInt( t.substring( j, j + 1 ) );
      }
      return formaterResultatSortie( distribuerGrainsSurCase( array, limitSupCase ), row1.length );
   }
   
   private int[][] formaterResultatSortie( int[][] array, int n )
   {
      for( int i = 0; i < array.length; i++ )
      {
         for( int j = 0; j < array[i].length; j++ )
         {
            //System.out.print( array[i][j] );
         }
         //System.out.println();
      }
      return array;
   }
   
   private int[][] distribuerGrainsSurCase( int[][] array, int limitSupCase )
   {
      CaseTrouvee caseTrouvee = null;
      while( ( caseTrouvee = chercherCase( array, limitSupCase ) ) != null )
         distribuerSurLesCases( array, array.length, caseTrouvee, limitSupCase );
      return array;
   }
   
   private void distribuerSurLesCases( int[][] array, int n, CaseTrouvee caseTrouvee, int limitSupCase )
   {
      int i = caseTrouvee.i;
      int j = caseTrouvee.j;
      array[i][j] -= limitSupCase;
      if( i - 1 >= 0 && i - 1 < n ) array[i - 1][j] += 1;
      if( i + 1 < n ) array[i + 1][j] += 1;
      if( j - 1 >= 0 && j - 1 < n ) array[i][j - 1] += 1;
      if( j + 1 < n ) array[i][j + 1] += 1;
   }
   
   private CaseTrouvee chercherCase( int[][] array, int limitSupCase )
   {
      for( int i = 0; i < array.length; i++ )
      {
         for( int j = 0; j < array[i].length; j++ )
            if( array[i][j] >= limitSupCase ) return new CaseTrouvee( i, j );
      }
      return null;
   }
   /**
    * 
    * A Renseigner.
    * @author  : Merzouk
    * @project : codingGames
    * @package : org.com.sand.pile
    * @date : 7 févr. 2020 21:00:56
    */
   class CaseTrouvee
   {
      final int i;
      
      final int j;
      public CaseTrouvee( int i, int j )
      {
         this.i = i;
         this.j = j;
      }
   }
}