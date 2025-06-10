# Mapa zastávek PID
Mobilní android aplikace ukazuje na mapě zastávky Pražské Integrované dopravy. Když se klikne na zastávku, tak se zobrazí aktuální odjezdy.

## Zdroje dat a knihoven:
- Seznam zastávek získávám na [opendata.praha.eu](https://opendata.praha.eu/datasets/https%3A%2F%2Fapi.opendata.praha.eu%2Flod%2Fcatalog%2F6ac8381f-ea19-4ea9-8949-92076809dc5a) .
- Aktuální odjezdy spojů ze zastávek, získávám z [golemio.cz](https://golemio.cz/) - [Specifikace openapi](https://api.golemio.cz/pid/docs/openapi/#/) .
- Pro zobrazení map využívám knihovnu [maplibre native](https://maplibre.org/) .
- Mapové dlaždice získávám z [Maptiler](https://www.maptiler.com/) .

## Rozběhnutí aplikace ze zdrojového kódu
Pro rozběhnutí aplikace je nutné si vygenerovat token a style URL:
- Vygenerování tokenu pro získání PID dat: https://api.golemio.cz/api-keys/auth/sign-in
- Vytvoření style URL pro získávání dlaždic: https://cloud.maptiler.com/

Následně v `dev.chytac.map` adresáři je nutné vytvořit třídu `Env.class`, do které se dané hodnoty vloží:
```java
package dev.chytac.map;

public class Env {
    public static final String MAPTILER_URL = "<token>";
    public static final String PID_API_TOKEN = "<style-url>";
}
```