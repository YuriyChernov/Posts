import notes.CommentNote
import notes.Notes
import notes.WallServiceNote
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class WallServiceNoteTest {
    @Before
    fun clearBeforeTest() {
        WallServiceNote.clear()
    }

    @Test
    fun add() {
        val service = WallServiceNote
        service.add(Notes(2, 1, 5678, "Примечание", "Премечание"))
        Assert.assertEquals(1, service.getById(1)?.id)
    }

    @Test
    fun deleteTrue() {
        val service = WallServiceNote
        service.add(Notes(2, 1, 5678, "Примечание", "Премечание"))
        Assert.assertEquals(true, service.delete(1))
    }

    @Test
    fun deleteFalse() {
        val service = WallServiceNote
        service.add(Notes(2, 1, 5678, "Примечание", "Премечание"))
        Assert.assertEquals(false, service.delete(2))
    }

    @Test
    fun editTrue() {
        val service = WallServiceNote
        service.add(Notes(0, 1, 5678, "с", "Премечание"))
        val editNote = Notes(1, 1, 5678, "Примечание", "Премечание")
        Assert.assertEquals(true, service.edit(editNote))
    }

    @Test
    fun editFalse() {
        val service = WallServiceNote
        service.add(Notes(0, 1, 5678, "Примечание", "Премечание"))
        val editNote = Notes(2, 1, 5678, "Примечание", "Премечание")
        Assert.assertEquals(false, service.edit(editNote))
    }

    @Test
    fun read() {
        val service = WallServiceNote
        service.add(Notes(0, 1, 5678, "Примечание", "Премечание"))
        Assert.assertEquals(1, service.read().size)
    }


    @Test
    fun restoreTrue() {
        val service = WallServiceNote
        service.add(Notes(0, 1, 5678, "Примечание", "Премечание", true))
        Assert.assertEquals(true, service.restore(1))
    }

    @Test
    fun restoreFalse() {
        val service = WallServiceNote
        service.add(Notes(0, 1, 5678, "Примечание", "Премечание", true))
        Assert.assertEquals(false, service.restore(2))
    }

    @Test
    fun createComment() {
        val service = WallServiceNote
        service.add(Notes(0, 1, 5678, "Примечание", "Премечание"))
        val result = service.createComment(CommentNote(1, 0, 1, "ujjj", date = 5678))
        Assert.assertEquals(true, result)
    }

    @Test
    fun deleteCommentTrue() {
        val service = WallServiceNote
        service.add(Notes(0, 1, 5678, "Примечание", "Премечание"))
        service.createComment(CommentNote(1, 0, 1, "ujjj", date = 5678))
        Assert.assertEquals(true, service.deleteComment(1, 1))
    }

    @Test
    fun deleteCommentFalse() {
        val service = WallServiceNote
        service.add(Notes(0, 1, 5678, "Примечание", "Премечание"))
        service.createComment(CommentNote(1, 0, 1, "ujjj", date = 5678))
        Assert.assertEquals(false, service.deleteComment(2, 1))
    }

    @Test
    fun editCommentTrue() {
        val service = WallServiceNote
        service.add(Notes(0, 1, 5678, "Примечание", "Премечание"))
        service.createComment(CommentNote(1, 0, 1, "ujjj", date = 5678))
        val editCom = CommentNote(1, 1, 1, "jjj", date = 5678)
        Assert.assertEquals(true, service.editComment(editCom))
    }

    @Test
    fun editCommentFalse() {
        val service = WallServiceNote
        service.add(Notes(0, 1, 5678, "Примечание", "Премечание"))
        service.createComment(CommentNote(1, 0, 1, "ujjj", date = 5678))
        val editCom = CommentNote(2, 2, 1, "jjj", date = 4566)
        Assert.assertEquals(false, service.editComment(editCom))
    }


    @Test
    fun restoreCommentTrue() {
        val service = WallServiceNote
        service.add(Notes(0, 1, 5678, "Примечание", "Премечание"))
        service.createComment(CommentNote(1, 0, 1, "ujjj", date = 5678))
        service.deleteComment(1, 1)
        Assert.assertEquals(true, service.restoreComment(1, 1))
    }

    @Test
    fun restoreCommentFalse() {
        val service = WallServiceNote
        service.add(Notes(0, 1, 5678, "Примечание", "Премечание"))
        service.createComment(CommentNote(1, 0, 1, "ujjj", date = 5678))
        service.deleteComment(1, 1)
        Assert.assertEquals(false, service.restoreComment(1, 2))
    }
}
