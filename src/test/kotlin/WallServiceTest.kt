import junit.framework.TestCase.*
import org.junit.Before
import org.junit.Test

class WallServiceTest {

    @Before
    fun clear() {
        WallService.clear()
    }

    @Test
    fun addPost() {
        val service = WallService
        val id = service.add(Post(0, "Hi"))
        val updateId = Post(1, "Hi")

        assertEquals(id, updateId)
    }

    @Test
    fun updateExistingTrue() {
        val service = WallService

        service.add(Post(1, "Hi"))
        service.add(Post(2, "Hello"))
        service.add(Post(3, "Bye"))

        val update = Post(1, "Goodbye")

        val result = service.update(update)

        assertTrue(result)
    }

    @Test
    fun updateExistingFalse() {
        val service = WallService

        service.add(Post(1, "Hi"))
        service.add(Post(2, "Hello"))
        service.add(Post(3, "Bye"))

        val update = Post(4, "Goodbye")

        val result = service.update(update)

        assertFalse(result)
    }
}