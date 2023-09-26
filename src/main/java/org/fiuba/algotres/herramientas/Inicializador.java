package org.fiuba.algotres.herramientas;

import org.fiuba.algotres.Juego;
import org.fiuba.algotres.Jugador;
import org.fiuba.algotres.Pokemon;
import org.fiuba.algotres.Tipos;
import org.fiuba.algotres.item.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Inicializador {

    public static Juego inicializarJuego() {

        /*************************************************************/
        /**********************POKEMONS JUGADOR 1*********************/
        /*************************************************************/
        Pokemon bulbasaur = new Pokemon(
                "Bulbasaur",
                5,
                Tipos.PLANTA,
                "Este Pokémon nace con una semilla en el lomo, que brota con el paso del tiempo.",
                45,
                44,
                45,
                49,
                49,
                null
        );
        Pokemon pikachu = new Pokemon(
                "Pikachu",
                4,
                Tipos.ELECTRICO,
                "Cuando se enfada, este Pokémon descarga la energía que almacena en el interior de las bolsas de las mejillas.",
                35,
                35,
                90,
                40,
                55,
                null
        );
        Pokemon abra = new Pokemon(
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
        Pokemon pidgey = new Pokemon(
                "Pidgey",
                3,
                Tipos.NORMAL,
                "Su docilidad es tal que suelen defenderse levantando arena en lugar de contraatacar.",
                40,
                40,
                56,
                40,
                45,
                null
        );
        Pokemon pinsir = new Pokemon(
                "Pinsir",
                3,
                Tipos.BICHO,
                "Los Pinsir se juzgan entre ellos por la robustez de la cornamenta. Cuanto más imponente sea, más agradará a sus congéneres del sexo opuesto.",
                65,
                65,
                85,
                100,
                125,
                null
        );
        Pokemon staryu = new Pokemon(
                "Staryu",
                5,
                Tipos.AGUA,
                "A finales de verano, se pueden ver grupos de Staryu en la orilla de la playa sincronizando el brillo de sus núcleos a ritmo regular.",
                30,
                30,
                85,
                55,
                45,
                null
        );
        ArrayList<Pokemon> pokemonsJugador1 = new ArrayList<Pokemon>(Arrays.asList(
                bulbasaur,
                pikachu,
                abra,
                pidgey,
                staryu,
                pinsir
        ));

        /*************************************************************/
        /**********************POKEMONS JUGADOR 2*********************/
        /*************************************************************/
        Pokemon charmander = new Pokemon(
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
        Pokemon machop = new Pokemon(
                "Machop",
                6,
                Tipos.LUCHA,
                "Es una masa de músculos y, pese a su pequeño tamaño, tiene fuerza de sobra para levantar en brazos a 100 personas.",
                70,
                70,
                35,
                50,
                80,
                null
        );
        Pokemon tauros = new Pokemon(
                "Tauros",
                3,
                Tipos.NORMAL,
                "Cuando elige una presa, embiste sin pensárselo. Este Pokémon es famoso por su carácter violento.",
                75,
                75,
                110,
                95,
                100,
                null
        );
        Pokemon paras = new Pokemon(
                "Paras",
                4,
                Tipos.PLANTA,
                "Escarba en el suelo para extraer nutrientes de las raíces de los árboles, que las setas del lomo absorben después casi por completo.",
                35,
                35,
                25,
                55,
                70,
                null
        );
        Pokemon geodude = new Pokemon(
                "Geodude",
                4,
                Tipos.ROCA,
                "Se suele encontrar en senderos de montaña y sitios parecidos. Conviene andar con cuidado para no pisarlo sin querer y provocar su enfado.",
                40,
                40,
                20,
                100,
                80,
                null
        );
        Pokemon tentacool = new Pokemon(
                "Tentacool",
                3,
                Tipos.VENENO,
                "Sus facultades natatorias son más bien escasas, por lo que se limita a flotar a la deriva en aguas poco profundas en busca de alimento.",
                40,
                40,
                70,
                35,
                40,
                null
        );
        ArrayList<Pokemon> pokemonsJugador2 = new ArrayList<Pokemon>(Arrays.asList(
                charmander,
                machop,
                tauros,
                paras,
                tentacool,
                geodude
        ));

        /*************************************************/
        /******************ITEMS**************************/
        /*************************************************/

        Estadistica ataqueX = new Estadistica(
                1,
                "Ataque X",
                10,
                Estadistica.ATAQUE
        );

        Estadistica defensaX = new Estadistica(
                1,
                "Defensa X",
                10,
                Estadistica.DEFENSA
        );

        Pocion pocion = new Pocion(
                3,
                "Poción",
                20
        );

        Pocion megaPocion = new Pocion(
                2,
                "Mega Poción",
                50
        );

        Pocion hiperPocion = new Pocion(
                1,
                "Hiper Poción",
                100
        );

        CuraTodo curaTodo = new CuraTodo(
                1,
                "Cura Todo"
        );

        Jugador jugador1 = new Jugador(pokemonsJugador1, null);
        Jugador jugador2 = new Jugador(pokemonsJugador2, null);

        Revivir revivirJugador1 = new Revivir(
                2,
                "Revivir",
                jugador1
        );

        Revivir revivirJugador2 = new Revivir(
                2,
                "Revivir",
                jugador2
        );

        ArrayList<Item> itemsJugador1 = new ArrayList<Item>(Arrays.asList(
                ataqueX,
                defensaX,
                pocion,
                megaPocion,
                hiperPocion,
                curaTodo,
                revivirJugador1
        ));

        ArrayList<Item> itemsJugador2 = new ArrayList<Item>(Arrays.asList(
                ataqueX,
                defensaX,
                pocion,
                megaPocion,
                hiperPocion,
                curaTodo,
                revivirJugador2
        ));
        /*************************************************/
        /****************JUGADOR 1************************/
        /*************************************************/
        jugador1.setItems(itemsJugador1);

        /*************************************************/
        /****************JUGADOR 2************************/
        /*************************************************/
        jugador2.setItems(itemsJugador2);

        return new Juego(jugador1, jugador2);
    }

}