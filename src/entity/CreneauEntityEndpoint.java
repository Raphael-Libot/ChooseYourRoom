package entity;

import entity.PMF;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiMethod.HttpMethod;
import com.google.api.server.spi.config.ApiNamespace;
import com.google.api.server.spi.response.CollectionResponse;
import com.google.appengine.api.datastore.Cursor;
import com.google.appengine.api.datastore.Query.Filter;
import com.google.appengine.datanucleus.query.JDOCursorHelper;


//import com.google.appengine.api.datastore.*;

import java.util.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

import javax.annotation.Nullable;
import javax.inject.Named;
import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
//import javax.jdo.PersistenceManager;
//import javax.jdo.Query;
import javax.jdo.*;

@Api(name = "creneauentityendpoint", namespace = @ApiNamespace(ownerDomain = "mycompany.com", ownerName = "mycompany.com", packagePath = "services"))
public class CreneauEntityEndpoint {
	
	ArrayList<String> listeSalles = new ArrayList<String>() {{
		add("sa 006 PECB");
		add("sa TD 01-Vidéo");
		add("sa TD 02-Vidéo");
		add("sa TD 03-Vidéo");
		add("sa TD 04-Vidéo");
		add("sa TD 05-Vidéo");
		add("sa TD 06-Vidéo");
		add("sa TD 07-vidéo");
		add("sa TD 08-vidéo");
		add("sa TD 09-vidéo");
		add("sa TD 10-vidéo");
		add("sa TD 12-vidéo");
		add("sa TD 13-vidéo");
		add("sa TD 14-vidéo");
		add("sa TD 15-vidéo");
		add("sa TD 18");
		add("sa TD 20-Vidéo");
		add("sa TD 21-Vidéo");
		add("sa TD 22-Vidéo");
		add("sa TD 23-Vidéo");
		add("sa TD 24-Vidéo");
		add("sa TD 25-Vidéo");
		add("sa TD 26-Vidéo");
		add("sa TD 27-Vidéo");
		add("sa TD 28-Vidéo");
		add("sa TD 29-Vidéo");
		add("sa TD 30");
		add("sa TD B-Vidéo");
		add("sa TD D-vidéo");
		add("sa TD E-vidéo");
		add("sa TD-110");
		add("sa TD-117-Vidéo");
		add("sa TD-119-Vidéo");
		add("sa TP 65Geol-vidéo");
	}};


	/**
	 * This method lists all the entities inserted in datastore.
	 * It uses HTTP GET method and paging support.
	 *
	 * @return A CollectionResponse class containing the list of all entities
	 * persisted and a cursor to the next page.
	 */
	@SuppressWarnings({ "unchecked", "unused" })
	@ApiMethod(name = "listCreneauEntity")
	public CollectionResponse<CreneauEntity> listCreneauEntity(@Nullable @Named("cursor") String cursorString,
			@Nullable @Named("limit") Integer limit) {

		PersistenceManager mgr = null;
		Cursor cursor = null;
		List<CreneauEntity> execute = null;

		try {
			mgr = getPersistenceManager();
			Query query = mgr.newQuery(CreneauEntity.class);
			if (cursorString != null && cursorString != "") {
				cursor = Cursor.fromWebSafeString(cursorString);
				HashMap<String, Object> extensionMap = new HashMap<String, Object>();
				extensionMap.put(JDOCursorHelper.CURSOR_EXTENSION, cursor);
				query.setExtensions(extensionMap);
			}

			if (limit != null) {
				query.setRange(0, limit);
			}

			execute = (List<CreneauEntity>) query.execute();
			cursor = JDOCursorHelper.getCursor(execute);
			if (cursor != null)
				cursorString = cursor.toWebSafeString();

			// Tight loop for fetching all entities from datastore and accomodate
			// for lazy fetch.
			for (CreneauEntity obj : execute)
				;
		} finally {
			mgr.close();
		}

		return CollectionResponse.<CreneauEntity>builder().setItems(execute).setNextPageToken(cursorString).build();
	}

	/**
	 * This method gets the entity having primary key id. It uses HTTP GET method.
	 *
	 * @param id the primary key of the java bean.
	 * @return The entity with primary key id.
	 */
	@ApiMethod(name = "getCreneauEntity")
	public CreneauEntity getCreneauEntity(@Named("id") String id) {
		PersistenceManager mgr = getPersistenceManager();
		CreneauEntity creneauentity = null;
		try {
			creneauentity = mgr.getObjectById(CreneauEntity.class, id);
		} finally {
			mgr.close();
		}
		return creneauentity;
	}

