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

    @Test(expected = NotImplementedError::class)
    fun shouldThrow() {
        val service = WallService
        val id = 1L
        service.removeById(id)

    }

    @Test(expected = PostNotFoundException::class)
    fun newComment_postNotFound_shouldThrow() {
        val service = WallService
        service.createComment(900L, Comments(500, "Test"))
    }

    @Test
    fun newComment_postFound_success() {
        val service = WallService
        service.add(
            Post(
                1,
                "Hello",
                2,
                3,
            )
        )
        service.createComment(1, Comments(500, "Test"))
    }
}