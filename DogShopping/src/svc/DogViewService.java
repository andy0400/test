package svc;

import java.sql.Connection;
import static db.jdbcUtil.*;
import dao.DogDAO;
import vo.Dog;

public class DogViewService {
	
	public Dog getDogView(int id) {
		Dog dog = null;
		Connection con = null;
		try {
			con = getConnection();
			DogDAO dogDAO = DogDAO.getInstance();
			dogDAO.setConnection(con);
			int updateCount = dogDAO.updateReadCount(id);
			if(updateCount > 0) {
				commit(con);
			}else {
				rollback(con);
			}
			dog = dogDAO.selectDog(id);
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			close(con);
		}
		return dog;
	}
}
