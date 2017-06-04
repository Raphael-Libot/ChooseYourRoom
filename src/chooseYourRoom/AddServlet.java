package chooseYourRoom;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.TimeZone;

import javax.jdo.PersistenceManager;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.datastore.Text;

import entity.CreneauEntity;
import entity.PMF;

@SuppressWarnings("serial")
public class AddServlet extends HttpServlet {
	
	private HashMap<String, String> listeSalles;
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		
		peupleListeSAlle();
		
		GetDataFromIcsToDatastore(resp,"r134919");
		GetDataFromIcsToDatastore(resp,"r16740");
		GetDataFromIcsToDatastore(resp,"r16741");
		GetDataFromIcsToDatastore(resp,"r16742");
		GetDataFromIcsToDatastore(resp,"r16743");
		GetDataFromIcsToDatastore(resp,"r16744");
		GetDataFromIcsToDatastore(resp,"r16745");
		GetDataFromIcsToDatastore(resp,"r16746");
		GetDataFromIcsToDatastore(resp,"r16747");
		GetDataFromIcsToDatastore(resp,"r16748");
		GetDataFromIcsToDatastore(resp,"r16749");
		GetDataFromIcsToDatastore(resp,"r16750");
		GetDataFromIcsToDatastore(resp,"r16751");
		GetDataFromIcsToDatastore(resp,"r16752");
		GetDataFromIcsToDatastore(resp,"r16753");
		GetDataFromIcsToDatastore(resp,"r16755");
		GetDataFromIcsToDatastore(resp,"r16756");
		GetDataFromIcsToDatastore(resp,"r16757");
		GetDataFromIcsToDatastore(resp,"r16758");
		GetDataFromIcsToDatastore(resp,"r16759");
		GetDataFromIcsToDatastore(resp,"r16760");
		GetDataFromIcsToDatastore(resp,"r16761");
		GetDataFromIcsToDatastore(resp,"r16762");
		GetDataFromIcsToDatastore(resp,"r16763");
		GetDataFromIcsToDatastore(resp,"r16764");
		GetDataFromIcsToDatastore(resp,"r16765");
		GetDataFromIcsToDatastore(resp,"r144070");
		GetDataFromIcsToDatastore(resp,"r16788");
		GetDataFromIcsToDatastore(resp,"r16789");
		GetDataFromIcsToDatastore(resp,"r16791");
		GetDataFromIcsToDatastore(resp,"r16772");
		GetDataFromIcsToDatastore(resp,"r120796");
		GetDataFromIcsToDatastore(resp,"r120797");
		GetDataFromIcsToDatastore(resp,"r20168");
	}

	private void GetDataFromIcsToDatastore(HttpServletResponse resp, String IdCalendar) throws IOException {
		String id = "";
		String nom = "";
		Date dateDebut = new Date();
		Date dateFin = new Date();
		String salle = null;
		//Text description = null;
        ArrayList<String> a = new ArrayList<String>();
		TimeZone.setDefault(TimeZone.getTimeZone("CET"));  
		resp.setContentType("text/plain");
		resp.getWriter().println("Hello, world ! :-)");
		PersistenceManager pm = PMF.get().getPersistenceManager();
		
        try{
        	String urls="https://edt.univ-nantes.fr/sciences/"+IdCalendar+".ics";
        	resp.getWriter().println(urls);
        	URL url = new URL(urls);
            URLConnection uc = url.openConnection();
            uc.setRequestProperty ("Authorization", "Basic ZTE1NzM0NGI6a1R6bkdnc3A0");
            InputStream inp = uc.getInputStream();
            BufferedReader in = new BufferedReader(new InputStreamReader(inp,"UTF-8"));
            String inputLine;
            in.readLine();in.readLine();in.readLine();in.readLine();
            while ((inputLine = in.readLine()) != null){
                a.add(inputLine);
            }
            in.close();
        
            Calendar c = Calendar.getInstance(); 
        for (String s : a) {
        	if (s.startsWith("BEGIN")) { 
        		
        	}else if (s.startsWith("DTSTART")) {
        			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd'T'HHmmssZ", Locale.FRANCE);
        			dateDebut = simpleDateFormat.parse(s.split(":")[1].replaceAll("Z$", "+0000"));
            }else if (s.startsWith("DTEND")) {
                	SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd'T'HHmmssZ",Locale.FRANCE);
					dateFin = simpleDateFormat.parse(s.split(":")[1].replaceAll("Z$", "+0000"));
            }else if(s.startsWith("UID")) {
                	id = s.replaceFirst("^[a-zA-Z0-9_]+:", "");
            }else if(s.startsWith("SUMMARY")) {
                	nom = s.replaceFirst("^[a-zA-Z0-9_]+:", "");
            }else if(s.startsWith("LOCATION")) {
                	salle = this.listeSalles.get(IdCalendar);
            }else if(s.startsWith("DESCRIPTION")) {
            }else if(s.startsWith("CATEGORIES")) {
            } else if (s.startsWith("END")) {
                	if (dateDebut.after(new Date()) || dateDebut.equals(new Date()) ){
                	CreneauEntity creneauEntity = new CreneauEntity(id,nom,dateDebut,dateFin,/*description,*/salle);
                	/*CreneauEntity creneauEntity = new CreneauEntity().Builder().id(id).nom(nom).dateDebut(dateDebut).dateFin(dateFin).description(description).salle(salle).reserve(false).build();*/
                	pm.makePersistent(creneauEntity);
                	resp.getWriter().println("-----ok------");
                	}
                }
        	}    
        //}
        pm.close();
        }catch (Exception e) {
        	resp.getWriter().println(e.toString());
		}
	}
	
	private String findSalle (String idSalle){
		
		
		
		return "";
	}
	
	private void peupleListeSAlle(){
		this.listeSalles = new HashMap<>();
		listeSalles.put("r134919", "sa 006 PECB");
		listeSalles.put("r16740", "sa TD 01-Vidéo");
		listeSalles.put("r16741", "sa TD 02-Vidéo");
		listeSalles.put("r16742", "sa TD 03-Vidéo");
		listeSalles.put("r16743", "sa TD 04-Vidéo");
		listeSalles.put("r16744", "sa TD 05-Vidéo");
		listeSalles.put("r16745", "sa TD 06-Vidéo");
		listeSalles.put("r16746", "sa TD 07-vidéo");
		listeSalles.put("r16747", "sa TD 08-vidéo");
		listeSalles.put("r16748", "sa TD 09-vidéo");
		listeSalles.put("r16749", "sa TD 10-vidéo");
		listeSalles.put("r16750", "sa TD 12-vidéo");
		listeSalles.put("r16751", "sa TD 13-vidéo");
		listeSalles.put("r16752", "sa TD 14-vidéo");
		listeSalles.put("r16753", "sa TD 15-vidéo");
		listeSalles.put("r16755", "sa TD 18");
		listeSalles.put("r16756", "sa TD 20-Vidéo");
		listeSalles.put("r16757", "sa TD 21-Vidéo");
		listeSalles.put("r16758", "sa TD 22-Vidéo");
		listeSalles.put("r16759", "sa TD 23-Vidéo");
		listeSalles.put("r16760", "sa TD 24-Vidéo");
		listeSalles.put("r16761", "sa TD 25-Vidéo");
		listeSalles.put("r16762", "sa TD 26-Vidéo");
		listeSalles.put("r16763", "sa TD 27-Vidéo");
		listeSalles.put("r16764", "sa TD 28-Vidéo");
		listeSalles.put("r16765", "sa TD 29-Vidéo");
		listeSalles.put("r144070", "sa TD 30");
		listeSalles.put("r16788", "sa TD B-Vidéo");
		listeSalles.put("r16789", "sa TD D-vidéo");
		listeSalles.put("r16791", "sa TD E-vidéo");
		listeSalles.put("r16772", "sa TD-110");
		listeSalles.put("r120796", "sa TD-117-Vidéo");
		listeSalles.put("r120797", "sa TD-119-Vidéo");
		listeSalles.put("r20168", "sa TP 65Geol-vidéo");
	}
}
