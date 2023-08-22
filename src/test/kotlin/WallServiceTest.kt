import junit.framework.TestCase.*
import org.junit.Assert.assertNotEquals
import org.junit.Test

class WallServiceTest {

    @Test
    fun addPost() {
        val post = WallService.add(Post(0, "Hi"))
        assertNotEquals(1, post.id)
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