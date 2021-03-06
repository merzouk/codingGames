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
 * Fichier 		:	BracketsMatching.java
 * Créé le 		: 	10 févr. 2020 à 16:06:48
 * Auteur		: 	Merzouk
 * 
 * Description 	:
 * 
 *---------------------------------------------------------
 */

package org.com.brackets.matching;

import org.springframework.stereotype.Service;

/**
 * 
 * Check for balanced parentheses in an expression
 * 
 * Given an expression string exp , write a program to examine whether the pairs and the orders of "{","}","(",")","[","]" are correct in exp.
 * 
 * Input: exp = "[()]{}{[()()]()}"  -> Output: Balanced
 * 
 * Input: exp = "[(])"  ->  Output: Not Balanced
 * 
 * @author  : Merzouk
 * @project : codingGames
 * @package : org.com.brackets.matching
 * @date    : 10 févr. 2020 16:06:48
 */
@Service("balancedParentheses")
public class BalancedParentheses
{

   private static final char[] caractersOpened = { '{', '(', '[', };
   
   private static final char[] caractersClosed = { '}', ')', ']' };
   /**
    * 
    * @param balancedStr
    * 
    * @return
    */
   public boolean checkParenthesesMatching( final String balancedStr )
   {
      if( balancedStr == null || balancedStr.isEmpty() ) return true;
      
      String checked = "";
      for( int index = 0; index < balancedStr.length(); index++ )
      {
         char currentCharRead = balancedStr.charAt( index );
         if( currentCharRead != ' ' )
         {
            if( checkChar( currentCharRead ) )
            {
               checked += currentCharRead;
            }
            else
            {
               boolean charFounded = false;
               for( int j = 0; j < caractersOpened.length; j++ )
               {
                  //we have found the character '?'
                  if( caractersClosed[j] == currentCharRead )
                  {
                     //we have the character '?' we have to found '?'
                     if( caractersOpened[j] == getChar( checked ) )
                     {
                        //we remove the opposite character
                        checked = checked.substring( 0, checked.length() - 1 );
                        //marked the opposite character found
                        charFounded = true;
                     }
                  }
               }
               //opposite character not found, processing is terminated
               if( !charFounded )
               {
                  return false;
               }
            }
         }
      }
      return true;
   }
   
   private boolean checkChar( char currentCharRead )
   {
      for( int i = 0; i < caractersOpened.length; i++ )
      {
         if( caractersOpened[i] == currentCharRead ) return true;
      }
      return false;
   }
   
   private char getChar( String checked )
   {
      char c = ' ';
      int i = 1;
      do
      {
         c = checked.charAt( checked.length() - i );
         i++;
      } while( c == ' ' );
      return c;
   }
}
