# Ejercicio-torneo
Ejercicio de torneo 


### Ejemplo de simular torneo
```
curl -X 'POST' \
  'http://198.148.116.202:9090/ejercicio-torneo/torneo/simular' \
  -H 'accept: */*' \
  -H 'Content-Type: application/json' \
  -d '{
  "jugadores": [
    {
        "nombre": "Pedro",
        "sexo": "MASCULINO",
        "habilidad": 15,
        "fuerza": 0.2,
        "velocidaddesplazamiento": 0.3
    },
    {
        "nombre": "Juan",
        "sexo": "MASCULINO",
        "habilidad": 20,
        "fuerza": 40.2, 
        "velocidaddesplazamiento": 26.3
    },
    {
        "nombre": "Luis",
        "sexo": "MASCULINO",
        "habilidad": 70,
        "fuerza": 0.2,
        "velocidaddesplazamiento": 1.3
    },
    {
        "nombre": "Jose",
        "sexo": "MASCULINO",
        "habilidad": 1,
        "fuerza": 0.2,
        "velocidaddesplazamiento": 90.3
    }
  ],
  "tipo": "MASCULINO",
  "Influencia de la suerte": 50,
  "Nombre": "Torneo Relampago"
}'
```
Documentacion Swagger:
http://198.148.116.202:9090/ejercicio-torneo/swagger-ui/index.html
