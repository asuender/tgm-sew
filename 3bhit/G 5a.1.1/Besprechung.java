package tgm.sew3.termine;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Besprechung extends Termin {
	private Benutzer[] teilnehmer = new Benutzer[0];
	private Ort ort;

	public Besprechung(LocalDateTime beginn, int dauer, String name, Benutzer besitzer, Ort ort) {
		super(beginn, dauer, name, besitzer);
		this.ort = ort;
	}

	public void addTeilnehmer(Benutzer neuerTeilnehmer) {
		teilnehmer = Arrays.copyOf(teilnehmer, teilnehmer.length + 1);
		teilnehmer[teilnehmer.length - 1] = neuerTeilnehmer;
	}
}
