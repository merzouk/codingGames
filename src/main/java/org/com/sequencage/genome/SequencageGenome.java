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
 * Fichier 		:	SequencageGenome.java
 * Créé le 		: 	11 févr. 2020 à 12:11:47
 * Auteur		: 	Merzouk
 * 
 * Description 	:
 * 
 *---------------------------------------------------------
 */

package org.com.sequencage.genome;

import org.springframework.stereotype.Service;

/**
 * A Renseigner.
 * @author  : Merzouk
 * @project : Exercices-coding-games
 * @package : org.com.sequencage.genome
 * @date    : 11 févr. 2020 12:11:47
 */
@Service("sequencageGenome")
public class SequencageGenome
{
   private final int lengthRef = 1000000;
   
   public final String optimalSequence( final String[] subSequenceList )
   {
      if( subSequenceList == null || subSequenceList.length == 0 )
      {
         return null;
      }
      int minLength = lengthRef;
      int index = 0;
      String[] resultBySequencesOrdered = new String[subSequenceList.length];
      for( int i = 0; i < resultBySequencesOrdered.length; i++ )
      {
         resultBySequencesOrdered[i] = buildSequencesList( subSequenceList, i );
         if( resultBySequencesOrdered[i] != null && minLength > resultBySequencesOrdered[i].length() )
         {
            minLength = resultBySequencesOrdered[i].length();
            index = i;
         }
      }
      return resultBySequencesOrdered[index];
   }
   
   /**
   *
   * @param subSequenceList
   * @return
   */
   private String buildSequencesList( final String[] subSequenceList, int beginIndex )
   {
      String finalConctString = "";
      boolean[] elementsTraites = new boolean[subSequenceList.length];
      boolean vrai = false;
      elementsTraites[beginIndex] = true;
      String buffer = subSequenceList[beginIndex];
      int badIndex = -1;
      while( !vrai )
      {
         int index = getIndex( elementsTraites, badIndex );
         if( index >= 0 )
         {
            if( finalConctString.length() > 0 )
            {
               buffer = finalConctString;
            }
            String res1 = buildSequence( buffer, subSequenceList[index] );
            //System.err.println( buffer + "  et  " + subSequenceList[index] + "    " + res1 );
            String res2 = buildSequence( subSequenceList[index], buffer );
            //System.err.println( subSequenceList[index] + "   et  " + buffer + "     " + res2 );
            if( res1 != null && res2 != null )
            {
               if( res1.length() < res2.length() )
               {
                  finalConctString = res1;
                  elementsTraites[index] = true;
                  badIndex = -1;
               }
               else
               {
                  finalConctString = res2;
                  elementsTraites[index] = true;
                  badIndex = -1;
               }
            }
            else if( res1 != null && res2 == null )
            {
               finalConctString = res1;
               elementsTraites[index] = true;
               badIndex = -1;
            }
            else if( res1 == null && res2 != null )
            {
               finalConctString = res2;
               elementsTraites[index] = true;
               badIndex = -1;
            }
            else if( res1 == null && res2 == null )
            {
               finalConctString = buffer + subSequenceList[index];
               elementsTraites[index] = true;
            }
            else
            {
               badIndex = index;
            }
         }
         else
         {
            vrai = true;
         }
      }
      return finalConctString;
   }
   
   /**
   *
   * @param subSequence1
   * @param subSequence2
   * @return
   */
   private String buildSequence( String subSequence1, String subSequence2 )
   {
      String finalSequence = "";
      finalSequence = concatSequences( subSequence1, subSequence2 );
      if( finalSequence != null )
      {
         return finalSequence;
      }
      finalSequence = "";
      char[] array1 = subSequence1.toCharArray();
      char[] array2 = subSequence2.toCharArray();
      int i = array1.length - 1;
      int j = 0;
      int m = 0;
      boolean vrai = false;
      while( !vrai )
      {
         while( m < array2.length && i > 0 )
         {
            if( array1[i] != array2[j] )
            {
               //System.err.println( i + "     " + array1[i] + "        " + j + "           " + array2[j] );
               i--;
            }
            else
            {
               int k = i;
               while( k < array1.length )
               {
                  if( array1[k] == array2[j] )
                  {
                     k++;
                     j++;
                  }
                  else if( k < array1.length && array1[k] != array2[j] )
                  {
                     return null;
                  }
               }
               if( k == array1.length )
               {
                  finalSequence = subSequence1;
                  //System.err.println( finalSequence );
                  for( m = j; m < array2.length; m++ )
                  {
                     finalSequence += array2[m];
                     //System.err.println( "l   " + l + "     " + finalSequence );
                  }
                  if( m == array2.length )
                  {
                     return finalSequence;
                  }
                  // System.err.println(i + " " + array1[i] + " " + j + "
                  // " + array2[j]);
               }
            }
         }
         if( finalSequence == null || m == array2.length || m == 0 )
         {
            return null;
         }
         else if( m == array2.length || m == 0 )
         {
            return finalSequence;
         }
      }
      return finalSequence;
   }
   
   /**
   *
   * @param elementsTraites
   * @param badIndex
   * @return
   */
   private int getIndex( final boolean[] elementsTraites, int badIndex )
   {
      if( elementsTraites == null || elementsTraites.length == 0 )
      {
         return -1;
      }
      for( int i = 0; i < elementsTraites.length; i++ )
      {
         if( !elementsTraites[i] && badIndex != i )
         {
            return i;
         }
      }
      return -1;
   }
   
   /**
   *
   * @param str1
   * @param str2
   * @return
   */
   private String concatSequences( String str1, String str2 )
   {
      if( str1 == null || str1.trim().length() == 0 )
      {
         return str2;
      }
      if( str2 == null || str2.trim().length() == 0 )
      {
         return str1;
      }
      if( str1.toLowerCase().equals( str2.toLowerCase() ) )
      {
         return str1;
      }
      if( str1.toLowerCase().contains( str2.toLowerCase() ) )
      {
         return str1;
      }
      if( str2.toLowerCase().contains( str1.toLowerCase() ) )
      {
         return str2;
      }
      return null;
   }
}