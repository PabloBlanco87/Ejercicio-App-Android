# Ejercicio-App-Android
Ejercicio para asignatura Programación Multimedia y Dispositivos Móviles, Lenguaje Java:

Crea un nuevo proyecto con Android Studio, el cual contará con tres Activities, todas ellas deberán tener un Constraint Layout bien definido.

• Activity1: Tendrá una imagen de bienvenida y deberá estar formado por una imagen y 2 botones.
    o Boton 1: ir al activity 2
    o Boton 2: ir al activity 3
    
• Activity 2: Al iniciarse mostrará un Toast informando de en qué Activity nos encontramos, está tendrá 4 botones:
    o Crear tabla.
    o Insertar datos
    o Consultar datos.
    o Volver al activity 1 (realizar las acciones pertinentes).
    
(Estas acciones las podéis personalizar a vuestro gusto para que realicen lo deseado, por ejemplo, podéis mostrar un nuevo Activity donde pedir datos al usuario, poner un TextEdit del que recoger los datos, etc.).

• Activity 3: Contendrá 3 botones, el 1ro creará un nuevo servicio, el segundo lo detendrá y el tercero podrá volver a la Activity 1:
    o En la creación del nuevo servicio, este podrá recibir 3 acciones diferentes
      1. Iniciar reproducción de música
      2. Detener reproducción de música
      3. Bloquearse durante 150000ms, (Thread.sleep(150000)).
