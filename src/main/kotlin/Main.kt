data class Post(
    var id: Int,
    val text: String,
    val likes: Likes = Likes(0),
    val comments: Comments = Comments(""),
    val delete: CanDelete = CanDelete(true or false),
    val date: Date = Date(0),
    val pin: CanPin = CanPin(true or false),
    val edit: CanEdit = CanEdit(true or false),
    val pinned: IsPinned = IsPinned(true or false),
    val ads: MarkAsAds = MarkAsAds(true or false),
    val replyOwnerId: Long? = null,
    val replyPostId: Long? = null,
    val attachments: Attachments? = null,
)

data class Likes(
    val count: Int
)

data class Comments(
    val comments: String
)

data class CanDelete(
    val delete: Boolean
)

data class Date(
    val date: Int
)

data class CanPin(
    val pin: Boolean
)

data class CanEdit(
    val edit: Boolean
)

data class IsPinned(
    val pinned: Boolean
)

data class MarkAsAds(
    val ads: Boolean
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