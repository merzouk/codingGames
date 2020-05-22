
package org.com.compare.str;

import org.springframework.stereotype.Service;

/**
 * A Renseigner.
 * @author  : Merzouk
 * @project : Exercices-coding-games
 * @package : org.com.compare.str
 * @date    : 8 févr. 2020 16:52:55
 */
@Service("compareString")
public class CompareString
{
   /**
    * 
    * @param str1
    * @param str2
    * @return
    */
   public boolean compare( String str1, String str2 )
   {
      if( str1 == null || str2 == null )
      {
         return false;
      }
      if( str1.trim().length() == 0 || str2.trim().length() == 0 )
      {
         return false;
      }
      char[] ch1 = str1.toLowerCase().toCharArray();
      char[] ch2 = str2.toLowerCase().toCharArray();
      //on parcours le premier ableau 
      for( int i = 0; i < ch1.length; i++ )
      {
         boolean trouve = false;
         int j = 0;
         //pour chaque char du tableau ch1, on le cherche dans le tableau ch2
         while( trouve == false && j < ch2.length )
         {
            if( trouve == false && ch1[i] == ch2[j] )
            {
               //un char controlé est supprimé
               ch2 = replace( ch2, j );
               //le char de ch1 recherché dans ch2 est trouvé
               trouve = true;
            }
            j++;
         }
         //si un char de ch1 n'est pas trouvé dans ch2 on quitte
         if( trouve == false )
         {
            return false;
         }
      }
      return true;
   }
   
   /**
    * supprime le char trouve
    * 
    * @param ch : la chaine dont laquelle on supprime le char
    * @param index : l'index du char à supprimer
    * 
    * @return : le tableau de char ou le char d'index est supprimé
    */
   private char[] replace( char[] ch, int index )
   {
      if( index > ch.length )
      {
         return ch;
      }
      char[] c = new char[ch.length - 1];
      int j = 0;
      for( int i = 0; i < ch.length; i++ )
      {
         if( i != index )
         {
            c[j] = ch[i];
            j++;
         }
      }
      return c;
   }
}
