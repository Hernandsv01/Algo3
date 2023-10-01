package org.fiuba.algotres.herramientas;

import org.fiuba.algotres.CampoDeBatalla;
import org.fiuba.algotres.Jugador;
import org.fiuba.algotres.Pokemon;
import org.fiuba.algotres.Tipos;
import org.fiuba.algotres.estado.Paralizado;
import org.fiuba.algotres.estado.Dormido;
import org.fiuba.algotres.estado.Envenenado;
import org.fiuba.algotres.habilidad.Ataque;
import org.fiuba.algotres.habilidad.Habilidad;
import org.fiuba.algotres.habilidad.ModificacionEstadistica;
import org.fiuba.algotres.habilidad.ModificacionEstado;
import org.fiuba.algotres.item.Item;
import org.fiuba.algotres.item.Ataque;
import org.fiuba.algotres.item.CuraTodo;
import org.fiuba.algotres.item.Defensa;
import org.fiuba.algotres.item.Estadistica;
import org.fiuba.algotres.item.Pocion;
import org.fiuba.algotres.item.Revivir;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Inicializador {

    /**
     * Crea los pokemons con sus respectivas habilidades
     * @return Un arreglo de listas de los pokemons de cada jugador
     */
    private static ArrayList<Pokemon>[] creacionPokemons() {
        /*************************************************/
        /***************HABILIDADES***********************/
        /*************************************************/

        /*******************TIPO ATAQUE ******************/
        org.fiuba.algotres.habilidad.Ataque llamarada = new org.fiuba.algotres.habilidad.Ataque(
                "Llamarada",
                10,
                120,
                Tipos.FUEGO
        );
        org.fiuba.algotres.habilidad.Ataque ascuas = new org.fiuba.algotres.habilidad.Ataque(
                "Ascuas",
                25,
                40,
                Tipos.FUEGO
        );
        org.fiuba.algotres.habilidad.Ataque giroFuego = new org.fiuba.algotres.habilidad.Ataque(
                "Giro fuego",
                15,
                60,
                Tipos.FUEGO
        );
        org.fiuba.algotres.habilidad.Ataque lanzallamas = new org.fiuba.algotres.habilidad.Ataque(
                "Lanzallamas",
                5,
                95,
                Tipos.FUEGO
        );

        org.fiuba.algotres.habilidad.Ataque arañazo = new org.fiuba.algotres.habilidad.Ataque(
                "Arañazo",
                30,
                40,
                Tipos.NORMAL
        );
        org.fiuba.algotres.habilidad.Ataque placaje = new org.fiuba.algotres.habilidad.Ataque(
                "Placaje",
                30,
                50,
                Tipos.NORMAL
        );

        org.fiuba.algotres.habilidad.Ataque burbuja = new org.fiuba.algotres.habilidad.Ataque(
                "Burbuja",
                30,
                40,
                Tipos.AGUA
        );
        org.fiuba.algotres.habilidad.Ataque hidrobomba = new org.fiuba.algotres.habilidad.Ataque(
                "Hidrobomba",
                5,
                110,
                Tipos.AGUA
        );
        org.fiuba.algotres.habilidad.Ataque rayoBurbuja = new org.fiuba.algotres.habilidad.Ataque(
                "Rayo burbuja",
                30,
                65,
                Tipos.AGUA
        );
        org.fiuba.algotres.habilidad.Ataque pistolaAgua = new org.fiuba.algotres.habilidad.Ataque(
                "Pistola agua",
                25,
                40,
                Tipos.AGUA
        );

        org.fiuba.algotres.habilidad.Ataque rayo = new org.fiuba.algotres.habilidad.Ataque(
                "Rayo",
                15,
                95,
                Tipos.ELECTRICO
        );

        org.fiuba.algotres.habilidad.Ataque confusion = new org.fiuba.algotres.habilidad.Ataque(
                "Confusion",
                25,
                50,
                Tipos.PSIQUICO
        );
        org.fiuba.algotres.habilidad.Ataque psiquico = new org.fiuba.algotres.habilidad.Ataque(
                "Psiquico",
                10,
                90,
                Tipos.PSIQUICO
        );

        org.fiuba.algotres.habilidad.Ataque megaCuerno = new org.fiuba.algotres.habilidad.Ataque(
                "Mega cuerno",
                5,
                120,
                Tipos.BICHO
        );
        org.fiuba.algotres.habilidad.Ataque pinMisil = new org.fiuba.algotres.habilidad.Ataque(
                "Pin misil",
                20,
                30,
                Tipos.BICHO
        );

        org.fiuba.algotres.habilidad.Ataque golpeKarate = new org.fiuba.algotres.habilidad.Ataque(
                "Golpe karate",
                25,
                50,
                Tipos.LUCHA
        );
        org.fiuba.algotres.habilidad.Ataque sismico = new org.fiuba.algotres.habilidad.Ataque(
                "Sismico",
                10,
                80,
                Tipos.LUCHA
        );
        org.fiuba.algotres.habilidad.Ataque doblePatada = new org.fiuba.algotres.habilidad.Ataque(
                "Doble patada",
                30,
                30,
                Tipos.LUCHA
        );

        org.fiuba.algotres.habilidad.Ataque lanzarrocas = new org.fiuba.algotres.habilidad.Ataque(
                "Lanzarrocas",
                15,
                50,
                Tipos.ROCA
        );
        org.fiuba.algotres.habilidad.Ataque avalancha = new org.fiuba.algotres.habilidad.Ataque(
                "Avalancha",
                10,
                60,
                Tipos.ROCA
        );

        org.fiuba.algotres.habilidad.Ataque ataqueArena = new org.fiuba.algotres.habilidad.Ataque(
                "Ataque arena",
                15,
                85,
                Tipos.TIERRA
        );
        org.fiuba.algotres.habilidad.Ataque terremoto = new org.fiuba.algotres.habilidad.Ataque(
                "Terremoto",
                10,
                100,
                Tipos.TIERRA
        );

        org.fiuba.algotres.habilidad.Ataque picotazoVeneno = new org.fiuba.algotres.habilidad.Ataque(
                "Picotazo veneno",
                35,
                35,
                Tipos.VENENO
        );

        org.fiuba.algotres.habilidad.Ataque latigoCepa = new org.fiuba.algotres.habilidad.Ataque(
                "Latigo cepa",
                25,
                45,
                Tipos.PLANTA
        );
        org.fiuba.algotres.habilidad.Ataque hojaAfilada = new org.fiuba.algotres.habilidad.Ataque(
                "Hoja afilada",
                15,
                70,
                Tipos.PLANTA
        );

        org.fiuba.algotres.habilidad.Ataque ataqueAla = new org.fiuba.algotres.habilidad.Ataque(
                "Ataque ala",
                35,
                60,
                Tipos.VOLADOR
        );
        org.fiuba.algotres.habilidad.Ataque ataqueAereo = new org.fiuba.algotres.habilidad.Ataque(
                "Ataque aéreo",
                20,
                75,
                Tipos.VOLADOR
        );
        org.fiuba.algotres.habilidad.Ataque picotazo = new org.fiuba.algotres.habilidad.Ataque(
                "Picotazo",
                35,
                35,
                Tipos.VOLADOR
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
                "Las bolsas de las mejillas están llenas de electricidad, que libera cuando se siente amenazado.",
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
                "Duerme 18 horas al día y mientras lo hace es capaz de usar una serie de poderes extrasensoriales.",
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
                "Muy común en bosques y selvas. Aletea al nivel del suelo para levantar la gravilla.",
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
                "Los pinsir se juzgan entre ellos por la robustez de la cornamenta. Cuanto mas imponente sea, mas agradará a sus congéneres del sexo opuesto.",
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
                "Aunque sus brazos se rompan podrán regenerarse, siempre y cuando su núcleo siga intacto.",
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
                "Este Pokémon nace con una llama en la punta de la cola. Si la llama se apagara, el Pokémon se debilitaría.",
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
                "Es una masa de músculos y, aunque es pequeño, tiene fuerza de sobra para tomar en brazos a 100 personas.",
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
                "Después de animarse a luchar fustigándose con sus tres colas, carga a toda velocidad.",
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
                "Escarba bajo el suelo para roer las raíces de los árboles. Sus setas absorben los nutrientes.",
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
                "Aparecen en llanos y montañas. Como parecen rocas, la gente se tropieza con ellos o los pisa.",
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
                "Va a la deriva a poca profundidad. Si es pescado por accidente, el castigo será su punzante ácido.",
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

        int numeroJugadores = 2;
        ArrayList<Pokemon>[] pokemons = new ArrayList[numeroJugadores];
        pokemons[0] = new ArrayList<Pokemon>();
        pokemons[0] = pokemonsJugador1;
        pokemons[1] = new ArrayList<Pokemon>();
        pokemons[1] = pokemonsJugador2;
        return pokemons;
    }
    git commit -m "Creacion de funciones auxiliares para pokemons y items. Correcion de items y estadgi"

    /**
     * Crea los items que tendra cada jugador
     * @return Lista de items
     */
    private static List<Item> creacionItems(){
        org.fiuba.algotres.item.Ataque ataqueX = new org.fiuba.algotres.item.Ataque(
                3,
                "Ataque X",
                10
        );

        org.fiuba.algotres.item.Defensa defensaX = new org.fiuba.algotres.item.Defensa(
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

        ArrayList<Item> itemsJugadores = new ArrayList<Item>(Arrays.asList(
                ataqueX,
                defensaX,
                pocion,
                megaPocion,
                hiperPocion,
                curaTodo,
                revivir
        ));

        return itemsJugadores;
    }

    /**
     * Crea el campo de batalla con los jugadores y asigna sus respectivos pokemons y items
     * @return El campo de batalla
     */
    public static CampoDeBatalla inicializarJuego() {
        /*************************************************************/
        /********************ASIGNACION DE POKEMONS*******************/
        /*************************************************************/
        ArrayList<Pokemon>[] pokemons = creacionPokemons();

        ArrayList<Pokemon> pokemonsJugador1 = pokemons[0];
        ArrayList<Pokemon> pokemonsJugador2 = pokemons[1];

        /*************************************************************/
        /********************ASIGNACION DE ITEMS**********************/
        /*************************************************************/
        List<Item> itemsJugadores = creacionItems();

        /*************************************************************/
        /**********************JUGADOR 1******************************/
        /*************************************************************/
        Jugador jugador1 = new Jugador(pokemonsJugador1, itemsJugadores);

        /*************************************************/
        /****************JUGADOR 2************************/
        /*************************************************/
        Jugador jugador2 = new Jugador(pokemonsJugador2, itemsJugadores);

        return new CampoDeBatalla(
                new Jugador[]{
                        jugador1,
                        jugador2
                }
        );
    }
}
