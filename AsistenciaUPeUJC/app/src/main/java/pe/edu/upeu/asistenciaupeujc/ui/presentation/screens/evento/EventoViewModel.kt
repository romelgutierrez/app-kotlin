package pe.edu.upeu.asistenciaupeujc.ui.presentation.screens.evento

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
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
class EventoViewModel @Inject constructor(
    private val eventRepo: EventoRepository,
) : ViewModel(){
    private val _isLoading: MutableLiveData<Boolean> by lazy {
        MutableLiveData<Boolean>(false)
    }
    val activ: LiveData<List<Evento>> by lazy {
        eventRepo.reportarEventos()
    }
    val isLoading: LiveData<Boolean> get() = _isLoading
    fun addEvento() {
        if (_isLoading.value == false)
            viewModelScope.launch (Dispatchers.IO) {
                _isLoading.postValue(true)
            }
    }

    fun deleteEvento(toDelete: Evento) {
        viewModelScope.launch(Dispatchers.IO) {
            Log.i("ELIMAR", toDelete.toString())
            eventRepo.deleteEvento(toDelete);
        }
    }

}