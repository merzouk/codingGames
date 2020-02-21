/*
 *--------------------------------------------------------
 * Administrateur
 *--------------------------------------------------------
 * Project     : codingGames
 *
 * Copyright Administrateur,  All Rights Reserved.
 *
 *-------------------------------------------------------- 
 * 
 * Fichier 		:	CheckNorris.java
 * Créé le 		: 	17 févr. 2020 à 10:34:40
 * Auteur		: 	Merzouk
 * 
 * Description 	:
 * 
 *---------------------------------------------------------
 */

package org.com.chuck.norris;

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
 * The exercise code in its short version to get as short as possible.
 * 
 * @author  : Merzouk
 * @project : codingGames
 * @package : org.com.chuck.norris
 * @date    : 17 févr. 2020 10:34:40
 */
@Service("checkNorris")
public class ChuckNorris
{
   public String v( String s )
   {
      String t = "", g;
      int i, j, v;
      for( i = 0; i < s.length(); i++ )
      {
         v = s.charAt( i );
         for( j = 0; j < 7; j++ )
         {
            v <<= 1;
            t += ( ( v & 128 ) == 0 ? 0 : 1 );
         }
      }
      i = 0;
      s = "";
      while( i < t.length() )
      {
         j = i;
         char c = t.charAt( j );
         g = "";
         while( j < t.length() && t.charAt( j ) == c )
         {
            j++;
            g += c;
         }
         if( g.contains( "0" ) )
            s += ( i == 0 ) ? ( "00 " + g ) : ( " 00 " + g );
         else
            s += ( i == 0 ) ? ( "0 " + g.replace( "1", "0" ) ) : ( " 0 " + g.replace( "1", "0" ) );
         i += g.length();
      }
      return s;
   }
}
