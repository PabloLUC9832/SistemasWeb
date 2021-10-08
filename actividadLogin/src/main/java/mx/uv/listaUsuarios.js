var tabla = [
    {usuario: "root",pass: "123"},
    {usuario: "qwe",pass: "987"}
];

//window.onload = mostrarTabla;
window.onload = mostrarTabla;

function cargarDatos(){
    document.getElementById("mostrar-tabla").addEventListener("click",mostrarTabla,false);
    document.getElementById("btnGuardar").addEventListener("click",nuevoUsuario,false);
}



function mostrarTabla(){
    var cuerpoTabla = document.getElementById("datos-tabla");
    var tablaLlena ="";
    //cuerpoTabla.innerHTML = "<tr><td>zzz</td><td>mnb</td></tr>";
    for(var i=0;i<tabla.length;i++){
        tablaLlena += "<tr><td>"+tabla[i].usuario+"</td><td>"+tabla[i].pass+"</td></tr>";
    }
    cuerpoTabla.innerHTML = tablaLlena;
}

function nuevoUsuario(event){
    event.preventDefault();
    var usuarioIn = document.getElementById("usuario").value;
    var passIn = document.getElementById("pass").value;
    var nuevo = {usuario: usuarioIn,pass: passIn}
    tabla.push(nuevo);
}