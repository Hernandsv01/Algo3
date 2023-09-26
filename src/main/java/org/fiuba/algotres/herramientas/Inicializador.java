package org.fiuba.algotres.herramientas;

import org.fiuba.algotres.Juego;
import org.fiuba.algotres.Jugador;
import org.fiuba.algotres.Pokemon;
import org.fiuba.algotres.Tipos;
import org.fiuba.algotres.estado.Estado;
import org.fiuba.algotres.habilidad.Ataque;
import org.fiuba.algotres.habilidad.Habilidad;
import org.fiuba.algotres.habilidad.ModificacionEstadistica;
import org.fiuba.algotres.habilidad.ModificacionEstado;
import org.fiuba.algotres.item.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Inicializador {

    public static Juego inicializarJuego() {

        /*************************************************/
        /***************HABILIDADES***********************/
        /*************************************************/

        /*******************TIPO ATAQUE ******************/
        Ataque llamarada = new Ataque(
                "Llamarada"
        );
        Ataque ascuas = new Ataque(
                "Ascuas"
        );
        Ataque giroFuego = new Ataque(
                "Giro fuego"
        );
        Ataque lanzallamas = new Ataque(
                "Lanzallamas"
        );;

        Ataque arañazo = new Ataque(
                "Arañazo"
        );;
        Ataque placaje = new Ataque(
                "Placaje"
        );

        Ataque burbuja = new Ataque(
                "Burbuja"
        );
        Ataque hidrobomba = new Ataque(
                "Hidrobomba"
        );
        Ataque rayoBurbuja = new Ataque(
                "Rayo burbuja"
        );
        Ataque pistolaAgua = new Ataque(
                "Pistola agua"
        );

        Ataque rayo = new Ataque(
                "Rayo"
        );

        Ataque confusion = new Ataque(
                "Confusion"
        );
        Ataque psiquico = new Ataque(
                "Psiquico"
        );

        Ataque megaCuerno = new Ataque(
                "Mega cuerno"
        );
        Ataque pinMisil = new Ataque(
                "Pin misil"
        );

        Ataque golpeKarate = new Ataque(
                "Golpe karate"
        );
        Ataque sismico = new Ataque(
                "Sismico"
        );
        Ataque doblePatada = new Ataque(
                "Doble patada"
        );

        Ataque lanzarrocas = new Ataque(
                "Lanzarrocas"
        );
        Ataque avalancha = new Ataque(
                "Avalancha"
        );

        Ataque ataqueArena = new Ataque(
                "Ataque arena"
        );
        Ataque terremoto = new Ataque(
                "Terremoto"
        );

        Ataque picotazoVeneno = new Ataque(
                "Picotazo veneno"
        );

        Ataque latigoCepa = new Ataque(
                "Latigo cepa"
        );
        Ataque hojaAfilada = new Ataque(
                "Hoja afilada"
        );

        Ataque ataqueAla = new Ataque(
                "Ataque ala"
        );
        Ataque ataqueAereo = new Ataque(
                "Ataque áereo"
        );
        Ataque picotazo = new Ataque(
                "Picotazo"
        );

        /***********TIPO MODIFICACION DE ESTADISTICA***********/
        ModificacionEstadistica danzaEspada = new ModificacionEstadistica(
                "Danza espada",
                15,
                ModificacionEstadistica.ATAQUE,
                true
        );
        ModificacionEstadistica fortaleza = new ModificacionEstadistica(
                "fortaleza",
                25,
                ModificacionEstadistica.DEFENSA,
                true
        );
        ModificacionEstadistica rizoDefensa = new ModificacionEstadistica(
                "Rizo defensa",
                25,
                ModificacionEstadistica.DEFENSA,
                true
        );
        ModificacionEstadistica recuperacion = new ModificacionEstadistica(
                "Recuperacion",
                25,
                ModificacionEstadistica.VIDA,
                true
        );
        ModificacionEstadistica chirrido = new ModificacionEstadistica(
                "Chirrido",
                15,
                ModificacionEstadistica.DEFENSA,
                false
        );
        ModificacionEstadistica pantalladDeLuz = new ModificacionEstadistica(
                "Pantalla de luz",
                30,
                ModificacionEstadistica.ATAQUE,
                false
        );
        ModificacionEstadistica descanso = new ModificacionEstadistica(
                "Descanso",
                5,
                ModificacionEstadistica.VIDA,
                true
        );
        ModificacionEstadistica acido = new ModificacionEstadistica(
                "Ácido",
                30,
                ModificacionEstadistica.DEFENSA,
                false
        );
        ModificacionEstadistica armaduraAcida = new ModificacionEstadistica(
                "Armadura ácida",
                15,
                ModificacionEstadistica.DEFENSA,
                true
        );
        ModificacionEstadistica absorber = new ModificacionEstadistica(
                "Absorber",
                20,
                ModificacionEstadistica.VIDA,
                true
        );

        /**************TIPO DE MODIFICACION DE ESTADO**************/
        ModificacionEstado impactrueno = new ModificacionEstado(
                "Impactrueno",
                20,
                Estado.PARALIZADO
        );
        ModificacionEstado trueno = new ModificacionEstado(
                "Trueno",
                10,
                Estado.PARALIZADO
        );
        ModificacionEstado polvoVeneno = new ModificacionEstado(
                "Polvo veneno",
                35,
                Estado.ENVENENADO
        );
        ModificacionEstado somnifero = new ModificacionEstado(
                "Somnífero",
                10,
                Estado.DORMIDO
        );
        ModificacionEstado paralizador = new ModificacionEstado(
                "Paralizador",
                15,
                Estado.PARALIZADO
        );


        /*************************************************************/
        /******************ASIGNACION DE HABILIDADES******************/
        /*************************************************************/

        ArrayList<Habilidad> habilidadesBulbasaur = new ArrayList<Habilidad>(Arrays.asList(
                absorber,
                somnifero,
                latigoCepa,
                hojaAfilada
        ));

        ArrayList<Habilidad> habilidadesPikachu = new ArrayList<Habilidad>(Arrays.asList(
                impactrueno,
                trueno,
                rayo,
                arañazo
        ));

        ArrayList<Habilidad> habilidadesAbra = new ArrayList<Habilidad>(Arrays.asList(
                pantalladDeLuz,
                descanso,
                confusion,
                psiquico
        ));

        ArrayList<Habilidad> habilidadesPidgey = new ArrayList<Habilidad>(Arrays.asList(
                danzaEspada,
                ataqueAereo,
                ataqueAla,
                picotazo
        ));

        ArrayList<Habilidad> habilidadesPinsir = new ArrayList<Habilidad>(Arrays.asList(
                chirrido,
                pinMisil,
                megaCuerno
        ));

        ArrayList<Habilidad> habilidadesStaryu = new ArrayList<Habilidad>(Arrays.asList(
                burbuja,
                hidrobomba,
                pistolaAgua,
                rayoBurbuja
        ));

        ArrayList<Habilidad> habilidadesCharmander = new ArrayList<Habilidad>(Arrays.asList(
                llamarada,
                ascuas,
                giroFuego,
                lanzallamas
        ));

        ArrayList<Habilidad> habilidadesMachop = new ArrayList<Habilidad>(Arrays.asList(
                golpeKarate,
                sismico,
                doblePatada
        ));

        ArrayList<Habilidad> habilidadesTauros = new ArrayList<Habilidad>(Arrays.asList(
                placaje,
                rizoDefensa,
                recuperacion,
                fortaleza
        ));

        ArrayList<Habilidad> habilidadesParas = new ArrayList<Habilidad>(Arrays.asList(
                paralizador,
                hojaAfilada,
                polvoVeneno,
                picotazoVeneno
        ));

        ArrayList<Habilidad> habilidadesGeodude = new ArrayList<Habilidad>(Arrays.asList(
                lanzarrocas,
                avalancha,
                ataqueArena,
                terremoto
        ));

        ArrayList<Habilidad> habilidadesTentacool = new ArrayList<Habilidad>(Arrays.asList(
                acido,
                armaduraAcida,
                picotazoVeneno
        ));

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
                habilidadesBulbasaur
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
                habilidadesPikachu
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
                habilidadesAbra
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
                habilidadesPidgey
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
                habilidadesPinsir
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
                habilidadesStaryu
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
                habilidadesCharmander
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
                habilidadesMachop
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
                habilidadesTauros
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
                habilidadesParas
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
                habilidadesGeodude
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
                habilidadesTentacool
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
                3,
                "Ataque X",
                10,
                Estadistica.ATAQUE
        );

        Estadistica defensaX = new Estadistica(
                3,
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
                3,
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