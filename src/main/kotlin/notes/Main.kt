package notes

data class Notes(
    val id: Int = 0,
    val ownerId: Int,
    val date: Int,
    val text: String,
    val title:String,
    var flagDelete: Boolean = false,
    val add: Add = Add(),
    val createComment: CreateComment = CreateComment(),
    val delete: Delete = Delete(),
    val deleteComment: DeleteComment = DeleteComment(),
    val edit: Edit = Edit(),
    val editComment: EditComment = EditComment(),
    val get: Get = Get(),
    val getById: GetById = GetById(),
    val getComments: GetComments = GetComments(),
    val restoreComment: RestoreComment = RestoreComment(),
    var comments: List<CommentNote> = mutableListOf()
)

fun main() {
    val serviceNote = WallServiceNote
    serviceNote.add(Notes(3, 1, 1234, "Заметка", "Запись"))
    serviceNote.add(Notes(2, 1, 5678, "Заметка", "Запись"))
    serviceNote.get(1, 2, 1).forEach { println(it) }
    val editNote = Notes(1, 1, 4321, "Заметка", "Примечание")
    serviceNote.edit(editNote)
    println(serviceNote.getById(editNote.id))
    println()
    serviceNote.delete(2)
    serviceNote.read().forEach { println(it) }
    println()
    serviceNote.restore(2)
    serviceNote.read().forEach { println(it) }
    serviceNote.createComment(CommentNote(1, 0, 1, "Привет", date = 1234))
    serviceNote.createComment(CommentNote(1, 0, 1, "Добрый день", date = 1234))
    serviceNote.createComment(CommentNote(2, 0, 1, "Здравствуйте", date = 1234))
    println()
    serviceNote.getComments(1, 0, 3).forEach { println(it) }
    serviceNote.deleteComment(1, 1)
    println()
    serviceNote.getComments(1, 0, 3).forEach { println(it) }
    println()
    println(serviceNote.restoreComment(1, 1))
    serviceNote.getComments(1, 0, 3).forEach { println(it) }
    println()
    serviceNote.deleteComment(1, 1)
}

object WallServiceNote : CrudService<Notes> {
    private var notes = emptyArray<Notes>()
    private var lastId = 1
    override fun add(note: Notes): Notes {
        notes += note.copy(id = lastId++)
        return notes.last()
    }

    override fun delete(noteId: Int): Boolean {
        for ((index, note) in notes.withIndex()) {
            if (note.id == noteId && !note.flagDelete) {
                notes[index].flagDelete = false
                return true
            }
        }
        return false
    }

    override fun edit(note: Notes): Boolean {
        for ((index, noteArr) in notes.withIndex()) {
            if (noteArr.id == note.id && !noteArr.flagDelete) {
                notes[index] = note.copy()
                return true
            }
        }
        return false
    }

    override fun read(): List<Notes> {
        val listNotes = mutableListOf<Notes>()
        for (note in notes) {
            if (!note.flagDelete) listNotes += note
        }
        return listNotes
    }

    override fun getById(noteId: Int): Notes? {
        for (note in notes) {
            if (note.id == noteId && !note.flagDelete) {
                return note
            }
        }
        return null
    }

    override fun restore(id: Int): Boolean {
        for ((index, note) in notes.withIndex()) {
            if (note.id == id && note.flagDelete) {
                notes[index].flagDelete = false
                return true
            }
        }
        return false
    }

    fun get(userId: Int, count: Int, sort: Int): List<Notes> {
        val listNotes = mutableListOf<Notes>()
        for (note in notes) {
            if (note.ownerId == userId) {
                listNotes += note.copy()
                if (listNotes.size == count) break
            }
        }
        if (sort == 1) {
            return listNotes.sortedBy { it.date }
        }
        return listNotes.sortedByDescending { it.date }
    }

    fun createComment(comment: CommentNote): Boolean {
        for ((index, note) in notes.withIndex()) {
            if (note.id == comment.noteId && !note.flagDelete) {
                val curCountComments = notes[index].comments.size + 1
                notes[index].comments += comment.copy(commentId = curCountComments)
                return true
            }
        }
        return false
    }

    fun deleteComment(commentId: Int, noteId: Int): Boolean {
        for ((index, note) in notes.withIndex()) {
            if (note.id == noteId && !note.flagDelete) {
                for ((indexCom, comment) in notes[index].comments.withIndex()) {
                    if (comment.commentId == commentId && !comment.flagDelete) {
                        notes[index].comments[indexCom].flagDelete = true
                        return true
                    }
                }
            }
        }
        return false
    }

    fun editComment(comment: CommentNote): Boolean {
        for ((index, note) in notes.withIndex()) {
            if (note.id == comment.noteId && !note.flagDelete) {
                for ((indexCom, commentArr) in notes[index].comments.withIndex()) {
                    if (commentArr.commentId == comment.commentId) {
                        notes[index].comments[indexCom].message = comment.message
                        return true
                    }
                }

            }
        }
        return false
    }

    fun getComments(noteId: Int, sort: Int, count: Int): List<CommentNote> {
        val listComments = mutableListOf<CommentNote>()
        for ((index, note) in notes.withIndex()) {
            if (note.id == noteId && !note.flagDelete) {
                for (comment in notes[index].comments) {
                    if (!comment.flagDelete) {
                        listComments += comment.copy()
                        if (listComments.size == count) break
                    }
                }
            }
        }
        if (sort == 1) {
            return listComments.sortedBy { it.date }
        }
        return listComments.sortedByDescending { it.date }
    }

    fun restoreComment(commentId: Int, noteId: Int): Boolean {
        for ((index, note) in notes.withIndex()) {
            if (note.id == noteId && !note.flagDelete) {
                for ((indexCom, comment) in notes[index].comments.withIndex()) {
                    if (comment.commentId == commentId && comment.flagDelete) {
                        notes[index].comments[indexCom].flagDelete = false
                        return true
                    }
                }
            }
        }
        return false
    }

    fun clear() {
        notes = emptyArray()
        lastId = 1
    }
}