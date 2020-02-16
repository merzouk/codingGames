
package org.com.sand.pile;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

/**
 * 
 * @author  : Merzouk
 * @project : Exercices-coding-games
 * @package : org.com.sand.pile
 * @date    : 8 févr. 2020 16:29:48
 */
@ExtendWith(SpringExtension.class)
@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
public class SandpileAdditionTest
{
   private static final Logger logger       = LoggerFactory.getLogger( SandpileAdditionTest.class );
   
   @Autowired
   private SandpileAddition    sandpileAddition;
   
   private static final int    limitSupCase = 4;
   
   private String[]            array1       = null;
   
   private String[]            array2       = null;
   
   private int[][]             expected     = null;
   
   private int                 matrixSize   = 0;
   /**
    * initialized parameters before test
    * 
    * 
    * @param testInfo : content parameters current test
    */
   @BeforeEach
   void initParams( TestInfo testInfo )
   {
      logger.info( "initParams" );
      switch( testInfo.getTestMethod().get().getName() )
      {
         case "sandpileAddition10Test":
            array1 = new String[] { "1221", "1321", "2111","3123" };
            array2 = new String[] { "1313", "1302", "1231","3210" };
            expected = new int[][] { { 2, 3, 0, 3 }, { 0, 3, 3, 3 }, { 2, 1, 0 , 3}, {2, 2, 1, 2} };
            matrixSize = 4;
            break;
         case "sandpileAddition09Test":
            array1 = new String[] { "000", "030", "000" };
            array2 = new String[] { "000", "030", "000" };
            expected = new int[][] { { 0, 1, 0 }, { 1, 2, 1 }, { 0, 1, 0 } };
            matrixSize = 3;
            break;
         case "sandpileAddition08Test":
            array1 = new String[] { "000", "020", "000" };
            array2 = new String[] { "000", "020", "000" };
            expected = new int[][] { { 0, 1, 0 }, { 1, 0, 1 }, { 0, 1, 0 } };
            matrixSize = 3;
            break;
         case "sandpileAddition07Test":
            array1 = new String[] { "12123212", "21221323", "13231321", "30232213", "01123100", "32203321", "32303321", "32123321" };
            array2 = new String[] { "30321311", "20231002", "12303321", "31231321", "12312323", "13123121", "13132121", "32303321" };
            expected = new int[][] { { 2, 0, 1, 3, 3, 3, 1, 2 }, { 1, 3, 3, 3, 2, 1, 3, 0 }, { 3, 2, 3, 3, 1, 0, 2, 1 }, { 3, 3, 2, 1, 1, 3, 3, 3 }, { 0, 1, 2, 3, 2, 1, 2, 1 }, { 3, 2, 3, 1, 3, 2, 0, 3 }, { 1, 3, 1, 3, 2, 3, 3, 3 }, { 2, 1, 3, 2, 3, 1, 3, 3 } };
            matrixSize = 8;
            break;
         case "sandpileAddition06Test":
            array1 = new String[] { "31003", "13120", "01310", "02131", "30013" };
            array2 = new String[] { "11111", "12221", "12321", "12221", "11111" };
            expected = new int[][] { { 2, 2, 1, 1, 2 }, { 2, 3, 3, 2, 1 }, { 1, 3, 2, 3, 1 }, { 1, 2, 3, 3, 2 }, { 2, 1, 1, 2, 2 } };
            matrixSize = 5;
            break;
         case "sandpileAddition05Test":
            array1 = new String[] { "1212321", "1221323", "1231321", "3032213", "0123100", "3203321", "3203321" };
            array2 = new String[] { "3032131", "0231002", "2303321", "1231321", "1232323", "1323121", "1332121" };
            expected = new int[][] { { 1, 1, 1, 2, 2, 0, 1 }, { 3, 1, 3, 2, 2, 1, 3 }, { 3, 2, 3, 1, 2, 2, 3 }, { 0, 2, 3, 3, 2, 2, 0 }, { 2, 2, 1, 3, 3, 3, 2 }, { 3, 0, 3, 3, 3, 0, 3 }, { 3, 1, 2, 0, 2, 2, 3 } };
            matrixSize = 7;
            break;
         case "sandpileAddition04Test":
            array1 = new String[] { "121", "202", "121" };
            array2 = new String[] { "020", "202", "020" };
            expected = new int[][] { { 3, 1, 3 }, { 1, 0, 1 }, { 3, 1, 3 } };
            matrixSize = 3;
            break;
         case "sandpileAddition03Test":
            array1 = new String[] { "121321", "122323", "123121", "303213", "023100", "303321" };
            array2 = new String[] { "303213", "023100", "303321", "121321", "122323", "123121" };
            expected = new int[][] { { 0, 3, 2, 3, 3, 0 }, { 2, 1, 3, 1, 3, 2 }, { 1, 3, 3, 1, 3, 3 }, { 1, 3, 2, 2, 3, 0 }, { 2, 3, 0, 2, 3, 2 }, { 1, 0, 2, 3, 3, 2 } };
            matrixSize = 6;
            break;
         case "sandpileAddition02Test":
            array1 = new String[] { "000", "020", "000" };
            array2 = new String[] { "000", "020", "000" };
            expected = new int[][] { { 0, 1, 0 }, { 1, 0, 1 }, { 0, 1, 0 } };
            matrixSize = 3;
            break;
         case "sandpileAddition01Test":
            array1 = new String[] { "121", "232", "121" };
            array2 = new String[] { "303", "000", "303" };
            expected = new int[][] { { 2, 1, 2 }, { 1, 3, 1 }, { 2, 1, 2 } };
            matrixSize = 3;
            break;
         case "sandpileAddition00Test":
            array1 = new String[] { "121", "232", "121" };
            array2 = new String[] { "303", "000", "303" };
            expected = new int[][] { { 1, 1, 2 }, { 0, 3, 1 }, { 2, 0, 2 } };
            matrixSize = 3;
            break;
         default:
            break;
      }
      assertNotNull( sandpileAddition );
      logger.info( " begin " + testInfo.getTestMethod().get().getName() );
   }
   
