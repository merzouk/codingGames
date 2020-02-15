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
 * Fichier 		:	chuckNorrisEncodage.java
 * Créé le 		: 	10 févr. 2020 à 21:42:56
 * Auteur		: 	Merzouk
 * 
 * Description 	:
 * 
 *---------------------------------------------------------
 */

package org.com.chuck.norris;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * 
 * Binary with 0 and 1 is good, but binary with only 0, or almost, is even better! Originally, this is a concept designed by Chuck Norris to send so called unary messages.
 * 
 * Write a program that takes an incoming message as input and displays as output the message encoded using Chuck Norris’ method. 
 * 
 * Rules
 * 
 * Here is the encoding principle:
 *  The input message consists of ASCII characters (7-bit)
 *  The encoded output message consists of blocks of 0
 *  A block is separated from another block by a space
 *  Two consecutive blocks are used to produce a series of same value bits (only 1 or 0 values):
 *    - First block: it is always 0 or 00. If it is 0, then the series contains 1, if not, it contains 0
 *    - Second block: the number of 0 in this block is the number of bits in the series
 *    
 *    Example
 *    
 *     Let’s take a simple example with a message which consists of only one character: Capital C. C in binary is represented as 1000011, so with Chuck Norris’ technique this gives:
 *     0 0 (the first series consists of only a single 1)
 *     00 0000 (the second series consists of four 0)
 *     0 00 (the third consists of two 1)
 *     
 *     
 *     So C is coded as: 0 0 00 0000 0 00
 *     
 *     Second example, we want to encode the message CC (i.e. the 14 bits 10000111000011) :
 *     
 *     0 0 (one single 1)
 *     00 0000 (four 0)
 *     0 000 (three 1)
 *     00 0000 (four 0)
 *     0 00 (two 1)
 *     
 *     So CC is coded as: 0 0 00 0000 0 000 00 0000 0 00
 *     
 *     
 * @author  : Merzouk
 * @project : Exercices-coding-games
 * @package : org.com.chuck.norris
 * @date    : 10 févr. 2020 21:42:56
 */
@Service("chuckNorrisEncodage")
public class ChuckNorrisEncodage
{
   private static final Logger logger = LoggerFactory.getLogger( ChuckNorrisEncodage.class );
   /**
    * 
    * @param str
    * @return
    */
   public String chuckNorrisEncode( String str )
   {
      logger.info( "str : " + str );
      if( str == null || str.isEmpty() ) return "";
      char[] array = str.toCharArray();
      String transform = "", result = "";
      for( int i = 0; i < array.length; transform += "" + Integer.toBinaryString( array[i++] ));
      logger.info( "transform : " + transform );
      int i = 0;
      boolean premierPassage = true;
      while( i < transform.length() )
      {
         char c = transform.charAt( i );
         if( c == '0' )
         {
            String s = getSerieDeZero( i, transform, '0' );
            i += s.length();
            result += ( premierPassage ) ? ( "00 " + s ) : ( " 00 " + s );
            premierPassage = false;
         }
         if( c == '1' )
         {
            String s = getSerieDeZero( i, transform, '1' );
            i += s.length();
            result += ( premierPassage ) ? ( "0 " + s ) : ( " 0 " + s );
            premierPassage = false;
         }
      }
      return result;
   }
   
   /**
    * 
    * @param pos
    * @param str
    * @return
    */
   private String getSerieDeZero( int pos, String str, char controler )
   {
      String s = "0";
      boolean t = false;
      int i = 1;
      while( !t && ( pos + i ) < str.length() )
      {
         char c = str.charAt( pos + i );
         if( c == controler )
            s += "0";
         else
            t = true;
         i++;
      }
      return s;
   }
}
