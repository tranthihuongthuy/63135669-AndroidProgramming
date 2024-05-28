package till.huongthuy.thick_appnote.DataBase;

import static androidx.room.OnConflictStrategy.REPLACE;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import till.huongthuy.thick_appnote.Models.Notes;

@Dao
public interface DAO {
    @Insert(onConflict = REPLACE)
    void insert(Notes notes);
    @Update
    void update(Notes notes);
    @Query("SELECT * FROM notes ORDER BY id DESC")
    List<Notes> getAll();
    @Query("UPDATE notes SET tittle=:tittle, notes=:notes WHERE ID=:id")
    void update(int id, String tittle, String notes);
    @Delete
    void delete(Notes notes);

    @Query("UPDATE notes SET pinned=:pin WHERE ID=:id")
    void pin(int id,boolean pin);

}
