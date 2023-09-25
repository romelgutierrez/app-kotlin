package pe.edu.upeu.asistenciaupeujc.repository

import android.util.Log
import androidx.lifecycle.LiveData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

import pe.edu.upeu.asistenciaupeujc.data.local.dao.EventoDao

import pe.edu.upeu.asistenciaupeujc.data.remote.RestEvento
import pe.edu.upeu.asistenciaupeujc.modelo.Actividad

import pe.edu.upeu.asistenciaupeujc.modelo.Evento
import pe.edu.upeu.asistenciaupeujc.utils.TokenUtils
import javax.inject.Inject

interface EventoRepository {

    suspend fun deleteEvento(evento: Evento)
    fun reportarEventos(): LiveData<List<Evento>>

    fun buscarEventoId(id:Long): LiveData<Evento>

    suspend fun insertarEvento(evento: Evento):Boolean

    suspend fun modificarRemoteEvento(evento: Evento):Boolean
}

class EventoRepositoryImp @Inject constructor(
    private val restEvento: RestEvento,
    private val eventoDao: EventoDao
):EventoRepository{
    override suspend fun deleteEvento(evento: Evento){
        CoroutineScope(Dispatchers.IO).launch {
            restEvento.deleteEvento(TokenUtils.TOKEN_CONTENT,evento.id)
        }
        eventoDao.eliminarEvento(evento)
    }


    override fun reportarEventos():LiveData<List<Evento>>{
        try {
            CoroutineScope(Dispatchers.IO).launch{
                delay(3000)
                val data=restEvento.reportarEvento(TokenUtils.TOKEN_CONTENT).body()!!
                eventoDao.insertarEventos(data)
            }
        }catch (e:Exception){
            Log.i("ERROR", "Error: ${e.message}")
        }
        return eventoDao.reportatEvento()
    }

    override fun buscarEventoId(id:Long):LiveData<Evento>{
        return  eventoDao.buscarEvento(id)
    }

    override suspend fun insertarEvento(evento: Evento):Boolean{
        return restEvento.insertarEvento(TokenUtils.TOKEN_CONTENT, evento).body()!=null
    }

    override suspend fun modificarRemoteEvento(evento: Evento):Boolean{
        var dd:Boolean=false
        CoroutineScope(Dispatchers.IO).launch {
            Log.i("VER", TokenUtils.TOKEN_CONTENT)
        }
        return restEvento.actualizarEvento(TokenUtils.TOKEN_CONTENT, evento.id, evento).body()!=null
    }

}