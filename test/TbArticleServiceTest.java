/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Class pour tester la classe TbArticleService
 * 
 * @author helldown <helldown.com>
 */
public class TbArticleServiceTest {
    
    public TbArticleServiceTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
     @Test
     public void hello() {
     //Arrange
     String maChaine = "Hello world";
     
     //Assert ready to test
     assertNotNull(maChaine);
             
     //Act
     int res = maChaine.compareTo("plop");
     //boolean resBool = (maChaine.compareToIgnoreCase("plop")<0);
     
     //Assert
     assertNotEquals(0,res);
     //assertNotEquals(Boolean.FALSE, resBool);
     
     }
}
