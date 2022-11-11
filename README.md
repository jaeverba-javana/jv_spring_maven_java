# jv_spring_maven_java


## Cómo hacer el deploy

 1. Correr `npm run dev` para empacar el proyecto
 2. Comprobar si el enlace sinbólico de las carpetas funciona, sino, entonces copiar las carpetas
 3. Agregar los enlaces a los recursos de producción de vue
 4. Cambiar el puerto a de 8082 a 80
 5. Eliminar todas las claves api (hay que buscar una solución para eso)
 5. 1. com.jaeverba.jv.controller.send_in_blue.email.transactional
 6. Crear el archivo .jar
 7. Hacer el respectivo proceso con docker
 7. 1. `docker build -t jaeverba/jv:spring-0.3.0 .`
 7. 2. `docker run --name jv_spring.0.3.0_1 -p 80:8080 jaeverba/jv:spring-0.3.0`
 7. 3. `docker push jaeverba/jv:spring-0.3.0`

