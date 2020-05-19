import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class attractionDaoImpl implements attractionDao {

	private SqlSessionFactory sqlSessionFactory = null;

	public attractionDaoImpl() {
		this.sqlSessionFactory = sqlSessionFactory;
	}

	public int add(attraction u) {
		SqlSession session = null;
		try {
			session = MySqlSession.getSession();
			int n = session.insert("attractionInfo.add", u);
			session.commit();
			return n;
		} finally {
			if (session != null)
				MySqlSession.closeSession();
			session.close();
		}
	}

	public int del(attraction u) {
		SqlSession session = null;
		try {
			session = MySqlSession.getSession();
			int n = session.delete("attractionInfo.del", u);
			session.commit();
			return n;
		} finally {
			if (session != null)
				MySqlSession.closeSession();
			session.close();

		}
	}

	// ID로 예약 정보 찾기
	public List<attraction> byuserIDName(String userIDName) {
		SqlSession session = null;
		try {
			session = MySqlSession.getSession();
			List<attraction> list = session.selectList("attractionInfo.byuserIDName", userIDName);
			MySqlSession.closeSession();
			return list;
		} finally {
			if (session != null)
				MySqlSession.closeSession();
			session.close();
		}
	}
}
