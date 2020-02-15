package org.com.compare.str;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * A Renseigner.
 * @author  : Merzouk
 * @project : Exercices-coding-games
 * @package : org.com.compare.str
 * @date    : 8 févr. 2020 16:53:58
 */
@ExtendWith(SpringExtension.class)
@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
public class CompareStringTest
{
   @Autowired
   private CompareString compareString;
   @Test
   public void compare()
   {
      assertEquals( compareString.compare( "abc", "CbAa" ), true );
      assertEquals( compareString.compare( "OUTlock", "outLOCk" ), true );
      assertEquals( compareString.compare( "OUTlock", "outLOCk " ), true );
      assertEquals( compareString.compare( "volvo", "VoOvl" ), true );
      assertEquals( compareString.compare( "volvo ", " VoOvl" ), true );
      assertEquals( compareString.compare( " vo l  vo", " Vo         Ov       l" ), true );
      assertEquals( compareString.compare( "abc", "CbA" ), true );
      assertEquals( compareString.compare( "abc", "" ), false );
      assertEquals( compareString.compare( "abc", null ), false );
      assertEquals( compareString.compare( "abc", "   " ), false );
   }
}
