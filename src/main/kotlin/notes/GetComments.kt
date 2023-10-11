package notes

data class GetComments(
    val noteId: Int = 0,
    val ownerId: Int = 0,
    val sort: Int = 0,
    val offset: String = "",
    val count: Int = 0,
)
