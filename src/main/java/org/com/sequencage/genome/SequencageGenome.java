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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * 
 * <p>
 * You are working as a computer scientist in a laboratory seeking to sequence the genome. A DNA sequence is represented by a character string (of A, C, T and G) 
 * such as GATTACA. The problem is that biologists are only able to extract sub-sequences of the complete sequence. 
 * Your role is to combine these partial sub-sequences to recover the original sequence.
 * </p>
 * <p>
 * In this exercise you are asked to calculate the length of the shortest sequence that contains all the sub-sequences of the input data.
 * </p>
 * 
 * Rules
 * <p>
 * You are given N sub-sequences and you must return the length of the shortest sequence that contains all the sub-sequences. 
 * There may be several sequences of the same minimum length and which fit the requirement. We are not asking you to list these, but only to return their length.
 * </p>
 * 
 * Note 
 * <p>
 * that there is always a solution. One can indeed simply concatenate all the sub-sequences to obtain a valid sequence. 
 * But by nesting (even partially) the sub-sequences, it is generally possible to obtain a shorter sequence (see the example).
 * </p>
 * 
 * Example
 * 
 * <p>
 * For example, you have three sub-sequences AGATTA, GATTACA, and TACAGA. The sequence AGATTACAGA is the shortest sequence that contains all the sub-sequences.
 * 
 * Note that in this example, there are other sequences which contain all of the sub-sequences such as TACAGATTACAGATTA.. However, we prefer the former because it is shorter (10 characters instead of 16).
 * </p>
 * 
 * Example
 * 
 * <p>
 * AGATTACAGA contains the sub-sequences AGATTA, GATTACA, and TACAGA.
 * </p>
 * 
 * Input
 * 
 * <p>
 * Line 1: The number N of sub-sequences
 * </p>
 * <p>
 * N following lines: one sub-sequence by line, represented by a string of characters from A, C, T and G. Each sub-sequence ranges from 1 to maximum 10 characters long.
 * </p>
 * Output
 * <p>
 * The length of the shortest sequence containing all the sub-sequences.
 * </p>
 * 
 * Constraints
 * <p>
 * 0 < N < 6
 * </p>
 * 
 * 
 * Examples
 * 
 * <p>
 * Input :
 * </p>
 * <p>
 * AAC
 * CCTT
 * </p>
 * <p>
 * Output  : 6 : AACCTT
 * </p>
 * 
 * </p>
 * Input :
 * </p>
 * <p>
 * AGATTA
 * GATTACA
 * TACAGA
 * </p>
 * </p>
 * Output : 10 : AGATTACAGA  
 * </p>
 * <p>
 * Input :
 * </p>
 * 
 * <p>
 * TT
 * AA
 * ACT
 * </p>
 * 
 * <p>
 * Output : 5 : AACTT
 * </p>
 * 
 * @author  : Merzouk
 * @project : Exercices-coding-games
 * @package : org.com.sequencage.genome
 * @date    : 11 févr. 2020 12:11:47
 */
@Service("sequencageGenome")
public class SequencageGenome
{
   private static final Logger logger    = LoggerFactory.getLogger( SequencageGenome.class );
   
   private final int           lengthRef = 1000000;
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
            logger.debug( buffer + "  et  " + subSequenceList[index] + "    " + res1 );
            String res2 = buildSequence( subSequenceList[index], buffer );
            logger.debug( subSequenceList[index] + "   et  " + buffer + "     " + res2 );
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
               logger.debug( i + "     " + array1[i] + "        " + j + "           " + array2[j] );
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
                  logger.debug( finalSequence );
                  for( m = j; m < array2.length; m++ )
                  {
                     finalSequence += array2[m];
                     logger.debug( "k   " + k + "     " + finalSequence );
                  }
                  if( m == array2.length )
                  {
                     return finalSequence;
                  }
                  logger.debug( i + " " + array1[i] + " " + j + " " + array2[j] );
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