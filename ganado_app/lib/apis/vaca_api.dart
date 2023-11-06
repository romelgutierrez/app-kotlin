import 'package:asistencia_app/modelo/VacaModelo.dart';
import 'package:asistencia_app/util/UrlApi.dart';
import 'package:dio/dio.dart';
import 'package:pretty_dio_logger/pretty_dio_logger.dart';
import 'package:retrofit/http.dart';

part 'vaca_api.g.dart';
@RestApi(baseUrl: UrlApi.urlApix)
abstract class VacaApi {
  factory VacaApi(Dio dio, {String baseUrl}) = _VacaApi;

  static VacaApi create() {
    final dio = Dio();
    dio.interceptors.add(PrettyDioLogger());
    return VacaApi(dio);
  }

   @GET("/asis/vaca/list")
  Future<List<VacaModelo>> getVaca(@Header("Authorization") String token);
  @POST("/asis/vaca/crear")
  Future<VacaModelo> crearVaca(@Header("Authorization") String token, @Body() VacaModelo vaca);

  @GET("/asis/vaca/buscar/{id}")
  Future<VacaModelo> findVaca(@Header("Authorization") String token, @Path("id") int id);

  @DELETE("/asis/vaca/eliminar/{id}")
  Future<VacaModelo> deleteVaca(@Header("Authorization") String token, @Path("id") int id);

  @PUT("/asis/vaca/editar/{id}")
  Future<VacaModelo> updateVaca(@Header("Authorization") String token, @Path("id") int id , @Body() VacaModelo vaca);
  
}