   /**
    * destroyed parameters after test
    * 
    * @param testInfo : content parameters current test 
    */
   @AfterEach
   void destroy( TestInfo testInfo )
   {
      logger.info( "destroy" );
      String callingTest = testInfo.getTestMethod().get().getName();
      logger.info( " end " + callingTest );
      array1 = null;
      array2 = null;
      expected = null;
      matrixSize = 0;
   }
   
   @Test
   public void sandpileAddition10Test() throws Exception
   {
      logger.info( "sandpileAddition10Test" );
      assertEquals( true, compareMatrices( matrixSize, sandpileAddition.sandPile( matrixSize, limitSupCase, array1, array2 ), expected ) );
   }
   
   @Test
   public void sandpileAddition09Test() throws Exception
   {
      logger.info( "sandpileAddition09Test" );
      assertEquals( true, compareMatrices( matrixSize, sandpileAddition.sandPile( matrixSize, limitSupCase, array1, array2 ), expected ) );
   }
   
   @Test
   public void sandpileAddition08Test() throws Exception
   {
      logger.info( "sandpileAddition08Test" );
      assertEquals( true, compareMatrices( matrixSize, sandpileAddition.sandPile( matrixSize, limitSupCase, array1, array2 ), expected ) );
   }
   
   @Test
   public void sandpileAddition07Test() throws Exception
   {
      logger.info( "sandpileAddition07Test" );
      assertEquals( true, compareMatrices( matrixSize, sandpileAddition.sandPile( matrixSize, limitSupCase, array1, array2 ), expected ) );
   }
   
   @Test
   public void sandpileAddition06Test() throws Exception
   {
      logger.info( "sandpileAddition06Test" );
      assertEquals( true, compareMatrices( matrixSize, sandpileAddition.sandPile( matrixSize, limitSupCase, array1, array2 ), expected ) );
   }
   
   @Test
   public void sandpileAddition05Test() throws Exception
   {
      logger.info( "sandpileAddition05Test" );
      assertEquals( true, compareMatrices( matrixSize, sandpileAddition.sandPile( matrixSize, limitSupCase, array1, array2 ), expected ) );
   }
   
   @Test
   public void sandpileAddition04Test() throws Exception
   {
      logger.info( "sandpileAddition04Test" );
      assertEquals( true, compareMatrices( matrixSize, sandpileAddition.sandPile( matrixSize, limitSupCase, array1, array2 ), expected ) );
   }
   
   @Test
   public void sandpileAddition03Test() throws Exception
   {
      logger.info( "sandpileAddition03Test" );
      assertEquals( true, compareMatrices( matrixSize, sandpileAddition.sandPile( matrixSize, limitSupCase, array1, array2 ), expected ) );
   }
   
   @Test
   public void sandpileAddition02Test() throws Exception
   {
      logger.info( "sandpileAddition02Test" );
      assertEquals( true, compareMatrices( matrixSize, sandpileAddition.sandPile( matrixSize, limitSupCase, array1, array2 ), expected ) );
   }
   
   @Test
   public void sandpileAddition01Test() throws Exception
   {
      logger.info( "sandpileAddition01Test" );
      assertEquals( true, compareMatrices( matrixSize, sandpileAddition.sandPile( matrixSize, limitSupCase, array1, array2 ), expected ) );
   }
   
   @Test
   public void sandpileAddition00Test() throws Exception
   {
      logger.info( "sandpileAddition01Test" );
      assertEquals( false, compareMatrices( matrixSize, sandpileAddition.sandPile( matrixSize, limitSupCase, array1, array2 ), expected ) );
   }
   
   /**
    * compare two matrix contents
    * 
    * @param n ; matrix dimension 
    * @param array : first matrix
    * @param expected : second matrix
    * 
    * @return return true if array is equals expected and false otherwise
    */
   private boolean compareMatrices( int n, int[][] array, int[][] expected )
   {
      assertNotNull( array );
      assertEquals( n, array.length );
      assertEquals( n, array[0].length );
      assertNotNull( expected );
      assertEquals( n, expected.length );
      assertEquals( n, expected[0].length );
      for( int i = 0; i < n; i++ )
      {
         for( int j = 0; j < n; j++ )
         {
            if( array[i][j] != expected[i][j] )
            {
               return false;
            }
         }
      }
      return true;
   }
}
