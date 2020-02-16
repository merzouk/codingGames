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
 * Fichier 		:	ChuckNorrisEncodageTest.java
 * Créé le 		: 	11 févr. 2020 à 11:21:07
 * Auteur		: 	Merzouk
 * 
 * Description 	:
 * 
 *---------------------------------------------------------
 */

package org.com.chuck.norris;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
 * @package : org.com.chuck.norris
 * @date    : 11 févr. 2020 11:21:07
 */
@ExtendWith(SpringExtension.class)
@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
public class ChuckNorrisEncodageTest
{
   @Autowired
   private ChuckNorrisEncodage chuckNorrisEncodage;
   /**
    * 
    */
   @Test
   public void chuckNorrisEncodage01Test()
   {
      assertEquals( "0 0 00 0000 0 00", chuckNorrisEncodage.chuckNorrisEncode( "C" ) );
   }
   
   @Test
   public void chuckNorrisEncodage02Test()
   {
      assertEquals( "0 0 00 0000 0 000 00 0000 0 00", chuckNorrisEncodage.chuckNorrisEncode( "CC" ) );
   }
   
   @Test
   public void chuckNorrisEncodage03Test()
   {
      assertEquals( "0 00 00 0000 0 000 00 000 0 0 00 0 0 00 00 000 0 0000 00 00 0 0 00 00 0 00 00 00 0 0 00 0 0 000 00 00 0 00 00 0 0 00 00 00 0 00000 00 0 0 0 00 000 0 00 00 0 0 0 00 00 0 000 00 0 0 0 00 0 0 0 00 0 0 00 00 0 0 0 00 0 0 0000 00 0 0 00 00 00 0 00 00 0 0 00 00 0 0 000 00 0 0 000 00 0 0 00 00 0 0 0000000 00 0000 0 000 00 000 0 0000 00 00 0 0 00 0 0 000 00 00 0 00000 00 0 0 0 00 00 0 000 00 0 0 0 00 0 0 0000 00 0 0 00 00 0 0 000 00 0 0 0000000 00 000 0 0000 00 00 0 00000 00 0 0 0 00 0", chuckNorrisEncodage.chuckNorrisEncode( "abcdefghijklmnopqrstuvwxyz" ) );
   }
   /**
    * 
    */
   @Test
   public void chuckNorrisEncodage04Test()
   {
      assertEquals( "0 0 00 0000 0 00 00 0 0 0 00 00000 0 0 00 0000 0 00", chuckNorrisEncodage.chuckNorrisEncode( "C C" ) );
   }
   
   /**
    * 
    */
   @Test
   public void chuckNorrisEncodage05Test()
   {
      assertEquals( "00 0 0 0 00 00 0 00 00 0 0 00 00 0000 0 0 00 0 0 0 00 00 0 0 00 00 0 0000 00 0 0 0 00 00 0 0 00 00 0 0 00 0 0 000 00 00 0 0 00 0 0 0 00 0 0 0 00 0 0 0 00 0 0 0 00 0 0 000 00 00 0 0 00 00 0 0 00 0 0 00 00 0 0 0000 00 0 0 0 00 000 0 0 00 0 0 0 00 0 0 000000 00 00 0 0 00 0 0 0000000000 00 00 0 0 00 0 0 0 00 0 0 000 00 0 0 000 00 0 0 0 00 0 0 0 00 0 0 000 00 0 0 0 00 0 0 00 00 0 0 0 00 00 0 0 00 0 0 0000 00 0 0 000 00 0 0 0000 00 0 0 0 00 0 0 0 00 00 0 0000 00 0000", chuckNorrisEncodage.chuckNorrisEncode( "&a$z%e*r-t+y?y.u:i=o)p" ) );
   }
   /**
    * 
    */
   @Test
   public void chuckNorrisEncodage06Test()
   {
      assertEquals( "00 0 0 0 00 00000", chuckNorrisEncodage.chuckNorrisEncode( " " ) );
   }
   
   /**
    * !\"#$&
    */
   @Test
   public void chuckNorrisEncodage08Test()
   {
      assertEquals( "00 0 0 0 00 0000 0 0 00 0 0 0 00 000 0 0 00 00 0 0 00 000 0 00 00 0 0 0 00 00 0 0 00 000 0 0 00 00 0 00 00 0", chuckNorrisEncodage.chuckNorrisEncode( "!\"#$&" ) );
   }
   
