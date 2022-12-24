import org.junit.Test;

import static org.junit.Assert.*;


public class UnionFindTest {
    static UnionFind uf = new UnionFind(10);

    @Test
    public void testSize() {
        assertEquals(1, uf.sizeOf(3));
    }

    @Test
    public void testUnion() {
        uf.connect(1, 2);
        assertEquals(1, uf.parent(2));
        assertEquals(2, uf.sizeOf(1));

        uf.connect(2, 3);
        assertEquals(1, uf.parent(3));
        assertEquals(3, uf.sizeOf(3));
    }

    @Test
    public void testFind() {
        uf.connect(1, 2);
        uf.connect(2, 3);
        uf.connect(4, 5);
        assertEquals(4, uf.find(5));
        uf.connect(5, 6);
        uf.connect(1, 5);
        uf.find(6);
        uf.find(6);
        assertEquals(1, uf.find(2));
        assertEquals(1, uf.find(3));
        assertEquals(1, uf.find(4));
        assertEquals(1, uf.find(6));
    }

    @Test
    public void testConnected() {
        uf.connect(1, 2);
        uf.connect(2, 3);
        assertTrue(uf.isConnected(1, 3));
        uf.connect(3, 4);
        assertTrue(uf.isConnected(1, 4));
        assertFalse(uf.isConnected(4, 5));
    }
}