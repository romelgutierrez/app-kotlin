package pe.edu.upeu.asistenciaupeujc.data.local.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import pe.edu.upeu.asistenciaupeujc.modelo.Evento


@Dao
interface EventoDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertarEvento(evento: Evento)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertarEventos(evento: List<Evento>)

    @Update
    suspend fun modificarEvento(evento: Evento)

    @Delete
    suspend fun eliminarEvento(evento: Evento)

    @Query("select * from evento")
    fun reportatEvento(): LiveData<List<Evento>>

    @Query("select * from evento where id=:idx")
    fun buscarEvento(idx: Long): LiveData<Evento>

}