   /**
    * %
    */
   @Test
   public void chuckNorrisEncodage07Test()
   {
      assertEquals( "00 0 0 0 00 00 0 0 00 0 0 0", chuckNorrisEncodage.chuckNorrisEncode( "%" ) );
   }
   /**
    * .
    */
   @Test
   public void chuckNorrisEncodage09Test()
   {
      assertEquals( "00 0 0 0 00 0 0 000 00 0", chuckNorrisEncodage.chuckNorrisEncode( "." ) );
   }
   /**
    * .
    */
   @Test
   public void chuckNorrisEncodage10Test()
   {
      assertEquals( "0 0 00 0000 0 0000 00 0 0 0 00 000 0 000 00 0 0 0 00 0 0 000 00 000 0 0000 00 0 0 0 00 0 0 00 00 0 0 0 00 00000 0 0 00 00 0 000 00 0 0 00 00 0 0 0000000 00 00 0 0 00 0 0 000 00 00 0 0 00 0 0 00 00 0 0 0 00 00 0 0000 00 00 0 00 00 0 0 0 00 00000 0 00 00 000 0 0000 00 0000 0 000 00 0 0 000 00 00 0 0 00 00000 0 00 00 00 0 0 00 00 0 00 00 0 0 0 00 00 0 0000 00 0 0 00 00 0 0 00 00 0 0 0 00 00 0 000 00 00 0 0 00 00 0 00 00 00 0 0 00 0 0 0 00 0 0 0 00 00000 0 00 00 000 0 0 00 0 0 0000 00 00 0 0 00 0 0 0 00 00000 0 0000 00 0 0 0 00 0 0 00 00 00 0 0 00 0 0 0000 00 00 0 0 00 0 0 00 00 0 0 0000 00 0 0 0 00 0 0 000 00 0", chuckNorrisEncodage.chuckNorrisEncode( "Chuck Norris can divide by zero." ) );
   }
   
   /**
    * .
    */
   @Test
   public void chuckNorrisEncodage11Test()
   {
      assertEquals( "0 0 00 0000 0 0000 00 0 0 0 00 000 0 000 00 0 0 0 00 0 0 000 00 000 0 0000 00 0 0 0 00 0 0 00 00 0 0 0 00 00000 0 0 00 00 0 000 00 0 0 00 00 0 0 0000000 00 00 0 0 00 0 0 000 00 00 0 0 00 0 0 00 00 0 0 0 00 00 0 0000 00 00 0 00 00 0 0 0 00 00000 0 00 00 000 0 0000 00 0 0 0000000 00 0 0 0 00 0 0 000 00 0 0 000 00 0 0 000 00 0 0 0 00 00 0 00 00 00 0 0 00 0 0 000 00 00 0 0 00 000 0 0 00 00000 0 000 00 0 0 0 00 00 0 00 00 0 0 0000 00 0 0 0 00 00000 0 00 00 0 0 0 00 00 0 000 00 0 0 000 00 0 0 00 00 00 0 00 00 0 0 00 00 0 0 0 00 00 0 000 00 0 0 000 00 0 0 00 00 0 0 0 00 00 0 0000 00 0 0 0 00 00 0 0000 00 00 0 0 00 0 0 0 00 000000 0 0 00 0 0 00 00 0 0 0 00 0 0 0 00 00000 0 000 00 0 0 0 00 00 0 00 00 0 0 0 00 000 0 000 00 00 0 0 00 0 0 00 00 00 0 0 00 0 0 000 00 00 0 0 00 0 0 0 00 0 0 0 00 00000 0 000 00 0 0 0 00 00 0 00 00 0 0 0 00 00 0 000 00 0 0 00 00 0 0 000 00 00 0 0 00 0 0 0000 00 00 0 00 00 0 0 0 00 0 0 000 00 0", chuckNorrisEncodage.chuckNorrisEncode( "Chuck Norris counted to infinity - three times." ) );
   }
   
