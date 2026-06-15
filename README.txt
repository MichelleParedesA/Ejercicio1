PRUEBA TÉCNICA SOFKA
EJERCICIO #1
AUTOMATIZACIÓN E2E CON SERENITY BDD

AUTORA:
Michelle Estefanía Paredes Almachi

DESCRIPCIÓN:
Este proyecto contiene una prueba funcional automatizada E2E sobre la página https://www.demoblaze.com

La automatización realiza el flujo de compra solicitado:
1. Agregar dos productos al carrito.
2. Visualizar el carrito.
3. Completar el formulario de compra.
4. Finalizar la compra.

TECNOLOGÍAS UTILIZADAS:
- Java 17
- Maven
- Serenity BDD
- Selenium WebDriver
- JUnit 4
- Google Chrome

REQUISITOS PREVIOS:
- Tener Java JDK 17 instalado.
- Tener Maven instalado.
- Tener Google Chrome instalado.
- Tener Git instalado.
- Tener acceso a internet.

PASOS PARA EJECUTAR:

1. Clonar el repositorio:

git clone https://github.com/MichelleParedesA/sofka-demoblaze-serenity.git

2. Ingresar a la carpeta del proyecto:

cd sofka-demoblaze-serenity

3. Verificar versión de Java:

java -version

Debe mostrar Java 17.

4. Verificar versión de Maven:

mvn -version

Debe mostrar que Maven está usando Java 17.

5. Si Maven muestra Java 8, ejecutar en PowerShell:

$env:JAVA_HOME="C:\Program Files\Java\jdk-17"
$env:Path="$env:JAVA_HOME\bin;$env:Path"

6. Ejecutar nuevamente:

java -version
mvn -version

7. Ejecutar la prueba automatizada:

mvn clean verify serenity:aggregate

8. Al finalizar, la consola debe mostrar:

BUILD SUCCESS

9. Abrir el reporte generado por Serenity en:

target/site/serenity/index.html

FLUJO AUTOMATIZADO:

1. Ingresar a https://www.demoblaze.com
2. Seleccionar "Samsung galaxy s6".
3. Agregar el producto al carrito.
4. Aceptar alerta de confirmación.
5. Regresar al inicio.
6. Seleccionar "Nokia lumia 1520".
7. Agregar el producto al carrito.
8. Aceptar alerta de confirmación.
9. Ingresar al carrito.
10. Validar que ambos productos estén visibles.
11. Hacer clic en "Place Order".
12. Completar el formulario de compra.
13. Hacer clic en "Purchase".
14. Validar el mensaje "Thank you for your purchase!".

RESULTADO ESPERADO:

La prueba debe ejecutarse correctamente, finalizar la compra y mostrar el mensaje de confirmación:

"Thank you for your purchase!"

REPORTE:

El reporte HTML de Serenity se genera en:

target/site/serenity/index.html