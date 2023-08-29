data class Post(
    var id: Int = 0,
    val text: String = "",
    val ownerId: Int = 0,
    val fromId: Int = 0,
    val createdBy: Int = 0,
    val date: Int = 0,
    val replyOwnerId: Long? = null,
    val replyPostId: Long? = null,
    val friendsOnly: Boolean = true or false,
    val comments: Comments = Comments(),
    val copyright: Copyright = Copyright(),
    val likes: Likes = Likes(),
    val reposts: Reposts = Reposts(),
    val views: Views = Views(),
    val postType: String = "",
    val geo: Geo = Geo(),
    val signerId: Int = 0,
    val canPin: Boolean = true or false,
    val canDelete: Boolean = true or false,
    val canEdit: Boolean = true or false,
    val isPinned: Boolean = true or false,
    val markAsAds: Boolean = true or false,
    val isFavorite: Boolean = true or false,
    val postponedId: Boolean = true or false,
    val attachments: List<Attachments> = emptyList(),
)

object WallService {
    private var posts = emptyArray<Post>()
    private var lastId = 0

    fun clear() {
        posts = emptyArray()
        lastId = 0
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