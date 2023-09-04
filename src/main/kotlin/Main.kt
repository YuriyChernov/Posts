data class Post(
    var id: Long = 0,
    val text: String = "",
    val ownerId: Int = 0,
    val fromId: Int = 0,
    val createdBy: Int = 0,
    val date: Int = 0,
    val replyOwnerId: Long? = null,
    val replyPostId: Long? = null,
    val friendsOnly: Boolean = true,
    val comments: Comments = Comments(),
    val copyright: Copyright = Copyright(),
    val likes: Likes = Likes(),
    val reposts: Reposts = Reposts(),
    val views: Views = Views(),
    val postType: String = "",
    val geo: Geo = Geo(),
    val signerId: Int = 0,
    val canPin: Boolean = true,
    val canDelete: Boolean = true,
    val canEdit: Boolean = true,
    val isPinned: Boolean = true,
    val markAsAds: Boolean = true,
    val isFavorite: Boolean = true,
    val postponedId: Boolean = true,
    val attachments: List<Attachments> = emptyList(),
)

object WallService {
    private var posts = emptyArray<Post>()
    private var lastId = 0L
    private var comments = emptyArray<Comments>()

    fun createComment(postId: Long, comment: Comments): Comments {
        posts.find { it.id == postId } ?: throw PostNotFoundException("Post $postId is not found")

        comments += comment
        return comments.last()
    }


    fun clear() {
        posts = emptyArray()
        lastId = 0L
    }

    fun add(post: Post): Post {
        posts += post.copy(id = ++lastId)
        return posts.last()
    }

    fun update(newPost: Post): Boolean {
        for ((index, post) in posts.withIndex()) {
            if (post.id == newPost.id) {
                posts[index] = newPost.copy()
                return true
            }
        }
        return false
    }

    fun printPosts() {
        for (post in posts) {
            print(post)
            println(' ')
        }
    }

    fun removeById(id: Long) {

    }
}

fun main() {
    val post = Post(1, "Hi")
    WallService.add(post)
    WallService.add(Post(1, "Hi"))
    WallService.printPosts()
    post.id = 2
    WallService.printPosts()
    println(WallService.update(Post(2, "Updated text")))
    println(WallService.update(Post(6, "Updated text")))
    WallService.printPosts()
}