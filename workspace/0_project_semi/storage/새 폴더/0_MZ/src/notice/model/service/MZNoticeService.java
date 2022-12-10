package notice.model.service;

import static common.MZTemplate.*;

import java.sql.Connection;
import java.util.ArrayList;

import notice.model.dao.MZNoticeDAO;
import notice.model.vo.MZNotice;

public class MZNoticeService {

	public ArrayList<MZNotice> selectList() {
		Connection conn = getConnection();
		
		ArrayList<MZNotice> list = new MZNoticeDAO().selectList(conn);
		
		close(conn);
		
		return list;
	}







}
