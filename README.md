# Widget Metereologico
E' un applicativo basato su Java Spring Boot.
Al momento è presente solo il readme che stai leggendo e un file .gitignore, che spiega a git cosa ignorare quando deve committare, 
in questo caso gli ho detto di ignorare il contenuto della cartella idea (che son file di sistema dell'IDE) e la cartella target con il
suo contenuto, che nei progetti Spring ospita i file di costruzione del jar.

## Step 1
Per il primo passaggio, occorrerà creare un applicativo Spring base, con un singolo endpoint, **keepalive**.
L'endpoint keepalive resituirà 200 OK qualora riceva una chiamata REST (nello specifico una GET).

Ci servirà a valle del progetto per poter controllare il fatto che l'applicativo sia up & running.


## Step 2
- Creazione di una classe **Utility**
- Creazione di una classe **WeatherReport** tra i modelli che dovrà essere una replica della struttura del json ottenuto 
- Creazione, al suo interno, di un metodo **WeatherReport getWeatherReport (String url)** a cui passare l'url per la chiamta REST a OpenWeather
- Il metodo **getWeatherReport()** si occuperà di fare la chiamata rest vera e propria, vedi https://www.baeldung.com/rest-template (vedi capitolo *3.1. Get Plain JSON*)
- Creazione del metodo **String readableWeather(WeatherReport wp)**
- Creazione di un nuovo endpoint **weatherReport**, copiato da keepalive, che al suo interno istanzierà l'url da chiamare in una stringa, passerà la stringa a **getWeatherReport()**, getWeatherReport creerà un oggetto di tipo WeatherReport che passerà a **readableWeather()**, readableWeather genererà una stringa che mettermo al posto dell'OK che resistuisce keepalive
``` java
    @RequestMapping("/weatherReport")
    @ResponseBody
    public String weatherReport(){
        logger.info("weatherReport");
        String lat = "45.4071293";
        String lon = "9.0748545";
        String appId = "******************************"; 
        String url = "https://api.openweathermap.org/data/2.5/weather?lat="+lat+"&lon="+lon+"&units=metric&lang=it&appid="+appId+"";
        return readableWeather(Utility.getWeatherReport(url));
    }
```    
## Step 3
Chiamato l'endpoint **weatherReport** voglio ottenere qualcosa del tipo
```    
Controllo tempo atmosferico per Via Privata Varallo 1:
	Temperatura: 17.79° (15.24°-19.49°)
	Condizione:  Nubi sparse
	Umidità:     85%
	Alba:        07:52:19
	Tramonto:    18:21:42
```    

## Json Structure
Puoi controllare qui https://openweathermap.org/current

``` json   
{
    "coord": {
        "lon": 9.0749,
        "lat": 45.4071
    },
    "weather": [
        {
            "id": 802,
            "main": "Clouds",
            "description": "nubi sparse",
            "icon": "03n"
        }
    ],
    "base": "stations",
    "main": {
        "temp": 18.06,
        "feels_like": 18.09,
        "temp_min": 15.36,
        "temp_max": 19.61,
        "pressure": 1019,
        "humidity": 83
    },
    "visibility": 10000,
    "wind": {
        "speed": 0.89,
        "deg": 99,
        "gust": 1.79
    },
    "clouds": {
        "all": 40
    },
    "dt": 1666730127,
    "sys": {
        "type": 2,
        "id": 84294,
        "country": "IT",
        "sunrise": 1666677169,
        "sunset": 1666714950
    },
    "timezone": 7200,
    "id": 3165198,
    "name": "Trezzano sul Naviglio",
    "cod": 200
}

```    
