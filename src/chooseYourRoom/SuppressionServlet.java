package chooseYourRoom;

import java.io.IOException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.PreparedQuery;
import com.google.appengine.api.datastore.Query;

@SuppressWarnings("serial")
public class SuppressionServlet extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		
		resp.setContentType("text/plain");
		
        com.google.appengine.api.datastore.DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
        Query q = new Query("CreneauEntity");
        PreparedQuery pq = datastore.prepare(q);
        for (Entity result : pq.asIterable()) { 
        	if(!result.getKey().toString().contains("@")){
        		datastore.delete(result.getKey());
        		resp.getWriter().println("-----SUPPRESSION------" + result.getKey().toString());
        	}else{
        		resp.getWriter().println("-----GARDER------" + result.getKey().toString());
        	}
        }
     
	}
}
