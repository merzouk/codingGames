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
 * Fichier 		:	PositionOfTheDancer.java
 * Créé le 		: 	10 févr. 2020 à 15:32:55
 * Auteur		: 	Merzouk
 * 
 * Description 	:
 * 
 *---------------------------------------------------------
 */

package org.com.dancer;

import org.springframework.stereotype.Service;

/**
 *  Description of the algorithm (copied)
 * 
 *  This dance asks every performer to follow a precise sequence of steps:
 * 
 * • Stage 0 : First, get away from obstacles by setting up your starting point at position 0
 * 
 * • Stage 1 : Take one step forward (+1 step)
 * 
 * • Stage 2 : Take two steps backward (-2 steps)
 * 
 * • To follow, the steps as well as the direction you will have to take in your next move will each time be obtained thanks to a specific calculation: 
 *   the number of steps you took on the previous stage minus the number of steps you took on the penultimate stage.
 * 
 * That is, on stage 3, a dancer will have to take 3 steps backwards (-2 - 1).
 * 
 * @author  : Merzouk
 * @project : Exercices-coding-games
 * @package : org.com
 * @date    : 10 févr. 2020 15:32:55
 */
@Service("positionOfTheDancer")
public class PositionOfTheDancer
{
   public int calculate( int iterationNumber )
   {
      int position = 0;
      int step1 = 1;
      position = position + step1;
      iterationNumber -= 1;
      int step2 = -2;
      position = position + step2;
      iterationNumber -= 1;
      while( iterationNumber > 0 )
      {
         position += ( step2 - step1 );
         int buffer = step1;
         step1 = step2;
         step2 = step2 - buffer;
         iterationNumber -= 1;
      }
      return position;
   }
}
