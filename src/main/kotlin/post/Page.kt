package post

data class Page(
    val id: Int = 0,
    val groupId: Int = 0,
    val creatorId: Int = 0,
    val title: String = "",
    val currentUserCanEdit: Int = 0,
    val currentUserCanEditAccess: Int = 0,
    val whoCanView: Int = 0,
    val whoCanEdit: Int = 0,
    val edited: Int = 0,
    val created: Int = 0,
    val editorId: Int = 0,
    val views: Int = 0,
    val parent: String = "",
    val parent2: String = "",
    val source: String = "",
    val html: String = "",
    val viewUrl: String = "",
)
