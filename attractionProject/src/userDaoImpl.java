import java.sql.ResultSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class userDaoImpl implements userDao {

	private SqlSessionFactory sqlSessionFactory = null;

	public userDaoImpl() {
		this.sqlSessionFactory = sqlSessionFactory;
	}

	public List<user> all(String s) {
		SqlSession session = null;
		try {
			session = MySqlSession.getSession();
			List<user> list = session.selectList("UserInfo.all", s);
			MySqlSession.closeSession();
			return list;
		} finally {
			if (session != null)
				MySqlSession.closeSession();
			session.close();
		}
	}

	public int del(int userID) {
		SqlSession session = null;
		try {
			session = MySqlSession.getSession();
			int n = session.delete("UserInfo.del", userID);
			session.commit();
			return n;
		} finally {
			if (session != null) {
				MySqlSession.closeSession();
				session.close();
			}
		}
	}

	public user ByuserID(int userID) {
		SqlSession session = MySqlSession.getSession();
		List<user> userli = session.selectList("UserInfo.search", userID);
		MySqlSession.closeSession();
		return userli.get(0);
	}

	public int add(user u) {
		SqlSession session = null;
		try {
			session = MySqlSession.getSession();
			int n = session.insert("UserInfo.add", u);
			session.commit();
			return n;
		} finally {
			if (session != null)
				MySqlSession.closeSession();
			session.close();
		}
	}

	public int lo(user u) {
		SqlSession session = null;
		try {
			session = MySqlSession.getSession();
			List list = session.selectList("UserInfo.lo", u);
			session.commit();
			if (list.size() > 0) {
				return 1;
			} else {
				return 0;
			}
		} finally {
			if (session != null)
				MySqlSession.closeSession();
			session.close();
		}
	}
}
