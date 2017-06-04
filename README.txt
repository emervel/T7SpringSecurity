-----------------------------
Securitydemo
-----------------------------
proyecto simple de las funcionalidades out of the box que da spring para autentificacion y autorizacion
-Autentificacion: en el properties ponemos un usuario y contrasena para que pueda autenficarse
-Autorizacion: en el properties ponemos un rol al usuario y en los mapping @Secured("ROLE_ para saber que pueden acceder
Para poder usar esto tenemos que tener una clase de configuracion anotada como @EnableGlobalMethodSecurity(securedEnabled = true) para anadir anotaciones de seguridad a metodos de requets para asi dar o no autorizacion de acceso al recurso mapeado
esta puesta la ruta por defecto de login para que spring lo coja por defecto y no haya que configurarlo


-----------------------------
Securitydemob
-----------------------------
En este proyecto en lugar de usar la configuracion por defecto de seguridad la sobreescribimos, retocando la clase de configuracion anotada como @EnableGlobalMethodSecurity(securedEnabled = true) con:
1.Autentificacion con el metodo configureAuth: para crear usuarios en memoria en vez de en properties. Con esto podemos poner varios usuarios y asignarles roles
2.Autorizacion con el metodo configure: en vez de tener que securizar cada mapping podemos poner toda la configuracion de autorizacion aqui. Incluso se puede defir el login y el logout 


-----------------------------
Security-springdata
-----------------------------
Sobreescribe totalmente la seguridad de spring para que apliquen poner nuestra configuracion. Para hacer esto:

1.Crear una clase de configuracion que extienda de WebMvcConfigurerAdapter y que anada un registry.addViewController con maxima precedencia para decirle 
a Spring la vista a la que redigir /login

2.Crear una clase de configuracion que extienda de WebSecurityConfigurerAdapter y que sera donde implementemos la configuracion de seguridad:
	2.1 En el metodo configure estableceremos la informacion de autorizacion (a que urls pueden acceder cada rol) y las urls de login y logout
	2.2 En el metodo configureAuth le pasaremos a Spring el UserDetailsService que sera el que use para la informacion de usuario, pass, rol, etc

3.Crear las clases de servicio de usuarios
	3.1 La interfaz UserService que solo tiene los metodos de la interfaz (para diseno)
	3.2 La clase UserServiceImpl que implementa las interfaces
		- UserService: con un metodo para recuperar usando la clase de repositorio el usuario a partir de un mail. Esto en propio nuestro, no de spring
		y usara JPA para acceder a la bbdd de postresql para recuperar el POJO de usuario con toda la info que estaba almacenada en la BBDD
		- UserDetailsService: con el metodo loadUserByUsername que usa un valor de busqueda debe devolver un objeto de la UserDetails (le pasaremos al constructor nuestro objeto user)
	3.1 La clase UserDetailsImpl que implementa los metodos de UserDetails para que podamos sobrescribir los metodos de Spring. Le pasaremos al constructor 
	nuestro usuario bean y sobrescribimos los metodos para devolver en ellos la informacion de nuestro bean

		
