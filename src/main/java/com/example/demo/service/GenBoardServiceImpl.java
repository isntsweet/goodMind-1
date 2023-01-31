package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.GenBoardDao;
import com.example.demo.dao.ReplyDao;
import com.example.demo.entity.GenBoard;
import com.example.demo.entity.Reply;

@Service
public class GenBoardServiceImpl implements GenBoardService {

	@Autowired
	private GenBoardDao GenBoardDao;
	
	@Autowired
	private ReplyDao replyDao;
	
	@Override
	public List<GenBoard> getGenBoardList(int page, String field, String query) {
		int offset = (page - 1) * 10;
		query = "%"+query+"%";
		List<GenBoard> list = GenBoardDao.getGenBoardList(offset, field, query);
		return list;
	}

	@Override
	public GenBoard getGenBoard(int genBid) {
		GenBoard genBoard = GenBoardDao.getGenBoard(genBid);
		return genBoard;
	}

	@Override
	public void insertGenBoard(GenBoard genBoard) {
		GenBoardDao.insertGenBoard(genBoard);
	}

	@Override
	public void updateGenBoard(GenBoard genBoard) {
		GenBoardDao.updateGenBoard(genBoard);
	}

	@Override
	public void deleteGenBoard(int genBid) {
		GenBoardDao.deleteGenBoard(genBid);
	}

	@Override
	public int getGenBoardCount(String field, String query) {
		query = "%"+query+"%";
		int count = GenBoardDao.getGenBoardCount(field, query);
		return count;
	}

	@Override
	public void increaseViewCount(int genBid) {
		String field = "viewCount";
		GenBoardDao.increaseCount(genBid, field);
	}

	@Override
	public void increaseReplyCount(int genBid) {
		String field = "replyCount";
		GenBoardDao.increaseCount(genBid, field);
	}

	@Override
	public List<Reply> getReplyList(int genBid) {
		List<Reply> list = replyDao.getReplyList(genBid);
		return list;
	}

	@Override
	public void insertReply(Reply reply) {
		replyDao.insertReply(reply);
	}

}
