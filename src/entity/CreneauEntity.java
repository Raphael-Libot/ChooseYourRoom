package entity;

import java.util.Date;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import com.google.appengine.api.datastore.Text;


@PersistenceCapable
public class CreneauEntity {
	
		@PrimaryKey
	    private String id;
		
		@Persistent
		private String nom; 
	 	
	 	@Persistent
	 	private Date dateDebut; 
	 	
	 	@Persistent
	 	private Date dateFin;
	 	
	 	@Persistent
	 	private String salle; // permet de stocker des chaine plus longue que de simple string
	 	
	 	//@Persistent
	 	//private Text description;
	 	
	 	//@Persistent
	 	//private Boolean reserve;
	 	
	 	private CreneauEntityBuilder creneauEntityBuilder;
	 	
	 	public CreneauEntity(String id, String nom, Date dateDebut, Date dateFin,/* Text description,*/ String salle ) {
	 		this.id = id;
	 		this.nom = nom;
	 		this.dateDebut = dateDebut;
	 		this.dateFin = dateFin;
	 		//this.description = description;
	 		this.salle = salle;
	 		//this.reserve = false; 	
		}
	 
	 	public CreneauEntity(CreneauEntityBuilder builder){
	 		this.id = builder.id;
	 		this.nom = builder.nom;
	 		this.dateDebut = builder.dateDebut;
	 		this.dateFin = builder.dateFin;
	 		//this.description = builder.description;
	 		this.salle = builder.salle;
	 		//this.reserve = builder.reserve;
	 	}
	 	
	 	public CreneauEntity(){
	 	
	 	}
	 	
	 	public CreneauEntityBuilder Builder(){
	 		return this.creneauEntityBuilder;
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

		/*public Text getDescription() {
			return description;
		}

		public void setDescription(Text description) {
			this.description = description;
		}*/

		/*public Boolean getReserve() {
			return reserve;
		}

		public void setReserve(Boolean reserve) {
			this.reserve = reserve;
		}*/

		public CreneauEntityBuilder getCreneauEntityBuilder() {
			return creneauEntityBuilder;
		}

		public void setCreneauEntityBuilder(CreneauEntityBuilder creneauEntityBuilder) {
			this.creneauEntityBuilder = creneauEntityBuilder;
		}



		public static class CreneauEntityBuilder{
	 	
	 		private String id;
			private String nom; 
		 	private Date dateDebut; 
		 	private Date dateFin;
		 	private String salle;
		 	//private Text description;
		 	//private Boolean reserve;
	 		
		 	public CreneauEntityBuilder id(String id){
		 		this.id=id;
		 		return this;
		 	}
		 	
		 	public CreneauEntityBuilder nom(String nom){
		 		this.nom=nom;
		 		return this;
		 	}
		
			public CreneauEntityBuilder dateDebut(Date dateDebut) {
				this.dateDebut = dateDebut;
				return this;
			}
		
			public CreneauEntityBuilder dateFin(Date dateFin) {
				this.dateFin = dateFin;
				return this;
			}
		
			/*public CreneauEntityBuilder description(Text description) {
				this.description = description;
				return this;
			}*/
		
			public CreneauEntityBuilder salle(String salle) {
				this.salle = salle;
				return this;
			}
		
			/*public CreneauEntityBuilder reserve(Boolean reserve) {
				this.reserve = reserve;
				return this;
			}*/
			
			public CreneauEntity build() {
	            return new CreneauEntity(this);
	        }
	 	}
}
