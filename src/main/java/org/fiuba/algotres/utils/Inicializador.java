package org.fiuba.algotres.utils;

import org.fiuba.algotres.model.CampoDeBatalla;
import org.fiuba.algotres.model.Jugador;
import org.fiuba.algotres.model.Pokemon;
import org.fiuba.algotres.model.clima.*;
import org.fiuba.algotres.model.estado.Confuso;
import org.fiuba.algotres.model.estado.Dormido;
import org.fiuba.algotres.model.estado.Envenenado;
import org.fiuba.algotres.model.estado.Paralizado;
import org.fiuba.algotres.model.habilidad.*;
import org.fiuba.algotres.model.item.*;
import org.fiuba.algotres.model.strategies.AtaqueStrategy;
import org.fiuba.algotres.model.strategies.DefensaStrategy;
import org.fiuba.algotres.model.strategies.VidaStrategy;
import org.fiuba.algotres.model.tipos.Tipos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Inicializador {

    /**
     * Crea los pokemons con sus respectivas habilidades
     * @param cdb al cual se le asignara a los climas
     * @return Un arreglo de listas de los pokemons de cada jugador
     */
    private static ArrayList<Pokemon>[] creacionPokemons(CampoDeBatalla cdb) {
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
        Ataque rayo = new Ataque(
                "Rayo",
                15,
                95,
                Tipos.ELECTRICO
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

        /* **********TIPO MODIFICACION DE ESTADISTICA********** */
        ModificacionEstadistica danzaEspada = new ModificacionEstadistica(
                "Danza espada",
                15,
                10,
                new AtaqueStrategy(true)
        );
        ModificacionEstadistica rizoDefensa = new ModificacionEstadistica(
                "Rizo defensa",
                25,
                15,
                new DefensaStrategy(true)
        );
        ModificacionEstadistica recuperacion = new ModificacionEstadistica(
                "Recuperacion",
                25,
                25,
                new VidaStrategy()
        );
        ModificacionEstadistica chirrido = new ModificacionEstadistica(
                "Chirrido",
                15,
                10,
                new AtaqueStrategy(false)
        );
        ModificacionEstadistica pantallaDeLuz = new ModificacionEstadistica(
                "Pantalla de luz",
                30,
                15,
                new AtaqueStrategy(false)
        );
        ModificacionEstadistica acido = new ModificacionEstadistica(
                "Ácido",
                30,
                10,
                new DefensaStrategy(false)
        );
        ModificacionEstadistica armaduraAcida = new ModificacionEstadistica(
                "Armadura ácida",
                15,
                20,
                new DefensaStrategy(true)
        );
        ModificacionEstadistica absorber = new ModificacionEstadistica(
                "Absorber",
                20,
                30,
                new VidaStrategy()
        );

        /* *************TIPO DE MODIFICACION DE ESTADO************* */
        ModificacionEstado impactrueno = new ModificacionEstado(
                "Impactrueno",
                20,
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
        ModificacionEstado confusion = new ModificacionEstado(
                "Confusion",
                15,
                new Confuso("CONFUSO")
        );

        /* *************TIPO DE CAMBIAR CLIMA************* */
        CambiarClima solear = new CambiarClima(
                "Solear",
                5,
                new Soleado(
                        "Soleado",
                        cdb
                )
        );
        CambiarClima llovizna = new CambiarClima(
                "Llovizna",
                5,
                new Lluvia(
                        "Lluvia",
                        cdb
                )
        );
        CambiarClima tormentaArenosa = new CambiarClima(
                "Tormenta arenosa",
                5,
                new TormentaArena(
                        "Tormenta de arena",
                        cdb
                )
        );
        CambiarClima tormentaElectrica = new CambiarClima(
                "Tormenta Electrica",
                5,
                new TormentaRayos(
                        "Tormenta de rayos",
                        cdb
                )
        );
        CambiarClima huracan = new CambiarClima(
                "Huracan",
                5,
                new Huracan(
                        "Huracan",
                        cdb
                )
        );
        CambiarClima neblina = new CambiarClima(
                "Neblina",
                5,
                new Niebla(
                        "Niebla",
                        cdb
                )
        );
        CambiarClima despejar = new CambiarClima(
                "Despejar",
                5,
                new SinClima(
                        "Sin clima",
                        cdb
                )
        );

        /* *********************************************************** */
        /* *****************ASIGNACION DE HABILIDADES***************** */
        /* *********************************************************** */

        ArrayList<Habilidad> habilidadesBulbasaur = new ArrayList<Habilidad>(Arrays.asList(
                absorber,
                somnifero,
                latigoCepa,
                llovizna
        ));

        ArrayList<Habilidad> habilidadesPikachu = new ArrayList<Habilidad>(Arrays.asList(
                impactrueno,
                tormentaElectrica,
                rayo,
                aranazo
        ));

        ArrayList<Habilidad> habilidadesAbra = new ArrayList<Habilidad>(Arrays.asList(
                pantallaDeLuz,
                neblina,
                confusion,
                psiquico
        ));

        ArrayList<Habilidad> habilidadesPidgey = new ArrayList<Habilidad>(Arrays.asList(
                danzaEspada,
                ataqueAereo,
                ataqueAla,
                huracan
        ));

        ArrayList<Habilidad> habilidadesPinsir = new ArrayList<Habilidad>(Arrays.asList(
                chirrido,
                pinMisil,
                megaCuerno
        ));

        ArrayList<Habilidad> habilidadesStaryu = new ArrayList<Habilidad>(Arrays.asList(
                burbuja,
                hidrobomba,
                llovizna,
                rayoBurbuja
        ));

        ArrayList<Habilidad> habilidadesCharmander = new ArrayList<Habilidad>(Arrays.asList(
                llamarada,
                ascuas,
                solear,
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
                despejar
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
                tormentaArenosa,
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
        Item ataqueX = FactoryItem.CrearAtaqueX(3);
        Item defensaX = FactoryItem.CrearDefensaX(3);
        Item pocion = FactoryItem.CrearPocion(3);
        Item megaPocion = FactoryItem.CrearMegaPocion(2);
        Item hiperPocion = FactoryItem.CrearHiperPocion(1);
        Item curaTodo = FactoryItem.CrearCuraTodo(3);
        Item revivir = FactoryItem.CrearRevivir(2);
        Item pocionMolestaAlumnos = FactoryItem.CrearPocionMolestaAlumnos(2);

        return new ArrayList<>(Arrays.asList(
                ataqueX,
                defensaX,
                pocion,
                megaPocion,
                hiperPocion,
                curaTodo,
                revivir,
                pocionMolestaAlumnos
        ));
    }

    /**
     * Creo el clima que tendra inicialmente el campo de batalla
     * @param cdb al cual se le asignara el clima
     * @return El clima que comenzara el campo de batalla.
     */
    private static Clima creacionClima(CampoDeBatalla cdb) {
        double probabilidadConClima = (double)2/3;
        double probabilidad = new Random().nextDouble();
        if(probabilidad > probabilidadConClima) {
            ArrayList<Clima> climasPosibles = new ArrayList<Clima>(Arrays.asList(
                    new Huracan(
                            "Huracan",
                            cdb
                    ),
                    new Lluvia(
                            "Lluvia",
                            cdb
                    ),
                    new Niebla(
                            "Niebla",
                            cdb
                    ),
                    new Soleado(
                            "Soleado",
                            cdb
                    ),
                    new TormentaRayos(
                            "Tormenta de rayos",
                            cdb
                    ),
                    new TormentaArena(
                            "tormenta de arena",
                            cdb
                    )
            ));

            int indiceSorteado = new Random().nextInt(6);
            return climasPosibles.get(indiceSorteado);
        } else {
            return new SinClima(
                    "Sin clima",
                    cdb
            );
        }
    }

    /**
     * Crea el campo de batalla con los jugadores y asigna sus respectivos pokemons y items
     * @return El campo de batalla
     */
    public static CampoDeBatalla inicializarJuego() {

        CampoDeBatalla cdb = new CampoDeBatalla();

        /* *********************************************************** */
        /* *******************ASIGNACION DE POKEMONS****************** */
        /* *********************************************************** */
        ArrayList<Pokemon>[] pokemons = creacionPokemons(cdb);

        /* *********************************************************** */
        /* *******************ASIGNACION DE ITEMS********************* */
        /* *********************************************************** */
        List<Item> itemsJugador1 = creacionItems();
        List<Item> itemsJugador2 = creacionItems();

        /* *********************************************************** */
        /* *******************ASIGNACION DE CLIMA********************* */
        /* *********************************************************** */
        Clima climaSorteado = creacionClima(cdb);
        cdb.setClima(climaSorteado);

        /* *********************************************** */
        /* *********************JUGADOR 1***************** */
        /* *********************************************** */
        Jugador jugador1 = new Jugador(pokemons[0], itemsJugador1);

        /* *********************************************** */
        /* *********************JUGADOR 2***************** */
        /* *********************************************** */
        Jugador jugador2 = new Jugador(pokemons[1], itemsJugador2);

        cdb.setJugadores(new Jugador[]{
                jugador1,
                jugador2
        });

        return cdb;
    }
}
