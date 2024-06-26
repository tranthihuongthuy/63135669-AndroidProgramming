package till.huongthuy.thick_appnote.Models;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;
@Entity(tableName = "notes")
public class Notes implements Serializable {
    @PrimaryKey(autoGenerate = true)
    int ID = 0;
    @ColumnInfo(name = "Tiêu đề")
    String tittle = "";
    @ColumnInfo(name = "Ghi chú")
    String notes = "";
    @ColumnInfo(name = "Ngày")
    String date = "";
    @ColumnInfo(name = "Ghim")
    boolean pinned = false;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public boolean isPinned() {
        return pinned;
    }

    public void setPinned(boolean pinned) {
        this.pinned = pinned;
    }
}
