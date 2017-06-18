package entity;

import java.util.Calendar;
import java.util.Date;

import javax.jdo.annotations.NotPersistent;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import com.google.appengine.api.datastore.Text;


@PersistenceCapable
public class CreneauEntity {
	
		@PrimaryKey
	    private String id;
		
		@Persistent
		public static String nom; 
	 	
		@Persistent
	 	private Date dateDebut; 
	 	
	 	@Persistent
	 	private Date dateFin;

	 	@Persistent
	 	private String dateD; 
	 	
	 	@Persistent
	 	private String dateF;
	 	
	 	
	 	
	 	@Persistent
	 	private String salle; // permet de stocker des chaine plus longue que de simple string
	 	
	 	@Persistent
	 	private String creneau; 
	 	
	 	@Persistent
	 	private String email;
	 	
	 	@Persistent
	 	private String capacite; 
	 	
	 	@Persistent
	 	private String capaciteResa; 
	 	
	 	
	 	//private CreneauEntityBuilder creneauEntityBuilder;
	 	
	 	public CreneauEntity(String id, String nom, Date dateDebut, Date dateFin,/* Text description,*/ String salle, String creneau, String emai, String capaciteResa) {
	 		this.id = id;
	 		this.nom = nom;
	 		
	 		Calendar cal1 = Calendar.getInstance();
			cal1.setTime(dateDebut);  
			
			Calendar cal2 = Calendar.getInstance();
			cal2.setTime(dateFin);
			
	 		
	 		String dateD = ""+cal1.get(Calendar.YEAR)+"_"+(cal1.get(Calendar.MONTH)+1)+"_"+cal1.get(Calendar.DAY_OF_MONTH);
	 		String dateF = ""+cal2.get(Calendar.YEAR)+"_"+(cal2.get(Calendar.MONTH)+1)+"_"+cal2.get(Calendar.DAY_OF_MONTH);;
			
	 		this.dateDebut = dateDebut;
	 		this.dateFin = dateFin;
	 		
	 		this.dateD = dateD;
	 		this.dateF = dateF;
	 		//this.description = description;
	 		
	 		
	 		this.salle = salle;
	 		//this.reserve = false; 	
	 		this.creneau = creneau;
	 		
	 		this.email = emai;
	 		this.capacite = "30";
	 		this.capaciteResa = capaciteResa;
	 		
		}

	 	public CreneauEntity(){
	 	
	 	}
	 	
	 	
	 	public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		public String getNom() {
			return nom;
		}

		public void setNom(String nom) {
			this.nom = nom;
		}

		public Date getDateDebut() {
			return dateDebut;
		}

		public void setDateDebut(Date dateDebut) {
			this.dateDebut = dateDebut;
		}

		public Date getDateFin() {
			return dateFin;
		}

		public void setDateFin(Date dateFin) {
			this.dateFin = dateFin;
		}

		public String getSalle() {
			return salle;
		}

		public void setSalle(String salle) {
			this.salle = salle;
		}

		
		public String getCreneau() {
			return creneau;
		}

		public void setCreneau(String creneau) {
			this.creneau = creneau;
		}

		public String getDateD() {
			return dateD;
		}

		public void setDateD(String dateD) {
			this.dateD = dateD;
		}

		public String getDateF() {
			return dateF;
		}

		public void setDateF(String dateF) {
			this.dateF = dateF;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getCapacite() {
			return capacite;
		}

		public void setCapacite(String capacite) {
			this.capacite = capacite;
		}

		public String getCapaciteResa() {
			return capaciteResa;
		}

		public void setCapaciteResa(String capaciteResa) {
			this.capaciteResa = capaciteResa;
		}
		
		
}
