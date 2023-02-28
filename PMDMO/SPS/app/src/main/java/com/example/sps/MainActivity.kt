package com.example.sps

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import java.util.*

class MainActivity : AppCompatActivity(), OnFragmentActionsListener {

    private var ptsMaquina = 0
    private var ptsUsuario = 0
    private var eleccionMaquina: String = ""
    private var eleccionUsuario: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    override fun onClickFragmentButtonPiedra() {

        // declaracion de variables
        val imgUsuario = findViewById<ImageView>(R.id.imgUsuario)
        val imgMaquina = findViewById<ImageView>(R.id.imgMaquina)
        val puntosMaquina = findViewById<TextView>(R.id.puntosMaquina)
        val puntosUsuario = findViewById<TextView>(R.id.puntosUsuario)
        val random = Random()


        imgUsuario.setImageResource(R.drawable.piedra)
        eleccionUsuario = "piedra"
        eleccionMaquina = establecerImagenRandom(imgMaquina, random)
        incrementarPuntuacion(eleccionUsuario, eleccionMaquina, puntosUsuario, puntosMaquina)

    }

    override fun onClickFragmentButtonPapel() {
        val imgUsuario = findViewById<ImageView>(R.id.imgUsuario)
        val imgMaquina = findViewById<ImageView>(R.id.imgMaquina)
        val puntosMaquina = findViewById<TextView>(R.id.puntosMaquina)
        val puntosUsuario = findViewById<TextView>(R.id.puntosUsuario)
        val random = Random()

        imgUsuario.setImageResource(R.drawable.papel)
        eleccionUsuario = "papel"
        eleccionMaquina = establecerImagenRandom(imgMaquina, random)
        incrementarPuntuacion(eleccionUsuario, eleccionMaquina, puntosUsuario, puntosMaquina)
    }

    override fun onClickFragmentButtonTijeras() {
        val imgUsuario = findViewById<ImageView>(R.id.imgUsuario)
        val imgMaquina = findViewById<ImageView>(R.id.imgMaquina)
        val puntosMaquina = findViewById<TextView>(R.id.puntosMaquina)
        val puntosUsuario = findViewById<TextView>(R.id.puntosUsuario)
        val random = Random()

        imgUsuario.setImageResource(R.drawable.tijeras)
        eleccionUsuario = "tijeras"
        eleccionMaquina = establecerImagenRandom(imgMaquina, random)
        incrementarPuntuacion(eleccionUsuario, eleccionMaquina, puntosUsuario, puntosMaquina)
    }

    /**
     * Metodo que genera un numero aleatorio entre 1 y 3, segun el numero establece una imagen para la eleccion de la maquina segun el y devuelve una eleccion.
     *
     * Precondicion :
     *
     * Postcondicion : se setea una imagen.
     *
     * Parametros : imagen ImageView, random Random
     *
     * Returns : devuelve eleccionMaquina que es de tipo String
     */
    private fun establecerImagenRandom(imagen: ImageView, random: Random): String {

        val numRandom = random.nextInt(3) + 1 // genero un numero aleatorio entre 1 y 3
        val eleccionMaquina: String

        // este switch es para establecerle una "eleccion" a la maquina
        when (numRandom) {
            1 -> {
                eleccionMaquina = "piedra"
                imagen.setImageResource(R.drawable.piedra)
            }
            2 -> {
                eleccionMaquina = "papel"
                imagen.setImageResource(R.drawable.papel)
            }
            else -> {
                eleccionMaquina = "tijeras"
                imagen.setImageResource(R.drawable.tijeras)
            }
        }

        return eleccionMaquina
    }

    /**
     * Metodo que comprueba la eleccion de cada jugador para incrementar su puntuacion y comprobar quien es el ganador.
     *
     * Precondicion :
     *
     * Postcondicion : la puntuacion incrementa.
     *
     * Parametros : eleccionUsuario String, eleccionMaquina String, txtPuntosUsuario TextView, txtPuntosMaquina TextView
     *
     * Returns :
     */
    private fun incrementarPuntuacion(eleccionUsuario: String, eleccionMaquina: String, txtPuntosUsuario: TextView, txtPuntosMaquina: TextView) {

        // este bloque de condicionales es para comprobar si el usuario gana a la maquina
        if (eleccionUsuario == "papel" && eleccionMaquina == "piedra") {  // papel gana a piedra, incrementa la puntuacion del usuario

            ptsUsuario += 1
            txtPuntosUsuario.text = ptsUsuario.toString() // para que el TextView del usuario se actualice con la puntuacion correspondiente

        } else if (eleccionUsuario == "piedra" && eleccionMaquina == "tijeras") { // piedra gana a tijeras, incrementa la puntuacion del usuario

            ptsUsuario += 1
            txtPuntosUsuario.text = ptsUsuario.toString()

        } else if (eleccionUsuario == "tijeras" && eleccionMaquina == "papel") { // tijeras gana a papel, incrementa la puntuacion del usuario

            ptsUsuario += 1
            txtPuntosUsuario.text = ptsUsuario.toString()

        }

        // este bloque de condicionales es para comprobar si la maquina gana al usuario
        if (eleccionMaquina == "papel" && eleccionUsuario == "piedra") { // papel gana a piedra, incrementa la puntuacion de la maquina

            ptsMaquina += 1
            txtPuntosMaquina.text = ptsMaquina.toString() // para que el TextView del usuario se actualice con la puntuacion correspondiente

        } else if (eleccionMaquina == "piedra" && eleccionUsuario == "tijeras") { // piedra gana a tijeras, incrementa la puntuacion de la maquina

            ptsMaquina += 1
            txtPuntosMaquina.text = ptsMaquina.toString()

        } else if (eleccionMaquina == "tijeras" && eleccionUsuario == "papel") { // tijeras gana a papel, incrementa la puntuacion de la maquina

            ptsMaquina += 1
            txtPuntosMaquina.text = ptsMaquina.toString()

        }

        // llamada al metodo comprobarGanador() para que cada vez que se incremente la puntuacion se compruebe quien ha ganado
        comprobarGanador()
    }

