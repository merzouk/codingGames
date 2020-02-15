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
 * Fichier 		:	BracketsMatchingTest.java
 * Créé le 		: 	10 févr. 2020 à 16:20:02
 * Auteur		: 	Merzouk
 * 
 * Description 	:
 * 
 *---------------------------------------------------------
 */

package org.com.brackets.matching;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

/**
 * 
 * 
 * 
 * @author  : Merzouk
 * @project : Exercices-coding-games
 * @package : org.com.brackets.matching
 * @date    : 10 févr. 2020 16:20:02
 */
@ExtendWith(SpringExtension.class)
@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
public class BracketsMatchingTest
{
   @Autowired
   private BracketsMatching bracketsMatching;
   /**
    * 
    */
   @Test
   public void bracketsMatchingTest()
   {
      assertEquals( true, bracketsMatching.checkBracketsMatching( "(){}" ) );
      /**
       * 
       */
      assertEquals( true, bracketsMatching.checkBracketsMatching( "(){}{}[]" ) );
      /**
       * 
       */
      assertEquals( true, bracketsMatching.checkBracketsMatching( "({})" ) );
      /**
       * 
       */
      assertEquals( true, bracketsMatching.checkBracketsMatching( "({})" ) );
      /**
       * 
       */
      assertEquals( true, bracketsMatching.checkBracketsMatching( "[()]{}{[()()]()}" ) );
      /**
       * 
       */
      assertEquals( false, bracketsMatching.checkBracketsMatching( "[(])" ) );
      /**
       * 
       */
      assertEquals( true, bracketsMatching.checkBracketsMatching( "((((({{{[()]{}{[()()]()}}}})))))" ) );
      /**
       * 
       */
      assertEquals( true, bracketsMatching.checkBracketsMatching( "(({{((((({{{[()]{}{[()()]()}}}})))))((((({{{[()]{}{[()()]()}}}})))))}}))" ) );
   }
}
