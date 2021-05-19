package test.cache;

import com.cache.Cache;
import com.cache.factories.CacheFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class CacheTest {

    Cache<Integer, Integer> cache;

    @BeforeEach
    public void setup() {
        cache = new CacheFactory<Integer, Integer>().defaultCache(2);
    }

    @Test
    public void itShouldBeAbleToPutAndGetItems() {
        cache.put(1, 1);
        cache.put(2, 2);

        assertEquals(1, cache.get(1)); // Accessing 1 after 2 got inserted which makes 2 the least recently used till now.
        cache.put(3, 3);
        assertEquals(3, cache.get(3));

        assertNull(cache.get(2));
    }
}
