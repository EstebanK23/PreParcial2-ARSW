var app = (function () {
    var getAllCountries = function () {
        client.getAllCountries(getCountries);
    }
    var getCountries = function (countries) {
        alert(countries);
        $("#keywords tbody tr").remove();
        countries = JSON.parse(countries);
        countries = countries.data.covid19Stats;
        var muertes = new Map();
        var confirmado = new Map();
        var sano = new Map();
        var pais = [];
        
        countries.map(function(result){
            //alert("Entro map")
            var contenedor = "<tr><td class=\"lalign\">"+result.country+"</td><td>"+result.deaths+"</td><td>"+result.confirmed+"</td><td>"+result.recovered+"</td><td><button class='btn btn-primary'>Ver</button></td></tr>";
            $("#keywords tbody").append(contenedor);
        })
        
        
    }
    return {
        getAllCountries: getAllCountries,   
        getCountries: getCountries
    }
})();

