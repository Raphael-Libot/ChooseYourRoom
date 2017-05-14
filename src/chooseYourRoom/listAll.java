package chooseYourRoom;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.api.server.spi.response.CollectionResponse;

import entity.CreneauEntity;
import entity.CreneauEntityEndpoint;

@SuppressWarnings("serial")
public class listAll extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		
		resp.getWriter().println(new java.util.Date().toString());

		CreneauEntityEndpoint cee = new CreneauEntityEndpoint();
		CollectionResponse<CreneauEntity> a = null;
		a = cee.listCreneauEntity(null, 5);
		CreneauEntity ce = new CreneauEntity();
		ce = (CreneauEntity) a.getItems().toArray()[1];
		resp.getWriter().println(ce.getNom());
	}

}
