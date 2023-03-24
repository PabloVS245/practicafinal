# practicafinal
Práctica Pablo Vacas Salazar Formación Junior JAVA

1.- Descargar y descomprimir el archivo .zip
2.- Importar desde el IDE como Existing Maven Proyects
3.- Run As Java Aplication desde la clase main ProyectofinalApplication 
4.- BBDD en postgres, se incluyen ficheros estructura.sql y datos.sql en carpeta proyectofinal\src\main\resources
5.- Contenido del archivo aplication.properties para poder configurar correctamente la BBDD
            spring.datasource.driver-class-name=org.postgresql.Driver
            spring.datasource.username=postgres
            spring.datasource.password=postgres
            spring.datasource.url=jdbc:postgresql://localhost:5432/postgres
            spring.jpa.show-sql=true
            spring.jpa.properties.hibernate.format_sql=true
            #spring.datasource.url=jdbc:h2:mem:testdb
            #spring.datasource.driverClassName=org.h2.Driver
            #spring.datasource.username=sa
            #spring.datasource.password=password
            #spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
            #spring.jpa.hibernate.ddl-auto=none
            #spring.jpa.defer-datasource-initialization=true 
