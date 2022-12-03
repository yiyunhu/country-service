To run the web service, execute the following command:

`./mvnw spring-boot:run`

If permission denied, please run `chmod +x mvnw` first, then run the command above.

The service will run on port 8080. You can change the port number in `CountryServiceApplication.java` by replacing `8080` with your designated port number. If you are running locally, open browser and put in URL [http://localhost:8080/countries](http://localhost:8080/countries), you can see a list of countries.

By searching for the details, say Finland, use the URL [http://localhost:8080/countries/Finland](http://localhost:8080/countries/Finland). And you can replace `Finland` with any country you want to query, and it supports both lower or higher case in English. 

Meantime, you can also access [http://localhost:8080/country/Finland](http://localhost:8080/country/Finlan) (or replace Finland with other countries) to see the HTML version of country information, which uses the `/countries/{name}` REST API.


![Example](example.png)
