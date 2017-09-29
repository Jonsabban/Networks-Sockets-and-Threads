/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serverTest;

import echoServer.Client;
import java.io.IOException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Sanox
 */
public class echoServerTest {

    Client client = new Client();

    public echoServerTest() {

    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() throws Exception {

        client.startConnection("127.0.0.1", 5555);
    }

    @After
    public void tearDown() throws IOException {
        client.stopConnection();
    }

    @Test
    public void echoResponseBackFromServer() throws IOException {
        
        String response1 = client.sendMessage("hello");
        String response2 = client.sendMessage("hello");
        String response3 = client.sendMessage("hello");
        
        assertEquals(response1, "HELLO");
    }
    
}
