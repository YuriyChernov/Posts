package notes

data class CommentNote(
    val noteId:Int,
    val commentId:Int=0,
    val ownerId:Int,
    var message: String,
    var flagDelete:Boolean=false,
    val date:Int
)
