package mx.uv;

import static spark.Spark.*;
import com.google.gson.*;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args ){

        options("/*", (request, response) -> {

            String accessControlRequestHeaders = request.headers("Access-Control-Request-Headers");
            if (accessControlRequestHeaders != null) {
                response.header("Access-Control-Allow-Headers", accessControlRequestHeaders);
            }

            String accessControlRequestMethod = request.headers("Access-Control-Request-Method");
            if (accessControlRequestMethod != null) {
                response.header("Access-Control-Allow-Methods", accessControlRequestMethod);
            }

            return "OK";
        });

        before((request, response) -> response.header("Access-Control-Allow-Origin", "*"));

        System.out.println("Hola Mundo");

        get("/registro",(rq,rs)->{
            
            return "A";
        });

        post("/datos",(rq,rs)->{
            
            String request = rq.body();
            System.out.println("Request:"+request);
            String msj = null;
            JsonParser parser = new JsonParser();
            JsonElement arbol = parser.parse( request );
            JsonObject peticion = arbol.getAsJsonObject();

            Object usuario =  peticion.get("usuario") ;
            return "HOlA" + usuario +"";
        });

        get("/datos",(rq,rs)->{
            JsonObject respuesta = new JsonObject();
            respuesta.addProperty("usuario", rq.queryParams("usuario"));
            respuesta.addProperty("access", "granted");
            respuesta.addProperty("time", 31312321);
            return respuesta;
        });
    }
}
