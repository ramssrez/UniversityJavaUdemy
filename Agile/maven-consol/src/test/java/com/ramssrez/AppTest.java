package com.ramssrez;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    private final ByteArrayOutputStream outStream = new ByteArrayOutputStream();

    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }
    @Before
    public void setUp(){
        System.setOut(new PrintStream(outStream));
    }

    @Test
    public void testDecilHola(){
        App app = new App();
        app.holaMundo();
        Assert.assertEquals("Hola mundo con Maven", outStream.toString());
    }
    @After
    public void cleanUp(){
        System.setOut(null);
    }
    @Test
    public void testNumero() {
        App app = new App();
        //app.numeroEjemplo(2);
        Assert.assertEquals(4.0,app.numeroEjemplo(2),0.0);
    }

}
