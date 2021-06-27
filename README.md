# AppAndroidLocal

App Android en ambiente local consumiendo un servicio web API rest desplegado en una maquina virtual

## Contenido

* Instalación del ambiente del web server en Ubuntu 16.04
* Despliegue del API en el servidor por medio del protocol FTP
* Comandos para correr API desde la terminal
* Crear base de datos mysql

### Instalación del Web Server en Ubuntu 16.04:

La instalación de Node js se realiza con el siguiente comando:

```
$ sudo apt-get install nodejs
```

Luego viene la instalación del administrador de paquetes npm:
```
$ sudo apt-get install npm
```
Por defecto, se instalará las siguientes versiones:
```
$ nodejs --version
v4.2.6
$ npm --version
3.5.2
```
Para el laboratorio que necesitamos hacer estas versiones son antiguas, lo cual significa no seran de utilidad, para actualizar a una versión mas reciente necesitamos realizar los siguientes pasos:

#### Usando el repositorio de PPA

A continuación, agregue el repositorio PPA:
```
$ sudo add-apt-repository -y -r ppa:chris-lea/node.js
```
```
$ sudo curl --silent https://deb.nodesource.com/gpgkey/nodesource.gpg.key | sudo apt-key add -
```

Establezca un número de versión de Node.js que desea instalar:
```
VERSION=node_12.x
```
```
DISTRO="$(lsb_release -s -c)"
```

Configure los repositorios de Node.js con los conjuntos anteriores:
```
$ sudo echo "deb https://deb.nodesource.com/$VERSION $DISTRO main" | sudo tee /etc/apt/sources.list.d/nodesource.list
```
```
$ sudo echo "deb-src https://deb.nodesource.com/$VERSION $DISTRO main" | sudo tee -a /etc/apt/sources.list.d/nodesource.list
```

En este punto, simplemente ejecute los siguientes apt-getcomandos para instalar Node.js:
```
$ sudo apt-get update
```
```
$ sudo apt-get install nodejs
```

Verifique que la version instalada de nodejs sea la version 12:
```
$ nodejs --version
```
```
$ npm --version
```

**Fuente de consulta:**
https://goto-linux.com/es/2020/4/18/como-instalar-node.js-en-ubuntu-16.04-xenial-xerus-linux-server/

### Despliegue del API en el servidor por medio del protocol FTP:
```
Herramienta empleada FTP zilla
```

### Comandos para correr API desde la terminal:

Luego de tener el proyecto nodejs desplegado en el servidor, procede la ejecución de los respectivos comandos.

**Nota:** Cuando instalamos nodejs en un servidor Linux, el servicio quedará con el nombre nodejs que entrará en conflicto con los comandos de ejecución, para solucionar esto, realizaremos un enlace simbolico.
```
$ sudo ln -s /usr/bin/nodejs /usr/bin/node
```

Ya de realizar el enlace simbolico, podremos ejecutar los comandos de node js desde la linea de comandos, lo primero es instalar el ambiente del proyecto:
```
$ npm install
```
**Nota:** el comando anterior descargara todas las librerias descriptas en el archivo package.json y los guardará en una nueva carpeta llamada node_modules(Esta carpeta no debe ser cargada al repositorio Git remoto).

Luego para poner a correr el servidor web, dejando el API disponible para ser consumida:
```
$ npm run dev
```


