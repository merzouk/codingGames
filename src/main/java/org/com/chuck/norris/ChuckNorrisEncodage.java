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
      String transform = convertCharToAsciiCode( str ), result = "";
      int i = 0;
      while( i < transform.length() )
      {
         String get = getSerieBit( i, transform );
         if( get.contains( "0" ) )
            result += ( result.length() == 0 ) ? ( "00 " + buildSerieZero( get ) ) : ( " 00 " + buildSerieZero( get ) );
         else
            result += ( result.length() == 0 ) ? ( "0 " + buildSerieZero( get ) ) : ( " 0 " + buildSerieZero( get ) );
         i += get.length();
      }
      return result;
   }
   
   /**
    * 
    * @param str
    * @return
    */
   private String convertCharToAsciiCode( String str )
   {
      StringBuilder binary = new StringBuilder();
      char[] chars = str.toCharArray();
      for( int j = 0; j < chars.length; j++ )
      {
         int val = chars[j];
         for( int i = 0; i < 7; i++ )
         {
            val <<= 1;
            binary.append( ( val & 128 ) == 0 ? 0 : 1 );
         }
      }
      return binary.toString();
   }
   
   private String buildSerieZero( String get )
   {
      String str = "";
      for( int i = 0; i < get.length(); i++ )
         str += "0";
      return str;
   }
   
   private String getSerieBit( int index, String str )
   {
      char c = str.charAt( index );
      String result = "" + c;
      do
      {
         if( index < str.length() - 1 )
         {
            index++;
            char s = str.charAt( index );
            if( s == c )
               result += c;
            else
               break;
         }
         else
         {
            break;
         }
      } while( true );
      return result;
   }
}
