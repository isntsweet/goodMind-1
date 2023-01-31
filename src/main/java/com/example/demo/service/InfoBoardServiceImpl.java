package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.InfoBoardDao;
import com.example.demo.entity.InfoBoard;

@Service
public class InfoBoardServiceImpl implements InfoBoardService {

	@Autowired
	private InfoBoardDao InfoBoardDao;
	
	@Override
	public List<InfoBoard> getInfoBoardList(int page, String field, String query) {
		int offset = (page - 1) * 10;
		query = "%"+query+"%";
		List<InfoBoard> list = InfoBoardDao.getInfoBoardList(offset, field, query);
		return list;
	}

	@Override
	public InfoBoard getInfoBoard(int infoBid) {
		InfoBoard infoBoard = InfoBoardDao.getInfoBoard(infoBid);
		return infoBoard;
	}

	@Override
	public void insertInfoBoard(InfoBoard infoBoard) {
		InfoBoardDao.insertInfoBoard(infoBoard);
	}

	@Override
	public void updateInfoBoard(InfoBoard infoBoard) {
		InfoBoardDao.updateInfoBoard(infoBoard);
	}

	@Override
	public void deleteInfoBoard(int infoBid) {
		InfoBoardDao.deleteInfoBoard(infoBid);
	}

	@Override
	public int getInfoBoardCount(String field, String query) {
		query = "%"+query+"%";
		int count = InfoBoardDao.getInfoBoardCount(field, query);
		return count;
	}

	@Override
	public void increaseViewCount(int infoBid) {
		String field = "viewCount";
		InfoBoardDao.increaseCount(infoBid, field);
	}

}
