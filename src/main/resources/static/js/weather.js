$(document).ready(function () {
    $.get(
        "http://api.openweathermap.org/data/2.5/weather",
        {
            "q":"Kazan",
            "appid":"56fc6c6cb76c0864b4cd055080568268",
        },

        function (data) {
            let out = '';
            out +='Kazan '+'<p style="text-align:center"><img src="https://openweathermap.org/img/w/'+data.weather[0].icon + '.png"></p>';
            out += 'Погода: <b>'+data.weather[0].main+'</b><br>';
            out += 'Температура: <b>'+Math.round(data.main.temp-273) + 'C</b><br>';
            out += 'Влажность: <b>'+data.main.humidity+'%</b><br>';
            out += 'Видимость: <b>' + (data.visibility/1000)+'км</b><br>';
            console.log(data.main);
            $('#weather').html(out);

        }
    );
})
