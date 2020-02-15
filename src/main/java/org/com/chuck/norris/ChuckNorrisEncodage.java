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
 * A Renseigner.
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
