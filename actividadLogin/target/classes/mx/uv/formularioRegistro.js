
var btnGuardar = document.getElementById("btnGuardar");
btnGuardar.addEventListener("click",function(){

    var params = new URLSearchParams();
    var usuario = document.getElementById("usuario").value;
    var pass = document.getElementById("pass").value;
    params.append("usuario", usuario);
    params.append("pass", pass);
    console.log("------")
    console.log("{" + "usuario:'" + params.get("usuario") + "'," + "pass:'" + params.get("pass") + "'}");
    axios.post("http://localhost:4567/datos",{"usuario:": params.get("usuario"),pass: params.get("pass") } )
        .then(function (rs){
            console.log(rs.data);                        
        })
        .catch(function(error){
            console.log(error);
        });        

    });