   /**
    * .
    */
   @Test
   public void chuckNorrisEncodage12Test()
   {
      assertEquals( "0 0 00 0000 0 0000 00 0 0 0 00 000 0 000 00 0 0 0 00 0 0 000 00 000 0 0000 00 0 0 0 00 0 0 00 00 0 0 0 00 00000 0 0 00 00 0 000 00 0 0 00 00 0 0 0000000 00 00 0 0 00 0 0 000 00 00 0 0 00 0 0 00 00 0 0 0 00 00 0 0000 00 00 0 00 00 0 0 0 00 00 0 000 00 0 0 0 00 00000 0 00 00 0 0 0 00 0 0 0000 00 00 0 0 00 0 0 00000 00 00 0 000 00 000 0 0 00 0 0 00 00 0 0 000000 00 0000 0 0000 00 00 0 0 00 0 0 00 00 00 0 0 00 000 0 0 00 00000 0 00 00 0 0 0 00 000 0 00 00 0000 0 0000 00 00 0 00 00 0 0 0 00 000000 0 00 00 00 0 0 00 00 0 0 00 00000 0 00 00 0 0 0 00 0 0 0000 00 00 0 0 00 0 0 00000 00 00 0 0000 00 00 0 00 00 0 0 000 00 0 0 0 00 00 0 0 00 000000 0 00 00 00000 0 0 00 00000 0 00 00 0000 0 000 00 0 0 000 00 0 0 00 00 00 0 0 00 000 0 0 00 00000 0 000 00 0 0 00000 00 0 0 0 00 000 0 00 00 0 0 0 00 00 0 0000 00 0 0 0 00 00 0 00 00 00 0 0 00 0 0 0 00 0 0 0 00 00000 0 000 00 00 0 00000 00 0000 0 00 00 0000 0 000 00 000 0 0000 00 00 0 0 00 0 0 0 00 0 0 0 00 0 0 000 00 0", chuckNorrisEncodage.chuckNorrisEncode( "Chuck Norris' keyboard has 2 keys: 0 and white space." ) );
   }
   
   /**
    * .
    */
   @Test
   public void chuckNorrisEncodage13Test()
   {
      assertEquals( "00 0 0 0 00 00 0 00 00 0 0 00 00 0000 0 0 00 0 0 0 00 00 0 0 00 00 0 0000 00 0 0 0 00 00 0 0 00 00 0 0 00 0 0 000 00 00 0 0 00 0 0 0 00 0 0 0 00 0 0 0 00 0 0 0 00 0 0 000 00 00 0 0 00 00 0 0 00 0 0 00 00 0 0 0000 00 0 0 0 00 000 0 0 00 0 0 0 00 0 0 000000 00 00 0 0 00 0 0 0000000000 00 00 0 0 00 0 0 0 00 0 0 000 00 0 0 000 00 0 0 0 00 0 0 0 00 0 0 000 00 0 0 0 00 0 0 00 00 0 0 0 00 00 0 0 00 0 0 0000 00 0 0 000 00 0 0 0000 00 0 0 0 00 0 0 0 00 00 0 0000 00 0000", chuckNorrisEncodage.chuckNorrisEncode( "&a$z%e*r-t+y?y.u:i=o)p" ) );
   }
   
   /**
    * .
    */
   @Test
   public void chuckNorrisEncodage14Test()
   {
      assertEquals( "0 0 00 0000 0 0000 00 0 0 0 00 000 0 000 00 0 0 0 00 0 0 000 00 000 0 0000 00 0 0 0 00 0 0 00 00 0 0 0 00 00000 0 0 00 00 0 000 00 0 0 00 00 0 0 0000000 00 00 0 0 00 0 0 000 00 00 0 0 00 0 0 00 00 0 0 0 00 00 0 0000 00 00 0 00 00 0 0 0 00 00 0 000 00 0 0 0 00 00000 0 00 00 0 0 0 00 0 0 0000 00 00 0 0 00 0 0 00000 00 00 0 000 00 000 0 0 00 0 0 00 00 0 0 000000 00 0000 0 0000 00 00 0 0 00 0 0 00 00 00 0 0 00 000 0 0 00 00000 0 00 00 0 0 0 00 000 0 00 00 0000 0 0000 00 00 0 00 00 0 0 0 00 000000 0 00 00 00 0 0 00 00 0 0 00 00000 0 00 00 0 0 0 00 0 0 0000 00 00 0 0 00 0 0 00000 00 00 0 0000 00 00 0 00 00 0 0 000 00 0 0 0 00 00 0 0 00 00000 0 000 00 0 0 00000 00 0 0 0 00 000 0 00 00 0 0 0 00 00 0 0000 00 0 0 0 00 00 0 00 00 00 0 0 00 0 0 0 00 0 0 0 00 00000 0 000 00 00 0 00000 00 0000 0 00 00 0000 0 000 00 000 0 0000 00 00 0 0 00 0 0 0 00 0 0 0 00 00000 0 00 00 0000 0 000 00 0 0 000 00 0 0 00 00 00 0 0 00 000 0 0 00 000000 0 00 00 00000 0 0 00 0 0 000 00 0", chuckNorrisEncodage.chuckNorrisEncode( "Chuck Norris' keyboard has 2 keys: white space and 0." ) );
   }
   
   /**
    * %
    */
   @Test
   public void chuckNorrisEncodage15Test()
   {
      assertEquals( "00 0 0 0 00 000 0 00", chuckNorrisEncodage.chuckNorrisEncode( "#" ) );
   }
}
