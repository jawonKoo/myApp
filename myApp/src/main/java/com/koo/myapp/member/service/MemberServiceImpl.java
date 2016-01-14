package com.koo.myapp.member.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.koo.myapp.member.bean.MemberBean;
import com.koo.myapp.member.dao.MemberDao;

@Service
public class MemberServiceImpl implements MemberDao {
	
	@Autowired
	private MemberDao memberDao;
	
	@Override
	public int insertMember(MemberBean memberBean) throws Exception{
		
		return memberDao.insertMember(memberBean);
	}

}