	/**
	 * This inserts a new entity into App Engine datastore. If the entity already
	 * exists in the datastore, an exception is thrown.
	 * It uses HTTP POST method.
	 *
	 * @param creneauentity the entity to be inserted.
	 * @return The inserted entity.
	 */
	@ApiMethod(name = "insertCreneauEntity")
	public CreneauEntity insertCreneauEntity(CreneauEntity creneauentity) {
		PersistenceManager mgr = getPersistenceManager();
		try {
			if (containsCreneauEntity(creneauentity)) {
				throw new EntityExistsException("Object already exists");
			}
			mgr.makePersistent(creneauentity);
		} finally {
			mgr.close();
		}
		return creneauentity;
	}

	/**
	 * This method is used for updating an existing entity. If the entity does not
	 * exist in the datastore, an exception is thrown.
	 * It uses HTTP PUT method.
	 *
	 * @param creneauentity the entity to be updated.
	 * @return The updated entity.
	 */
	@ApiMethod(name = "updateCreneauEntity")
	public CreneauEntity updateCreneauEntity(CreneauEntity creneauentity) {
		PersistenceManager mgr = getPersistenceManager();
		try {
			if (!containsCreneauEntity(creneauentity)) {
				throw new EntityNotFoundException("Object does not exist");
			}
			mgr.makePersistent(creneauentity);
		} finally {
			mgr.close();
		}
		return creneauentity;
	}

	/**
	 * This method removes the entity with primary key id.
	 * It uses HTTP DELETE method.
	 *
	 * @param id the primary key of the entity to be deleted.
	 */
	@ApiMethod(name = "removeCreneauEntity")
	public void removeCreneauEntity(@Named("id") String id) {
		PersistenceManager mgr = getPersistenceManager();
		try {
			CreneauEntity creneauentity = mgr.getObjectById(CreneauEntity.class, id);
			mgr.deletePersistent(creneauentity);
		} finally {
			mgr.close();
		}
	}

	
	
	private boolean containsCreneauEntity(CreneauEntity creneauentity) {
		PersistenceManager mgr = getPersistenceManager();
		boolean contains = true;
		try {
			mgr.getObjectById(CreneauEntity.class, creneauentity.getId());
		} catch (javax.jdo.JDOObjectNotFoundException ex) {
			contains = false;
		} finally {
			mgr.close();
		}
		return contains;
	}

	private static PersistenceManager getPersistenceManager() {
		return PMF.get().getPersistenceManager();
	}

	@SuppressWarnings({ "unchecked", "unused" })
	@ApiMethod(name = "creneauToday")
	public CollectionResponse<CreneauEntity> creneauToday() {

		PersistenceManager mgr = null;
		Cursor cursor = null;
		List<CreneauEntity> execute = null;

		try {
			mgr = getPersistenceManager();
			java.util.Date d = new java.util.Date();
			java.util.Date dt = new java.util.Date();
			Calendar c = Calendar.getInstance(); 
			c.setTime(dt); 
			c.add(Calendar.DAY_OF_MONTH, 2);
			dt = c.getTime();
			Query query = mgr.newQuery(CreneauEntity.class);
			query.setFilter("dateDebut >= :aujourdui && dateDebut <= :apresdemain");
			execute = (List<CreneauEntity>) query.execute(d,dt);

		} finally {
			mgr.close();
		}
	
		
		return CollectionResponse.<CreneauEntity>builder().setItems(execute).build();
	}
	
	//2017-05-31T11:00:00
	//@ApiMethod(name = "listeSalleLibres")
	
	
	@ApiMethod(
	        path = "listeSalleLibres/{date}",
	        httpMethod = HttpMethod.GET
	    )
	public CollectionResponse<String> listeSalleLibres(@Named("date") String date) throws ParseException {

		PersistenceManager mgr = null;

		List<CreneauEntity> execute = null;
		ArrayList<String> tmp = new ArrayList<String>();
		ArrayList<String> res = new ArrayList<String>(this.listeSalles);
		
		DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
		java.util.Date nd = formatter.parse(date);
		
		//java.util.Date nd = date;
		Calendar c = Calendar.getInstance(); 
		c.setTime(nd); 
		c.add(Calendar.HOUR_OF_DAY, -2);
		nd = c.getTime(); 
		
		try {
			
			mgr = getPersistenceManager();
			Query query = mgr.newQuery(CreneauEntity.class);
			query.setFilter("dateDebut <= :aujourdui"); 
			execute = (List<CreneauEntity>) query.execute(nd);
			
			for(int i = 0; i < execute.size(); i++)
			{
				if(execute.get(i).getDateFin().after(nd)|| execute.get(i).getDateFin().equals(nd))
				{
					tmp.add(execute.get(i).getSalle());
				}
			}
			
			res.removeAll(tmp);
			
		} finally {
			mgr.close();
		}
	
		
		return CollectionResponse.<String>builder().setItems(res).build();
	}
	
	
	
