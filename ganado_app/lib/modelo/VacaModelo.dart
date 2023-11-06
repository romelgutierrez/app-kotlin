
import 'package:json_annotation/json_annotation.dart';

@JsonSerializable()
class VacaModelo {
  VacaModelo({
    required this.id,
    required this.nombreVaca,
    required this.sexo,
    required this.fNacimiento,
    required this.raza,
    required this.narete,
  });
  VacaModelo.unlaunched();
  late final int id;
  late final String nombreVaca;
  late final String sexo;
  late final String fNacimiento;
  late final String raza;
  late final String narete;
  
 factory VacaModelo.fromJson(Map<String, dynamic> json){
    return VacaModelo(
    id : json['id'],
    nombreVaca : json['nombreVaca'],
    sexo : json['sexo'],
    fNacimiento : json['fNacimiento'],
    raza : json['raza'],
    narete : json['narete']
    );
  }

  Map<String, dynamic> toJson() {
    final _data = <String, dynamic>{};
    _data['id'] = id;
    _data['nombreVaca'] = nombreVaca;
    _data['sexo'] = sexo;
    _data['fNacimiento'] = fNacimiento;
    _data['raza'] = raza;
    _data['narete'] = narete;
    return _data;
  }
}