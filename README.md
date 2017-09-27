# geoquiz_api_core

## BBDD

Necesitaremos tener [Docker CE](https://docs.docker.com/engine/installation/linux/docker-ce/ubuntu/) 
y [Docker Compose](https://docs.docker.com/compose/install/) instalado en el portátil. 

Descargamos el [archivo de configuración](https://raw.githubusercontent.com/diegofpb/geoquiz_api_core/master/docker-compose.yml?token=ALFHWmnzGynejE1qXl2ld4LS8NdZ-Z31ks5Z1O__wA%3D%3D)
para Docker Compose y lo guardamos en la carpeta que queramos con el nombre _docker-compose.yml_.
Navegamos hasta esa carpeta y ejecutamos:

```bash
docker-compose up -d
```
Es recomendable incluir nuestro usuario en el grupo docker para no tener que utilizar ```sudo``` cada vez que queramos utilizar
Docker. Para ello:
  * Añadimos nuestro usuario al grupo docker
    ```bash
    sudo usermod -aG docker ${USER}
    ```
  * Actualizamos grupos a los que perterene el usuario
    ```bash
    su - ${USER}
    ```
  * Comprobamos que pertenecemos al grupo docker
    ```bash
    id -nG
    ```

Si queremos conectarnos a la Base de Datos, la IP sería ```127.0.0.1:7777```, el usuario es ```geoquiz``` 
y la contraseña es ```geoquiz```.
