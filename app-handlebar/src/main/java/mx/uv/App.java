package mx.uv;
import java.util.HashMap;
import java.util.Map;
//import static spark.Spark.*;
import spark.ModelAndView;
import spark.TemplateEngine;
import spark.template.handlebars.HandlebarsTemplateEngine;

import static spark.Spark.get;
/**
 * Hello world!
 *
 */
public class App {

    //private static Map<String,String> prueba = new HashMap<>();

    public static void main( String[] args ){

        System.out.println( "Hello World!" );
        Map<String,String> map = new HashMap<>();
        map.put("name", "Sam");

        // prueba
        get("/prueba", (rq, rs) -> new ModelAndView(map, "templates/ejemploHandle.hbs"),new HandlebarsTemplateEngine());
    }
}        
