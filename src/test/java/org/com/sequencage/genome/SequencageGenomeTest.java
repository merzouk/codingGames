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
 * Fichier 		:	SequencageGenomeTest.java
 * Créé le 		: 	11 févr. 2020 à 12:15:26
 * Auteur		: 	Merzouk
 * 
 * Description 	:
 * 
 *---------------------------------------------------------
 */

package org.com.sequencage.genome;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
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
 * @package : org.com.sequencage.genome
 * @date    : 11 févr. 2020 12:15:26
 */
@ExtendWith(SpringExtension.class)
@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
public class SequencageGenomeTest
{
   private static final Logger logger          = LoggerFactory.getLogger( SequencageGenomeTest.class );
   
   private static String[]     subSequenceList = null;
   
   private static String       expected        = null;
   
   @Autowired
   private SequencageGenome    sequencageGenome;
   /**
    * 
    * @param testInfo
    */
   @BeforeEach
   void initParamsTest( TestInfo testInfo )
   {
      logger.info( "initParamsTest" );
      switch( testInfo.getTestMethod().get().getName() )
      {
         case "sequencageGenome01Test":
            subSequenceList = new String[] { "AAC", "CCTT" };
            expected = "AACCTT";
            break;
         case "sequencageGenome02Test":
            subSequenceList = new String[] { "AGATTA", "GATTACA", "TACAGA" };
            expected = "AGATTACAGA";
            break;
         case "sequencageGenome03Test":
            subSequenceList = new String[] { "TT", "AA", "ACT" };
            expected = "AACTT";
            break;
         case "sequencageGenome04Test":
            subSequenceList = new String[] { "GAT", "AGATTA" };
            expected = "AGATTA";
            break;
         case "sequencageGenome05Test":
            subSequenceList = new String[] { "CCCTG", "TGACA", "CATGA" };
            expected = "CCCTGACATGA";
            break;
         case "sequencageGenome06Test":
            subSequenceList = new String[] { "AGATTA", "GATTACA", "TACAGA" };
            expected = "AGATTACAGA";
            break;
         case "sequencageGenome07Test":
            subSequenceList = new String[] { "TT", "AA", "ACT", "AACTT" };
            expected = "AACTT";
            break;
         case "sequencageGenome08Test":
            subSequenceList = new String[] { "CCCTG", "TGACA", "CATGA", "CCCTGACATGA" };
            expected = "CCCTGACATGA";
            break;
         default:
            logger.info( "default not test" );
            break;
      }
      assertNotNull( sequencageGenome );
      logger.info( " begin " + testInfo.getTestMethod().get().getName() );
   }
   
   /**
    * destroyed parameters after test
    * 
    * @param testInfo : content parameters current test 
    */
   @AfterEach
   void destroyParamsTest( TestInfo testInfo )
   {
      logger.info( "destroyParamsTest" );
      String callingTest = testInfo.getTestMethod().get().getName();
      logger.info( " end " + callingTest );
      subSequenceList = null;
      expected = null;
   }
   
   /**
    * 
    */
   @Test
   public void sequencageGenome01Test()
   {
      assertEquals( expected, sequencageGenome.optimalSequence( subSequenceList ) );
   }
   
   /**
    * 
    */
   @Test
   public void sequencageGenome02Test()
   {
      assertEquals( expected, sequencageGenome.optimalSequence( subSequenceList ) );
   }
   
   /**
    * 
    */
   @Test
   public void sequencageGenome03Test()
   {
      assertEquals( expected, sequencageGenome.optimalSequence( subSequenceList ) );
   }
   
   /**
    * 
    */
   @Test
   public void sequencageGenome04Test()
   {
      assertEquals( expected, sequencageGenome.optimalSequence( subSequenceList ) );
   }
   
   /**
    * 
    */
   @Test
   public void sequencageGenome05Test()
   {
      assertEquals( expected, sequencageGenome.optimalSequence( subSequenceList ) );
   }
   
   /**
    * 
    */
   @Test
   public void sequencageGenome06Test()
   {
      assertEquals( expected, sequencageGenome.optimalSequence( subSequenceList ) );
   }
   
   /**
    * 
    */
   @Test
   public void sequencageGenome07Test()
   {
      assertEquals( expected, sequencageGenome.optimalSequence( subSequenceList ) );
   }
   
   /**
    * 
    */
   @Test
   public void sequencageGenome08Test()
   {
      assertEquals( expected, sequencageGenome.optimalSequence( subSequenceList ) );
   }
}
