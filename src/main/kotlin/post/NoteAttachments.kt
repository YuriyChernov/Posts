package post

data class NoteAttachments(
    val note: Note = Note(),
) : Attachments {
    val type = "note"
}
