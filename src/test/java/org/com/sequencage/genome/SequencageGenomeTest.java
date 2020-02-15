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

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.extension.ExtendWith;
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
   @Autowired
   private SequencageGenome sequencageGenome;
   /**
    * 
    */
   @Test
   public void sequencageGenome01Test()
   {
      String[] subSequenceList = { "AAC", "CCTT" };
      assertEquals( "AACCTT", sequencageGenome.optimalSequence( subSequenceList ) );
   }
   
   /**
    * 
    */
   @Test
   public void sequencageGenome02Test()
   {
      String[] subSequenceList = { "AGATTA", "GATTACA", "TACAGA" };
      assertEquals( "AGATTACAGA", sequencageGenome.optimalSequence( subSequenceList ) );
   }
   
   /**
    * 
    */
   @Test
   public void sequencageGenome03Test()
   {
      String[] subSequenceList = { "TT", "AA", "ACT" };
      assertEquals( "AACTT", sequencageGenome.optimalSequence( subSequenceList ) );
   }
   
   /**
    * 
    */
   @Test
   public void sequencageGenome04Test()
   {
      String[] subSequenceList = { "GAT", "AGATTA" };
      assertEquals( "AGATTA", sequencageGenome.optimalSequence( subSequenceList ) );
   }
   
   /**
    * 
    */
   @Test
   public void sequencageGenome05Test()
   {
      String[] subSequenceList = { "CCCTG", "TGACA", "CATGA" };
      assertEquals( "CCCTGACATGA", sequencageGenome.optimalSequence( subSequenceList ) );
   }
   
   /**
    * 
    */
   @Test
   public void sequencageGenome06Test()
   {
      String[] subSequenceList = { "AGATTA", "GATTACA", "TACAGA" };
      assertEquals( "AGATTACAGA", sequencageGenome.optimalSequence( subSequenceList ) );
   }
}
