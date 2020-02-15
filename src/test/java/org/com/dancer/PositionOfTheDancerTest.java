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
 * Fichier 		:	PositionOfTheDancerTest.java
 * Créé le 		: 	10 févr. 2020 à 15:39:48
 * Auteur		: 	Merzouk
 * 
 * Description 	:
 * 
 *---------------------------------------------------------
 */

package org.com.dancer;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.com.dancer.PositionOfTheDancer;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

/**
 * A Renseigner.
 * @author  : Merzouk
 * @project : Exercices-coding-games
 * @package : org.com
 * @date    : 10 févr. 2020 15:39:48
 */
@ExtendWith(SpringExtension.class)
@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
public class PositionOfTheDancerTest
{
   @Autowired
   private PositionOfTheDancer positionOfTheDancer;
   /**
    * 
    */
   @Test
   public void positionOfTheDancer01Test()
   {
      assertEquals( -4, positionOfTheDancer.calculate( 3 ) );
   }
   
   /**
    * 
    */
   @Test
   public void positionOfTheDancer02Test()
   {
      assertEquals( -5, positionOfTheDancer.calculate( 100000 ) );
   }
   
   /**
    * 
    */
   @Test
   public void positionOfTheDancer03Test()
   {
      assertEquals( 1, positionOfTheDancer.calculate( 2147483647 ) );
   }
}
