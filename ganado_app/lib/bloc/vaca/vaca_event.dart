part of 'vaca_bloc.dart';

@immutable
abstract class VacaEvent {}
class ListarActividadEvent extends VacaEvent{
  ListarActividadEvent(){print("Evento si");}
//ListarActividadEvent({required ActividadModelo actividad}):super(actividad:actividad);
}
class DeleteActividadEvent extends VacaEvent{
  VacaModelo actividad;
  DeleteActividadEvent(this.actividad);
//DeleteActividadEvent({required ActividadModelo actividad}):super(actividad:actividad);
}
class UpdateActividadEvent extends VacaEvent{
  VacaModelo actividad;
  UpdateActividadEvent(this.actividad);
//UpdateActividadEvent({required ActividadModelo actividad}):super(actividad:actividad);
}
class CreateActividadEvent extends VacaEvent{
  VacaModelo actividad;
  CreateActividadEvent(this.actividad);
//CreateActividadEvent({required ActividadModelo actividad}):super(actividad:actividad);
}