	@ApiMethod(
	        path = "listeSalleLibrescreneau/{date}/{creneau}",
	        httpMethod = HttpMethod.GET
	    )
	public CollectionResponse<String> listeSalleLibresCreneau(@Named("date") String date, @Named("creneau") String creneau) throws ParseException {

		PersistenceManager mgr = null;

		List<CreneauEntity> execute = null;
		ArrayList<String> tmp = new ArrayList<String>();
		ArrayList<String> res = new ArrayList<String>(this.listeSalles);
		
		try {		
			mgr = getPersistenceManager();
			Query query = mgr.newQuery(CreneauEntity.class);
			query.setFilter("dateD==:date");
			execute = (List<CreneauEntity>) query.execute(date);
					
			for(int i = 0; i < execute.size(); i++)
			{
				if(execute.get(i).getCreneau().matches(creneau) )
					tmp.add(execute.get(i).getSalle());
				
			}
			
			res.removeAll(tmp);
			
		} finally {
			mgr.close();
		}
		
			return CollectionResponse.<String>builder().setItems(res).build();
	}
	
	
	@ApiMethod(
	        path = "listeSalleOccupees/{date}",
	        httpMethod = HttpMethod.GET
	    )
	public CollectionResponse<String> listeSalleOccupees(@Named("date") String date) throws ParseException {

		PersistenceManager mgr = null;

		List<CreneauEntity> execute = null;
		ArrayList<String> tmp = new ArrayList<String>();
		
		DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
		java.util.Date nd = formatter.parse(date);
		
		//java.util.Date nd = date;
		Calendar c = Calendar.getInstance(); 
		c.setTime(nd); 
		c.add(Calendar.HOUR_OF_DAY, -2);
		nd = c.getTime(); 
		
		try {
			
			mgr = getPersistenceManager();
			Query query = mgr.newQuery(CreneauEntity.class);
			query.setFilter("dateDebut <= :aujourdui"); 
			execute = (List<CreneauEntity>) query.execute(nd);
			
			for(int i = 0; i < execute.size(); i++)
			{
				if(execute.get(i).getDateFin().after(nd)|| execute.get(i).getDateFin().equals(nd))
				{
					tmp.add(execute.get(i).getSalle());
				}
			}
			
		} finally {
			mgr.close();
		}
		
		return CollectionResponse.<String>builder().setItems(tmp).build();
	}
	
	
	
	/**
	 * This inserts a new entity into App Engine datastore. If the entity already
	 * exists in the datastore, an exception is thrown.
	 * It uses HTTP POST method.
	 *
	 * @param creneauentity the entity to be inserted.
	 * @return The inserted entity.
	 * @throws ParseException 
	 */
	@ApiMethod(
	        path = "insertCreneau/{date}/{salle}/{creneau}/{email}",
	        httpMethod = HttpMethod.GET
	    )
	public CreneauEntity insertCreneau(@Named("date") String date, @Named("salle") String salle, @Named("creneau") String creneau, @Named("email") String email) throws ParseException {
		PersistenceManager mgr = getPersistenceManager();
		
		String id = ""+email+" "+date+" "+creneau+" "+salle;
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy_MM_dd");
		Date dateDebut= sdf.parse(date);

		
		Calendar cc = Calendar.getInstance();
		cc.setTime(dateDebut);
		
		
		if(creneau.equals("1")){
			cc.set(Calendar.HOUR, 8);
		}else if(creneau.equals("2")){
			cc.set(Calendar.HOUR, 9);
			cc.set(Calendar.MINUTE, 30);
		}else if(creneau.equals("3")){
			cc.set(Calendar.HOUR, 11);
		}else if(creneau.equals("4")){
			cc.set(Calendar.HOUR, 12);
			cc.set(Calendar.MINUTE, 30);
		}else if(creneau.equals("5")){
			cc.set(Calendar.HOUR, 14);
		}else if(creneau.equals("6")){
			cc.set(Calendar.HOUR, 15);
			cc.set(Calendar.MINUTE, 30);
		}else if(creneau.equals("7")){
			cc.set(Calendar.HOUR, 17);
		}else if(creneau.equals("8")){
			cc.set(Calendar.HOUR, 18);
			cc.set(Calendar.MINUTE, 30);
		}
		
		Calendar cc2 = cc;
		cc2.add(Calendar.HOUR, 1);
		cc2.add(Calendar.MINUTE, 20);
		
		CreneauEntity creneauentity = new CreneauEntity(id, "Reservation de : " +salle, cc.getTime(), cc2.getTime(), salle, creneau);
		
		try {
			if (containsCreneauEntity(creneauentity)) {
				throw new EntityExistsException("Object already exists");
			}
			mgr.makePersistent(creneauentity);
		} finally {
			mgr.close();
		}
		return creneauentity;
	}
	
	
	
}
