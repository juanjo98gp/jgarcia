package ProjecteM3;

import java.util.Scanner;

public class JocRol {
	public static Scanner teclat = new Scanner(System.in);
	//detector si tenemos item
	public static boolean llave;
	public static boolean daga;
	public static boolean espada;
	public static boolean pechera;
	public static boolean pocion;
	//detector vida
	public static int topeVida;
	public static int vida;
	//arama equipada
	public static int arma;
	//armas
	public static final int DMGPUÑO = 5;
	public static final int DMGDAGA = 15;
	public static final int DMGESPADA = 30;
	public static final int VITPECHERA = 50;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int opcion;
		System.out.println("Mini Souls");
		System.out.println();
		do {
			opcion = menuPrincipal();
			switch (opcion) {
			case 0:
			default:
				break;
			case 1:
				iniciarJuego();
				inicial();
				inicialMenu();
				break;
			case 2:
				break;
			}
		}while (opcion !=0);
	}
	
	public static void juego() {
		inicial();
		inicialMenu();
	}
	
	public static void escalera() {
		System.out.println("Te encuentras con una escalera, por la derecha sube a algun lugar con una luz tenue, a la izquierda la escalera baja hacia una oscuridad casi total");
		System.out.println("Que quieres hacer?");
		System.out.println();
		System.out.println("1 Ir hacia la derecha y buscar la fuente de la luz");
		System.out.println("2 Bajar y intenar ver algo en la oscuridad");
		System.out.println("3 Inventario");
	}
	
	public static void pasillo() {
		boolean pasillo = true;
		int opcion;
		int andar=0;
		System.out.println("Delante de ti encuentras un pasillo oscuro, no llegas a ver el fondo");
		System.out.println("Que quieres hacer?");
		System.out.println();
		System.out.println("1 Seguir andando");
		System.out.println("2 Volver a la habitación");
		System.out.println("3 Inventario");
		do {
			System.out.println("Escoje una acción:");
			opcion = teclat.nextInt();
			if (opcion > 3 || opcion < 0)
				System.err.println("No puedes hacer esto!");
		} while (opcion > 3 || opcion < 0);
		switch(opcion) {
		case 1:
			while(andar<3) {
				System.out.println("Avanzas por el pasillo sin llegar a ver el fondo");
			}
			if (andar>3) {
				System.out.println("Tras perder la cuenta de los pasos que has dado dislumbras una luz, te acercas hacia ella");
				//pasillo = false
			}
			break;
		case 2:
			System.out.println("Te giras y vuleves sobre tus pasos hasta donde te despertastes");
			inicialMenu();
		}
		
	}
	
	public static void inicial1(boolean inicial) {
		 if (llave==true) { 
			System.out.println("Metes la llave en la cerradura y consigue encajar, empujas la vieja puerta");
			inicial = false;
			pasillo();
		 } else {
			System.out.println("Intentas abrir la puerta pero aunque empujes mucho, no se mueve");
			inicialMenu();
		}	
		
	}
	
	public static void inicial2() {
		int opcion;
		System.out.println("Ante ti se ecuentra el anterior residente de esta habitación, hace mucho tiempo, tiene una llave en las manos");
		System.out.println("Que quieres hacer?");
		System.out.println();
		System.out.println("1 Coger la llave, ya no la necessita");
		System.out.println("2 Mirar mas de cerca el esqueleto");
		do {
			System.out.println("Escoje una acción:");
			opcion = teclat.nextInt();
			if (opcion > 2 || opcion < 0)
				System.err.println("No puedes hacer esto!");
		} while (opcion > 2 || opcion < 0);
		switch(opcion) {
		case 1:
			System.out.println("Has obtenido Llave vieja!");
			llave=true;
			System.out.println("Coges la llave y vuelves a mirar hacia la puerta");
			inicialMenu();
		case 2:
			System.out.println("Te acercas al esqueleto, puedes ver que lleva mucho tiempo aqui, no puedes aprovechar nada mas a parte de la llave que tiene en la mano");
			inicial2();
		}
	}
	
	public static void inicial3() {
		System.out.println("Al mirar a la derecha encuentras un cofre, lo abres y dentro hay una daga a la que el tiempo no a tratado bien");
		daga=true;
		System.out.println("_______________________");
		System.out.println("|      Daga Vieja      |");
		System.out.println("| Daño............15   |");
		System.out.println("| Una daga oxidada y   |");
		System.out.println("| sin filo, pero es    |");
		System.out.println("| mejor que nada.      |");
		System.out.println("|______________________|");
		System.out.println();
		System.out.println("Coges la daga y te la guardas en tu alforja, vuelves a mirar hacia la puerta");
		inicialMenu();
	}
	
	public static void inicial() {
		System.out.println("Te levantas en una habitacion, delante tienes una puerta");
	}
	
	public static void inicialMenu() {
		boolean inicial = true;
		int opcion;
		System.out.println("Que quieres hacer?");
		System.out.println();
		System.out.println("1 Intenar abrir la puerta");
		System.out.println("2 Mirar a la izquierda");
		System.out.println("3 Mirar a la derecha");
		System.out.println("4 Inventario");
		do {
			System.out.println("Escoje una acción:");
			opcion = teclat.nextInt();
			if (opcion > 4 || opcion < 0 || opcion == 9)
				System.err.println("No puedes hacer esto!");
		} while (opcion > 4 || opcion < 0 || opcion == 9);
		switch (opcion ) {
		case 4:
			inventario(inicial);
			break;
		case 1:
			inicial1(inicial);
			break;
		case 2:
			inicial2();
			break;
		case 3:
			inicial3();
			break;
		}
	}
	
	public static void inventario(boolean inicial) {
		int opcion;
		//Equipamiento ID
		int llaveID, dagaID, puñoID, espadaID, pecheraID, pocionID;
		
		System.out.println("________________________________________");
		System.out.println("_____________Inventario_________________");
		System.out.println("________________________________________");
		
		if(llave==true) {
			System.out.println("_____-Llave vieja                      _");
			llaveID = 9;
		}
		if(daga==true) {
			System.out.println("_____-Daga oxidada                     _");
			dagaID = 1;
		}
		if(espada==true) {
			System.out.println("_____-Espada rota                      _");
			espadaID = 2;
		}
		if(pechera==true) {
			System.out.println("_____-Pechera de cuero                 _");
			pecheraID = 3;
		}
		if(pocion==true) {
			System.out.println("_____-Poción Roja                      _");
			pocionID = 4;
		}
		System.out.println("________________________________________");
		do {
			System.out.println("Escoje una acción:");
			System.out.println("0.-Salir");
			if(llave==true) {
				System.out.println("1.-Equipar llave");
			}
			if(daga==true) {
				System.out.println("2.-Equipar daga");
			}
			if(espada==true) {
				System.out.println("3.-Equipar espada");
			}
			if(pechera==true) {
				System.out.println("4.-Equipar pechera");
			}
			if(pocion==true) {
				System.out.println("5.-Beber pocion");
			}
			System.out.println("6.-Ver estado");
			opcion = teclat.nextInt();
			if (opcion > 6 || opcion < 0 || opcion == 9)
				System.err.println("No puedes hacer esto!");
		} while (opcion > 6 || opcion < 0 || opcion == 9);
		switch (opcion ) {
		case 0:
		default:
			break;
		case 1: if(llave==true) {
			System.out.println("Miras la llave, pero no puedes usarla para nada a parte de abrir una puerta");
			} else { System.out.println("No puedes hacer esto");}
			break;
		case 2: if(daga==true) {
			System.out.println("Coges la daga y la guardas en tu cinturón preparada para usarla en cualquier momento");
			arma=1;} else { System.out.println("No puedes hacer esto");}
			break;
		case 3: if(espada==true) {
			System.out.println("Coges lo que queda de espada con fuerza preparado para cualquier ataque");
			arma = 2; } else { System.out.println("No puedes hacer esto");}
			break;
		case 4: if(pechera==true) {
			System.out.println("Te pones la pechera de cuero sin muchos problemas");
			vida=vida+VITPECHERA;
			} else { System.out.println("No puedes hacer esto");}
			break;
		case 5: if(pocion==true) {
				if (vida < 25) {
				System.out.println("Con las pocas fuerzas que te queda, abres la pocion y te la bebes, sientes como recuperas toda tu fuerza ");
				pocion=false;
				} else { System.out.println("Destapas la pocion y te la bebes de un sorbo, aunque sea roja no sabe a fresa"); 
					pocion = false; }
			} else { System.out.println("Ni puedes hace esto");}
			break;
		case 6:
			estadisticas(inicial);
			break;
			}
		if(inicial==true) {
			inicialMenu();
		}
	//	if(pasillo==true) {
			
	//	}
		
	}
	
	public static void estadisticas(boolean inicial) {
		System.out.println("__________________");
		System.out.println("-HP"+vida+"/"+topeVida);
		if(arma == 0) {
			System.out.println("-DMG: 5");
		} else { if(arma==1) {
			System.out.println("-DMG: 15");
		} else { if(arma==2) {
			System.out.println("-DMG: 30");
		}
		}	
		}
		inventario(inicial);
	}
	
	public static void iniciarJuego() {
		llave = false;
		daga = false;
		espada = false;
		pechera = false;
		pocion = false;
		topeVida = 100;
		vida = 100;
		arma = 0;
	}
	
	public static int menuPrincipal() {
		int opcion;
		System.out.println("1 Iniciar Partida");
		System.out.println("0 Salir");
		do {
			System.out.println("Escoje una opción:");
			opcion = teclat.nextInt();
			if (opcion > 1 || opcion < 0)
				System.err.println("Opcion incorrecta");
		} while (opcion > 1 || opcion < 0);
		return opcion;
	}
}
