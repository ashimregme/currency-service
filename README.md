# Currency Service

## About

Microservice that collects exchange rates of currencies from NBP's (National Bank of Poland) website http://api.nbp.pl/en.html.

This service can receive sell exchange rate, expressed in the PLN currency, for the given currency and the date of publication of the exchange rate table by the NBP. Also, the collected rates are cached in local database (PostgreSQL). So, the service only returns data to the client if all data from NBP was firstly persisted in the local database.

Moreover, the service can calculate the total purchasing cost in PLN of given list of foreign currencies for a particular date. The request contains a list of foreign currencies in format of three-letter currency code (ISO 4217 format). The total cost in PLN is recalculated using middle exchange rate of currencies.

## Dependencies

- Spring Boot
- Maven
- Redis
- PostgreSQL