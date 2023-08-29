data class Comments(
    val count: Int = 0,
    val canPost: Boolean = true or false,
    val groupsCanPost: Boolean = true or false,
    val canClose: Boolean = true or false,
    val canOpen: Boolean = true or false,
)
