package pe.edu.upeu.asistenciaupeujc.ui.presentation.screens.evento

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import pe.edu.upeu.asistenciaupeujc.modelo.Actividad
import pe.edu.upeu.asistenciaupeujc.modelo.Evento
import pe.edu.upeu.asistenciaupeujc.repository.ActividadRepository
import pe.edu.upeu.asistenciaupeujc.repository.EventoRepository
import javax.inject.Inject

@HiltViewModel
class EventoFormViewModel @Inject constructor(
    private val eventRepo: EventoRepository,
    savedStateHandle: SavedStateHandle
) : ViewModel(){
    private val _isLoading: MutableLiveData<Boolean> by lazy {
        MutableLiveData<Boolean>(false)
    }

    fun getEvento(idX: Long): LiveData<Evento> {
        return eventRepo.buscarEventoId(idX)
    }

    val isLoading: LiveData<Boolean> get() = _isLoading


    fun addEvento(evento: Evento){
        viewModelScope.launch (Dispatchers.IO){
            Log.i("REAL", evento.toString())
            eventRepo.insertarEvento(evento)
        }
    }
    fun editEvento(evento: Evento){
        viewModelScope.launch(Dispatchers.IO){
            eventRepo.modificarRemoteEvento(evento)
        }
    }
}