package svc;

import vo.Dog;
import static db.jdbcUtil.*;
import java.sql.Connection;
import dao.DogDAO;
public class DogRegistService {
	
	public boolean registDog(Dog dog) {
		DogDAO dogDAO = DogDAO.getInstance();
		boolean isRegistSuccess = false;
		Connection con = null;
		try {
			con = getConnection();
			dogDAO.setConnection(con);
			int insertCount = dogDAO.insertDog(dog);
			
			if(insertCount > 0) {
				commit(con);
				isRegistSuccess=true;
			}else {
				rollback(con);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(con);
		}
		
		return isRegistSuccess;
	}
}
