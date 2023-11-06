import 'dart:async';

import 'package:asistencia_app/modelo/VacaModelo.dart';
import 'package:asistencia_app/repository/VacaRepository.dart';
import 'package:bloc/bloc.dart';
import 'package:meta/meta.dart';

part 'vaca_event.dart';
part 'vaca_state.dart';

class VacaBloc extends Bloc<VacaEvent, VacaState> {
  late final VacaRepository _actividadRepository;
  VacaBloc(this._actividadRepository) : super(ActividadInitialState()) {
    on<VacaEvent>((event, emit) async{
      // TODO: implement event handler
      print("Bloc x");
      if(event is ListarActividadEvent){
        emit(ActividadLoadingState());
        try{
          print("pasox!!");
          List<VacaModelo> PersonaList= await _actividadRepository.getVaca();
          emit(ActividadLoadedState(PersonaList));
        } catch(e){
          emit(ActividadError(e as Error)) ;
        }
      }else if(event is DeleteActividadEvent){
        try{
          await _actividadRepository.deleteVaca(event.actividad!.id);
          emit(ActividadLoadingState());
          List<VacaModelo> PersonaList= await _actividadRepository.getVaca();
          emit(ActividadLoadedState(PersonaList));
        }catch(e){
          emit(ActividadError(e as Error));
        }
      }else if(event is CreateActividadEvent){
        try{
          await _actividadRepository.createVaca(event.actividad!);
          emit(ActividadLoadingState());
          List<VacaModelo> PersonaList= await _actividadRepository.getVaca();
          emit(ActividadLoadedState(PersonaList));
        }catch(e){
          emit(ActividadError(e as Error));
        }
      }else if(event is UpdateActividadEvent){
        try{
          await _actividadRepository.updateVaca(event.actividad!.id, event.actividad!);
          emit(ActividadLoadingState());
          List<VacaModelo> PersonaList= await _actividadRepository.getVaca();
          emit(ActividadLoadedState(PersonaList));
        }catch(e){
          emit(ActividadError(e as Error));
        }
      }
    });
  }
}