    /**
     * Metodo que resetea los puntos y limpia las imagenes de eleccion tanto del jugador como de la maquina.
     *
     * Precondicion :
     *
     * Postcondicion : los puntos se setean a 0 y las imagenes se quedan vacias.
     *
     * Parametros :
     *
     * Returns :
     */
    private fun volverAJugar(){

        val puntosMaquina = findViewById<TextView>(R.id.puntosMaquina)
        val puntosUsuario = findViewById<TextView>(R.id.puntosUsuario)
        val imgUsuario = findViewById<ImageView>(R.id.imgUsuario)
        val imgMaquina = findViewById<ImageView>(R.id.imgMaquina)
        ptsMaquina = 0
        ptsUsuario = 0
        puntosUsuario.text = ptsUsuario.toString()
        puntosMaquina.text = ptsMaquina.toString()
        imgUsuario.setImageResource(0)
        imgMaquina.setImageResource(0)
    }

    /**
     * Metodo que crea una alerta para cuando gana el usuario
     *
     * Precondicion :
     *
     * Postcondicion : se crea la alerta
     *
     * Parametros :
     *
     * Returns : devuelve alertaUsuario que es de tipo AlertDialog.Builder
     */
    private fun crearAlertaUsuario(): AlertDialog.Builder {

        val alertaUsuario = AlertDialog.Builder(this) // para crear la alerta en caso de que gane el usuario

        alertaUsuario.create() // creo la alerta

        // propiedades de la alerta para cuando gane el usuario
        alertaUsuario.setMessage("¿Quieres volver a jugar?")
            .setNegativeButton("Salir") { dialogInterface, i -> finish() }
            .setPositiveButton("Jugar de nuevo") { dialogInterface, i -> volverAJugar() }

        alertaUsuario.setTitle("Has ganado") // establezco el titulo de la alerta

        alertaUsuario.setCancelable(false) // esta propiedad es para que el usuario no pueda interactuar con nada de "detras" de la app
        // es decir, solo puede interactuar con la alerta


        return alertaUsuario
    }

    /**
     * Metodo que crea una alerta para cuando gana la maquina
     *
     * Precondicion :
     *
     * Postcondicion : se crea la alerta
     *
     * Parametros :
     *
     * Returns : devuelve alertaMaquina que es de tipo AlertDialog.Builder
     */
    private fun crearAlertaMaquina(): AlertDialog.Builder {

        val alertaMaquina = AlertDialog.Builder(this) // para crear la alerta en caso de que gane la maquina

        alertaMaquina.create() // creo la alerta

        // propiedades de la alerta para cuando gane la maquina
        alertaMaquina.setMessage("¿Quieres volver a jugar?")
            .setNegativeButton("Salir") { dialogInterface, i -> finish()  }
            .setPositiveButton("Jugar de nuevo"){ dialogInterface, i -> volverAJugar() }

        alertaMaquina.setTitle("Ha ganado la maquina") // establezco el titulo de la alerta

        alertaMaquina.setCancelable(false) // esta propiedad es para que el usuario no pueda interactuar con nada de "detras" de la app
        // es decir, solo puede interactuar con la alerta

        return alertaMaquina
    }

    /**
     * Metodo que comprueba los puntos del usuario y de la maquina para decidir quien es el ganador del juego.
     *
     * Precondicion :
     *
     * Postcondicion : aparece una alerta diciendo quien ha ganado
     *
     * Parametros :
     *
     * Returns :
     */
    private fun comprobarGanador(){

        val alerta: AlertDialog.Builder

        if(ptsUsuario == 3){
            alerta = crearAlertaUsuario()
            alerta.show() // esta linea es para que se muestre la alerta del usuario
        }else if(ptsMaquina == 3){
            alerta = crearAlertaMaquina()
            alerta.show() // esta linea es para que se muestre la alerta de la maquina
        }
    }
}