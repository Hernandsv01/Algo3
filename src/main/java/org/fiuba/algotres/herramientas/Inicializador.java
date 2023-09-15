package org.fiuba.algotres.herramientas;

import org.fiuba.algotres.Jugador;
import org.fiuba.algotres.Pokemon;
import org.fiuba.algotres.Tipos;

import javax.print.attribute.standard.PrinterMakeAndModel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Inicializador {

    /***********************************************/
    /*************POKEMONS DE RED******************/
    /***********************************************/
    Pokemon Squirtle = new Pokemon(
            "Squirtle",
            5,
            Tipos.AGUA,
            "Cuando retrae su largo cuello en el caparazón, dispara agua a una presión increíble.",
            44,
            44,
            43,
            65,
            48,
            null
    );

    Pokemon Pikachu = new Pokemon(
            "Pikachu",
            4,
            Tipos.ELECTRICO,
            "Cuando se enfada, este Pokémon descarga la energía que almacena en el interior de las bolsas de las mejillas.",
            35,
            35,
            90,
            40,
            45,
            null
    );

    Pokemon Abra = new Pokemon(
            "Abra",
            6,
            Tipos.PSIQUICO,
            "Es capaz de usar sus poderes psíquicos aun estando dormido. Al parecer, el contenido del sueño influye en sus facultades.",
            25,
            25,
            90,
            15,
            20,
            null
    );

    Pokemon Ekans = new Pokemon(
            "Ekans",
            4,
            Tipos.VENENO,
            "La longitud de este Pokémon aumenta con el tiempo. Por la noche, se enrosca en las ramas de los árboles para descansar.",
            35,
            35,
            55,
            44,
            60,
            null
    );

    Pokemon Pinsir = new Pokemon(
            "Pinsir",
            7,
            Tipos.BICHO,
            "Los Pinsir se juzgan entre ellos por la robustez de la cornamenta. Cuanto más imponente sea, más agradará a sus congéneres del sexo opuesto.",
            65,
            65,
            85,
            100,
            125,
            null
    );

    Pokemon Eevee = new Pokemon(
            "Eevee",
            4,
            Tipos.NORMAL,
            "Es capaz de evolucionar de muchas maneras para adaptarse sin problemas a cualquier medio.",
            55,
            55,
            55,
            50,
            55,
            null
    );

    ArrayList<Pokemon> PokemonsRed = new ArrayList<Pokemon>(Arrays.asList(
            Squirtle,
            Pikachu,
            Abra,
            Ekans,
            Eevee,
            Pinsir
    ));

    /**************JUGADOR RED*********************/


    /***********************************************/
    /*************POKEMONS DE BLUE******************/
    /***********************************************/

    Pokemon Charmander = new Pokemon(
            "Charmander",
            5,
            Tipos.FUEGO,
            "Prefiere las cosas calientes. Dicen que cuando llueve le sale vapor de la punta de la cola.",
            39,
            39,
            65,
            43,
            52,
            null
    );

    Pokemon Mankey = new Pokemon(
            "Mankey",
            6,
            Tipos.LUCHA,
            "Vive en grupos en las copas de los árboles. Si pierde de vista a su manada, se siente solo y se enfada.",
            40,
            40,
            70,
            35,
            80,
            null
    );

    Pokemon Tauros = new Pokemon(
            "Tauros",
            7,
            Tipos.NORMAL,
            "Cuando elige una presa, embiste sin pensárselo. Este Pokémon es famoso por su carácter violento.",
            75,
            75,
            110,
            95,
            100,
            null
    );

    Pokemon Chikorita = new Pokemon(
            "Chikorita",
            4,
            Tipos.PLANTA,
            "Al luchar, Chikorita agita la hoja que tiene para mantener a raya al rival. Pero, al mismo tiempo, libera una suave fragancia que apacigua el encuentro y crea un ambiente agradable y de amistad.",
            45,
            45,
            45,
            65,
            49,
            null
    );

    Pokemon Dratini = new Pokemon(
            "Dratini",
            3,
            Tipos.DRAGON,
            "Durante la etapa de crecimiento, muda muchas veces de piel y se protege mediante una cascada.",
            41,
            41,
            50,
            45,
            64,
            null
    );

    Pokemon Diglett = new Pokemon(
            "Diglett",
            3,
            Tipos.TIERRA,
            "Vive 1 m por debajo del suelo, donde se alimenta de raíces. A veces también aparece en la superficie.",
            10,
            10,
            95,
            25,
            55,
            null
    );

    ArrayList<Pokemon> PokemonsBlue = new ArrayList<Pokemon>(Arrays.asList(
            Charmander,
            Mankey,
            Tauros,
            Chikorita,
            Dratini,
            Diglett
    ));

    /**************JUGADOR BLUE*********************/

}
