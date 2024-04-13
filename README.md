# TALLER 8 - MICROSERVICIOS 
Presentamos una plataforma inspirada en Twitter que permite a los usuarios compartir publicaciones de hasta 140 caracteres en un flujo continuo. El sistema, que se desarrolló como un monolito Quarkus, se compone de entidades de usuario, hilo (stream) y publicaciones. Hemos creado una aplicación web que se desplega en Amazon S3 para una accesibilidad global al servicio. 

## EMPEZANDO

El proyecto contiene:
- Se tiene el siguiente directorio [src/main/java/org/acme](https://github.com/MPulidoM/Taller8_AREP/tree/main/src/main/java/org/acme)
  
  --> Tiene [Thread](https://github.com/MPulidoM/Taller8_AREP/tree/main/src/main/java/org/acme/Thread) Este código en Java implementa una API RESTful utilizando JAX-  
     RS, que ofrece dos funciones principales en la ruta "/Thread": "getThread()" para obtener publicaciones de un hilo de conversación desde una base de datos 
     MongoDB, y "addUserPost()" para agregar nuevas publicaciones. Utiliza la clase "ThreadCRUD" para interactuar con MongoDB, ofreciendo métodos para obtener y 
     agregar publicaciones.Proporciona una forma de ver y contribuir a un hilo de conversación almacenado en MongoDB a través de una API RESTful.

  --> Tiene [Publication](https://github.com/MPulidoM/Taller8_AREP/tree/main/src/main/java/org/acme/publication) Este código Java implementa una API RESTful en la     
      ruta "/publication", proporcionando cuatro métodos: "getPublication()" para obtener publicaciones de un usuario específico, "getPublicationArr()" para obtener 
      todas las publicaciones, "CreatePublication()" para agregar nuevas publicaciones y "DeletePublication()" para eliminar publicaciones. Utiliza la clase 
      "PublicationCRUD" para interactuar con MongoDB, facilitando las operaciones de agregar, obtener y eliminar publicaciones. La API ofrece a los 
      usuarios la capacidad de ver, agregar y eliminar publicaciones en una base de datos MongoDB a través de una interfaz RESTful.

  --> Tiene [User](https://github.com/MPulidoM/Taller8_AREP/tree/main/src/main/java/org/acme/user) Este código en Java es una API RESTful simple que opera en la ruta         "/user". Permite a los usuarios ver, agregar y eliminar usuarios en una base de datos MongoDB. Utiliza la clase "UserCRUD" para la interacción con la base de          datos.
  
- Se tienen los [Recursos](https://github.com/MPulidoM/Taller8_AREP/tree/main/src/main/resources/static) que contienen un HTML que utiliza JavaScript para interactuar con una API RESTful y permitir a los usuarios publicar mensajes en un hilo de conversación. La página tiene formularios para ingresar el nombre del usuario y el mensaje, y botones para enviar esta información al servidor. Después de enviar el mensaje, la página hace una solicitud para obtener el hilo de conversación actualizado y lo muestra.
  

## HERRAMIENTAS 
- [MAVEN](https://maven.apache.org) : Para el manejo de las dependecias.
  <p align="center">
  <IMG src=https://upload.wikimedia.org/wikipedia/commons/thumb/5/52/Apache_Maven_logo.svg/1280px-Apache_Maven_logo.svg.png height=150 width=250 >
    <p/>
- [GIT](https://git-scm.com) : Para el manejo de las versiones.
  <p align="center">
  <IMG src=https://logowik.com/content/uploads/images/git6963.jpg height=150 width=250 >
    <p/>
- [JAVA](https://www.java.com/es/) : Lenguaje de programación manejado.
  <p align="center">
  <IMG src=https://1000marcas.net/wp-content/uploads/2020/11/Java-logo.png height=150 width=250> 
  <p/>
- [AWS Academy](https://awsacademy.instructure.com/) : Para el uso de una máquina virtual.
  <p align="center">
  <IMG src=https://software.uniandes.edu.co/wp-content/uploads/2022/04/1500px_Academy_logo_HD.png height=150 width=200> 
  <p/>
- [DOCKER](https://www.docker.com/): Contenedor
  <p align="center">
   <IMG src=https://static-00.iconduck.com/assets.00/docker-icon-2048x1753-uguk29a7.png height=150 width=250> 
  <p/>
- [POSTMAN](https://www.postman.com/): Permite enviar solicitudes HTTP, inspeccionar respuestas, automatizar pruebas y colaborar en el desarrollo de APIs de manera eficiente. 
  <p align="center">
   <IMG src=https://uxwing.com/wp-content/themes/uxwing/download/brands-and-social-media/postman-icon.png height=150 width=250> 
  <p/>
# ARQUITECTURA

La arquitectura se basa en una API RESTful desarrollada en Java utilizando el framework JAX-RS. La API se comunica con una base de datos MongoDB para almacenar y recuperar datos.

La API tiene diferentes rutas o endpoint para realizar diferentes operaciones CRUD (Crear, Leer, Actualizar, Eliminar) en tres diferentes recursos: hilo de conversación, publicaciones y usuarios.

La ruta "/Thread" permite obtener las publicaciones de un hilo de conversación y agregar nuevas publicaciones al hilo. La clase ThreadCRUD se utiliza para interactuar con la base de datos MongoDB y realizar las operaciones CRUD correspondientes.

La ruta "/publication" permite obtener las publicaciones de un usuario específico, obtener todas las publicaciones, crear nuevas publicaciones y eliminar publicaciones. La clase PublicationCRUD se utiliza para interactuar con la base de datos MongoDB y realizar las operaciones CRUD correspondientes.

La ruta "/user" permite obtener la información de un usuario específico, crear nuevos usuarios y eliminar usuarios. La clase UserCRUD se utiliza para interactuar con la base de datos MongoDB y realizar las operaciones CRUD correspondientes.

Por otro lado, la página web HTML utiliza JavaScript para interactuar con la API RESTful y publicar mensajes en el hilo de conversación. La página web proporciona una interfaz de usuario fácil de usar y un estilo agradable.

La arquitectura y diseño de este  se basa en una API RESTful desarrollada en Java utilizando JAX-RS, que se comunica con una base de datos MongoDB para almacenar y recuperar datos. La API tiene diferentes rutas o endpoint para realizar operaciones CRUD en tres diferentes recursos: hilo de conversación, publicaciones y usuarios. La página web HTML utiliza JavaScript para interactuar con la API y publicar mensajes en el hilo de conversación.
  
  
# INSTALACIÓN 

+ Se clona el repositorio en una máquina local con el siguiente comando:
  ~~~
  git clone https://github.com/MPulidoM/Taller8_AREP.git
  ~~~
+ Entrar al directorio del proyecto con el siguiente comando:
  ~~~
  cd Taller8_AREP
  ~~~
+ Primero tenemos que abrir Docker y correr el siguiente comando para el contenedor de mongodb:
  ~~~
  docker run -d -p 27017:27017 --name mongodb mongo:latest
  ~~~
  ![imagen](https://github.com/MPulidoM/Taller8_AREP/assets/118181224/da39e0bb-7306-4137-892c-576fe971bfd0)

+ Compilamos y corremos el proyecto con el siguiente comando:
  ~~~
  mvn compile quarkus:dev
  ~~~
  ![imagen](https://github.com/MPulidoM/Taller8_AREP/assets/118181224/d6b4c42f-bc89-4a2f-85a0-3a1efb32c4cf)
  ![imagen](https://github.com/MPulidoM/Taller8_AREP/assets/118181224/199d3da8-9ad2-467e-93b7-ff6a256afe35)

# PRUEBAS 
## Local 
* Abrir en el navegador:
 ~~~
 http://localhost:8080/X.html
 ~~~
  ![imagen](https://github.com/MPulidoM/Taller8_AREP/assets/118181224/bbb15536-6d93-4817-a500-378f97d0cc2b)

+ Cuando el usuario no esta registrado:
  ![imagen](https://github.com/MPulidoM/Taller8_AREP/assets/118181224/95f4451f-6a61-4b74-bfcc-475fb8c79a32)

+ Para registrar el usuario:
  
  Entrar a postman y colocar la siguiente
  ~~~
  localhost:8080/user
  ~~~
  ![imagen](https://github.com/MPulidoM/Taller8_AREP/assets/118181224/a783f698-986f-4cb9-977a-13dc7b30e45f)
  
+ Cuando el usuario esta registrado:
  ![imagen](https://github.com/MPulidoM/Taller8_AREP/assets/118181224/a21efc71-3022-4f97-b1b8-af51b1d31a47)
   
## AWS 
## S3 
+ ¿Qué es S3? --> Un servicio de almacenamiento en la nube proporcionado por Amazon Web Services (AWS) se conoce como Amazon Simple Storage Service. Permite que las empresas almacenen y recuperen grandes cantidades de información de manera segura y escalable. S3 es una opción popular para una amplia gama de usos, incluido el almacenamiento de archivos, la copia de seguridad de datos, el alojamiento de sitios web estáticos y el almacenamiento de archivos multimedia, debido a su durabilidad y disponibilidad.
+ Se subió el html de la página y se publico: 
  <img width="960" alt="s3" src="https://github.com/MPulidoM/Taller8_AREP/assets/118181224/28794373-c41b-4cd2-b7d9-e51db9bc147c">
  
+ Quedo con la siguiente URL:
  ~~~
  https://tareaexperimental.s3.amazonaws.com/X.html
  ~~~
  <img width="960" alt="firefox_RybWZRAx3z" src="https://github.com/MPulidoM/Taller8_AREP/assets/118181224/21451da5-6615-4a94-8ad9-db40b872668c">

  <img width="960" alt="firefox_7016PJkF7o" src="https://github.com/MPulidoM/Taller8_AREP/assets/118181224/fcff1896-5ac8-4928-80f5-ad9117466c70">

## Amazon Cognito 
+ ¿Qué es Amazon Cognito? --> Se utiliza principalmente para permitir que los usuarios se autentiquen y autorizen en aplicaciones web y móviles.
   
+ Se configura el servicio de cognito y después nos da el siguiente link para entrar al login:
  ~~~
  https://apolo28.auth.us-east-1.amazoncognito.com/login?client_id=3jmpv1khnbt78qnhgpj922qleb&response_type=code&scope=email+openid+phone&redirect_uri=https%3A%2F%2Ftareaexperimental.s3.amazonaws.com%2FX.html
  ~~~
+ Para registrar podemos señalar lo siguiente:
  
  ![imagen](https://github.com/MPulidoM/Taller8_AREP/assets/118181224/eb027387-4814-4e9a-91c0-2fa5ffae401d)
  
+ Llenamos los datos:
  
  <img width="962" alt="registro" src="https://github.com/MPulidoM/Taller8_AREP/assets/118181224/ef006964-d511-4d2c-ac71-f4cf8bdb0306">
  
+ Nos pide verificar el correo, entonces nos llegara un correo con el código:
  
  ![Imagen de WhatsApp 2024-04-12 a las 17 26 05_1923a69c](https://github.com/MPulidoM/Taller8_AREP/assets/118181224/125d27b5-f32e-4246-8e34-a121d4b71d9d)
+ Colocamos el código:
  
  <img width="962" alt="verificar" src="https://github.com/MPulidoM/Taller8_AREP/assets/118181224/ac5d81e4-b02e-4d45-b559-4038a3b2bb28">
  
+ Después del registrarse aparece la página:
  
  <img width="962" alt="abrio" src="https://github.com/MPulidoM/Taller8_AREP/assets/118181224/235a9354-394e-47d8-b77a-b26e040c5d59">
  
+ Cuando el usuario esta registrado:
  
  ![imagen](https://github.com/MPulidoM/Taller8_AREP/assets/118181224/1afb7ac2-68d1-48bd-8730-3b579038081f)

+ Después del entrar aparece la página:
  
  <img width="962" alt="abrio" src="https://github.com/MPulidoM/Taller8_AREP/assets/118181224/235a9354-394e-47d8-b77a-b26e040c5d59">

# VIDEO : 
[VIDEO AWS](https://youtu.be/P1CYymrkMd0)

## TAREA EXPERIMENTAL - CONCLUSIÓN DE ALCANCE

La separación de un monolito en microservicios y su implementación en AWS Lambda puede añadir complejidad al sistema, lo que potencialmente dificultaría su gestión y mantenimiento, especialmente para aquellos no familiarizados con esta arquitectura. Además, los problemas de compatibilidad entre los servicios de AWS y el código de la aplicación podrían surgir, planteando desafíos significativos para su resolución. Asimismo, los riesgos de seguridad son una preocupación importante. Por ejemplo, la implementación de seguridad mediante JWT a través de AWS Cognito, junto con el despliegue del servicio en AWS Lambda, podría exponer al sistema a vulnerabilidades si no se ejecutan correctamente los controles de validación del token JWT. Del mismo modo, una función AWS Lambda mal protegida podría ser vulnerable a accesos no autorizados. 

- Las cuentas de estudiante de AWS tienen limitaciones en términos de recursos disponibles, como la cantidad de instancias de computación, almacenamiento y ancho de banda. Estas limitaciones pueden afectar el rendimiento y la escalabilidad de la aplicación, lo que puede ser un problema al implementar JWT en una aplicación que requiere autenticación

# REFERENCIAS 

- Akkaya, C. (2023, Septiembre). Amazon Cognito-1: Creating Cognito User Pools for authentication, and Connecting to an Application by using it. Medium; Medium. https://cmakkaya.medium.com/amazon-cognito-1-creating-cognito-user-pools-for-authentication-and-connecting-to-an-application-99f8c5388205

- AWS | Almacenamiento de datos seguro en la nube (S3). (2023). Amazon Web Services, Inc. https://aws.amazon.com/es/s3/
  
- Amazon Cognito | Amazon Web Services (1:27). (2023). Amazon Web Services, Inc. https://aws.amazon.com/es/cognito/
‌
# AUTORES 
Mariana Pulido Moreno [MPulidoM](https://github.com/MPulidoM)

Erika Juliana Castro Romero [Juc28](https://github.com/Juc28)


