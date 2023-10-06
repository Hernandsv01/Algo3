package org.fiuba.algotres.herramientas;

import org.fiuba.algotres.CampoDeBatalla;
import org.fiuba.algotres.Jugador;
import org.fiuba.algotres.Pokemon;
import org.fiuba.algotres.Tipos;
import org.fiuba.algotres.estado.Dormido;
import org.fiuba.algotres.estado.Envenenado;
import org.fiuba.algotres.estado.Paralizado;
import org.fiuba.algotres.habilidad.*;
import org.fiuba.algotres.item.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Inicializador {

    /**
     * Crea los pokemons con sus respectivas habilidades
     * @return Un arreglo de listas de los pokemons de cada jugador
     */
    private static ArrayList<Pokemon>[] creacionPokemons() {
        /* *********************************************** */
        /* **************HABILIDADES********************** */
        /* *********************************************** */

        /* ******************TIPO ATAQUE ***************** */
        Ataque llamarada = new Ataque(
                "Llamarada",
                10,
                120,
                Tipos.FUEGO
        );
        Ataque ascuas = new Ataque(
                "Ascuas",
                25,
                40,
                Tipos.FUEGO
        );
        Ataque giroFuego = new Ataque(
                "Giro fuego",
                15,
                60,
                Tipos.FUEGO
        );
        Ataque lanzallamas = new Ataque(
                "Lanzallamas",
                5,
                95,
                Tipos.FUEGO
        );

        Ataque aranazo = new Ataque(
                "Arañazo",
                30,
                40,
                Tipos.NORMAL
        );
        Ataque placaje = new Ataque(
                "Placaje",
                30,
                50,
                Tipos.NORMAL
        );

        Ataque burbuja = new Ataque(
                "Burbuja",
                30,
                40,
                Tipos.AGUA
        );
        Ataque hidrobomba = new Ataque(
                "Hidrobomba",
                5,
                110,
                Tipos.AGUA
        );
        Ataque rayoBurbuja = new Ataque(
                "Rayo burbuja",
                30,
                65,
                Tipos.AGUA
        );
        Ataque pistolaAgua = new Ataque(
                "Pistola agua",
                25,
                40,
                Tipos.AGUA
        );

        Ataque rayo = new Ataque(
                "Rayo",
                15,
                95,
                Tipos.ELECTRICO
        );

        Ataque confusion = new Ataque(
                "Confusion",
                25,
                50,
                Tipos.PSIQUICO
        );
        Ataque psiquico = new Ataque(
                "Psiquico",
                10,
                90,
                Tipos.PSIQUICO
        );

        Ataque megaCuerno = new Ataque(
                "Mega cuerno",
                5,
                120,
                Tipos.BICHO
        );
        Ataque pinMisil = new Ataque(
                "Pin misil",
                20,
                30,
                Tipos.BICHO
        );

        Ataque golpeKarate = new Ataque(
                "Golpe karate",
                25,
                50,
                Tipos.LUCHA
        );
        Ataque sismico = new Ataque(
                "Sismico",
                10,
                80,
                Tipos.LUCHA
        );
        Ataque doblePatada = new Ataque(
                "Doble patada",
                30,
                30,
                Tipos.LUCHA
        );

        Ataque lanzarrocas = new Ataque(
                "Lanzarrocas",
                15,
                50,
                Tipos.ROCA
        );
        Ataque avalancha = new Ataque(
                "Avalancha",
                10,
                60,
                Tipos.ROCA
        );

        Ataque ataqueArena = new Ataque(
                "Ataque arena",
                15,
                85,
                Tipos.TIERRA
        );
        Ataque terremoto = new Ataque(
                "Terremoto",
                10,
                100,
                Tipos.TIERRA
        );

        Ataque picotazoVeneno = new Ataque(
                "Picotazo veneno",
                35,
                35,
                Tipos.VENENO
        );

        Ataque latigoCepa = new Ataque(
                "Latigo cepa",
                25,
                45,
                Tipos.PLANTA
        );
        Ataque hojaAfilada = new Ataque(
                "Hoja afilada",
                15,
                70,
                Tipos.PLANTA
        );

        Ataque ataqueAla = new Ataque(
                "Ataque ala",
                35,
                60,
                Tipos.VOLADOR
        );
        Ataque ataqueAereo = new Ataque(
                "Ataque aéreo",
                20,
                75,
                Tipos.VOLADOR
        );
        Ataque picotazo = new Ataque(
                "Picotazo",
                35,
                35,
                Tipos.VOLADOR
        );

        /* **********TIPO MODIFICACION DE ESTADISTICA********** */
        ModificacionEstadisticaAtaque danzaEspada = new ModificacionEstadisticaAtaque(
                "Danza espada",
                15,
                10
        );
        ModificacionEstadisticaDefensa fortaleza = new ModificacionEstadisticaDefensa(
                "fortaleza",
                25,
                10
        );
        ModificacionEstadisticaDefensa rizoDefensa = new ModificacionEstadisticaDefensa(
                "Rizo defensa",
                25,
                15
        );
        ModificacionEstadisticaVida recuperacion = new ModificacionEstadisticaVida(
                "Recuperacion",
                25,
                25
        );
        ModificacionEstadisticaAtaque chirrido = new ModificacionEstadisticaAtaque(
                "Chirrido",
                15,
                10
        );
        ModificacionEstadisticaAtaque pantalladDeLuz = new ModificacionEstadisticaAtaque(
                "Pantalla de luz",
                30,
                15
        );
        ModificacionEstadisticaVida descanso = new ModificacionEstadisticaVida(
                "Descanso",
                5,
                75
        );
        ModificacionEstadisticaDefensa acido = new ModificacionEstadisticaDefensa(
                "Ácido",
                30,
                10
        );
        ModificacionEstadisticaDefensa armaduraAcida = new ModificacionEstadisticaDefensa(
                "Armadura ácida",
                15,
                20
        );
        ModificacionEstadisticaVida absorber = new ModificacionEstadisticaVida(
                "Absorber",
                20,
                30
        );

        /* *************TIPO DE MODIFICACION DE ESTADO************* */
        ModificacionEstado impactrueno = new ModificacionEstado(
                "Impactrueno",
                20,
                new Paralizado("PARALIZADO")
        );
        ModificacionEstado trueno = new ModificacionEstado(
                "Trueno",
                10,
                new Paralizado("PARALIZADO")
        );
        ModificacionEstado polvoVeneno = new ModificacionEstado(
                "Polvo veneno",
                35,
                new Envenenado("ENVENENADO")
        );
        ModificacionEstado somnifero = new ModificacionEstado(
                "Somnífero",
                10,
                new Dormido("DORMIDO")
        );
        ModificacionEstado paralizador = new ModificacionEstado(
                "Paralizador",
                15,
                new Paralizado("PARALIZADO")
        );


        /* *********************************************************** */
        /* *****************ASIGNACION DE HABILIDADES***************** */
        /* *********************************************************** */

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
                aranazo
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

        /* *********************************************************** */
        /* *********************POKEMONS JUGADOR 1******************** */
        /* *********************************************************** */

        Pokemon bulbasaur = new Pokemon(
                "Bulbasaur",
                5,
                Tipos.PLANTA,
                "Este Pokémon nace con una semilla en el lomo, que brota con el paso del tiempo.",
                45,
                45,
                49,
                49,
                habilidadesBulbasaur
        );
        Pokemon pikachu = new Pokemon(
                "Pikachu",
                4,
                Tipos.ELECTRICO,
                "Las bolsas de las mejillas están llenas de electricidad, que libera cuando se siente amenazado.",
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
                "Duerme 18 horas al día y mientras lo hace es capaz de usar una serie de poderes extrasensoriales.",
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
                "Muy común en bosques y selvas. Aletea al nivel del suelo para levantar la gravilla.",
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
                "Los pinsir se juzgan entre ellos por la robustez de la cornamenta. Cuanto mas imponente sea, mas agradará a sus congéneres del sexo opuesto.",
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
                "Aunque sus brazos se rompan podrán regenerarse, siempre y cuando su núcleo siga intacto.",
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

        /* *********************************************************** */
        /* *********************POKEMONS JUGADOR 2******************** */
        /* *********************************************************** */
        Pokemon charmander = new Pokemon(
                "Charmander",
                5,
                Tipos.FUEGO,
                "Este Pokémon nace con una llama en la punta de la cola. Si la llama se apagara, el Pokémon se debilitaría.",
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
                "Es una masa de músculos y, aunque es pequeño, tiene fuerza de sobra para tomar en brazos a 100 personas.",
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
                "Después de animarse a luchar fustigándose con sus tres colas, carga a toda velocidad.",
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
                "Escarba bajo el suelo para roer las raíces de los árboles. Sus setas absorben los nutrientes.",
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
                "Aparecen en llanos y montañas. Como parecen rocas, la gente se tropieza con ellos o los pisa.",
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
                "Va a la deriva a poca profundidad. Si es pescado por accidente, el castigo será su punzante ácido.",
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

        int numeroJugadores = 2;
        ArrayList<Pokemon>[] pokemons = new ArrayList[numeroJugadores];
        pokemons[0] = pokemonsJugador1;
        pokemons[1] = pokemonsJugador2;
        return pokemons;
    }

    /**
     * Crea los items que tendra cada jugador
     * @return Lista de items
     */
    private static List<Item> creacionItems(){
        EstadisticaAtaque ataqueX = new org.fiuba.algotres.item.EstadisticaAtaque(
                3,
                "Ataque X",
                10
        );

        EstadisticaDefensa defensaX = new org.fiuba.algotres.item.EstadisticaDefensa(
                3,
                "Defensa X",
                10
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

        Revivir revivir = new Revivir(
                2,
                "Revivir"
        );

        return new ArrayList<>(Arrays.asList(
                ataqueX,
                defensaX,
                pocion,
                megaPocion,
                hiperPocion,
                curaTodo,
                revivir
        ));
    }

    /**
     * Crea el campo de batalla con los jugadores y asigna sus respectivos pokemons y items
     * @return El campo de batalla
     */
    public static CampoDeBatalla inicializarJuego() {
        /* *********************************************************** */
        /* *******************ASIGNACION DE POKEMONS****************** */
        /* *********************************************************** */
        ArrayList<Pokemon>[] pokemons = creacionPokemons();

        /* *********************************************************** */
        /* *******************ASIGNACION DE ITEMS********************* */
        /* *********************************************************** */
        List<Item> itemsJugador1 = creacionItems();
        List<Item> itemsJugador2 = creacionItems();

        /* *********************************************************** */
        /* *********************JUGADOR 1***************************** */
        /* *********************************************************** */
        Jugador jugador1 = new Jugador(pokemons[0], itemsJugador1);

        /* *********************************************** */
        /* ***************JUGADOR 2*********************** */
        /* *********************************************** */
        Jugador jugador2 = new Jugador(pokemons[1], itemsJugador2);

        return new CampoDeBatalla(
                new Jugador[]{
                        jugador1,
                        jugador2
                }
        );
    }
}
