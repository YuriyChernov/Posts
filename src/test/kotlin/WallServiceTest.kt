import junit.framework.TestCase.assertFalse
import junit.framework.TestCase.assertTrue
import org.junit.Test

class WallServiceTest {

    @Test
    fun addPost() {
        val post = WallService.add(Post(1, "Hi"))
        assertTrue(post.id == 1)
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