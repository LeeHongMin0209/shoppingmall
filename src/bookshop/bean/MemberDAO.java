package bookshop.bean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class MemberDAO {
	private MemberDAO() {
	}

	private static MemberDAO instance = new MemberDAO();

	public static MemberDAO getInstance() {
		return instance;
	}

	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	private Connection getConnection() throws Exception {
		Context initCtx = new InitialContext();
		Context envCtx = (Context) initCtx.lookup("java:comp/env");
		DataSource ds = (DataSource) envCtx.lookup("jdbc/pool");
		return ds.getConnection();
	}

	// 회원 가입 처리에서 사용하는 메소드
	public void insertMember(MemberBean member) {
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = getConnection();

			String orgPass = member.getPasswd();

			pstmt = conn.prepareStatement("insert into member1 values (?,?,?,?,?,?)");
			pstmt.setString(1, member.getId());
			pstmt.setString(2, member.getPasswd());
			pstmt.setString(3, member.getName());
			pstmt.setString(4, member.getReg_date());
			pstmt.setString(5, member.getAddress());
			pstmt.setString(6, member.getTel());
			pstmt.executeUpdate();
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException ex) {
				}
			if (conn != null)
				try {
					conn.close();
				} catch (SQLException ex) {
				}
		}
	}

	// 로그인 폼 처리의 사용자 인증 처리에서 사용하는 메소드
	public int userCheck(String id, String passwd) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int x = -1;

		try {
			conn = getConnection();

			String orgPass = passwd;

			pstmt = conn.prepareStatement("select passwd from member1 where id = ?");
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();

			if (rs.next()) {// 해당 아이디가 있으면 수행
				String dbpasswd = rs.getString("passwd");
				x = 1;

			} else// 해당 아이디 없으면 수행
				x = -1;// 아이디 없음

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException ex) {
				}
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException ex) {
				}
			if (conn != null)
				try {
					conn.close();
				} catch (SQLException ex) {
				}
		}
		return x;
	}

	// 아이디 중복 확인에서 아이디의 중복 여부를 확인하는 메소드
	public int confirm(String id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int x = -1;

		try {
			conn = getConnection();

			pstmt = conn.prepareStatement("select id from member1 where id = ?");
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();

			if (rs.next())// 아이디 존재
				x = 1; // 같은 아이디 있음
			else
				x = -1;// 같은 아이디 없음
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException ex) {
				}
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException ex) {
				}
			if (conn != null)
				try {
					conn.close();
				} catch (SQLException ex) {
				}
		}
		return x;
	}

	// 주어진 id에 해당하는 회원정보를 얻어내는 메소드
	public MemberBean getMember(String id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		MemberBean member = null;

		try {
			conn = getConnection();

			pstmt = conn.prepareStatement("select * from member1 where id = ?");
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();

			if (rs.next()) {// 해당 아이디에 대한 레코드가 존재
				member = new MemberBean();// 데이터저장빈 객체생성
				member.setId(rs.getString("id"));
				member.setName(rs.getString("name"));
				member.setReg_date(rs.getString("reg_date"));
				member.setAddress(rs.getString("address"));
				member.setTel(rs.getString("tel"));
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException ex) {
				}
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException ex) {
				}
			if (conn != null)
				try {
					conn.close();
				} catch (SQLException ex) {
				}
		}
		return member;// 데이터 저장빈 객체 member 리턴
	}

	// 주어진 id, passwd에 해당하는 회원정보를 얻어내는 메소드
	public MemberBean getMember(String id, String passwd) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		MemberBean member = null;

		try {
			conn = getConnection();

			String orgPass = passwd;

			pstmt = conn.prepareStatement("select * from member1 where id = ?");
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();

			if (rs.next()) {// 해당 아이디에 대한 레코드가 존재
				String dbpasswd = rs.getString("passwd");
				// 사용자가 입력한 비밀번호와 테이블의 비밀번호가 같으면 수행

				member = new MemberBean();// 데이터저장빈 객체생성
				member.setId(rs.getString("id"));
				member.setName(rs.getString("name"));
				member.setReg_date(rs.getString("reg_date"));
				member.setAddress(rs.getString("address"));
				member.setTel(rs.getString("tel"));

			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException ex) {
				}
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException ex) {
				}
			if (conn != null)
				try {
					conn.close();
				} catch (SQLException ex) {
				}
		}
		return member;// 데이터 저장빈 객체 member 리턴
	}

	// 회원 정보 수정을 처리하는 메소드
	@SuppressWarnings("resource")
	public int updateMember(MemberBean member) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int x = -1;

		try {
			conn = getConnection();

			String orgPass = member.getPasswd();

			pstmt = conn.prepareStatement("select passwd from member1 where id = ?");
			pstmt.setString(1, member.getId());
			rs = pstmt.executeQuery();

			if (rs.next()) {// 해당 아이디가 있으면 수행
				String dbpasswd = rs.getString("passwd");
				pstmt = conn.prepareStatement("update member1 set name=?,address=?,tel=? where id=?");
				pstmt.setString(1, member.getName());
				pstmt.setString(2, member.getAddress());
				pstmt.setString(3, member.getTel());
				pstmt.setString(4, member.getId());
				pstmt.executeUpdate();
				x = 1;// 회원정보 수정 처리 성공

			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException ex) {
				}
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException ex) {
				}
			if (conn != null)
				try {
					conn.close();
				} catch (SQLException ex) {
				}
		}
		return x;
	}

	// 회원 정보를 삭제하는 메소드
	@SuppressWarnings("resource")
	public int deleteMember(String id, String passwd) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int x = -1;

		try {
			conn = getConnection();

			String orgPass = passwd;

			pstmt = conn.prepareStatement("select passwd from member1 where id = ?");
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				String dbpasswd = rs.getString("passwd");

				pstmt = conn.prepareStatement("delete from member1 where id=?");
				pstmt.setString(1, id);
				pstmt.executeUpdate();
				x = 1;// 회원탈퇴처리 성공

			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException ex) {
				}
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException ex) {
				}
			if (conn != null)
				try {
					conn.close();
				} catch (SQLException ex) {
				}
		}
		return x;
	}
}
