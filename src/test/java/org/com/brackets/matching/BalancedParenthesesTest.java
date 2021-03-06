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
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
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
public class BalancedParenthesesTest
{
   @Autowired
   private BalancedParentheses balancedParentheses;
   /**
    * 
    */
   @BeforeEach
   public void init()
   {
      assertTrue( balancedParentheses != null );
   }
   
   /**
    * 
    */
   @AfterEach
   public void destroy()
   {
      balancedParentheses = null;
   }
   
   /**
    * 
    */
   @Test
   public void bracketsMatchingTest()
   {
      assertEquals( true, balancedParentheses.checkParenthesesMatching( "(){}" ) );
      /**
       * 
       */
      assertEquals( true, balancedParentheses.checkParenthesesMatching( "(){}{}[]" ) );
      /**
       * 
       */
      assertEquals( true, balancedParentheses.checkParenthesesMatching( "({})" ) );
      /**
       * 
       */
      assertEquals( true, balancedParentheses.checkParenthesesMatching( "( {}) " ) );
      /**
       * 
       */
      assertEquals( true, balancedParentheses.checkParenthesesMatching( "[()]{}{[()()]()}" ) );
      /**
       * 
       */
      assertEquals( false, balancedParentheses.checkParenthesesMatching( "[(])" ) );
      /**
       * 
       */
      assertEquals( false, balancedParentheses.checkParenthesesMatching( " [( ]) " ) );
      /**
       * 
       */
      assertEquals( true, balancedParentheses.checkParenthesesMatching( "((((({{{[()]{}{[()()]()}}}})))))" ) );
      /**
       * 
       */
      assertEquals( true, balancedParentheses.checkParenthesesMatching( "(({{((((({{{[()]{}{[()()]()}}}})))))((((({{{[()]{}{[()()]()}}}})))))}}))" ) );
      /**
       * 
       */
      assertEquals( false, balancedParentheses.checkParenthesesMatching( "(({{((((({{{[()]{}{[()()]()}}}})))))((((({{{[()]{}{[()()]()}}}}))))){}}))" ) );
      /**
       * 
       */
      assertEquals( true, balancedParentheses.checkParenthesesMatching( "(( { {( (((({ { { [()]{ }{[()()]()} } } })))))((((({ { { [() ] { }{ [() () ]( )}}}})))))}} ) )" ) );
      /**
       * 
       */
      assertEquals( false, balancedParentheses.checkParenthesesMatching( "(( { {( (((({ { { [()]{ }{[()()]()} } } })))))((((({ { { ) [() ] { }{ [() () ]( )}}}})))))}} ) )" ) );
   }
}
