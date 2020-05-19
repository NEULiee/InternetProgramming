import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class boardDaoImpl implements boardDao {

	private SqlSessionFactory sqlSessionFactory = null;

	public boardDaoImpl() {
		this.sqlSessionFactory = sqlSessionFactory;
	}

	public int add(board b) {
		SqlSession session = null;
		try {
			session = MySqlSession.getSession();
			int n = session.insert("boardInfo.add", b);
			session.commit();
			return n;
		} finally {
			if (session != null)
				MySqlSession.closeSession();
			session.close();
		}
	}

	public int del(Integer boardID) {
		SqlSession session = null;
		try {
			session = MySqlSession.getSession();
			int n = session.delete("boardInfo.del", boardID);
			session.commit();
			return n;
		} finally {
			if (session != null) {
				MySqlSession.closeSession();
				session.close();
			}
		}
	}

	public List<board> selectAll() {
		SqlSession session = null;
		try {
			session = MySqlSession.getSession();
			List<board> list = session.selectList("boardInfo.all");
			MySqlSession.closeSession();
			return list;
		} finally {
			if (session != null)
				MySqlSession.closeSession();
			session.close();
		}
	}

	public board byboardID(Integer boardID) {
		SqlSession session = null;
		try {
			session = MySqlSession.getSession();
			board b = session.selectOne("boardInfo.byboardID", boardID);
			MySqlSession.closeSession();
			return b;
		} finally {
			if (session != null)
				MySqlSession.closeSession();
			session.close();
		}
	}

	public List<board> selectSearch(String search) {
		SqlSession session = null;
		try {
			session = MySqlSession.getSession();
			List<board> list = session.selectList("boardInfo.search", search);
			MySqlSession.closeSession();
			return list;
		} finally {
			if (session != null)
				MySqlSession.closeSession();
			session.close();
		}
	}

	public int upd(board b) {
		SqlSession session = null;
		try {
			session = MySqlSession.getSession();
			int n = session.update("boardInfo.upd", b);
			session.commit();
			return n;
		} finally {
			if (session != null)
				MySqlSession.closeSession();
			session.close();

		}
	}

}
