
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import projecto.Colisiones;
import projecto.Interfaz;
import projecto.auto;

/**
 * Esta clase es para los test unitarios
 *
 *
 */
public class AutoTest {

    private Colisiones c;
    private auto a;

    public AutoTest() {
        a = new auto(150, 200);
        c = new Colisiones(a);
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

    @Test
    public void PastoTest() {
        if (c.estaenelpasto == true) {
            assertTrue(c.roce);
        } else {
            assertFalse(c.roce);
        }

    }

    @Test
    public void ColiTest() {
        if (c.choque == true) {
            assertTrue(c.colision);
        }

        if (c.choque == false) {
            assertFalse(c.colision);
        }
    }

}
