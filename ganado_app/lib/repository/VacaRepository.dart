import 'package:asistencia_app/apis/vaca_api.dart';
import 'package:asistencia_app/modelo/VacaModelo.dart';
import 'package:asistencia_app/modelo/GenericModelo.dart';
import 'package:asistencia_app/util/TokenUtil.dart';
import 'package:dio/dio.dart';
class VacaRepository {
  VacaApi? vacaApi;

  VacaRepository() {
    Dio _dio = Dio();
    _dio.options.headers["Content-Type"] = "application/json";
    vacaApi = VacaApi(_dio);
  }

  Future<List<VacaModelo>> getVaca() async {
    var dato = await vacaApi!.getVaca(TokenUtil.TOKEN).then((
        value) => value);
    return await dato;
  }

  Future<GenericModelo> deleteVaca(int id) async {
    return await vacaApi!.deleteVaca(TokenUtil.TOKEN, id);
  }

  Future<VacaModelo> updateVaca(int id,
      VacaModelo vaca) async {
    return await vacaApi!.updateVaca(TokenUtil.TOKEN, id, vaca);
  }

  Future<VacaModelo> createVaca(VacaModelo vaca) async {
    return await vacaApi!.crearVaca(TokenUtil.TOKEN, vaca);
  }
}