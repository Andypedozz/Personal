package model;

import java.net.URL;
import java.util.Arrays;
import java.util.List;
import model.battle.MovesEffects;

public class Pokedex {
	
	private List<Pokemon> pokedex;
	
	public Pokedex() {
		URL path = this.getClass().getResource("/icons");
		Move zuffa = new Move("Zuffa", Type.LOTTA, 5, 120, 100, "Chi la usa attacca abbassando la guardia. La propria Difesa e difesa speciale si riducono.", MoveType.FISICA, MovesEffects.DANNO_RIDUZIONE_DIFESA_E_DIFESA_SPECIALE_SE_STESSO, 1);
		Move danzaspada = new Move("Danzaspada", Type.NORMALE, 20, 0, 100, "Chi la usa aumenta le proprie statistiche di attacco", MoveType.FISICA, MovesEffects.AUMENTA_ATTACCOX2, 1);
		Move assorbipugno = new Move("Assorbipugno", Type.LOTTA, 10, 75, 100, "Pugno che assorbe energia. Fa recuperare una quantità di PS pari alla metà del danno inferto.", MoveType.FISICA, MovesEffects.DANNO_RECUPERO_HP, 1);
		Move metaltestata = new Move("Metaltestata", Type.ACCIAIO, 15, 80, 100, "Chi la usa colpisce il nemico con la sua testa dura come l'acciaio.", MoveType.FISICA, MovesEffects.DANNO, 1);
		Move nitrocarica = new Move("Nitrocarica", Type.FUOCO, 20, 50, 100, "Chi la usa si copre di fuoco e attacca il bersaglio. Concentrandosi aumenta, inoltre, la propria Velocità.", MoveType.FISICA, MovesEffects.DANNO_AUMENTA_VELOCITA, 1);
		Move agilita = new Move("Agilità", Type.PSICO, 20, 0, 100, "Chi la usa raddoppia la propria velocità", MoveType.FISICA, MovesEffects.AUMENTA_VELOCITAX2, 1);
		Move protezione = new Move("Protezione", Type.NORMALE, 10, 0, 100, "Chi la usa elude tutti gli attacchi", MoveType.FISICA, MovesEffects.ANNULLA_DANNI, 4);
		Move covauova = new Move("Covauova", Type.NORMALE, 5,0,100, "Chi la usa recupera l'80% della salute", MoveType.FISICA, MovesEffects.RECUPERO_HP, 1);
		Move pugnorapido = new Move("Pugnorapido", Type.LOTTA, 30, 40, 100, "Chi la usa tira un pugno a una velocità impressionante.", MoveType.FISICA, MovesEffects.DANNO, 2);
		Move lanciafiamme = new Move("Lanciafiamme", Type.FUOCO, 15, 90, 100, "Il bersaglio viene colpito da intense fiammate", MoveType.SPECIALE, MovesEffects.DANNO, 1);
		Move ferroscudo = new Move("Ferroscudo", Type.ACCIAIO, 15, 0, 100, "Il corpo di chi la usa si indurisce come il ferro, facendone salire di molto la Difesa", MoveType.FISICA, MovesEffects.AUMENTA_DIFESAX2, 1);
		Move aeroassalto = new Move("Aeroassalto", Type.VOLANTE, 20, 60, 100, "Chi la usa attacca il bersaglio a grande velocità", MoveType.FISICA, MovesEffects.DANNO, 1);
		Move urtoscuro = new Move("Urtoscuro", Type.BUIO, 10, 85, 100, "Chi la usa attacca il bersaglio con un’onda d’urto oscura e ne riduce la precisione.", MoveType.SPECIALE, MovesEffects.DANNO_RIDUZIONE_PRECISIONE, 1);
		Move ripicca = new Move("Ripicca", Type.BUIO, 10, 85, 100, "Chi la usa si schianta contro l'avversario con una presenza oscura", MoveType.FISICA, MovesEffects.DANNO, 1);
		Move doppioteam = new Move("Doppioteam", Type.NORMALE, 10, 0, 100, "Chi la usa aumenta la propria elusione", MoveType.FISICA, MovesEffects.AUMENTA_ELUSIONE, 1);
		Move tifone = new Move("Tifone", Type.VOLANTE, 10, 110, 70, "Chi la usa scatena un tifone che infligge grossi danni", MoveType.SPECIALE, MovesEffects.DANNO, 1);
		Move pugnoscarica = new Move("Pugnoscarica", Type.ACCIAIO, 30, 40, 100, "Chi la usa attacca con una scarica di pugni veloci come proiettili. Con questa mossa si colpisce per primi.", MoveType.FISICA, MovesEffects.DANNO, 2);
		Move dragartigli = new Move("Dragartigli", Type.DRAGO, 15, 80, 100, "Chi la usa attacca con artigli affilati che graffiano il nemico rapidamente e con grande forza.", MoveType.FISICA, MovesEffects.DANNO, 1);
		Move dragopulsar = new Move("Dragopulsar", Type.DRAGO, 10, 85, 100, "Chi la usa attacca un'onda d'urto generata spalancando la bocca.", MoveType.SPECIALE, MovesEffects.DANNO, 1);
		Move dragodanza = new Move("Dragodanza", Type.DRAGO, 20, 0, 100, "Danza mistica e vigorosa che aumenta l'Attacco e la Velocità di chi la usa.", MoveType.FISICA, MovesEffects.AUMENTA_ATTACCO_VELOCITA, 1);
		Move fulmine = new Move("Fulmine", Type.ELETTRO , 15, 90, 100, "Chi la usa colpisce l'avversario con una scarica di fulmini", MoveType.SPECIALE, MovesEffects.DANNO, 1);
		Move scintilla = new Move("Scintilla", Type.ELETTRO, 20, 65, 100, "Chi la usa colpisce il nemico con una carica elettrica", MoveType.FISICA, MovesEffects.DANNO, 1);
		Move acquagetto = new Move("Acquagetto", Type.ACQUA, 30, 40, 100, "Chi la usa si copre di acqua e si schianta verso il nemico. Si colpisce per primi", MoveType.FISICA, MovesEffects.DANNO, 1);
		Move surf = new Move("Surf", Type.ACQUA, 15, 90, 100, "Un'onda enorme sommerge il campo di lotta.", MoveType.SPECIALE, MovesEffects.DANNO, 1);
		Move fanghiglia = new Move("Fanghiglia", Type.TERRA, 10, 90, 85, "Chi la usa attacca con un getto di fango e riduce la precisione dei nemici.", MoveType.SPECIALE, MovesEffects.DANNO_RIDUZIONE_PRECISIONE, 1);
		Move calciardente = new Move("Calciardente", Type.FUOCO, 15, 90, 100, "Chi la usa colpisce il nemico con un potente calcio", MoveType.FISICA, MovesEffects.DANNO, 1);
		
		Stats lucarioStats = new Stats(177, 178, 134, 183, 134, 156);
		Stats infernapeStats = new Stats(183, 171, 135, 171, 135, 176);
		Stats zoroarkStats = new Stats(167, 172, 123, 189, 123, 172);
		Stats blisseyStats = new Stats(362, 62, 62, 95, 172, 112);
		Stats staraptorStats = new Stats(192,189,134,112,123,167);
		Stats swampertStats = new Stats(207, 178, 156, 150, 156, 123);
		Stats blazikenStats = new Stats(187, 189, 134, 178, 134, 145);
		Stats salamenceStats = new Stats(202, 205, 145, 178, 145, 167);
		Stats luxrayStats = new Stats(187, 189, 144, 161, 144, 134);
		Stats metagrossStats = new Stats(187, 205, 200, 161, 156, 134);
		
		MoveSet lucarioMoveset = new MoveSet(danzaspada, zuffa, assorbipugno, dragopulsar);
		MoveSet infernapeMoveset = new MoveSet(pugnorapido, zuffa, lanciafiamme, nitrocarica);
		MoveSet zoroarkMoveset = new MoveSet(agilita, urtoscuro, ripicca, lanciafiamme);
		MoveSet blisseyMoveset = new MoveSet(protezione, lanciafiamme, covauova, ferroscudo);
		MoveSet staraptorMoveset = new MoveSet(doppioteam, zuffa, aeroassalto, tifone);
		MoveSet metagrossMoveset = new MoveSet(agilita, pugnoscarica, metaltestata, ferroscudo);
		MoveSet salamenceMoveset = new MoveSet(dragopulsar, dragodanza, lanciafiamme, dragartigli);
		MoveSet blazikenMoveset = new MoveSet(calciardente, lanciafiamme, zuffa, agilita);
		MoveSet luxrayMoveset = new MoveSet(fulmine, scintilla, lanciafiamme, nitrocarica);
		MoveSet swampertMoveset = new MoveSet(surf, fanghiglia, acquagetto, agilita);
		
		
		Pokemon lucario = new Pokemon("Lucario", Arrays.asList(Type.LOTTA, Type.ACCIAIO) , lucarioStats, lucarioMoveset.duplicate(), path.getPath()+"\\lucario.png");
		Pokemon infernape = new Pokemon("Infernape", Arrays.asList(Type.FUOCO, Type.LOTTA), infernapeStats, infernapeMoveset.duplicate(), path.getPath()+"\\infernape.png");
		Pokemon blissey = new Pokemon("Blissey", Arrays.asList(Type.NORMALE) , blisseyStats, blisseyMoveset.duplicate(), path.getPath()+"\\blissey.png");
		Pokemon staraptor = new Pokemon("Staraptor", Arrays.asList(Type.NORMALE, Type.VOLANTE), staraptorStats, staraptorMoveset.duplicate(), path.getPath()+"\\staraptor.png");
		Pokemon zoroark = new Pokemon("Zoroark", Arrays.asList(Type.BUIO) , zoroarkStats, zoroarkMoveset.duplicate(), path.getPath()+"\\zoroark.png");
		Pokemon swampert = new Pokemon("Swampert", Arrays.asList(Type.ACQUA, Type.TERRA), swampertStats, swampertMoveset.duplicate(), path.getPath()+"\\swampert.png");
		Pokemon blaziken = new Pokemon("Blaziken", Arrays.asList(Type.FUOCO, Type.LOTTA), blazikenStats, blazikenMoveset.duplicate(), path.getPath()+"\\blaziken.png");
		Pokemon salamence = new Pokemon("Salamence", Arrays.asList(Type.DRAGO, Type.VOLANTE), salamenceStats, salamenceMoveset.duplicate(), path.getPath()+"\\salamence.png");
		Pokemon luxray = new Pokemon("Luxray", Arrays.asList(Type.ELETTRO), luxrayStats, luxrayMoveset.duplicate(), path.getPath()+"\\luxray.png");
		Pokemon metagross = new Pokemon("Metagross", Arrays.asList(Type.ACCIAIO, Type.PSICO), metagrossStats, metagrossMoveset.duplicate(), path.getPath()+"\\metagross.png");
	
		this.pokedex = List.of(lucario, infernape, blissey, staraptor, zoroark, swampert, blaziken, salamence, luxray, metagross);
		
	}

	
	public List<Pokemon> getList() {
		return this.pokedex;
	}

	
	public Pokemon getPokemon(String name) {
		for(Pokemon p : this.pokedex) {
			if(p.getName().equals(name))
				return p;
		}
		return null;
	}
}
