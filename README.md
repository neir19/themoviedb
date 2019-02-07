+  # themoviedb
-------------------

+  # BLOQUES
----------
 # Modelos.
- Movie: es la clase encargada de modelar la vista entregada por moviedb.

- Result: es laclase encargada de modela  cada película

- CustomAdapter: genera laconexión de los datos con el Recyclerview.

- ResultSQLiteHelper: datea la tablas.

# VIew.
- TopFragment,UpcomingFragment,PopularFragment: Muestra en pantalla cada una de sus categorias

- SplashActivity: muestra imagen con el logo de la pagina por un breve instante al inciar la app, dandole paso al mainActivity

- ViewActivity: mediante un intent muestra los detallas de la película seleccionada

- MainActivity: escoge que fragment mostrar según  sea necesario 

# VIewModel
- MyViewmodel: encargado de hacer la llamada al servidor y mostrar en cada view respectivamente los datos, mediante el recyclerview, llamar viewActivit cuando se presione algún elemento de recylcer view y hacer la paginación.

- DataViewmodel: encargado de almacenar en un arreglo los results de cada pagina de moviesdb para así mostrarlo en el recyclerview  al hacer paginación

- CreateTableViewmodel: encargado de ir almacenando en la tabla de SQlite y crear el listado de los datos dentro de la tabla (me generó error)

# Service
- RetrofitClientInstance : mediante la libreria retrofit llamaal json para ser utilizado en la app.

-GetDataService: interfaz con las funciones que llaman los diferentes servicios del json.


# Preguntas:
--------------------

-  En qué consiste el principio de responsabilidad única? Cuál es su propósito?:
es un principiode programación orientada a objetos que consiste en que cada clase debe tener una única resposabilidad y su  proposito es generar un codigo en el cual no se tenga un monton de codigo en una misma parte y así pueda sermás flexible y entendible

- Qué características tiene, según su opinión, un “buen” código o código limpio?:

-conciso así evitar procesos inenecesarios ni redundantes,fácil de entender se deben delegar responsabilidades para así entender con mayor facilidad que hace que

