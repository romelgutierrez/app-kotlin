part of 'vaca_bloc.dart';

@immutable
abstract class VacaState {}

class ActividadInitialState extends VacaState {}
class ActividadLoadingState extends VacaState{}
class ActividadLoadedState extends VacaState{
  List<VacaModelo> ActividadList;
  ActividadLoadedState(this.ActividadList);
}
class ActividadError extends VacaState{
  Error e;
  ActividadError(this.e);
}
